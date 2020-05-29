package com.deskera.sdk.common.dto.enums;

import com.deskera.sdk.common.util.exception.BadRequestException;
import java.util.Arrays;
import java.util.function.Supplier;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.Assert;

public enum SupportedCustomFieldModules {
  CONTACT("Contact", "General"),
  PRODUCT("Product","General"),
  INVOICE("Invoice", "Sell"),
  QUOTATION("Quotation", "Sell"),
  ACCOUNT("Account","General"),
  JOURNAL("Journal","General"),
  ORDER("Order", "Buy");

  private String value;
  private String group;

  SupportedCustomFieldModules(String value, String group) {
    this.value = value;
    this.group = group;
  }


  public String getValue() {
    return this.value;
  }

  public String getGroup() {
    return this.group;
  }

  public static SupportedCustomFieldModules fromValue(String value) {
    Assert.isTrue(StringUtils.isNotEmpty(value), "SupportedModules cannot be blank.");
    Supplier<? extends BadRequestException> supplier = () -> new BadRequestException(
        String.format("SupportedModules '%s' is invalid", value));
    return Arrays.stream(values()).filter((p) -> p.getValue().equalsIgnoreCase(value)).findFirst()
        .orElseThrow(supplier);
  }
}
