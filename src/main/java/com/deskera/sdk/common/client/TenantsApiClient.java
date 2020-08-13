package com.deskera.sdk.common.client;

import com.amazonaws.services.cognitoidp.model.AuthenticationResultType;
import com.deskera.sdk.common.dto.ENVIRONMENT;
import com.deskera.sdk.common.dto.tenant.WebSignInRequest;
import com.deskera.sdk.common.util.constants.ApiConstants;
import java.util.Objects;
import javax.annotation.PostConstruct;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j2
@Data
@EqualsAndHashCode(callSuper = true)
public class TenantsApiClient extends ApiClient {

  private String tenantSignInUrl;

  private final static String WEB_SIGN_IN = ApiConstants.URL_SEPERATOR
      + ApiConstants.AUTH_CONST + ApiConstants.URL_SEPERATOR + ApiConstants.WEB_SIGN_IN_CONST;

  public TenantsApiClient() {
   super();
  }

  @PostConstruct
  private void init() {
    switch (environment) {
      case DEV:
        this.tenantSignInUrl = this.tenantsBaseApiDev + WEB_SIGN_IN;
        break;
      case QA:
        this.tenantSignInUrl = this.tenantsBaseApiQA + WEB_SIGN_IN;
        break;
      case PROD_US:
        this.tenantSignInUrl = this.tenantsBaseApiProdUS + WEB_SIGN_IN;
        break;
      case STAGING:
        this.tenantSignInUrl = this.tenantsBaseApiStaging + WEB_SIGN_IN;
        break;
      case PROD:
        this.tenantSignInUrl = this.tenantsBaseApiProd + WEB_SIGN_IN;
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + environment);
    }
  }

  public AuthenticationResultType login(final WebSignInRequest webSignInRequest) {
    final HttpEntity<WebSignInRequest> httpEntity = new HttpEntity<WebSignInRequest>(
        webSignInRequest);
    try {
      final ResponseEntity<AuthenticationResultType> responseEntity = (ResponseEntity<AuthenticationResultType>) this
          .createUrl(this.tenantSignInUrl, httpEntity, AuthenticationResultType.class,
              HttpMethod.POST);
      if (!HttpStatus.OK.equals(responseEntity.getStatusCode()) || Objects
          .isNull(responseEntity.getBody())) {
        throw new HttpClientErrorException(responseEntity.getStatusCode(), "Invalid credentials");
      }
      return responseEntity.getBody();
    } catch (RestClientException restClientException) {
      throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
          restClientException.getMessage());
    }
  }
}
