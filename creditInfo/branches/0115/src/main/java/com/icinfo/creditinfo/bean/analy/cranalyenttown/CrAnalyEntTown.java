/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-11-28
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.analy.cranalyenttown;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * 描述: 特色小镇 实体类<br>
 * @author yulirong
 * @date 2015-11-28
 * 
 */
public class CrAnalyEntTown implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private BigDecimal id;
    // 年度
    private BigDecimal entYear;
    // 月度
    private BigDecimal entMonth;
    // 行业
    private String trade;
    // 规模 1:10万以下，2:10-20万
    private String qyScale;
    // 管辖单位
    private String regUnit;
    // 企业数量
    private BigDecimal qyCount;
    // 规模统计
    private BigDecimal qyScaleCount;
    // 资产总额
    private BigDecimal totalAssets;
    // 营业收入
    private BigDecimal income;
    // 用电量
    private BigDecimal elecNum;
    // 用水量
    private BigDecimal waterNum;
    // 利润
    private BigDecimal netProfit;
    // 纳税
    private BigDecimal tax;
    // 人数
    private BigDecimal socialSecurityNum;
    // e游小镇
    private BigDecimal charactTownEy;
    // 杭州湾花田小镇
    private BigDecimal charactTownHzwht;
    // 伞艺小镇
    private BigDecimal charactTownSy;
    // 节能环保创新小镇
    private BigDecimal charactTownJnhbcx;
    // 青瓷小镇
    private BigDecimal charactTownQc;
    // 千年古城小镇
    private BigDecimal charactTownQngc;
    // 童装小镇
    private BigDecimal charactTownTz;
    // 吐鲁番小镇
    private BigDecimal charactTownTlf;
    // 休闲养生小镇
    private BigDecimal charactTownXxys;
    // 
    private Date createDate;
    private String time;
    private Double entNum;
    private String myTrade;
    //小镇-名称（）
    private String town;

    public BigDecimal getId() {
        return id;
    }
    public void setId(BigDecimal id) {
        this.id = id;
    }


    public BigDecimal getEntYear() {
        return entYear;
    }
    public void setEntYear(BigDecimal entYear) {
        this.entYear = entYear;
    }


    public BigDecimal getEntMonth() {
        return entMonth;
    }
    public void setEntMonth(BigDecimal entMonth) {
        this.entMonth = entMonth;
    }


    public String getTrade() {
        return trade;
    }
    public void setTrade(String trade) {
        this.trade = trade;
    }


    public String getQyScale() {
        return qyScale;
    }
    public void setQyScale(String qyScale) {
        this.qyScale = qyScale;
    }


    public String getRegUnit() {
        return regUnit;
    }
    public void setRegUnit(String regUnit) {
        this.regUnit = regUnit;
    }


    public BigDecimal getQyCount() {
        return qyCount;
    }
    public void setQyCount(BigDecimal qyCount) {
        this.qyCount = qyCount;
    }


    public BigDecimal getQyScaleCount() {
        return qyScaleCount;
    }
    public void setQyScaleCount(BigDecimal qyScaleCount) {
        this.qyScaleCount = qyScaleCount;
    }


    public BigDecimal getTotalAssets() {
    	if(this.totalAssets == null){
    		return new BigDecimal(0);
    	}
        return totalAssets;
    }
    public void setTotalAssets(BigDecimal totalAssets) {
        this.totalAssets = totalAssets;
    }


    public BigDecimal getIncome() {
    	if(this.income == null){
    		return new BigDecimal(0);
    	}
        return income;
    }
    public void setIncome(BigDecimal income) {
        this.income = income;
    }


    public BigDecimal getElecNum() {
    	if(this.elecNum == null){
    		return new BigDecimal(0);
    	}
        return elecNum;
    }
    public void setElecNum(BigDecimal elecNum) {
        this.elecNum = elecNum;
    }


    public BigDecimal getWaterNum() {
    	if(this.waterNum == null){
    		return new BigDecimal(0);
    	}
        return waterNum;
    }
    public void setWaterNum(BigDecimal waterNum) {
        this.waterNum = waterNum;
    }


    public BigDecimal getNetProfit() {
    	if(this.netProfit == null){
    		return new BigDecimal(0);
    	}
        return netProfit;
    }
    public void setNetProfit(BigDecimal netProfit) {
        this.netProfit = netProfit;
    }


    public BigDecimal getTax() {
    	if(this.tax == null){
    		return new BigDecimal(0);
    	}
        return tax;
    }
    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }


    public BigDecimal getSocialSecurityNum() {
    	if(this.socialSecurityNum == null){
    		return new BigDecimal(0);
    	}
        return socialSecurityNum;
    }
    public void setSocialSecurityNum(BigDecimal socialSecurityNum) {
        this.socialSecurityNum = socialSecurityNum;
    }


    public BigDecimal getCharactTownEy() {
        return charactTownEy;
    }
    public void setCharactTownEy(BigDecimal charactTownEy) {
        this.charactTownEy = charactTownEy;
    }


    public BigDecimal getCharactTownHzwht() {
        return charactTownHzwht;
    }
    public void setCharactTownHzwht(BigDecimal charactTownHzwht) {
        this.charactTownHzwht = charactTownHzwht;
    }


    public BigDecimal getCharactTownSy() {
        return charactTownSy;
    }
    public void setCharactTownSy(BigDecimal charactTownSy) {
        this.charactTownSy = charactTownSy;
    }


    public BigDecimal getCharactTownJnhbcx() {
        return charactTownJnhbcx;
    }
    public void setCharactTownJnhbcx(BigDecimal charactTownJnhbcx) {
        this.charactTownJnhbcx = charactTownJnhbcx;
    }


    public BigDecimal getCharactTownQc() {
        return charactTownQc;
    }
    public void setCharactTownQc(BigDecimal charactTownQc) {
        this.charactTownQc = charactTownQc;
    }


    public BigDecimal getCharactTownQngc() {
        return charactTownQngc;
    }
    public void setCharactTownQngc(BigDecimal charactTownQngc) {
        this.charactTownQngc = charactTownQngc;
    }


    public BigDecimal getCharactTownTz() {
        return charactTownTz;
    }
    public void setCharactTownTz(BigDecimal charactTownTz) {
        this.charactTownTz = charactTownTz;
    }


    public BigDecimal getCharactTownTlf() {
        return charactTownTlf;
    }
    public void setCharactTownTlf(BigDecimal charactTownTlf) {
        this.charactTownTlf = charactTownTlf;
    }


    public BigDecimal getCharactTownXxys() {
        return charactTownXxys;
    }
    public void setCharactTownXxys(BigDecimal charactTownXxys) {
        this.charactTownXxys = charactTownXxys;
    }


    public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public Double getEntNum() {
		return entNum;
	}
	public void setEntNum(Double entNum) {
		this.entNum = entNum;
	}
	public String getMyTrade() {
		return myTrade;
	}
	public void setMyTrade(String myTrade) {
		this.myTrade = myTrade;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	

}
