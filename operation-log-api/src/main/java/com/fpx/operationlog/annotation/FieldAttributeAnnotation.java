package com.fpx.operationlog.annotation;

import java.lang.annotation.*;

/**
 * @author dinghua
 * @date 2019/09/04
 *
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface FieldAttributeAnnotation {

    /**
     * 字段名称
     * @return
     */
    String value() default "";

    /**
     * 若是数字类型，保留的小数位
     * @return
     */
    int scale() default 0;
}
