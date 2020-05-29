package com.deskera.sdk.common.dto.inventory;

public enum SHIPMENT_DOCUMENT_STATUS {



  READY_TO_PICK(1),
  PICKING_IN_PROGRESS(2),
  PICKED(3),
  READY_TO_PACK(4),
  PACKING_IN_PROGRESS(5),
  PACKED(6),
  READY_TO_SHIP(7),
  SHIPPING_IN_PROGRESS(8),
  PARTIAL_SHIPPED(9),
  SHIPPED(10);

  private final int order;

  private SHIPMENT_DOCUMENT_STATUS(int order) {
    this.order = order;
  }

  public int getOrder(){
    return this.order;
  }

}
