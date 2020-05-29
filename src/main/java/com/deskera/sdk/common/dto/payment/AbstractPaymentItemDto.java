package com.deskera.sdk.common.dto.payment;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import lombok.Data;


@Data
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AbstractPaymentItemDto implements Serializable {

  private Long id;
  private String documentType;
  private String documentCode;
  private String description;
  private BigDecimal exchangeRate;
  private String taxCode;
  private BigDecimal taxAmount;
  private BigDecimal paymentAmount;
  private Long tenantId;
  private String accountName;
  private List<TaxMappingDto> taxList = new ArrayList<>();

  @JsonIgnore
  private Long paymentId;

}
