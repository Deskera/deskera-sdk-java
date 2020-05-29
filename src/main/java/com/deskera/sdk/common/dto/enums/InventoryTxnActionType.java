package com.deskera.sdk.common.dto.enums;

import com.deskera.sdk.common.util.exception.BadRequestException;
import java.util.Arrays;
import java.util.function.Supplier;

public enum InventoryTxnActionType {
  ADD,
  REMOVE,
  CHANGE;

  public String getValue() {
    return this.toString();
  }

  public static InventoryTxnActionType fromValue(final String type) {
  //  Assert.isTrue(StringUtils.isNotEmpty(type), Constants.ACTIONTYPE_NOT_FOUND);

    final Supplier<? extends BadRequestException> supplier =
        () -> new BadRequestException(String.format("Action type '%s' is invalid", type));

    return Arrays.stream(InventoryTxnActionType.values())
        .filter(p -> p.getValue().equalsIgnoreCase(type))
        .findFirst()
        .orElseThrow(supplier);
  }
}
