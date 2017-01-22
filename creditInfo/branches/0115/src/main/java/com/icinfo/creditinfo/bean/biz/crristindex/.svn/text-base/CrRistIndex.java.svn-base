/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-11-04
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.biz.crristindex;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * 描述: 风险指数 实体类<br>
 * @author zhuyong
 * @date 2015-11-04
 * 
 */
public class CrRistIndex implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private String id;
    // 
    private String corpid;
    // 企业名称
    private String entName;
    // 风险指数
    private BigDecimal ristIndex;
    // 行业
    private String ristTrade;
    // 生成日期
    private Date ristDate;
    // 状态1：有效
    private String ristState;
    //注册资本
    private BigDecimal ristRegCap;
    //平均指数
    private BigDecimal avgRistIndex;


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


    public BigDecimal getRistIndex() {
        return ristIndex.setScale(0, BigDecimal.ROUND_HALF_UP);
    }
    public void setRistIndex(BigDecimal ristIndex) {
        this.ristIndex = ristIndex;
    }


    public String getRistTrade() {
        return ristTrade;
    }
    public void setRistTrade(String ristTrade) {
        this.ristTrade = ristTrade;
    }


    public Date getRistDate() {
        return ristDate;
    }
    public void setRistDate(Date ristDate) {
        this.ristDate = ristDate;
    }


    public String getRistState() {
        return ristState;
    }
    public void setRistState(String ristState) {
        this.ristState = ristState;
    }
	public BigDecimal getRistRegCap() {
		return ristRegCap;
	}
	public void setRistRegCap(BigDecimal ristRegCap) {
		this.ristRegCap = ristRegCap;
	}
	public BigDecimal getAvgRistIndex() {
		if(this.avgRistIndex==null){
    		return new BigDecimal(0);
    	}
		return avgRistIndex.setScale(0, BigDecimal.ROUND_HALF_UP);
	}
	public void setAvgRistIndex(BigDecimal avgRistIndex) {
		this.avgRistIndex = avgRistIndex;
	}
    
}
