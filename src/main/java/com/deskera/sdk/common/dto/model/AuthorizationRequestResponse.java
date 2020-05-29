package com.deskera.sdk.common.dto.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
public class AuthorizationRequestResponse {
  private boolean isAuthorized;
  private String redirectUrl;
  private String state;
  private String code;
  private Long clientId;
}
