package com.icinfo.creditinfo.bean.upload.temppunish;
/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-10
 * @version 1.0
 */

import java.io.Serializable;
import java.util.Date;

/** 
 * 描述: 行政处罚 实体类<br>
 * @author gaotong
 * @date 2015-11-10
 * 
 */
public class TempPunish implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private String id;
    // 所属地区行政区划编码
    private String areaCode;
    // 所属地区名称
    private String punRegionName;
    // 执法部门名称
    private String punOrgName;
    // 执法部门组织编码
    private String punOrgId;
    // 行政处罚决定书文号
    private String punDocno;
    // 案件名称
    private String punCaseName;
    // 被处罚对象类别
    private String punishedType;
    // 被处罚对象名称
    private String punishedName;
    // 被处罚对象证件类型
    private String punishedCertType;
    // 被处罚对象证件号码
    private String punishedCertNo;
    // 被处罚对象单位法定代表人姓名
    private String punishedLegRep;
    // 被处罚对象单位法定代表人证件类型
    private String punishedLegRepCertType;
    // 被处罚单位法定代表人证件号
    private String punishedLegRepCertno;
    // 行政处罚权力事项名称
    private String punItemName;
    // 权力内部编码（权力事项唯一码）
    private String punItemId;
    // 对外公开的行政处罚决定书全文或摘要
    private String punAbstract;
    // 作出行政处罚的日期
    private Date punDate;
    // 状态标记
    private String punState;
    // 撤销处罚的原因说明
    private String punCancel;
    // 
    private String importFrom;
    // 
    private Date importDate;
    // 企业内部序号
    private String corpid;
    //涉案金额
    private String caseMoney;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public String getAreaCode() {
        return areaCode;
    }
    public void setAreaCode(String areaCode) {
        this.areaCode = areaCode;
    }


    public String getPunRegionName() {
        return punRegionName;
    }
    public void setPunRegionName(String punRegionName) {
        this.punRegionName = punRegionName;
    }


    public String getPunOrgName() {
        return punOrgName;
    }
    public void setPunOrgName(String punOrgName) {
        this.punOrgName = punOrgName;
    }


    public String getPunOrgId() {
        return punOrgId;
    }
    public void setPunOrgId(String punOrgId) {
        this.punOrgId = punOrgId;
    }


    public String getPunDocno() {
        return punDocno;
    }
    public void setPunDocno(String punDocno) {
        this.punDocno = punDocno;
    }


    public String getPunCaseName() {
        return punCaseName;
    }
    public void setPunCaseName(String punCaseName) {
        this.punCaseName = punCaseName;
    }


    public String getPunishedType() {
        return punishedType;
    }
    public void setPunishedType(String punishedType) {
        this.punishedType = punishedType;
    }


    public String getPunishedName() {
        return punishedName;
    }
    public void setPunishedName(String punishedName) {
        this.punishedName = punishedName;
    }


    public String getPunishedCertType() {
        return punishedCertType;
    }
    public void setPunishedCertType(String punishedCertType) {
        this.punishedCertType = punishedCertType;
    }


    public String getPunishedCertNo() {
        return punishedCertNo;
    }
    public void setPunishedCertNo(String punishedCertNo) {
        this.punishedCertNo = punishedCertNo;
    }


    public String getPunishedLegRep() {
        return punishedLegRep;
    }
    public void setPunishedLegRep(String punishedLegRep) {
        this.punishedLegRep = punishedLegRep;
    }


    public String getPunishedLegRepCertType() {
        return punishedLegRepCertType;
    }
    public void setPunishedLegRepCertType(String punishedLegRepCertType) {
        this.punishedLegRepCertType = punishedLegRepCertType;
    }


    public String getPunishedLegRepCertno() {
        return punishedLegRepCertno;
    }
    public void setPunishedLegRepCertno(String punishedLegRepCertno) {
        this.punishedLegRepCertno = punishedLegRepCertno;
    }


    public String getPunItemName() {
        return punItemName;
    }
    public void setPunItemName(String punItemName) {
        this.punItemName = punItemName;
    }


    public String getPunItemId() {
        return punItemId;
    }
    public void setPunItemId(String punItemId) {
        this.punItemId = punItemId;
    }


    public String getPunAbstract() {
        return punAbstract;
    }
    public void setPunAbstract(String punAbstract) {
        this.punAbstract = punAbstract;
    }


    public Date getPunDate() {
        return punDate;
    }
    public void setPunDate(Date punDate) {
        this.punDate = punDate;
    }


    public String getPunState() {
        return punState;
    }
    public void setPunState(String punState) {
        this.punState = punState;
    }


    public String getPunCancel() {
        return punCancel;
    }
    public void setPunCancel(String punCancel) {
        this.punCancel = punCancel;
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
	public String getCaseMoney() {
		return caseMoney;
	}
	public void setCaseMoney(String caseMoney) {
		this.caseMoney = caseMoney;
	}
    
}
