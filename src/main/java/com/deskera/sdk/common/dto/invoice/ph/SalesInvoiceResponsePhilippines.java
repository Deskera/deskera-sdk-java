package com.deskera.sdk.common.dto.invoice.ph;

import com.deskera.sdk.common.dto.invoice.AbstractSalesInvoiceResponse;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class SalesInvoiceResponsePhilippines extends
    AbstractSalesInvoiceResponse<SalesInvoiceItemDetailsPhilippines> {

}
