package com.deskera.sdk.common.dto.asset.response;

import com.deskera.sdk.common.dto.asset.request.DepreciationScheduleDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import java.time.Month;
import java.util.Map;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AssetDepreciationResponse {

  @ApiModelProperty(notes = "Asset Id", example = "Computer")
  private Long assetId;

  @ApiModelProperty(notes = "Asset name", example = "Computer")
  private String asset;

  @ApiModelProperty(notes = "monthly schedule", dataType = "java.util.Map<java.time.Month, DepreciationScheduleDto>")
  private Map<Month, DepreciationScheduleDto> monthlySchedule;

  @ApiModelProperty(notes = "Total Amount for the asset", example = "2000.00")
  private BigDecimal totalAmount;

}
