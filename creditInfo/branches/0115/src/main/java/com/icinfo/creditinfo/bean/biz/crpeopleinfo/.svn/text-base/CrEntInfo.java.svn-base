package com.icinfo.creditinfo.bean.biz.crpeopleinfo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.text.DecimalFormat;

/** 
 * 描述: 个人详情  实体类<br>
 * @author gaotong
 * @date 2015-10-22
 * 
 */
public class CrEntInfo implements Serializable
{

    private static final long	serialVersionUID	= 1L;
	//corpid
	private String corpid;
    // 企业名称
    private String entName;
    // 注册号
    private String entRegNo;
    // 关系
    private String relation;
    // 来源
    private String source;

	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getRelation() {
		return relation;
	}
	public void setRelation(String relation) {
		if(relation.endsWith("%的持股股东")){
			String[] str=relation.split("%的持股股东");
			DecimalFormat df = new DecimalFormat("##.#"); 
			this.relation=df.format(new BigDecimal(str[0]))+"%的持股股东";
		}else{
			this.relation = relation;
		}
	}
	public String getEntName() {
		return entName;
	}
	public void setEntName(String entName) {
		this.entName = entName;
	}
	public String getEntRegNo() {
		return entRegNo;
	}
	public void setEntRegNo(String entRegNo) {
		this.entRegNo = entRegNo;
	}
	public String getCorpid() {
		return corpid;
	}
	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}


    
}
