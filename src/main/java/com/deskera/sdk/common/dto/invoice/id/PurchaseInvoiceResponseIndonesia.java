package com.deskera.sdk.common.dto.invoice.id;

import com.deskera.sdk.common.dto.invoice.AbstractPurchaseInvoiceResponse;
import com.deskera.sdk.common.dto.invoice.PurchaseInvoiceProductDetails;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PurchaseInvoiceResponseIndonesia extends
    AbstractPurchaseInvoiceResponse<PurchaseInvoiceProductDetails> {

  @ApiModelProperty(notes = "Is Creditable", example = "true")
  private Boolean isCreditable;
}
