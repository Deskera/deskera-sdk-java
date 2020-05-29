package com.deskera.sdk.common.dto.invoice.ph;

import com.deskera.sdk.common.dto.invoice.AbstractPurchaseInvoiceResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PurchaseInvoiceResponsePhilippines extends
    AbstractPurchaseInvoiceResponse<PurchaseInvoiceProductDetailsPhilippines> {

}
