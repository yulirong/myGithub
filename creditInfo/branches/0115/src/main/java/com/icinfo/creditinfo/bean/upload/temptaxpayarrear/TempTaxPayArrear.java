/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-11
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.upload.temptaxpayarrear;

import java.io.Serializable;
import java.util.Date;

/** 
 * 描述: 税费欠税 实体类<br>
 * @author gaotong
 * @date 2015-11-11
 * 
 */
public class TempTaxPayArrear implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private String id;
    // 企业名称
    private String entName;
    // 税务登记证
    private String taxRegNo;
    // 欠税税种
    private String taxarrearType;
    // 欠税余额
    private String taxarrearBalance;
    // 欠税所属期
    private Date taxarrearPeriod;
    // 
    private String importFrom;
    // 
    private Date importDate;
    // 
    private Date taxarrearPeriodTo;
    // 企业内部序号
    private String corpid;


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


    public String getTaxRegNo() {
        return taxRegNo;
    }
    public void setTaxRegNo(String taxRegNo) {
        this.taxRegNo = taxRegNo;
    }


    public String getTaxarrearType() {
        return taxarrearType;
    }
    public void setTaxarrearType(String taxarrearType) {
        this.taxarrearType = taxarrearType;
    }


    public String getTaxarrearBalance() {
        return taxarrearBalance;
    }
    public void setTaxarrearBalance(String taxarrearBalance) {
        this.taxarrearBalance = taxarrearBalance;
    }


    public Date getTaxarrearPeriod() {
        return taxarrearPeriod;
    }
    public void setTaxarrearPeriod(Date taxarrearPeriod) {
        this.taxarrearPeriod = taxarrearPeriod;
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


    public Date getTaxarrearPeriodTo() {
        return taxarrearPeriodTo;
    }
    public void setTaxarrearPeriodTo(Date taxarrearPeriodTo) {
        this.taxarrearPeriodTo = taxarrearPeriodTo;
    }


    public String getCorpid() {
        return corpid;
    }
    public void setCorpid(String corpid) {
        this.corpid = corpid;
    }

}
