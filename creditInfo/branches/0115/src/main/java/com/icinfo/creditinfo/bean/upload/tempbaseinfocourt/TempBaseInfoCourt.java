/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.upload.tempbaseinfocourt;

import java.io.Serializable;
import java.util.Date;

/** 
 * 描述: 法院当然人基本情况表 实体类<br>
 * @author gaotong
 * @date 2015-11-12
 * 
 */
public class TempBaseInfoCourt implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private String id;
    // 案号
    private String caseNo;
    // 当事人类型
    private String partyType;
    // 诉讼地位
    private String legStatus;
    // 当事人名称
    private String partyName;
    // 证件类型
    private String certType;
    // 证件号
    private String certNo;
    // 单位类型
    private String entType;
    // 地址
    private String addr;
    // 联系电话
    private String tel;
    // 性别
    private String gender;
    // 出生日期
    private Date birth;
    // 国籍
    private String nationality;
    // 民族
    private String nation;
    // 文化程度
    private String edu;
    // 职业
    private String profession;
    // 法定代表人姓名
    private String legRepName;
    // 法定代表人证件类型
    private String legRepCertType;
    // 法定代表人证件号
    private String legRepCertNo;
    // 
    private String zipCode;
    // 
    private String orgCode;
    // 导入来源
    private String importFrom;
    // 导入日期
    private Date importDate;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public String getCaseNo() {
        return caseNo;
    }
    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }


    public String getPartyType() {
        return partyType;
    }
    public void setPartyType(String partyType) {
        this.partyType = partyType;
    }


    public String getLegStatus() {
        return legStatus;
    }
    public void setLegStatus(String legStatus) {
        this.legStatus = legStatus;
    }


    public String getPartyName() {
        return partyName;
    }
    public void setPartyName(String partyName) {
        this.partyName = partyName;
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


    public String getEntType() {
        return entType;
    }
    public void setEntType(String entType) {
        this.entType = entType;
    }


    public String getAddr() {
        return addr;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }


    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }


    public String getGender() {
        return gender;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }


    public Date getBirth() {
        return birth;
    }
    public void setBirth(Date birth) {
        this.birth = birth;
    }


    public String getNationality() {
        return nationality;
    }
    public void setNationality(String nationality) {
        this.nationality = nationality;
    }


    public String getNation() {
        return nation;
    }
    public void setNation(String nation) {
        this.nation = nation;
    }


    public String getEdu() {
        return edu;
    }
    public void setEdu(String edu) {
        this.edu = edu;
    }


    public String getProfession() {
        return profession;
    }
    public void setProfession(String profession) {
        this.profession = profession;
    }


    public String getLegRepName() {
        return legRepName;
    }
    public void setLegRepName(String legRepName) {
        this.legRepName = legRepName;
    }


    public String getLegRepCertType() {
        return legRepCertType;
    }
    public void setLegRepCertType(String legRepCertType) {
        this.legRepCertType = legRepCertType;
    }


    public String getLegRepCertNo() {
        return legRepCertNo;
    }
    public void setLegRepCertNo(String legRepCertNo) {
        this.legRepCertNo = legRepCertNo;
    }


    public String getZipCode() {
        return zipCode;
    }
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }


    public String getOrgCode() {
        return orgCode;
    }
    public void setOrgCode(String orgCode) {
        this.orgCode = orgCode;
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

}
