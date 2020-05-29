package com.deskera.sdk.common.dto.invoice;

import com.deskera.sdk.common.dto.enums.RECURRING_FREQUENCY_TYPE;
import io.swagger.annotations.ApiModelProperty;
import javax.validation.constraints.NotNull;
import lombok.Data;

@Data
public class PurchaseInvoiceRecurringDetails {

  @ApiModelProperty(example = "2", notes = "ID")
  private Long id;

  @NotNull
  @ApiModelProperty(required = true, example = "1", notes = "Every x Days/Weeks/Months")
  private Integer recurrenceType;

  @NotNull
  @ApiModelProperty(required = true, example = "WEEK", notes = "Days, Weeks or Months")
  private RECURRING_FREQUENCY_TYPE recurrenceFrequency;

  @NotNull
  @ApiModelProperty(required = true, example = "1", notes = "Number of Invoices to be created")
  private Integer invoiceRecurringCount;

  @NotNull
  @ApiModelProperty(required = true, example = "25-10-2019", notes = "Recurrence End date")
  private String recurrenceEndDate;
}
