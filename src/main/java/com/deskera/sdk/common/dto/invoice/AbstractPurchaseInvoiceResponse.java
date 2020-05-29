package com.deskera.sdk.common.dto.invoice;


import com.deskera.sdk.common.dto.Address;
import com.deskera.sdk.common.dto.enums.PAYMENT_STATUS;
import com.deskera.sdk.common.dto.enums.RECEIPT_STATUS;
import io.swagger.annotations.ApiModelProperty;
import java.util.List;
import javax.validation.Valid;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Data
@EqualsAndHashCode(callSuper = true)
public class AbstractPurchaseInvoiceResponse<T extends AbstractInvoiceProductDetails> extends
    BasePurchaseInvoiceDetails {

  @Valid
  @ApiModelProperty(notes = "Purchase invoice Product item details")
  private List<T> purchaseInvoiceProducts;

  @ApiModelProperty(example = "1", notes = "Purchase invoice id")
  private Long id;

  @ApiModelProperty(example = "SI001", notes = "Purchase invoice code")
  private String purchaseInvoiceCode;

  @ApiModelProperty(example = "0000001", notes = "Purchase invoice Sequence Code")
  private String documentSequenceCode;

  @ApiModelProperty(notes = "KnockOff Info")
  private KnockOffInfo[] knockoffInfo;

  @ApiModelProperty(example = "false", notes = "Purchase invoice drafted")
  private Boolean draft;

  @ApiModelProperty(example = "PENDING", notes = "Purchase invoice payment status")
  private PAYMENT_STATUS paymentStatus;

  @ApiModelProperty(example = "UNRECEIVED", notes = "Purchase invoice receipt status")
  private RECEIPT_STATUS receiptStatus;
  
  @ApiModelProperty(notes = "Ship from address")
  private Address shipFrom;

  @ApiModelProperty(notes = "Ship to address")
  private Address shipTo;

  @ApiModelProperty(notes = "Bill to Address")
  private Address billTo;

}
