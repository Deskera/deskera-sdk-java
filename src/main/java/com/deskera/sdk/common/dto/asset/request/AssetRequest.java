package com.deskera.sdk.common.dto.asset.request;

import com.deskera.sdk.common.dto.asset.enums.DEPRECIATION_CONVENTION;
import com.deskera.sdk.common.dto.asset.enums.DEPRECIATION_METHOD;
import com.deskera.sdk.common.util.date.DateUtil;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;

@Data
@EqualsAndHashCode
public class AssetRequest {

    @ApiModelProperty(example = "1", notes = "Id")
    private Long id;

    @NotNull
    @ApiModelProperty(example = "Computer", notes = "Asset Name")
    private String name;

    @ApiModelProperty(example = "ABCD123456", notes = "Serial Number")
    private String serialNumber;

    @ApiModelProperty(example = "Computer for developers", notes = "Asset Description")
    private String description;

    @NotNull
    @ApiModelProperty(example = "USD", notes = "Currency")
    private String currency;

    @NotNull
    @JsonFormat(pattern = DateUtil.DD_MM_YYYY)
    @ApiModelProperty(example = "20-06-2019", notes = "Purchase Date")
    private Date purchaseDate;

    @NotNull
    @ApiModelProperty(example = "9999.99", notes = "Purchase Price")
    private BigDecimal purchasePrice;

    @ApiModelProperty(example = "FA-0000001", notes = "Document Sequence Code")
    private String documentSequenceCode;

    @ApiModelProperty(example = "FA-0000000", notes = "Document Sequence Format")
    private String sequenceFormat;

    @ApiModelProperty(example = "false", notes = "Is this an Opening Asset")
    private boolean openingAsset;

    @ApiModelProperty(example = "1234.56", notes = "Opening Accumulated Depreciation")
    private BigDecimal openingAccumulatedDepreciation;

    @NotNull
    @ApiModelProperty(example = "1", notes = "Asset Group Id")
    private Long assetGroupId;

    @NotNull
    @JsonFormat(pattern = DateUtil.DD_MM_YYYY)
    @ApiModelProperty(example = "20-06-2019", notes = "Depreciation Start Date")
    private Date depreciationStartDate;

    @ApiModelProperty(example = "8765.43", notes = "Depreciation Threshold")
    private BigDecimal depreciationThreshold;

    @ApiModelProperty(example = "1234.56", notes = "Residual Value")
    private BigDecimal residualValue;

    @NotNull
    @ApiModelProperty(example = "STRAIGHT_LINE", notes = "Depreciation Method")
    private DEPRECIATION_METHOD depreciationMethod;

    @ApiModelProperty(example = "FULL_MONTH", notes = "Depreciation Convention")
    private DEPRECIATION_CONVENTION depreciationConvention;

    @ApiModelProperty(example = "66.66", notes = "Depreciation Rate")
    private BigDecimal depreciationRate;

    @ApiModelProperty(example = "1.50", notes = "Effective Life")
    private BigDecimal effectiveLife;

    @ApiModelProperty(example = "2.50", notes = "Declining Factor")
    private BigDecimal decliningFactor;

    @ApiModelProperty(example = "BUY-0000001", notes = "Expense Bill Code")
    private String expenseBillCode;

}
