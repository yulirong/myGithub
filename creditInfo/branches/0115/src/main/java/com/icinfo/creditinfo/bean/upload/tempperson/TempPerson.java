/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-11
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.upload.tempperson;

import java.io.Serializable;
import java.util.Date;

/** 
 * 描述: 基本信息 实体类<br>
 * @author liyafeng
 * @date 2015-11-11
 * 
 */
public class TempPerson implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private String id;
    // 名称
    private String name;
    // 证件类型
    private String certType;
    // 证件号
    private String certNo;
    // 电话
    private String tel;
    // 地址
    private String addr;
    // 配偶姓名
    private String spouseName;
    // 配偶证件类型
    private String spouseCertType;
    // 配偶证件号
    private String spouseCertNo;
    // 
    private String importFrom;
    // 
    private Date importDate;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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


    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }


    public String getAddr() {
        return addr;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }


    public String getSpouseName() {
        return spouseName;
    }
    public void setSpouseName(String spouseName) {
        this.spouseName = spouseName;
    }


    public String getSpouseCertType() {
        return spouseCertType;
    }
    public void setSpouseCertType(String spouseCertType) {
        this.spouseCertType = spouseCertType;
    }


    public String getSpouseCertNo() {
        return spouseCertNo;
    }
    public void setSpouseCertNo(String spouseCertNo) {
        this.spouseCertNo = spouseCertNo;
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
