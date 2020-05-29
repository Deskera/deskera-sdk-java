package com.deskera.sdk.common.dto.invoice;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AbstractInvoiceProductDetails {

  @ApiModelProperty(example = "2", notes = "ID")
  private Long id;

  @NotNull
  @ApiModelProperty(required = true, example = "P00001", notes = "Product code")
  private String productCode;

  @ApiModelProperty(example = "Apple watch", notes = "Product description")
  private String productDescription;

  @NotNull
  @ApiModelProperty(required = true, example = "2", notes = "Product quantity")
  private BigDecimal productQuantity;

  @NotNull
  @ApiModelProperty(required = true, example = "0.7", notes = "Product unit price")
  private BigDecimal unitPrice;

  @ApiModelProperty(example = "2", notes = "Discount")
  private BigDecimal discount;

  @ApiModelProperty(example = "true", notes = "Discount in percentage")
  private Boolean discountInPercent;

  @ApiModelProperty(example = "GST7", notes = "Tax code")
  private String taxCode;

  @ApiModelProperty(example = "0.5", notes = "Tax amount")
  private BigDecimal taxAmount;


  @ApiModelProperty(required = true, example = "2.3", notes = "Total amount")
  private BigDecimal totalAmount;

  @ApiModelProperty(example = "1", notes = "Product view order")
  private Integer productOrder;

  @ApiModelProperty(example = "PII-000001", notes = "Purchase Invoice Item Code")
  private String purchaseInvoiceItemCode;

}
