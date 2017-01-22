/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-11-04
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crristindex;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.commons.lang3.StringUtils;

import com.icinfo.creditinfo.bean.biz.crentbaseinfo.CrEntBaseInfo;
import com.icinfo.creditinfo.bean.biz.crristindex.CrRistIndex;
import com.icinfo.creditinfo.service.biz.crentbaseinfo.CrEntBaseInfoService;
import com.icinfo.creditinfo.service.biz.crristindex.CrRistIndexService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.icinfo.plugin.common.AESEUtil;

/** 
 * 描述: 风险指数 Action 类<br>
 * @author zhuyong
 * @date 2015-11-04
 */
public class CrRistIndexAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrRistIndexService crRistIndexService;
	private CrEntBaseInfoService crEntBaseInfoService;
	private CrRistIndex crRistIndex;
	private String[] crRistIndexIds;
	private CrEntBaseInfo crEntBaseInfo;
	private String corpid;
	private String trade;//行业
	
	/**
	 * 描述：进入风险指数主页
	 * 
	 * @author zhuyong
	 * @date 2015-11-04
	 * @return
	 * @throws Exception
	 */
	public String doEnCrRistIndexAnalyAction() throws Exception{
		if (StringUtils.isNotBlank(corpid) && corpid.length() > 16) {
			corpid = AESEUtil.decryptContext(corpid);
		}
		Map<String,Object> qryMap = new HashMap<String, Object>();
		qryMap.put("corpid", corpid);
		crEntBaseInfo = crEntBaseInfoService.doGetList(qryMap).get(0); 
		return SUCCESS;
	}
	
	
	/**
	 * 描述: 查询分析信息
	 * 
	 * @author zhuyong
	 * @date 2015-11-04
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String doReadCrRistIndexAnalyJSONAction() throws Exception {
		if (StringUtils.isNotBlank(corpid) && corpid.length() > 16) {
			corpid = AESEUtil.decryptContext(corpid);
		}
		Map<String,Object> qryMap = new HashMap<String, Object>();
		qryMap.put("corpid", corpid);
		qryMap.put("trade", trade);
		List<CrRistIndex> indexList = crRistIndexService.doGetCrRistIndexList(qryMap);
		if(indexList==null || indexList.size()==0){
			return AJAX;
		}
		Map<String,Object> rstMap = crRistIndexService.doBuildResultMap(indexList);
		List<String> axisList = (List<String>)rstMap.get("axisList");
		List<BigDecimal> dataList = (List<BigDecimal>)rstMap.get("dataList");
		List<BigDecimal> avgDataList = (List<BigDecimal>)rstMap.get("avgDataList");
		this.addAjaxResults("axisList", JSONArray.fromObject(axisList));
		this.addAjaxResults("dataList", JSONArray.fromObject(dataList));
		this.addAjaxResults("avgDataList", JSONArray.fromObject(avgDataList));
		return AJAX;
	}
	
	/**
	 * 描述:获取值得关注的高风险企业（top10）数据
	 * 
	 * @author yulirong
	 * @date 2015-11-11
	 * @return
	 * @throws Exception
	 */
	public String doGetCrRistIndexTopAction() throws Exception {
		Map<String,Object> qryMap = new HashMap<String, Object>();
		List<CrRistIndex>  crRistIndexList = new ArrayList<CrRistIndex>();
		List<String> entList = new ArrayList<String>();
		List<BigDecimal> ristList = new ArrayList<BigDecimal>();
		qryMap.put("ristState", 1);
		crRistIndexList = crRistIndexService.doGetCrRistIndexToptList(qryMap);
		for(int i=9;i>=0;i--){
			entList.add(crRistIndexList.get(i).getEntName());
			ristList.add(crRistIndexList.get(i).getRistIndex());
		}
		this.addAjaxResults("entList", entList);
		this.addAjaxResults("ristList",ristList);
		return AJAX;
	}
	
	
	public CrRistIndexService getCrRistIndexService()
	{
		return crRistIndexService;
	}
	public void setCrRistIndexService(CrRistIndexService crRistIndexService)
	{
		this.crRistIndexService = crRistIndexService;
	}

	public CrRistIndex getCrRistIndex()
	{
		return crRistIndex;
	}

	public void setCrRistIndex(CrRistIndex crRistIndex)
	{
		this.crRistIndex = crRistIndex;
	}

	public String[] getCrRistIndexIds()
	{
		return crRistIndexIds;
	}

	public void setCrRistIndexIds(String[] crRistIndexIds)
	{
		this.crRistIndexIds = crRistIndexIds;
	}


	public String getCorpid() {
		return corpid;
	}


	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}


	public CrEntBaseInfoService getCrEntBaseInfoService() {
		return crEntBaseInfoService;
	}


	public void setCrEntBaseInfoService(CrEntBaseInfoService crEntBaseInfoService) {
		this.crEntBaseInfoService = crEntBaseInfoService;
	}


	public CrEntBaseInfo getCrEntBaseInfo() {
		return crEntBaseInfo;
	}


	public void setCrEntBaseInfo(CrEntBaseInfo crEntBaseInfo) {
		this.crEntBaseInfo = crEntBaseInfo;
	}


	public String getTrade() {
		return trade;
	}


	public void setTrade(String trade) {
		this.trade = trade;
	}
    
	
	
}
