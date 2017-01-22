/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-16
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.biz.crguaranteesuminfo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

/** 
 * 描述: 保函汇总 实体类<br>
 * @author gaotong
 * @date 2015-10-16
 * 
 */
public class CrGuaranteeSumInfo implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private String id;
    // 企业名称
    private String guaEntName;
    // 注册号
    private String guaRegNo;
    // 信用证汇总(折人民币)
    private BigDecimal guaSum;
    // 授信机构
    private String guaCerInst;
    // 五级分类
    private String guaGradeType;
    // 币种
    private String guaCurrency;
    // 保函种类
    private String guaType;
    // 保证金比例
    private BigDecimal guaBondRatio;
    // 金额
    private BigDecimal guaAmount;
    // 开证日期
    private Date guaOpenDate;
    // 担保
    private String guaGuarantee;
    // 可用余额
    private BigDecimal guaBalance;
    // 到期日期
    private Date guaDeadlineDate;
    // 垫款
    private String guaAdvance;
    // 企业内部序号
    private String corpid;
    // 用户id
    private String guaUserid;
    // 添加时间
    private Date guaOptTime;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public String getGuaEntName() {
        return guaEntName;
    }
    public void setGuaEntName(String guaEntName) {
        this.guaEntName = guaEntName;
    }


    public String getGuaRegNo() {
        return guaRegNo;
    }
    public void setGuaRegNo(String guaRegNo) {
        this.guaRegNo = guaRegNo;
    }


    public BigDecimal getGuaSum() {
        return guaSum;
    }
    public void setGuaSum(BigDecimal guaSum) {
        this.guaSum = guaSum;
    }


    public String getGuaCerInst() {
        return guaCerInst;
    }
    public void setGuaCerInst(String guaCerInst) {
        this.guaCerInst = guaCerInst;
    }


    public String getGuaGradeType() {
        return guaGradeType;
    }
    public void setGuaGradeType(String guaGradeType) {
        this.guaGradeType = guaGradeType;
    }


    public String getGuaCurrency() {
        return guaCurrency;
    }
    public void setGuaCurrency(String guaCurrency) {
        this.guaCurrency = guaCurrency;
    }


    public String getGuaType() {
        return guaType;
    }
    public void setGuaType(String guaType) {
        this.guaType = guaType;
    }


    public BigDecimal getGuaBondRatio() {
        return guaBondRatio;
    }
    public void setGuaBondRatio(BigDecimal guaBondRatio) {
        this.guaBondRatio = guaBondRatio;
    }


    public BigDecimal getGuaAmount() {
        return guaAmount;
    }
    public void setGuaAmount(BigDecimal guaAmount) {
        this.guaAmount = guaAmount;
    }

    @JSON(format = "yyyy/MM/dd")
    public Date getGuaOpenDate() {
        return guaOpenDate;
    }
    public void setGuaOpenDate(Date guaOpenDate) {
        this.guaOpenDate = guaOpenDate;
    }


    public String getGuaGuarantee() {
        return guaGuarantee;
    }
    public void setGuaGuarantee(String guaGuarantee) {
    	if(guaGuarantee.equals("1")){
    		this.guaGuarantee = "有";
    	}else{
    		this.guaGuarantee = "无";
    	}
    }


    public BigDecimal getGuaBalance() {
        return guaBalance;
    }
    public void setGuaBalance(BigDecimal guaBalance) {
        this.guaBalance = guaBalance;
    }

    @JSON(format = "yyyy/MM/dd")
    public Date getGuaDeadlineDate() {
        return guaDeadlineDate;
    }
    public void setGuaDeadlineDate(Date guaDeadlineDate) {
        this.guaDeadlineDate = guaDeadlineDate;
    }


    public String getGuaAdvance() {
        return guaAdvance;
    }
    public void setGuaAdvance(String guaAdvance) {
        this.guaAdvance = guaAdvance;
    }


    public String getCorpid() {
        return corpid;
    }
    public void setCorpid(String corpid) {
        this.corpid = corpid;
    }


    public String getGuaUserid() {
        return guaUserid;
    }
    public void setGuaUserid(String guaUserid) {
        this.guaUserid = guaUserid;
    }


    public Date getGuaOptTime() {
        return guaOptTime;
    }
    public void setGuaOptTime(Date guaOptTime) {
        this.guaOptTime = guaOptTime;
    }

}
