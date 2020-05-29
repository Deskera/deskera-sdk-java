package com.deskera.sdk.common.dto.auth;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class OAuth2AccessToken {

  @JsonProperty("access_token")
  private String accessToken;
  @JsonProperty("token_type")
  private String tokenType;
  @JsonProperty("refresh_token")
  private String refreshToken;
  @JsonProperty("expires_in")
  private float expiresIn;
  @JsonProperty("scope")
  private String scope;
  @JsonProperty("deskera-token")
  private String deskeraToken;
  @JsonProperty("deskera-refresh-token")
  private String deskeraRefreshToken;
}
