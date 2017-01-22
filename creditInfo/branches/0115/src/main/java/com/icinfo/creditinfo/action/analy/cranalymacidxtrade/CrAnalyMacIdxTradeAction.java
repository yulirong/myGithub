/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-11-09
 * @version 1.0
 */
package com.icinfo.creditinfo.action.analy.cranalymacidxtrade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.analy.cranalymacidxtrade.CrAnalyMacIdxTrade;
import com.icinfo.creditinfo.service.analy.cranalymacidxtrade.CrAnalyMacIdxTradeService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;

/** 
 * 描述: 行业经济景气和信贷风险指数 Action 类<br>
 * @author yulirong
 * @date 2015-11-09
 */
public class CrAnalyMacIdxTradeAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrAnalyMacIdxTradeService crAnalyMacIdxTradeService;
	private CrAnalyMacIdxTrade crAnalyMacIdxTrade;
	private String[] crAnalyMacIdxTradeIds;
	private String hyname;

	/**
	 * 描述: 查看列表
	 * @auther yulirong
	 * @date 2015-11-09
	 * @return
	 * @throws Exception
	 */
	public String doReadCrAnalyMacIdxTradeListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 获取行业经济景气信贷风险指数
	 * @auther yulirong
	 * @date 2015-11-09
	 * @return
	 * @throws Exception
	 */
	public String doGetEconomicIndexAction() throws Exception {
		List<CrAnalyMacIdxTrade> crAnalyMacIdxTradeList = new ArrayList<CrAnalyMacIdxTrade>();
		List<String> dataList = new ArrayList<String>();
		List<BigDecimal> economicList = new ArrayList<BigDecimal>();
		List<BigDecimal> riskList = new ArrayList<BigDecimal>();
		crAnalyMacIdxTradeList = crAnalyMacIdxTradeService.doGetEconomicIndex(null);
		for(CrAnalyMacIdxTrade list:crAnalyMacIdxTradeList){
			dataList.add(list.getIdxTradeSupcode());
			economicList.add(list.getIdxEcomcIdx());
			riskList.add(list.getIdxRistValue());
		}
		this.addAjaxResults("dataList", dataList);
		this.addAjaxResults("economicList", economicList);
		this.addAjaxResults("riskList", riskList);
		return AJAX;
		
	}
	
	/**
	 * 描述: 获取行业经济景气信贷风险趋势指数
	 * @auther yulirong
	 * @date 2015-11-09
	 * @return
	 * @throws Exception
	 */
	public String doGetEconomicTrendIndexAction() throws Exception {
		Map<String, Object> qryMap = new HashMap<String, Object>();
		qryMap = crAnalyMacIdxTradeService.doGetEconomicRiskTrendIndex(hyname);
		this.addAjaxResults("economicList", qryMap.get("economicList"));
		this.addAjaxResults("riskList", qryMap.get("riskList"));
		this.addAjaxResults("dateList", qryMap.get("dateList"));
		return AJAX;
	}
	
	
	
	public CrAnalyMacIdxTradeService getCrAnalyMacIdxTradeService()
	{
		return crAnalyMacIdxTradeService;
	}
	public void setCrAnalyMacIdxTradeService(CrAnalyMacIdxTradeService crAnalyMacIdxTradeService)
	{
		this.crAnalyMacIdxTradeService = crAnalyMacIdxTradeService;
	}

	public CrAnalyMacIdxTrade getCrAnalyMacIdxTrade()
	{
		return crAnalyMacIdxTrade;
	}

	public void setCrAnalyMacIdxTrade(CrAnalyMacIdxTrade crAnalyMacIdxTrade)
	{
		this.crAnalyMacIdxTrade = crAnalyMacIdxTrade;
	}

	public String[] getCrAnalyMacIdxTradeIds()
	{
		return crAnalyMacIdxTradeIds;
	}

	public void setCrAnalyMacIdxTradeIds(String[] crAnalyMacIdxTradeIds)
	{
		this.crAnalyMacIdxTradeIds = crAnalyMacIdxTradeIds;
	}

	public String getHyname() {
		return hyname;
	}

	public void setHyname(String hyname) {
		this.hyname = hyname;
	}

	
}
