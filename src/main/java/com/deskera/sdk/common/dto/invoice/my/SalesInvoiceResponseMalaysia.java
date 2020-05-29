package com.deskera.sdk.common.dto.invoice.my;

import com.deskera.sdk.common.dto.invoice.AbstractSalesInvoiceResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Sales invoice response for Malaysia.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SalesInvoiceResponseMalaysia extends
    AbstractSalesInvoiceResponse<SalesInvoiceItemDetailsMalaysia> {

}
