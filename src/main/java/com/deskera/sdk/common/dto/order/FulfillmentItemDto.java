package com.deskera.sdk.common.dto.order;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.math.BigDecimal;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FulfillmentItemDto {

  private Long id;
  private BigDecimal pendingQuantity;
  private BigDecimal quantityRequired;
  private String productCode;
  private Integer sequence;
  private String documentItemCode;
  private BigDecimal fulfilledQuantity;
  private String fulfillmentDate;
  private BigDecimal availableProductQuantity;
  private String productName;
  private String productType;
  private String productDescription;
  private String warehouseCode;

}
