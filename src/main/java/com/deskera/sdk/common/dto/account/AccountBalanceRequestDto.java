package com.deskera.sdk.common.dto.account;

import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * This class handles Account information
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountBalanceRequestDto {

  @ApiModelProperty(example = "DEBIT", notes = "Credit/Debit Type")
  private CREDIT_DEBIT_TYPE cdType;

  @ApiModelProperty(example = "0", notes = "Opening Balance")
  private BigDecimal openingBalance;

  @ApiModelProperty(example = "1", notes = "Account Code")
  private String accountCode;
}
