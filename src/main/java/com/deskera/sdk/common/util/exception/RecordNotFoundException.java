package com.deskera.sdk.common.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Entity Not Found Exception.
 *
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class RecordNotFoundException extends ServiceException {

  /**
   * The Constant serialVersionUID.
   */
  private static final long serialVersionUID = -1082732770469410017L;

  /**
   * The Constant HTTP_STATUS.
   */
  private static final HttpStatus HTTP_STATUS = HttpStatus.NOT_FOUND;

  /**
   * Instantiates a new entity not found exception.
   *
   * @param errorMessage the error message
   */
  public RecordNotFoundException(final String errorMessage) {
    super(errorMessage, HTTP_STATUS);
  }

  /**
   * Instantiates a new entity not found exception.
   *
   * @param throwable the throwable
   */
  public RecordNotFoundException(final Throwable throwable) {
    super(throwable, HTTP_STATUS);
  }
}
