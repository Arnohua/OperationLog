
/*
 * Copyright (c) 2016 4PX Information Technology Co.,Ltd. All rights reserved.
 */
package com.fpx.operationlog.utils;

import com.fpx.operationlog.annotation.FieldAttributeAnnotation;

import java.math.BigDecimal;

/**
 * 
 * @author leijinf
 * @date 2018年7月23日
 */

public class AirExcelUpdateDTO {
    

    private String id;

    private String mawbNo;

    @FieldAttributeAnnotation(value = "其他杂费1",scale = 4)
    private BigDecimal otherFee1;

    @FieldAttributeAnnotation(value = "其他杂费2",scale = 5)
    private Double otherFee2;

    @FieldAttributeAnnotation(value = "其他杂费3",scale = 2)
    private Float otherFee3;

    @FieldAttributeAnnotation(value = "卸货费",scale = 1)
    private BigDecimal dischargeFee;

    @FieldAttributeAnnotation("备注")
    private String otherFeeRemark;

    @FieldAttributeAnnotation(value = "PIVOT值（KG）")
    private BigDecimal pivotWeight;

    @FieldAttributeAnnotation("是否特价")
    private String specialOfferFlag;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMawbNo() {
        return mawbNo;
    }

    public void setMawbNo(String mawbNo) {
        this.mawbNo = mawbNo;
    }

    public BigDecimal getOtherFee1() {
        return otherFee1;
    }

    public void setOtherFee1(BigDecimal otherFee1) {
        this.otherFee1 = otherFee1;
    }

    public Double getOtherFee2() {
        return otherFee2;
    }

    public void setOtherFee2(Double otherFee2) {
        this.otherFee2 = otherFee2;
    }

    public Float getOtherFee3() {
        return otherFee3;
    }

    public void setOtherFee3(Float otherFee3) {
        this.otherFee3 = otherFee3;
    }

    public BigDecimal getDischargeFee() {
        return dischargeFee;
    }

    public void setDischargeFee(BigDecimal dischargeFee) {
        this.dischargeFee = dischargeFee;
    }

    public String getOtherFeeRemark() {
        return otherFeeRemark;
    }

    public void setOtherFeeRemark(String otherFeeRemark) {
        this.otherFeeRemark = otherFeeRemark;
    }

    public BigDecimal getPivotWeight() {
        return pivotWeight;
    }

    public void setPivotWeight(BigDecimal pivotWeight) {
        this.pivotWeight = pivotWeight;
    }

    public String getSpecialOfferFlag() {
        return specialOfferFlag;
    }

    public void setSpecialOfferFlag(String specialOfferFlag) {
        this.specialOfferFlag = specialOfferFlag;
    }
}
