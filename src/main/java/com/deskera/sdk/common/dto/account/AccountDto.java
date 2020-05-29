package com.deskera.sdk.common.dto.account;

import com.deskera.sdk.common.dto.invoice.constants.ApiConstants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import java.math.BigDecimal;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * This class handles Account information
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountDto implements Serializable {

  @ApiModelProperty(example = "1", notes = "Account ID.")
  private Long id;

  @NotEmpty
  @ApiModelProperty(example = "SA", notes = "Account code")
  private String accountCode;

  @NotEmpty
  @ApiModelProperty(example = "Savings account", notes = "Account Name")
  private String name;

  @NotEmpty
  @ApiModelProperty(example = "", notes = "Account code")
  private String code;

  @ApiModelProperty(example = "Savings account", notes = "Account Description")
  private String description;

  @ApiModelProperty(example = "", notes = "Account Tax")
  private String taxCode;

  @NotEmpty
  @ApiModelProperty(example = "", notes = "Account Currency")
  private String currency;

  @NotEmpty
  @ApiModelProperty(example = "", notes = "Account group")
  private String accountGroup;

  @ApiModelProperty(example = "", notes = "Account group")
  private String accountGroupId;

  @ApiModelProperty(example = "ACTIVE", notes = "Account Status")
  private String status;

  @ApiModelProperty(example = "999.99", notes = "Opening Balance Amount")
  private BigDecimal openingBalance;

  @ApiModelProperty(example = "999.99", notes = "Balance Amount")
  private BigDecimal balance;

  @ApiModelProperty(example = "999.99", notes = "Summation of Opening Balance and Balance")
  private BigDecimal totalBalance;

  @ApiModelProperty(example = "999.99", notes = "Summation of Opening Balance and Balance with Nature")
  private BigDecimal totalCOABalance;

  @ApiModelProperty(example = "DEBIT", notes = "Opening balance Credit/Debit Type")
  private String openingBalanceCdType;

  @ApiModelProperty(example = "ASSET", notes = "Account Nature")
  private String accountNature;

  @ApiModelProperty(example = "{\"x\":\"1\",\"y\":\"some value\"}", notes = "custom field json")
  private Object customField;

  public BigDecimal getTotalBalance() {
    if (CREDIT_DEBIT_TYPE.CREDIT.name()
        .equals(this.getOpeningBalanceCdType())) {
      return this.getBalance().subtract(this.getOpeningBalance());
    }
    return this.getBalance().add(this.getOpeningBalance());
  }

  public BigDecimal getTotalCOABalance() {
    if (!(ApiConstants.NATURE_ASSET.equalsIgnoreCase(this.getAccountNature()))
        && !(ApiConstants.NATURE_EXPENSES.equalsIgnoreCase(this.getAccountNature()))) {
      return this.getTotalBalance().negate();
    } else {
      return this.getTotalBalance();
    }
  }
}
