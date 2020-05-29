package com.deskera.sdk.common.dto.order;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;
import org.springframework.util.CollectionUtils;

@Data
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class FulfillmentRequest  extends FulfillmentDto {

  @JsonIgnore
  public boolean hasLineItems() {
    return (!CollectionUtils.isEmpty(getFulfillmentItemDtos()));
  }

  @JsonIgnore
  public boolean isRequestAutoFulfilled() {
    return Boolean.TRUE.equals(this.getAutoFulfilled());
  }

}
