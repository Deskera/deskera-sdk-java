package com.deskera.sdk.common.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The Bad Request Exception.
 *
 */
@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class BadRequestException extends ServiceException {

  /**
   * The Constant serialVersionUID.
   */
  private static final long serialVersionUID = -418514577885795898L;

  /**
   * The Constant HTTP_STATUS.
   */
  private static final HttpStatus HTTP_STATUS = HttpStatus.BAD_REQUEST;

  /**
   * Instantiates a new bad request exception.
   *
   * @param errorMessage the error message
   */
  public BadRequestException(final String errorMessage) {
    super(errorMessage, HTTP_STATUS);
  }

  /**
   * Instantiates a new bad request exception.
   *
   * @param throwable the throwable
   */
  public BadRequestException(final Throwable throwable) {
    super(throwable, HTTP_STATUS);
  }
}
