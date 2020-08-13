package com.deskera.sdk.common.client;

import com.deskera.sdk.common.dto.ENVIRONMENT;
import com.deskera.sdk.common.dto.asset.request.AssetGroupRequest;
import com.deskera.sdk.common.dto.asset.request.AssetRequest;
import com.deskera.sdk.common.dto.asset.request.DepreciationTxnRequest;
import com.deskera.sdk.common.dto.asset.response.AssetDepreciationResponse;
import com.deskera.sdk.common.dto.asset.response.AssetGroupResponse;
import com.deskera.sdk.common.dto.asset.response.AssetResponse;
import com.deskera.sdk.common.dto.asset.response.DepreciationPostPreviewResponse;
import com.deskera.sdk.common.dto.asset.response.DepreciationRollbackPreviewResponse;
import com.deskera.sdk.common.dto.asset.response.DepreciationTxnResponse;
import com.deskera.sdk.common.dto.asset.response.FiscalPeriodResponse;
import com.deskera.sdk.common.dto.asset.response.NetBookValueResponse;
import com.deskera.sdk.common.util.RestResponsePage;
import com.deskera.sdk.common.util.constants.ApiConstants;
import com.deskera.sdk.common.util.constants.Constants;
import com.deskera.sdk.common.util.exception.BadRequestException;
import com.deskera.sdk.common.util.exception.ExceptionUtil;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import javax.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Log4j2
@Data
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AssetApiClient extends ApiClient {

  private final static String AssetGroupAPI = "/group";
  private static final String ASSET_GROUP_STATUS_ENDPOINT = "/status";
  private static final String SUMMARY = "/summary";
  private static final String SUMMARY_NBV = SUMMARY + "/nbv";
  private static final String DEPRECIATION_SCHEDULE = "/depreciation-schedule";
  private static final String FISCAL_PERIOD = "/fiscal-period";
  private static final String POST_PREVIEW = "/post-preview";
  private static final String ROLLBACK_PREVIEW = "/rollback-preview";
  private static final String POST = "/post";
  private static final String ROLLBACK = "/rollback";
  private static final String ACTIVE = "active";
  private static final String START_DATE = "startDate";
  private static final String END_DATE = "endDate";
  private static final String YEAR = "year";
  private String baseURL;

  public AssetApiClient(final String oAuth2PartnerClientId, final RestTemplate restTemplate,
      final String oAuth2PartnerSecret, final String oAuth2PartnerRedirectUrl,
      final ENVIRONMENT environment) {
    this.oAuth2PartnerClientId = oAuth2PartnerClientId;
    this.restTemplate = restTemplate;
    this.oAuth2PartnerSecret = oAuth2PartnerSecret;
    this.oAuth2PartnerRedirectUrl = oAuth2PartnerRedirectUrl;
    this.environment = environment;
  }

  public AssetApiClient() {
    super();
  }

  @PostConstruct
  private void init() {
    switch (environment) {
      case DEV:
        this.baseURL = this.assetBaseApiDev;
        break;
      case QA:
        this.baseURL = this.assetBaseApiQA;
        break;
      case STAGING:
        this.baseURL = this.assetBaseApiStaging;
        break;
      case PROD:
        this.baseURL = this.assetBaseApiProd;
        break;
      case PROD_US:
        this.baseURL = this.assetBaseApiProdUS;
        break;
      default:
        throw new IllegalStateException("Unexpected value: " + environment);
    }
  }

  public RestResponsePage<AssetGroupResponse> getAssetGroups(final String accessToken,
      final String queryString) {
    String getAssetGroupQuery = this.getBaseURL() + AssetGroupAPI;
    if (StringUtils.isNotBlank(queryString)) {
      getAssetGroupQuery =
          getAssetGroupQuery + Constants.REQUEST_SEPARATOR + this.decodeUrlString(queryString);
    }
    final HttpEntity<String> httpEntity = this.createHttpEntityWithHeaders(accessToken);
    final ParameterizedTypeReference<RestResponsePage<AssetGroupResponse>> responseType = new
        ParameterizedTypeReference<RestResponsePage<AssetGroupResponse>>() {
        };
    try {
      final ResponseEntity<RestResponsePage<AssetGroupResponse>> exchange = this.restTemplate
          .exchange(getAssetGroupQuery, HttpMethod.GET, httpEntity, responseType);
      return exchange.getBody();
    } catch (final Exception exception) {
      ExceptionUtil.resolveErrorResponseAndThrow(exception);
      return null;
    }
  }

  public AssetGroupResponse getAssetGroupById(final String accessToken, final long id) {
    final String getAssetGroupByIdURL = this.getBaseURL() + AssetGroupAPI + ApiConstants.URL_SEPERATOR + id;
    final HttpEntity<String> httpEntity = this.createHttpEntityWithHeaders(accessToken);
    try {
      final ResponseEntity<AssetGroupResponse> responseEntity = this.restTemplate
              .exchange(getAssetGroupByIdURL, HttpMethod.GET, httpEntity, AssetGroupResponse.class);
      return responseEntity.getBody();
    } catch (final Exception exception) {
      ExceptionUtil.resolveErrorResponseAndThrow(exception);
      return null;
    }
  }

  public AssetGroupResponse createAssetGroup(final String accessToken,
      final AssetGroupRequest assetGroupRequest) {
    final String AssetGroupCreateURL = this.getBaseURL() + AssetGroupAPI;
    final HttpEntity<AssetGroupRequest> httpEntity = (HttpEntity<AssetGroupRequest>) this
        .getHttpEntity(assetGroupRequest, accessToken);
    try {
      final ResponseEntity<AssetGroupResponse> responseEntity = this.restTemplate
          .exchange(AssetGroupCreateURL, HttpMethod.POST, httpEntity, AssetGroupResponse.class);
      return responseEntity.getBody();
    } catch (final Exception exception) {
      ExceptionUtil.resolveErrorResponseAndThrow(exception);
      return null;
    }
  }

  public AssetGroupResponse updateAssetGroup(final String accessToken, final long id,
                                             final AssetGroupRequest assetGroupRequest) {
    final String assetGroupUpdateURL = this.getBaseURL() + AssetGroupAPI + ApiConstants.URL_SEPERATOR + id;
    final HttpEntity<AssetGroupRequest> httpEntity = (HttpEntity<AssetGroupRequest>) this
            .getHttpEntity(assetGroupRequest, accessToken);
    try {
      final ResponseEntity<AssetGroupResponse> responseEntity = this.restTemplate
              .exchange(assetGroupUpdateURL, HttpMethod.PUT, httpEntity, AssetGroupResponse.class);
      return responseEntity.getBody();
    } catch (final Exception exception) {
      ExceptionUtil.resolveErrorResponseAndThrow(exception);
      return null;
    }
  }

  public void deleteAssetGroupById(final String accessToken, final long id) {
    final String getAssetGroupByIdURL = this.getBaseURL() + AssetGroupAPI + ApiConstants.URL_SEPERATOR + id;
    final HttpEntity<String> httpEntity = this.createHttpEntityWithHeaders(accessToken);
    try {
      final ResponseEntity<Void> responseEntity = this.restTemplate
              .exchange(getAssetGroupByIdURL, HttpMethod.DELETE, httpEntity, Void.class);
    } catch (final Exception exception) {
      ExceptionUtil.resolveErrorResponseAndThrow(exception);
    }
  }

  public void updateAssetGroupStatus(final String accessToken, final long id, final boolean active) {
    final String updateAssetGroupStatusUrlWithQuery = this.getBaseURL() + AssetGroupAPI + ASSET_GROUP_STATUS_ENDPOINT +
            ApiConstants.URL_SEPERATOR + id + Constants.REQUEST_SEPARATOR + ACTIVE + Constants.EQUALS + active;
    final HttpEntity<String> httpEntity = this.createHttpEntityWithHeaders(accessToken);
    try {
      this.restTemplate.setRequestFactory(new HttpComponentsClientHttpRequestFactory());
      final ResponseEntity<Void> responseEntity = this.restTemplate
              .exchange(updateAssetGroupStatusUrlWithQuery, HttpMethod.PATCH, httpEntity, Void.class);
    } catch (final Exception exception) {
      ExceptionUtil.resolveErrorResponseAndThrow(exception);
    }
  }

  public RestResponsePage<AssetResponse> getAssets(final String accessToken,
                                                   final String queryString) {
    String getAssetQuery = this.getBaseURL();
    if (StringUtils.isNotBlank(queryString)) {
      getAssetQuery = getAssetQuery + Constants.REQUEST_SEPARATOR +
          this.decodeUrlString(queryString);
    }
    final HttpEntity<String> httpEntity = this.createHttpEntityWithHeaders(accessToken);
    final ParameterizedTypeReference<RestResponsePage<AssetResponse>> responseType = new
            ParameterizedTypeReference<RestResponsePage<AssetResponse>>() {
            };
    try {
      final ResponseEntity<RestResponsePage<AssetResponse>> exchange = this.restTemplate
              .exchange(getAssetQuery, HttpMethod.GET, httpEntity, responseType);
      return exchange.getBody();
    } catch (final Exception exception) {
      ExceptionUtil.resolveErrorResponseAndThrow(exception);
      return null;
    }
  }

  public AssetResponse getAssetById(final String accessToken, final long id) {
    final String getAssetByIdURL = this.getBaseURL() + ApiConstants.URL_SEPERATOR + id;
    final HttpEntity<String> httpEntity = this.createHttpEntityWithHeaders(accessToken);
    try {
      final ResponseEntity<AssetResponse> responseEntity = this.restTemplate
              .exchange(getAssetByIdURL, HttpMethod.GET, httpEntity, AssetResponse.class);
      return responseEntity.getBody();
    } catch (final Exception exception) {
      ExceptionUtil.resolveErrorResponseAndThrow(exception);
      return null;
    }
  }

  public AssetResponse createAsset(final String accessToken, final AssetRequest assetRequest) {
    final String assetCreateURL = this.getBaseURL();
    final HttpEntity<AssetRequest> httpEntity = (HttpEntity<AssetRequest>) this
            .getHttpEntity(assetRequest, accessToken);
    try {
      final ResponseEntity<AssetResponse> responseEntity = this.restTemplate
              .exchange(assetCreateURL, HttpMethod.POST, httpEntity, AssetResponse.class);
      return responseEntity.getBody();
    } catch (final Exception exception) {
      ExceptionUtil.resolveErrorResponseAndThrow(exception);
      return null;
    }
  }

  public AssetResponse updateAsset(final String accessToken, final long id,
                                   final AssetRequest assetRequest) {
    final String assetUpdateURL = this.getBaseURL() + ApiConstants.URL_SEPERATOR + id;
    final HttpEntity<AssetRequest> httpEntity = (HttpEntity<AssetRequest>) this
            .getHttpEntity(assetRequest, accessToken);
    try {
      final ResponseEntity<AssetResponse> responseEntity = this.restTemplate
              .exchange(assetUpdateURL, HttpMethod.PUT, httpEntity, AssetResponse.class);
      return responseEntity.getBody();
    } catch (final Exception exception) {
      ExceptionUtil.resolveErrorResponseAndThrow(exception);
      return null;
    }
  }

  public void deleteAssetById(final String accessToken, final long id) {
    final String deleteAssetByIdURL = this.getBaseURL() + ApiConstants.URL_SEPERATOR + id;
    final HttpEntity<String> httpEntity = this.createHttpEntityWithHeaders(accessToken);
    try {
      final ResponseEntity<Void> responseEntity = this.restTemplate
              .exchange(deleteAssetByIdURL, HttpMethod.DELETE, httpEntity, Void.class);
    } catch (final Exception exception) {
      ExceptionUtil.resolveErrorResponseAndThrow(exception);
    }
  }

  public NetBookValueResponse getTotalNetBookValue(final String accessToken,
      final String queryString) {
    final String getNetBookValueURL =
        this.getBaseURL() + SUMMARY_NBV + Constants.REQUEST_SEPARATOR + queryString;
    final HttpEntity<String> httpEntity = this.createHttpEntityWithHeaders(accessToken);
    try {
      final ResponseEntity<NetBookValueResponse> responseEntity = this.restTemplate
          .exchange(getNetBookValueURL, HttpMethod.GET, httpEntity, NetBookValueResponse.class);
      return responseEntity.getBody();
    } catch (final Exception exception) {
      log.info("exception occurred: " + exception.getClass().getName());
      log.error(exception);
      ExceptionUtil.resolveErrorResponseAndThrow(exception);
      return null;
    }
  }

  public RestResponsePage<AssetDepreciationResponse> getDepreciationSchedules(
      final String accessToken,
      final String queryString) {
    String getDepreciationSchedulesURL = this.getBaseURL() + DEPRECIATION_SCHEDULE;
    if (StringUtils.isNotBlank(queryString)) {
      getDepreciationSchedulesURL +=
          Constants.REQUEST_SEPARATOR+ this
              .decodeUrlString(queryString);
    }
    final HttpEntity<String> httpEntity = this.createHttpEntityWithHeaders(accessToken);
    final ParameterizedTypeReference<RestResponsePage<AssetDepreciationResponse>> responseType = new
        ParameterizedTypeReference<RestResponsePage<AssetDepreciationResponse>>() {
        };
    try {
      final ResponseEntity<RestResponsePage<AssetDepreciationResponse>> exchange = this.restTemplate
          .exchange(getDepreciationSchedulesURL, HttpMethod.GET, httpEntity, responseType);
      return exchange.getBody();
    } catch (final Exception exception) {
      ExceptionUtil.resolveErrorResponseAndThrow(exception);
      return null;
    }
  }

  public FiscalPeriodResponse getFiscalPeriod(final String accessToken, final Integer year) {
    String getFiscalPeriodURL =
        this.getBaseURL() + DEPRECIATION_SCHEDULE + FISCAL_PERIOD + Constants.REQUEST_SEPARATOR
            + YEAR + Constants.EQUALS + year;
    final HttpEntity<String> httpEntity = this.createHttpEntityWithHeaders(accessToken);
    try {
      final ResponseEntity<FiscalPeriodResponse> exchange = this.restTemplate
          .exchange(getFiscalPeriodURL, HttpMethod.GET, httpEntity, FiscalPeriodResponse.class);
      return exchange.getBody();
    } catch (final Exception exception) {
      ExceptionUtil.resolveErrorResponseAndThrow(exception);
      return null;
    }
  }

  public DepreciationPostPreviewResponse getDepreciationPostPreview(final String accessToken,
      final DepreciationTxnRequest depreciationTxnRequest) {
    final String requestURL = this.getBaseURL() + DEPRECIATION_SCHEDULE + POST_PREVIEW;
    final HttpEntity<DepreciationTxnRequest> httpEntity = (HttpEntity<DepreciationTxnRequest>) this
        .getHttpEntity(depreciationTxnRequest, accessToken);
    try {
      final ResponseEntity<DepreciationPostPreviewResponse> responseEntity = this.restTemplate
          .exchange(requestURL, HttpMethod.POST, httpEntity, DepreciationPostPreviewResponse.class);
      return responseEntity.getBody();
    } catch (final Exception exception) {
      ExceptionUtil.resolveErrorResponseAndThrow(exception);
      return null;
    }
  }

  public DepreciationRollbackPreviewResponse getDepreciationRollbackPreview(
      final String accessToken, final DepreciationTxnRequest depreciationTxnRequest) {
    final String requestURL = this.getBaseURL() + DEPRECIATION_SCHEDULE + ROLLBACK_PREVIEW;
    final HttpEntity<DepreciationTxnRequest> httpEntity = (HttpEntity<DepreciationTxnRequest>) this
        .getHttpEntity(depreciationTxnRequest, accessToken);
    try {
      final ResponseEntity<DepreciationRollbackPreviewResponse> responseEntity = this.restTemplate
          .exchange(requestURL, HttpMethod.POST, httpEntity,
              DepreciationRollbackPreviewResponse.class);
      return responseEntity.getBody();
    } catch (final Exception exception) {
      ExceptionUtil.resolveErrorResponseAndThrow(exception);
      return null;
    }
  }

  public DepreciationTxnResponse postDepreciation(final String accessToken,
      final DepreciationTxnRequest depreciationTxnRequest) {
    final String requestURL = this.getBaseURL() + DEPRECIATION_SCHEDULE + POST;
    final HttpEntity<DepreciationTxnRequest> httpEntity = (HttpEntity<DepreciationTxnRequest>) this
        .getHttpEntity(depreciationTxnRequest, accessToken);
    try {
      final ResponseEntity<DepreciationTxnResponse> responseEntity = this.restTemplate
          .exchange(requestURL, HttpMethod.POST, httpEntity, DepreciationTxnResponse.class);
      return responseEntity.getBody();
    } catch (final Exception exception) {
      log.error(exception);
      ExceptionUtil.resolveErrorResponseAndThrow(exception);
      return null;
    }
  }

  public DepreciationTxnResponse rollbackDepreciation(final String accessToken,
      final DepreciationTxnRequest depreciationTxnRequest) {
    final String requestURL = this.getBaseURL() + DEPRECIATION_SCHEDULE + ROLLBACK;
    final HttpEntity<DepreciationTxnRequest> httpEntity = (HttpEntity<DepreciationTxnRequest>) this
        .getHttpEntity(depreciationTxnRequest, accessToken);
    try {
      final ResponseEntity<DepreciationTxnResponse> responseEntity = this.restTemplate
          .exchange(requestURL, HttpMethod.POST, httpEntity, DepreciationTxnResponse.class);
      return responseEntity.getBody();
    } catch (final Exception exception) {
      log.error(exception);
      ExceptionUtil.resolveErrorResponseAndThrow(exception);
      return null;
    }
  }

  private String decodeUrlString(final String query) {
    try {
      return URLDecoder
          .decode(query, StandardCharsets.UTF_8.toString());
    } catch (UnsupportedEncodingException e) {
      ExceptionUtil
          .resolveErrorResponseAndThrow(new BadRequestException("Unable to resolve query string"));
      return null;
    }
  }

}
