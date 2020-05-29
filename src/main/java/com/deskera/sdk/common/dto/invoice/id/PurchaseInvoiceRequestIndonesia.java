package com.deskera.sdk.common.dto.invoice.id;

import com.deskera.sdk.common.dto.invoice.AbstractPurchaseInvoiceRequest;
import com.deskera.sdk.common.dto.invoice.PurchaseInvoiceProductDetails;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@EqualsAndHashCode(callSuper = true)
public class PurchaseInvoiceRequestIndonesia extends
    AbstractPurchaseInvoiceRequest<PurchaseInvoiceProductDetails> {

  @ApiModelProperty(notes = "Is Creditable", example = "true")
  private Boolean isCreditable;

}
