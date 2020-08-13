package com.deskera.sdk.common.dto.asset.enums;

public enum DEPRECIATION_METHOD {
  NO_DEPRECIATION("No Depreciation"),
  STRAIGHT_LINE("Straight Line"),
  DECLINING_BALANCE("Declining Balance"),
  INSTANT_ASSET_WRITE_OFF("Instant Asset Write-off");

  private String type;

  DEPRECIATION_METHOD(final String type) {
    this.type = type;
  }

  public String getValue() {
    return type;
  }
}