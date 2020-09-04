package com.deskera.sdk.common.dto.auth;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class RefreshTokenRequest extends NewTokenRequest {

  @ApiModelProperty(required = true, example = "123456", notes = "Tenant Id")
  private Long tenantId;

}