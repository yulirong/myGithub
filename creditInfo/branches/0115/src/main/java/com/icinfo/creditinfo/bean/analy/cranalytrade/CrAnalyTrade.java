/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-11-05
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.analy.cranalytrade;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * 描述: 企业数量就业人数 实体类<br>
 * @author yulirong
 * @date 2015-11-05
 * 
 */
public class CrAnalyTrade implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private BigDecimal id;
    // 
    private String tradeCode;
    // 
    private String tradeSupCode;
    // 企业数量
    private BigDecimal tradeCorpCount;
    // 从业人员数量统计
    private BigDecimal tradeManCount;
    // 经济指数
    private BigDecimal tradeEcmcIdx;
    // 信贷风险指数
    private BigDecimal tradeRiskIdx;
    // 
    private Date tradeCreateDate;


    public BigDecimal getId() {
        return id;
    }
    public void setId(BigDecimal id) {
        this.id = id;
    }


    public String getTradeCode() {
        return tradeCode;
    }
    public void setTradeCode(String tradeCode) {
        this.tradeCode = tradeCode;
    }


    public String getTradeSupCode() {
        return tradeSupCode;
    }
    public void setTradeSupCode(String tradeSupCode) {
        this.tradeSupCode = tradeSupCode;
    }


    public BigDecimal getTradeCorpCount() {
        return tradeCorpCount;
    }
    public void setTradeCorpCount(BigDecimal tradeCorpCount) {
        this.tradeCorpCount = tradeCorpCount;
    }


    public BigDecimal getTradeManCount() {
        return tradeManCount;
    }
    public void setTradeManCount(BigDecimal tradeManCount) {
        this.tradeManCount = tradeManCount;
    }


    public BigDecimal getTradeEcmcIdx() {
        return tradeEcmcIdx;
    }
    public void setTradeEcmcIdx(BigDecimal tradeEcmcIdx) {
        this.tradeEcmcIdx = tradeEcmcIdx;
    }


    public BigDecimal getTradeRiskIdx() {
        return tradeRiskIdx;
    }
    public void setTradeRiskIdx(BigDecimal tradeRiskIdx) {
        this.tradeRiskIdx = tradeRiskIdx;
    }


    public Date getTradeCreateDate() {
        return tradeCreateDate;
    }
    public void setTradeCreateDate(Date tradeCreateDate) {
        this.tradeCreateDate = tradeCreateDate;
    }

}
