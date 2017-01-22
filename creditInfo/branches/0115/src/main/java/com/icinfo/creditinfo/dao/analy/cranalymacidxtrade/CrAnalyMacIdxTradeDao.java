/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-11-09
 * @version 1.0
 */
package com.icinfo.creditinfo.dao.analy.cranalymacidxtrade;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.analy.cranalymacidxtrade.CrAnalyMacIdxTrade;
import com.icinfo.plugin.hxbasedaoservice.dao.HxBaseDao;

/**
 * 
 * 描述: 行业经济景气和信贷风险指数 Dao 接口<br>
 * @author yulirong
 * @date 2015-11-09
 */
public interface CrAnalyMacIdxTradeDao extends HxBaseDao<CrAnalyMacIdxTrade>
{
	/**
	 * 描述: 获取行业经济景气和信贷风险指数
	 * @author yulirong
	 * @date 2015-11-10
	 * @throws Exception
	 */
	public List<CrAnalyMacIdxTrade> doGetEconomicIndex(Map<String,Object> qryMap)throws Exception;
	/**
	 * 描述: 获取行业经济景气和信贷风险指数
	 * @author yulirong
	 * @date 2015-11-10
	 * @throws Exception
	 */
	public List<CrAnalyMacIdxTrade> doGetEconomicTrendIndex(Map<String,Object> qryMap)throws Exception;

}