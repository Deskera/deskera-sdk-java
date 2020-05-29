package com.deskera.sdk.common.dto.inventory;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BoxDto {

  @ApiModelProperty(example = "BOX_M", notes = "BOX_S, BOX_M, BOX_L")
  private String type;

  @ApiModelProperty(example = "10 m", notes = "Box length.")
  private String length;

  @ApiModelProperty(example = "10 m", notes = "Box width.")
  private String width;

  @ApiModelProperty(example = "14 m", notes = "Box width.")
  private String height;

}
