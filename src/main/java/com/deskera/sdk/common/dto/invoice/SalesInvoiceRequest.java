package com.deskera.sdk.common.dto.invoice;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@EqualsAndHashCode(callSuper = true)
public class SalesInvoiceRequest extends AbstractSalesInvoiceRequest<SalesInvoiceItemDetails> {

}
