/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-28
 * @version 1.0
 */
package com.icinfo.creditinfo.action.analy.cranalyentsmall;

import com.icinfo.creditinfo.bean.analy.cranalyentsmall.CrAnalyEntSmall;
import com.icinfo.creditinfo.service.analy.cranalyentsmall.CrAnalyEntSmallService;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.icinfo.plugin.pagination.Pagination;

/** 
 * 描述: 小微企业 Action 类<br>
 * @author liyafeng
 * @date 2015-11-28
 */
public class CrAnalyEntSmallAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrAnalyEntSmallService crAnalyEntSmallService;
	private CrAnalyEntSmall crAnalyEntSmall;
	private List<BigDecimal> yearList;
	private BigDecimal year;
	private String trade;//行业
	private String industry;//产业
	private String type;//营业收入，用水量，用电量

	/**
	 * 描述: 获得年份集合
	 * @auther liyafeng
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public String doEnCrAnalyEntSmallAction() throws Exception 
	{   
		yearList=crAnalyEntSmallService.doGetYearList();
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 获得区域企业数
	 * @auther liyafeng
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public String doReadCrAnalyEntSmallNumByZoneJSONAction() throws Exception {
		Map<String,Object> qryMap = new HashMap<String,Object>();
		qryMap.put("entYear", year);
		qryMap.put("trade", trade);
		qryMap.put("industry", industry);
		qryMap.put("smallEnt", "1");
		JSONObject dataMap=crAnalyEntSmallService.doGetCrAnalyEntSmallNumByZone(qryMap);
		this.addAjaxResults("dataMap", dataMap);
		return AJAX;
	}
	/**
	 * 
	 * 描述: 小微企业活跃度分析
	 * @author LiYaFeng
	 * @date 2015年11月28日 
	 * @return
	 */
	public String doReadCrAnalyEntSmallActiveJSONAction() throws Exception{
		Map<String,Object> qryMap = new HashMap<String,Object>();
		qryMap.put("entYear", year);
		qryMap.put("trade", trade);
		qryMap.put("industry", industry);
		Map<String,Object> dataMap=crAnalyEntSmallService.doGetCrAnalyEntSmallActive(qryMap);
		this.addAjaxResults("totalNum",JSONArray.fromObject((Integer)dataMap.get("totalNum")));
		this.addAjaxResults("openNum",JSONArray.fromObject((Integer)dataMap.get("openNum")));
		this.addAjaxResults("smallTotalNum",JSONArray.fromObject((Integer)dataMap.get("smallTotalNum")));
		this.addAjaxResults("smallTotalNumPercent",(String)dataMap.get("smallTotalNumPercent"));
		this.addAjaxResults("openSmallPercent",(String)dataMap.get("openSmallPercent"));
		return AJAX;
	}
	/**
	 * 
	 * 描述: 新生消亡
	 * @author LiYaFeng
	 * @date 2015年11月28日 
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String doReadCrAnalyEntSmallNewAndDieJSONAction() throws Exception{
		Map<String,Object> qryMap = new HashMap<String,Object>();
		qryMap.put("entYear", year);
		qryMap.put("trade", trade);
		qryMap.put("industry", industry);
		qryMap.put("smallEnt", "1");
		Map<String,Object> dataMap=crAnalyEntSmallService.doGetNewAndDieAndDateList(qryMap);
		this.addAjaxResults("newNumList",JSONArray.fromObject((List<BigDecimal>)dataMap.get("newNumList")));
		this.addAjaxResults("dieNumList",JSONArray.fromObject((List<BigDecimal>)dataMap.get("dieNumList")));
		this.addAjaxResults("dateList",JSONArray.fromObject((List<String>)dataMap.get("dateList")));
		return AJAX;
	}
	/**
	 * 
	 * 描述:经营状况趋势
	 * @author LiYaFeng
	 * @date 2015年11月28日 
	 * @return
	 * @throws Exception 
	 */
	public String doReadOperateStateJSONAction() throws Exception{
		Map<String,Object> qryMap = new HashMap<String,Object>();
		qryMap.put("entYear", year);
		qryMap.put("trade", trade);
		qryMap.put("industry", industry);
		qryMap.put("smallEnt", "1");
		qryMap.put("type", type);
		Map<String,Object> dataMap=crAnalyEntSmallService.doGetOperateStateListAndDateList(qryMap);
		this.addAjaxResults("numList",JSONArray.fromObject((List<BigDecimal>)dataMap.get("numList")));
		this.addAjaxResults("entNumList",JSONArray.fromObject((List<BigDecimal>)dataMap.get("entNumList")));
		this.addAjaxResults("incomelast",JSONArray.fromObject((BigDecimal)dataMap.get("incomelast")));
		this.addAjaxResults("dateList",JSONArray.fromObject((List<String>)dataMap.get("dateList")));
		this.addAjaxResults("percent",(String)dataMap.get("percent"));
		this.addAjaxResults("increEntNum",dataMap.get("increEntNum").toString());
		this.addAjaxResults("increpercent",(String)dataMap.get("increpercent"));
		return AJAX;
	}
	/**
	 * 
	 * 描述: 就业情况
	 * @author LiYaFeng
	 * @date 2015年11月29日 
	 * @return
	 * @throws Exception
	 */
	public String doReadEmpStatusJSONAction() throws Exception{
		Map<String,Object> qryMap = new HashMap<String,Object>();
		qryMap.put("entYear", year);
		qryMap.put("trade", trade);
		qryMap.put("industry", industry);
		qryMap.put("smallEnt", "1");
		Map<String,Object> dataMap=crAnalyEntSmallService.doGetEmpStatus(qryMap);
		this.addAjaxResults("empNumList",JSONArray.fromObject((List<BigDecimal>)dataMap.get("empNumList")));
		this.addAjaxResults("empNumLast",JSONArray.fromObject((BigDecimal)dataMap.get("empNumLast")));
		this.addAjaxResults("entNumList",JSONArray.fromObject((List<BigDecimal>)dataMap.get("entNumList")));
		this.addAjaxResults("dateList",JSONArray.fromObject((List<String>)dataMap.get("dateList")));
		this.addAjaxResults("empNumLastPercent",(String)dataMap.get("empNumLastPercent"));
		this.addAjaxResults("avgEmpNum",JSONArray.fromObject(dataMap.get("avgNum")));
		return AJAX;
	}
	/**
	 * 
	 * 描述: 三年成长轨迹
	 * @author LiYaFeng
	 * @date 2015年11月29日 
	 * @return
	 * @throws Exception 
	 */
	public String doReadThreeYearGrowJSONAction() throws Exception{
		Map<String,Object> qryMap = new HashMap<String,Object>();
		qryMap.put("entYear", year);
		qryMap.put("trade", trade);
		qryMap.put("industry", industry);
		qryMap.put("smallEnt", "1");
		BigDecimal year=(BigDecimal) qryMap.get("entYear");
		qryMap.put("secondYear", new BigDecimal(year.intValue()+1));
		qryMap.put("thirdYear", new BigDecimal(year.intValue()+2));
		Map<String,Object> dataMap=crAnalyEntSmallService.doGetThreeYearGrow(qryMap);
		if(dataMap==null){
		  this.addAjaxResults("dataMap",null);
		}else{
		  this.addAjaxResults("dataMap",JSONObject.fromObject(dataMap));
		}
		return AJAX;
	}
	public CrAnalyEntSmallService getCrAnalyEntSmallService()
	{
		return crAnalyEntSmallService;
	}
	public void setCrAnalyEntSmallService(CrAnalyEntSmallService crAnalyEntSmallService)
	{
		this.crAnalyEntSmallService = crAnalyEntSmallService;
	}

	public CrAnalyEntSmall getCrAnalyEntSmall()
	{
		return crAnalyEntSmall;
	}

	public void setCrAnalyEntSmall(CrAnalyEntSmall crAnalyEntSmall)
	{
		this.crAnalyEntSmall = crAnalyEntSmall;
	}
	public List<BigDecimal> getYearList() {
		return yearList;
	}

	public void setYearList(List<BigDecimal> yearList) {
		this.yearList = yearList;
	}

	public BigDecimal getYear() {
		return year;
	}

	public void setYear(BigDecimal year) {
		this.year = year;
	}

	public String getTrade() {
		return trade;
	}

	public void setTrade(String trade) {
		this.trade = trade;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
    
	
}
