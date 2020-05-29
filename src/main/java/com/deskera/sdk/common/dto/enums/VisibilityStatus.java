package com.deskera.sdk.common.dto.enums;

import com.deskera.sdk.common.util.exception.BadRequestException;
import java.util.Arrays;
import java.util.function.Supplier;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

public enum VisibilityStatus {
  ACTIVE("Active"),
  INACTIVE("Inactive");
  private String value;

  VisibilityStatus(String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

  public static VisibilityStatus fromValue(String value) {
    Assert.isTrue(StringUtils.isNotEmpty(value), "ActivityStatus cannot be blank.");
    Supplier<? extends BadRequestException> supplier = () -> new BadRequestException(
        String.format("ActivityStatus '%s' is invalid", value));
    return Arrays.stream(values()).filter((p) -> p.getValue().equalsIgnoreCase(value)).findFirst()
        .orElseThrow(supplier);
  }
}
