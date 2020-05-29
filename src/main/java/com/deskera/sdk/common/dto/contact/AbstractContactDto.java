package com.deskera.sdk.common.dto.contact;


import com.deskera.sdk.common.dto.Address;
import com.deskera.sdk.common.dto.invoice.InvoiceResponseInfo;
import com.deskera.sdk.common.util.audit.IncludeInAudit;
import com.deskera.sdk.common.util.enums.CONTACT_STATUS;
import com.deskera.sdk.common.util.enums.SUPPORTED_CURRENCY_TYPE;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import io.swagger.annotations.ApiModelProperty;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.builder.DiffBuilder;
import org.apache.commons.lang3.builder.DiffResult;
import org.apache.commons.lang3.builder.Diffable;
import org.apache.commons.lang3.builder.ToStringStyle;

@Log4j2
@Data
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public abstract class AbstractContactDto implements Diffable<AbstractContactDto > {
  @ApiModelProperty(example = "1", notes = "Contact ID.", hidden = true)
  private Long id;

  @IncludeInAudit
  @ApiModelProperty(example = "C-001", notes = "Contact code", hidden = true)
  private String code;

  @IncludeInAudit
  @ApiModelProperty(example = "Sam", notes = "Contact name")
  private String name;

  @IncludeInAudit
  @ApiModelProperty(example = "AC001", notes = "Receivable account code")
  private String receivableAccountCode;

  @IncludeInAudit
  @ApiModelProperty(example = "AC002", notes = "Payable account code")
  private String payableAccountCode;

  @IncludeInAudit
  @ApiModelProperty(example = "SGD", notes = "Currency code")
  private SUPPORTED_CURRENCY_TYPE currencyCode;

  @IncludeInAudit
  @ApiModelProperty(example = "Net 0", notes = "Payment term code")
  private String paymentTermCode;

  @ApiModelProperty(dataType = "java.util.List<Address>", notes = "List of Billing Address.")
  private List<Address> billingAddress;

  @ApiModelProperty(dataType = "java.util.List<Address>", notes = "List of Shipping Address.")
  private List<Address> shippingAddress;

  @IncludeInAudit
  @ApiModelProperty(example = "ACTIVE", notes = "Contact status", hidden = true)
  private CONTACT_STATUS status;

  @ApiModelProperty(example = "true", notes = "Is customer?", hidden = true)
  private Boolean customer;

  @ApiModelProperty(example = "false", notes = "Is vendor?", hidden = true)
  private Boolean vendor;

  @ApiModelProperty(example = "false", notes = "Contact delete flag", hidden = true)
  private Boolean deleted;

  @ApiModelProperty(example = "123", notes = "Tenant ID.", hidden = true)
  private Long tenantId;

  @ApiModelProperty(example = "200", notes = "They owe you", hidden = true)
  private BigDecimal theyOweYou;

  @ApiModelProperty(example = "100", notes = "You owe them", hidden = true)
  private BigDecimal youOweThem;

  @ApiModelProperty(example = "100", notes = "receivable account opening amount account receivable", hidden = true)
  private BigDecimal totalNetAmount;

  @ApiModelProperty(example = "100", notes = "payable account opening amount account payable", hidden = true)
  private BigDecimal totalBillAmount;

  private Map<String, List<InvoiceResponseInfo>> invoices;

  @ApiModelProperty(example = "{\"field1\":\"value1\",\"field2\":\"value2\"}", notes = "JSON object for custom fields")
  private Object customField;

  public abstract void validate() ;

  @Override
  public DiffResult diff(final AbstractContactDto oldDto) {
    final DiffBuilder diffBuilder = new DiffBuilder(this, oldDto, ToStringStyle.SHORT_PREFIX_STYLE);
    final Field[] fields = this.getClass().getDeclaredFields();
    Arrays.stream(fields)
        .filter(f -> Objects.nonNull(f.getAnnotation(IncludeInAudit.class)))
        .forEach(e -> {
          try {
            if (
                (Objects.isNull(e.get(this)) && Objects.isNull(e.get(oldDto)))
                    || (Objects.nonNull(e.get(this)) && e.get(this).equals(e.get(oldDto)))
            ) {
              log.debug("Dto Field {{}} is either null or same with values as Old {{}}, New {{}}.",
                  e.getName(), e.get(oldDto), e.get(this));
              return;
            }
            diffBuilder.append(e.getName(), e.get(oldDto), e.get(this));
          } catch (final IllegalAccessException ex) {
            log.error("Error while getting the diff for Dto on field {{}}.", e.getName());
          }
        });
    return diffBuilder.build();
  }
}
