package com.deskera.sdk.common.dto.enums.contact;

import com.deskera.sdk.common.dto.enums.Constants;
import java.util.HashMap;
import java.util.Map;

public enum TaxTypesVendorIndonesia {
  TAX_CODE_VENDOR_01(Constants.NOT_COLLECTING_VAT_VENDOR),
  TAX_CODE_VENDOR_02(Constants.TREASURER_COLLECTOR_VENDOR),
  TAX_CODE_VENDOR_03(Constants.COLLECTOR_THAN_TREASURER_VENDOR),
  TAX_CODE_VENDOR_04(Constants.OTHER_VALUE_DPP_VENDOR),
  TAX_CODE_VENDOR_05(Constants.OTHER_SUBMISSIONS_VENDOR),
  TAX_CODE_VENDOR_06(Constants.VAT_NOT_CHARGED_VENDOR),
  TAX_CODE_VENDOR_07(Constants.VAT_EXEMPTED_VENDOR),
  TAX_CODE_VENDOR_08(Constants.ASSET_TRANSFER_VENDOR);


  private static final Map<String, TaxTypesVendorIndonesia> lookup = new HashMap<>();

  static {
    for (TaxTypesVendorIndonesia taxTypesVendor : values()) {
      lookup.put(taxTypesVendor.getValue(), taxTypesVendor);
    }
  }

  private final String value;

  TaxTypesVendorIndonesia(final String value) {
    this.value = value;
  }

  public String getValue() {
    return this.value;
  }

  public static TaxTypesVendorIndonesia getByValue(final String value) {
    return lookup.get(value);
  }


}