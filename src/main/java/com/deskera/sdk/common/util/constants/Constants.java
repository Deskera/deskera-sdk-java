package com.deskera.sdk.common.util.constants;


public final class Constants {



  private Constants() {}

  public static final String BASE_PACKAGE = "com.deskera.erp";
  public static final String ERROR_RESPONSE = "Error response:\\n{}";
  public static final String EXCEPTION_THROWN = "Exception is thrown: ";
  public static final String FAILED_INVALID_ARGUMENT = "Failed due to invalid arguments: ";
  public static final String FAILED_INVALID_METHOD_ARGUMENT =
      "Failed due to invalid method arguments.";
  public static final String FAILED_DATABASE_CONSTRAINT_VIOLATIONS =
      "Failed due to database constraint violations.";
  public static final String FAILED_DATABASE_INTEGRITY_VIOLATIONS =
      "Failed due to database data integrity violations.";
  public static final String FAILED_DATABASE_VIOLATIONS = "Failed due to database violations.";
  public static final String FAILED_EXCEPTION_PROCESSING_REQUEST =
      "Failed due to exception while processing the request. Error Message: %s";
  public static final String GET_USER_ROLES_API = "/roles";
  public static final String GET_USER_LIMITS_API = "/planlimits";
  public static final String ACCOUNT_REQUEST_NAME_EMPTY = "Account name can not be empty";
  public static final String ACCOUNT_GROUP_REQUEST_NAME_EMPTY =
      "Account Group name can not be empty";
  public static final String UOMTYPE_NOT_FOUND = "UOM type cannot be blank.";
  public static final String ACTIONTYPE_NOT_FOUND =
      "Please provide the correct Inventory Transaction action type.";
  public static final String OPERATION_NOT_SUPPORTED = "Operation not supported.";
  public static final String SCOPE_NOT_REQUEST = "Scope of external request should be : Request.";
  public static final String ORG_RWD = "org_setup_rwd";
  public static final String SORT_DIR = "sortDir";
  public static final String SORT_DIR_DESC = "desc";
  public static final String DEFAULT_TAX_ACCOUNT_CODE =  "ACC40010";
  public static final String documentInfoValue = "[Lcom.deskera.erp.common.dto.DocumentInfo;";
  public static final String CONTENT = "content";
  public static final String NUMBER = "number";
  public static final String TOTAL_ELEMENTS = "totalElements";
  public static final String SIZE = "size";
  public static final String PAGEABLE = "pageable";
  public static final String TOTAL_PAGES = "totalPages";
  public static final String FIRST = "first";
  public static final String LAST = "last";
  public static final String SORT = "sort";
  public static final String SHIP_BY_DATE = "shipByDate";
  public static final String FULFILLMENT_DATE = "fulfillmentDate";
  public static final String NUM_OF_ELEMENTS = "numberOfElements";
  public static final String REQUEST_SEPARATOR = "?";
  public static final String EQUALS = "=";
  public static final String REQUEST_PARAM_QUERY = REQUEST_SEPARATOR+ "query" +EQUALS;
  public static final String QUERY = "query";
  public static final String DOCUMENT_SEQ_CODE = "documentSequenceCode";
  public static final String STATUS = "status";
  public static final String COMMA = ",";
  public static final String REQUEST_PARAM_JOIN = "&";
  public static final String LIMIT = "limit";
  public static final String PAGE = "page";
  public static final String NOT_NULL = "!null";
  public static final String SEARCH = "search";
  public static final String FROM_DATE = "fromDate";
  public static final String TO_DATE = "toDate";
  public static final String EMPTY_STRING = "";

  public static class DataTypes {
    public static final String STRING = "string";
    public static final String NUMBER = "number";
    public static final String INTEGER = "integer";
    public static final String ARRAY = "array";
    public static final String BOOLEAN = "boolean";
    public static final String OBJECT = "object";
    public static final String NULL = "null";
    public static final String DATE = "date";
  }

  public static class HEADER {

    public static final String X_ACCESS_TOKEN = "x-access-token";
  }

  /*public static String getTokenForIntegrationTest() {
    try {
      return new JWTUtil().getJwtTokenForTesting();
    } catch (final Exception e) {
      return null;
    }
  }*/
}
