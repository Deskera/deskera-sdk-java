package com.deskera.sdk.common.dto.asset.request;

import com.deskera.sdk.common.dto.asset.enums.DEPRECIATION_POSTING_STATUS;
import com.deskera.sdk.common.util.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.Month;
import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class DepreciationScheduleDto {

  @ApiModelProperty(example = "1", notes = "Id")
  private Long id;

  @NotNull
  @ApiModelProperty(example = "1", notes = "Asset Id")
  private Long assetId;

  @NotNull
  @ApiModelProperty(example = "2020", notes = "Fiscal year of depreciation period")
  private Integer fiscalYear;

  @NotNull
  @ApiModelProperty(example = "JANUARY", notes = "Fiscal month of depreciation period")
  private Month fiscalMonth;

  @NotNull
  @ApiModelProperty(example = "PENDING", notes = "Posting Status")
  private DEPRECIATION_POSTING_STATUS postingStatus;

  @NotNull
  @ApiModelProperty(example = "9999.99", notes = "Depreciation Amount")
  private BigDecimal amount;

  @JsonFormat(pattern = DateUtil.DD_MM_YYYY)
  @ApiModelProperty(example = "15-07-2020", notes = "Journal Entry Posting Date")
  private Date postingDate;

  @ApiModelProperty(example = "JE-0000001", notes = "Journal Entry Number")
  private String journalEntryNumber;

}
