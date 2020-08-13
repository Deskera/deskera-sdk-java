package com.deskera.sdk.common.client;

import com.deskera.sdk.common.dto.ENVIRONMENT;
import com.deskera.sdk.common.dto.tax.Taxes;
import com.deskera.sdk.common.util.constants.ApiConstants;
import java.util.HashMap;
import java.util.Map;
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
public class TaxesApiClient extends ApiClient {

  private String getAllTaxesUrl;

  private String updateContactByIdUrl;

  private String createContactApiUrl;

  private final static String TAX_FETCH_FAILURE_MSG = "Could not get taxes";

  public TaxesApiClient() {
  super();
  }

  @PostConstruct
  private void init() {
    switch (environment) {
      case DEV:
        this.getAllTaxesUrl = this.taxesBaseApiDev;
        break;
      case QA:
        this.getAllTaxesUrl = this.taxesBaseApiQA;
        break;
      case PROD_US:
        this.getAllTaxesUrl = this.taxesBaseApiProdUS;
        break;
      case STAGING:
        this.getAllTaxesUrl = this.taxesBaseApiStaging;
        break;
      case PROD:
        this.getAllTaxesUrl = this.taxesBaseApiProd;
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + environment);
    }
  }

  public Taxes getTaxes(final String accessToken, final Integer limit, final Integer page) {

    final int newLimit;
    if (Objects.isNull(limit)) {
      newLimit = ApiConstants.DEFAULT_LIMIT_SIZE;
    } else {
      newLimit = limit;
    }

    final int newPageSize;

    if (Objects.isNull(page)) {
      newPageSize = ApiConstants.DEFAULT_PAGE_SIZE;
    } else {
      newPageSize = page;
    }

    Map<String, Integer> params = new HashMap<String, Integer>();
    params.put(ApiConstants.LIMIT, limit);
    params.put(ApiConstants.PAGE, page);
    final String endpoint =
        this.getEndpoint(this.getAllTaxesUrl) + this
            .getParamFormattedString(limit, newLimit, page,
                newPageSize);
    final HttpEntity httpEntity = new HttpEntity<>(this.getHttpHeaders(accessToken));
    try {
      final ResponseEntity<Taxes> responseEntity = this.restTemplate
          .exchange(endpoint, HttpMethod.GET, httpEntity, Taxes.class);
      if (!HttpStatus.OK.equals(responseEntity.getStatusCode()) || Objects
          .isNull(responseEntity.getBody())) {
        throw new HttpClientErrorException(responseEntity.getStatusCode(),
            TAX_FETCH_FAILURE_MSG);
      }
      return responseEntity.getBody();
    } catch (RestClientException restClientException) {
      throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
          restClientException.getMessage());
    }
  }
}
