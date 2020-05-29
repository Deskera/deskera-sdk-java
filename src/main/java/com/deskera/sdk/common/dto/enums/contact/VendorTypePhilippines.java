package com.deskera.sdk.common.dto.enums.contact;


import com.deskera.sdk.common.dto.enums.Constants;
import java.util.HashMap;
import java.util.Map;

/**
 * Philippines Vendor type enums.
 */
public enum VendorTypePhilippines {
  NORMAL_CORPORATE(Constants.VENDOR_NORMAL_CORPORATE_VALUE),
  NORMAL_INDIVIDUAL(Constants.VENDOR_NORMAL_INDIVIDUAL_VALUE),
  ZERO_RATED_CORPORATE(Constants.VENDOR_ZERO_RATED_CORPORATE_VALUE),
  ZERO_RATED_INDIVIDUAL(Constants.VENDOR_ZERO_RATED_INDIVIDUAL_VALUE),
  IMPORT1(Constants.IMPORT_VALUE);


  private static final Map<String, VendorTypePhilippines> lookup = new HashMap<>();

  static {
    for (VendorTypePhilippines vendorTypePhilippines : values()) {
      lookup.put(vendorTypePhilippines.getValue(), vendorTypePhilippines);
    }
  }

  private final String value;

  VendorTypePhilippines(final String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

  public static VendorTypePhilippines getByValue(final String value) {
    return lookup.get(value);
  }

  public String toString() {
    return this.name() + "=" + this.value;
  }
}