/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-12-22
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.upload.templandsequestrate;

import java.io.Serializable;
import java.util.Date;

/** 
 * 描述: 土地查封 实体类<br>
 * @author yulirong
 * @date 2015-12-22
 * 
 */
public class TempLandSequestrate implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private String id;
    // 查封文号
    private String sequestrateNo;
    // 查封土地坐落
    private String sequestrateLoc;
    // 产权人
    private String propertyOwner;
    // 产权人证件类型
    private String propertyOwnerCertType;
    // 产权人证件号
    private String propertyOwnerCertNo;
    // 查封期限起
    private Date sequestrateDateFrom;
    // 查封期限至
    private Date sequestrateDateTo;
    // 查封法院
    private String sequestrateCourt;
    // 土地证号
    private String landNo;
    // 
    private String importFrom;
    // 
    private Date importDate;
    // 企业内部序号
    private String corpid;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public String getSequestrateNo() {
        return sequestrateNo;
    }
    public void setSequestrateNo(String sequestrateNo) {
        this.sequestrateNo = sequestrateNo;
    }


    public String getSequestrateLoc() {
        return sequestrateLoc;
    }
    public void setSequestrateLoc(String sequestrateLoc) {
        this.sequestrateLoc = sequestrateLoc;
    }


    public String getPropertyOwner() {
        return propertyOwner;
    }
    public void setPropertyOwner(String propertyOwner) {
        this.propertyOwner = propertyOwner;
    }


    public String getPropertyOwnerCertType() {
        return propertyOwnerCertType;
    }
    public void setPropertyOwnerCertType(String propertyOwnerCertType) {
        this.propertyOwnerCertType = propertyOwnerCertType;
    }


    public String getPropertyOwnerCertNo() {
        return propertyOwnerCertNo;
    }
    public void setPropertyOwnerCertNo(String propertyOwnerCertNo) {
        this.propertyOwnerCertNo = propertyOwnerCertNo;
    }


    public Date getSequestrateDateFrom() {
        return sequestrateDateFrom;
    }
    public void setSequestrateDateFrom(Date sequestrateDateFrom) {
        this.sequestrateDateFrom = sequestrateDateFrom;
    }


    public Date getSequestrateDateTo() {
        return sequestrateDateTo;
    }
    public void setSequestrateDateTo(Date sequestrateDateTo) {
        this.sequestrateDateTo = sequestrateDateTo;
    }


    public String getSequestrateCourt() {
        return sequestrateCourt;
    }
    public void setSequestrateCourt(String sequestrateCourt) {
        this.sequestrateCourt = sequestrateCourt;
    }


    public String getLandNo() {
        return landNo;
    }
    public void setLandNo(String landNo) {
        this.landNo = landNo;
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

}
