package com.deskera.sdk.common.dto.asset.response;

import com.deskera.sdk.common.dto.asset.request.AssetRequest;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = false)
public class AssetResponse extends AssetRequest {

  @NotNull
  @ApiModelProperty(notes = "Asset Group")
  @JsonProperty("assetGroup")
  private AssetGroupResponse assetGroup;

  @ApiModelProperty(example = "true", notes = "Is Asset view-only?")
  private boolean viewOnly;

  @ApiModelProperty(example = "1.25 years", notes = "Remaining Life")
  private String remainingLife;

  @ApiModelProperty(example = "9999.99", notes = "Book Value")
  private BigDecimal bookValue;

  @ApiModelProperty(example = "9876.54", notes = "Net Book Value")
  private BigDecimal netBookValue;
}
