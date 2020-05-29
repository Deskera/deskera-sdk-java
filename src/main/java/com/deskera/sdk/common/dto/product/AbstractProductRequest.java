package com.deskera.sdk.common.dto.product;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractProductRequest {

  private String name;
  private ProductType type;
  private String barcode;
  private String description;
  private Double purchasePrice;
  private Double salesPrice;
  private String purchaseAccountCode;
  private String salesAccountCode;
  private String purchaseReturnAccountCode;
  private String salesReturnAccountCode;
  private String purchaseTaxCode;
  private String salesTaxCode;
  private Boolean purchasePriceTaxInclusive;
  private Boolean salesPriceTaxInclusive;
  private Long stockUom;
  private String[] images;
  private InventoryDto inventory;
  private String categoryCode;
  private String categoryDesc;
  private Boolean taxable = Boolean.TRUE;
  private Object customField;
  private Boolean reorderEnabled;
  private Long reorderLevel;

  @JsonIgnore
  public boolean isTracked() {
    return ProductType.TRACKED.equals(this.type) || ProductType.BILL_OF_MATERIALS.equals(this.type);
  }

  @JsonIgnore
  public boolean isBillOfMaterials() {
    return ProductType.BILL_OF_MATERIALS.equals(this.type);
  }

}
