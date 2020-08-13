package com.deskera.sdk.common.dto.inventory;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
public class StockAdjustmentDto {


  @CsvBindByName(column = "Code")
  @CsvBindByPosition(position = 0)
  private String code;


  @CsvBindByName(column = "Warehouse Code")
  @CsvBindByPosition(position = 1)
  private String warehouseCode;


  @CsvBindByName(column = "Adjustment Date")
  @CsvBindByPosition(position = 2)
  private Date adjustmentDate;

  @CsvBindByName(column = "Adjustment Type")
  @CsvBindByPosition(position = 3)
  private ADJUSTMENT_TYPE adjustmentType;


  @CsvBindByName(column = "Adjustment Reason")
  @CsvBindByPosition(position = 4)
  private ADJUSTMENT_REASON adjustmentReason;


  @CsvBindByName(column = "Total Value")
  @CsvBindByPosition(position = 5)
  private BigDecimal totalValue;


  @CsvBindByName(column = "Notes")
  @CsvBindByPosition(position = 6)
  private String notes;

  @CsvBindByName(column = "Warehouse Name")
  @CsvBindByPosition(position = 7)
  private String warehouseName;

  private List<StockAdjustmentItemDto> stockAdjustmentItems;

}
