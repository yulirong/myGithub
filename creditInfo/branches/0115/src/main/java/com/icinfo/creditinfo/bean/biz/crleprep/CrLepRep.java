/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author mayawei
 * @date 2015-10-26
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.biz.crleprep;

import java.io.Serializable;

/** 
 * 描述: 企业法人代表 实体类<br>
 * @author mayawei
 * @date 2015-10-26
 * 
 */
public class CrLepRep implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private String id;
    // 
    private String corpid;
    // 
    private String lepName;
    // 
    private String lepSex;
    // 
    private String lepCertNo;
    // 
    private String lepCertType;
    // 
    private String lepAddress;
    // 
    private String lepCountry;
    // 
    private String lepTel;
    
    //辅助字段
    private Integer lepRepCount;
    private String entName;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public String getCorpid() {
        return corpid;
    }
    public void setCorpid(String corpid) {
        this.corpid = corpid;
    }


    public String getLepName() {
        return lepName;
    }
    public void setLepName(String lepName) {
        this.lepName = lepName;
    }


    public String getLepSex() {
        return lepSex;
    }
    public void setLepSex(String lepSex) {
        this.lepSex = lepSex;
    }


    public String getLepCertNo() {
        return lepCertNo;
    }
    public void setLepCertNo(String lepCertNo) {
        this.lepCertNo = lepCertNo;
    }


    public String getLepCertType() {
        return lepCertType;
    }
    public void setLepCertType(String lepCertType) {
        this.lepCertType = lepCertType;
    }


    public String getLepAddress() {
        return lepAddress;
    }
    public void setLepAddress(String lepAddress) {
        this.lepAddress = lepAddress;
    }


    public String getLepCountry() {
        return lepCountry;
    }
    public void setLepCountry(String lepCountry) {
        this.lepCountry = lepCountry;
    }


    public String getLepTel() {
        return lepTel;
    }
    public void setLepTel(String lepTel) {
        this.lepTel = lepTel;
    }
    
	public Integer getLepRepCount() {
		return lepRepCount;
	}
	public void setLepRepCount(Integer lepRepCount) {
		this.lepRepCount = lepRepCount;
	}
	public String getEntName() {
		return entName;
	}
	public void setEntName(String entName) {
		this.entName = entName;
	}


    
}
