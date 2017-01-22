/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.dao._impl.analy.cranalyguarantrelationdata;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.analy.cranalyguarantrelationdata.CrAnalyGuarantRelationData;
import com.icinfo.creditinfo.dao.analy.cranalyguarantrelationdata.CrAnalyGuarantRelationDataDao;
import com.icinfo.plugin.hxbasedaoservice.dao._impl.HxBaseDaoImpl;

/**
 * 描述: 担保圈分析 Dao 实现<br>
 * @author zhuyong
 * @date 2015-11-12
 */
public class CrAnalyGuarantRelationDataDaoImpl extends HxBaseDaoImpl<CrAnalyGuarantRelationData> implements CrAnalyGuarantRelationDataDao
{
	/**
	 * 描述：获取担保圈涉及的企业数和人数
	 * 
	 * @author zhuyong
	 * @date 2015-11-24
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CrAnalyGuarantRelationData> doSelectGuarantEntryTotal(Map<String,Object> qryMap) throws Exception{
		return (List<CrAnalyGuarantRelationData>)getBaseSqlMapDao().queryForList("ibatis-cranalyguarantrelationdata.selectCrAnalyGuarantEntryTotal",qryMap);
	}
	
	/**
	 * 描述：获取担保群数
	 * 
	 * @author zhuyong
	 * @date 2015-11-24
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public Integer doSelectGuarantGroupTotal(Map<String,Object> qryMap) throws Exception{
		return (Integer)getBaseSqlMapDao().queryForObject("ibatis-cranalyguarantrelationdata.selectGuarantGroupTotal",qryMap);
	}
	
	/**
	 * 描述：获取双向担保详情
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CrAnalyGuarantRelationData> doSelectDoubleGuarantList(Map<String,Object> qryMap) throws Exception{
		return (List<CrAnalyGuarantRelationData>)getBaseSqlMapDao().queryForList("ibatis-cranalyguarantrelationdata.selectDoubleGuarantList",qryMap);
	}
	
	
	/**
	 * 描述：获取无反担保企业数量
	 * 
	 * @author 朱勇
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public Integer doSelectNoReturnGuarantTotal(Map<String,Object> qryMap) throws Exception{
		return (Integer)getBaseSqlMapDao().queryForObject("ibatis-cranalyguarantrelationdata.selectNoReturnGuarantTotal",qryMap);
	}

	
	
}

