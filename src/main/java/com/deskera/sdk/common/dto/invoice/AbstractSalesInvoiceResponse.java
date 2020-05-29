package com.deskera.sdk.common.dto.invoice;

import com.deskera.sdk.common.dto.Address;
import com.deskera.sdk.common.dto.DocumentInfo;
import com.deskera.sdk.common.dto.FULFILLMENT_TYPE;
import com.deskera.sdk.common.dto.enums.FULFILLMENT_STATUS;
import com.deskera.sdk.common.dto.enums.PAYMENT_STATUS;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@EqualsAndHashCode(callSuper = true)
public class AbstractSalesInvoiceResponse<T extends AbstractSalesInvoiceItemDetails> extends BaseInvoiceDetails {

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
  private List<T> salesInvoiceItems;

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

  @ApiModelProperty(notes = "Bill to address")
  private Address billTo;

  @ApiModelProperty(required = false, example = "25-10-2019", notes = "Ship by date")
  private String shipByDate;


  @ApiModelProperty(example = "1", notes = "Sales invoice id")
  private Long id;

  @ApiModelProperty(example = "SI001", notes = "Sales invoice code")
  private String salesInvoiceCode;

  @ApiModelProperty(example = "0000001", notes = "Sales invoice Sequence Code")
  private String documentSequenceCode;

  @ApiModelProperty(notes = "KnockOff Info")
  private KnockOffInfo[] knockoffInfo;

  @ApiModelProperty(example = "false", notes = "Sales invoice drafted")
  private Boolean draft;

  @ApiModelProperty(example = "PENDING", notes = "Sales invoice payment status")
  private PAYMENT_STATUS paymentStatus;

  @ApiModelProperty(example = "UNFULFILLED", notes = "Sales invoice fulfillment status")
  private FULFILLMENT_STATUS fulfillmentStatus;

  @ApiModelProperty(example = "PICK_PACK_SHIP", notes = "Fulfillment type: NONE, DEFAULT, PICK_PACK_SHIP, DROP_SHIP")
  private FULFILLMENT_TYPE fulfillmentType;

  @ApiModelProperty(example = "true", notes = "Backorder flag to indicate if backorder created")
  private Boolean backOrder;

}
