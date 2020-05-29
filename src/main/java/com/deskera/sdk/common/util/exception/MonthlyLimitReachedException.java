package com.deskera.sdk.common.util.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * The MonthlyLimitReached Exception.
 */
@ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
public class MonthlyLimitReachedException extends ServiceException {

  /**
   * The Constant serialVersionUID.
   */
  private static final long serialVersionUID = -418514577995795898L;

  /**
   * The Constant HTTP_STATUS.
   */
  private static final HttpStatus HTTP_STATUS = HttpStatus.NOT_ACCEPTABLE;

  /**
   * Instantiates a new not acceptable exception.
   *
   * @param errorMessage the error message
   */
  public MonthlyLimitReachedException(final String errorMessage) {
    super(errorMessage, HTTP_STATUS);
  }

  /**
   * Instantiates a new not acceptable exception.
   *
   * @param throwable the throwable
   */
  public MonthlyLimitReachedException(final Throwable throwable) {
    super(throwable, HTTP_STATUS);
  }
}