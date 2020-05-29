package com.deskera.sdk.common.dto.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class InventoryDto {

  private Double openingQuantity;
  private Double openingValuation;
  private Double availableQuantity;
  private String costOfGoodsSoldAccountCode;
  private String inventoryAccountCode;
  private String stockAdjustmentAccountCode;
  private String inventoryAccountName;
  private String warehouseCode;
}
