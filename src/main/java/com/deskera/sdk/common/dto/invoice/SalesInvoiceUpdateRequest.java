package com.deskera.sdk.common.dto.invoice;

import com.deskera.sdk.common.dto.DocumentInfo;
import com.deskera.sdk.common.dto.FULFILLMENT_TYPE;
import com.deskera.sdk.common.dto.enums.FULFILLMENT_STATUS;
import com.deskera.sdk.common.dto.enums.INVOICE_STATUS;
import com.deskera.sdk.common.dto.enums.PAYMENT_STATUS;
import com.deskera.sdk.common.util.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import lombok.Data;

@Data
public class SalesInvoiceUpdateRequest {

  @ApiModelProperty(example = "FULLY_FULFILLED", notes = "Sales Fulfillment status")
  private FULFILLMENT_STATUS fulfillmentStatus;

  @ApiModelProperty(example = "05-12-2019", notes = "Sales Invoice closed on date")
  @JsonFormat(pattern = DateUtil.DD_MM_YYYY)
  private Date closedDate;

  @JsonFormat(pattern = DateUtil.DD_MM_YYYY)
  private Date fulfillmentDate;

  @ApiModelProperty(example = "RECEIVED", notes = "Payment status")
  private PAYMENT_STATUS paymentStatus;

  @ApiModelProperty(example = "OPEN", notes = "Invoice status")
  private INVOICE_STATUS status;

  @JsonFormat(pattern = DateUtil.DD_MM_YYYY)
  private Date paymentDate;

  @JsonFormat(pattern = DateUtil.DD_MM_YYYY)
  private Date fulFillmentOn;

  @ApiModelProperty(example = "PICK_PACK_SHIP", notes = "Fulfillment type: NONE, DEFAULT, PICK_PACK_SHIP, DROP_SHIP")
  private FULFILLMENT_TYPE fulfillmentType;

  @ApiModelProperty(example = "0000012", notes = " SalesInvoice Code")
  private String salesInvoiceCode;

  @ApiModelProperty(notes = "Linked Documents")
  private DocumentInfo[] linkedDocuments;

  @ApiModelProperty(example = "true", notes = "Backorder flag to indicate if backorder created")
  private Boolean backOrder;
}
