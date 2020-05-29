package com.deskera.sdk.common.dto.account;

import java.math.BigDecimal;
import java.util.Date;

public interface ReconcileTransactionTuple {

  Date getDate();

  String getContactCode();

  String getContactName();

  String getReferenceNumber();

  Date getReferenceDate();

  String getJeCode();

  BigDecimal getAmount();

  String getDocumentCode();

  String getDocumentType();

  String getCdType();
}