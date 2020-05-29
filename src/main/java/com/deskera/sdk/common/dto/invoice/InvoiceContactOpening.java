package com.deskera.sdk.common.dto.invoice;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InvoiceContactOpening {

  private BigDecimal totalNetAmount;
  private BigDecimal totalBillAmount;

  private Map<String, List<InvoiceResponseInfo>> invoices;

  public InvoiceContactOpening() {}
}
