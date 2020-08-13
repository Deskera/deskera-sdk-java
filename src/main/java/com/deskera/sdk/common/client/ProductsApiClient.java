package com.deskera.sdk.common.client;

import static com.deskera.sdk.common.util.constants.ErrorConstants.WAREHOUSE_PRODUCTS_ERROR;

import com.deskera.sdk.common.dto.ENVIRONMENT;
import com.deskera.sdk.common.dto.inventory.ProductShortInfo;
import com.deskera.sdk.common.dto.product.ProductRequest;
import com.deskera.sdk.common.dto.product.ProductResponse;
import java.util.List;
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
public class ProductsApiClient extends ApiClient {

  private String productUrl;

  private String productBriefInfoUrl;

  public ProductsApiClient() {
    super();
  }

  @PostConstruct
  private void init() {
    switch (environment) {
      case DEV:
        this.productUrl = this.productsBaseApiDev;
        break;
      case QA:
        this.productUrl = this.productsBaseApiQA;
        break;
      case PROD_US:
        this.productUrl = this.productsBaseApiProdUS;
        break;
      case STAGING:
        this.productUrl = this.productsBaseApiStaging;
        break;
      case PROD:
        this.productUrl = this.productsBaseApiProd;
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + environment);
    }

    this.productBriefInfoUrl = this.productUrl + "/brief";
  }

  public ProductResponse createProduct(final ProductRequest productRequest,
      final String accessToken) {
    final HttpEntity<ProductRequest> httpEntity = new HttpEntity<ProductRequest>(productRequest,
        this.getHttpHeaders(accessToken));
    try {
      final ResponseEntity<ProductResponse> responseEntity = (ResponseEntity<ProductResponse>) this
          .createUrl(this.productUrl, httpEntity, ProductResponse.class, HttpMethod.POST);
      if (!HttpStatus.CREATED.equals(responseEntity.getStatusCode()) || Objects
          .isNull(responseEntity.getBody())) {
        throw new HttpClientErrorException(responseEntity.getStatusCode(),
            "Could not create product");
      }
      return responseEntity.getBody();
    } catch (RestClientException restClientException) {
      throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
          restClientException.getMessage());
    }
  }

  public List<ProductShortInfo> getProductBriefInfo(final String accessToken) {
    final HttpEntity<String> httpEntity = this.createHttpEntityWithHeaders(accessToken);
    final ResponseEntity<List<ProductShortInfo>> responseEntity = (ResponseEntity<List<ProductShortInfo>>) this
        .createUrl(this.productBriefInfoUrl, httpEntity, List.class, HttpMethod.GET);

    this.validateResponse(HttpStatus.OK, responseEntity, WAREHOUSE_PRODUCTS_ERROR);
    return responseEntity.getBody();
  }

  private <T> void validateResponse(final HttpStatus httpStatus,
      final ResponseEntity<T> responseEntity, final String errorMessage)
      throws HttpClientErrorException {
    if (!httpStatus.equals(responseEntity.getStatusCode()) || Objects
        .isNull(responseEntity.getBody())) {
      throw new HttpClientErrorException(responseEntity.getStatusCode(), errorMessage);
    }
  }


}
