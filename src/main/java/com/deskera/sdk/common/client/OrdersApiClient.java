package com.deskera.sdk.common.client;

import com.deskera.sdk.common.dto.order.FulfillmentRequest;
import com.deskera.sdk.common.dto.order.FulfillmentResponse;
import com.deskera.sdk.common.util.constants.ApiConstants;
import java.util.Objects;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
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
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class OrdersApiClient extends ApiClient {

  private String createFulfillmentUri;

  private final static String FULFILLMENT =
      ApiConstants.URL_SEPERATOR + ApiConstants.VERSION_CONST + ApiConstants.URL_SEPERATOR
          + ApiConstants.SALES_CONST + ApiConstants.URL_SEPERATOR + ApiConstants.FULFILLMENTS_CONST;

  public OrdersApiClient(final String oAuth2PartnerClientId, final RestTemplate restTemplate,
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
    if (isSandbox) {
      this.createFulfillmentUri = this.ordersBaseApiSandbox + FULFILLMENT;
    } else {
      this.createFulfillmentUri = this.ordersBaseApi + FULFILLMENT;
    }
  }

  public FulfillmentResponse createFulfillment(final FulfillmentRequest fulfillmentRequest,
      final String accessToken) {
    final HttpEntity<FulfillmentRequest> httpEntity = new HttpEntity<FulfillmentRequest>(
        fulfillmentRequest,
        this.getHttpHeaders(accessToken));
    try {
      final ResponseEntity<FulfillmentResponse> responseEntity = (ResponseEntity<FulfillmentResponse>) this
          .createUrl(this.createFulfillmentUri, httpEntity, FulfillmentResponse.class,
              HttpMethod.POST);
      if (!HttpStatus.OK.equals(responseEntity.getStatusCode()) || Objects
          .isNull(responseEntity.getBody())) {
        throw new HttpClientErrorException(responseEntity.getStatusCode(),
            "Could not create fulfillment request");
      }
      return responseEntity.getBody();
    } catch (RestClientException restClientException) {
      throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
          restClientException.getMessage());
    }
  }

}
