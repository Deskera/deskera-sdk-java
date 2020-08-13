package com.deskera.sdk.common.client;

import com.deskera.sdk.common.dto.ENVIRONMENT;
import com.deskera.sdk.common.dto.account.AccountDto;
import com.deskera.sdk.common.dto.account.Accounts;
import com.deskera.sdk.common.util.constants.ApiConstants;
import java.util.Objects;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j2
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AccountsApiClient extends ApiClient {

  private String getAccountsApi;

  private static final String GET_ACCOUNT_BY_ID_FAILURE_MSG = "Could not get Accounts by ID";
  private static final String GET_ACCOUNT_FAILURE_MSG = "Could not get Accounts ";

  public AccountsApiClient() {
    super();
  }

  @PostConstruct
  private void init() {
    switch (environment) {
      case DEV:
        this.getAccountsApi = this.accountsBaseApiDev;
        break;
      case QA:
        this.getAccountsApi = this.accountsBaseApiQA;
        break;
      case PROD_US:
        this.getAccountsApi = this.accountsBaseApiProdUS;
        break;
      case STAGING:
        this.getAccountsApi = this.accountsBaseApiStaging;
        break;
      case PROD:
        this.getAccountsApi = this.accountsBaseApiProd;
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + environment);
    }
  }

  public AccountDto getById(final long id, final String accessToken) {
    final String endpoint = this.getEndpoint(this.getAccountsApi, id);
    final HttpEntity<String> httpEntity = this.createHttpEntityWithHeaders(accessToken);
    try {
      final ResponseEntity<AccountDto> responseEntity = (ResponseEntity<AccountDto>) this
          .createUrl(
              endpoint, httpEntity, AccountDto.class, HttpMethod.GET);
      if (!HttpStatus.OK.equals(responseEntity.getStatusCode()) || Objects
          .isNull(responseEntity.getBody())) {
        throw new HttpClientErrorException(responseEntity.getStatusCode(),
            GET_ACCOUNT_BY_ID_FAILURE_MSG);
      }
      return responseEntity.getBody();
    } catch (RestClientException restClientException) {
      throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
          restClientException.getMessage());
    }
  }

  public Accounts getAccounts(final String accessToken, final Integer limit, final Integer page) {
    final int newLimit;
    if (Objects.isNull(limit)) {
      newLimit = ApiConstants.DEFAULT_LIMIT_SIZE;
    } else {
      newLimit = limit;
    }

    final int newPageSize;

    if (Objects.isNull(page)) {
      newPageSize = ApiConstants.DEFAULT_PAGE_SIZE;
    } else {
      newPageSize = page;
    }

    final String endpoint =
        this.getEndpoint(this.getAccountsApi) + this
            .getParamFormattedString(limit, newLimit, page,
                newPageSize);
    final HttpEntity<String> httpEntity = this.createHttpEntityWithHeaders(accessToken);
    try {
      final ResponseEntity<Accounts> responseEntity = (ResponseEntity<Accounts>) this
          .createUrl(
              endpoint, httpEntity, Accounts.class, HttpMethod.GET);
      if (!HttpStatus.OK.equals(responseEntity.getStatusCode()) || Objects
          .isNull(responseEntity.getBody())) {
        throw new HttpClientErrorException(responseEntity.getStatusCode(),
            GET_ACCOUNT_FAILURE_MSG);
      }
      return responseEntity.getBody();
    } catch (RestClientException restClientException) {
      throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
          restClientException.getMessage());
    }
  }
}
