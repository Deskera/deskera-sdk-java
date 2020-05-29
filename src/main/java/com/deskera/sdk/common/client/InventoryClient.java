package com.deskera.sdk.common.client;

import static com.deskera.sdk.common.util.constants.ErrorConstants.CREATE_STOCK_ADJUSTMENT_ERROR;
import static com.deskera.sdk.common.util.constants.ErrorConstants.CREATE_STOCK_TRANSFER_ERROR;
import static com.deskera.sdk.common.util.constants.ErrorConstants.EDIT_STOCK_ADJUSTMENT_ERROR;
import static com.deskera.sdk.common.util.constants.ErrorConstants.EDIT_STOCK_TRANSFER_ERROR;
import static com.deskera.sdk.common.util.constants.ErrorConstants.STOCK_ADJUSTMENT_BY_CODE_ERROR;
import static com.deskera.sdk.common.util.constants.ErrorConstants.STOCK_ADJUSTMENT_LIST_ERROR;
import static com.deskera.sdk.common.util.constants.ErrorConstants.STOCK_TRANSFER_BY_CODE_ERROR;
import static com.deskera.sdk.common.util.constants.ErrorConstants.STOCK_TRANSFER_LIST_ERROR;
import static com.deskera.sdk.common.util.constants.ErrorConstants.WAREHOUSE_DETAILS_ERROR;
import static com.deskera.sdk.common.util.constants.ErrorConstants.WAREHOUSE_LIST_ERROR;
import static com.deskera.sdk.common.util.constants.ErrorConstants.WAREHOUSE_PRODUCTS_ERROR;

import com.deskera.sdk.common.dto.FilterCriteria;
import com.deskera.sdk.common.dto.inventory.InventoryValuation;
import com.deskera.sdk.common.dto.inventory.StockAdjustmentDto;
import com.deskera.sdk.common.dto.inventory.StockAdjustmentProductValuation;
import com.deskera.sdk.common.dto.inventory.StockAdjustmentRequest;
import com.deskera.sdk.common.dto.inventory.StockTransferDto;
import com.deskera.sdk.common.dto.inventory.StockTransferRequest;
import com.deskera.sdk.common.dto.inventory.WHProductResponse;
import com.deskera.sdk.common.dto.inventory.WarehouseResponse;
import com.deskera.sdk.common.util.RestResponsePage;
import com.deskera.sdk.common.util.constants.ApiConstants;
import com.deskera.sdk.common.util.constants.Constants;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import javax.annotation.PostConstruct;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j2
@Data
@EqualsAndHashCode(callSuper = true)
public class InventoryClient extends ApiClient {

  private String warehousesApi;

  private String warehouseByCodeApi;

  private String warehouseProductsApi;

  private String stockTransferListApi;

  private String stockTransferByCodeApi;

  private String createStockTransferApi;

  private String stockAdjustmentListApi;

  private String stockAdjustmentByCodeApi;

  private String createStockAdjustmentApi;

  private String searchStockTransferApi;

  private String searchStockAdjustmentApi;

  private String getValuation;
  /**
   * Warehouse APIs
   **/

  public List<WarehouseResponse> getWarehouseList(final String accessToken) {
    final HttpEntity<String> httpEntity = this.createHttpEntityWithHeaders(accessToken);
    final ResponseEntity<List<WarehouseResponse>> responseEntity = (ResponseEntity<List<WarehouseResponse>>) this
        .createUrl(this.warehousesApi, httpEntity, List.class, HttpMethod.GET);

    this.validateResponse(HttpStatus.OK, responseEntity, WAREHOUSE_LIST_ERROR);
    return responseEntity.getBody();
  }

  public WarehouseResponse getWarehouseDetailsByCode(final String accessToken, final String code) {
    final String endpoint = String.format(this.warehouseByCodeApi, code);
    final HttpEntity<String> httpEntity = this.createHttpEntityWithHeaders(accessToken);
    final ResponseEntity<WarehouseResponse> responseEntity = (ResponseEntity<WarehouseResponse>) this
        .createUrl(endpoint, httpEntity, WarehouseResponse.class, HttpMethod.GET);

    this.validateResponse(HttpStatus.OK, responseEntity, WAREHOUSE_DETAILS_ERROR);
    return responseEntity.getBody();
  }

  public WHProductResponse getWarehouseProducts(final String accessToken,
      final Set<String> productCodes) {
    final HttpEntity<Set<String>> httpEntity = new HttpEntity<>(productCodes,
        this.getHttpHeaders(accessToken));
    final ResponseEntity<WHProductResponse> responseEntity = (ResponseEntity<WHProductResponse>) this
        .createUrl(this.warehouseProductsApi, httpEntity, WHProductResponse.class, HttpMethod.POST);

    this.validateResponse(HttpStatus.OK, responseEntity, WAREHOUSE_PRODUCTS_ERROR);
    return responseEntity.getBody();
  }

  public WHProductResponse getActiveWarehouseProducts(final String accessToken) {
    final HttpEntity<String> httpEntity = this.createHttpEntityWithHeaders(accessToken);
    final ResponseEntity<WHProductResponse> responseEntity = (ResponseEntity<WHProductResponse>) this
        .createUrl(this.warehouseProductsApi, httpEntity, WHProductResponse.class, HttpMethod.GET);

    this.validateResponse(HttpStatus.OK, responseEntity, WAREHOUSE_PRODUCTS_ERROR);
    return responseEntity.getBody();
  }

  /**
   * Stock Transfer APIs
   **/

  public List<StockTransferDto> getStockTransferList(final String accessToken) {
    final HttpEntity<String> httpEntity = this.createHttpEntityWithHeaders(accessToken);
    final ResponseEntity<List<StockTransferDto>> responseEntity = (ResponseEntity<List<StockTransferDto>>) this
        .createUrl(this.stockTransferListApi, httpEntity, List.class, HttpMethod.GET);

    this.validateResponse(HttpStatus.OK, responseEntity, STOCK_TRANSFER_LIST_ERROR);
    return responseEntity.getBody();
  }

  public RestResponsePage<StockTransferDto> searchStockTransferList(final String accessToken, final
  FilterCriteria filterCriteria) {
    String stockTransferSearch =
        this.searchStockTransferApi + Constants.REQUEST_SEPARATOR + Constants.LIMIT
            + Constants.EQUALS
            + filterCriteria.getLimit()
            + Constants.REQUEST_PARAM_JOIN + Constants.PAGE + Constants.EQUALS + filterCriteria
            .getPage();
    stockTransferSearch = this.generateSearchQuery(filterCriteria, stockTransferSearch);
    final HttpEntity<String> httpEntity = this.createHttpEntityWithHeaders(accessToken);

    final ParameterizedTypeReference<RestResponsePage<StockTransferDto>> responseType = new
        ParameterizedTypeReference<RestResponsePage<StockTransferDto>>() {
        };
    final ResponseEntity<RestResponsePage<StockTransferDto>> responseEntity = this.restTemplate
        .exchange(stockTransferSearch, HttpMethod.GET, httpEntity, responseType);

    this.validateResponse(HttpStatus.OK, responseEntity, STOCK_TRANSFER_LIST_ERROR);
    return responseEntity.getBody();
  }


  public RestResponsePage<StockAdjustmentDto> searchStockAdjustmentList(final String accessToken, final
  FilterCriteria filterCriteria) {
    String stockTransferSearch =
        this.searchStockAdjustmentApi + Constants.REQUEST_SEPARATOR + Constants.LIMIT
            + Constants.EQUALS
            + filterCriteria.getLimit()
            + Constants.REQUEST_PARAM_JOIN + Constants.PAGE + Constants.EQUALS + filterCriteria
            .getPage();
    stockTransferSearch = this.generateSearchQuery(filterCriteria, stockTransferSearch);
    final HttpEntity<String> httpEntity = this.createHttpEntityWithHeaders(accessToken);

    final ParameterizedTypeReference<RestResponsePage<StockAdjustmentDto>> responseType = new
        ParameterizedTypeReference<RestResponsePage<StockAdjustmentDto>>() {
        };
    final ResponseEntity<RestResponsePage<StockAdjustmentDto>> responseEntity = this.restTemplate
        .exchange(stockTransferSearch, HttpMethod.GET, httpEntity, responseType);

    this.validateResponse(HttpStatus.OK, responseEntity, STOCK_ADJUSTMENT_LIST_ERROR);
    return responseEntity.getBody();
  }

  private String generateSearchQuery(final FilterCriteria filterCriteria,
      String queryUrl) {

    final String sort =
        Constants.REQUEST_PARAM_JOIN + Constants.SORT + Constants.EQUALS + filterCriteria.getSort();
    final String sortDir =
        Constants.REQUEST_PARAM_JOIN + Constants.SORT_DIR + Constants.EQUALS + filterCriteria
            .getSortDir();
    final String search =
        Constants.REQUEST_PARAM_JOIN + Constants.SEARCH + Constants.EQUALS + filterCriteria
            .getFullTextSearch();
    final String query =
        Constants.REQUEST_PARAM_JOIN + Constants.QUERY + Constants.EQUALS + filterCriteria
            .getQuery();
    if (Objects.nonNull(filterCriteria.getSort())) {
      queryUrl = queryUrl + sort;
    }
    if (Objects.nonNull(filterCriteria.getSortDir())) {
      queryUrl = queryUrl + sortDir;
    }
    if (Objects.nonNull(filterCriteria.getFullTextSearch())) {
      queryUrl = queryUrl + search;
    }
    if (Objects.nonNull(filterCriteria.getQuery())) {
      queryUrl = queryUrl + query;
    }
    if (Objects.nonNull(filterCriteria.getFromDate())) {
      final String fromDate =
          Constants.REQUEST_PARAM_JOIN + Constants.FROM_DATE + Constants.EQUALS + this.extractDate(filterCriteria
              .getFromDate());
      queryUrl = queryUrl + fromDate;
    }
    if (Objects.nonNull(filterCriteria.getToDate())) {
      final String toDate =
          Constants.REQUEST_PARAM_JOIN + Constants.TO_DATE + Constants.EQUALS + this.extractDate(filterCriteria
              .getToDate());
      queryUrl = queryUrl + toDate;
    }
    return queryUrl;
  }

  private String extractDate(final Date date) {
    DateFormat simple = new SimpleDateFormat(ApiConstants.DATE_FORMAT);
    Date result = new Date(date.getTime());
    return simple.format(result);
  }

  public StockTransferDto getStockTransferByCode(final String accessToken, final String code) {
    final String endpoint = String.format(this.stockTransferByCodeApi, code);
    final HttpEntity<String> httpEntity = this.createHttpEntityWithHeaders(accessToken);
    final ResponseEntity<StockTransferDto> responseEntity = (ResponseEntity<StockTransferDto>) this
        .createUrl(endpoint, httpEntity, StockTransferDto.class, HttpMethod.GET);

    this.validateResponse(HttpStatus.OK, responseEntity,
        String.format(STOCK_TRANSFER_BY_CODE_ERROR, code));
    return responseEntity.getBody();
  }

  public StockTransferDto createStockTransfer(final String accessToken,
      final StockTransferDto stockTransferDto) {
    final HttpEntity<StockTransferDto> httpEntity = new HttpEntity<>(stockTransferDto,
        this.getHttpHeaders(accessToken));
    final ResponseEntity<StockTransferDto> responseEntity = (ResponseEntity<StockTransferDto>) this
        .createUrl(this.createStockTransferApi, httpEntity, StockTransferDto.class, HttpMethod.POST);

    this.validateResponse(HttpStatus.OK, responseEntity, CREATE_STOCK_TRANSFER_ERROR);
    return responseEntity.getBody();
  }

  public StockTransferDto editStockTransferByCode(final String accessToken,
      final StockTransferRequest request) {
    final HttpEntity<StockTransferRequest> httpEntity = new HttpEntity<>(request,
        this.getHttpHeaders(accessToken));
    final ResponseEntity<StockTransferDto> responseEntity = (ResponseEntity<StockTransferDto>) this
        .createUrl(this.createStockTransferApi, httpEntity, StockTransferDto.class,
            HttpMethod.PUT);

    this.validateResponse(HttpStatus.OK, responseEntity, EDIT_STOCK_TRANSFER_ERROR);
    return responseEntity.getBody();
  }

  /**
   * Stock Adjustment APIs
   **/

  public List<StockAdjustmentDto> getStockAdjustmentList(final String accessToken) {
    final HttpEntity<String> httpEntity = this.createHttpEntityWithHeaders(accessToken);
    final ResponseEntity<List<StockAdjustmentDto>> responseEntity = (ResponseEntity<List<StockAdjustmentDto>>) this
        .createUrl(this.stockAdjustmentListApi, httpEntity, List.class, HttpMethod.GET);

    this.validateResponse(HttpStatus.OK, responseEntity, STOCK_ADJUSTMENT_LIST_ERROR);
    return responseEntity.getBody();
  }

  public StockAdjustmentDto getStockAdjustmentByCode(final String accessToken, final String code) {
    final String endpoint = String.format(this.stockAdjustmentByCodeApi, code);
    final HttpEntity<String> httpEntity = this.createHttpEntityWithHeaders(accessToken);
    final ResponseEntity<StockAdjustmentDto> responseEntity = (ResponseEntity<StockAdjustmentDto>) this
        .createUrl(endpoint, httpEntity, StockAdjustmentDto.class, HttpMethod.GET);

    this.validateResponse(HttpStatus.OK, responseEntity,
        String.format(STOCK_ADJUSTMENT_BY_CODE_ERROR, code));
    return responseEntity.getBody();
  }

  public StockAdjustmentDto createStockAdjustment(final String accessToken,
      final StockAdjustmentDto stockAdjustmentDto) {
    final HttpEntity<StockAdjustmentDto> httpEntity = new HttpEntity<>(stockAdjustmentDto,
        this.getHttpHeaders(accessToken));
    final ResponseEntity<StockAdjustmentDto> responseEntity = (ResponseEntity<StockAdjustmentDto>) this
        .createUrl(this.createStockAdjustmentApi, httpEntity, StockAdjustmentDto.class, HttpMethod.POST);

    this.validateResponse(HttpStatus.OK, responseEntity, CREATE_STOCK_ADJUSTMENT_ERROR);
    return responseEntity.getBody();
  }

  public StockAdjustmentDto editStockAdjustmentByCode(final String accessToken,
      final StockAdjustmentRequest request) {
    final HttpEntity<StockAdjustmentRequest> httpEntity = new HttpEntity<>(request,
        this.getHttpHeaders(accessToken));
    final ResponseEntity<StockAdjustmentDto> responseEntity = (ResponseEntity<StockAdjustmentDto>) this
        .createUrl(this.createStockAdjustmentApi, httpEntity, StockAdjustmentDto.class,
            HttpMethod.PUT);

    this.validateResponse(HttpStatus.OK, responseEntity, EDIT_STOCK_ADJUSTMENT_ERROR);
    return responseEntity.getBody();
  }

  public List<StockAdjustmentProductValuation> getValuation(final String accessToken,
      final Date fromDate) {
    final HttpEntity<String> httpEntity = new HttpEntity<>(this.getHttpHeaders(accessToken));
    final String valuationEndpoint = this.getValuation + ApiConstants.PARAM_OPTIONS_IDENTIFIER +
        ApiConstants.FROM_DATE + ApiConstants.PARAM_VALUE_SET_IDENTFIER + this
        .extractDate(fromDate);
    final ResponseEntity<List<StockAdjustmentProductValuation>> responseEntity =
        (ResponseEntity<List<StockAdjustmentProductValuation>>) this
            .createUrl(valuationEndpoint, httpEntity, List.class, HttpMethod.GET);
    this.validateResponse(HttpStatus.OK, responseEntity, "Unable to get valuations");
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

  public InventoryClient(final String oAuth2PartnerClientId, final RestTemplate restTemplate,
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
    final String baseApi;

    if (isSandbox) {
      baseApi = this.inventoriesBaseApiSandbox;
    } else {
      baseApi = this.inventoriesBaseApi;
    }

    this.warehousesApi = baseApi + "/warehouses";
    this.warehouseByCodeApi = this.warehousesApi + "/%s";
    this.warehouseProductsApi = this.warehousesApi + "/warehouse-products";
//    todo : change all endpoints to separate with '-' instead of camel-case(in inventory, sdk, stock-management) services.
    this.stockTransferListApi = baseApi + "/stockTransferList";
    this.stockTransferByCodeApi = baseApi + "/stockTransfer/%s";
    this.createStockTransferApi = baseApi + "/stockTransfer";
    this.stockAdjustmentListApi = baseApi + "/stockAdjustmentList";
    this.stockAdjustmentByCodeApi = baseApi + "/stockAdjustment/%s";
    this.createStockAdjustmentApi = baseApi + "/stockAdjustment";
    this.searchStockTransferApi =  createStockTransferApi + "/search";
    this.searchStockAdjustmentApi = createStockAdjustmentApi + "/search";
    this.getValuation = baseApi + "/product" + "/valuation";
  }

}
