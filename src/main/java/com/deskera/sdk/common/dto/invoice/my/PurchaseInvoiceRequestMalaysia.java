package com.deskera.sdk.common.dto.invoice.my;

import com.deskera.sdk.common.dto.invoice.AbstractPurchaseInvoiceRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Purchase invoice request for Malaysia.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PurchaseInvoiceRequestMalaysia extends
    AbstractPurchaseInvoiceRequest<PurchaseInvoiceProductDetailsMalaysia> {

}
