package com.deskera.sdk.common.dto.inventory;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class StockTransferItemDto {

  private String productVariantCode;

  private BigDecimal quantity;

  private String productName;

}
