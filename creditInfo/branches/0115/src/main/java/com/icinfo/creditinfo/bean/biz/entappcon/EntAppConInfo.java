/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author 朱勇
 * @date 2015-01-23
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.biz.entappcon;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;

/** 
 * 描述: 企业核准内容 实体类<br>
 * @author 朱勇
 * @date 2015-01-23
 * 
 */
public class EntAppConInfo implements Serializable{

    private static final long	serialVersionUID	= 1L;

    //内部序号 nbxh
    private String corpid;
    // 企业名称 qymc
    private String appConEntName;
    // 注册号 zch
    private String appConRegNo;
    // 法定代表人 fddbr
    private String appConLegRep;
    // 成立日期 CLRQ
    private String entEstDateStr;
    // 住所地址 zs
    private String appConLoc;
    //统一信用代码
    private String entUnscId;
    //税务登记号
    private String entTaxRegNo;
    //组织机构代码号
    private String entOrgRegNo; 
    
    
	public String getCorpid() {
		return corpid;
	}
	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}
	public String getAppConEntName() {
		return appConEntName;
	}
	public void setAppConEntName(String appConEntName) {
		this.appConEntName = appConEntName;
	}
	public String getAppConRegNo() {
		return appConRegNo;
	}
	public void setAppConRegNo(String appConRegNo) {
		this.appConRegNo = appConRegNo;
	}
	public String getAppConLegRep() {
		return appConLegRep;
	}
	public void setAppConLegRep(String appConLegRep) {
		this.appConLegRep = appConLegRep;
	}
	public String getAppConLoc() {
		return appConLoc;
	}
	public void setAppConLoc(String appConLoc) {
		this.appConLoc = appConLoc;
	}
	public String getEntEstDateStr() {
		return entEstDateStr;
	}
	public void setEntEstDateStr(String entEstDateStr) {
		this.entEstDateStr = entEstDateStr;
	}
	public String getEntUnscId() {
		return entUnscId;
	}
	public void setEntUnscId(String entUnscId) {
		this.entUnscId = entUnscId;
	}
	public String getEntTaxRegNo() {
		return entTaxRegNo;
	}
	public void setEntTaxRegNo(String entTaxRegNo) {
		this.entTaxRegNo = entTaxRegNo;
	}
	public String getEntOrgRegNo() {
		return entOrgRegNo;
	}
	public void setEntOrgRegNo(String entOrgRegNo) {
		this.entOrgRegNo = entOrgRegNo;
	}
	
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
