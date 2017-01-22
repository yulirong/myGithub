/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-03
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.biz.crelecpay;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * 描述: 用电量信息表 实体类<br>
 * @author myw
 * @date 2015-11-03
 * 
 */
public class CrElecPay implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private String id;
    // 企业名称
    private String entName;
    // 工商注册号
    private String regNo;
    // 经营地点
    private String entLoc;
    // 电力户号
    private String elecNo;
    // 用户类型
    private String userType;
    // 抄表时间
    private String recordDate;
    // 用电所属期
    private String elecPeriod;
    // 用电量
    private String elecConsumption;
    // 用电金额
    private String elecPayAmount;
    // 交费日期
    private String payDate;
    // 交费金额
    private String payAmount;
    // 
    private String importFrom;
    // 
    private Date importDate;
    // 企业内部序号
    private String corpid;
    
    //辅助字段
    private BigDecimal analyElecConsumptionTotal;//按月统计用电量
    private String analyRecordDateStr;//统计时间字符串
    
    private String entOrgRegNo;
    private String arrearBalance;


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


    public String getRegNo() {
        return regNo;
    }
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }


    public String getEntLoc() {
        return entLoc;
    }
    public void setEntLoc(String entLoc) {
        this.entLoc = entLoc;
    }


    public String getElecNo() {
        return elecNo;
    }
    public void setElecNo(String elecNo) {
        this.elecNo = elecNo;
    }


    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }


    public String getEntOrgRegNo() {
		return entOrgRegNo;
	}
	public void setEntOrgRegNo(String entOrgRegNo) {
		this.entOrgRegNo = entOrgRegNo;
	}
	public String getArrearBalance() {
		return arrearBalance;
	}
	public void setArrearBalance(String arrearBalance) {
		this.arrearBalance = arrearBalance;
	}
	public String getRecordDate() {
        return recordDate;
    }
    public void setRecordDate(String recordDate) {
        this.recordDate = recordDate;
    }


    public String getElecPeriod() {
        return elecPeriod;
    }
    public void setElecPeriod(String elecPeriod) {
        this.elecPeriod = elecPeriod;
    }


    public String getElecConsumption() {
        return elecConsumption;
    }
    public void setElecConsumption(String elecConsumption) {
        this.elecConsumption = elecConsumption;
    }


    public String getElecPayAmount() {
        return elecPayAmount;
    }
    public void setElecPayAmount(String elecPayAmount) {
        this.elecPayAmount = elecPayAmount;
    }


    public String getPayDate() {
        return payDate;
    }
    public void setPayDate(String payDate) {
        this.payDate = payDate;
    }


    public String getPayAmount() {
        return payAmount;
    }
    public void setPayAmount(String payAmount) {
        this.payAmount = payAmount;
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
	public BigDecimal getAnalyElecConsumptionTotal() {
		return analyElecConsumptionTotal;
	}
	public void setAnalyElecConsumptionTotal(BigDecimal analyElecConsumptionTotal) {
		this.analyElecConsumptionTotal = analyElecConsumptionTotal;
	}
	public String getAnalyRecordDateStr() {
		return analyRecordDateStr;
	}
	public void setAnalyRecordDateStr(String analyRecordDateStr) {
		this.analyRecordDateStr = analyRecordDateStr;
	}

    
}
