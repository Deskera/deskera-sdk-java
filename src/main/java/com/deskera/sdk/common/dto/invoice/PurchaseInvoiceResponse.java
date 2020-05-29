package com.deskera.sdk.common.dto.invoice;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class PurchaseInvoiceResponse extends
    AbstractPurchaseInvoiceResponse<PurchaseInvoiceProductDetails> {

}
