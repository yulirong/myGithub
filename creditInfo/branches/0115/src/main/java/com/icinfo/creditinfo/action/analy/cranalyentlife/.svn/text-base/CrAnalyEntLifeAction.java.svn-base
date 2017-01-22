/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author mayawei
 * @date 2015-10-29
 * @version 1.0
 */
package com.icinfo.creditinfo.action.analy.cranalyentlife;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import com.icinfo.creditinfo.bean.analy.cranalyentlife.CrAnalyEntLife;
import com.icinfo.creditinfo.service.analy.cranalyentlife.CrAnalyEntLifeService;
import com.icinfo.creditinfo.service.biz.yccodeindustrytype.YcCodeIndustryTypeService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;

/** 
 * 描述: 企业新生消亡趋势分析 Action 类<br>
 * @author mayawei
 * @date 2015-10-29
 */
public class CrAnalyEntLifeAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrAnalyEntLifeService crAnalyEntLifeService;
	private CrAnalyEntLife crAnalyEntLife;
	private String[] crAnalyEntLifeIds;
	
	private YcCodeIndustryTypeService ycCodeIndustryTypeService;
	
	/**
	 * 描述: 查看列表
	 * @auther mayawei
	 * @date 2015-10-29
	 * @return
	 * @throws Exception
	 */
	public String doReadCrAnalyEntLifeListAction() throws Exception 
	{
		Map<String,Object> dataMap = crAnalyEntLifeService.doGetCrAnalyEntLifeJsonForCharts(null);
		JSONObject dataMapJson = new JSONObject().fromObject(dataMap);
		this.addJstlResults("crAnalyEntLifeJson",crAnalyEntLifeService.doGetCrAnalyEntLifeJson(null));
		this.addJstlResults("industryTypeList",ycCodeIndustryTypeService.doGetList(null));
		this.addJstlResults("dataMapJson",dataMapJson);
		String updateTime = crAnalyEntLifeService.doGetLastCrEntLifeTime();
		this.addJstlResults("updateTime",updateTime);
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 查询信息
	 * @auther mayawei
	 * @date 2015-10-29
	 * @return
	 * @throws Exception
	 */
	public String doGetCrAnalyEntLifeJSONAction() throws Exception {
		Map<String,Object> qryMap = new HashMap<String, Object>();
		if(crAnalyEntLife!=null&&crAnalyEntLife.getEntSupTrade()!=null&&!"".equals(crAnalyEntLife.getEntSupTrade()))
		qryMap.put("entSupTrade", crAnalyEntLife.getEntSupTrade());
		this.addAjaxResults("crAnalyEntLifeJson",crAnalyEntLifeService.doGetCrAnalyEntLifeJson(qryMap));
		return AJAX;
	}
	
	/**
	 * 描述：获得行业类型Ajax
	 * @author 马亚伟
	 * @date 2015-10-29
	 * @return String
	 * @throws Exception
	 */
	public String doGetIndustryTypeListJSONAction() throws Exception{
		this.addJstlResults("industryTypeList",ycCodeIndustryTypeService.doGetList(null));
		return NONE;
	}
	
	/**
	 * 描述：获取三大产业统计值
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	public String doGetBigEntLifeListJSONAction() throws Exception{
		List<CrAnalyEntLife> entList = crAnalyEntLifeService.doGetBigEntList(null);
		this.addAjaxResults("dataList", crAnalyEntLifeService.doBuildBigEntList(entList));
		return AJAX;
	}
	
	
	public CrAnalyEntLifeService getCrAnalyEntLifeService()
	{
		return crAnalyEntLifeService;
	}
	public void setCrAnalyEntLifeService(CrAnalyEntLifeService crAnalyEntLifeService)
	{
		this.crAnalyEntLifeService = crAnalyEntLifeService;
	}

	public CrAnalyEntLife getCrAnalyEntLife()
	{
		return crAnalyEntLife;
	}

	public void setCrAnalyEntLife(CrAnalyEntLife crAnalyEntLife)
	{
		this.crAnalyEntLife = crAnalyEntLife;
	}

	public String[] getCrAnalyEntLifeIds()
	{
		return crAnalyEntLifeIds;
	}

	public void setCrAnalyEntLifeIds(String[] crAnalyEntLifeIds)
	{
		this.crAnalyEntLifeIds = crAnalyEntLifeIds;
	}

	public YcCodeIndustryTypeService getYcCodeIndustryTypeService() {
		return ycCodeIndustryTypeService;
	}

	public void setYcCodeIndustryTypeService(
			YcCodeIndustryTypeService ycCodeIndustryTypeService) {
		this.ycCodeIndustryTypeService = ycCodeIndustryTypeService;
	}

	
}
