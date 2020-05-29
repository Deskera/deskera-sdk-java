package com.deskera.sdk.common.dto.payment;


import com.deskera.sdk.common.dto.Address;
import com.deskera.sdk.common.dto.enums.PAYMENT_TYPE;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.math.BigDecimal;
import java.util.List;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class AbstractReceivePaymentDto<T extends AbstractReceivePaymentItemDto> {

  private Long id;
  private String code;
  private String jeCode;
  private String contactCode;
  private String contactName;
  private String currency;
  private BigDecimal exchangeRate;
  private String accountCodePayTo;
  private String accountName;
  private PAYMENT_TYPE paymentType;
  private String referenceNumber;
  private String referenceDate;
  private BigDecimal amount;
  private String documentDate;
  private String memo;
  private boolean deleted;
  private Long tenantId;
  private List<T> receivePaymentItemDtoList;
  private List<ReceivePaymentFeeDto> receivePaymentFeeDtoList;
  private Address shipFrom;
  private Address shipTo;
  private Address billTo;

}
