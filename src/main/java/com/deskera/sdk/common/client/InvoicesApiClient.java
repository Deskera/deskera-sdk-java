package com.deskera.sdk.common.client;

import com.deskera.sdk.common.dto.invoice.SalesInvoiceRequest;
import com.deskera.sdk.common.dto.invoice.SalesInvoiceResponse;
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
public class InvoicesApiClient extends ApiClient {

  private String invoicesUrl;

  private static final String CREATE_FAILURE_MSG = "Could not create Sales Invoice";
  private static final String FIND_SALES_INVOICE_FAILURE_MSG = "Could not find Sales Invoice";

  public InvoicesApiClient(final String oAuth2PartnerClientId, final RestTemplate restTemplate,
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
      this.invoicesUrl = this.invoiceBaseApiSandbox;
    } else {
      this.invoicesUrl = this.invoiceBaseApi;
    }
  }

  public SalesInvoiceResponse createInvoice(final SalesInvoiceRequest salesInvoiceRequest,
      final String accessToken) {
    final String endpoint = this.getEndpoint(this.invoicesUrl, ApiConstants.SALES_CONST);
    final HttpEntity<SalesInvoiceRequest> httpEntity = new HttpEntity<>(salesInvoiceRequest,
        this.getHttpHeaders(accessToken));
    try {
      final ResponseEntity<SalesInvoiceResponse> responseEntity = (ResponseEntity<SalesInvoiceResponse>) this
          .createUrl(endpoint, httpEntity, SalesInvoiceResponse.class, HttpMethod.POST);
      if (!HttpStatus.CREATED.equals(responseEntity.getStatusCode()) || Objects
          .isNull(responseEntity.getBody())) {
        throw new HttpClientErrorException(responseEntity.getStatusCode(), CREATE_FAILURE_MSG
        );
      }
      return responseEntity.getBody();
    } catch (RestClientException restClientException) {
      throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
          restClientException.getMessage());
    }
  }

  public SalesInvoiceResponse getInvoiceByCode(final String documentCode,
      final String accessToken) {
    final String endpoint = this
        .getEndpoint(this.invoicesUrl, ApiConstants.SALES_CONST, documentCode);
    final HttpEntity httpEntity = new HttpEntity(this.getHttpHeaders(accessToken));
    try {
      final ResponseEntity<SalesInvoiceResponse> responseEntity = (ResponseEntity<SalesInvoiceResponse>) this
          .createUrl(endpoint, httpEntity, SalesInvoiceResponse.class, HttpMethod.GET);
      if (!HttpStatus.OK.equals(responseEntity.getStatusCode()) || Objects
          .isNull(responseEntity.getBody())) {
        throw new HttpClientErrorException(responseEntity.getStatusCode(),
            FIND_SALES_INVOICE_FAILURE_MSG
        );
      }
      return responseEntity.getBody();
    } catch (RestClientException restClientException) {
      throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
          restClientException.getMessage());
    }
  }
}
