package com.deskera.sdk.common.util.exception;


import com.deskera.sdk.common.util.dto.error.ErrorResponse;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Objects;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;


/**
 * Util class for Exception.
 */

@Log4j2
public class ExceptionUtil {

  final static ObjectMapper mapper = new ObjectMapper()
      .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

  /**
   * This method is used to print the stack trace of an exception as string.
   *
   * @param ex, object of Exception
   * @return sw, return printStackTrack of Exception as string
   */
  public static String getTraceAsString(final Exception ex) {
    final StringWriter sw = new StringWriter();
    final PrintWriter pw = new PrintWriter(sw);
    ex.printStackTrace(pw);
    return sw.toString();
  }

  /**
   * This method is used to resolve the Error response from HTTP API calls.
   *
   * @param ex, Exception
   * @return errorResponse, Object of ErrorResponse
   */
  public static ErrorResponse resolveErrorResponse(final Exception ex) {
    final String errorResponseBody = ((HttpClientErrorException) ex).getResponseBodyAsString();
    try {
      return mapper.readValue(errorResponseBody, ErrorResponse.class);
    } catch (final IOException e) {
      log.error(
          "Inter-service communication - could not resolve error response thrown by other service",
          e);
      return null;
    }
  }

  /**
   * This method is used to resolve the Error response from HTTP API calls and throw .
   *
   * @param ex
   * @return void
   */
  public static void resolveErrorResponseAndThrow(final Exception ex) {
    final ErrorResponse errorResponse = resolveErrorResponse(ex);

    if (Objects.isNull(errorResponse)) {
      throw new ApplicationException("Could not resolved error from API call.");
    }
    final String errorMsg = errorResponse.getErrorMessage();
    log.error("Inter-service communication resulted in an exception {}", errorResponse);
    switch (HttpStatus.resolve(errorResponse.getCode())) {
      case BAD_REQUEST:
        throw new BadRequestException(errorMsg);
      case UNAUTHORIZED:
        throw new UnauthorizedException(errorMsg);
      case FORBIDDEN:
        throw new ForbiddenException(errorMsg);
      case NOT_FOUND:
        throw new RecordNotFoundException(errorMsg);
      case INTERNAL_SERVER_ERROR:
        throw new ServiceException(errorMsg, HttpStatus.INTERNAL_SERVER_ERROR);
      default:
        throw new ApplicationException("Could not resolved error from API call.");
    }
  }
}
