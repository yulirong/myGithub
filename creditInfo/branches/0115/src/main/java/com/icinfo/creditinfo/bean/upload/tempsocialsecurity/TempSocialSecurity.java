/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-11
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.upload.tempsocialsecurity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * 描述: 社保信息 实体类<br>
 * @author liyafeng
 * @date 2015-11-11
 * 
 */
public class TempSocialSecurity implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private String id;
    // 企业名称
    private String entName;
    // 社保编号
    private String siNo;
    // 税务登记证
    private String taxRegNo;
    // 参保类型
    private String siType;
    // 参保人数
    private String siNumber;
    // 参保金额
    private String siMoney;
    // 统计时间
    private String statisticDate;
    // 
    private String remark;
    // 
    private String importFrom;
    // 
    private Date importDate;
    // 
    private String corpid;
    //组织机构代码
    private String orgCode;
    //统一信用代码
    private String unscCode;

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


    public String getSiNo() {
        return siNo;
    }
    public void setSiNo(String siNo) {
        this.siNo = siNo;
    }


    public String getTaxRegNo() {
        return taxRegNo;
    }
    public void setTaxRegNo(String taxRegNo) {
        this.taxRegNo = taxRegNo;
    }


    public String getSiType() {
        return siType;
    }
    public void setSiType(String siType) {
        this.siType = siType;
    }


    public String getSiNumber() {
        return siNumber;
    }
    public void setSiNumber(String siNumber) {
        this.siNumber = siNumber;
    }


    public String getSiMoney() {
        return siMoney;
    }
    public void setSiMoney(String siMoney) {
        this.siMoney = siMoney;
    }


    public String getStatisticDate() {
        return statisticDate;
    }
    public void setStatisticDate(String statisticDate) {
        this.statisticDate = statisticDate;
    }


    public String getRemark() {
        return remark;
    }
    public void setRemark(String remark) {
        this.remark = remark;
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
	public String getOrgCode() {
		return orgCode;
	}
	public void setOrgCode(String orgCode) {
		this.orgCode = orgCode;
	}
	public String getUnscCode() {
		return unscCode;
	}
	public void setUnscCode(String unscCode) {
		this.unscCode = unscCode;
	}

    
}
