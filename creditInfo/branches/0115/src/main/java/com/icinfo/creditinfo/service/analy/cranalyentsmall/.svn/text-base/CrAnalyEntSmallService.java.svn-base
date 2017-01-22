/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-28
 * @version 1.0
 */
package com.icinfo.creditinfo.service.analy.cranalyentsmall;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.analy.cranalyentsmall.CrAnalyEntSmall;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/**
 * 描述: 小微企业 Service 接口<br>
 * @author liyafeng
 * @date 2015-11-28
 */
public interface CrAnalyEntSmallService extends HxBaseService<CrAnalyEntSmall>{
    /**
     * 
     * 描述: 获得年份
     * @author LiYaFeng
     * @return 
     * @date 2015年11月28日 
     * @throws Exception
     */
	public List<BigDecimal> doGetYearList() throws Exception;
    /**
     * 
     * 描述: 获得区域企业数
     * @author LiYaFeng
     * @date 2015年11月28日 
     * @param qryMap
     * @return
     * @throws Exception
     */
	public JSONObject doGetCrAnalyEntSmallNumByZone(Map<String, Object> qryMap) throws Exception;
	/**
	 * 
	 * 描述: 小微企业活跃度
	 * @author LiYaFeng
	 * @date 2015年11月28日 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> doGetCrAnalyEntSmallActive(Map<String, Object> qryMap) throws Exception;
	/**
	 * 
	 * 描述: 获得新生消亡企业数与时间
	 * @author LiYaFeng
	 * @date 2015年11月28日 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> doGetNewAndDieAndDateList(Map<String, Object> qryMap)throws Exception;
	/**
	 * 
	 * 描述: 获得经营状况参数
	 * @author LiYaFeng
	 * @date 2015年11月28日 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> doGetOperateStateListAndDateList(Map<String, Object> qryMap)throws Exception;
	/**
	 * 
	 * 描述: 获得就业情况
	 * @author LiYaFeng
	 * @date 2015年11月28日 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> doGetEmpStatus(Map<String, Object> qryMap)throws Exception;
	/**
	 * 
	 * 描述: 三年成长轨迹
	 * @author LiYaFeng
	 * @date 2015年11月29日 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> doGetThreeYearGrow(Map<String, Object> qryMap) throws Exception;
	

}
