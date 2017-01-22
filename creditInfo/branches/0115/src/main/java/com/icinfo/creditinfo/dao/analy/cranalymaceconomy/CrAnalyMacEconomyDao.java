/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-11-06
 * @version 1.0
 */
package com.icinfo.creditinfo.dao.analy.cranalymaceconomy;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.analy.cranalymaceconomy.CrAnalyMacEconomy;
import com.icinfo.plugin.hxbasedaoservice.dao.HxBaseDao;

/**
 * 
 * 描述: 宏观经济 Dao 接口<br>
 * @author yulirong
 * @date 2015-11-06
 */
public interface CrAnalyMacEconomyDao extends HxBaseDao<CrAnalyMacEconomy>
{
	/**
	 * 描述：获取宏观经济数据趋势信息
	 * 
	 * @author yulirong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyMacEconomy> doGetCrAnalyMacEconomyTrendList(Map<String, Object> qryMap) throws Exception;

}