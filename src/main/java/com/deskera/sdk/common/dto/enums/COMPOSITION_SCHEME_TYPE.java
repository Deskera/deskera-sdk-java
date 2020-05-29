package com.deskera.sdk.common.dto.enums;

import java.util.HashMap;
import java.util.Map;

public enum COMPOSITION_SCHEME_TYPE {
  ONE_PERCENT(1, "For Traders and Manufacturers"), TWO_PERCENT(2,
      "For Manufacturers - GSTN has lowered the rate for Manufacturers to 1%"), FIVE_PERCENT(5,
          "For Restaurant sector"), SIX_PERCENT(6, "For Suppliers of Services or Mixed Supplied");

  private int compositionPercentage;
  private String description;

  private static final Map<Integer, COMPOSITION_SCHEME_TYPE> lookup = new HashMap<>();

  static {
    for (COMPOSITION_SCHEME_TYPE cst : COMPOSITION_SCHEME_TYPE.values()) {
      lookup.put(cst.getCompositionPercentage(), cst);
    }
  }

  public int getCompositionPercentage() {
    return compositionPercentage;
  }

  public String getDescription() {
    return description;
  }

  COMPOSITION_SCHEME_TYPE(final int compositionPercentage, final String description) {
    this.compositionPercentage = compositionPercentage;
    this.description = description;
  }

  public static COMPOSITION_SCHEME_TYPE get(Integer compositionPercentage) {
    return lookup.get(compositionPercentage);
  }

}
