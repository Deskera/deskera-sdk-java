package com.deskera.sdk.common.dto.account;

import com.deskera.sdk.common.util.constants.Constants;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;
import lombok.Data;
import org.springframework.util.Assert;

/**
 * This class store AccountGroup information
 */

@Data
public class AccountGroupDto {

  @ApiModelProperty(example = "1", notes = "AccountGroup ID.")
  private Long id;

  @NotEmpty
  @ApiModelProperty(example = "Apple", notes = "AccountGroup Name")
  private String name;

  @ApiModelProperty(example = "1", notes = "AccountGroup Parent id")
  private Long parentId;

  @ApiModelProperty(example = "3", notes = "Account Nature Id")
  private Long accountNatureId;

  @ApiModelProperty(example = "Apple", notes = "AccountGroup Parent name")
  private String parentName;

  @ApiModelProperty(example = "false", notes = "AccountGroup is deleted")
  private Boolean isDeleted;

  @ApiModelProperty(example = "1", notes = "Account Master")
  private Long accountMaster;

  @ApiModelProperty(example = "AG-0000001", notes = "Account Status")
  private String code;

  public void setName(final String name) {
    Assert.hasText(name, Constants.ACCOUNT_GROUP_REQUEST_NAME_EMPTY);
    this.name = name.trim();
  }
}
