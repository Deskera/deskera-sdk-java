package com.deskera.sdk.common.util.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception thrown in case an user is forbidden from invoking a method or an API.
 */
@ResponseStatus(value = HttpStatus.FORBIDDEN)
public class ForbiddenException extends ServiceException {

  /**
   * The Constant serialVersionUID.
   */
  private static final long serialVersionUID = -418514577885795898L;

  /**
   * The Constant HTTP_STATUS.
   */
  private static final HttpStatus HTTP_STATUS = HttpStatus.FORBIDDEN;

  /**
   * Instantiates a new bad request exception.
   *
   * @param errorMessage the error message
   */
  public ForbiddenException(final String errorMessage) {
    super(errorMessage, HTTP_STATUS);
  }

  /**
   * Instantiates a new bad request exception.
   *
   * @param throwable the throwable
   */
  public ForbiddenException(final Throwable throwable) {
    super(throwable, HTTP_STATUS);
  }
}
