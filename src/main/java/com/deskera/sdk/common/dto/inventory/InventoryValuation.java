package com.deskera.sdk.common.dto.inventory;

import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

@Data
public class InventoryValuation {
  @ApiModelProperty(example = "3000.00", notes = "Total Valuation")
  private Double totalValuation;
  @ApiModelProperty(example = "30", notes = "Number of Product")
  private Double totalProduct;
  private List<ProductValuation> productValuations;

}
