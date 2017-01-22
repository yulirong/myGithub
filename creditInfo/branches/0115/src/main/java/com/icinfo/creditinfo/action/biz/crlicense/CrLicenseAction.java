/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-22
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crlicense;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.icinfo.creditinfo.bean.biz.crlicense.CrLicense;
import com.icinfo.creditinfo.pagination.AjaxPagination;
import com.icinfo.creditinfo.service.biz.crlicense.CrLicenseService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.common.AESEUtil;
import com.icinfo.plugin.pagination.WebPagination;
import com.icinfo.plugin.pagination.context.PaginationContext;

/** 
 * 描述: 许可信息 Action 类<br>
 * @author yulirong
 * @date 2015-10-22
 */
public class CrLicenseAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrLicenseService crLicenseService;
	private CrLicense crLicense;
	private String[] crLicenseIds;
	private String ajaxUrl;
	private List<CrLicense> crLicenseList;
	private List<String> stateList;
	
	public String doEnReadCrLicenseListAction() throws Exception{
		stateList=crLicenseService.doGetStateList();
		return Action.SUCCESS;
	}

	/**
	 * 描述: 查看列表
	 * @auther liyafeng
	 * @date 2015-10-22
	 * @return
	 * @throws Exception
	 */
	public String doReadCrLicenseListAction() throws Exception 
	{    
		PaginationContext context = doGetContextRequestMap();
		Map<String,Object> qryMap = doGetPojoMap(crLicense, context.getAllRequestMap());
		List<CrLicense> dataList = crLicenseService.doGetList(qryMap);
		List<CrLicense> newDataList = new ArrayList<CrLicense>();
		for (CrLicense crLicense : dataList) {
			if(StringUtils.isNotBlank(crLicense.getCorpid())){
				crLicense.setCorpid(AESEUtil.encryptContext(crLicense.getCorpid()));
			}
			newDataList.add(crLicense);
		}
		WebPagination webPagination=new WebPagination(newDataList, crLicenseService.doGetTotal(qryMap), context);
	    this.addJstlResults("dataList", webPagination.getDataList());
		this.addJstlResults("paginationHtml", webPagination.getPageHtml());
		this.addJstlResults("currentPage", webPagination.getCurrentPage());
		this.addJstlResults("pageSize", webPagination.getPageSize());
		this.addJstlResults("skipResult", webPagination.getSkipResult());
		stateList=crLicenseService.doGetStateList();
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 许可信息获取
	 * @auther yulirong
	 * @date 2015-10-22
	 * @return
	 * @throws Exception
	 */
	public String doReadPermissionCrLicenseListJSON() throws Exception {
		PaginationContext context = doGetContextRequestMap();
		context.setPageSize(5);
		context.setNavigationTemplate("ajax.ftl");
		context.setPageParamName("pageNo2");
		Map<String,Object> qryMap  = context.getAllRequestMap();
		context.getSkipResult();
		crLicenseList = crLicenseService.doGetList(qryMap);
	    AjaxPagination pagination = new AjaxPagination(crLicenseList,crLicenseService.doGetTotal(qryMap),context);
		pagination.setDataUrl(ajaxUrl);
		pagination.setShowId("ajax2");
		this.addAjaxResults("dataList", pagination.getDataList());
		this.addAjaxResults("skipResult", pagination.getSkipResult());
		this.addAjaxResults("paginationHtml", pagination.getPageHtml());
		return AJAX;
	}
	
	/**
	 * 描述: 进入增加(修改)页面
	 * @auther yulirong
	 * @date 2015-10-22
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditCrLicenseAction() throws Exception {
		if(crLicense!=null && crLicense.getId()!=null){
			crLicense =  crLicenseService.doGetById(crLicense.getId());
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 增加(修改)信息
	 * @auther yulirong
	 * @date 2015-10-22
	 * @return
	 * @throws Exception
	 */
	public String doAddAndEditCrLicenseAction() throws Exception {
		if(crLicense!=null && crLicense.getId()!=null){
		    crLicenseService.doMod(crLicense);
		}
		else{
			crLicenseService.doSave(crLicense);
		}
		this.addAjaxResults("success", "true");
		return AJAX;
	}

	/**
	 * 描述: 批量删除
	 * @auther yulirong
	 * @date 2015-10-22
	 * @return
	 * @throws Exception
	 */
	public String doDelCrLicenseAction() throws Exception{
		crLicenseService.doRmBatch(crLicenseIds);
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	public CrLicenseService getCrLicenseService()
	{
		return crLicenseService;
	}
	public void setCrLicenseService(CrLicenseService crLicenseService)
	{
		this.crLicenseService = crLicenseService;
	}

	public CrLicense getCrLicense()
	{
		return crLicense;
	}

	public void setCrLicense(CrLicense crLicense)
	{
		this.crLicense = crLicense;
	}

	public String[] getCrLicenseIds()
	{
		return crLicenseIds;
	}

	public void setCrLicenseIds(String[] crLicenseIds)
	{
		this.crLicenseIds = crLicenseIds;
	}

	public String getAjaxUrl() {
		return ajaxUrl;
	}

	public void setAjaxUrl(String ajaxUrl) {
		this.ajaxUrl = ajaxUrl;
	}

	public List<CrLicense> getCrLicenseList() {
		return crLicenseList;
	}

	public void setCrLicenseList(List<CrLicense> crLicenseList) {
		this.crLicenseList = crLicenseList;
	}

	public List<String> getStateList() {
		return stateList;
	}

	public void setStateList(List<String> stateList) {
		this.stateList = stateList;
	}
    
	
}
