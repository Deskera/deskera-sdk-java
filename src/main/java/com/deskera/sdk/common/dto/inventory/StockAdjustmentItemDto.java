package com.deskera.sdk.common.dto.inventory;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class StockAdjustmentItemDto {

  private String productVariantCode;

  private BigDecimal quantity;

  private BigDecimal perUnitValue;

  private String productName;

}
