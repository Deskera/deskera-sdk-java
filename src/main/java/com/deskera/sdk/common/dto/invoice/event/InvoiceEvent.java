package com.deskera.sdk.common.dto.invoice.event;

import com.deskera.sdk.common.dto.enums.INVOICE_TYPE;
import com.deskera.sdk.common.util.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceEvent {

  private INVOICE_TYPE type;

  private String contactCode;

  @JsonFormat(pattern = DateUtil.DD_MM_YYYY)
  private Date invoiceDate;

  private String invoiceCode;

  private String jeCode;

  private String currency;

  private BigDecimal exchangeRate;

  private Boolean openingInvoice;

  private boolean interStateIndia;

  private boolean isExpense;

  private List<InvoiceEventItemDetails> invoiceItemDetailsList = new ArrayList<>();

  public void addInvoiceEventItemDetails (final InvoiceEventItemDetails invoiceEventItemDetails) {
    invoiceItemDetailsList.add(invoiceEventItemDetails);
  }
}
