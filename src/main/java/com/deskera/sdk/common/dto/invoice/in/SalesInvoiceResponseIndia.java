package com.deskera.sdk.common.dto.invoice.in;

import com.deskera.sdk.common.dto.enums.contact.CustomerTypeIndia;
import com.deskera.sdk.common.dto.enums.contact.VendorTypeIndia;
import com.deskera.sdk.common.dto.invoice.AbstractSalesInvoiceResponse;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class SalesInvoiceResponseIndia
    extends AbstractSalesInvoiceResponse<SalesInvoiceItemDetailsIndia> {

  @ApiModelProperty(required = true, notes = "GSTIN", example = "ABSASASSASASA198")
  private String gstin;

  @ApiModelProperty(required = true, notes = "state in India", example = "Punjab")
  private String placeOfSupply;

  @ApiModelProperty(required = true, notes = "Customer Type", example = "NA")
  private CustomerTypeIndia customerType;

  @ApiModelProperty(required = true, notes = "Vendor Type", example = "NA")
  private VendorTypeIndia vendorType;

  @ApiModelProperty(required = true, notes = "Whether Eway Bill is created or not",
      example = "false")
  private boolean isEwayGenerated;
}
