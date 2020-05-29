package com.deskera.sdk.common.client;

import com.deskera.sdk.common.util.constants.ApiConstants;
import lombok.Data;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Data
@Log4j2
@PropertySource(value = {"classpath:/application.properties"})
public abstract class ApiClient {

  protected String oAuth2PartnerClientId;

  protected RestTemplate restTemplate;

  protected String oAuth2PartnerSecret;

  protected boolean isSandbox;

  protected String deskeraApiHost;

  protected String oAuth2PartnerRedirectUrl;

  private static final String COLON = ":";

  @Value(value = "${contactsByCodeSandbox}")
  protected String contactsByCodeSandbox;

  @Value(value = "${contactsBaseApiSandbox}")
  protected String contactsBaseApiSandbox;

  @Value(value = "${contactsUpdateByIdSandbox}")
  protected String contactsUpdateByIdSandbox;

  @Value(value = "${contactsCreateSandbox}")
  protected String contactsCreateSandbox;

  @Value(value = "${contactsByCode}")
  protected String contactsByCode;

  @Value(value = "${contactsBaseApi}")
  protected String contactsBaseApi;

  @Value(value = "${contactsUpdateById}")
  protected String contactsUpdateById;

  @Value(value = "${contactsCreate}")
  protected String contactsCreate;

  @Value(value = "${sandBoxBaseUrl}")
  protected String sandBoxBaseUrl;

  @Value(value = "${productionBaseUrl}")
  protected String productionBaseUrl;

  @Value(value = "${invoiceBaseApiSandbox}")
  protected String invoiceBaseApiSandbox;

  @Value(value = "${invoiceBaseApi}")
  protected String invoiceBaseApi;

  @Value(value = "${accountsBaseApi}")
  protected String accountsBaseApi;

  @Value(value = "${accountsBaseApiSandbox}")
  protected String accountsBaseApiSandbox;

  @Value(value = "${productsBaseApiSandbox}")
  protected String productsBaseApiSandbox;

  @Value(value = "${productsBaseApi}")
  protected String productsBaseApi;

  @Value(value = "${taxesBaseApiSandbox}")
  protected String taxesBaseApiSandbox;

  @Value(value = "${taxesBaseApi}")
  protected String taxesBaseApi;

  @Value(value = "${paymentsBaseApiSandbox}")
  protected String paymentsBaseApiSandbox;

  @Value(value = "${paymentsBaseApi}")
  protected String paymentsBaseApi;

  @Value(value = "${tenantsBaseApiSandbox}")
  protected String tenantsBaseApiSandbox;

  @Value(value = "${tenantsBaseApi}")
  protected String tenantsBaseApi;

  @Value(value = "${ordersBaseApiSandbox}")
  protected String ordersBaseApiSandbox;

  @Value(value = "${ordersBaseApi}")
  protected String ordersBaseApi;

  @Value(value = "${inventoriesBaseApiSandbox}")
  protected String inventoriesBaseApiSandbox;

  @Value(value = "${inventoriesBaseApi}")
  protected String inventoriesBaseApi;

  @Value(value = "${fulfillmentBaseApiSandbox}")
  protected String fulfillmentBaseApiSandbox;

  @Value(value = "${fulfillmentBaseApi}")
  protected String fulfillmentBaseApi;

  protected ResponseEntity<?> createUrl(final String endpoint,
      final HttpEntity httpEntity, final Class<?> clazz, final HttpMethod httpMethod) {
    log.info("Following URL is accessed : {}", endpoint);
    return this.restTemplate
        .exchange(endpoint, httpMethod, httpEntity, clazz);
  }

  protected HttpEntity<String> createHttpEntityWithHeaders(final String accessToken) {
    final HttpHeaders headers = this.getHttpHeaders(accessToken);
    return new org.springframework.http.HttpEntity<String>(null, headers);
  }

  protected HttpEntity<String> createHttpEntity(
      final String code) {
    final org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
    headers.set(HttpHeaders.AUTHORIZATION,
        ApiConstants.BASIC_CONST + this.getBase64AuthCodeFromClientIdAndSecret());
    return new org.springframework.http.HttpEntity<String>(null, headers);
  }

  protected HttpHeaders getHttpHeaders(final String accessToken) {
    final HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
    headers.set(ApiConstants.X_ACCESS_TOKEN, accessToken);
    headers.set(HttpHeaders.AUTHORIZATION,
        ApiConstants.BASIC_CONST + this.getBase64AuthCodeFromClientIdAndSecret());
    return headers;
  }

  protected String getBase64AuthCodeFromClientIdAndSecret() {
    final String clientId = this.getOAuth2PartnerClientId();
    final String clientSecret = this.getOAuth2PartnerSecret();
    return new String(
        Base64.encodeBase64((clientId + COLON + clientSecret).getBytes()));
  }

  protected HttpEntity<MultiValueMap<String, String>> createHttpEntityWithHeaders(
      final MultiValueMap<String, String> body) {
    final org.springframework.http.HttpHeaders headers = new org.springframework.http.HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
    headers.set(HttpHeaders.AUTHORIZATION,
        ApiConstants.BASIC_CONST + this.getBase64AuthCodeFromClientIdAndSecret());
    return new org.springframework.http.HttpEntity<>(body, headers);
  }

  protected HttpEntity<?> getHttpEntity(final Object body, final String accessToken) {
    final HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);
    headers.set(HttpHeaders.ACCEPT, MediaType.APPLICATION_JSON_VALUE);
    headers.set(ApiConstants.X_ACCESS_TOKEN, accessToken);
    headers.set(HttpHeaders.AUTHORIZATION,
        ApiConstants.BASIC_CONST + this.getBase64AuthCodeFromClientIdAndSecret());
    return new org.springframework.http.HttpEntity<>(body, headers);
  }

  protected String getEndpoint(String baseEndpoint, Object... args) {
    StringBuilder sb = new StringBuilder();
    sb.append(baseEndpoint);
    for (int i = 0; i < args.length; i++) {
      if (i == 0 && !baseEndpoint.endsWith(ApiConstants.URL_SEPERATOR)) {
        sb.append(ApiConstants.URL_SEPERATOR);
      }
      sb.append(args[i]);
      if (i < args.length - 1) {
        sb.append(ApiConstants.URL_SEPERATOR);
      }
    }
    return String.format(sb.toString());
  }

  protected String getParamFormattedString(Object... params) {
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < params.length; i++) {
      if (i == 0) {
        sb.append(ApiConstants.PARAM_OPTIONS_IDENTIFIER);
        sb.append(params[i]);
        sb.append(ApiConstants.PARAM_VALUE_SET_IDENTFIER);
      } else if (i % 2 == 0 && i != 0) { // i is even, means its an option
        sb.append(ApiConstants.PARAM_NEXT_OPTION_IDENTIFIER);
        sb.append(params[i]);
        sb.append(ApiConstants.PARAM_VALUE_SET_IDENTFIER);
      } else { // i is odd, means its a value to be set to option
        sb.append(params[i]);
      }
    }
    return String.format(sb.toString());
  }
}
