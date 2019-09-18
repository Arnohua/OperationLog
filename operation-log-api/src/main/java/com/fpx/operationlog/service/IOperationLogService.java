package com.fpx.operationlog.service;


import com.fpx.ironforge.common.model.PageDTO;
import com.fpx.operationlog.dto.OperationLog;
import com.fpx.operationlog.dto.OperationLogParamDTO;

/**
 * @author dinghua
 * @date 2019/9/4
 */
public interface IOperationLogService {

    /**
     * 通用操作日志记录
     * @param param
     */
    void recordOperationLogs(OperationLogParamDTO param);


    /**
     * 分页查询操作日志
     * @param dto
     * @return
     */
    PageDTO<? extends OperationLog> getListWithPage(OperationLogParamDTO dto);

}
