package com.deskera.sdk.common.dto.invoice;

import com.deskera.sdk.common.dto.enums.INVOICE_STATUS;
import com.deskera.sdk.common.dto.enums.PAYMENT_STATUS;
import com.deskera.sdk.common.dto.enums.RECEIPT_STATUS;
import com.deskera.sdk.common.util.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@Data
public class PurchaseInvoiceUpdateRequest {
  @ApiModelProperty(example = "FULLY_RECEIVED", notes = "Purchase Invoice Receipt status")
  private RECEIPT_STATUS receiptStatus;

  @ApiModelProperty(example = "05-12-2019", notes = "Purchase Invoice closed on date")
  @JsonFormat(pattern = DateUtil.DD_MM_YYYY)
  private Date closedDate;

  @JsonFormat(pattern = DateUtil.DD_MM_YYYY)
  private Date receiptDate;

  @ApiModelProperty(example = "RECEIVED", notes = "Payment status")
  private PAYMENT_STATUS paymentStatus;

  @ApiModelProperty(example = "OPEN", notes = "Invoice status")
  private INVOICE_STATUS status;

  @JsonFormat(pattern = DateUtil.DD_MM_YYYY)
  private Date paymentDate;

  @JsonFormat(pattern = DateUtil.DD_MM_YYYY)
  private Date receiptOn;
}
