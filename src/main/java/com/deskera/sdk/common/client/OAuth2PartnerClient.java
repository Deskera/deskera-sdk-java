package com.deskera.sdk.common.client;

import com.deskera.sdk.common.dto.ENVIRONMENT;
import com.deskera.sdk.common.dto.auth.AuthenticationResultTypeDto;
import com.deskera.sdk.common.dto.auth.OAuth2AccessToken;
import com.deskera.sdk.common.dto.model.AuthorizationRequestResponse;
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
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;


/**
 * @author rahulgodha
 */
@Service
@Log4j2
@Data
@EqualsAndHashCode(callSuper = true)
public class OAuth2PartnerClient extends ApiClient {

  private final static String DESKERA_CONNECT_FAILURE_MSG = "Error in Connecting to Deskera";
  private final static String TOKEN_GENERATION_FAILURE_MSG = "Could not generate Access token and Refresh token";

  public OAuth2PartnerClient() {
    super();
  }

  @PostConstruct
  void init() {

    switch (environment) {
      case DEV:
        this.deskeraApiHost = this.devBaseUrl;
        break;
      case QA:
        this.deskeraApiHost = this.qaBaseUrl;
        break;
      case PROD_US:
        this.deskeraApiHost = this.prodUSBaseUrl;
        break;
      case STAGING:
        this.deskeraApiHost = this.stagingBaseUrl;
        break;
      case PROD:
        this.deskeraApiHost = this.prodBaseUrl;
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + environment);
    }
  }

  // TODO : Fix this method
  // Explore the usage of this method, if not used remove it

  /**
   * Authenticate the partner to Deskera Platform.
   *
   * @param {@code {@link java.util.HashMap<String, String>}} Map containing Request body params
   * @return {@code AuthenticationResultType}
   */
  public ResponseEntity<AuthorizationRequestResponse> authenticate(
      final MultiValueMap<String, String> map) {
    final String endpoint = this.getEndpoint(deskeraApiHost) + this
        .getParamFormattedString("?state=1234&scope=read&clientKey=",
                oAuth2PartnerClientId, "&redirectUrl=", oAuth2PartnerRedirectUrl,
            "&response_type=code");
    final HttpEntity httpEntity = this.createHttpEntityWithHeaders(map);
    try {
      final ResponseEntity<AuthorizationRequestResponse> responseEntity = (ResponseEntity<AuthorizationRequestResponse>) this
          .createUrl(
              endpoint, httpEntity, AuthorizationRequestResponse.class, HttpMethod.GET);
      if (!HttpStatus.OK.equals(responseEntity.getStatusCode()) || Objects
          .isNull(responseEntity.getBody())) {
        throw new HttpClientErrorException(responseEntity.getStatusCode(),
            "Could not generate Refresh token");
      }
      return responseEntity;
    } catch (RestClientException restClientException) {
      throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
          restClientException.getMessage());
    }
  }

  /**
   * Write your custom logic for saving the refreshToken and accessToken in your side
   *
   * @return {@code boolean} Specifies whether the connection is successful or failure
   */
  public OAuth2AccessToken connectWithDeskera(final String authCode) {
    final String endpoint =
        this.getEndpoint(deskeraApiHost, ApiConstants.OAUTH_CONST, ApiConstants.TOKEN_CONST)
            + this.getParamFormattedString(ApiConstants.GRANT_TYPE_CONST,
            ApiConstants.AUTHORIZATION_CODE_CONST, ApiConstants.SCOPE_CONST,
            ApiConstants.READ_WRITE_CONST, ApiConstants.CODE_CONST, authCode);
    final HttpEntity httpEntity = this.createHttpEntity(authCode);
    try {
      final ResponseEntity<OAuth2AccessToken> responseEntity = (ResponseEntity<OAuth2AccessToken>) this
          .createUrl(
              endpoint, httpEntity, OAuth2AccessToken.class, HttpMethod.POST);
      if (!HttpStatus.OK.equals(responseEntity.getStatusCode()) || Objects
          .isNull(responseEntity.getBody())) {
        throw new HttpClientErrorException(responseEntity.getStatusCode(),
            DESKERA_CONNECT_FAILURE_MSG);
      }
      return responseEntity.getBody();
    } catch (RestClientException restClientException) {
      throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
          restClientException.getMessage());
    }
  }

  public OAuth2AccessToken getRefreshToken(final String oldRefreshToken, final String authCode) {
    final String endpoint =
        this.getEndpoint(deskeraApiHost, ApiConstants.OAUTH_CONST, ApiConstants.TOKEN_CONST)
            + this.getParamFormattedString(ApiConstants.GRANT_TYPE_CONST,
            ApiConstants.REFRESH_TOKEN_CONST, ApiConstants.REFRESH_TOKEN_CONST, oldRefreshToken);
    final HttpEntity httpEntity = this.createHttpEntity(authCode);
    try {
      final ResponseEntity<OAuth2AccessToken> responseEntity = (ResponseEntity<OAuth2AccessToken>) this
          .createUrl(
              endpoint, httpEntity, OAuth2AccessToken.class, HttpMethod.POST);
      if (!HttpStatus.OK.equals(responseEntity.getStatusCode()) || Objects
          .isNull(responseEntity.getBody())) {
        throw new HttpClientErrorException(responseEntity.getStatusCode(),
            TOKEN_GENERATION_FAILURE_MSG);
      }
      return responseEntity.getBody();
    } catch (RestClientException restClientException) {
      throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
          restClientException.getMessage());
    }
  }

  public Boolean validateToken(final String token) {
    final String endpoint = this.deskeraApiHost +
        com.deskera.sdk.common.dto.invoice.constants.ApiConstants.VALIDATE_TOKEN;
    final HttpEntity httpEntity = this.createHttpEntityWithHeaders(token);
    try {
      final ResponseEntity<AuthenticationResultTypeDto> responseEntity = (ResponseEntity<AuthenticationResultTypeDto>) this
          .createUrl(endpoint, httpEntity, AuthenticationResultTypeDto.class, HttpMethod.GET);
      if (!HttpStatus.OK.equals(responseEntity.getStatusCode()) || Objects
          .isNull(responseEntity.getBody())) {
        return false;
      }
    } catch (RestClientException exception) {
      return false;
    }
    return true;
  }

}
