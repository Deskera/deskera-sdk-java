package com.deskera.sdk.common.dto.asset.response;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = false)
@AllArgsConstructor
@NoArgsConstructor
public class NetBookValueResponse {

  @ApiModelProperty(example = "9999.99", notes = "Total Net Book Value for date range")
  private BigDecimal totalNetBookValue;
}
