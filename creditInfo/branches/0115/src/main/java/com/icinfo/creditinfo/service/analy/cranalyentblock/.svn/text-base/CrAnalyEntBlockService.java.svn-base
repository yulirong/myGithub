/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-28
 * @version 1.0
 */
package com.icinfo.creditinfo.service.analy.cranalyentblock;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.icinfo.creditinfo.bean.analy.cranalyentblock.CrAnalyEntBlock;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 块状经济专题分析表 Service 接口<br>
 * @author myw
 * @date 2015-11-28
 */
public interface CrAnalyEntBlockService extends HxBaseService<CrAnalyEntBlock>{

	/**
	 * 描述：获得块经济表中的统计年份
	 * @author mayawei
	 * @date 2015-11-28 
	 * @return List<String>
	 * @throws Exception
	 */
	List<String> doGetYearList() throws Exception;
	
	/**
	 * 描述：获得块经济行业数据
	 * @author mayawei
	 * @param qryMap
	 * @date 2015-11-28
	 * @return JSONObject
	 * @throws Exception
	 */
	JSONObject doGetEachTradeDataJSON(Map<String, Object> qryMap) throws Exception;

	/**
	 * 描述：获得块经济行业数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	JSONObject doGetEachTradeDataJSONForChart2(Map<String, Object> qryMap) throws Exception;
	
	/**
	 * 描述：获得块经济行业数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	JSONObject doGetEachTradeDataJSONForChart3(Map<String, Object> qryMap) throws Exception;
	/**
	 * 描述：获得块经济chart4数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	JSONObject doGetEachTradeDataJSONForChart4(Map<String, Object> qryMap) throws Exception;
	/**
	 * 描述：获得块经济chart42数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	JSONObject doGetEachTradeDataJSONForChart42(Map<String, Object> qryMap) throws Exception;
	/**
	 * 描述：获得块经济chart3-2数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	JSONObject doGetEachTradeDataJSONForChart32(Map<String, Object> qryMap) throws Exception;

	
}
