/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-07
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.analy.cranalypubres;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * 描述: 公共资源统计表 实体类<br>
 * @author myw
 * @date 2015-11-07
 * 
 */
public class CrAnalyPubRes implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private BigDecimal id;
    // 地区编码
    private String zoneCode;
    // 所属期
    private String balancePeriod;
    // 用量
    private String presentAmount;
    // 标识
    private String importTable;
    // 
    private Date createDate;
    
    //辅助字段
    private BigDecimal presentAmountTotal;
    private String analyZoneName;

    public BigDecimal getId() {
        return id;
    }
    public void setId(BigDecimal id) {
        this.id = id;
    }


    public String getZoneCode() {
        return zoneCode;
    }
    public void setZoneCode(String zoneCode) {
        this.zoneCode = zoneCode;
    }


    public String getBalancePeriod() {
        return balancePeriod;
    }
    public void setBalancePeriod(String balancePeriod) {
        this.balancePeriod = balancePeriod;
    }


    public String getPresentAmount() {
        return presentAmount;
    }
    public void setPresentAmount(String presentAmount) {
        this.presentAmount = presentAmount;
    }


    public String getImportTable() {
        return importTable;
    }
    public void setImportTable(String importTable) {
        this.importTable = importTable;
    }


    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
	public BigDecimal getPresentAmountTotal() {
		return presentAmountTotal;
	}
	public void setPresentAmountTotal(BigDecimal presentAmountTotal) {
		this.presentAmountTotal = presentAmountTotal;
	}
	public String getAnalyZoneName() {
		return analyZoneName;
	}
	public void setAnalyZoneName(String analyZoneName) {
		this.analyZoneName = analyZoneName;
	}

}
