package com.fpx.operationlog.annotation;

import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface OperationAnnotation {

    /**
     * 操作类型（增、删、改、查类）
     * @return
     */
    String opType() default "";

    /**
     * 操作人,从参数中获取，指定参数名称
     * @return
     */
    String createBy() default "";

    /**
     * 日志类型
     * @return
     */
    String logType() default "";

    /**
     * 指定解析的参数
     * @return
     */
    int paramIndex() default 0;

    /**
     * 操作的数据id，从参数中获取，指定参数名称
     * @return
     */
    String opId() default "";
}
