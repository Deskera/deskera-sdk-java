package com.deskera.sdk.common.dto.contact;

import com.deskera.sdk.common.dto.invoice.InvoiceResponseInfo;
import com.deskera.sdk.common.util.audit.IncludeInAudit;
import com.deskera.sdk.common.util.exception.BadRequestException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@EqualsAndHashCode(callSuper = true)
public class ContactDto extends AbstractContactDto {

  @ApiModelProperty(example = "abcd-efgh", notes = "Customer code in Avalara", hidden = true)
  private String avalaraCustomerCode;

  @IncludeInAudit
  @ApiModelProperty(example = "DHJEUK", notes = "Contact UEN")
  private String uen;

  @IncludeInAudit
  @ApiModelProperty(example = "123456", notes = "Tax number")
  private String taxNumber;


  @ApiModelProperty(example = "true", notes = "Denotes if customer is tax exempted")
  private Boolean taxExempted;

  @ApiModelProperty(example = "234s-few3-2422", notes = "Generated tax exemption number")
  private String taxExemptionNo;

  @ApiModelProperty(example = "Resale, Federal Agency", notes = "Tax exemption reason")
  private String taxExemptionReason;

  @ApiModelProperty(example = "u000:11::11293", notes = "Peppol ID")
  private String peppolId;

  private Map<String, List<InvoiceResponseInfo>> invoices;

  @JsonIgnore
  public void validate() {
    if (customerTaxExempted()) {
      if (Objects.isNull(getTaxExemptionReason())) {
        throw new BadRequestException(
            "Tax exemption reason is necessary for tax exempted customers.");
      }
    }
  }

  @JsonIgnore
  public boolean customerTaxExempted() {
    return (Objects.nonNull(this.getTaxExempted()) && this.getTaxExempted());
  }
}
