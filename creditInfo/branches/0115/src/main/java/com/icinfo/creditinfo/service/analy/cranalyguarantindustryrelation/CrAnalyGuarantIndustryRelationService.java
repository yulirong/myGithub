/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-10-23
 * @version 1.0
 */
package com.icinfo.creditinfo.service.analy.cranalyguarantindustryrelation;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.analy.cranalyguarantindustryrelation.CrAnalyGuarantIndustryRelation;
import com.icinfo.creditinfo.bean.analy.cranalyguarantindustryrelation.GuarantIndustryNode;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 行业担保关系 Service 接口<br>
 * 
 * @author zhuyong
 * @date 2015-10-23
 */
public interface CrAnalyGuarantIndustryRelationService extends HxBaseService<CrAnalyGuarantIndustryRelation>{
	
	/***
	 * desc：获取所有行业名称
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<String> doGetIndustryTypeList(Map<String,Object> qryMap) throws Exception;
	
	
	/**
	 * 描述：获取行业担保数排行
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyGuarantIndustryRelation> doGetCrAnalyGuarantRelationRank(Map<String,Object> qryMap) throws Exception;
	
	/**
	 * desc:构造节点数据
	 * 
	 * @author zhuyong
	 * @param typeList
	 * @return
	 * @throws Exception
	 */
	public List<GuarantIndustryNode> doBuildNodeList(List<String> typeList) throws Exception; 
	
	/**
	 * desc:构造echarts所需数据
	 * 
	 * @author zhuyong
	 * @param typeList
	 * @param dataList
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> doBuildDataMap(List<String> typeList,List<CrAnalyGuarantIndustryRelation> dataList) throws Exception;
	
	/**
	 * desc:构建返回数据字符串
	 * 
	 * @author zhuyong
	 * @param dataList
	 * @return
	 * @throws Exception
	 */
	public String doBuildDataStr(List<List<Integer>> dataList) throws Exception;
	
}
