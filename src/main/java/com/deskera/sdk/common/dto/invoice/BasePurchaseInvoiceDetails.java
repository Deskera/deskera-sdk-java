package com.deskera.sdk.common.dto.invoice;


import com.deskera.sdk.common.dto.DocumentInfo;
import com.deskera.sdk.common.dto.enums.INVOICE_STATUS;
import com.deskera.sdk.common.dto.enums.PURCHASE_INVOICE_TYPE;
import com.deskera.sdk.common.dto.enums.RECEIPT_STATUS;
import com.deskera.sdk.common.dto.invoice.constants.ApiConstants;
import com.deskera.sdk.common.util.exception.BadRequestException;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class BasePurchaseInvoiceDetails  extends BaseInvoiceDetails{

  @ApiModelProperty(example = "false", notes = "True if opening invoice")
  private Boolean openingInvoice;

  @ApiModelProperty(example = "12.322", notes = "Total amount")
  private BigDecimal totalAmount;

  @ApiModelProperty(example = "AC-000001", notes = "Code of Account")
  private String payableAccountCode;

  @ApiModelProperty(example = "2.322", notes = "Tax amount")
  private BigDecimal taxAmount;

  @ApiModelProperty(example = "DC-0001", notes = "Customer opening document number")
  private String openingDocumentNumber;

  @ApiModelProperty(example = "OPEN", notes = "Invoice status")
  private INVOICE_STATUS status;


  @NotNull
  @ApiModelProperty(required = true, example = "C0001", notes = "Contact Code")
  private String contactCode;

  @NotNull
  @ApiModelProperty(required = true, example = "INVENTORY", notes = "Purchase invoice type.")
  private PURCHASE_INVOICE_TYPE purchaseInvoiceType;

  @ApiModelProperty(notes = "Linked Documents")
  private DocumentInfo[] linkedDocuments;

  private String supplierInvoiceNo;

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
  @ApiModelProperty(required = true, example = "25-10-2019", notes = "Purchase Invoice date")
  private String purchaseInvoiceDate;

  @NotNull
  @ApiModelProperty(required = true, example = "25-10-2019", notes = "Purchase Invoice due date")
  private String purchaseInvoiceDueDate;

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

  @JsonProperty("receiveGoodsStatus")
  @ApiModelProperty(example = "FULLY_RECEIVED", notes = "receipt goods status")
  private RECEIPT_STATUS receiptStatus;

  @Valid
  @ApiModelProperty(notes = "Purchase invoice Account item details")
  private List<PurchaseInvoiceAccountDetails> purchaseInvoiceAccounts;

  @Valid
  @ApiModelProperty(notes = "Purchase invoice item details")
  private PurchaseInvoiceRecurringDetails purchaseInvoiceRecurring;

  @Valid
  @NotNull
  @ApiModelProperty(required = true, notes = "Contact details")
  private ContactInfo contact;

  public void validateTaxAmountOpening() {
    if (Boolean.TRUE.equals(this.openingInvoice) && Objects.isNull(this.taxAmount)) {
      throw new BadRequestException(ApiConstants.Error.TAX_AMOUNT_INVALID);
    }
  }

}
