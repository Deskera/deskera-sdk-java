package com.deskera.sdk.common.util.exception;

import org.springframework.http.HttpStatus;

/**
 * Generic application exception.
 *
 */
public class ApplicationException extends ServiceException {

  /**
   * The Constant serialVersionUID.
   */
  private static final long serialVersionUID = 3214888091928259104L;

  /**
   * The Constant HTTP_STATUS.
   */
  private static final HttpStatus HTTP_STATUS = HttpStatus.INTERNAL_SERVER_ERROR;

  /**
   * Instantiates a new application exception.
   *
   * @param errorMessage the error message
   */
  public ApplicationException(final String errorMessage) {
    super(errorMessage, HTTP_STATUS);
  }

  /**
   * Instantiates a new application exception.
   *
   * @param throwable the throwable
   */
  public ApplicationException(final Throwable throwable) {
    super(throwable, HTTP_STATUS);
  }
}
