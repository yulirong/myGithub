/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-10-23
 * @version 1.0
 */
package com.icinfo.creditinfo.dao.analy.cranalyguarantindustryrelation;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.analy.cranalyguarantindustryrelation.CrAnalyGuarantIndustryRelation;
import com.icinfo.plugin.hxbasedaoservice.dao.HxBaseDao;

/**
 * 
 * 描述: 行业担保关系 Dao 接口<br>
 * @author zhuyong
 * @date 2015-10-23
 */
public interface CrAnalyGuarantIndustryRelationDao extends HxBaseDao<CrAnalyGuarantIndustryRelation>
{
	
	/**
	 * 描述：获取行业担保数排行
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyGuarantIndustryRelation> doSelectCrAnalyGuarantRelationRank(Map<String,Object> qryMap) throws Exception;
	
	/***
	 * desc：获取所有行业名称
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<String> doGetIndustryTypeList(Map<String,Object> qryMap) throws Exception;
}