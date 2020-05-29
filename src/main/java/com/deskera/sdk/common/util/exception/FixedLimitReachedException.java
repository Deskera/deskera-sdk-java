package com.deskera.sdk.common.util.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The FixedLimitReached Exception.
 */
@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class FixedLimitReachedException extends ServiceException {


  /**
   * The Constant serialVersionUID.
   */
  private static final long serialVersionUID = -418514588885795898L;

  /**
   * The Constant HTTP_STATUS.
   */
  private static final HttpStatus HTTP_STATUS = HttpStatus.NOT_ACCEPTABLE;

  /**
   * Instantiates a new not acceptable exception.
   *
   * @param errorMessage the error message
   */
  public FixedLimitReachedException(final String errorMessage) {
    super(errorMessage, HTTP_STATUS);
  }

  /**
   * Instantiates a new not acceptable exception.
   *
   * @param throwable the throwable
   */
  public FixedLimitReachedException(final Throwable throwable) {
    super(throwable, HTTP_STATUS);
  }
}