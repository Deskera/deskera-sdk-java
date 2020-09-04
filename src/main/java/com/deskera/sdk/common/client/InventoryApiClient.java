package com.deskera.sdk.common.client;

import com.deskera.sdk.common.dto.ENVIRONMENT;
import com.deskera.sdk.common.dto.inventory.SHIPMENT_DOCUMENT_STATUS;
import com.deskera.sdk.common.dto.inventory.ShipmentDocumentDto;
import com.deskera.sdk.common.dto.order.FulfillmentResponse;
import com.deskera.sdk.common.util.RestResponsePage;
import com.deskera.sdk.common.util.constants.Constants;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j2
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class InventoryApiClient extends ApiClient {

  private String getShipmentOrders;

  private String getFulfillmentOrders;

  private final static String INVENTORY_DOCUMENTS = "/ship-list";

  private final static String FULLFILLMENT_SEARCH = "/search";

  public InventoryApiClient(final String oAuth2PartnerClientId, final RestTemplate restTemplate,
      final String oAuth2PartnerSecret, final String oAuth2PartnerRedirectUrl,
      final ENVIRONMENT environment) {
    this.oAuth2PartnerClientId = oAuth2PartnerClientId;
    this.restTemplate = restTemplate;
    this.oAuth2PartnerSecret = oAuth2PartnerSecret;
    this.oAuth2PartnerRedirectUrl = oAuth2PartnerRedirectUrl;
    this.environment = environment;
  }

  public InventoryApiClient() {
    super();
  }

  @PostConstruct
  private void init() {
    switch (environment){
      case DEV:
        this.getShipmentOrders = this.inventoriesBaseApiDev + INVENTORY_DOCUMENTS;
        this.getFulfillmentOrders = this.fulfillmentBaseApiDev;
        break;
      case QA:
        this.getShipmentOrders = this.inventoriesBaseApiQA + INVENTORY_DOCUMENTS;
        this.getFulfillmentOrders = this.fulfillmentBaseApiQA;
        break;
      case PROD:
        this.getShipmentOrders = this.inventoriesBaseApiProd + INVENTORY_DOCUMENTS;
        this.getFulfillmentOrders = this.fulfillmentBaseApiProd;
        break;
      case STAGING:
        this.getShipmentOrders = this.inventoriesBaseApiStaging + INVENTORY_DOCUMENTS;
        this.getFulfillmentOrders = this.fulfillmentBaseApiStaging;
        break;
      case PROD_US:
        this.getShipmentOrders = this.inventoriesBaseApiProdUS + INVENTORY_DOCUMENTS;
        this.getFulfillmentOrders = this.fulfillmentBaseApiProdUS;
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + environment);
    }
  }

  public RestResponsePage<ShipmentDocumentDto> getShipmentOrder(final String accessToken,
      final String page,
      final String limit) {
    final String getQuery =
        this.getShipmentOrders + Constants.REQUEST_PARAM_QUERY + Constants.STATUS
            + Constants.EQUALS +
            SHIPMENT_DOCUMENT_STATUS.SHIPPING_IN_PROGRESS + Constants.COMMA + Constants.STATUS
            + Constants.EQUALS +
            SHIPMENT_DOCUMENT_STATUS.PARTIAL_SHIPPED + Constants.COMMA + Constants.STATUS
            + Constants.EQUALS +
            SHIPMENT_DOCUMENT_STATUS.SHIPPED + Constants.COMMA + Constants.DOCUMENT_SEQ_CODE
            + Constants.NOT_NULL;
    final String pagedQuery =
        Constants.REQUEST_PARAM_JOIN + Constants.LIMIT + Constants.EQUALS + limit
            + Constants.REQUEST_PARAM_JOIN + Constants.PAGE + Constants.EQUALS + page
            + Constants.REQUEST_PARAM_JOIN + Constants.SORT + Constants.EQUALS +
            Constants.SHIP_BY_DATE + Constants.REQUEST_PARAM_JOIN + Constants.SORT_DIR
            + Constants.EQUALS + Constants.SORT_DIR_DESC;
    final String endpoint = getQuery + pagedQuery;

    final HttpEntity<String> httpEntity = this.createHttpEntityWithHeaders(accessToken);
    final ParameterizedTypeReference<RestResponsePage<ShipmentDocumentDto>> responseType = new
        ParameterizedTypeReference<RestResponsePage<ShipmentDocumentDto>>() {
        };
    final ResponseEntity<RestResponsePage<ShipmentDocumentDto>> exchange = this.restTemplate
        .exchange(endpoint, HttpMethod.GET, httpEntity, responseType);
    return exchange.getBody();
  }

  public RestResponsePage<FulfillmentResponse> getFulfillmentData(final String accessToken,
      final String page, final String limit) {
    final String fulfillmentEndpoint =
        this.getFulfillmentOrders + Constants.REQUEST_SEPARATOR + Constants.LIMIT + Constants.EQUALS
            + limit
            + Constants.REQUEST_PARAM_JOIN + Constants.PAGE + Constants.EQUALS + page +
            Constants.REQUEST_PARAM_JOIN + Constants.SORT + Constants.EQUALS
            + Constants.FULFILLMENT_DATE + Constants.REQUEST_PARAM_JOIN + Constants.SORT_DIR
            + Constants.EQUALS + Constants.SORT_DIR_DESC + Constants.REQUEST_PARAM_JOIN
            + Constants.QUERY + Constants.EQUALS + Constants.DOCUMENT_CODE + Constants.NOT_NULL +
            Constants.COMMA + Constants.FULFILLMENT_DATE + Constants.NOT_NULL;
    final HttpEntity<String> httpEntity = this.createHttpEntityWithHeaders(accessToken);
    final ParameterizedTypeReference<RestResponsePage<FulfillmentResponse>> responseType = new
        ParameterizedTypeReference<RestResponsePage<FulfillmentResponse>>() {
        };
    final ResponseEntity<RestResponsePage<FulfillmentResponse>> exchange = this.restTemplate
        .exchange(fulfillmentEndpoint, HttpMethod.GET, httpEntity, responseType);
    return exchange.getBody();
  }
}
