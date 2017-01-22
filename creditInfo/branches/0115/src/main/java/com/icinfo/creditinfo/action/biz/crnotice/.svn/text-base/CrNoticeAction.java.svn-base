/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crnotice;
import java.util.Date;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icinfo.creditinfo.bean.biz.crnotice.CrNotice;
import com.icinfo.creditinfo.service.biz.crnotice.CrNoticeService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.pagination.Pagination;
import com.icinfo.plugin.pagination.WebPagination;
import com.icinfo.plugin.pagination.context.PaginationContext;

/** 
 * 描述: 发布公告 Action 类<br>
 * @author yulirong
 * @date 2015-11-12
 */
public class CrNoticeAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrNoticeService crNoticeService;
	private CrNotice crNotice;
	private String[] crNoticeIds;
	private String att;
	private String ajaxUrl;
	private String ids;

	/**
	 * 描述: 查看列表
	 * @auther yulirong
	 * @date 2015-11-12
	 * @return
	 * @throws Exception
	 */
	public String doReadCrNoticeListAction() throws Exception 
	{
		Map<String, Object> qryMap = doGetRequestMap();
		qryMap.put("ticStatus", 1);
		if(qryMap.get("startTicTime")!=null){qryMap.put("startTicTime", qryMap.get("startTicTime")+" 00:00:00");}
		if(qryMap.get("endTicTime")!=null){qryMap.put("endTicTime", qryMap.get("endTicTime")+" 23:59:59");}
		this.addAjaxResults("pagination", new Pagination(crNoticeService.doGetList(qryMap),crNoticeService.doGetTotal(qryMap),pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}
	
	/**
	 * 描述: 读取更多公告信息
	 * @auther yulirong
	 * @date 2015-11-14
	 * @return
	 * @throws Exception
	 */
	public String doEnCrNoticeListAction() throws Exception 
	{
		PaginationContext context = doGetContextRequestMap();
		Map<String,Object> qryMap = doGetPojoMap(crNotice, context.getAllRequestMap());		
		qryMap.put("ticStatus", 1);
		if(qryMap.get("startTicTime")!=null){qryMap.put("startTicTime", qryMap.get("startTicTime")+" 00:00:00");}
		if(qryMap.get("endTicTime")!=null){qryMap.put("endTicTime", qryMap.get("endTicTime")+" 23:59:59");}
		WebPagination webPagination=new WebPagination(crNoticeService.doGetList(qryMap), crNoticeService.doGetTotal(qryMap), context);
	    this.addJstlResults("dataList", webPagination.getDataList());
		this.addJstlResults("paginationHtml", webPagination.getPageHtml());
		this.addJstlResults("currentPage", webPagination.getCurrentPage());
		this.addJstlResults("pageSize", webPagination.getPageSize());
		this.addJstlResults("skipResult", webPagination.getSkipResult());
		return SUCCESS;
	}
	
	/**
	 * 描述: 进入增加(修改)页面
	 * @auther yulirong
	 * @date 2015-11-12
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditCrNoticeAction() throws Exception {
		if(att.equals("mod")){
			crNotice =  crNoticeService.doGetById(crNotice.getId());
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 增加(修改)信息
	 * @auther yulirong
	 * @date 2015-11-12
	 * @return
	 * @throws Exception
	 */
	public String doAddAndEditCrNoticeAction() throws Exception {
		if(att.equals("mod")){
		    crNoticeService.doMod(crNotice);
		}
		else{
			crNotice.setTicDate(new Date());
			crNotice.setTicStatus("1");
			crNoticeService.doSave(crNotice);
		}
		this.addAjaxResults("success", "true");
		return AJAX;
	}

	/**
	 * 描述: 批量删除
	 * @auther yulirong
	 * @date 2015-11-12
	 * @return
	 * @throws Exception
	 */
	public String doDelCrNoticeAction() throws Exception{
		crNoticeIds = ids.split(",");
		crNoticeService.doRmBatch(crNoticeIds);
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	public CrNoticeService getCrNoticeService()
	{
		return crNoticeService;
	}
	public void setCrNoticeService(CrNoticeService crNoticeService)
	{
		this.crNoticeService = crNoticeService;
	}

	public CrNotice getCrNotice()
	{
		return crNotice;
	}

	public void setCrNotice(CrNotice crNotice)
	{
		this.crNotice = crNotice;
	}

	public String[] getCrNoticeIds()
	{
		return crNoticeIds;
	}

	public void setCrNoticeIds(String[] crNoticeIds)
	{
		this.crNoticeIds = crNoticeIds;
	}

	public String getAtt() {
		return att;
	}

	public void setAtt(String att) {
		this.att = att;
	}

	public String getAjaxUrl() {
		return ajaxUrl;
	}

	public void setAjaxUrl(String ajaxUrl) {
		this.ajaxUrl = ajaxUrl;
	}

	public String getIds() {
		return ids;
	}

	public void setIds(String ids) {
		this.ids = ids;
	}

	
}
