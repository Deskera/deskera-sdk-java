package com.deskera.sdk.common.client;

import com.deskera.sdk.common.dto.ENVIRONMENT;
import com.deskera.sdk.common.dto.payment.ReceivePaymentDto;
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
public class PaymentsApiClient extends ApiClient {

  private String receivePaymentUrl;

  private final static String RECEIVE = ApiConstants.URL_SEPERATOR + ApiConstants.RECEIVE_CONST;

  public PaymentsApiClient() {
    super();
  }

  @PostConstruct
  private void init() {
    switch (environment) {
      case DEV:
        this.receivePaymentUrl = this.paymentsBaseApiDev + this.RECEIVE;
        break;
      case QA:
        this.receivePaymentUrl = this.paymentsBaseApiQA + this.RECEIVE;
        break;
      case PROD_US:
        this.receivePaymentUrl = this.paymentsBaseApiProdUS + this.RECEIVE;
        break;
      case STAGING:
        this.receivePaymentUrl = this.paymentsBaseApiStaging + this.RECEIVE;
        break;
      case PROD:
        this.receivePaymentUrl = this.paymentsBaseApiProd + this.RECEIVE;
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + environment);
    }
  }

  public ReceivePaymentDto receivePayment(final ReceivePaymentDto receivePaymentDto,
      final String accessToken) {
    final HttpEntity<ReceivePaymentDto> httpEntity = new HttpEntity<ReceivePaymentDto>(
        receivePaymentDto,
        this.getHttpHeaders(accessToken));
    try {
      final ResponseEntity<ReceivePaymentDto> responseEntity = (ResponseEntity<ReceivePaymentDto>) this
          .createUrl(this.receivePaymentUrl, httpEntity, ReceivePaymentDto.class, HttpMethod.POST);
      if (!HttpStatus.CREATED.equals(responseEntity.getStatusCode()) || Objects
          .isNull(responseEntity.getBody())) {
        throw new HttpClientErrorException(responseEntity.getStatusCode(),
            "Could not receive payment");
      }
      return responseEntity.getBody();
    } catch (RestClientException restClientException) {
      throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
          restClientException.getMessage());
    }
  }


}
