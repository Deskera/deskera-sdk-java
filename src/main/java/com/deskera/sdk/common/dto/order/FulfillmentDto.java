package com.deskera.sdk.common.dto.order;

import com.deskera.sdk.common.dto.FULFILLMENT_TYPE;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FulfillmentDto {

  private Integer sequence;
  private String fulfillmentCode;
  private String documentCode;
  private String documentType;

  @JsonProperty("fulfillmentItems")
  private List<FulfillmentItemDto> fulfillmentItemDtos;

  private String status;
  private Boolean autoFulfilled;
  private String fulfillmentDate;
  private String documentDate;
  private FULFILLMENT_TYPE fulfillmentType;
  private String warehouseCode;

}
