/**

 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-22
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crpunish;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crpunish.CrPunish;
import com.icinfo.creditinfo.pagination.AjaxPagination;
import com.icinfo.creditinfo.service.biz.crpunish.CrPunishService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.common.AESEUtil;
import com.icinfo.plugin.pagination.context.PaginationContext;

/** 
 * 描述: 行政处罚信息 Action 类<br>
 * @author yulirong
 * @date 2015-10-22
 */
public class CrPunishAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrPunishService crPunishService;
	private CrPunish crPunish;
	private String[] crPunishIds;
	private List<CrPunish> crPunishList;
	private String ajaxUrl;

	/**
	 * 描述: 查看列表
	 * @auther yulirong
	 * @date 2015-10-22
	 * @return
	 * @throws Exception
	 */
	public String doReadCrPunishListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 获取行政处罚信息
	 * @auther yulirong
	 * @date 2015-10-22
	 * @return
	 * @throws Exception
	 */
	public String  doReadPermissionCrPunishListJSON() throws Exception {
		PaginationContext context = doGetContextRequestMap();
		context.setPageSize(5);
		context.setNavigationTemplate("ajax.ftl");
		context.setPageParamName("pageNo3");
		Map<String,Object> qryMap  = context.getAllRequestMap();
		context.getSkipResult();
		crPunishList = crPunishService.doGetList(qryMap);
	    AjaxPagination pagination = new AjaxPagination(crPunishList,crPunishService.doGetTotal(qryMap),context);
		pagination.setDataUrl(ajaxUrl);
		pagination.setShowId("ajax3");
		this.addAjaxResults("dataList", pagination.getDataList());
		this.addAjaxResults("skipResult", pagination.getSkipResult());
		this.addAjaxResults("paginationHtml", pagination.getPageHtml());
		return AJAX;
	}
	/**
	 * 描述: 个人详情关联处罚信息
	 * @auther gaotong
	 * @date 2015-10-22
	 * @return
	 * @throws Exception
	 */
	public String doReadPermissionPeopleCrPunishListJSON() throws Exception{
		PaginationContext context = doGetContextRequestMap();
		context.setPageSize(5);
		context.setNavigationTemplate("ajax.ftl");
		context.setPageParamName("pageNo2");
		Map<String,Object> qryMap  = context.getAllRequestMap();
		qryMap.put("sfzjhm", AESEUtil.decryptContext(qryMap.get("punishedCertNo").toString()));
		qryMap.remove("punishedCertNo");
		context.getSkipResult();
		qryMap.put("notePublicSecurity","公安局");
		crPunishList = crPunishService.doGetList(qryMap);
	    AjaxPagination pagination = new AjaxPagination(crPunishList,crPunishService.doGetTotal(qryMap),context);
		pagination.setDataUrl(ajaxUrl);
		pagination.setShowId("ajax2");
		this.addAjaxResults("dataList", pagination.getDataList());
		this.addAjaxResults("skipResult", pagination.getSkipResult());
		this.addAjaxResults("paginationHtml", pagination.getPageHtml());
		return AJAX;
	}
	
	
	public CrPunishService getCrPunishService()
	{
		return crPunishService;
	}
	public void setCrPunishService(CrPunishService crPunishService)
	{
		this.crPunishService = crPunishService;
	}

	public CrPunish getCrPunish()
	{
		return crPunish;
	}

	public void setCrPunish(CrPunish crPunish)
	{
		this.crPunish = crPunish;
	}

	public String[] getCrPunishIds()
	{
		return crPunishIds;
	}

	public void setCrPunishIds(String[] crPunishIds)
	{
		this.crPunishIds = crPunishIds;
	}

	public List<CrPunish> getCrPunishList() {
		return crPunishList;
	}

	public void setCrPunishList(List<CrPunish> crPunishList) {
		this.crPunishList = crPunishList;
	}

	public String getAjaxUrl() {
		return ajaxUrl;
	}

	public void setAjaxUrl(String ajaxUrl) {
		this.ajaxUrl = ajaxUrl;
	}

	
}
