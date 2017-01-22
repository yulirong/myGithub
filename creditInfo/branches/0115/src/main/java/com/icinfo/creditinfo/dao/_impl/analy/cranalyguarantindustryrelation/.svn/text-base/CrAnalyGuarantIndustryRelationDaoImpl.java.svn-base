/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-10-23
 * @version 1.0
 */
package com.icinfo.creditinfo.dao._impl.analy.cranalyguarantindustryrelation;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.analy.cranalyguarantindustryrelation.CrAnalyGuarantIndustryRelation;
import com.icinfo.creditinfo.dao.analy.cranalyguarantindustryrelation.CrAnalyGuarantIndustryRelationDao;
import com.icinfo.plugin.hxbasedaoservice.dao._impl.HxBaseDaoImpl;

/**
 * 描述: 行业担保关系 Dao 实现<br>
 * 
 * @author zhuyong
 * @date 2015-10-23
 */
public class CrAnalyGuarantIndustryRelationDaoImpl extends HxBaseDaoImpl<CrAnalyGuarantIndustryRelation> implements CrAnalyGuarantIndustryRelationDao
{
	
	
	/**
	 * 描述：获取行业担保数排行
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CrAnalyGuarantIndustryRelation> doSelectCrAnalyGuarantRelationRank(Map<String,Object> qryMap) throws Exception{
		return (List<CrAnalyGuarantIndustryRelation>)getBaseSqlMapDao().queryForList("ibatis-cranalyguarantindustryrelation.selectCrAnalyGuarantRelationRank",qryMap);
	}
	
	
	/***
	 * desc：获取所有行业名称
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<String> doGetIndustryTypeList(Map<String,Object> qryMap) throws Exception{
		return (List<String>)getBaseSqlMapDao().queryForList("ibatis-cranalyguarantindustryrelation.selectIndustryTypeList",qryMap);
	}
}