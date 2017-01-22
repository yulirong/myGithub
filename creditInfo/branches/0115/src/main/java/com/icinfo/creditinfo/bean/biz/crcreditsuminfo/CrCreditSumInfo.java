/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-16
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.biz.crcreditsuminfo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

/** 
 * 描述: 信用证汇总 实体类<br>
 * @author gaotong
 * @date 2015-10-16
 * 
 */
public class CrCreditSumInfo implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private String id;
    // 企业名称
    private String creEntName;
    // 注册号
    private String creRegNo;
    // 信用证汇总(折人民币)
    private BigDecimal creSum;
    // 授信机构
    private String creCerInst;
    // 五级分类
    private String creGradeType;
    // 币种
    private String creCurrency;
    // 保证金比例
    private BigDecimal creBondRatio;
    // 开证金额
    private BigDecimal creOpenAmount;
    // 开证日期
    private Date creOpenDate;
    // 担保
    private String creGuarantee;
    // 可用余额
    private BigDecimal creUseBalance;
    // 到期日期
    private Date creDeadlineDate;
    // 垫款
    private String creAdvance;
    // 企业内部序号
    private String corpid;
    // 用户id
    private String creUserid;
    // 添加时间
    private Date creOptTime;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public String getCreEntName() {
        return creEntName;
    }
    public void setCreEntName(String creEntName) {
        this.creEntName = creEntName;
    }


    public String getCreRegNo() {
        return creRegNo;
    }
    public void setCreRegNo(String creRegNo) {
        this.creRegNo = creRegNo;
    }


    public BigDecimal getCreSum() {
        return creSum;
    }
    public void setCreSum(BigDecimal creSum) {
        this.creSum = creSum;
    }


    public String getCreCerInst() {
        return creCerInst;
    }
    public void setCreCerInst(String creCerInst) {
        this.creCerInst = creCerInst;
    }


    public String getCreGradeType() {
        return creGradeType;
    }
    public void setCreGradeType(String creGradeType) {
        this.creGradeType = creGradeType;
    }


    public String getCreCurrency() {
        return creCurrency;
    }
    public void setCreCurrency(String creCurrency) {
        this.creCurrency = creCurrency;
    }


    public BigDecimal getCreBondRatio() {
        return creBondRatio;
    }
    public void setCreBondRatio(BigDecimal creBondRatio) {
        this.creBondRatio = creBondRatio;
    }


    public BigDecimal getCreOpenAmount() {
        return creOpenAmount;
    }
    public void setCreOpenAmount(BigDecimal creOpenAmount) {
        this.creOpenAmount = creOpenAmount;
    }

    @JSON(format = "yyyy/MM/dd")
    public Date getCreOpenDate() {
        return creOpenDate;
    }
    public void setCreOpenDate(Date creOpenDate) {
        this.creOpenDate = creOpenDate;
    }


    public String getCreGuarantee() {
        return creGuarantee;
    }
    public void setCreGuarantee(String creGuarantee) {
    	if(creGuarantee.equals("1")){
    		this.creGuarantee = "有";
    	}else{
    		this.creGuarantee = "无";
    	}
    }


    public BigDecimal getCreUseBalance() {
        return creUseBalance;
    }
    public void setCreUseBalance(BigDecimal creUseBalance) {
        this.creUseBalance = creUseBalance;
    }

    @JSON(format = "yyyy/MM/dd")
    public Date getCreDeadlineDate() {
        return creDeadlineDate;
    }
    public void setCreDeadlineDate(Date creDeadlineDate) {
        this.creDeadlineDate = creDeadlineDate;
    }


    public String getCreAdvance() {
        return creAdvance;
    }
    public void setCreAdvance(String creAdvance) {
        this.creAdvance = creAdvance;
    }


    public String getCorpid() {
        return corpid;
    }
    public void setCorpid(String corpid) {
        this.corpid = corpid;
    }


    public String getCreUserid() {
        return creUserid;
    }
    public void setCreUserid(String creUserid) {
        this.creUserid = creUserid;
    }


    public Date getCreOptTime() {
        return creOptTime;
    }
    public void setCreOptTime(Date creOptTime) {
        this.creOptTime = creOptTime;
    }

}
