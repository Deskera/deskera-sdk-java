package com.deskera.sdk.common.dto.inventory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class LocationDto {

  @ApiModelProperty(example = "1", notes = "Id")
  private Long id;

  @ApiModelProperty(example = "Location-1", notes = "Name of location")
  private String name;

  @ApiModelProperty(dataType = "java.util.List<Address>", notes = "List of Address.")
  private List<Address> address;
}
