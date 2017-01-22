/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-11-30
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.biz.crrelationnetall;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;

/** 
 * 描述: 关系网络汇总信息 实体类<br>
 * @author zhuyong
 * @date 2015-11-30
 * 
 */
public class CrRelationNetAll implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 内部序号
    private String fromCorpid;
    // 企业名称
    private String fromName;
    // 关系企业名称/人名
    private String toName;
    // 关系内部序号/身份证号码
    private String toCorpid;
    // 关系
    private String relateName;
    // 身份识别标志（企业 or 人）
    private String toType;
    // 筛选条件
    private String relateCondtion;
    // 关系描述
    private String relateDetail;
    

    //法定代表人
    private String fddbrName;
    //法人股东
    private BigDecimal frgdNum;
    //自然人股东
    private BigDecimal zrrgdNum;
    //高管
    private BigDecimal ggNum;
    //担保
    private BigDecimal dbNum;

    public String getFromCorpid() {
        return fromCorpid;
    }
    public void setFromCorpid(String fromCorpid) {
        this.fromCorpid = fromCorpid;
    }


    public String getFromName() {
        return fromName;
    }
    public void setFromName(String fromName) {
        this.fromName = fromName;
    }


    public String getToName() {
        return toName;
    }
    public void setToName(String toName) {
        this.toName = toName;
    }


    public String getToCorpid() {
        return toCorpid;
    }
    public void setToCorpid(String toCorpid) {
        this.toCorpid = toCorpid;
    }

    public String getRelateName() {
        return relateName;
    }
    public void setRelateName(String relateName) {
        this.relateName = relateName;
    }

    public String getToType() {
        return toType;
    }
    public void setToType(String toType) {
        this.toType = toType;
    }

    public String getRelateCondtion() {
        return relateCondtion;
    }
    public void setRelateCondtion(String relateCondtion) {
        this.relateCondtion = relateCondtion;
    }

    public String getRelateDetail() {
        return relateDetail;
    }
    public void setRelateDetail(String relateDetail) {
        this.relateDetail = relateDetail;
    }
    
    
	public String getFddbrName() {
		return fddbrName;
	}
	public void setFddbrName(String fddbrName) {
		this.fddbrName = fddbrName;
	}
	public BigDecimal getFrgdNum() {
		return frgdNum;
	}
	public void setFrgdNum(BigDecimal frgdNum) {
		this.frgdNum = frgdNum;
	}
	public BigDecimal getZrrgdNum() {
		return zrrgdNum;
	}
	public void setZrrgdNum(BigDecimal zrrgdNum) {
		this.zrrgdNum = zrrgdNum;
	}
	public BigDecimal getGgNum() {
		return ggNum;
	}
	public void setGgNum(BigDecimal ggNum) {
		this.ggNum = ggNum;
	}
	public BigDecimal getDbNum() {
		return dbNum;
	}
	public void setDbNum(BigDecimal dbNum) {
		this.dbNum = dbNum;
	}
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
    
}
