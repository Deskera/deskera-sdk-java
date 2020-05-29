package com.deskera.sdk.common.dto.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import com.deskera.sdk.common.util.constants.Constants.DataTypes;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * This Annotation is used by Import MicroService to identify each field and its validation rules
 */
@Retention(RUNTIME)
@Target({TYPE, FIELD})
public @interface ImportProperty {

  String displayName();

  String dataType() default DataTypes.STRING;

  boolean required() default false;

  int length() default 255;

  boolean unique() default false;

}
