package com.deskera.sdk.common.dto.invoice;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class InvoiceResponseInfo {

  @ApiModelProperty(example = "2018-10-01", notes = "invoice date")
  private Date invoiceDate;

  @ApiModelProperty(example = "2018-10-01", notes = "invoice due date")
  private Date invoiceDueDate;

  @ApiModelProperty(example = "test", notes = "memo")
  private String memo;

  @ApiModelProperty(example = "SI-0000041", notes = "document code")
  private String documentCode;

  @ApiModelProperty(example = "46", notes = "total amount")
  private BigDecimal totalAmount;

  @ApiModelProperty(example = "46", notes = "due amount")
  private BigDecimal dueAmount;

  @ApiModelProperty(example = "43", notes = "ID")
  private Long id;

  @ApiModelProperty(example = "sale_invoice", notes = "sale invoice or purchase invoice")
  private String type;

  @ApiModelProperty(example = "1", notes = "Total Amount")
  private BigDecimal taxAmount;
}
