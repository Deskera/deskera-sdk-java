package com.deskera.sdk.common.client;

import com.deskera.sdk.common.dto.contact.ContactAttributeUpdateDto;
import com.deskera.sdk.common.dto.contact.ContactDto;
import com.deskera.sdk.common.util.RestResponsePage;
import com.deskera.sdk.common.util.constants.ApiConstants;
import java.util.List;
import java.util.Objects;
import javax.annotation.PostConstruct;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;
import org.springframework.core.ParameterizedTypeReference;
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
@EqualsAndHashCode(callSuper = true)
public class ContactsApiClient extends ApiClient {

  private String contactByCodeApiUrl;

  private String updateContactByIdUrl;

  private String createContactApiUrl;

  private static final String CONTACT_FETCH_BY_CODE_FAILURE_MSG = "Failure in retrieving Contacts by Contact Code";
  private static final String CONTACT_CREATION_FAILURE_MSG = "Could not create Contact";
  private static final String CONTACT_ATTRIBUTE_UPDATE_FAILURE_MSG = "Could not update Contact attributes";
  private static final String CONTACT_UPDATE_FAILURE_MSG = "Could not update Contact";
  private static final String ALL_CONTACT_FETCH_FAILURE_MSG = "Could not get All Contacts";

  public ContactsApiClient(final String oAuth2PartnerClientId, final RestTemplate restTemplate,
      final String oAuth2PartnerSecret, final String oAuth2PartnerRedirectUrl,
      final boolean isSandbox) {
    this.oAuth2PartnerClientId = oAuth2PartnerClientId;
    this.restTemplate = restTemplate;
    this.oAuth2PartnerSecret = oAuth2PartnerSecret;
    this.oAuth2PartnerRedirectUrl = oAuth2PartnerRedirectUrl;
    this.isSandbox = isSandbox;
  }

  @PostConstruct
  private void init() {
    if (this.isSandbox) {
      this.contactByCodeApiUrl = this.contactsByCodeSandbox;
      this.updateContactByIdUrl = this.contactsUpdateByIdSandbox;
      this.createContactApiUrl = this.contactsCreateSandbox;
    } else {
      this.contactByCodeApiUrl = this.contactsByCode;
      this.updateContactByIdUrl = this.contactsUpdateById;
      this.createContactApiUrl = this.contactsCreate;
    }
  }

  /**
   * This API should be called when fetching ContactDto
   *
   * @param contactCode code of the target Contact
   * @param accessToken accessToken provided by Deskera
   * @return {@link ContactDto}
   */
  public ContactDto getClientByCode(final String contactCode, final String accessToken) {
    final String endpoint = this.getEndpoint(this.contactByCodeApiUrl, contactCode);
    final HttpEntity httpEntity = this.createHttpEntityWithHeaders(accessToken);
    try {
      final ResponseEntity<ContactDto> responseEntity = (ResponseEntity<ContactDto>) this
          .createUrl(
              endpoint, httpEntity, ContactDto.class, HttpMethod.GET);
      if (!HttpStatus.OK.equals(responseEntity.getStatusCode()) || Objects
          .isNull(responseEntity.getBody())) {
        throw new HttpClientErrorException(responseEntity.getStatusCode(),
            CONTACT_FETCH_BY_CODE_FAILURE_MSG);
      }
      return responseEntity.getBody();
    } catch (RestClientException restClientException) {
      throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
          restClientException.getMessage());
    }
  }

  /**
   * Api to create Contacts on Deskera platform
   *
   * @param contactDto
   * @param accessToken
   * @return {@link ContactDto}
   */
  public ContactDto createContact(final ContactDto contactDto, final String accessToken) {
    final String endpoint = this.getEndpoint(this.createContactApiUrl);
    final HttpEntity<ContactDto> httpEntity = (HttpEntity<ContactDto>) this
        .getHttpEntity(contactDto, accessToken);
    try {
      final ResponseEntity<ContactDto> responseEntity = (ResponseEntity<ContactDto>) this
          .createUrl(endpoint, httpEntity, ContactDto.class, HttpMethod.POST);
      if (!HttpStatus.CREATED.equals(responseEntity.getStatusCode()) || Objects
          .isNull(responseEntity.getBody())) {
        throw new HttpClientErrorException(responseEntity.getStatusCode(),
            CONTACT_CREATION_FAILURE_MSG);
      }
      return responseEntity.getBody();
    } catch (RestClientException restClientException) {
      throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
          restClientException.getMessage());
    }
  }

  /**
   * Update ContactAttributes Api
   *
   * @param contactId
   * @param contactAttributeUpdateDto
   * @param accessToken
   * @return {@link ContactAttributeUpdateDto}
   */
  public ContactAttributeUpdateDto updateContactAttributes(final long contactId,
      final ContactAttributeUpdateDto contactAttributeUpdateDto, final String accessToken) {
    final String endpoint = this.getEndpoint(this.updateContactByIdUrl, contactId);
    final HttpEntity<ContactAttributeUpdateDto> httpEntity = new HttpEntity<ContactAttributeUpdateDto>(
        contactAttributeUpdateDto,
        this.getHttpHeaders(accessToken));
    try {
      final ResponseEntity<ContactAttributeUpdateDto> responseEntity = (ResponseEntity<ContactAttributeUpdateDto>) this
          .createUrl(endpoint, httpEntity, ContactAttributeUpdateDto.class, HttpMethod.PATCH);
      if (!HttpStatus.OK.equals(responseEntity.getStatusCode()) || Objects
          .isNull(responseEntity.getBody())) {
        throw new HttpClientErrorException(responseEntity.getStatusCode(),
            CONTACT_ATTRIBUTE_UPDATE_FAILURE_MSG);
      }
      return responseEntity.getBody();
    } catch (RestClientException restClientException) {
      throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
          restClientException.getMessage());
    }
  }

  /**
   * Api to update Contact
   *
   * @param contactId
   * @param contactDto
   * @param accessToken
   * @return {@link ContactDto}
   */
  public ContactDto updateContact(final long contactId, final ContactDto contactDto,
      final String accessToken) {
    final String endpoint = this.getEndpoint(this.updateContactByIdUrl, contactId);
    final HttpEntity<ContactDto> httpEntity = new HttpEntity<ContactDto>(
        contactDto,
        this.getHttpHeaders(accessToken));
    try {
      final ResponseEntity<ContactDto> responseEntity = (ResponseEntity<ContactDto>) this
          .createUrl(endpoint, httpEntity, ContactDto.class, HttpMethod.PUT);
      if (!HttpStatus.OK.equals(responseEntity.getStatusCode()) || Objects
          .isNull(responseEntity.getBody())) {
        throw new HttpClientErrorException(responseEntity.getStatusCode(),
            CONTACT_UPDATE_FAILURE_MSG);
      }
      return responseEntity.getBody();
    } catch (RestClientException restClientException) {
      throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
          restClientException.getMessage());
    }
  }

  /**
   * Get All Contacts
   *
   * @param accessToken
   * @return {@link java.util.List}
   */
  public List<ContactDto> getAllContacts(final String accessToken, final int limit) {
    final String endpoint = this.getEndpoint(this.updateContactByIdUrl) + this
        .getParamFormattedString(ApiConstants.INCLUDE_OPENING_AMOUNT_CONST, "false",
            ApiConstants.INCLUDE_OWE_AMOUNT_CONST, "false", ApiConstants.LIMIT,
            limit, ApiConstants.PAGE, ApiConstants.DEFAULT_PAGE_SIZE, ApiConstants.SORT_CONST,
            ApiConstants.CREATED_AT_CONST, ApiConstants.SORT_DIR_CONST, ApiConstants.DESC_CONST);
    final ParameterizedTypeReference<RestResponsePage<ContactDto>> responseType = new ParameterizedTypeReference<RestResponsePage<ContactDto>>() {
    };
    final HttpEntity<String> httpEntity = this.createHttpEntityWithHeaders(accessToken);
    try {
      final ResponseEntity<RestResponsePage<ContactDto>> responseEntity = this.restTemplate
          .exchange(endpoint, HttpMethod.GET, httpEntity, responseType);
      if (!HttpStatus.OK.equals(responseEntity.getStatusCode()) || Objects
          .isNull(responseEntity.getBody())) {
        throw new HttpClientErrorException(responseEntity.getStatusCode(),
            ALL_CONTACT_FETCH_FAILURE_MSG);
      }
      return responseEntity.getBody().getContent();
    } catch (RestClientException restClientException) {
      throw new HttpClientErrorException(HttpStatus.INTERNAL_SERVER_ERROR,
          restClientException.getMessage());
    }
  }
}
