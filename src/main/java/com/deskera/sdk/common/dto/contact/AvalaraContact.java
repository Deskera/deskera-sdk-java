package com.deskera.sdk.common.dto.contact;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class AvalaraContact {

  private Integer id;

  @NotNull
  private Integer companyId;

  @NotEmpty
  private String customerCode;

  @NotEmpty
  private String name;

  @NotEmpty
  private String line1;

  @NotEmpty
  private String city;

  @NotEmpty
  private String postalCode;

  @NotEmpty
  private String country;

  @NotEmpty
  private String region;

  private String taxNumber;
}
