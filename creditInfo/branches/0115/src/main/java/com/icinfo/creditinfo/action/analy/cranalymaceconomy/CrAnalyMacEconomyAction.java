/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-11-06
 * @version 1.0
 */
package com.icinfo.creditinfo.action.analy.cranalymaceconomy;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import com.icinfo.creditinfo.bean.analy.cranalymaceconomy.CrAnalyMacEconomy;
import com.icinfo.creditinfo.service.analy.cranalymaceconomy.CrAnalyMacEconomyService;
import com.icinfo.creditinfo.service.biz.yccodeindustrytype.YcCodeIndustryTypeService;
import com.icinfo.creditinfo.action.HxBaseAction;

/** 
 * 描述: 宏观经济 Action 类<br>
 * @author yulirong
 * @date 2015-11-06
 */
public class CrAnalyMacEconomyAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrAnalyMacEconomyService crAnalyMacEconomyService;
	private CrAnalyMacEconomy crAnalyMacEconomy;
	private String[] crAnalyMacEconomyIds;
	private YcCodeIndustryTypeService ycCodeIndustryTypeService;
	private String selectVal;
	private String entSupTrade;

	/**
	 * 描述: 查看列表
	 * @auther yulirong
	 * @date 2015-11-06
	 * @return
	 * @throws Exception
	 */
	public String doReadCrAnalyMacEconomyListAction() throws Exception 
	{
		return SUCCESS;
	}
	
	/**
	 * 描述: 进入宏观经济数据趋势页面
	 * @auther yulirong
	 * @date 2015-11-06
	 * @return
	 * @throws Exception
	 */
	public String doEnCrAnalyMacEconomyTrendListAction() throws Exception 
	{
		this.addJstlResults("industryTypeList",ycCodeIndustryTypeService.doGetList(null));
		return SUCCESS;
	}
	
	/**
	 * 描述: 获取宏观经济数据趋势信息
	 * @auther yulirong
	 * @date 2015-11-06
	 * @return
	 * @throws Exception
	 */
	public String doGetCrAnalyMacEconomyTrendListAction() throws Exception 
	{
		Map<String,Object> qryMap = new HashMap<String, Object>();
		List<CrAnalyMacEconomy> crAnalyMacEconomyList = new ArrayList<CrAnalyMacEconomy>();
		List<BigDecimal> dataList = new ArrayList<BigDecimal>();
		List<BigDecimal> dataExpList = new ArrayList<BigDecimal>();
		List<String> timeList = new ArrayList<String>();
		qryMap.put("selectVal", selectVal);
		qryMap.put("entSupTrade", entSupTrade);
		crAnalyMacEconomyList = crAnalyMacEconomyService.doGetCrAnalyMacEconomyTrendList(qryMap);
		for(CrAnalyMacEconomy list:crAnalyMacEconomyList){
			String dateStr = list.getEcoMonth();
			dateStr = dateStr.substring(0, 4)+"-"+dateStr.substring(4);
			if(list.getEcoImpAmount()==null){list.setEcoImpAmount(new BigDecimal("0")); }
			dataList.add(list.getEcoImpAmount());
			timeList.add(dateStr);
			if(list.getEcoExpAmount()==null){list.setEcoExpAmount(new BigDecimal("0")); }
			dataExpList.add(list.getEcoExpAmount());
		}
		if(selectVal.equals("eco_imp_amount")){
			this.addAjaxResults("dataExpList", dataExpList);
		}
		this.addAjaxResults("dataList", dataList);
		this.addAjaxResults("timeList", timeList);
		return AJAX;
	}

	
	public CrAnalyMacEconomyService getCrAnalyMacEconomyService()
	{
		return crAnalyMacEconomyService;
	}
	public void setCrAnalyMacEconomyService(CrAnalyMacEconomyService crAnalyMacEconomyService)
	{
		this.crAnalyMacEconomyService = crAnalyMacEconomyService;
	}

	public CrAnalyMacEconomy getCrAnalyMacEconomy()
	{
		return crAnalyMacEconomy;
	}

	public void setCrAnalyMacEconomy(CrAnalyMacEconomy crAnalyMacEconomy)
	{
		this.crAnalyMacEconomy = crAnalyMacEconomy;
	}

	public String[] getCrAnalyMacEconomyIds()
	{
		return crAnalyMacEconomyIds;
	}

	public void setCrAnalyMacEconomyIds(String[] crAnalyMacEconomyIds)
	{
		this.crAnalyMacEconomyIds = crAnalyMacEconomyIds;
	}

	public YcCodeIndustryTypeService getYcCodeIndustryTypeService() {
		return ycCodeIndustryTypeService;
	}

	public void setYcCodeIndustryTypeService(
			YcCodeIndustryTypeService ycCodeIndustryTypeService) {
		this.ycCodeIndustryTypeService = ycCodeIndustryTypeService;
	}

	public String getSelectVal() {
		return selectVal;
	}

	public void setSelectVal(String selectVal) {
		this.selectVal = selectVal;
	}

	public String getEntSupTrade() {
		return entSupTrade;
	}

	public void setEntSupTrade(String entSupTrade) {
		this.entSupTrade = entSupTrade;
	}

	
}
