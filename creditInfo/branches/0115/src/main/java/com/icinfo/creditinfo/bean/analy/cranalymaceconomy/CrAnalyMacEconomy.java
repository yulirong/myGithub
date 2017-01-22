/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-11-06
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.analy.cranalymaceconomy;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * 描述: 宏观经济 实体类<br>
 * @author yulirong
 * @date 2015-11-06
 * 
 */
public class CrAnalyMacEconomy implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private BigDecimal id;
    // 
    private String ecoMonth;
    // 行业编码
    private String ecoTradeCode;
    // 
    private String ecoSupTradeCode;
    // 资产总额
    private BigDecimal ecoAssGro;
    // 营业收入
    private BigDecimal ecoVendInc;
    // 利润总额
    private BigDecimal ecoProGro;
    // 纳税总额
    private BigDecimal ecoPartGro;
    // 进口额
    private BigDecimal ecoImpAmount;
    // 出口额
    private BigDecimal ecoExpAmount;
    // 生成日期
    private Date ecoCreateDate;


    public BigDecimal getId() {
        return id;
    }
    public void setId(BigDecimal id) {
        this.id = id;
    }


    public String getEcoMonth() {
        return ecoMonth;
    }
    public void setEcoMonth(String ecoMonth) {
        this.ecoMonth = ecoMonth;
    }


    public String getEcoTradeCode() {
        return ecoTradeCode;
    }
    public void setEcoTradeCode(String ecoTradeCode) {
        this.ecoTradeCode = ecoTradeCode;
    }


    public String getEcoSupTradeCode() {
        return ecoSupTradeCode;
    }
    public void setEcoSupTradeCode(String ecoSupTradeCode) {
        this.ecoSupTradeCode = ecoSupTradeCode;
    }


    public BigDecimal getEcoAssGro() {
        return ecoAssGro;
    }
    public void setEcoAssGro(BigDecimal ecoAssGro) {
        this.ecoAssGro = ecoAssGro;
    }


    public BigDecimal getEcoVendInc() {
        return ecoVendInc;
    }
    public void setEcoVendInc(BigDecimal ecoVendInc) {
        this.ecoVendInc = ecoVendInc;
    }


    public BigDecimal getEcoProGro() {
        return ecoProGro;
    }
    public void setEcoProGro(BigDecimal ecoProGro) {
        this.ecoProGro = ecoProGro;
    }


    public BigDecimal getEcoPartGro() {
        return ecoPartGro;
    }
    public void setEcoPartGro(BigDecimal ecoPartGro) {
        this.ecoPartGro = ecoPartGro;
    }


    public BigDecimal getEcoImpAmount() {
        return ecoImpAmount;
    }
    public void setEcoImpAmount(BigDecimal ecoImpAmount) {
        this.ecoImpAmount = ecoImpAmount;
    }


    public BigDecimal getEcoExpAmount() {
        return ecoExpAmount;
    }
    public void setEcoExpAmount(BigDecimal ecoExpAmount) {
        this.ecoExpAmount = ecoExpAmount;
    }


    public Date getEcoCreateDate() {
        return ecoCreateDate;
    }
    public void setEcoCreateDate(Date ecoCreateDate) {
        this.ecoCreateDate = ecoCreateDate;
    }

}
