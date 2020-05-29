package com.deskera.sdk.common.dto.inventory;

import java.math.BigDecimal;
import lombok.Data;

@Data
public class ProductShortInfo {

  private String pid;
  private String documentSequenceCode;
  private String name;
  private String description;
  private String type;
  private String barcode;
  private BigDecimal availableQuantity;
  private Boolean status;
  private String categoryCode;
  private BigDecimal unitPrice;
  private boolean taxable;
}
