package com.deskera.sdk.common.dto.enums.contact;

import com.deskera.sdk.common.dto.enums.Constants;
import java.util.HashMap;
import java.util.Map;

public enum TaxTypesCustomerIndonesia {
  TAX_CODE_CUSTOMER_01(Constants.NOT_COLLECTING_VAT_CUSTOMER),
  TAX_CODE_CUSTOMER_02(Constants.TREASURER_COLLECTOR_CUSTOMER),
  TAX_CODE_CUSTOMER_03(Constants.COLLECTOR_THAN_TREASURER_CUSTOMER),
  TAX_CODE_CUSTOMER_04(Constants.OTHER_VALUE_DPP_CUSTOMER),
  TAX_CODE_CUSTOMER_05(Constants.OTHER_SUBMISSIONS_CUSTOMER),
  TAX_CODE_CUSTOMER_06(Constants.VAT_NOT_CHARGED_CUSTOMER),
  TAX_CODE_CUSTOMER_07(Constants.VAT_EXEMPTED_CUSTOMER),
  TAX_CODE_CUSTOMER_08(Constants.ASSET_TRANSFER_CUSTOMER);

  private static final Map<String, TaxTypesCustomerIndonesia> lookup = new HashMap<>();

  static {
    for (TaxTypesCustomerIndonesia taxTypesCustomer : values()) {
      lookup.put(taxTypesCustomer.getValue(), taxTypesCustomer);
    }
  }

  private final String value;

  TaxTypesCustomerIndonesia(final String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

  public static TaxTypesCustomerIndonesia getByValue(final String value) {
    return lookup.get(value);
  }


}