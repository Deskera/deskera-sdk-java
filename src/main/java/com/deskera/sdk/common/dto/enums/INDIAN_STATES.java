package com.deskera.sdk.common.dto.enums;

/**
 * Enum class for indian GST States.
 *
 * @Date: 29/01/20
 * @Time: 12.35
 */
public enum INDIAN_STATES {

  AN("Andaman & Nicobar Islands","Andaman & Nicobar Islands","35"),
  AP("Andhra Pradesh","Andhra Pradesh","28"),
  APN("Andhra Pradesh(New)","Andhra Pradesh(New)","37"),
  AR("Arunachal Pradesh","Arunachal Pradesh","12"),
  AS("Assam","Assam","18"),
  BR("Bihar","Bihar","10"),
  CH("Chandigarh","Chandigarh","04"),
  CT("Chhattisgarh","Chhattisgarh","22"),
  DN("Dadra & Nagar Haveli","Dadra & Nagar Haveli","26"),
  DD("Daman & Diu","Daman & Diu","25"),
  DL("Delhi","Delhi","07"),
  GA("Goa","Goa","30"),
  GJ("Gujarat","Gujarat","24"),
  HR("Haryana","Haryana","06"),
  HP("Himachal Pradesh","Himachal Pradesh","02"),
  JK("Jammu & Kashmir","Jammu & Kashmir","01"),
  JH("Jharkhand","Jharkhand","20"),
  KA("Karnataka","Karnataka","29"),
  KL("Kerala","Kerala","32"),
  LD("Lakshadweep","Lakshadweep","31"),
  MP("Madhya Pradesh","Madhya Pradesh","23"),
  MH("Maharashtra","Maharashtra","27"),
  MN("Manipur","Manipur","14"),
  ML("Meghalaya","Meghalaya","17"),
  MZ("Mizoram","Mizoram","15"),
  NL("Nagaland","Nagaland","13"),
  OR("Orissa","Orissa","21"),
  PY("Puducherry","Puducherry","34"),
  PB("Punjab","Punjab","03"),
  RJ("Rajasthan","Rajasthan","08"),
  SK("Sikkim","Sikkim","11"),
  TN("Tamil Nadu","Tamil Nadu","33"),
  TG("Telangana","Telangana","36"),
  TR("Tripura","Tripura","16"),
  UP("Uttar Pradesh","Uttar Pradesh","09"),
  UT("Uttarakhand","Uttarakhand","05"),
  WB("West Bengal","West Bengal","19");

  private String code;
  private String name;
  private String stateCode;

  INDIAN_STATES(final String code, final String name, final String stateCode) {
    this.code = code;
    this.name = name;
    this.stateCode = stateCode;
  }

  public String getCode() {
    return code;
  }

}
