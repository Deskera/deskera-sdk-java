package com.deskera.sdk.common.dto;

import com.deskera.sdk.common.dto.enums.DOCUMENT_TYPE;
import com.deskera.sdk.common.util.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class SalesDocument implements Serializable {

  @ApiModelProperty(example = "QUOTATION", notes = "Type of document.")
  private DOCUMENT_TYPE documentType;

  @ApiModelProperty(example = "QO-0000001", notes = "Document Code.")
  private String documentCode;

  @ApiModelProperty( dataType = "java.util.List<DocumentItemDetails>", notes = "Document item details.")
  private List<DocumentItemDetails> documentItemDetails;

  @ApiModelProperty(notes = "Ship from address.")
  private Address shipFrom;

  @ApiModelProperty(notes = "Ship To address.")
  private Address shipTo;

  @ApiModelProperty(example = "000012", notes = "Contact code")
  private String contactCode;

  @ApiModelProperty(example = "25-10-2019", notes = "Ship by date")
  @JsonFormat(pattern = DateUtil.DD_MM_YYYY)
  private Date shipByDate;

  @ApiModelProperty(example = "25-10-2019", notes = "Document date")
  @JsonFormat(pattern = DateUtil.DD_MM_YYYY)
  private Date documentDate;

  @ApiModelProperty(notes = "Linked Documents")
  private DocumentInfo[] linkedDocuments;
}
