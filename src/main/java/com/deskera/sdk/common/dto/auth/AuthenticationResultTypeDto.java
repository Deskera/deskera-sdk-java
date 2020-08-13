package com.deskera.sdk.common.dto.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthenticationResultTypeDto {

  @ApiModelProperty(example = "eyJraWQi...", notes = " The access token")
  private String accessToken;

  @ApiModelProperty(example = "eyJjdHki...", notes = " The refresh token")
  private String refreshToken;

  @ApiModelProperty(example = "eyJhbGci...", notes = " The id token")
  private String idToken;

  @ApiModelProperty(example = "3600", notes = "The expiration period of the authentication result in seconds.")
  private Integer expiresIn;

  @ApiModelProperty(example = "Bearer", notes = "The token type.")
  private String tokenType;

}

