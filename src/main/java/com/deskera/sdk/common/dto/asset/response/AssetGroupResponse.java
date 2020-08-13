package com.deskera.sdk.common.dto.asset.response;

import com.deskera.sdk.common.dto.asset.request.AssetGroupRequest;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class AssetGroupResponse extends AssetGroupRequest {

  @ApiModelProperty(example = "Acc00001", notes = "Asset Account Display Code")
  private String assetAccountDisplayCode;

  @ApiModelProperty(example = "Acc00002", notes = "Asset Accumulated Account Display Code")
  private String assetAccumulatedAccountDisplayCode;

  @ApiModelProperty(example = "Acc00003", notes = "Depreciation Expense Account Display Code")
  private String depreciationExpenseAccountDisplayCode;

  @ApiModelProperty(example = "Computer Equipment Asset Account", notes = "Asset Account Name")
  private String assetAccountName;

  @ApiModelProperty(example = "Computer Equipment Accumulated Account", notes = "Asset Accumulated Account Name")
  private String assetAccumulatedAccountName;

  @ApiModelProperty(example = "Computer Equipment Depreciation Account", notes = "Depreciation Expense Account Name")
  private String depreciationExpenseAccountName;

  @ApiModelProperty(example = "true", notes = "Is Asset Group active?")
  private Boolean active;

  @ApiModelProperty(example = "true", notes = "Is Asset Group view-only?")
  private boolean viewOnly;

}
