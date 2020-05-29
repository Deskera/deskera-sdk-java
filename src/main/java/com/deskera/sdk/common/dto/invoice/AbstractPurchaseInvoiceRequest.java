package com.deskera.sdk.common.dto.invoice;

import com.deskera.sdk.common.dto.Address;
import com.deskera.sdk.common.dto.invoice.constants.ApiConstants;
import com.deskera.sdk.common.util.date.DateUtil;
import com.deskera.sdk.common.util.exception.BadRequestException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import javax.validation.Valid;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@EqualsAndHashCode(callSuper = true)
public class AbstractPurchaseInvoiceRequest<T extends AbstractInvoiceProductDetails> extends
    BasePurchaseInvoiceDetails {

  @Valid
  @ApiModelProperty(notes = "Purchase invoice Product item details")
  private List<T> purchaseInvoiceProducts;

  @ApiModelProperty(example = "false", notes = "True if want to save as draft.")
  private Boolean draft;

  @ApiModelProperty(example = "false", notes = "True if auto received is required.")
  private Boolean receivedComplete;
  
  @ApiModelProperty(notes = "Ship from address")
  private Address shipFrom;

  @ApiModelProperty(notes = "Ship to address")
  private Address shipTo;

  @ApiModelProperty(notes = "Bill to Address")
  private Address billTo;

  @ApiModelProperty(example = "0000001", notes = "Bill Code")
  private String documentSequenceCode;

  @ApiModelProperty(example = "1", notes = "Sequence Format Id")
  private String sequenceFormat;

  @JsonIgnore
  public boolean isSavedAsDraft() {
    return Boolean.TRUE.equals(draft);
  }

  @JsonIgnore
  public boolean notSavedAsDraft() {
    return !isSavedAsDraft();
  }

  @JsonIgnore
  public void resetInvoiceItems() {
    this.setPurchaseInvoiceAccounts(null);
    this.setPurchaseInvoiceProducts(null);
  }

  @JsonIgnore
  public boolean isAutoReceived() {
    return Boolean.TRUE.equals(this.getReceivedComplete());
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

      final Date piDate = DateUtil
          .convertDateWithFormat(this.getPurchaseInvoiceDate(), DateUtil.DEFAULT_DATE_FORMAT);
      if (bookBeginningDate.before(piDate)) {
        log.error("Validate purchase invoice date = {} before booking beginning date = {} fail.",
            bookBeginningDate,
            piDate);
        throw new BadRequestException(
            String.format(ApiConstants.Error.OPENING_INVOICE_DATE_ERROR, bookBeginningDate));
      }
      log.debug("Validate purchase invoice date = {} before booking beginning date = {} success.",
          bookBeginningDate,
          piDate);
    }
  }


}
