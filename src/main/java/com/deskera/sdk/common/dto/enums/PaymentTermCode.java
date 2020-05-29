package com.deskera.sdk.common.dto.enums;

public enum PaymentTermCode {

  NET_0("1", "NET 0"),
  NET_10("2", "NET 10"),
  NET_15("3", "NET 15"),
  NET_30("4", "NET 30"),
  NET_45("5", "NET 45");

  private String termId;
  private String code;

  PaymentTermCode(final String termId, final String code) {
    this.termId = termId;
    this.code = code;
  }

  public String getTermId() {
    return termId;
  }

  public String getCode() {
    return code;
  }
}
