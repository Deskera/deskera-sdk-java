package com.deskera.sdk.common.dto.invoice.event;

import com.deskera.sdk.common.dto.enums.product.ItcAdjustment;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceEventItemDetails {

  private String productCode;

  private BigDecimal taxAmount;

  private String taxCode;

  private BigDecimal sgstAmountIndia;

  private BigDecimal cgstAmountIndia;

  private BigDecimal igstAmountIndia;

  private BigDecimal cessAmountIndia;

  private ItcAdjustment itcAdjustment;

  private BigDecimal totalAmount;

}
