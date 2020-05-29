package com.deskera.sdk.common.dto.invoice;

import com.deskera.sdk.common.dto.enums.ProductType;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AbstractSalesInvoiceItemDetails {
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

  @ApiModelProperty(example = "SII-000001", notes = "Sales Invoice Item Code")
  private String salesInvoiceItemCode;

  @ApiModelProperty(required = true, example = "TRACKED", allowableValues = "TRACKED, NONTRACKED", notes = "Product type")
  private ProductType type;

  @ApiModelProperty(example = "3", notes = "Total available quantity")
  private BigDecimal availableQuantity;
}
