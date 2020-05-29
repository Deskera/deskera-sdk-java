package com.deskera.sdk.common.dto.enums;

import com.deskera.sdk.common.util.exception.BadRequestException;
import java.util.Arrays;
import java.util.function.Supplier;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

public enum SupportedCustomFieldTypes {
  NUMBER("Number"),
  TEXT("Text"),
  DATE("Date"),
  DROPDOWN("Dropdown"),
  MULTI_SELECT("Multi-Select");

  private String type;

  SupportedCustomFieldTypes(String type) {
    this.type = type;
  }

  public String getValue() {
    return this.type;
  }

  public static SupportedCustomFieldTypes fromValue(String type) {
    Assert.isTrue(StringUtils.isNotEmpty(type), "SupportedCustomFieldType cannot be blank.");
    Supplier<? extends BadRequestException> supplier = () -> new BadRequestException(
        String.format("SupportedCustomFieldType '%s' is invalid", type));
    return Arrays.stream(values()).filter((p) -> p.getValue().equalsIgnoreCase(type)).findFirst()
        .orElseThrow(supplier);
  }

}
