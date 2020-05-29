package com.deskera.sdk.common.dto.inventory;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipmentDocumentItemDto {

  @ApiModelProperty(example = "2", notes = "ID")
  private Long id;

  @ApiModelProperty(example = "PICKED", notes = "PPS-Document-item status")
  private SHIPMENT_DOCUMENT_STATUS status;

  @ApiModelProperty(required = true, example = "00001", notes = "Document code")
  private String documentCode;

  @ApiModelProperty(required = true, example = "QUOTATION", notes = "Document Type, Stage from where fulfillment - PPS is requested. Value will QUOTATION or SALES_INVOICE")
  private DOCUMENT_TYPE documentType;

  @ApiModelProperty(example = "Cotton T-Shirt - Dark Blue/Large", notes = "Item name.")
  @JsonProperty("itemName")
  private String name;

  @ApiModelProperty(example = "Cotton T-Shirt - Dark Blue/Large", notes = "Item Description.")
  @JsonProperty("itemDescription")
  private String description;

  @ApiModelProperty(example = "10", notes = "Ordered item quantity.")
  @JsonProperty("quantity")
  private BigDecimal quantity;

  @ApiModelProperty(example = "10", notes = "Total available item quantity.")
  @JsonProperty("availableQuantity")
  private BigDecimal availableQuantity;

  @ApiModelProperty(example = "FALSE", notes = "Flag to tell whether inventory have sufficient quantity or not.")
  private Boolean insufficientQuantity;

  @ApiModelProperty(example = "10", notes = "Total quantity picked for item.")
  private BigDecimal pickedQuantity;

  @ApiModelProperty(notes = "Warehouse details.")
  @JsonProperty("warehouse")
  private WarehouseDto warehouseDto;

  @ApiModelProperty(required = true, example = "P00001", notes = "Product code")
  private String productCode;

  @ApiModelProperty(required = true, example = "P-0000001", notes = "Product Document Sequence Code")
  private String productDocumentSequenceCode;

  @ApiModelProperty(example = "271231628", notes = "barcode of product")
  private String barcode;
}
