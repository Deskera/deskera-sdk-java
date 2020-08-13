package com.deskera.sdk.common.dto.asset.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepreciationPostPreviewResponse {

  @JsonProperty("postDepreciations")
  @ApiModelProperty(dataType = "java.util.List", notes = "AssetGroup Post Depreciation List")
  private List<AssetGroupPostDepreciation> assetGroupPostDepreciationList;

}
