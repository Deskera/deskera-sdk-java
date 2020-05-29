package com.deskera.sdk.common.client;

import com.amazonaws.services.cognitoidp.model.AuthenticationResultType;
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

  public TenantsApiClient(final String oAuth2PartnerClientId, final RestTemplate restTemplate,
      final String oAuth2PartnerSecret, final String oAuth2PartnerRedirectUrl,
      final boolean isSandbox) {
    this.oAuth2PartnerClientId = oAuth2PartnerClientId;
    this.restTemplate = restTemplate;
    this.oAuth2PartnerSecret = oAuth2PartnerSecret;
    this.oAuth2PartnerRedirectUrl = oAuth2PartnerRedirectUrl;
    this.isSandbox = isSandbox;
  }

  @PostConstruct
  private void init() {
    if (this.isSandbox) {
      this.tenantSignInUrl = this.tenantsBaseApiSandbox + WEB_SIGN_IN;
    } else {
      this.tenantSignInUrl = this.tenantsBaseApi + WEB_SIGN_IN;
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
