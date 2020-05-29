package com.deskera.sdk.common.dto.inventory;

import com.deskera.sdk.common.util.exception.ApplicationException;
import java.math.BigDecimal;

public enum ADJUSTMENT_TYPE {
  STOCK_IN, STOCK_OUT;

  public BigDecimal getQuantityAccordingToAdjustmentType(final BigDecimal quantity) {
    switch (this) {
      case STOCK_IN:
        return quantity;
      case STOCK_OUT:
        return quantity.multiply(BigDecimal.valueOf(-1));
      default:
        throw new ApplicationException(
            String.format("Invalid adjustment type : {%s}", this));
    }
  }

}
