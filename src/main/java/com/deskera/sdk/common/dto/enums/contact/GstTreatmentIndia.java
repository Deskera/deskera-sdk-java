package com.deskera.sdk.common.dto.enums.contact;

import com.deskera.sdk.common.dto.enums.Constants;
import java.util.HashMap;
import java.util.Map;

/**
 * India GST Treatment type enums.
 *
 */
public enum GstTreatmentIndia {
  REGISTERED_BUSINESS_REGULAR(Constants.REGISTERED_BUSINESS_REGULAR_VALUE),
  REGISTERED_BUSINESS_COMPOSITION(Constants.REGISTERED_BUSINESS_COMPOSITION_VALUE),
  UNREGISTERED_BUSINESS(Constants.UNREGISTERED_BUSINESS_VALUE),
  CUSTOMER(Constants.CUSTOMER_VALUE),
  OVERSEAS(Constants.OVERSEAS_VALUE),
  SPECIAL_ECONOMIC_ZONE(Constants.SPECIAL_ECONOMIC_ZONE_VALUE),
  DEEMED_EXPORT(Constants.DEEMED_EXPORT_VALUE);

  private static final Map<String, GstTreatmentIndia> lookup = new HashMap<>();
  static {
    for (GstTreatmentIndia gstTreatmentIndia : values()) {
      lookup.put(gstTreatmentIndia.getValue(), gstTreatmentIndia);
    }
  }

  private final String value;

  GstTreatmentIndia(final String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

  public static GstTreatmentIndia getByValue(final String value) {
    return lookup.get(value);
  }

  public String toString() {
    return this.name() + "=" + this.value;
  }
}