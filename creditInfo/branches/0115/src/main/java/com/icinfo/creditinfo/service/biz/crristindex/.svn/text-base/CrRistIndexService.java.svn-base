/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-11-04
 * @version 1.0
 */
package com.icinfo.creditinfo.service.biz.crristindex;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crristindex.CrRistIndex;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 风险指数 Service 接口<br>
 * @author zhuyong
 * @date 2015-11-04
 */
public interface CrRistIndexService extends HxBaseService<CrRistIndex>{
	
	/**
	 * 描述：构造返回map
	 * 
	 * @author zhuyong
	 * @param indexList
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> doBuildResultMap(List<CrRistIndex> indexList) throws Exception;
	/**
	 * 描述：获取值得关注的高风险企业（top10）数据
	 * 
	 * @author yulirong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<CrRistIndex> doGetCrRistIndexToptList(Map<String,Object> qryMap) throws Exception;
	/**
	 * 
	 * 描述:获取风险日期，指数，行业平均指数
	 * @author LiYaFeng
	 * @date 2015年12月18日 
	 * @param qryMap
	 * @return
	 */
	public List<CrRistIndex> doGetCrRistIndexList(Map<String, Object> qryMap)throws Exception;
	
}
