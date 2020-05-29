package com.deskera.sdk.common.dto.enums;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public enum UOMType {
  //TODO: this need to be changed once UI and product level changes done
  HOUR(1l),
  UNIT(2l),
  KG(3l),
  PIECES(4l),
  NA(5l),
  DEFAULT(6l);

  private Long uom;

  UOMType(Long uom) {
    this.uom = uom;
  }

  public Long getUOMType() {
    return this.uom;
  }

  public static Map<Long, UOMType> getUOMTypeMap() {
    return Arrays.stream(UOMType.values()).collect(Collectors.toMap(
        UOMType::getUOMType, uomType -> uomType
    ));
  }

}
