/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-20
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.biz.crentbaseinfo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * 描述: 企业基本信息 实体类<br>
 * @author yulirong
 * @date 2015-10-20
 * 
 */
public class CrEntBaseInfo implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private String id;
    // 企业内部序号
    private String corpid;
    // 企业名称
    private String entName;
    // 注册号
    private String entRegNo;
    // 注册地址
    private String entRegLoc;
    // 经营地址
    private String entRunLoc;
    // 邮编
    private String entPost;
    // 电话
    private String entTel;
    // 法定代表人
    private String entLepRep;
    // 身份证
    private String entCertCode;
    // 企业类型
    private String entType;
    // 企业类型大类
    private String entTypeCatg;
    // 行业--zhongwen
    private String entTrade;
    // 注册资本
    private BigDecimal entRegCap;
    // 币种
    private String entCurrency;
    // 经营范围
    private String entMgrScope;
    // 核准日期
    private Date entCheckDate;
    // 登记机关
    private String entRegOrg;
    // 管辖单位
    private String entJur;
    // 企业状态
    private String entState;
    // 实缴资本
    private BigDecimal entInCap;
    // 一般经营项目
    private String entBusItem;
    // 成立日期
    private Date entEstDate;
    // 经营期限开始
    private Date entMgrBegin;
    // 经营期限结束
    private Date entMgrEnd;
    // 统一信用代码
    private String entUnscId;
    // 组织机构代码号
    private String entOrgRegNo;
    // 税务登记号
    private String entTaxRegNo;
    // 从业人数
    private Integer entManCount;
 // 行业--bianma 
    private String entRealTrade;
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


    public String getEntName() {
        return entName;
    }
    public void setEntName(String entName) {
        this.entName = entName;
    }


    public String getEntRegNo() {
        return entRegNo;
    }
    public void setEntRegNo(String entRegNo) {
        this.entRegNo = entRegNo;
    }


    public String getEntRegLoc() {
        return entRegLoc;
    }
    public void setEntRegLoc(String entRegLoc) {
        this.entRegLoc = entRegLoc;
    }


    public String getEntRunLoc() {
        return entRunLoc;
    }
    public void setEntRunLoc(String entRunLoc) {
        this.entRunLoc = entRunLoc;
    }


    public String getEntPost() {
        return entPost;
    }
    public void setEntPost(String entPost) {
        this.entPost = entPost;
    }


    public String getEntTel() {
        return entTel;
    }
    public void setEntTel(String entTel) {
        this.entTel = entTel;
    }


    public String getEntLepRep() {
        return entLepRep;
    }
    public void setEntLepRep(String entLepRep) {
        this.entLepRep = entLepRep;
    }


    public String getEntCertCode() {
        return entCertCode;
    }
    public void setEntCertCode(String entCertCode) {
        this.entCertCode = entCertCode;
    }


    public String getEntType() {
        return entType;
    }
    public void setEntType(String entType) {
        this.entType = entType;
    }


    public String getEntTypeCatg() {
        return entTypeCatg;
    }
    public void setEntTypeCatg(String entTypeCatg) {
        this.entTypeCatg = entTypeCatg;
    }


    public String getEntTrade() {
        return entTrade;
    }
    public void setEntTrade(String entTrade) {
        this.entTrade = entTrade;
    }


    public BigDecimal getEntRegCap() {
        return entRegCap;
    }
    public void setEntRegCap(BigDecimal entRegCap) {
        this.entRegCap = entRegCap;
    }


    public String getEntCurrency() {
        return entCurrency;
    }
    public void setEntCurrency(String entCurrency) {
        this.entCurrency = entCurrency;
    }


    public String getEntMgrScope() {
        return entMgrScope;
    }
    public void setEntMgrScope(String entMgrScope) {
        this.entMgrScope = entMgrScope;
    }


    public Date getEntCheckDate() {
        return entCheckDate;
    }
    public void setEntCheckDate(Date entCheckDate) {
        this.entCheckDate = entCheckDate;
    }


    public String getEntRegOrg() {
        return entRegOrg;
    }
    public void setEntRegOrg(String entRegOrg) {
        this.entRegOrg = entRegOrg;
    }


    public String getEntJur() {
        return entJur;
    }
    public void setEntJur(String entJur) {
        this.entJur = entJur;
    }


    public String getEntState() {
        return entState;
    }
    public void setEntState(String entState) {
        this.entState = entState;
    }


    public BigDecimal getEntInCap() {
        return entInCap;
    }
    public void setEntInCap(BigDecimal entInCap) {
        this.entInCap = entInCap;
    }


    public String getEntBusItem() {
        return entBusItem;
    }
    public void setEntBusItem(String entBusItem) {
        this.entBusItem = entBusItem;
    }


    public Date getEntEstDate() {
        return entEstDate;
    }
    public void setEntEstDate(Date entEstDate) {
        this.entEstDate = entEstDate;
    }


    public Date getEntMgrBegin() {
        return entMgrBegin;
    }
    public void setEntMgrBegin(Date entMgrBegin) {
        this.entMgrBegin = entMgrBegin;
    }


    public Date getEntMgrEnd() {
        return entMgrEnd;
    }
    public void setEntMgrEnd(Date entMgrEnd) {
        this.entMgrEnd = entMgrEnd;
    }


    public String getEntUnscId() {
        return entUnscId;
    }
    public void setEntUnscId(String entUnscId) {
        this.entUnscId = entUnscId;
    }


    public String getEntOrgRegNo() {
        return entOrgRegNo;
    }
    public void setEntOrgRegNo(String entOrgRegNo) {
        this.entOrgRegNo = entOrgRegNo;
    }


    public String getEntTaxRegNo() {
        return entTaxRegNo;
    }
    public void setEntTaxRegNo(String entTaxRegNo) {
        this.entTaxRegNo = entTaxRegNo;
    }
	public Integer getEntManCount() {
		return entManCount;
	}
	public void setEntManCount(Integer entManCount) {
		this.entManCount = entManCount;
	}
	/**
	 * 描述: 得到企业经营状态 1、吊销2、注销3、吊销备案4、迁出5、正常开业
	 * 
	 * @author 余力荣
	 * @date 2015-11-14
	 * @return
	 */
	public String getEntStateDesc() {
		if ("D".equals(this.entState)) {
			return "吊销";
		}
		if ("X".equals(this.entState)) {
			return "注销";
		}
		if ("DA".equals(this.entState)) {
			return "吊销备案";
		}
		if ("Q".equals(this.entState)) {
			return "迁出";
		}
		return "正常开业";
	}
	public String getEntRealTrade() {
		return entRealTrade;
	}
	public void setEntRealTrade(String entRealTrade) {
		this.entRealTrade = entRealTrade;
	}


}
