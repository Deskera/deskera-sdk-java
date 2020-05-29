package com.deskera.sdk.common.dto.enums.contact;

import java.util.HashMap;
import java.util.Map;

public enum CustomerTypeIndia {
  EXPORT_WO_PAY("Export (WOPAY)"), EXPORT_W_PAY("Export (WPAY)"), NA("NA"), SEZ_WO_PAY(
      "SEZ (WOPAY)"), SEZ_W_PAY("SEZ (WPAY)");

  private String description;

  private static final Map<String, CustomerTypeIndia> lookup = new HashMap<>();

  static {
    for (final CustomerTypeIndia customerType : CustomerTypeIndia.values()) {
      lookup.put(customerType.getDescription(), customerType);
    }
  }

  CustomerTypeIndia(final String description) {
    this.description = description;
  }

  public static CustomerTypeIndia get(final String description) {
    return lookup.get(description);
  }

  public String getDescription() {
    return this.description;
  }
}
