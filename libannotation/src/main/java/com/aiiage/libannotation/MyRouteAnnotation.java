package com.aiiage.libannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author zhengyx
 * @des annotation
 * @date 2019-07-27
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.CLASS)
public @interface MyRouteAnnotation {
}
