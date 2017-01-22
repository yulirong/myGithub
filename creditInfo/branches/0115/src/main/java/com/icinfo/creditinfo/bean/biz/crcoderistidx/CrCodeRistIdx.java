/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-09
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.biz.crcoderistidx;

import java.io.Serializable;
import java.math.BigDecimal;

/** 
 * 描述: 风险指数明细 实体类<br>
 * @author liyafeng
 * @date 2015-11-09
 * 
 */
public class CrCodeRistIdx implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private int id;
    // 指标编码
    private String idxCode;
    // 指标名称描述
    private String idxName;
    // 指标上级编码
    private String idxSupCode;
    // 指标等级
    private String idxLevel;
    // 权重1-100
    private BigDecimal idxWeight;
    // 指标上级名称
    private String idxSupName;
    // 指标门类编码
    private String idxRootCode;
    // 指标门类名称
    private String idxRootName;
    // 指标计算规则
    private String idxRule;
    // 备注
    private String idxRemark;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }


    public String getIdxCode() {
        return idxCode;
    }
    public void setIdxCode(String idxCode) {
        this.idxCode = idxCode;
    }


    public String getIdxName() {
        return idxName;
    }
    public void setIdxName(String idxName) {
        this.idxName = idxName;
    }


    public String getIdxSupCode() {
        return idxSupCode;
    }
    public void setIdxSupCode(String idxSupCode) {
        this.idxSupCode = idxSupCode;
    }


    public String getIdxLevel() {
        return idxLevel;
    }
    public void setIdxLevel(String idxLevel) {
        this.idxLevel = idxLevel;
    }


    public BigDecimal getIdxWeight() {
        return idxWeight;
    }
    public void setIdxWeight(BigDecimal idxWeight) {
        this.idxWeight = idxWeight;
    }


    public String getIdxSupName() {
        return idxSupName;
    }
    public void setIdxSupName(String idxSupName) {
        this.idxSupName = idxSupName;
    }


    public String getIdxRootCode() {
        return idxRootCode;
    }
    public void setIdxRootCode(String idxRootCode) {
        this.idxRootCode = idxRootCode;
    }


    public String getIdxRootName() {
        return idxRootName;
    }
    public void setIdxRootName(String idxRootName) {
        this.idxRootName = idxRootName;
    }


    public String getIdxRule() {
        return idxRule;
    }
    public void setIdxRule(String idxRule) {
        this.idxRule = idxRule;
    }


    public String getIdxRemark() {
        return idxRemark;
    }
    public void setIdxRemark(String idxRemark) {
        this.idxRemark = idxRemark;
    }

}
