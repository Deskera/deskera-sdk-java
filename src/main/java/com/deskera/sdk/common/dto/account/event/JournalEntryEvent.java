package com.deskera.sdk.common.dto.account.event;

import java.math.BigDecimal;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JournalEntryEvent {
  private long tenantId;
  private Map<String, BigDecimal> accountBalanceMap;
  private String message;
  private String errMsg;
}