/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.action.analy.cranalyguarantrelationdata;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.icinfo.creditinfo.bean.analy.cranalyguarantrelationdata.CrAnalyGuarantRelationData;
import com.icinfo.creditinfo.service.analy.cranalyguarantrelationdata.CrAnalyGuarantRelationDataService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;

/** 
 * 描述: 担保圈分析 Action 类<br>
 * @author zhuyong
 * @date 2015-11-12
 */
public class CrAnalyGuarantRelationDataAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrAnalyGuarantRelationDataService crAnalyGuarantRelationDataService;
	private CrAnalyGuarantRelationData crAnalyGuarantRelationData;
	private String[] crAnalyGuarantRelationDataIds;
	private String qno;
	/**
	 * 描述: 分页查询信息
	 * 
	 * @author zhuyong
	 * @date 2015-11-12
	 * @return
	 * @throws Exception
	 */
	public String doReadCrAnalyGuarantRelationDataListJSONAction() throws Exception {
		List<CrAnalyGuarantRelationData> dataList = crAnalyGuarantRelationDataService.doGetList(null);
		Map<String,Object> rstMap = crAnalyGuarantRelationDataService.doBuildResultMap(dataList);
		List<CrAnalyGuarantRelationData> dataList2 = crAnalyGuarantRelationDataService.doGetGuarantEntryTotal(null);
		if(dataList2==null || dataList2.size()==0){
			crAnalyGuarantRelationData = new CrAnalyGuarantRelationData();
			crAnalyGuarantRelationData.setEntNum(0);
			crAnalyGuarantRelationData.setPerNum(0);
		}else {
			crAnalyGuarantRelationData  = dataList2.get(0);
		}
		this.addAjaxResults("nodeList", (JSONArray)rstMap.get("nodeList"));
		this.addAjaxResults("linkList", (JSONArray)rstMap.get("linkList"));
		this.addAjaxResults("cateList", (JSONArray)rstMap.get("cateList"));
		this.addAjaxResults("danbao", crAnalyGuarantRelationDataService.doGetTotal(null));
		this.addAjaxResults("ent", crAnalyGuarantRelationData.getEntNum());
		this.addAjaxResults("people", crAnalyGuarantRelationData.getPerNum());
		this.addAjaxResults("independ", crAnalyGuarantRelationDataService.doGetGuarantGroupTotal(null));
		this.addAjaxResults("relation", (int)Math.floor(crAnalyGuarantRelationDataService.doGetDoubleGuarantList(null).size()/2));
		this.addAjaxResults("noguarantee", crAnalyGuarantRelationDataService.doGetNoReturnGuarantTotal(null));
		return AJAX;
	}
	
	
	/**
	 * 描述: 全屏信息数据获取
	 * 
	 * @author zhuyong
	 * @date 2015-11-12
	 * @return
	 * @throws Exception
	 */
	public String doReadGuarantRelationFullScreenJSONAction() throws Exception {
		Map<String,Object> qryMap = new HashMap<String, Object>();
		qryMap.put("relGuaNo",qno);
		List<CrAnalyGuarantRelationData> dataList = crAnalyGuarantRelationDataService.doGetList(qryMap);
		Map<String,Object> rstMap = crAnalyGuarantRelationDataService.doBuildFullScreenResultMap(dataList);
		this.addAjaxResults("nodeList", (JSONArray)rstMap.get("nodeList"));
		this.addAjaxResults("linkList", (JSONArray)rstMap.get("linkList"));
		this.addAjaxResults("cateList", (JSONArray)rstMap.get("cateList"));
		return AJAX;
	}
	
	
	/**
	 * 描述：进入全屏页面
	 * 
	 * @author zhuyong
	 * @date 2015-12-15
	 * @return
	 */
	public String doEnFullScreenAction(){
		System.out.println();
		System.err.println(qno);
		return SUCCESS;
	}
	
	public CrAnalyGuarantRelationDataService getCrAnalyGuarantRelationDataService()
	{
		return crAnalyGuarantRelationDataService;
	}
	public void setCrAnalyGuarantRelationDataService(CrAnalyGuarantRelationDataService crAnalyGuarantRelationDataService)
	{
		this.crAnalyGuarantRelationDataService = crAnalyGuarantRelationDataService;
	}

	public CrAnalyGuarantRelationData getCrAnalyGuarantRelationData()
	{
		return crAnalyGuarantRelationData;
	}

	public void setCrAnalyGuarantRelationData(CrAnalyGuarantRelationData crAnalyGuarantRelationData)
	{
		this.crAnalyGuarantRelationData = crAnalyGuarantRelationData;
	}

	public String[] getCrAnalyGuarantRelationDataIds()
	{
		return crAnalyGuarantRelationDataIds;
	}

	public void setCrAnalyGuarantRelationDataIds(String[] crAnalyGuarantRelationDataIds)
	{
		this.crAnalyGuarantRelationDataIds = crAnalyGuarantRelationDataIds;
	}


	public String getQno() {
		return qno;
	}
	public void setQno(String qno) {
		this.qno = qno;
	}

	
}
