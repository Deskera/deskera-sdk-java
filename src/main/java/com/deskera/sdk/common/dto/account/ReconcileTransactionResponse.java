package com.deskera.sdk.common.dto.account;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
public class ReconcileTransactionResponse {

  @ApiModelProperty(example = "5000.00", notes = "Total Deposit Amount.")
  private BigDecimal totalDeposits;

  @ApiModelProperty(example = "3000.00", notes = "Total Payment Amount.")
  private BigDecimal totalPayments;

  @ApiModelProperty(example = "3000.00", notes = "Total Opening Amount.")
  private BigDecimal openingBalance;

  @ApiModelProperty(example = "CREDIT", notes = "CREDIT/DEBIT Type")
  private String openingBalanceCdType;

  @ApiModelProperty(notes = "List of transaction details")
  private List<ReconcileTransactionInfo> reconcileTransactionInfos;
}