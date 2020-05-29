package com.deskera.sdk.common.dto.enums;

import com.deskera.sdk.common.util.exception.BadRequestException;
import java.util.Arrays;
import java.util.function.Supplier;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

public enum ProductType {
  TRACKED, NONTRACKED, BILL_OF_MATERIALS;

  public String getValue() {
    return this.toString();
  }

  public static ProductType fromValue(final String type) {
    Assert.isTrue(StringUtils.isNotEmpty(type), "Product type cannot be blank.");

    final Supplier<? extends BadRequestException> supplier = () -> new BadRequestException(
        String.format("Product type '%s' is invalid", type));

    return Arrays.stream(ProductType.values())
        .filter(p -> p.getValue().equalsIgnoreCase(type)).findFirst()
        .orElseThrow(supplier);
  }

  public static String getDisplayValue(final String type) {
    final ProductType productType = fromValue(type);
    return (TRACKED == productType ? "Tracked" : "Non-tracked");
  }
}
