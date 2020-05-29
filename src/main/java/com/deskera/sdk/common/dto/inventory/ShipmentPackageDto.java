package com.deskera.sdk.common.dto.inventory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipmentPackageDto {

  @ApiModelProperty(example = "1", notes = "Package Id.")
  @JsonProperty("id")
  private Long id;

  @ApiModelProperty(example = "10", notes = "Carton or other package sequence.")
  private Integer sequence;

  @ApiModelProperty(example = "Carton", notes = "Label of package.")
  @JsonProperty("label")
  private String label;

  @ApiModelProperty(example = "10", notes = "Total capacity of defined package/carton.")
  private BigDecimal capacity;

  @ApiModelProperty(example = "10", notes = "Quantity packed in this package.")
  @JsonProperty("packedQuantity")
  private BigDecimal packedQuantity;

  @ApiModelProperty(example = "103313333#$", notes = "Tracking number of shipment.")
  @JsonProperty("trackingNumber")
  private String trackingNumber;

  @ApiModelProperty(example = "Fedex", notes = "Shipping carrier. Fedex, ups")
  private CARRIER_TYPE carrier;

  @ApiModelProperty(example = "Courier", notes = "Delivery type. Courier")
  private DELIVERY_TYPE deliveryType;

  @ApiModelProperty(notes = "Box Details")
  private BoxDto box;

  @ApiModelProperty(example = "10 KG", notes = "box weight.")
  private String boxWeight;

  @ApiModelProperty(example = "FALSE", notes = "Whether package contains fragile object.")
  private Boolean containsFragileObject;

  @ApiModelProperty(example = "PACKED", notes = "Package status")
  private SHIPMENT_DOCUMENT_STATUS status;

  @ApiModelProperty(required = true, example = "00001", notes = "Document code")
  private String documentCode;

  @ApiModelProperty(required = true, example = "QUOTATION", notes = "Document Type, Stage from where fulfillment - PPS is requested. Value will QUOTATION or SALES_INVOICE")
  private DOCUMENT_TYPE documentType;

  @ApiModelProperty(notes = "Package Item quantity.", dataType = "java.util.List<PackedItemQuantity>")
  private List<PackedItemQuantityDto> packedItemQuantities;
}
