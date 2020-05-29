package com.deskera.sdk.common.dto.enums.contact;

import com.deskera.sdk.common.dto.enums.Constants;
import java.util.HashMap;
import java.util.Map;

/**
 * CustomerTypePhilippines Philippines Customer type enums.
 */
public enum CustomerTypePhilippines {
  NORMAL_CORPORATE(Constants.CUSTOMER_NORMAL_CORPORATE_VALUE),
  NORMAL_INDIVIDUAL(Constants.CUSTOMER_NORMAL_INDIVIDUAL_VALUE),
  ZERO_RATED_CORPORATE(Constants.CUSTOMER_ZERO_RATED_CORPORATE_VALUE),
  ZERO_RATED_INDIVIDUAL(Constants.CUSTOMER_ZERO_RATED_INDIVIDUAL_VALUE);


  private static final Map<String, CustomerTypePhilippines> lookup = new HashMap<>();

  static {
    for (CustomerTypePhilippines customerTypePhilippines : values()) {
      lookup.put(customerTypePhilippines.getValue(), customerTypePhilippines);
    }
  }

  private final String value;

  CustomerTypePhilippines(final String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

  public static CustomerTypePhilippines getByValue(final String value) {
    return lookup.get(value);
  }

  public String toString() {
    return this.name() + "=" + this.value;
  }
}