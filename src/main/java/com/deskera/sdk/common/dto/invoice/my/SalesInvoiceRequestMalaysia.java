package com.deskera.sdk.common.dto.invoice.my;

import com.deskera.sdk.common.dto.invoice.AbstractSalesInvoiceRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Sales invoice request for Malaysia.
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SalesInvoiceRequestMalaysia extends
    AbstractSalesInvoiceRequest<SalesInvoiceItemDetailsMalaysia> {

}
