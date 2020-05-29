package com.deskera.sdk.common.dto.account;

import com.deskera.sdk.common.util.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ReconcileTransactionInfo implements Serializable {

  @ApiModelProperty(example = "27-12-2019", dataType = "date", notes = "Date of document")
  @JsonFormat(pattern = DateUtil.DD_MM_YYYY)
  private String date;

  @ApiModelProperty(example = "19425", notes = "Contact code.")
  private String contactCode;

  @ApiModelProperty(example = "ABC Corp Ltd.", notes = "Contact Name.")
  private String contactName;

  @ApiModelProperty(example = "CH001", notes = "Reference number of Bank Transfer/cheque.")
  private String referenceNumber;

  @ApiModelProperty(example = "27-12-2019", dataType = "date", notes = "Date of Bank Transfer/cheque.")
  @JsonFormat(pattern = DateUtil.DD_MM_YYYY)
  private String referenceDate;

  private String jeCode;

  private BigDecimal amount;

  private String documentCode;

  @ApiModelProperty(example = "CREDIT", notes = "CREDIT/DEBIT Nature of transaction.")
  private String cdType;

  private String documentType;
}