package com.deskera.sdk.common.dto.contact;

import com.deskera.sdk.common.dto.enums.contact.CustomerTypeIndia;
import com.deskera.sdk.common.dto.enums.contact.GstTreatmentIndia;
import com.deskera.sdk.common.dto.enums.contact.VendorTypeIndia;
import com.deskera.sdk.common.util.audit.IncludeInAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@EqualsAndHashCode(callSuper = true)
public class ContactIndiaDto extends AbstractContactDto {

  @IncludeInAudit
  @ApiModelProperty(example = "21AONPM8088Q211", notes = "Contact GSTIN")
  private String gstin;

  @IncludeInAudit
  @ApiModelProperty(example = "AONPM8088Q", notes = "Contact PAN")
  private String pan;

  @IncludeInAudit
  @ApiModelProperty(example = "UnregisteredBusiness", notes = "GST treatment")
  private GstTreatmentIndia gstTreatment;

  @IncludeInAudit
  @ApiModelProperty(example = "NA", notes = "Customer Type")
  private CustomerTypeIndia customerType;

  @IncludeInAudit
  @ApiModelProperty(example = "NA", notes = "Vendor Type")
  private VendorTypeIndia vendorType;

  @IncludeInAudit
  @ApiModelProperty(example = "1213454", notes = "Contact TDS Section to Tds Rate Id")
  private Long tdsSectionToTdsRateId;

  @ApiModelProperty(example = "true", notes = "Is resident?")
  private Boolean resident;

  @JsonIgnore
  public void validate() {
  }

}
