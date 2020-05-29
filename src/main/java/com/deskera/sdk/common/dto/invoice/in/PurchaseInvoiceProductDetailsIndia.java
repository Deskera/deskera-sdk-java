package com.deskera.sdk.common.dto.invoice.in;

import com.deskera.sdk.common.dto.enums.product.ItcAdjustment;
import com.deskera.sdk.common.dto.enums.product.TAX_EXEMPTION_REASON;
import com.deskera.sdk.common.dto.invoice.AbstractInvoiceProductDetails;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class PurchaseInvoiceProductDetailsIndia extends AbstractInvoiceProductDetails {

  @ApiModelProperty(required = false, example = "6.0", notes = " CGST tax rate")
  private BigDecimal cgstRate;

  @ApiModelProperty(required = false, example = "6.0", notes = " SGST tax rate")
  private BigDecimal sgstRate;

  @ApiModelProperty(required = false, example = "12.0", notes = " IGST tax rate")
  private BigDecimal igstRate;

  @ApiModelProperty(required = false, example = "60.0", notes = " CGST tax amount")
  private BigDecimal cgstAmount;

  @ApiModelProperty(required = false, example = "60.0", notes = " SGST tax amount")
  private BigDecimal sgstAmount;

  @ApiModelProperty(required = false, example = "120.0", notes = " IGST tax amount")
  private BigDecimal igstAmount;

  @ApiModelProperty(required = false, example = "40.0", notes = " cess amount")
  private BigDecimal cessAmount;

  @ApiModelProperty(required = true, example = "160.0", notes = "Tax amount")
  private BigDecimal taxAmount;


  @ApiModelProperty(required = true, example = "1000.0", notes = "Total amount")
  private BigDecimal totalAmount;

  @ApiModelProperty(required = true, example = "1160.0",
      notes = " total amount inclusive of all taxes")
  private BigDecimal totalAmountInclTax;

  @ApiModelProperty(example = "Math.max(21amount/100,4170quantity/1000)",
      notes = "Cess rule expression")
  private String cessRule;

  @ApiModelProperty(example = "ITC_IS_BLOCKED", notes = "ITC adjustment")
  private ItcAdjustment itcAdjustment;

  @ApiModelProperty(example = "false", notes = "Tax preference, whether Exempted or not Exempted")
  private Boolean taxPreference;

  @ApiModelProperty(example = "EXEMPTED", notes = "Tax Exemption reason if taxPreference is true")
  private TAX_EXEMPTION_REASON taxExemptionReason;

  @ApiModelProperty(example = "110011", notes = "Hsn or Sac code")
  private String hsnOrSacCode;

}
