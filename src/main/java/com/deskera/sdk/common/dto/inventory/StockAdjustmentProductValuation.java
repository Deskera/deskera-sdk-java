package com.deskera.sdk.common.dto.inventory;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class StockAdjustmentProductValuation {

  @ApiModelProperty(example = "P-000001", notes = "Product Code")
  private final String productCode;
  @ApiModelProperty(example = "20", notes = "Number of product of same type")
  private final BigDecimal noOfProduct;
  @ApiModelProperty(example = "2000.0", notes = "Valuation")
  private final BigDecimal valuation;
  @ApiModelProperty(example = "IPHONE", notes = "Product Name")
  private String productName;
  @ApiModelProperty(example = "2000.0", notes = "Unit price")
  private BigDecimal unitPrice;

}
