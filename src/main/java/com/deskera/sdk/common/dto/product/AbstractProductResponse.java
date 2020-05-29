package com.deskera.sdk.common.dto.product;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import lombok.Data;

@Data
@JsonInclude(Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractProductResponse extends AbstractProductRequest {

  private Long id;
  private String productId;
  private Boolean active;
  private Boolean deleted;
}
