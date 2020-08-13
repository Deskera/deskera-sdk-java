package com.deskera.sdk.common.dto.asset.response;

import com.deskera.sdk.common.dto.account.CREDIT_DEBIT_TYPE;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class DepreciationLineItem {

    @ApiModelProperty(example = "100", notes = "Amount")
    private BigDecimal amount;

    @ApiModelProperty(example = "AC-0000001", notes = "Account code")
    private String accountCode;

    @ApiModelProperty(example = "Asset Account", notes = "Account Name")
    private String accountName;

    @ApiModelProperty(example = "CREDIT", notes = "credit debit type")
    private CREDIT_DEBIT_TYPE cdType;

}
