package com.sccddw.test.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * description
 *
 * @author dell
 * date 2020/10/14 14:17
 * @version 1.0
 **/
@Target({ElementType.METHOD})
// 允许被反射到
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
}
