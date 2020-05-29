package com.deskera.sdk.common.dto.enums.product;

import java.util.HashMap;
import java.util.Map;

public enum TAX_EXEMPTION_REASON {
  EXEMPTED("Exempted"), NON_GST("Non-GST");

  private static final Map<String, TAX_EXEMPTION_REASON> lookup = new HashMap<>();

  private final String description;

  static {
    for (final TAX_EXEMPTION_REASON taxExemptionReason : TAX_EXEMPTION_REASON.values()) {
      lookup.put(taxExemptionReason.getDescription(), taxExemptionReason);
    }
  }

  TAX_EXEMPTION_REASON(final String description) {
    this.description = description;
  }

  public String getDescription() {
    return this.description;
  }

  public static TAX_EXEMPTION_REASON get(final String description) {
    return lookup.get(description);
  }

}
