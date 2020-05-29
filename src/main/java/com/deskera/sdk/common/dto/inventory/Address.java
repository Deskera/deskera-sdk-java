package com.deskera.sdk.common.dto.inventory;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class Address implements Serializable {

  @ApiModelProperty(example = "218, Robinson Road", notes = "Address line 1")
  private String address1;

  @ApiModelProperty(example = "Downtown", notes = "Address line 2")
  private String address2;

  @NotEmpty
  @ApiModelProperty(example = "C001", notes = "Country")
  private String country;

  @ApiModelProperty(example = "CS001", notes = "State")
  private String state;

  @ApiModelProperty(example = "C001", notes = "City")
  private String city;

  @ApiModelProperty(example = "123456", notes = "Postal Code")
  private String postalCode;

  @ApiModelProperty(example = "true", notes = "Is this a default address?")
  private Boolean preferred;
}
