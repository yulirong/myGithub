/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-11-16
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.analy.cranalyentrelation;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;

/** 
 * 描述: 企业关系 实体类<br>
 * @author zhuyong
 * @date 2015-11-16
 * 
 */
public class CrAnalyEntRelation implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private BigDecimal id;
    // 内部序号
    private String nbxh;
    // 企业名称
    private String fromQymc;
    // 证件号
    private String sfzjhm;
    // 姓名
    private String xm;
    // 群号
    private String qno;
    //预警级别
    private String ristLevel;
    
    private Integer ristTotal;
    
    private Integer entNum ;
    private Integer perNum;
    private Integer totalNum;
    
    private String relName;
    
    public BigDecimal getId() {
        return id;
    }
    public void setId(BigDecimal id) {
        this.id = id;
    }


    public String getNbxh() {
        return nbxh;
    }
    public void setNbxh(String nbxh) {
        this.nbxh = nbxh;
    }


    public String getFromQymc() {
        return fromQymc;
    }
    public void setFromQymc(String fromQymc) {
        this.fromQymc = fromQymc;
    }


    public String getSfzjhm() {
        return sfzjhm;
    }
    public void setSfzjhm(String sfzjhm) {
        this.sfzjhm = sfzjhm;
    }


    public String getXm() {
        return xm;
    }
    public void setXm(String xm) {
        this.xm = xm;
    }


    public String getQno() {
        return qno;
    }
    public void setQno(String qno) {
        this.qno = qno;
    }
	public String getRistLevel() {
		return ristLevel;
	}
	public void setRistLevel(String ristLevel) {
		this.ristLevel = ristLevel;
	}
	public Integer getRistTotal() {
		return ristTotal;
	}
	public void setRistTotal(Integer ristTotal) {
		this.ristTotal = ristTotal;
	}
	public Integer getEntNum() {
		return entNum;
	}
	public void setEntNum(Integer entNum) {
		this.entNum = entNum;
	}
	public Integer getPerNum() {
		return perNum;
	}
	public void setPerNum(Integer perNum) {
		this.perNum = perNum;
	}
	public Integer getTotalNum() {
		return totalNum;
	}
	public void setTotalNum(Integer totalNum) {
		this.totalNum = totalNum;
	}
	public String getRelName() {
		return relName;
	}
	public void setRelName(String relName) {
		this.relName = relName;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
