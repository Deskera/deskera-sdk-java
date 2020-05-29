package com.deskera.sdk.common.dto.invoice;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PurchaseInvoiceProductDetails extends AbstractInvoiceProductDetails {

  @ApiModelProperty(example = "{\"x\":\"1\",\"y\":\"some value\"}", notes = "custom field json")
  private Object customField;
}
