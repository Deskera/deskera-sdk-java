package com.deskera.sdk.common.dto.contact;

import com.deskera.sdk.common.dto.Address;
import com.deskera.sdk.common.util.enums.CONTACT_STATUS;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;

/**
 * Request payload to update contact attributes.
 */
@Data
public class ContactAttributeUpdateDto {

  @ApiModelProperty(example = "INACTIVE", notes = "Contact status")
  private CONTACT_STATUS status;

  @ApiModelProperty(example = "true", notes = "Is customer?")
  private Boolean customer;

  @ApiModelProperty(example = "false", notes = "Is vendor?")
  private Boolean vendor;

  @ApiModelProperty(dataType = "java.util.List<Address>", notes = "List of Billing Address.")
  private List<Address> billingAddress;

  @ApiModelProperty(dataType = "java.util.List<Address>", notes = "List of Shipping Address.")
  private List<Address> shippingAddress;

  @ApiModelProperty(example = "{\"x\":\"1\",\"y\":\"some value\"}", notes = "custom field json")
  private Object customField;
}
