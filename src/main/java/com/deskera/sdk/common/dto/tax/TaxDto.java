package com.deskera.sdk.common.dto.tax;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.math.BigDecimal;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxDto {

  private Long id;
  private String name;
  private String taxCode;
  private String accountCode;
  private String accountName;
  private TAX_TYPE type;
  private String description;
  private BigDecimal percent;
  private String code;
  private String status;
  private boolean deleted;
  private Long tenantId;
  private TAX_CATEGORY category;

}
