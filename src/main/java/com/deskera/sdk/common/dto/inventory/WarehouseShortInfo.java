package com.deskera.sdk.common.dto.inventory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Map;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class WarehouseShortInfo {

  @ApiModelProperty(example = "WH-0000001", notes = "warehouse specific unique code")
  @JsonProperty("code")
  private String code;

  @ApiModelProperty(example = "1", notes = "Warehouse Id")
  private Long id;

  @ApiModelProperty(example = "Warehouse-1", notes = "Warehouse Name.")
  private String name;

  @ApiModelProperty(example = "false", notes = "flag to determine if warehouse is primary")
  private Boolean primary;

  @ApiModelProperty(notes = "Product Code and Available quantity Map.")
  private Map<String, BigDecimal> productAvailableQuantity;

  @ApiModelProperty(notes = "Location details")
  @JsonProperty("location")
  private LocationDto locationDto;

}