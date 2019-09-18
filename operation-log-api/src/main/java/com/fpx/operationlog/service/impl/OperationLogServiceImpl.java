package com.fpx.operationlog.service.impl;

import com.fpx.ironforge.common.model.PageDTO;
import com.fpx.operationlog.dto.OperationLog;
import com.fpx.operationlog.dto.OperationLogParamDTO;
import com.fpx.operationlog.service.IOperationLogService;
import com.fpx.operationlog.service.client.OperationLogClient;
import com.fpx.operationlog.utils.ClassFieldDealWithUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.Date;

/**
 * @author dinghua
 * @date 2019/9/9
 * @since v1.0.0
 */
@Service
public class OperationLogServiceImpl implements IOperationLogService{

    @Autowired(required = false)
    private OperationLogClient operationLogClient;

    private static final int DEFAUL_LENGTH = 1024;

    @Override
    @Async
    public void recordOperationLogs(OperationLogParamDTO param) {
        if(param == null){
            throw new RuntimeException("param must not be null");
        }
        OperationLog operationLog = new OperationLog();
        String content = ClassFieldDealWithUtils.compareFieldVaule(param.getClazz(), param.getSource(), param.getTarget());
        operationLog.setOpId(param.getOpId());
        if(content != null && content.length() >= DEFAUL_LENGTH){
            content = content.substring(0,DEFAUL_LENGTH);
        }
        operationLog.setContent(content);
        operationLog.setLogType(param.getLogType());
        operationLog.setOpBy(param.getOptBy());
        operationLog.setOpTime(new Date());
        operationLog.setOpType(param.getOptType());
        operationLogClient.recordOperationLogs(operationLog);
    }

    @Override
    public PageDTO<? extends OperationLog> getListWithPage(OperationLogParamDTO dto) {
        return operationLogClient.getListWithPage(dto);
    }
}
