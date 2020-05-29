package com.deskera.sdk.common.dto;

import com.deskera.sdk.common.dto.enums.DOCUMENT_TYPE;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DocumentInfo implements Serializable {

  @ApiModelProperty(example = "QUOTATION", notes = "Type of document.")
  private DOCUMENT_TYPE documentType;

  @ApiModelProperty(example = "QO-0000001", notes = "Document Code.")
  private String documentCode;

  @JsonIgnore
  public boolean isValid() {
    return !(documentType == null || StringUtils.isEmpty(documentCode));
  }
}
