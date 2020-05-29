package com.deskera.sdk.common.util.dto.error;

import com.deskera.sdk.common.util.exception.BadRequestException;
import com.deskera.sdk.common.util.exception.ServiceException;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.http.HttpStatus;

/**
 * This class contains the error details sent back to API caller.
 */
@Data
@NoArgsConstructor
public class ErrorResponse {

  /**
   * The time stamp.
   */
  @JsonIgnore
  private LocalDateTime timestamp;
  /**
   * The code.
   */
  private Integer code;
  /**
   * The error message.
   */
  private String errorMessage;
  /**
   * The debug message.
   */
  @JsonInclude(Include.NON_NULL)
  private String debugMessage;

  /**
   * The HTTP status.
   */
  private HttpStatus httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

  /**
   * The errors.
   */
  @JsonInclude(Include.NON_NULL)
  private List<ValidationError> errors; // To throw multiple error

  /**
   * Instantiates a new error response.
   *
   * @param serviceException the service exception
   */
  public ErrorResponse(final ServiceException serviceException) {
    this(serviceException.getLocalizedMessage(), serviceException,
        serviceException.getStatus());
  }

  /**
   * Instantiates a new error response.
   *
   * @param badRequest the service exception
   */
  public ErrorResponse(final BadRequestException badRequest) {
    this(badRequest.getLocalizedMessage(), badRequest,
        badRequest.getHttpStatus());
  }

  /**
   * Instantiates a new error response.
   *
   * @param theErrorMessage the error message
   * @param exception       the exception
   * @param theHttpStatus   the HTTP status
   */
  public ErrorResponse(final String theErrorMessage, final Throwable exception,
      final HttpStatus theHttpStatus) {
    this.code = theHttpStatus.value();
    this.errorMessage = theErrorMessage;
    this.debugMessage = exception.getLocalizedMessage();
    this.httpStatus = theHttpStatus;
    this.timestamp = LocalDateTime.now();
  }

  /**
   * Instantiates a new error response.
   *
   * @param theErrorMessage the the error message
   * @param sqlException    the SQL exception
   * @param theHttpStatus   the the HTTP status
   */
  public ErrorResponse(final String theErrorMessage, final SQLException sqlException,
      final HttpStatus theHttpStatus) {
    this.code = theHttpStatus.value();
    this.errorMessage =
        String.format("%s Vendor Code: %d, SQL State: %s, Error Message: %s", theErrorMessage,
            sqlException.getErrorCode(), sqlException.getSQLState(), sqlException.getMessage());
    this.debugMessage = sqlException.getLocalizedMessage();
    this.httpStatus = theHttpStatus;
    this.timestamp = LocalDateTime.now();
  }

  /**
   * Instantiates a new error response.
   *
   * @param theErrorMessage the the error message
   * @param exception       the exception
   * @param theHttpStatus   the the HTTP status
   * @param theErrors       the the errors
   */
  public ErrorResponse(final String theErrorMessage, final Exception exception,
      final HttpStatus theHttpStatus, final List<ValidationError> theErrors) {
    this.code = theHttpStatus.value();
    this.errorMessage = theErrorMessage;
    this.debugMessage = exception.getLocalizedMessage();
    this.httpStatus = theHttpStatus;
    this.timestamp = LocalDateTime.now();
    this.errors = theErrors;
  }

  @Override
  public String toString() {
    return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
  }
}
