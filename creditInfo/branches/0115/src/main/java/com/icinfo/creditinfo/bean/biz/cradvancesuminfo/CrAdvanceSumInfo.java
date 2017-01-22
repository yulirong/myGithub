/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-16
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.biz.cradvancesuminfo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

/** 
 * 描述: 垫款汇总 实体类<br>
 * @author gaotong
 * @date 2015-10-16
 * 
 */
public class CrAdvanceSumInfo implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private String id;
    // 企业名称
    private String advEntName;
    // 注册号
    private String advRegNo;
    // 信用证汇总(折人民币)
    private BigDecimal advSum;
    // 授信机构
    private String advCerInst;
    // 币种
    private String advCurrency;
    // 金额
    private BigDecimal advAmount;
    // 余额
    private BigDecimal advBalance;
    // 垫款日期
    private Date advDate;
    // 五级分类
    private String advGradeType;
    // 原业务
    private String advOrgBiz;
    // 企业内部序号
    private String corpid;
    // 用户id
    private String advUserid;
    // 添加时间
    private Date advOptTime;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public String getAdvEntName() {
        return advEntName;
    }
    public void setAdvEntName(String advEntName) {
        this.advEntName = advEntName;
    }


    public String getAdvRegNo() {
        return advRegNo;
    }
    public void setAdvRegNo(String advRegNo) {
        this.advRegNo = advRegNo;
    }


    public BigDecimal getAdvSum() {
        return advSum;
    }
    public void setAdvSum(BigDecimal advSum) {
        this.advSum = advSum;
    }


    public String getAdvCerInst() {
        return advCerInst;
    }
    public void setAdvCerInst(String advCerInst) {
        this.advCerInst = advCerInst;
    }


    public String getAdvCurrency() {
        return advCurrency;
    }
    public void setAdvCurrency(String advCurrency) {
        this.advCurrency = advCurrency;
    }


    public BigDecimal getAdvAmount() {
        return advAmount;
    }
    public void setAdvAmount(BigDecimal advAmount) {
        this.advAmount = advAmount;
    }


    public BigDecimal getAdvBalance() {
        return advBalance;
    }
    public void setAdvBalance(BigDecimal advBalance) {
        this.advBalance = advBalance;
    }

@JSON(format = "yyyy/MM/dd")
    public Date getAdvDate() {
        return advDate;
    }
    public void setAdvDate(Date advDate) {
        this.advDate = advDate;
    }


    public String getAdvGradeType() {
        return advGradeType;
    }
    public void setAdvGradeType(String advGradeType) {
        this.advGradeType = advGradeType;
    }


    public String getAdvOrgBiz() {
        return advOrgBiz;
    }
    public void setAdvOrgBiz(String advOrgBiz) {
        this.advOrgBiz = advOrgBiz;
    }


    public String getCorpid() {
        return corpid;
    }
    public void setCorpid(String corpid) {
        this.corpid = corpid;
    }


    public String getAdvUserid() {
        return advUserid;
    }
    public void setAdvUserid(String advUserid) {
        this.advUserid = advUserid;
    }


    public Date getAdvOptTime() {
        return advOptTime;
    }
    public void setAdvOptTime(Date advOptTime) {
        this.advOptTime = advOptTime;
    }

}
