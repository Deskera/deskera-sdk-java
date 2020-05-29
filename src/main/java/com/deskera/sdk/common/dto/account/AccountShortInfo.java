package com.deskera.sdk.common.dto.account;

import com.opencsv.bean.CsvBindByPosition;
import java.io.Serializable;
import lombok.Data;
import com.opencsv.bean.CsvBindByName;

/**
 * This class handles Account basic information
 */
@Data
public class AccountShortInfo implements Serializable {

  @CsvBindByName(column = "Account Code")
  @CsvBindByPosition(position = 0)
  private String code;

  @CsvBindByName(column = "Account Name")
  @CsvBindByPosition(position = 1)
  private String name;
  
  @CsvBindByName(column = "Group")
  @CsvBindByPosition(position = 2)
  private String accountGroup;

  @CsvBindByName(column = "Opening Balance")
  @CsvBindByPosition(position = 3)
  private String openingBalance;

  @CsvBindByName(column = "Opening Balance Type")
  @CsvBindByPosition(position = 4)
  private String openingBalanceType;

  @CsvBindByName(column = "Balance")
  @CsvBindByPosition(position = 5)
  private String balance;

  @CsvBindByName(column = "Currency")
  @CsvBindByPosition(position = 6)
  private String currency;

}
