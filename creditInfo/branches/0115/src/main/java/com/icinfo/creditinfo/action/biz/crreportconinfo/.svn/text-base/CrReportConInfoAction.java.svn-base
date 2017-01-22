/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-21
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crreportconinfo;

import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icinfo.creditinfo.bean.biz.crreportconinfo.CrReportConInfo;
import com.icinfo.creditinfo.pagination.AjaxPagination;
import com.icinfo.creditinfo.service.biz.crentbaseinfo.CrEntBaseInfoService;
import com.icinfo.creditinfo.service.biz.crreportconinfo.CrReportConInfoService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.pagination.context.PaginationContext;

/** 
 * 描述: 资本信息 Action 类<br>
 * @author yulirong
 * @date 2015-10-21
 */
public class CrReportConInfoAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrReportConInfoService crReportConInfoService;
	private CrReportConInfo crReportConInfo;
	private String[] crReportConInfoIds;
	private String ajaxUrl;
	private List<CrReportConInfo> crReportConInfoList;
	private String corpid;
	private CrEntBaseInfoService crEntBaseInfoService;
	private String nocorpid;

	/**
	 * 描述: 查看列表
	 * @auther yulirong
	 * @date 2015-10-21
	 * @return
	 * @throws Exception
	 */
	public String doReadCrReportConInfoListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 企业资本信息获取
	 * @auther yulirong
	 * @date 2015-10-21
	 * @return
	 * @throws Exception
	 */
	public String doReadPermissionCrReportConInfoListJSON() throws Exception {
				PaginationContext context = doGetContextRequestMap();
				context.setPageSize(5);
				context.setNavigationTemplate("ajax.ftl");
				context.setPageParamName("pageNo1");
				Map<String,Object> qryMap  = context.getAllRequestMap();
				context.getSkipResult();
				crReportConInfoList = crReportConInfoService.doGetList(qryMap);
				for(CrReportConInfo list:crReportConInfoList){
					if(StringUtils.isBlank(list.getConInfoPercent())){
						list.setConInfoPercent("");
					}
					if(StringUtils.isNotBlank(list.getConInfoPercent())){
						list.setConInfoPercent(list.getConInfoPercent()+"%");
					}
				}
			    AjaxPagination pagination = new AjaxPagination(crReportConInfoList,crReportConInfoService.doGetTotal(qryMap),context);
				pagination.setDataUrl(ajaxUrl);
				pagination.setShowId("ajax1");
				this.addAjaxResults("dataList", pagination.getDataList());
				this.addAjaxResults("skipResult", pagination.getSkipResult());
				this.addAjaxResults("paginationHtml", pagination.getPageHtml());
				this.addAjaxResults("crEntBaseInfo", crEntBaseInfoService.doGetById(corpid));
				return AJAX;
	}
	
	/**
	 * 描述: 进入增加(修改)页面
	 * @auther yulirong
	 * @date 2015-10-21
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditCrReportConInfoAction() throws Exception {
		if(crReportConInfo!=null && crReportConInfo.getId()!=null){
			crReportConInfo =  crReportConInfoService.doGetById(crReportConInfo.getId());
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 增加(修改)信息
	 * @auther yulirong
	 * @date 2015-10-21
	 * @return
	 * @throws Exception
	 */
	public String doAddAndEditCrReportConInfoAction() throws Exception {
		if(crReportConInfo!=null && crReportConInfo.getId()!=null){
		    crReportConInfoService.doMod(crReportConInfo);
		}
		else{
			crReportConInfoService.doSave(crReportConInfo);
		}
		this.addAjaxResults("success", "true");
		return AJAX;
	}

	/**
	 * 描述: 批量删除
	 * @auther yulirong
	 * @date 2015-10-21
	 * @return
	 * @throws Exception
	 */
	public String doDelCrReportConInfoAction() throws Exception{
		crReportConInfoService.doRmBatch(crReportConInfoIds);
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	public CrReportConInfoService getCrReportConInfoService()
	{
		return crReportConInfoService;
	}
	public void setCrReportConInfoService(CrReportConInfoService crReportConInfoService)
	{
		this.crReportConInfoService = crReportConInfoService;
	}

	public CrReportConInfo getCrReportConInfo()
	{
		return crReportConInfo;
	}

	public void setCrReportConInfo(CrReportConInfo crReportConInfo)
	{
		this.crReportConInfo = crReportConInfo;
	}

	public String[] getCrReportConInfoIds()
	{
		return crReportConInfoIds;
	}

	public void setCrReportConInfoIds(String[] crReportConInfoIds)
	{
		this.crReportConInfoIds = crReportConInfoIds;
	}

	public String getAjaxUrl() {
		return ajaxUrl;
	}

	public void setAjaxUrl(String ajaxUrl) {
		this.ajaxUrl = ajaxUrl;
	}

	public List<CrReportConInfo> getCrReportConInfoList() {
		return crReportConInfoList;
	}

	public void setCrReportConInfoList(List<CrReportConInfo> crReportConInfoList) {
		this.crReportConInfoList = crReportConInfoList;
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

	public String getNocorpid() {
		return nocorpid;
	}

	public void setNocorpid(String nocorpid) {
		this.nocorpid = nocorpid;
	}

}
