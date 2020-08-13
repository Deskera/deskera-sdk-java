package com.deskera.sdk.common.dto.asset.request;

import com.deskera.sdk.common.util.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepreciationTxnRequest {

  @NotEmpty
  @ApiModelProperty(notes = "assetIds", dataType = "java.util.List")
  private List<Long> assetIds;

  @NotNull
  @JsonFormat(pattern = DateUtil.DD_MM_YYYY)
  @ApiModelProperty(example = "15-01-2020", notes = "Start date of depreciation period")
  private Date startDate;

  @NotNull
  @JsonFormat(pattern = DateUtil.DD_MM_YYYY)
  @ApiModelProperty(example = "14-02-2020", notes = "End date of depreciation period")
  private Date endDate;

}
