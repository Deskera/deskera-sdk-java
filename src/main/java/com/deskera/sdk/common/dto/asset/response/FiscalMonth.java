package com.deskera.sdk.common.dto.asset.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import java.time.Month;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@EqualsAndHashCode(callSuper = false)
public class FiscalMonth extends FiscalPeriod {

  @ApiModelProperty(example = "JANUARY", dataType = "java.time.Month", notes = "Month name")
  private Month month;

}
