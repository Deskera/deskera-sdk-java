package com.deskera.sdk.common.dto.inventory;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class WarehouseResponse extends WarehouseDto {

  @ApiModelProperty(example = "1234", notes = "Warehouse ID")
  private Long id;

  @ApiModelProperty(example = "false", notes = "Flag to determine if warehouse can be deleted")
  private Boolean isDeleteEnable = Boolean.TRUE;
}
