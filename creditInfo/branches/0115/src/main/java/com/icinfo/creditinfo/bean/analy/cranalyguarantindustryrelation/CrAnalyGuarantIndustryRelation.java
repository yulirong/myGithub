/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-10-23
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.analy.cranalyguarantindustryrelation;

import java.io.Serializable;
import java.math.BigDecimal;

import org.apache.commons.lang3.builder.ToStringBuilder;

/** 
 * 描述: 行业担保关系 实体类<br>
 * @author zhuyong
 * @date 2015-10-23
 * 
 */
public class CrAnalyGuarantIndustryRelation implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 担保人行业
    private String indGuarantee;
    // 被担保人行业
    private String indGuarantor;
    // 数量
    private BigDecimal indNumber;


    public String getIndGuarantee() {
        return indGuarantee;
    }
    public void setIndGuarantee(String indGuarantee) {
        this.indGuarantee = indGuarantee;
    }

    public String getIndGuarantor() {
        return indGuarantor;
    }
    public void setIndGuarantor(String indGuarantor) {
        this.indGuarantor = indGuarantor;
    }

    public BigDecimal getIndNumber() {
        return indNumber;
    }
    public void setIndNumber(BigDecimal indNumber) {
        this.indNumber = indNumber;
    }
    
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
    
    

}
