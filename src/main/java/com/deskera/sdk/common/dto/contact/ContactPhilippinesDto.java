package com.deskera.sdk.common.dto.contact;

import com.deskera.sdk.common.dto.enums.contact.CustomerTypePhilippines;
import com.deskera.sdk.common.dto.enums.contact.VendorTypePhilippines;
import com.deskera.sdk.common.util.audit.IncludeInAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@EqualsAndHashCode(callSuper = true)
public class ContactPhilippinesDto extends AbstractContactDto {

  @IncludeInAudit
  @ApiModelProperty(example = "012-345-678-910", notes = "Philippines specific Contact VAT No.")
  private String vatNoPhilippines;

  @IncludeInAudit
  @ApiModelProperty(example = "Input VAT", notes = "Philippines specific Contact VAT Status")
  private String vatStatusPhilippines;

  @IncludeInAudit
  @ApiModelProperty(example = "Reason", notes = "Philippines specific Contact VAT Exemption Reason")
  private String vatExemptionReasonPhilippines;

  @IncludeInAudit
  @ApiModelProperty(example = "Normal(Corporate)", notes = "Customer Type")
  private CustomerTypePhilippines customerTypePhilippines;

  @IncludeInAudit
  @ApiModelProperty(example = "Normal(Corporate)", notes = "Vendor Type")
  private VendorTypePhilippines vendorTypePhilippines;

  @ApiModelProperty(example = "true", notes = "Make Contact as WHT applicable")
  private Boolean whtApplicablePhilippines;

  @IncludeInAudit
  @ApiModelProperty(example = "Services", notes = "BIR class determines the type of business")
  private String birClassPhilippines;

  @IncludeInAudit
  @ApiModelProperty(example = "Individual", notes = "BIR class determines the type of business")
  private String whtBusinessPhilippines;

  @JsonIgnore
  public void validate() {
  }
}
