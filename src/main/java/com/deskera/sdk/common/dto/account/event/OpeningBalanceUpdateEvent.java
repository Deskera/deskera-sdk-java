package com.deskera.sdk.common.dto.account.event;

import com.deskera.sdk.common.dto.account.AccountBalanceRequestDto;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;

@Data
public class OpeningBalanceUpdateEvent {

  private List<AccountBalanceRequestDto> accountBalanceList = new ArrayList<>();

}
