package com.deskera.sdk.common.dto.enums.contact;

import java.util.HashMap;
import java.util.Map;

public enum VendorTypeIndia {
  IMPORT("Import"), NA("NA"), SEZ_W_PAY("SEZ (WPAY)"),SEZ_WO_PAY(
      "SEZ (WOPAY)");

  private String description;

  private static final Map<String, VendorTypeIndia> lookup = new HashMap<>();

  static {
    for (final VendorTypeIndia vendorType : VendorTypeIndia.values()) {
      lookup.put(vendorType.getDescription(), vendorType);
    }
  }

  public String getDescription() {
    return this.description;
  }

  VendorTypeIndia(final String description) {
    this.description = description;
  }

  public static VendorTypeIndia get(final String description) {
    return lookup.get(description);
  }
}
