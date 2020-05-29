package com.deskera.sdk.common.dto.invoice;

import com.deskera.sdk.common.dto.enums.INVOICE_STATUS;
import com.deskera.sdk.common.dto.invoice.constants.ApiConstants;
import com.deskera.sdk.common.util.exception.BadRequestException;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.List;
import java.util.Objects;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class BaseInvoiceDetails {

  @ApiModelProperty(example = "false", notes = "True if opening invoice")
  private Boolean openingInvoice;

  @ApiModelProperty(example = "12.322", notes = "Total amount")
  private BigDecimal totalAmount;

  @ApiModelProperty(hidden=true, example = "AC-000001", notes = "Code of Account")
  private String payableAccountCode;

  @ApiModelProperty(example = "2.322", notes = "Tax amount")
  private BigDecimal taxAmount;

  @ApiModelProperty(example = "DC-0001", notes = "Customer opening document number")
  private String openingDocumentNumber;

  @ApiModelProperty(example = "WH-000001", notes = "Warehouse Code")
  private String warehouseCode;

  @ApiModelProperty(example = "true", notes = "Drop Ship flag to indicate if purchase invoice is created for drop ship")
  private Boolean dropShip;

  @ApiModelProperty(example = "true", notes = "Backorder flag to indicate if purchase invoice is backorder")
  private Boolean backOrder;

  @ApiModelProperty(example = "OPEN", notes = "Invoice status")
  private INVOICE_STATUS status;

  @ApiModelProperty(example = "{\"x\":\"1\",\"y\":\"some value\"}", notes = "custom field json")
  private Object customField;

  private List<BigInteger> attachmentIds;

  public void validateTaxAmountOpening() {
    if (Boolean.TRUE.equals(this.openingInvoice) && Objects.isNull(this.taxAmount)) {
      throw new BadRequestException(ApiConstants.Error.TAX_AMOUNT_INVALID);
    }
  }
}
