package com.deskera.sdk.common.dto.contact;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@EqualsAndHashCode
public class ContactReportInfo {

  @ApiModelProperty(example = "C-001", notes = "Contact code", hidden = true)
  @CsvBindByName(column = "CONTACT CODE", required = true)
  @CsvBindByPosition(position = 1)
  private String code;

  @ApiModelProperty(example = "Sam", notes = "Contact name")
  @CsvBindByName(column = "CONTACT NAME", required = true)
  @CsvBindByPosition(position = 0)
  private String name;

  @ApiModelProperty(example = "ACTIVE", notes = "Contact status", hidden = true)
  @CsvBindByName(column = "STATUS", required = true)
  @CsvBindByPosition(position = 2)
  private String status;

  @ApiModelProperty(example = "200", notes = "They owe you", hidden = true)
  @CsvBindByName(column = "THEY OWE YOU", required = true)
  @CsvBindByPosition(position = 4)
  private String theyOweYou;

  @ApiModelProperty(example = "100", notes = "You owe them", hidden = true)
  @CsvBindByName(column = "YOU OWE THEM", required = true)
  @CsvBindByPosition(position = 3)
  private String youOweThem;
}
