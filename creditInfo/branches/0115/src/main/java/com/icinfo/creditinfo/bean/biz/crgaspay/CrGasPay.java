/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-03
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.biz.crgaspay;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * 描述: 用气量信息表 实体类<br>
 * @author myw
 * @date 2015-11-03
 * 
 */
public class CrGasPay implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private String id;
    // 
    private String entName;
    // 
    private Date balanceDateStart;
    // 
    private Date balanceDateEnd;
    // 
    private String supplyType;
    // 
    private String meterReadingDate;
    // 
    private String previousDegree;
    // 
    private String presentDegree;
    // 
    private String degree;
    // 
    private String presentAmount;
    // 
    private String gasPrice;
    // 
    private String payable;
    // 
    private String paid;
    // 
    private String prepayments;
    // 滞纳金
    private String penalty;
    // 
    private String payableAmount;
    // 
    private String importFrom;
    // 
    private Date importDate;
    // 企业内部序号
    private String corpid;
    
    //辅助字段
    private BigDecimal analyPresentAmountTotal;
    private String analyMeterReadingDateStr;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public String getEntName() {
        return entName;
    }
    public void setEntName(String entName) {
        this.entName = entName;
    }


    public Date getBalanceDateStart() {
        return balanceDateStart;
    }
    public void setBalanceDateStart(Date balanceDateStart) {
        this.balanceDateStart = balanceDateStart;
    }


    public Date getBalanceDateEnd() {
        return balanceDateEnd;
    }
    public void setBalanceDateEnd(Date balanceDateEnd) {
        this.balanceDateEnd = balanceDateEnd;
    }


    public String getSupplyType() {
        return supplyType;
    }
    public void setSupplyType(String supplyType) {
        this.supplyType = supplyType;
    }


    public String getMeterReadingDate() {
        return meterReadingDate;
    }
    public void setMeterReadingDate(String meterReadingDate) {
        this.meterReadingDate = meterReadingDate;
    }


    public String getPreviousDegree() {
        return previousDegree;
    }
    public void setPreviousDegree(String previousDegree) {
        this.previousDegree = previousDegree;
    }


    public String getPresentDegree() {
        return presentDegree;
    }
    public void setPresentDegree(String presentDegree) {
        this.presentDegree = presentDegree;
    }


    public String getDegree() {
        return degree;
    }
    public void setDegree(String degree) {
        this.degree = degree;
    }


    public String getPresentAmount() {
        return presentAmount;
    }
    public void setPresentAmount(String presentAmount) {
        this.presentAmount = presentAmount;
    }


    public String getGasPrice() {
        return gasPrice;
    }
    public void setGasPrice(String gasPrice) {
        this.gasPrice = gasPrice;
    }


    public String getPayable() {
        return payable;
    }
    public void setPayable(String payable) {
        this.payable = payable;
    }


    public String getPaid() {
        return paid;
    }
    public void setPaid(String paid) {
        this.paid = paid;
    }


    public String getPrepayments() {
        return prepayments;
    }
    public void setPrepayments(String prepayments) {
        this.prepayments = prepayments;
    }


    public String getPenalty() {
        return penalty;
    }
    public void setPenalty(String penalty) {
        this.penalty = penalty;
    }


    public String getPayableAmount() {
        return payableAmount;
    }
    public void setPayableAmount(String payableAmount) {
        this.payableAmount = payableAmount;
    }


    public String getImportFrom() {
        return importFrom;
    }
    public void setImportFrom(String importFrom) {
        this.importFrom = importFrom;
    }


    public Date getImportDate() {
        return importDate;
    }
    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }


    public String getCorpid() {
        return corpid;
    }
    public void setCorpid(String corpid) {
        this.corpid = corpid;
    }
	public BigDecimal getAnalyPresentAmountTotal() {
		return analyPresentAmountTotal;
	}
	public void setAnalyPresentAmountTotal(BigDecimal analyPresentAmountTotal) {
		this.analyPresentAmountTotal = analyPresentAmountTotal;
	}
	public String getAnalyMeterReadingDateStr() {
		return analyMeterReadingDateStr;
	}
	public void setAnalyMeterReadingDateStr(String analyMeterReadingDateStr) {
		this.analyMeterReadingDateStr = analyMeterReadingDateStr;
	}

}
