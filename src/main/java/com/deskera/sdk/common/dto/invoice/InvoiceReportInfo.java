package com.deskera.sdk.common.dto.invoice;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import lombok.Data;

@Data
public class InvoiceReportInfo {

  @CsvBindByName(column = "Invoice Date")
  @CsvBindByPosition(position = 3)
  private String invoiceDateFormat;

  @CsvBindByName(column = "Due Date")
  @CsvBindByPosition(position = 4)
  private String invoiceDueDateFormat;

  @CsvBindByName(column = "Contact")
  @CsvBindByPosition(position = 2)
  private String contactName;

  @CsvBindByName(column = "Journal No")
  @CsvBindByPosition(position = 1)
  private String journalEntryCode;

  @CsvBindByName(column = "No")
  @CsvBindByPosition(position = 0)
  private String documentCode;

  @CsvBindByName(column = "Total Amount")
  @CsvBindByPosition(position = 5)
  private String totalAmount;

  @CsvBindByName(column = "Amount Due")
  @CsvBindByPosition(position = 6)
  private String dueAmount;
}
