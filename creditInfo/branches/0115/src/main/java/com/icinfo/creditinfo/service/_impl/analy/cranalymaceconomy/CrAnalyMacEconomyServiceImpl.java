/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-11-06
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.analy.cranalymaceconomy;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.analy.cranalymaceconomy.CrAnalyMacEconomy;
import com.icinfo.creditinfo.dao.analy.cranalymaceconomy.CrAnalyMacEconomyDao;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.analy.cranalymaceconomy.CrAnalyMacEconomyService;
/**
 * 
 * 描述: 宏观经济 Service 实现<br>
 * @author yulirong
 * @date 2015-11-06
 */
public class CrAnalyMacEconomyServiceImpl extends HxBaseServiceImpl<CrAnalyMacEconomy> implements CrAnalyMacEconomyService
{
	
	/**
	 * 描述：获取宏观经济数据趋势信息
	 * 
	 * @author yulirong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyMacEconomy> doGetCrAnalyMacEconomyTrendList(Map<String, Object> qryMap) throws Exception{
		return doGetCrAnalyMacEconomyDao().doGetCrAnalyMacEconomyTrendList(qryMap);
	}
	
	public CrAnalyMacEconomyDao doGetCrAnalyMacEconomyDao()
	{
		return (CrAnalyMacEconomyDao)hxBaseDao;
	}
}
