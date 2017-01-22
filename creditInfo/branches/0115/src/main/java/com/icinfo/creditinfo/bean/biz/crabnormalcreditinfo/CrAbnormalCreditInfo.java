/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-15
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.biz.crabnormalcreditinfo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

/** 
 * 描述: 异常信贷记录明细 实体类<br>
 * @author yulirong
 * @date 2015-10-15
 * 
 */
public class CrAbnormalCreditInfo implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private String id;
    // 企业名称
    private String abnEntName;
    // 注册号
    private String abnRegNo;
    // 欠息汇总
    private BigDecimal abnInterSum;
    // 授信机构
    private String abnCreditInst;
    // 币种
    private String abnCurrency;
    // 欠息余额
    private BigDecimal abnInterBalance;
    // 余额改变日期
    private Date abnChangeDate;
    // 欠息类型
    private String abnInterType;
    //用户id
    private String abnUserId;
    //添加时间
    private Date abnOptTime;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public String getAbnEntName() {
        return abnEntName;
    }
    public void setAbnEntName(String abnEntName) {
        this.abnEntName = abnEntName;
    }


    public String getAbnRegNo() {
        return abnRegNo;
    }
    public void setAbnRegNo(String abnRegNo) {
        this.abnRegNo = abnRegNo;
    }


    public BigDecimal getAbnInterSum() {
    	if(abnInterSum == null) return new BigDecimal(0);
        return abnInterSum;
    }
    public void setAbnInterSum(BigDecimal abnInterSum) {
        this.abnInterSum = abnInterSum;
    }


    public String getAbnCreditInst() {
        return abnCreditInst;
    }
    public void setAbnCreditInst(String abnCreditInst) {
        this.abnCreditInst = abnCreditInst;
    }


    public String getAbnCurrency() {
        return abnCurrency;
    }
    public void setAbnCurrency(String abnCurrency) {
        this.abnCurrency = abnCurrency;
    }


    public BigDecimal getAbnInterBalance() {
        return abnInterBalance;
    }
    public void setAbnInterBalance(BigDecimal abnInterBalance) {
        this.abnInterBalance = abnInterBalance;
    }

    @JSON(format = "yyyy/MM/dd")
    public Date getAbnChangeDate() {
        return abnChangeDate;
    }
    public void setAbnChangeDate(Date abnChangeDate) {
        this.abnChangeDate = abnChangeDate;
    }


    public String getAbnInterType() {
        return abnInterType;
    }
    public void setAbnInterType(String abnInterType) {
    	 this.abnInterType = abnInterType;
    }
	public String getAbnUserId() {
		return abnUserId;
	}
	public void setAbnUserId(String abnUserId) {
		this.abnUserId = abnUserId;
	}
	public Date getAbnOptTime() {
		return abnOptTime;
	}
	public void setAbnOptTime(Date abnOptTime) {
		this.abnOptTime = abnOptTime;
	}

}
