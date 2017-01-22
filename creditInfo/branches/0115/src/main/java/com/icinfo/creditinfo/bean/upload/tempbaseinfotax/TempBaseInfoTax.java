/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-11
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.upload.tempbaseinfotax;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * 描述: 企业基本信息 实体类<br>
 * @author gaotong
 * @date 2015-11-11
 * 
 */
public class TempBaseInfoTax implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 企业内部序号
    private String id;
    // 
    private String entName;
    // 税务登记证
    private String taxRegNo;
    // 工
    private String regNo;
    // 组织
    private String orgRegNo;
    // 税务内部编码
    private String siNo;
    // 成
    private Date estDate;
    // 经营地点
    private String entLoc;
    // 法定代表人
    private String legRep;
    // 证件类型
    private String certType;
    // 证件号
    private String certNo;
    // 注册资本
    private BigDecimal regCap;
    // 
    private String importFrom;
    // 
    private Date importDate;
    // 企业内部序号
    private String corpid;
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


    public String getTaxRegNo() {
        return taxRegNo;
    }
    public void setTaxRegNo(String taxRegNo) {
        this.taxRegNo = taxRegNo;
    }


    public String getRegNo() {
        return regNo;
    }
    public void setRegNo(String regNo) {
        this.regNo = regNo;
    }


    public String getOrgRegNo() {
        return orgRegNo;
    }
    public void setOrgRegNo(String orgRegNo) {
        this.orgRegNo = orgRegNo;
    }


    public String getSiNo() {
        return siNo;
    }
    public void setSiNo(String siNo) {
        this.siNo = siNo;
    }


    public Date getEstDate() {
        return estDate;
    }
    public void setEstDate(Date estDate) {
        this.estDate = estDate;
    }


    public String getEntLoc() {
        return entLoc;
    }
    public void setEntLoc(String entLoc) {
        this.entLoc = entLoc;
    }


    public String getLegRep() {
        return legRep;
    }
    public void setLegRep(String legRep) {
        this.legRep = legRep;
    }


    public String getCertType() {
        return certType;
    }
    public void setCertType(String certType) {
        this.certType = certType;
    }


    public String getCertNo() {
        return certNo;
    }
    public void setCertNo(String certNo) {
        this.certNo = certNo;
    }


    public BigDecimal getRegCap() {
        return regCap;
    }
    public void setRegCap(BigDecimal regCap) {
        this.regCap = regCap;
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
	public String getUnscCode() {
		return unscCode;
	}
	public void setUnscCode(String unscCode) {
		this.unscCode = unscCode;
	}
    
}
