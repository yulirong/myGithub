/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-10-26
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crsequestrateall;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crsequestrateall.CrSequestrateAll;
import com.icinfo.creditinfo.pagination.AjaxPagination;
import com.icinfo.creditinfo.service.biz.crsequestrateall.CrSequestrateAllService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.icinfo.plugin.pagination.context.PaginationContext;
import com.opensymphony.xwork2.Action;

/** 
 * 描述: 土地房产查封信息 Action 类<br>
 * @author gaotong
 * @date 2015-10-26
 */
public class CrSequestrateAllAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrSequestrateAllService crSequestrateAllService;
	private CrSequestrateAll crSequestrateAll;
	private String[] crSequestrateAllIds;
	private List<CrSequestrateAll> crSequestrateAllList;
	private String corpid;
	private String ajaxUrl;

	/**
	 * 描述: 查看列表
	 * @auther gaotong
	 * @date 2015-10-26
	 * @return
	 * @throws Exception
	 */
	public String doReadCrSequestrateAllListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 房产查封信息
	 * @auther yulirong
	 * @date 2015-10-26
	 * @return
	 * @throws Exception
	 */
	public String doReadPermissionCrSequestrateAllListJSON() throws Exception 
	{
		PaginationContext context = doGetContextRequestMap();
		context.setPageSize(5);
		context.setNavigationTemplate("ajax.ftl");
		context.setPageParamName("pageNo11");
		Map<String,Object> qryMap  = context.getAllRequestMap();
		context.getSkipResult();
		qryMap.put("importFrom", "建设局");
		crSequestrateAllList = crSequestrateAllService.doGetList(qryMap);
	    AjaxPagination pagination = new AjaxPagination(crSequestrateAllList,crSequestrateAllService.doGetTotal(qryMap),context);
		pagination.setDataUrl(ajaxUrl);
		pagination.setShowId("ajax11");
		this.addAjaxResults("dataList", pagination.getDataList());
		this.addAjaxResults("skipResult", pagination.getSkipResult());
		this.addAjaxResults("paginationHtml", pagination.getPageHtml());
		return AJAX;
	}
	
	/**
	 * 描述: 土地查封信息
	 * @auther yulirong
	 * @date 2015-12-18
	 * @return
	 * @throws Exception
	 */
	public String doReadPermissionLandCrSequestrateAllListJSON() throws Exception 
	{
		PaginationContext context = doGetContextRequestMap();
		context.setPageSize(5);
		context.setNavigationTemplate("ajax.ftl");
		context.setPageParamName("pageNo12");
		Map<String,Object> qryMap  = context.getAllRequestMap();
		context.getSkipResult();
		qryMap.put("importFrom", "国土资源局");
		crSequestrateAllList = crSequestrateAllService.doGetList(qryMap);
	    AjaxPagination pagination = new AjaxPagination(crSequestrateAllList,crSequestrateAllService.doGetTotal(qryMap),context);
		pagination.setDataUrl(ajaxUrl);
		pagination.setShowId("ajax12");
		this.addAjaxResults("dataList", pagination.getDataList());
		this.addAjaxResults("skipResult", pagination.getSkipResult());
		this.addAjaxResults("paginationHtml", pagination.getPageHtml());
		return AJAX;
	}
	

	/**
	 * 描述: 批量删除
	 * @auther gaotong
	 * @date 2015-10-26
	 * @return
	 * @throws Exception
	 */
	public String doDelCrSequestrateAllAction() throws Exception{
		crSequestrateAllService.doRmBatch(crSequestrateAllIds);
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	public CrSequestrateAllService getCrSequestrateAllService()
	{
		return crSequestrateAllService;
	}
	public void setCrSequestrateAllService(CrSequestrateAllService crSequestrateAllService)
	{
		this.crSequestrateAllService = crSequestrateAllService;
	}

	public CrSequestrateAll getCrSequestrateAll()
	{
		return crSequestrateAll;
	}

	public void setCrSequestrateAll(CrSequestrateAll crSequestrateAll)
	{
		this.crSequestrateAll = crSequestrateAll;
	}

	public String[] getCrSequestrateAllIds()
	{
		return crSequestrateAllIds;
	}

	public void setCrSequestrateAllIds(String[] crSequestrateAllIds)
	{
		this.crSequestrateAllIds = crSequestrateAllIds;
	}

	public List<CrSequestrateAll> getCrSequestrateAllList() {
		return crSequestrateAllList;
	}

	public void setCrSequestrateAllList(List<CrSequestrateAll> crSequestrateAllList) {
		this.crSequestrateAllList = crSequestrateAllList;
	}

	public String getCorpid() {
		return corpid;
	}

	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}

	public String getAjaxUrl() {
		return ajaxUrl;
	}

	public void setAjaxUrl(String ajaxUrl) {
		this.ajaxUrl = ajaxUrl;
	}

	
}
