package com.deskera.sdk.common.dto.contact;

import com.deskera.sdk.common.dto.enums.contact.RESIDENT_STATUS;
import com.deskera.sdk.common.dto.enums.contact.TaxTypesCustomerIndonesia;
import com.deskera.sdk.common.dto.enums.contact.TaxTypesVendorIndonesia;
import com.deskera.sdk.common.util.audit.IncludeInAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@EqualsAndHashCode(callSuper = true)
public class ContactIndonesiaDto extends AbstractContactDto {

  @ApiModelProperty(
      example = "123456789012345",
      notes = "NPWP No"
  )
  private Long npwpNumber;

  @IncludeInAudit
  @ApiModelProperty(example = "RESIDENT", notes = "Resident Status")
  private RESIDENT_STATUS residentStatus;

  @IncludeInAudit
  @ApiModelProperty(example = "TAX_CODE_VENDOR_01", notes = "Tax Types Vendor")
  private TaxTypesVendorIndonesia taxTypeVendor;

  @IncludeInAudit
  @ApiModelProperty(example = "TAX_CODE_CUSTOMER_01", notes = "Tax Types Customer")
  private TaxTypesCustomerIndonesia taxTypeCustomer;


  @JsonIgnore
  public void validate() {

  }

}
