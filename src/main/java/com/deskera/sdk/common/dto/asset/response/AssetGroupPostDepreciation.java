package com.deskera.sdk.common.dto.asset.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetGroupPostDepreciation {

  @ApiModelProperty(example = "1", notes = "Asset Group Id")
  private Long assetGroupId;

  @ApiModelProperty(example = "IT Hardware", notes = "Asset Group name")
  private String assetGroupName;

  @ApiModelProperty(dataType = "java.util.List", notes = "depreciationItems")
  private List<DepreciationItem> depreciationItems;

}
