package com.deskera.sdk.common.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The ConflictException.
 *
 */
@ResponseStatus(value = HttpStatus.CONFLICT)
public class ConflictException extends ServiceException {

  /**
   * The Constant serialVersionUID.
   */
  private static final long serialVersionUID = 8533333646842447026L;

  /**
   * The Constant HTTP_STATUS.
   */
  private static final HttpStatus HTTP_STATUS = HttpStatus.CONFLICT;

  /**
   * Instantiates a new ConflictException.
   *
   * @param errorMessage the error message
   */
  public ConflictException(final String errorMessage) {
    super(errorMessage, HTTP_STATUS);
  }

  /**
   * Instantiates a new ConflictException.
   *
   * @param throwable the throwable
   */
  public ConflictException(final Throwable throwable) {
    super(throwable, HTTP_STATUS);
  }
}
