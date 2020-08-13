package com.deskera.sdk.common.client;

import org.springframework.beans.factory.annotation.Value;

public class EnvironmentEndpoints {
  @Value(value = "${contactsByCodeSandbox}")
  protected String contactsByCodeDev;

  @Value(value = "${contactsBaseApiSandbox}")
  protected String contactsBaseApiSandbox;

  @Value(value = "${contactsUpdateByIdSandbox}")
  protected String contactsUpdateByIdDev;

  @Value(value = "${contactsCreateSandbox}")
  protected String contactsCreateDev;

  @Value(value = "${contactsByCode}")
  protected String contactsByCodeQA;

  @Value(value = "${contactsBaseApi}")
  protected String contactsBaseApi;

  @Value(value = "${contactsUpdateById}")
  protected String contactsUpdateByIdQA;

  @Value(value = "${contactsCreate}")
  protected String contactsCreateQA;

  @Value(value = "${contactsByCodeStaging}")
  protected String contactsByCodeStaging;

  @Value(value = "${contactsBaseApiStaging}")
  protected String contactsBaseApiStaging;

  @Value(value = "${contactsUpdateByIdStaging}")
  protected String contactsUpdateByIdStaging;

  @Value(value = "${contactsCreateStaging}")
  protected String contactsCreateStaging;

  @Value(value = "${contactsByCodeProd}")
  protected String contactsByCodeProd;

  @Value(value = "${contactsBaseApiProd}")
  protected String contactsBaseApiProd;

  @Value(value = "${contactsUpdateByIdProd}")
  protected String contactsUpdateByIdProd;

  @Value(value = "${contactsCreateProd}")
  protected String contactsCreateProd;

  @Value(value = "${contactsByCodeProdUS}")
  protected String contactsByCodeProdUS;

  @Value(value = "${contactsBaseApiProdUS}")
  protected String contactsBaseApiProdUS;

  @Value(value = "${contactsUpdateByIdProdUS}")
  protected String contactsUpdateByIdProdUS;

  @Value(value = "${contactsCreateProdUS}")
  protected String contactsCreateProdUS;

  @Value(value = "${devBaseUrl}")
  protected String devBaseUrl;

  @Value(value = "${qaBaseUrl}")
  protected String qaBaseUrl;

  @Value(value = "${stagingBaseUrl}")
  protected String stagingBaseUrl;

  @Value(value = "${prodBaseUrl}")
  protected String prodBaseUrl;

  @Value(value = "${prodUSBaseUrl}")
  protected String prodUSBaseUrl;

  @Value(value = "${invoiceBaseApiSandbox}")
  protected String invoiceBaseApiDev;

  @Value(value = "${invoiceBaseApi}")
  protected String invoiceBaseApiQA;

  @Value(value = "${invoiceBaseApiStaging}")
  protected String invoiceBaseApiStaging;

  @Value(value = "${invoiceBaseApiProd}")
  protected String invoiceBaseApiProd;

  @Value(value = "${invoiceBaseApiProdUS}")
  protected String invoiceBaseApiProdUS;

  @Value(value = "${accountsBaseApi}")
  protected String accountsBaseApiQA;

  @Value(value = "${accountsBaseApiSandbox}")
  protected String accountsBaseApiDev;

  @Value(value = "${accountsBaseApiStaging}")
  protected String accountsBaseApiStaging;

  @Value(value = "${accountsBaseApiProd}")
  protected String accountsBaseApiProd;

  @Value(value = "${accountsBaseApiProdUS}")
  protected String accountsBaseApiProdUS;


  @Value(value = "${productsBaseApiSandbox}")
  protected String productsBaseApiDev;

  @Value(value = "${productsBaseApi}")
  protected String productsBaseApiQA;

  @Value(value = "${productsBaseApiStaging}")
  protected String productsBaseApiStaging;

  @Value(value = "${productsBaseApiProd}")
  protected String productsBaseApiProd;

  @Value(value = "${productsBaseApiProdUS}")
  protected String productsBaseApiProdUS;

  @Value(value = "${taxesBaseApiSandbox}")
  protected String taxesBaseApiDev;

  @Value(value = "${taxesBaseApi}")
  protected String taxesBaseApiQA;

  @Value(value = "${taxesBaseApiStaging}")
  protected String taxesBaseApiStaging;

  @Value(value = "${taxesBaseApiProd}")
  protected String taxesBaseApiProd;

  @Value(value = "${taxesBaseApiProdUS}")
  protected String taxesBaseApiProdUS;

  @Value(value = "${paymentsBaseApiSandbox}")
  protected String paymentsBaseApiDev;

  @Value(value = "${paymentsBaseApi}")
  protected String paymentsBaseApiQA;

  @Value(value = "${paymentsBaseApiStaging}")
  protected String paymentsBaseApiStaging;

  @Value(value = "${paymentsBaseApiProd}")
  protected String paymentsBaseApiProd;

  @Value(value = "${paymentsBaseApiProdUS}")
  protected String paymentsBaseApiProdUS;

  @Value(value = "${tenantsBaseApiSandbox}")
  protected String tenantsBaseApiDev;

  @Value(value = "${tenantsBaseApi}")
  protected String tenantsBaseApiQA;

  @Value(value = "${tenantsBaseApiStaging}")
  protected String tenantsBaseApiStaging;

  @Value(value = "${tenantsBaseApiProd}")
  protected String tenantsBaseApiProd;

  @Value(value = "${tenantsBaseApiProdUS}")
  protected String tenantsBaseApiProdUS;

  @Value(value = "${ordersBaseApiSandbox}")
  protected String ordersBaseApiDev;

  @Value(value = "${ordersBaseApi}")
  protected String ordersBaseApiQA;

  @Value(value = "${ordersBaseApiStaging}")
  protected String ordersBaseApiStaging;

  @Value(value = "${ordersBaseApiProd}")
  protected String ordersBaseApiProd;

  @Value(value = "${ordersBaseApiProdUS}")
  protected String ordersBaseApiProdUS;

  @Value(value = "${inventoriesBaseApiSandbox}")
  protected String inventoriesBaseApiDev;

  @Value(value = "${inventoriesBaseApi}")
  protected String inventoriesBaseApiQA;

  @Value(value = "${inventoriesStagingApi}")
  protected String inventoriesBaseApiStaging;

  @Value(value = "${inventoriesProdApi}")
  protected String inventoriesBaseApiProd;

  @Value(value = "${inventoriesProdUSApi}")
  protected String inventoriesBaseApiProdUS;

  @Value(value = "${fulfillmentBaseApiSandbox}")
  protected String fulfillmentBaseApiDev;

  @Value(value = "${fulfillmentBaseApi}")
  protected String fulfillmentBaseApiQA;


  @Value(value = "${fulfillmentBaseApiProd}")
  protected String fulfillmentBaseApiProd;

  @Value(value = "${fulfillmentBaseApiStaging}")
  protected String fulfillmentBaseApiStaging;

  @Value(value = "${fulfillmentBaseApiProdUs}")
  protected String fulfillmentBaseApiProdUS;

  @Value(value = "${assetBaseApiDevSandBox}")
  protected String assetBaseApiDev;

  @Value(value = "${assetBaseApiQA}")
  protected String assetBaseApiQA;

  @Value(value = "${assetBaseApiProd}")
  protected String assetBaseApiProd;

  @Value(value = "${assetBaseApiStaging}")
  protected String assetBaseApiStaging;

  @Value(value = "${assetBaseApiProdUS}")
  protected String assetBaseApiProdUS;

}
