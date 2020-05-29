package com.deskera.sdk.common.dto.inventory;

import lombok.Data;

@Data
public class StockAdjustmentRequest {

  private String code;
  private ADJUSTMENT_REASON reason;
  private String notes;

}
