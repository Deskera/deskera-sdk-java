package com.deskera.sdk.common.dto.invoice;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SalesInvoiceResponse extends AbstractSalesInvoiceResponse<SalesInvoiceItemDetails> {

}
