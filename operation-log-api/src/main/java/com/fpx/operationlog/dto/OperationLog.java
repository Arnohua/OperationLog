package com.fpx.operationlog.dto;

import java.util.Date;

/**
 * @author dinghua
 * @date 2019/9/4
 */
public class OperationLog {

    /**
     * 空运报价单ID或空运应付ID
     */
    private String opId;
    /**
     * 创建时间
     */
    private Date opTime;

    /**
     * 操作人
     */
    private String opBy;

    /**
     * 操作类型,C:新增 R:审核 U:更新 D:删除 O:作废 Y:启用
     */
    private String opType;

    /**
     * 日志类型，1：空运报价日志，2：空运成本数据日志
     */
    private String logType;

    /**
     * 变更内容
     */
    private String content;

    public String getOpId() {
        return opId;
    }

    public void setOpId(String opId) {
        this.opId = opId;
    }

    public Date getOpTime() {
        return opTime;
    }

    public void setOpTime(Date opTime) {
        this.opTime = opTime;
    }

    public String getOpBy() {
        return opBy;
    }

    public void setOpBy(String opBy) {
        this.opBy = opBy;
    }

    public String getOpType() {
        return opType;
    }

    public void setOpType(String opType) {
        this.opType = opType;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
