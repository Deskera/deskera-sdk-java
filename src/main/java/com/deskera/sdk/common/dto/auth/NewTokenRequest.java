package com.deskera.sdk.common.dto.auth;

import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class NewTokenRequest {

  @ApiModelProperty(required = true, example = "+65-1234-5678", notes = "Username")
  private String userName;

  @NotEmpty
  @ApiModelProperty(required = true, example = "eyJjdHkiOiJKV1QiLCJlbmMiOiJ..", notes = "Refresh token")
  private String refreshToken;
}