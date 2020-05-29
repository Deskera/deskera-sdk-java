package com.deskera.sdk.common.dto.invoice;

import com.deskera.sdk.common.dto.Address;
import com.deskera.sdk.common.dto.DocumentInfo;
import com.deskera.sdk.common.dto.enums.FULFILLMENT_STATUS;
import com.deskera.sdk.common.dto.invoice.constants.ApiConstants;
import com.deskera.sdk.common.util.date.DateUtil;
import com.deskera.sdk.common.util.exception.BadRequestException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;
import org.springframework.util.CollectionUtils;
@Log4j2
@Data
@EqualsAndHashCode(callSuper = true)
public class AbstractSalesInvoiceRequest<T extends AbstractSalesInvoiceItemDetails>  extends BaseInvoiceDetails{

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

  @ApiModelProperty(example = "PARTIAL_FULFILLED", notes = "fulfillment status")
  private FULFILLMENT_STATUS fulfillmentStatus;

  @ApiModelProperty(example = "false", notes = "True if want to save as draft.")
  private Boolean draft;

  @ApiModelProperty(example = "false", notes = "True if auto fulfilled is required.")
  private Boolean fulfillmentComplete;

  @ApiModelProperty(example = "0000001", notes = "Sales Invoice Code")
  private String documentSequenceCode;

  @ApiModelProperty(example = "1", notes = "Sequence Format Id")
  private String sequenceFormat;

  @JsonIgnore
  public boolean isSavedAsDraft() {
    return Boolean.TRUE.equals(draft);
  }

  @JsonIgnore
  public boolean isAutoFulfilled() {
    return Boolean.TRUE.equals(this.getFulfillmentComplete());
  }

  @JsonIgnore
  public boolean notSavedAsDraft() {
    return !isSavedAsDraft();
  }

  @JsonIgnore
  public boolean hasProducts() {
    return (!CollectionUtils.isEmpty(getSalesInvoiceItems()));
  }

  @JsonIgnore
  public void resetInvoiceItems() {
    this.setSalesInvoiceItems(null);
  }

  @JsonIgnore
  public boolean isSavedAsOpeningInvoice() {
    return Boolean.TRUE.equals(this.getOpeningInvoice());
  }

  @JsonIgnore
  public void validateOpeningInvoice(final Date bookBeginningDate) {
    if (this.isSavedAsOpeningInvoice()) {
      if (bookBeginningDate == null) {
        log.error(ApiConstants.Error.BOOK_BEGINNING_DATE_MISSING);
        throw new BadRequestException(ApiConstants.Error.BOOK_BEGINNING_DATE_MISSING);
      }

      final Date siDate = DateUtil
          .convertDateWithFormat(this.getSalesInvoiceDate(), DateUtil.DEFAULT_DATE_FORMAT);
      if (bookBeginningDate.before(siDate)) {
        log.error("Validate sale invoice date = {} before booking beginning date = {} fail.",
            bookBeginningDate, siDate);
        throw new BadRequestException(
            String.format(ApiConstants.Error.OPENING_INVOICE_DATE_ERROR, bookBeginningDate));
      }
      log.debug("Validate sale invoice date = {} before booking beginning date = {} success.",
          bookBeginningDate,
          siDate);
    }
  }


}
