package com.deskera.sdk.common.dto.invoice.ph;

import com.deskera.sdk.common.dto.invoice.AbstractPurchaseInvoiceRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PurchaseInvoiceRequestPhilippines extends
    AbstractPurchaseInvoiceRequest<PurchaseInvoiceProductDetailsPhilippines> {

}
