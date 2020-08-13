package com.deskera.sdk.common.dto.asset.enums;

public enum DEPRECIATION_CONVENTION {
  FULL_MONTH("Full Month"),
  ACTUAL_DATE("Actual Days");

  private String type;

  DEPRECIATION_CONVENTION(final String type) {
    this.type = type;
  }

  public String getValue() {
    return type;
  }
}