/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.upload.tempwatersewagedischargepayarrear;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * 描述: 污水排放量欠费 实体类<br>
 * @author liyafeng
 * @date 2015-11-12
 * 
 */
public class TempWaterSewageDischargePayArrear implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private String id;
    // 
    private String entName;
    // 
    private String loc;
    // 
    private String payArrearPeriod;
    // 
    private BigDecimal payArrearAmount;
    // 
    private String importFrom;
    // 
    private Date importDate;
    // 企业内部序号
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


    public String getLoc() {
        return loc;
    }
    public void setLoc(String loc) {
        this.loc = loc;
    }


    public String getPayArrearPeriod() {
        return payArrearPeriod;
    }
    public void setPayArrearPeriod(String payArrearPeriod) {
        this.payArrearPeriod = payArrearPeriod;
    }


    public BigDecimal getPayArrearAmount() {
        return payArrearAmount;
    }
    public void setPayArrearAmount(BigDecimal payArrearAmount) {
        this.payArrearAmount = payArrearAmount;
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
