package com.deskera.sdk.common.dto.invoice.my;

import com.deskera.sdk.common.dto.invoice.AbstractPurchaseInvoiceResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Purchase invoice response for Malaysia.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PurchaseInvoiceResponseMalaysia extends
    AbstractPurchaseInvoiceResponse<PurchaseInvoiceProductDetailsMalaysia> {

}
