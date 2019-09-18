package com.fpx.operationlog.config;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fpx.operationlog.annotation.OperationAnnotation;
import com.fpx.operationlog.dto.OperationLogParamDTO;
import com.fpx.operationlog.service.IOperationLogService;
import org.apache.commons.lang3.StringUtils;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import java.lang.reflect.Method;

/**
 * @author dinghua
 * @date 2019/9/17
 * @since v1.0.0
 */
@Aspect
@Order
@Component
public class OperationLogAspect {

    private static Logger logger = LoggerFactory.getLogger(OperationLogAspect.class);

    @Autowired
    private IOperationLogService operationLogService;

    @Pointcut("@annotation(com.fpx.operationlog.annotation.OperationAnnotation)")
    public void pointcut() {
    }

    @Around("pointcut()")
    public void around(ProceedingJoinPoint joinPoint) throws Throwable {
        OperationLogParamDTO operationLogParamDTO = doBefore(joinPoint);
        Object result;
        try {
            result = joinPoint.proceed();
        } catch (Throwable throwable) {
            logger.error("方法执行错误",throwable.getMessage());
            throw throwable;
        }
        // 如果没有返回值，则无法进行参数对比
        if(result == null){
            operationLogParamDTO.setTarget(null);
        }
        operationLogParamDTO.setSource(result);
        doAfter(operationLogParamDTO);
    }

    private OperationLogParamDTO doBefore(ProceedingJoinPoint joinPoint){
        MethodSignature signature = (MethodSignature)joinPoint.getSignature();
        Method method = signature.getMethod();
        OperationAnnotation annotation = method.getAnnotation(OperationAnnotation.class);
        int index = annotation.paramIndex();
        String createBy = StringUtils.EMPTY;
        String opId = StringUtils.EMPTY;
        String logType = annotation.logType();
        String opType = annotation.opType();
        Object[] args = joinPoint.getArgs();
        if(args == null || args.length - 1 < index){
            throw new RuntimeException(method.getName() + "入参获取异常");
        }
        Object arg = args[index];
        String s = JSON.toJSONString(arg);
        JSONObject jsonObject = JSON.parseObject(s);
        Object o = jsonObject.get(annotation.createBy());
        Object o1 = jsonObject.get(annotation.opId());
        if(o != null){
            createBy = o.toString();
        }
        if(o1 != null){
            opId = o1.toString();
        }
        OperationLogParamDTO operationLogParamDTO = new OperationLogParamDTO();
        operationLogParamDTO.setOpId(opId);
        operationLogParamDTO.setOptBy(createBy);
        operationLogParamDTO.setLogType(logType);
        operationLogParamDTO.setOptBy(opType);
        operationLogParamDTO.setClazz(arg.getClass());
        operationLogParamDTO.setTarget(arg);
        return operationLogParamDTO;
    }

    private void doAfter(OperationLogParamDTO operationLogParamDTO){
        operationLogService.recordOperationLogs(operationLogParamDTO);
    }
}
