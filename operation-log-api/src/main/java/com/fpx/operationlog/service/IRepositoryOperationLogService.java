package com.fpx.operationlog.service;

import com.fpx.ironforge.common.model.PageDTO;
import com.fpx.operationlog.dto.OperationLog;
import com.fpx.operationlog.dto.OperationLogParamDTO;

/**
 * @author dinghua
 * @date 2019/9/12
 * @since v1.0.0
 */
public interface IRepositoryOperationLogService {

    /**
     * 持久化记录
     * @param operationLog
     * @param operationLogParamDTO
     */
    void record(OperationLog operationLog,OperationLogParamDTO operationLogParamDTO);

    /**
     * 获取日志列表
     * @param dto
     * @return
     */
    PageDTO<? extends OperationLog> getListWithPage(OperationLogParamDTO dto);
}
