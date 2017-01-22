/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.service.analy.cranalyguarantrelationdata;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.analy.cranalyguarantrelationdata.CrAnalyGuarantRelationData;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 担保圈分析 Service 接口<br>
 * @author zhuyong
 * @date 2015-11-12
 */
public interface CrAnalyGuarantRelationDataService extends HxBaseService<CrAnalyGuarantRelationData>{
	
	
	/**
	 * 描述：获取担保圈涉及的企业数和人数
	 * 
	 * @author zhuyong
	 * @date 2015-11-24
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyGuarantRelationData> doGetGuarantEntryTotal(Map<String,Object> qryMap) throws Exception;
	
	/**
	 * 描述：获取担保群数
	 * 
	 * @author zhuyong
	 * @date 2015-11-24
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public Integer doGetGuarantGroupTotal(Map<String,Object> qryMap) throws Exception;
	
	/**
	 * 描述：获取双向担保详情
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyGuarantRelationData> doGetDoubleGuarantList(Map<String,Object> qryMap) throws Exception;
	
	/**
	 * 描述：获取无反担保企业数量
	 * 
	 * @author 朱勇
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public Integer doGetNoReturnGuarantTotal(Map<String,Object> qryMap) throws Exception;
	
	/**
	 * 描述：构建返回Map
	 * 
	 * @author zhuyong
	 * @param dataList
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> doBuildResultMap(List<CrAnalyGuarantRelationData> dataList) throws Exception;
	/**
	 * 描述：构建返回Map
	 * 
	 * @author zhuyong
	 * @param dataList
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> doBuildFullScreenResultMap(List<CrAnalyGuarantRelationData> dataList) throws Exception;
}
