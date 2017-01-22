/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-11-06
 * @version 1.0
 */
package com.icinfo.creditinfo.action.analy.cranalyzone;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.analy.cranalyzone.CrAnalyZone;
import com.icinfo.creditinfo.service.analy.cranalyzone.CrAnalyZoneService;
import com.icinfo.creditinfo.service.biz.crentbaseinfo.CrEntBaseInfoService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.icinfo.plugin.common.HxDateUtil;

/** 
 * 描述: 地域分布 Action 类<br>
 * @author zhuyong
 * @date 2015-11-06
 */
public class CrAnalyZoneAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrAnalyZoneService crAnalyZoneService;
	private CrAnalyZone crAnalyZone;
	private String typeName;
	private CrEntBaseInfoService crEntBaseInfoService;
	
	/**
	 * 描述: 地域分布数据集
	 * 
	 * @author zhuyong
	 * @date 2015-11-06
	 * @return
	 * @throws Exception
	 */
	public String doReadCrAnalyZoneAnalyJSONAction() throws Exception {
		Map<String,Object> qryMap = new HashMap<String, Object>();
		List<CrAnalyZone> zoneList = crAnalyZoneService.doGetList(null);
		this.addAjaxResults("dataList",crAnalyZoneService.doBuildDataList(zoneList, typeName));
		this.addAjaxResults("dataTotal",crAnalyZoneService.doBuildTotalNum(zoneList, typeName));
		this.addAjaxResults("allentnum",crAnalyZoneService.doGetAllEntNum(zoneList));
		qryMap.put("newDate",HxDateUtil.stringToDate("2015-01-01", "yyyy-MM-dd"));
		this.addAjaxResults("newentnum",crEntBaseInfoService.doGetTotal(qryMap));
		return AJAX;
	}
	
	

	public CrAnalyZoneService getCrAnalyZoneService()
	{
		return crAnalyZoneService;
	}
	public void setCrAnalyZoneService(CrAnalyZoneService crAnalyZoneService)
	{
		this.crAnalyZoneService = crAnalyZoneService;
	}

	public CrAnalyZone getCrAnalyZone()
	{
		return crAnalyZone;
	}

	public void setCrAnalyZone(CrAnalyZone crAnalyZone)
	{
		this.crAnalyZone = crAnalyZone;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}



	public CrEntBaseInfoService getCrEntBaseInfoService() {
		return crEntBaseInfoService;
	}



	public void setCrEntBaseInfoService(CrEntBaseInfoService crEntBaseInfoService) {
		this.crEntBaseInfoService = crEntBaseInfoService;
	}

	
}
