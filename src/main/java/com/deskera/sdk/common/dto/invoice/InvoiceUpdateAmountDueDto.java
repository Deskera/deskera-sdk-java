package com.deskera.sdk.common.dto.invoice;

import com.deskera.sdk.common.dto.enums.DOCUMENT_TYPE;
import com.deskera.sdk.common.util.enums.SUPPORTED_CURRENCY_TYPE;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceUpdateAmountDueDto {

  private DOCUMENT_TYPE documentType;

  private String documentCode;

  private Date documentDate;

  private String invoiceCode;

  private BigDecimal amount;

  private BigDecimal exchangeRate;

  private SUPPORTED_CURRENCY_TYPE currency;

  private Boolean paymentDocument;

  public Boolean isPaymentDocument() {
    return DOCUMENT_TYPE.MAKE_PAYMENT.name().equalsIgnoreCase(this.getDocumentType().name())
        || DOCUMENT_TYPE.RECEIVE_PAYMENT.name().equalsIgnoreCase(this.getDocumentType().name())
        || DOCUMENT_TYPE.EXPENSE_PREPAYMENT.name().equalsIgnoreCase(this.getDocumentType().name())
        || DOCUMENT_TYPE.DEPOSIT_ADVPAYMENT.name().equalsIgnoreCase(this.getDocumentType().name());
  }
}
