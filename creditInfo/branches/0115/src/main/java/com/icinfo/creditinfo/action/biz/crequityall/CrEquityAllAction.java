/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-10-26
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crequityall;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icinfo.creditinfo.bean.biz.crequityall.CrEquityAll;
import com.icinfo.creditinfo.pagination.AjaxPagination;
import com.icinfo.creditinfo.service.biz.crequityall.CrEquityAllService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.icinfo.plugin.common.AESEUtil;
import com.icinfo.plugin.common.StringUtil;
import com.icinfo.plugin.pagination.context.PaginationContext;
import com.opensymphony.xwork2.Action;

/** 
 * 描述: 出质信息 Action 类<br>
 * @author gaotong
 * @date 2015-10-26
 */
public class CrEquityAllAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrEquityAllService crEquityAllService;
	private CrEquityAll crEquityAll;
	private String[] crEquityAllIds;
	private String corpid;
	private List<CrEquityAll> crEquityAllList;
	private String ajaxUrl;
	/**
	 * 描述: 查看列表
	 * @auther gaotong
	 * @date 2015-10-26
	 * @return
	 * @throws Exception
	 */
	public String doReadCrEquityAllListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 出质信息
	 * @auther yulirong
	 * @date 2015-10-26
	 * @return
	 * @throws Exception
	 */
	public String doReadPermissionCrEquityAllListJSON() throws Exception {
		Map<String,Object> qryMap  = new HashMap<String, Object>();
		qryMap.put("nbxh", corpid);
		crEquityAllList = crEquityAllService.doGetList(qryMap);
			for(CrEquityAll list:crEquityAllList){//脱敏处理
				if(StringUtils.isNotBlank(list.getZqrxm())&&list.getZqrxm().length()<5){
					list.setZqrzzhm(StringUtil.replacePartString(list.getZqrzzhm(), "*", 6, 14));
				}
			}
		this.addAjaxResults("dataList", crEquityAllList);
		return AJAX;
	}
	
	/**
	 * 描述: 个人详情关联出质信息
	 * @auther gaotong
	 * @date 2015-10-22
	 * @return
	 * @throws Exception
	 */
	public String doReadPermissionEquityAllListJSON() throws Exception{
		PaginationContext context = doGetContextRequestMap();
		context.setPageSize(5);
		context.setNavigationTemplate("ajax.ftl");
		context.setPageParamName("pageNo6");
		Map<String,Object> qryMap  = context.getAllRequestMap();
		qryMap.put("sfzjhm", AESEUtil.decryptContext(qryMap.get("czrzzhm").toString()));
		qryMap.remove("czrzzhm");
		context.getSkipResult();
		crEquityAllList = crEquityAllService.doGetList(qryMap);
		for(CrEquityAll list:crEquityAllList){//脱敏处理
			if(StringUtils.isNotBlank(list.getZqrxm())&&list.getZqrxm().length()<5){
				list.setZqrzzhm(StringUtil.replacePartString(list.getZqrzzhm(), "*", 6, 14));
			}
		}
	    AjaxPagination pagination = new AjaxPagination(crEquityAllList,crEquityAllService.doGetTotal(qryMap),context);
		pagination.setDataUrl(ajaxUrl);
		pagination.setShowId("ajax6");
		this.addAjaxResults("dataList", pagination.getDataList());
		this.addAjaxResults("skipResult", pagination.getSkipResult());
		this.addAjaxResults("paginationHtml", pagination.getPageHtml());
		return AJAX;
	}
	/**
	 * 描述: 进入增加(修改)页面
	 * @auther gaotong
	 * @date 2015-10-26
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditCrEquityAllAction() throws Exception {
		if(crEquityAll!=null && crEquityAll.getId()!=null){
			crEquityAll =  crEquityAllService.doGetById(crEquityAll.getId());
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 增加(修改)信息
	 * @auther gaotong
	 * @date 2015-10-26
	 * @return
	 * @throws Exception
	 */
	public String doAddAndEditCrEquityAllAction() throws Exception {
		if(crEquityAll!=null && crEquityAll.getId()!=null){
		    crEquityAllService.doMod(crEquityAll);
		}
		else{
			crEquityAllService.doSave(crEquityAll);
		}
		this.addAjaxResults("success", "true");
		return AJAX;
	}

	/**
	 * 描述: 批量删除
	 * @auther gaotong
	 * @date 2015-10-26
	 * @return
	 * @throws Exception
	 */
	public String doDelCrEquityAllAction() throws Exception{
		crEquityAllService.doRmBatch(crEquityAllIds);
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	public CrEquityAllService getCrEquityAllService()
	{
		return crEquityAllService;
	}
	public void setCrEquityAllService(CrEquityAllService crEquityAllService)
	{
		this.crEquityAllService = crEquityAllService;
	}

	public CrEquityAll getCrEquityAll()
	{
		return crEquityAll;
	}

	public void setCrEquityAll(CrEquityAll crEquityAll)
	{
		this.crEquityAll = crEquityAll;
	}

	public String[] getCrEquityAllIds()
	{
		return crEquityAllIds;
	}

	public void setCrEquityAllIds(String[] crEquityAllIds)
	{
		this.crEquityAllIds = crEquityAllIds;
	}

	public String getCorpid() {
		return corpid;
	}

	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}

	public List<CrEquityAll> getCrEquityAllList() {
		return crEquityAllList;
	}

	public void setCrEquityAllList(List<CrEquityAll> crEquityAllList) {
		this.crEquityAllList = crEquityAllList;
	}

	public String getAjaxUrl() {
		return ajaxUrl;
	}

	public void setAjaxUrl(String ajaxUrl) {
		this.ajaxUrl = ajaxUrl;
	}

	
}
