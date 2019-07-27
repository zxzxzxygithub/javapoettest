package com.aiiage.libannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created By HuangQing on 2018/7/20 15:38
 **/
@Retention(RetentionPolicy.CLASS)
@Target(ElementType.TYPE)
public @interface KAnnotation {
}
