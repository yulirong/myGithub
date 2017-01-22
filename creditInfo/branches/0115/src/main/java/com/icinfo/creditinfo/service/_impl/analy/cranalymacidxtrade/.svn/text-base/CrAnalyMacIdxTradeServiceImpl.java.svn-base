/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-11-09
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.analy.cranalymacidxtrade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icinfo.creditinfo.bean.analy.cranalymacidxtrade.CrAnalyMacIdxTrade;
import com.icinfo.creditinfo.dao.analy.cranalymacidxtrade.CrAnalyMacIdxTradeDao;
import com.icinfo.plugin.common.HxDateUtil;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.analy.cranalymacidxtrade.CrAnalyMacIdxTradeService;
/**
 * 
 * 描述: 行业经济景气和信贷风险指数 Service 实现<br>
 * @author yulirong
 * @date 2015-11-09
 */
public class CrAnalyMacIdxTradeServiceImpl extends HxBaseServiceImpl<CrAnalyMacIdxTrade> implements CrAnalyMacIdxTradeService
{
	/**
	 * 描述: 获取行业经济景气和信贷风险指数
	 * @author yulirong
	 * @date 2015-11-10
	 * @throws Exception
	 */
	public List<CrAnalyMacIdxTrade> doGetEconomicIndex(Map<String,Object> qryMap)throws Exception{
		return doGetCrAnalyMacIdxTradeDao().doGetEconomicIndex(qryMap);
	}
	
	/**
	 * 描述: 获取行业经济景气和信贷风险指数
	 * @author yulirong
	 * @date 2015-11-10
	 * @throws Exception
	 */
	public List<CrAnalyMacIdxTrade> doGetEconomicTrendIndex(Map<String,Object> qryMap)throws Exception{
		return doGetCrAnalyMacIdxTradeDao().doGetEconomicTrendIndex(qryMap);
	}
	/**
	 * 描述: 获取行业经济景气和信贷风险指数趋势数据处理
	 * @author yulirong
	 * @date 2015-11-10
	 * @throws Exception
	 */
	public Map<String, Object> doGetEconomicRiskTrendIndex(String hyname)throws Exception{
		Map<String, Object> qryMap = new HashMap<String, Object>();
		List<String> list =  new ArrayList<String>();
		List<String> dateList = new ArrayList<String>();
		List<BigDecimal> economicList = new ArrayList<BigDecimal>();
		List<BigDecimal> riskList = new ArrayList<BigDecimal>();
		list.add("E");list.add("K");
		if(StringUtils.isNotBlank(hyname)){
			list.clear();
			if(hyname.equals("房地产与建筑业")){
				list.add("E");list.add("K");
			}
			if(hyname.equals("工业")){
				list.add("A");list.add("B");list.add("C");list.add("D");
			}
			if(hyname.equals("批发零售业")){
				list.add("F");
			}
			if(hyname.equals("社会服务及商业服务业")){
				list.add("G");list.add("H");list.add("I");list.add("J");list.add("K");list.add("L");list.add("M");list.add("N");list.add("O");
				list.add("P");list.add("Q");list.add("R");list.add("S");
			}
		}
		qryMap.put("hydata", list);
		List<CrAnalyMacIdxTrade> crAnalyMacIdxTradeList = new ArrayList<CrAnalyMacIdxTrade>();
		crAnalyMacIdxTradeList = doGetEconomicTrendIndex(qryMap);
		for(CrAnalyMacIdxTrade list1:crAnalyMacIdxTradeList){
			economicList.add(list1.getIdxEcomcIdx());
			riskList.add(list1.getIdxRistValue());
			dateList.add(HxDateUtil.dateToString(list1.getIdxCreateDate(), "yyyy-MM-dd"));
		}
		qryMap.put("economicList", economicList);
		qryMap.put("riskList", riskList);
		qryMap.put("dateList", dateList);
		return qryMap;
	}

	public CrAnalyMacIdxTradeDao doGetCrAnalyMacIdxTradeDao()
	{
		return (CrAnalyMacIdxTradeDao)hxBaseDao;
	}
}
