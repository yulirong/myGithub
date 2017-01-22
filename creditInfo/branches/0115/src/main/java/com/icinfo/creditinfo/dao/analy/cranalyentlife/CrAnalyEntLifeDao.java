/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author mayawei
 * @date 2015-10-29
 * @version 1.0
 */
package com.icinfo.creditinfo.dao.analy.cranalyentlife;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.analy.cranalyentlife.CrAnalyEntLife;
import com.icinfo.plugin.hxbasedaoservice.dao.HxBaseDao;

/**
 * 
 * 描述: 企业新生消亡趋势分析 Dao 接口<br>
 * @author mayawei
 * @date 2015-10-29
 */
public interface CrAnalyEntLifeDao extends HxBaseDao<CrAnalyEntLife>
{

	/**
	 * 描述：获得企业新生或消亡数量
	 * @author 马亚伟
	 * @date 2015-10-29
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	Integer selectCrAnalyEntLifeTotal(Map<String, Object> qryMap) throws Exception;

	/**
	 ** 描述：获得企业新生或消亡集合
	 * @author 马亚伟
	 * @date 2015-10-30
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	List<CrAnalyEntLife> selectAnalyEntLifeList(Map<String, Object> qryMap) throws Exception;

	/**
	 * 描述：获得年、行业类型、企业数的CrAnalyEntLife的list集合
	 * @author 马亚伟
	 * @date 2015-10-31
	 * @param qryMap
	 * @return JSONArray
	 * @throws Exception
	 */
	List<CrAnalyEntLife> selectCrAnalyEntLifeJsonForCharts(Map<String, Object> qryMap) throws Exception;
	
	/**
	 * 描述：获取三大产业统计值
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyEntLife> selectBigEntList(Map<String, Object> qryMap) throws Exception;

	/**
	 * 描述：获得最新entLife
	 * @author 马亚伟
	 * @date 2015-11-15
	 * @return
	 * @throws Exception
	 */
	CrAnalyEntLife selectLastCrEntLife() throws Exception;
	
}