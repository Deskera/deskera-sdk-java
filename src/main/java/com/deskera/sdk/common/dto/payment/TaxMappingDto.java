package com.deskera.sdk.common.dto.payment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.math.BigDecimal;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxMappingDto {

  private Long id;
  private String taxSeqCode;
  private String taxCode;
  private String taxType;
  private BigDecimal taxAmount;
  private BigDecimal taxRate;
  private BigDecimal taxableAmount;
}
