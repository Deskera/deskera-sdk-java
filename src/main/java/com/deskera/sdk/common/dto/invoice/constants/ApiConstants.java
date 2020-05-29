package com.deskera.sdk.common.dto.invoice.constants;

/**
 * @Date: 09/12/19 Time: 14.27
 */
public class ApiConstants {

  private ApiConstants() {

  }
  public static final String NATURE_ASSET = "ASSET";
  public static final String NATURE_EXPENSES = "EXPENSES";
  public static class Error {

    public static final String BOOK_BEGINNING_DATE_MISSING = "Book beginning date is not available.";
    public static final String TAX_AMOUNT_INVALID = "Tax amount is mandatory for opening invoices.";
    public static final String OPENING_INVOICE_DATE_ERROR = "Opening invoice date should be prior to book beginning date %s";
  }
}
