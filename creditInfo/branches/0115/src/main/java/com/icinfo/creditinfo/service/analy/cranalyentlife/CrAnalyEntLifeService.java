/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author mayawei
 * @date 2015-10-29
 * @version 1.0
 */
package com.icinfo.creditinfo.service.analy.cranalyentlife;

import java.util.List;
import java.util.Map;
import net.sf.json.JSONArray;
import com.icinfo.creditinfo.bean.analy.cranalyentlife.CrAnalyEntLife;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 企业新生消亡趋势分析 Service 接口<br>
 * @author mayawei
 * @date 2015-10-29
 */
public interface CrAnalyEntLifeService extends HxBaseService<CrAnalyEntLife>{

		/**
	 * 描述：获得行业新生消亡数据
	 * @author 马亚伟
	 * @param qryMap 
	 * @date 2015-10-29
	 * @return JSONArray
	 * @throws Exception
	 */
	JSONArray doGetCrAnalyEntLifeJson(Map<String, Object> qryMap) throws Exception;
	
	/**
	 * 描述：获得年、行业类型、企业数的CrAnalyEntLife的json
	 * @author 马亚伟
	 * @date 2015-10-31
	 * @param qryMap
	 * @return Map<String,Object>
	 * @throws Exception
	 */
	Map<String,Object> doGetCrAnalyEntLifeJsonForCharts(Map<String, Object> qryMap) throws Exception;
	
	/**
	 * 描述：获取三大产业统计值
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyEntLife> doGetBigEntList(Map<String, Object> qryMap) throws Exception;
	
	/**
	 * 描述：构建三大产业统计值返回结果
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public JSONArray doBuildBigEntList(List<CrAnalyEntLife> entList) throws Exception;

	/**
	 * 描述：获得最新的更新日期
	 * @author 马亚伟
	 * @date 2015-11-15
	 * @return
	 * @throws Exception
	 */
	String doGetLastCrEntLifeTime() throws Exception;

}
