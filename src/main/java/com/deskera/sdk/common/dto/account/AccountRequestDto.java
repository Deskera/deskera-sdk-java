package com.deskera.sdk.common.dto.account;

import com.deskera.sdk.common.dto.annotation.ImportProperty;
import com.deskera.sdk.common.util.constants.Constants;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import java.util.Objects;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.util.Assert;

/**
 * This class handles Account information
 */
@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountRequestDto {

  @ApiModelProperty(example = "1", notes = "Account ID", hidden = true)
  private Long id;

  @NotEmpty
  @ApiModelProperty(example = "SA", notes = "Account code")
  @ImportProperty(displayName = "Account Code", required = true)
  private String accountCode;

  @NotEmpty
  @ApiModelProperty(example = "Savings account", notes = "Account Name")
  @ImportProperty(displayName = "Account Name", required = true)
  private String name;

  @ApiModelProperty(example = "Savings account description", notes = "Account Description")
  @ImportProperty(displayName = "Account Description")
  private String description;

  @ApiModelProperty(example = "1", notes = "Account Group Id")
  private Long accountGroupId;

  @ApiModelProperty(example = "Sample Account Group", notes = "Account Group Name")
  @ImportProperty(displayName = "Account Group", required = true)
  private String accountGroupName;

  @ApiModelProperty(example = "Tax Code", notes = "Account Tax")
  @ImportProperty(displayName = "Tax Code")
  private String taxCode;

  @NotEmpty
  @ApiModelProperty(example = "SGD", notes = "Singapore Dollars")
  private String currency;

  @ApiModelProperty(example = "ACTIVE", notes = "Account Status", hidden = true)
  private String status;

  @ApiModelProperty(example = "false", notes = "Control Account Flag", hidden = true)
  private boolean controlAccount;

  @ApiModelProperty(example = "DEBIT", notes = "Opening balance Credit/Debit Type")
  private CREDIT_DEBIT_TYPE openingBalanceCdType;

  @ApiModelProperty(example = "{\"x\":\"1\",\"y\":\"some value\"}", notes = "custom field json")
  private Object customField;

  public void setName(final String name) {
    if(Objects.nonNull(name)) {
      Assert.hasText(name, Constants.ACCOUNT_REQUEST_NAME_EMPTY);
      this.name = name.trim();
    }
  }
}
