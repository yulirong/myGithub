/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-12
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crhistoryrecords;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icinfo.creditinfo.bean.biz.crhistoryrecords.CrHistoryRecords;
import com.icinfo.creditinfo.service.biz.crhistoryrecords.CrHistoryRecordsService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.pagination.Pagination;
import com.icinfo.plugin.pagination.WebPagination;
import com.icinfo.plugin.pagination.context.PaginationContext;

/** 
 * 描述: 浏览记录 Action 类<br>
 * @author yulirong
 * @date 2015-10-12
 */
public class CrHistoryRecordsAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrHistoryRecordsService crHistoryRecordsService;
	private CrHistoryRecords crHistoryRecords;
	private String[] crHistoryRecordsIds;

	/**
	 * 描述: 查看列表
	 * @auther yulirong
	 * @date 2015-10-12
	 * @return
	 * @throws Exception
	 */
	public String doReadCrHistoryRecordsListAction() throws Exception 
	{
		PaginationContext context = doGetContextRequestMap();
		Map<String,Object> qryMap = doGetPojoMap(crHistoryRecords, context.getAllRequestMap());
		qryMap.put("hisUserId",doGetSysUser().getId());
		WebPagination webPagination = new WebPagination(crHistoryRecordsService.doGetList(qryMap),crHistoryRecordsService.doGetTotal(qryMap),context);
		this.addJstlResults("dataList", webPagination.getDataList());
		this.addJstlResults("paginationHtml", webPagination.getPageHtml());
		this.addJstlResults("currentPage", webPagination.getCurrentPage());
		this.addJstlResults("pageSize", webPagination.getPageSize());
		this.addJstlResults("hisEntName",qryMap.get("hisEntName"));
		return SUCCESS;
	}
	
	/**
	 * 描述: 分页查询信息
	 * @auther yulirong
	 * @date 2015-10-12
	 * @return
	 * @throws Exception
	 */
	public String doReadCrHistoryRecordsListJSONAction() throws Exception {
		this.addAjaxResults("pagination", new Pagination(crHistoryRecordsService.doGetList(doGetRequestMap()), 
				crHistoryRecordsService.doGetTotal(doGetRequestMap()),pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}
	
	/**
	 * 描述: 进入增加(修改)页面
	 * @auther yulirong
	 * @date 2015-10-12
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditCrHistoryRecordsAction() throws Exception {
		if(crHistoryRecords!=null && crHistoryRecords.getId()!=null){
			crHistoryRecords =  crHistoryRecordsService.doGetById(crHistoryRecords.getId());
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 增加(修改)信息
	 * @auther yulirong
	 * @date 2015-10-12
	 * @return
	 * @throws Exception
	 */
	public String doAddAndEditCrHistoryRecordsAction() throws Exception {
		if(crHistoryRecords!=null && crHistoryRecords.getId()!=null){
		    crHistoryRecordsService.doMod(crHistoryRecords);
		}
		else{
			crHistoryRecordsService.doSave(crHistoryRecords);
		}
		this.addAjaxResults("success", "true");
		return AJAX;
	}

	/**
	 * 描述: 批量删除
	 * @auther yulirong
	 * @date 2015-10-12
	 * @return
	 * @throws Exception
	 */
	public String doDelCrHistoryRecordsAction() throws Exception{
		crHistoryRecordsService.doRmBatch(crHistoryRecordsIds);
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	/**
	 * 描述: 清除所有浏览记录
	 * @auther yulirong
	 * @date 2015-10-13
	 * @return
	 * @throws Exception
	 */
	public String doDelAllCrHistoryRecordsAction() throws Exception{
		this.addAjaxResults("success", "false");
		if(StringUtils.isBlank(doGetSysUser().getId())){
			return AJAX;
		}
		Map<String,Object> qryMap = new HashMap<String, Object>();
		qryMap.put("hisUserId", doGetSysUser().getId());
		crHistoryRecordsService.doDelAllCrHistoryRecords(qryMap);
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	
	public CrHistoryRecordsService getCrHistoryRecordsService()
	{
		return crHistoryRecordsService;
	}
	public void setCrHistoryRecordsService(CrHistoryRecordsService crHistoryRecordsService)
	{
		this.crHistoryRecordsService = crHistoryRecordsService;
	}

	public CrHistoryRecords getCrHistoryRecords()
	{
		return crHistoryRecords;
	}

	public void setCrHistoryRecords(CrHistoryRecords crHistoryRecords)
	{
		this.crHistoryRecords = crHistoryRecords;
	}

	public String[] getCrHistoryRecordsIds()
	{
		return crHistoryRecordsIds;
	}

	public void setCrHistoryRecordsIds(String[] crHistoryRecordsIds)
	{
		this.crHistoryRecordsIds = crHistoryRecordsIds;
	}

	
}
