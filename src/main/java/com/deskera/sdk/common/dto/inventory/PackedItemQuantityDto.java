package com.deskera.sdk.common.dto.inventory;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.Data;

/**
 * DTO class for mapping of packed quantity of item in shipment package
 */
@Data
public class PackedItemQuantityDto {

  @ApiModelProperty(example = "2", notes = "Shipment Document Item Id")
  private Long shipmentDocumentItemId;

  @ApiModelProperty(example = "10", notes = "packed quantity of item in the package")
  private BigDecimal packedQuantity;

}

