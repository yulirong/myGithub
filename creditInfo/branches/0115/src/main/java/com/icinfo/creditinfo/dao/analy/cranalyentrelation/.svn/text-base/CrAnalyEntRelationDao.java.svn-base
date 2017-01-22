/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-11-16
 * @version 1.0
 */
package com.icinfo.creditinfo.dao.analy.cranalyentrelation;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.analy.cranalyentrelation.CrAnalyEntRelation;
import com.icinfo.plugin.hxbasedaoservice.dao.HxBaseDao;

/**
 * 
 * 描述: 企业关系 Dao 接口<br>
 * @author zhuyong
 * @date 2015-11-16
 */
public interface CrAnalyEntRelationDao extends HxBaseDao<CrAnalyEntRelation>
{
	/**
	 * 描述：统计企业个数
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public CrAnalyEntRelation doCountEntTotal(Map<String,Object> qryMap) throws Exception;
	
	/**
	 * 描述：获取不同级别数字
	 * 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyEntRelation>  doGetRistLevelTotal(Map<String,Object> qryMap) throws Exception;
	
}