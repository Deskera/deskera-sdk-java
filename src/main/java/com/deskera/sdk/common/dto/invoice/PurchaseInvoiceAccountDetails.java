package com.deskera.sdk.common.dto.invoice;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PurchaseInvoiceAccountDetails {

  @ApiModelProperty(example = "2", notes = "ID")
  private Long id;

  @NotNull
  @ApiModelProperty(required=true, example = "P00001", notes = "Product code")
  private String accountCode;

  @ApiModelProperty(example = "Apple watch", notes = "Product description")
  private String accountDescription;

  @ApiModelProperty(example = "2", notes = "Discount")
  private BigDecimal discount;

  @ApiModelProperty(example = "true", notes = "Discount in percentage")
  private Boolean discountInPercent;

  @ApiModelProperty(example = "GST7", notes = "Tax code")
  private String taxCode;

  @ApiModelProperty(example = "0.5", notes = "Tax amount")
  private BigDecimal taxAmount;

  @NotNull
  @ApiModelProperty(required=true, example = "2.0", notes = "Amount")
  private BigDecimal amount;

  @NotNull
  @ApiModelProperty(required=true, example = "2.3", notes = "Total amount")
  private BigDecimal totalAmount;

  @ApiModelProperty(example = "1", notes = "Product view order")
  private Integer accountOrder;

}
