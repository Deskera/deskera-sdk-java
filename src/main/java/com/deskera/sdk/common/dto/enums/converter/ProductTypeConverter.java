package com.deskera.sdk.common.dto.enums.converter;

import com.deskera.sdk.common.dto.enums.ProductType;
import java.util.Objects;
import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import org.apache.commons.lang3.StringUtils;

@Converter
public class ProductTypeConverter implements AttributeConverter<ProductType, String> {

  @Override
  public String convertToDatabaseColumn(final ProductType productType) {
    return (Objects.isNull(productType) ? null : productType.getValue());
  }

  @Override
  public ProductType convertToEntityAttribute(final String productType) {
    return (StringUtils.isEmpty(productType) ? null : ProductType.fromValue(productType));
  }
}
