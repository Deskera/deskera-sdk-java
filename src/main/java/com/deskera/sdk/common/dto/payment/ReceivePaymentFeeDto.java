package com.deskera.sdk.common.dto.payment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.math.BigDecimal;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class ReceivePaymentFeeDto {

  private Long id;
  private String accountCode;
  private BigDecimal amount;
  private Long tenantId;

  @JsonIgnore
  private Long paymentId;
}
