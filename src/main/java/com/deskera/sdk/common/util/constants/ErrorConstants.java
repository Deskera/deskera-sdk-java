package com.deskera.sdk.common.util.constants;

public class ErrorConstants {

  private ErrorConstants() {}

  /**
   * InventoryClient error constants.
   */
  public static String WAREHOUSE_LIST_ERROR = "Could not fetch list of Warehouses.";
  public static String WAREHOUSE_DETAILS_ERROR = "Could not fetch Warehouse details for code.";
  public static String WAREHOUSE_PRODUCTS_ERROR = "Could not fetch Warehouse products.";
  public static String STOCK_TRANSFER_LIST_ERROR = "Could not fetch Stock Transfers.";
  public static String STOCK_TRANSFER_BY_CODE_ERROR = "Could not fetch Stock Transfer for code : {%s}.";
  public static String CREATE_STOCK_TRANSFER_ERROR = "Could not create stock transfer.";
  public static String EDIT_STOCK_TRANSFER_ERROR = "Could not edit stock transfer.";
  public static String STOCK_ADJUSTMENT_LIST_ERROR = "Could not fetch Stock Adjustments.";
  public static String STOCK_ADJUSTMENT_BY_CODE_ERROR = "Could not fetch Stock Adjustment for code : {%s}.";
  public static String CREATE_STOCK_ADJUSTMENT_ERROR = "Could not create stock adjustment.";
  public static String EDIT_STOCK_ADJUSTMENT_ERROR = "Could not edit stock adjustment.";

}
