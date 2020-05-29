package com.deskera.sdk.common.util.audit;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuditTrailMessage {

  public static final String ACTION_CREATE = "create";
  public static final String ACTION_UPDATE = "update";
  public static final String ACTION_DELETE = "delete";

  private String module;

  private String action;

  private String message;

  private String recordCode;

  private List<AuditHelper.DiffObj> details;

}
