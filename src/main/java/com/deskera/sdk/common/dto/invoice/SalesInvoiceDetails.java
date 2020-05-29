package com.deskera.sdk.common.dto.invoice;

import com.deskera.sdk.common.dto.Address;
import com.deskera.sdk.common.dto.DocumentInfo;
import com.deskera.sdk.common.dto.enums.FULFILLMENT_STATUS;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class SalesInvoiceDetails extends BaseInvoiceDetails {

  @NotNull
  @ApiModelProperty(required = true, example = "C0001", notes = "Contact Code")
  private String contactCode;

  @ApiModelProperty(notes = "Linked Documents")
  private DocumentInfo[] linkedDocuments;

  @ApiModelProperty(example = "CPO001", notes = "Contact PO reference number")
  private String purchaseOrderRefNo;

  @ApiModelProperty(example = "JE0001", notes = "Journal Entry Code")
  private String journalEntryCode;

  @NotEmpty
  @ApiModelProperty(required = true, example = "C001", notes = "Currency")
  private String currency;

  @ApiModelProperty(example = "0.456345", notes = "Exchange rate")
  private BigDecimal exchangeRate;

  @NotNull
  @ApiModelProperty(required = true, example = "25-10-2019", notes = "Sales Invoice date")
  private String salesInvoiceDate;

  @NotNull
  @ApiModelProperty(required = true, example = "25-10-2019", notes = "Sales Invoice due date")
  private String salesInvoiceDueDate;

  @ApiModelProperty(example = "Memo details", notes = "Memo")
  private String memo;

  @ApiModelProperty(notes = "File attachments")
  private String[] attachments;

  @ApiModelProperty(example = "false", notes = "Unit price is GST inclusive")
  private Boolean unitPriceGstInclusive;

  @ApiModelProperty(example = "12.322", notes = "Amount Due")
  private BigDecimal dueAmount;

  @ApiModelProperty(example = "true", notes = "True if Invoice is recurring.")
  private Boolean recurring;

  @ApiModelProperty(example = "false", notes = "True if Invoice recurrence is active.")
  private Boolean recurringActivated;

  @Valid
  @ApiModelProperty(notes = "Sales invoice item details")
  private List<SalesInvoiceItemDetails> salesInvoiceItems;

  @Valid
  @ApiModelProperty(notes = "Sales invoice item details")
  private SalesInvoiceRecurringDetails salesInvoiceRecurring;

  @Valid
  @NotNull
  @ApiModelProperty(required = true, notes = "Contact details")
  private ContactInfo contact;

  @ApiModelProperty(notes = "Ship from address")
  private Address shipFrom;

  @ApiModelProperty(notes = "Ship to address")
  private Address shipTo;

  @ApiModelProperty(required = false, example = "25-10-2019", notes = "Ship by date")
  private String shipByDate;

  @ApiModelProperty(example = "PARTIAL_FULFILLED", notes = "fulfillment status")
  private FULFILLMENT_STATUS fulfillmentStatus;
}
