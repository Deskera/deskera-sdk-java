package com.deskera.sdk.common.dto.enums;

public enum TransportationMode {
  ROAD("1"), RAIL("2"), AIR("3"), SHIP("4");

  private String code;


  TransportationMode(final String code) {
    this.code = code;
  }

  public String getCode() {
    return this.code;
  }
}
