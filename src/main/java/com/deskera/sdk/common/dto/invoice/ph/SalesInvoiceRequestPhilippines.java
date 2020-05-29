package com.deskera.sdk.common.dto.invoice.ph;

import com.deskera.sdk.common.dto.invoice.AbstractSalesInvoiceRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class SalesInvoiceRequestPhilippines extends
    AbstractSalesInvoiceRequest<SalesInvoiceItemDetailsPhilippines> {



}
