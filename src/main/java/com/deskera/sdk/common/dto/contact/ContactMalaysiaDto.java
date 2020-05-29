package com.deskera.sdk.common.dto.contact;

import com.deskera.sdk.common.util.audit.IncludeInAudit;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@EqualsAndHashCode(callSuper = true)
public class ContactMalaysiaDto extends AbstractContactDto {

  @IncludeInAudit
  @ApiModelProperty(example = "W10-0108-000000021", notes = "Contact Service Tax Registration No")
  private String serviceTaxRegNo;

  @IncludeInAudit
  @ApiModelProperty(example = "W10-0108-000000021", notes = "Contact Sales Tax Registration No")
  private String salesTaxRegNo;

  @JsonIgnore
  public void validate() {
  }

}
