package com.deskera.sdk.common.dto.account;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;
import lombok.Data;

@Data
public class BankAccountDto extends AccountDto implements Serializable {

  @ApiModelProperty(example = "123456", notes = "Bank Account No")
  private String bankNumber;

  @ApiModelProperty(example = "ABC Current Account", notes = "Bank Account Name")
  private String bankName;

  @ApiModelProperty(example = "Active", notes = "Connection Status")
  private Boolean connectStatus;
}
