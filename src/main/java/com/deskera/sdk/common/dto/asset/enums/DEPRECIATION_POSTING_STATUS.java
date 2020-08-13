package com.deskera.sdk.common.dto.asset.enums;

public enum DEPRECIATION_POSTING_STATUS {
  POSTED("Posted"),
  PENDING("To be posted");

  private String type;

  DEPRECIATION_POSTING_STATUS(final String type) {
    this.type = type;
  }

  public String getValue() {
    return type;
  }
}
