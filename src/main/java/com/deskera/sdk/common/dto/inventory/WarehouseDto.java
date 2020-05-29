package com.deskera.sdk.common.dto.inventory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class WarehouseDto {

  @ApiModelProperty(example = "WH-0000001", notes = "warehouse specific unique code")
  @JsonProperty("code")
  private String code;

  @ApiModelProperty(example = "1", notes = "Warehouse Id")
  private Long id;

  @ApiModelProperty(notes = "Location details")
  @JsonProperty("location")
  private LocationDto locationDto;

  @ApiModelProperty(example = "123", notes = "Tenant ID.", hidden = true)
  @JsonIgnore
  private Long tenantId;

  @ApiModelProperty(example = "Warehouse-1", notes = "Warehouse Name.")
  private String name;

  @ApiModelProperty(example = "true", notes = "Warehouse Status.")
  private Boolean active;

  @ApiModelProperty(example = "false", notes = "flag to determine if warehouse is primary")
  private Boolean primary;
}
