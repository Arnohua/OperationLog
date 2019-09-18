package com.fpx.operationlog.service.client;

import com.fpx.ironforge.common.model.PageDTO;
import com.fpx.operationlog.dto.OperationLog;
import com.fpx.operationlog.dto.OperationLogParamDTO;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author dinghua
 * @date 2019/9/16
 * @since v1.0.0
 */
public interface OperationLogClient {

    /**
     * 记录操作日志
     * @param operationLog
     */
    @RequestMapping(value = "/api/operation/log/record",method = {RequestMethod.POST})
    void recordOperationLogs(@RequestBody OperationLog operationLog);

    /**
     * 操作日志查询
     * @param dto
     * @return
     */
    @RequestMapping(value = "/api/operation/log/list",method = {RequestMethod.POST})
    PageDTO<? extends OperationLog> getListWithPage(@RequestBody OperationLogParamDTO dto);
}
