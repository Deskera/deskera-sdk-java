package com.deskera.sdk.common.dto.asset.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FiscalPeriodResponse extends FiscalPeriod {

  @ApiModelProperty(dataType = "java.util.List", notes = "Fiscal Months with timelines")
  private List<FiscalMonth> fiscalMonths;

}
