package com.deskera.sdk.common.dto;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class DocumentItemDetails implements Serializable {

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

  @ApiModelProperty(example = "iPhone", notes = "Product Name")
  private String productName;
}
