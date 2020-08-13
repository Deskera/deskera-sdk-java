package com.deskera.sdk.common.dto.asset.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepreciationTxnResponse {

  @NotNull
  @ApiModelProperty(example = "4", notes = "Count of JE Posted/Reverted")
  private Long jeCount;

}
