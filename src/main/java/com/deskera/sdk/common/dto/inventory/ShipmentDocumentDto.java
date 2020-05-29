package com.deskera.sdk.common.dto.inventory;

import com.deskera.sdk.common.util.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ShipmentDocumentDto {

  @ApiModelProperty(example = "2", notes = "ID")
  private Long id;

  @ApiModelProperty(example = "PICKED", notes = "PPS-Document status")
  private SHIPMENT_DOCUMENT_STATUS status;

  @ApiModelProperty(notes = "PPS-Document item details", dataType = "java.util.List<ShipmentDocumentItemDto>")
  @JsonProperty("ppsDocumentItems")
  private List<ShipmentDocumentItemDto> shipmentDocumentItemDtos;

  @ApiModelProperty(required = true, example = "00001", notes = "Document code")
  private String documentCode;

  @ApiModelProperty(required = true, example = "00001", notes = "Document Sequence code")
  private String documentSequenceCode;

  @ApiModelProperty(required = true, example = "QUOTATION", notes = "Document Type, Stage from where fulfillment - PPS is requested. Value will QUOTATION or SALES_INVOICE")
  private DOCUMENT_TYPE documentType;

  @ApiModelProperty(example = "25-10-2019", notes = "Ship by date")
  @JsonFormat(pattern = DateUtil.DD_MM_YYYY)
  private Date shipByDate;

  @ApiModelProperty(example = "25-10-2019", notes = "Document date")
  @JsonFormat(pattern = DateUtil.DD_MM_YYYY)
  private Date documentDate;

  @ApiModelProperty(notes = "Package details.", dataType = "java.util.List<ShipmentPackageDto>")
  @JsonProperty("shipmentPackages")
  private List<ShipmentPackageDto> shipmentPackageDtos;

  @ApiModelProperty(example = "WH-0000001", notes = "Warehouse Code")
  private String warehouseCode;
}
