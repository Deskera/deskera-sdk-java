package com.deskera.sdk.common.dto.enums.product;

import com.deskera.sdk.common.util.exception.BadRequestException;
import com.fasterxml.jackson.annotation.JsonCreator;
import java.util.Arrays;
import java.util.function.Supplier;
import org.apache.commons.lang3.StringUtils;

public enum ItcAdjustment {
  ITC_IS_BLOCKED,
  ITC_IS_REVERSED;

  @JsonCreator
  public static ItcAdjustment fromValue(final String text) {
    if (StringUtils.isEmpty(text)) {
      return null;
    }

    final Supplier<? extends BadRequestException> supplier = () -> new BadRequestException(
        String.format("ITC adjustment '%s' is invalid", text));

    return Arrays.stream(ItcAdjustment.values())
        .filter(e -> StringUtils.equalsIgnoreCase(e.name(), text))
        .findFirst()
        .orElseThrow(supplier);
  }

}