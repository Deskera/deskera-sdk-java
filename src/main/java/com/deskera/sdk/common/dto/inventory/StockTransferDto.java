package com.deskera.sdk.common.dto.inventory;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class StockTransferDto {

  @CsvBindByName(column = "Code")
  @CsvBindByPosition(position = 0)
  private String code;

  @CsvBindByName(column = "Source Warehouse")
  @CsvBindByPosition(position = 1)
  private String srcWarehouseCode;

  @CsvBindByName(column = "Destination Warehouse")
  @CsvBindByPosition(position = 2)
  private String destWarehouseCode;

  @CsvBindByName(column = "Notes")
  @CsvBindByPosition(position = 3)
  private String notes;

  @CsvBindByName(column = "Transfer Date")
  @CsvBindByPosition(position = 4)
  private Date transferDate;

  private List<StockTransferItemDto> stockTransferItems;

}
