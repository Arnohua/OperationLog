package com.fpx.operationlog.dto;


/**
 * 操作日志入参
 * @author dinghua
 * @date 2019/9/4
 */
public class OperationLogParamDTO {

    private Class<?> clazz;

    private String optType;

    private String logType;

    private String optBy;

    private String opId;

    private Object source;

    private Object target;

    public Class<?> getClazz() {
        return clazz;
    }

    public void setClazz(Class<?> clazz) {
        this.clazz = clazz;
    }

    public String getOptType() {
        return optType;
    }

    public void setOptType(String optType) {
        this.optType = optType;
    }

    public String getLogType() {
        return logType;
    }

    public void setLogType(String logType) {
        this.logType = logType;
    }

    public String getOptBy() {
        return optBy;
    }

    public void setOptBy(String optBy) {
        this.optBy = optBy;
    }

    public String getOpId() {
        return opId;
    }

    public void setOpId(String opId) {
        this.opId = opId;
    }

    public Object getSource() {
        return source;
    }

    public void setSource(Object source) {
        this.source = source;
    }

    public Object getTarget() {
        return target;
    }

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public String toString() {
        return "OperationLogParamDTO{" +
                "clazz=" + clazz +
                ", optType='" + optType + '\'' +
                ", logType='" + logType + '\'' +
                ", optBy='" + optBy + '\'' +
                ", opId=" + opId +
                ", source=" + source +
                ", target=" + target +
                '}';
    }
}
