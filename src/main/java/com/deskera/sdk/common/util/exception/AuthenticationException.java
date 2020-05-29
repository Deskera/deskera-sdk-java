package com.deskera.sdk.common.util.exception;

import org.springframework.http.HttpStatus;

/**
 * Authentication exception.
 *
 */
public class AuthenticationException extends ServiceException {

  /**
   * The Constant serialVersionUID.
   */
  private static final long serialVersionUID = 7810158149075424445L;

  /**
   * The Constant HTTP_STATUS for UNAUTHORIZED request.
   */
  private static final HttpStatus HTTP_STATUS = HttpStatus.UNAUTHORIZED;

  /**
   * Instantiates a new authentication exception.
   *
   * @param errorMessage the error message
   */
  public AuthenticationException(final String errorMessage) {
    super(errorMessage, HTTP_STATUS);
  }

  /**
   * Instantiates a new authentication exception.
   *
   * @param throwable the throwable
   */
  public AuthenticationException(final Throwable throwable) {
    super(throwable, HTTP_STATUS);
  }
}
