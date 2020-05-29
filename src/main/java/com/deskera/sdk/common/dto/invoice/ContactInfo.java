package com.deskera.sdk.common.dto.invoice;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class ContactInfo implements Serializable {

  @NotEmpty
  @ApiModelProperty(required = true, example = "ABC Pte Ltd", notes = "Customer name")
  private String name;

  @ApiModelProperty(example = "Raffles Place 1", notes = "Address")
  private String address;

  @ApiModelProperty(example = "u000:1109:uen", notes = "Peppol ID")
  private String peppolId;
}
