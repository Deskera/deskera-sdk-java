/*
package com.deskera.sdk.common.dto;


import com.deskera.sdk.common.util.enums.Application;
import com.deskera.sdk.common.util.exception.UnauthorizedException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserSession {

  public static final String UNAUTHORIZED_USER_ERR = "Could not validate the user";

  private Long id;
  private Long tenantId;
  private String email;
  private String name;
  private Map<String, List<String>> applicationPermissions;
  private String token;
  private Map<Application, Map<String, Limit>> userLimitMap;

  public void setUserSession(final String accessToken) throws IOException {
    if (StringUtils.isEmpty(accessToken)) {
      throw new UnauthorizedException(UNAUTHORIZED_USER_ERR);
    }
    final UserDetails userDetails = TokenHelper.decode(accessToken);
    if (!ObjectUtils.allNotNull(userDetails.getUserId(), userDetails.getTenantId())) {
      throw new UnauthorizedException(UNAUTHORIZED_USER_ERR);
    }

    this.setId(userDetails.getUserId());
    this.setTenantId(userDetails.getTenantId());
    this.setEmail(userDetails.getEmail());
    this.setName(userDetails.getName());
    this.setToken(accessToken);
  }
}*/
