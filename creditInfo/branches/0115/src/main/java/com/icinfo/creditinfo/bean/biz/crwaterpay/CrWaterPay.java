/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-03
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.biz.crwaterpay;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * 描述: 用水量信息统计表 实体类<br>
 * @author myw
 * @date 2015-11-03
 * 
 */
public class CrWaterPay implements Serializable
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
    // 水务户号
    private String waterNo;
    // 用户类型
    private String userType;
    // 抄表时间
    private Date recordDate;
    // 用水所属期
    private String waterPeriod;
    // 用水量
    private String waterConsumption;
    // 用水金额
    private BigDecimal waterPayAmount;
    // 交费日期
    private Date payDate;
    // 交费金额
    private BigDecimal payAmount;
    // 
    private String importFrom;
    // 
    private Date importDate;
    // 企业内部序号
    private String corpid;

    //辅助字段
    private BigDecimal analyWaterConsumptionTotal;
    private String analyRecordDateStr;

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


    public String getWaterNo() {
        return waterNo;
    }
    public void setWaterNo(String waterNo) {
        this.waterNo = waterNo;
    }


    public String getUserType() {
        return userType;
    }
    public void setUserType(String userType) {
        this.userType = userType;
    }


    public Date getRecordDate() {
        return recordDate;
    }
    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }


    public String getWaterPeriod() {
        return waterPeriod;
    }
    public void setWaterPeriod(String waterPeriod) {
        this.waterPeriod = waterPeriod;
    }


    public String getWaterConsumption() {
        return waterConsumption;
    }
    public void setWaterConsumption(String waterConsumption) {
        this.waterConsumption = waterConsumption;
    }


    public BigDecimal getWaterPayAmount() {
        return waterPayAmount;
    }
    public void setWaterPayAmount(BigDecimal waterPayAmount) {
        this.waterPayAmount = waterPayAmount;
    }


    public Date getPayDate() {
        return payDate;
    }
    public void setPayDate(Date payDate) {
        this.payDate = payDate;
    }


    public BigDecimal getPayAmount() {
        return payAmount;
    }
    public void setPayAmount(BigDecimal payAmount) {
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
	public BigDecimal getAnalyWaterConsumptionTotal() {
		return analyWaterConsumptionTotal;
	}
	public void setAnalyWaterConsumptionTotal(BigDecimal analyWaterConsumptionTotal) {
		this.analyWaterConsumptionTotal = analyWaterConsumptionTotal;
	}
	public String getAnalyRecordDateStr() {
		return analyRecordDateStr;
	}
	public void setAnalyRecordDateStr(String analyRecordDateStr) {
		this.analyRecordDateStr = analyRecordDateStr;
	}

}
