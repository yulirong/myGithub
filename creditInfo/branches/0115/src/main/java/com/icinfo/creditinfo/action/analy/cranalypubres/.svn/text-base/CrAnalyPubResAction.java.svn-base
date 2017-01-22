/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-07
 * @version 1.0
 */
package com.icinfo.creditinfo.action.analy.cranalypubres;

import java.util.HashMap;
import java.util.Map;

import net.sf.json.JSONObject;

import com.icinfo.creditinfo.bean.analy.cranalypubres.CrAnalyPubRes;
import com.icinfo.creditinfo.service.analy.cranalypubres.CrAnalyPubResService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;

/** 
 * 描述: 公共资源统计表 Action 类<br>
 * @author myw
 * @date 2015-11-07
 */
public class CrAnalyPubResAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrAnalyPubResService crAnalyPubResService;
	private CrAnalyPubRes crAnalyPubRes;
	private String[] crAnalyPubResIds;

	//行业类型
	private String publicSourceType;
	/**
	 * 描述: 查看列表
	 * @auther myw
	 * @date 2015-11-07
	 * @return
	 * @throws Exception
	 */
	public String doReadCrAnalyPubResListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 分页查询信息
	 * @auther myw
	 * @date 2015-11-07
	 * @return
	 * @throws Exception
	 */
	public String doReadCrAnalyPubResListJSONAction() throws Exception {
		//资源类型
		Map<String, String> resType = new HashMap<String, String>();
		resType.put("water", "CR_WATER_PAY");
		resType.put("gas", "CR_GAS_PAY");
		resType.put("elec", "CR_ELEC_PAY");
		resType.put("sewage", "CR_WATER_SEWAGE_DISCHARGE_PAY");
		
		Map<String,Object> qryMap = new HashMap<String, Object>();
		qryMap.put("publicSourceType", resType.get(publicSourceType));
		JSONObject dataMap = crAnalyPubResService.doGetAnalyPubResByType(qryMap);
		this.addAjaxResults("dataMap", dataMap);
		return AJAX;
	}
	
		
	public CrAnalyPubResService getCrAnalyPubResService()
	{
		return crAnalyPubResService;
	}
	public void setCrAnalyPubResService(CrAnalyPubResService crAnalyPubResService)
	{
		this.crAnalyPubResService = crAnalyPubResService;
	}

	public CrAnalyPubRes getCrAnalyPubRes()
	{
		return crAnalyPubRes;
	}

	public void setCrAnalyPubRes(CrAnalyPubRes crAnalyPubRes)
	{
		this.crAnalyPubRes = crAnalyPubRes;
	}

	public String[] getCrAnalyPubResIds()
	{
		return crAnalyPubResIds;
	}

	public void setCrAnalyPubResIds(String[] crAnalyPubResIds)
	{
		this.crAnalyPubResIds = crAnalyPubResIds;
	}

	public String getPublicSourceType() {
		return publicSourceType;
	}

	public void setPublicSourceType(String publicSourceType) {
		this.publicSourceType = publicSourceType;
	}

	
}
