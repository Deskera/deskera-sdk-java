package com.deskera.sdk.common.util.dto.error;

import lombok.Data;

/**
 * This class holds validation error information.
 *
 */
@Data
public class ValidationError {

  private String field;
  private String error;
}
