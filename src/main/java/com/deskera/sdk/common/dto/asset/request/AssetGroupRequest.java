package com.deskera.sdk.common.dto.asset.request;

import com.deskera.sdk.common.dto.asset.enums.DEPRECIATION_CONVENTION;
import com.deskera.sdk.common.dto.asset.enums.DEPRECIATION_METHOD;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class AssetGroupRequest {

  @ApiModelProperty(example = "1", notes = "Id")
  private Long id;

  @NotNull
  @ApiModelProperty(example = "IT Hardware", notes = "Asset Group Name")
  private String name;

  @NotNull
  @ApiModelProperty(example = "AC-0000001", notes = "Asset Account Code")
  private String assetAccountCode;

  @NotNull
  @ApiModelProperty(example = "AC-0000002", notes = "Asset Accumulated Account Code")
  private String assetAccumulatedAccountCode;

  @NotNull
  @ApiModelProperty(example = "AC-0000003", notes = "Depreciation Expense Account Code")
  private String depreciationExpenseAccountCode;

  @NotNull
  @ApiModelProperty(example = "STRAIGHT_LINE", notes = "Depreciation Method")
  private DEPRECIATION_METHOD depreciationMethod;

  @ApiModelProperty(example = "FULL_MONTH", notes = "Depreciation Convention")
  private DEPRECIATION_CONVENTION depreciationConvention;

  @ApiModelProperty(example = "1", notes = "Depreciation Rate")
  private BigDecimal depreciationRate;

  @ApiModelProperty(example = "2", notes = "Effective Life")
  private BigDecimal effectiveLife;

  @ApiModelProperty(example = "1", notes = "Declining Factor")
  private BigDecimal decliningFactor;

}
