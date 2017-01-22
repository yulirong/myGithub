/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-21
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.biz.crreportconinfo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

/** 
 * 描述: 资本信息 实体类<br>
 * @author yulirong
 * @date 2015-10-21
 * 
 */
public class CrReportConInfo implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private String id;
    // 
    private String conNo;
    //内部序号 
    private String corpid;
    //年度 
    private String year;
    //序列号 
    private String conInfoSeq;
    //名称 
    private String conInfoName;
    //注册号 
    private String conInfoRegNo;
    //投资方式 
    private String conInfoInvForm;
    //应缴出资额 
    private BigDecimal conInfoPayConAmount;
    //实缴出资额 
    private BigDecimal conInfoActConAmount;
    //股份数 
    private String conInfoShareNum;
    //百分比 
    private String conInfoPercent;
    //冗余字段，没有使用 
    private String conInfoInvalidFld;
    //国籍代码 
    private String conInfoCountry;
    //责任形式1、无限责任2、有限合伙3、特殊普通合伙 
    private String conInfoLiaForm;
    //执行合伙事务的合伙人1、是2、否 
    private String conInfoAffairPart;
    //应缴出资时间 
    private Date conInfoPayDate;
    //实缴出资时间 
    private Date conInfoActDate;
    //实缴出资方式 
    private String conInfoActForm;
    //提交报表no 
    private String conReportNo;
    //YC_CON_INFO的id和YC_FOR_CAP的id 
    private String conId;
    //注册资本认缴
    private BigDecimal payCon;
    //实缴
    private BigDecimal actCon;
    //实缴比例
    private Double percen;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public String getConNo() {
        return conNo;
    }
    public void setConNo(String conNo) {
        this.conNo = conNo;
    }


    public String getCorpid() {
        return corpid;
    }
    public void setCorpid(String corpid) {
        this.corpid = corpid;
    }


    public String getYear() {
        return year;
    }
    public void setYear(String year) {
        this.year = year;
    }


    public String getConInfoSeq() {
        return conInfoSeq;
    }
    public void setConInfoSeq(String conInfoSeq) {
        this.conInfoSeq = conInfoSeq;
    }


    public String getConInfoName() {
        return conInfoName;
    }
    public void setConInfoName(String conInfoName) {
        this.conInfoName = conInfoName;
    }


    public String getConInfoRegNo() {
        return conInfoRegNo;
    }
    public void setConInfoRegNo(String conInfoRegNo) {
        this.conInfoRegNo = conInfoRegNo;
    }


    public String getConInfoInvForm() {
        return conInfoInvForm;
    }
    public void setConInfoInvForm(String conInfoInvForm) {
        this.conInfoInvForm = conInfoInvForm;
    }


    public BigDecimal getConInfoPayConAmount() {
        return conInfoPayConAmount;
    }
    public void setConInfoPayConAmount(BigDecimal conInfoPayConAmount) {
        this.conInfoPayConAmount = conInfoPayConAmount;
    }


    public BigDecimal getConInfoActConAmount() {
        return conInfoActConAmount;
    }
    public void setConInfoActConAmount(BigDecimal conInfoActConAmount) {
        this.conInfoActConAmount = conInfoActConAmount;
    }


    public String getConInfoShareNum() {
        return conInfoShareNum;
    }
    public void setConInfoShareNum(String conInfoShareNum) {
        this.conInfoShareNum = conInfoShareNum;
    }


    public String getConInfoPercent() {
        return conInfoPercent;
    }
    public void setConInfoPercent(String conInfoPercent) {
        this.conInfoPercent = conInfoPercent;
    }


    public String getConInfoInvalidFld() {
        return conInfoInvalidFld;
    }
    public void setConInfoInvalidFld(String conInfoInvalidFld) {
        this.conInfoInvalidFld = conInfoInvalidFld;
    }


    public String getConInfoCountry() {
        return conInfoCountry;
    }
    public void setConInfoCountry(String conInfoCountry) {
        this.conInfoCountry = conInfoCountry;
    }


    public String getConInfoLiaForm() {
        return conInfoLiaForm;
    }
    public void setConInfoLiaForm(String conInfoLiaForm) {
        this.conInfoLiaForm = conInfoLiaForm;
    }


    public String getConInfoAffairPart() {
        return conInfoAffairPart;
    }
    public void setConInfoAffairPart(String conInfoAffairPart) {
        this.conInfoAffairPart = conInfoAffairPart;
    }

    @JSON(format = "yyyy-MM-dd")
    public Date getConInfoPayDate() {
        return conInfoPayDate;
    }
    public void setConInfoPayDate(Date conInfoPayDate) {
        this.conInfoPayDate = conInfoPayDate;
    }

    @JSON(format = "yyyy-MM-dd")
    public Date getConInfoActDate() {
        return conInfoActDate;
    }
    public void setConInfoActDate(Date conInfoActDate) {
        this.conInfoActDate = conInfoActDate;
    }


    public String getConInfoActForm() {
        return conInfoActForm;
    }
    public void setConInfoActForm(String conInfoActForm) {
        this.conInfoActForm = conInfoActForm;
    }


    public String getConReportNo() {
        return conReportNo;
    }
    public void setConReportNo(String conReportNo) {
        this.conReportNo = conReportNo;
    }


    public String getConId() {
        return conId;
    }
    public void setConId(String conId) {
        this.conId = conId;
    }
	public BigDecimal getPayCon() {
			if(this.payCon==null){
				return null;
			}
			String payCon = this.payCon.toString();
			if(payCon.contains(".")){
				payCon = payCon.replaceAll("0+?$", "");//去掉后面无用的零
				payCon = payCon.replaceAll("[.]$", "");//如小数点后面全是零则去掉小数点
			}
			return new BigDecimal(payCon);
	}
	public void setPayCon(BigDecimal payCon) {
		this.payCon = payCon;
	}
	public BigDecimal getActCon() {
		if(this.actCon==null){
			return null;
		}
		String actCon = this.actCon.toString();
		if(actCon.contains(".")){
			actCon = actCon.replaceAll("0+?$", "");//去掉后面无用的零
			actCon = actCon.replaceAll("[.]$", "");//如小数点后面全是零则去掉小数点
		}
		return new BigDecimal(actCon);
	}
	public void setActCon(BigDecimal actCon) {
		this.actCon = actCon;
	}
	public Double getPercen() {
		return percen;
	}
	public void setPercen(Double percen) {
		this.percen = percen;
	}

}
