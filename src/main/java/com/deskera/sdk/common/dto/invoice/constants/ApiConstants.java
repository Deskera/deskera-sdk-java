package com.deskera.sdk.common.dto.invoice.constants;

/**
 * @Date: 09/12/19 Time: 14.27
 */
public class ApiConstants {

  private ApiConstants() {

  }
  public static final String URL_SEPERATOR = "/";
  public static final String AUTH_CONST = "auth";
  public static final String RECEIVE_CONST = "receive";
  public static final String IAM = "iam";
  public static final String SALES_CONST = "sales";
  public static final String VERSION_CONST = "v1";
  public static final String IAM_API =
      VERSION_CONST + URL_SEPERATOR + IAM + URL_SEPERATOR + AUTH_CONST + URL_SEPERATOR;
  public static final String VALIDATE_TOKEN = IAM_API + "sign-in/login/status";

  public static final String NATURE_ASSET = "ASSET";
  public static final String NATURE_EXPENSES = "EXPENSES";
  public static class Error {

    public static final String BOOK_BEGINNING_DATE_MISSING = "Book beginning date is not available.";
    public static final String TAX_AMOUNT_INVALID = "Tax amount is mandatory for opening invoices.";
    public static final String OPENING_INVOICE_DATE_ERROR = "Opening invoice date should be prior to book beginning date %s";
  }
}
