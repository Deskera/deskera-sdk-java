package com.deskera.sdk.common.dto.asset.response;

import com.deskera.sdk.common.util.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FiscalPeriod {

  @NotNull
  @JsonFormat(pattern = DateUtil.DD_MM_YYYY)
  @ApiModelProperty(example = "15-01-2019", notes = "Start Date")
  private Date start;

  @NotNull
  @JsonFormat(pattern = DateUtil.DD_MM_YYYY)
  @ApiModelProperty(example = "14-02-2019", notes = "End Date")
  private Date end;
}
