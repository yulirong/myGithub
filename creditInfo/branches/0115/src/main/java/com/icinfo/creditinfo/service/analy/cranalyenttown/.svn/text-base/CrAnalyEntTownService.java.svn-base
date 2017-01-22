/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-11-28
 * @version 1.0
 */
package com.icinfo.creditinfo.service.analy.cranalyenttown;

import java.util.List;
import java.util.Map;
import com.icinfo.creditinfo.bean.analy.cranalyenttown.CrAnalyEntTown;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 特色小镇 Service 接口<br>
 * @author yulirong
 * @date 2015-11-28
 */
public interface CrAnalyEntTownService extends HxBaseService<CrAnalyEntTown>{
	/**
	 * 描述: 获取特色小镇企业数量
	 * 
	 * @author ylr
	 * @date 2015-11-28
	 * @throws Exception
	 */
	public CrAnalyEntTown doGetQyCount() throws Exception;
	/**
	 * 描述: 获取产业特点企业数量
	 * 
	 * @author ylr
	 * @date 2015-11-28
	 * @throws Exception
	 */
	public List<CrAnalyEntTown> doGetIndustryCharacter(Map<String, Object> qryMap) throws Exception;
	
	/**
	 * 描述：获取企业规模大小数据
	 * 
	 * @author zhuyong
	 * @date 2015-11-28
	 * @param dataList
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyEntTown> doGetQyScaleDataList(Map<String,Object> qryMap) throws Exception;
	
	
	/**
	 * 描述：构建企业规模大小返回数据
	 * 
	 * @author zhuyong
	 * @date 2015-11-28
	 * @param dataList
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> doBuildQyScale(List<CrAnalyEntTown> dataList) throws Exception;
	/**
	 * 描述：运营状况
	 * 
	 * @author ylr
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyEntTown> doGetOperationStatus(Map<String, Object> qryMap) throws Exception;
	/**
	 * 描述：资产总额
	 * 
	 * @author ylr
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyEntTown> doGetTotalAsset(Map<String, Object> qryMap) throws Exception;
	
	/**
	 * 描述：盈利状况
	 * 
	 * @author ylr
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyEntTown> doGetProfitStatus(Map<String, Object> qryMap) throws Exception;
	/**
	 * 描述：盈利企业数量
	 * 
	 * @author ylr
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyEntTown> doGetProfitTotal(Map<String, Object> qryMap) throws Exception;
	/**
	 * 描述：对周边经济的影响程度
	 * 
	 * @author ylr
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyEntTown> doGetLocalEconomy(Map<String, Object> qryMap) throws Exception;
	/**
	 * 描述：对行业的影响程度
	 * 
	 * @author ylr
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyEntTown> doGetLocalIndustry(Map<String, Object> qryMap) throws Exception;
	/**
	 * 描述：就业贡献
	 * 
	 * @author ylr
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyEntTown> doGetEmploymentContribution(Map<String, Object> qryMap) throws Exception;
	
}
