/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-09
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.analy.cranalymacidx;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * 描述: 经济指数风险指数统计表 实体类<br>
 * @author myw
 * @date 2015-11-09
 * 
 */
public class CrAnalyMacIdx implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private BigDecimal id;
    // 经济指数
    private BigDecimal idxEcomcValue;
    // 信贷风险指数
    private BigDecimal idxRistValue;
    // 生成日期
    private Date idxCreateDate;
    // 
    private String idxStatus;


    public BigDecimal getId() {
        return id;
    }
    public void setId(BigDecimal id) {
        this.id = id;
    }


    public BigDecimal getIdxEcomcValue() {
        return idxEcomcValue;
    }
    public void setIdxEcomcValue(BigDecimal idxEcomcValue) {
        this.idxEcomcValue = idxEcomcValue;
    }


    public BigDecimal getIdxRistValue() {
        return idxRistValue;
    }
    public void setIdxRistValue(BigDecimal idxRistValue) {
        this.idxRistValue = idxRistValue;
    }


    public Date getIdxCreateDate() {
        return idxCreateDate;
    }
    public void setIdxCreateDate(Date idxCreateDate) {
        this.idxCreateDate = idxCreateDate;
    }


    public String getIdxStatus() {
        return idxStatus;
    }
    public void setIdxStatus(String idxStatus) {
        this.idxStatus = idxStatus;
    }

}
