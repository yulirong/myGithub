/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-28
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.analy.cranalyentblock;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * 描述: 块状经济专题分析表 实体类<br>
 * @author myw
 * @date 2015-11-28
 * 
 */
public class CrAnalyEntBlock implements Serializable
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
    // 产业
    private String industry;
    // 企业类型大类
    private String entCatg;
    // 企业数量
    private BigDecimal qyCount;
    // 规模统计
    private BigDecimal qyScaleCount;
    // 资产总额
    private BigDecimal totalAssets;
    // 营业收入
    private BigDecimal income;
    // 用水量
    private BigDecimal elecNum;
    // 用电量
    private BigDecimal waterNum;
    // 进口量
    private BigDecimal impNum;
    // 出口量
    private BigDecimal expNum;
    // 利润
    private BigDecimal netProfit;
    // 纳税
    private BigDecimal tax;
    // 人数
    private BigDecimal socialSecurityNum;
    // 机械设备
    private BigDecimal blockEcoJxyq;
    // 伞业
    private BigDecimal blockEcoSy;
    // 消防器材
    private BigDecimal blockEcoXfqc;
    // 童装
    private BigDecimal blockEcoTz;
    // 风机
    private BigDecimal blockEcoFj;
    // 汽车零部件
    private BigDecimal blockEcoQclbj;
    // 铜管
    private BigDecimal blockEcoTg;
    // 劳保袜业
    private BigDecimal blockEcoLbwy;
    private Date createDate;
    
    //辅助字段
    private String dateStr;//日期字符串
    private String tradeName;//行业名称
    private String isProfit;//是否盈利
    private String isLocal;//是否是当前行业
    private BigDecimal resTotal;//资源使用量
    private BigDecimal industryCount;
    
    
    public BigDecimal getId() {
        return id;
    }
    public void setId(BigDecimal id) {
        this.id = id;
    }


    public BigDecimal getIndustryCount() {
		return industryCount;
	}
	public void setIndustryCount(BigDecimal industryCount) {
		this.industryCount = industryCount;
	}
	public String getTradeName() {
		return tradeName;
	}
	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
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


    public String getIndustry() {
        return industry;
    }
    public void setIndustry(String industry) {
        this.industry = industry;
    }


    public String getEntCatg() {
        return entCatg;
    }
    public void setEntCatg(String entCatg) {
        this.entCatg = entCatg;
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
        return totalAssets;
    }
    public void setTotalAssets(BigDecimal totalAssets) {
        this.totalAssets = totalAssets;
    }


    public BigDecimal getIncome() {
        return income;
    }
    public void setIncome(BigDecimal income) {
        this.income = income;
    }


    public BigDecimal getElecNum() {
        return elecNum;
    }
    public void setElecNum(BigDecimal elecNum) {
        this.elecNum = elecNum;
    }


    public BigDecimal getWaterNum() {
        return waterNum;
    }
    public void setWaterNum(BigDecimal waterNum) {
        this.waterNum = waterNum;
    }


    public BigDecimal getImpNum() {
        return impNum;
    }
    public void setImpNum(BigDecimal impNum) {
        this.impNum = impNum;
    }


    public BigDecimal getExpNum() {
        return expNum;
    }
    public void setExpNum(BigDecimal expNum) {
        this.expNum = expNum;
    }


    public BigDecimal getNetProfit() {
        return netProfit;
    }
    public void setNetProfit(BigDecimal netProfit) {
        this.netProfit = netProfit;
    }


    public BigDecimal getTax() {
        return tax;
    }
    public void setTax(BigDecimal tax) {
        this.tax = tax;
    }


    public BigDecimal getSocialSecurityNum() {
        return socialSecurityNum;
    }
    public void setSocialSecurityNum(BigDecimal socialSecurityNum) {
        this.socialSecurityNum = socialSecurityNum;
    }



    public BigDecimal getBlockEcoSy() {
        return blockEcoSy;
    }
    public void setBlockEcoSy(BigDecimal blockEcoSy) {
        this.blockEcoSy = blockEcoSy;
    }



    public BigDecimal getBlockEcoTz() {
        return blockEcoTz;
    }
    public void setBlockEcoTz(BigDecimal blockEcoTz) {
        this.blockEcoTz = blockEcoTz;
    }


    public BigDecimal getBlockEcoFj() {
        return blockEcoFj;
    }
    public void setBlockEcoFj(BigDecimal blockEcoFj) {
        this.blockEcoFj = blockEcoFj;
    }


    public BigDecimal getBlockEcoTg() {
        return blockEcoTg;
    }
    public void setBlockEcoTg(BigDecimal blockEcoTg) {
        this.blockEcoTg = blockEcoTg;
    }



    public BigDecimal getBlockEcoJxyq() {
		return blockEcoJxyq;
	}
	public void setBlockEcoJxyq(BigDecimal blockEcoJxyq) {
		this.blockEcoJxyq = blockEcoJxyq;
	}
	public BigDecimal getBlockEcoXfqc() {
		return blockEcoXfqc;
	}
	public void setBlockEcoXfqc(BigDecimal blockEcoXfqc) {
		this.blockEcoXfqc = blockEcoXfqc;
	}
	public BigDecimal getBlockEcoQclbj() {
		return blockEcoQclbj;
	}
	public void setBlockEcoQclbj(BigDecimal blockEcoQclbj) {
		this.blockEcoQclbj = blockEcoQclbj;
	}

	public BigDecimal getBlockEcoLbwy() {
		return blockEcoLbwy;
	}
	public void setBlockEcoLbwy(BigDecimal blockEcoLbwy) {
		this.blockEcoLbwy = blockEcoLbwy;
	}
	public Date getCreateDate() {
        return createDate;
    }
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
	public String getDateStr() {
		return dateStr;
	}
	public void setDateStr(String dateStr) {
		this.dateStr = dateStr;
	}
	public String getIsProfit() {
		return isProfit;
	}
	public void setIsProfit(String isProfit) {
		this.isProfit = isProfit;
	}
	public String getIsLocal() {
		return isLocal;
	}
	public void setIsLocal(String isLocal) {
		this.isLocal = isLocal;
	}
	public BigDecimal getResTotal() {
		return resTotal;
	}
	public void setResTotal(BigDecimal resTotal) {
		this.resTotal = resTotal;
	}

	
}
