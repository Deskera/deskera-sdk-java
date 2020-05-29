package com.deskera.sdk.common.dto.account;

public enum CREDIT_DEBIT_TYPE {
  CREDIT,
  DEBIT;

  public static boolean isCredit(final String type) {
    return CREDIT_DEBIT_TYPE.CREDIT.name().equalsIgnoreCase(type);
  }

  public static boolean isDebit(final String type) {
    return CREDIT_DEBIT_TYPE.DEBIT.name().equalsIgnoreCase(type);
  }

  public static String getCredit() {
    return CREDIT_DEBIT_TYPE.CREDIT.name();
  }

  public static String getDebit() {
    return CREDIT_DEBIT_TYPE.DEBIT.name();
  }
}

