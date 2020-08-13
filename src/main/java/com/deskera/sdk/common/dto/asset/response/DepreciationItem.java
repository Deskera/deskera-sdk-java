package com.deskera.sdk.common.dto.asset.response;

import com.deskera.sdk.common.util.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import java.util.Date;
import java.util.List;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepreciationItem {

    @ApiModelProperty(example = "1", notes = "depreciation schedule Id List")
    private List<Long> depScheduleIdList;

    @JsonFormat(pattern = DateUtil.DD_MM_YYYY)
    @ApiModelProperty(example = "15-01-2019", notes = "JE Date")
    private Date jeDate;

    @ApiModelProperty(example = "JE-0000001", notes = "JE Code")
    private String jeCode;

    @ApiModelProperty(dataType = "java.util.List", notes = "depreciationLineItems")
    private List<DepreciationLineItem> depreciationLineItems;

}
