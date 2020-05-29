package com.deskera.sdk.common.dto.invoice;

import com.deskera.sdk.common.dto.enums.DOCUMENT_TYPE;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

@Data
public class KnockOffInfo implements Serializable {

  private Integer documentOrder;

  private DOCUMENT_TYPE documentType;

  private String documentCode;

  private Date documentDate;

  private BigDecimal amount;

  private BigDecimal exchangeRate;

  private String currency;
}
