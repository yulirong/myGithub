/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-11-16
 * @version 1.0
 */
package com.icinfo.creditinfo.service.analy.cranalyentrelation;

import java.util.List;
import java.util.Map;
import java.util.Set;

import com.icinfo.creditinfo.bean.analy.cranalyentrelation.CrAnalyEntRelation;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 企业关系 Service 接口<br>
 * @author zhuyong
 * @date 2015-11-16
 */
public interface CrAnalyEntRelationService extends HxBaseService<CrAnalyEntRelation>{
	
	/**
	 * 描述：构建返回结果集
	 * 
	 * @author zhuyong
	 * @date 2015-11-16
	 * @param dataList
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> doBuildDataList(List<CrAnalyEntRelation> dataList,String corpid) throws Exception;
	
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
	
	/** 
	 * 描述: TODO
	 * @auther gqf
	 * @date 2015年11月23日 
	 * @param relationList
	 * @param begin
	 * @param end
	 * @param resultNodeSet
	 * @return 
	 */
	
	public Map<String,Object> doGetSearchNodePath(List<CrAnalyEntRelation> relationList,String begin,String end)  throws Exception;
	

}
