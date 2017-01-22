/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-10-24
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crdcdyapplyinfo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icinfo.creditinfo.bean.biz.crdcdyapplyinfo.CrDcdyApplyinfo;
import com.icinfo.creditinfo.pagination.AjaxPagination;
import com.icinfo.creditinfo.service.biz.crdcdyapplyinfo.CrDcdyApplyinfoService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.icinfo.plugin.common.AESEUtil;
import com.icinfo.plugin.common.StringUtil;
import com.icinfo.plugin.pagination.context.PaginationContext;
import com.opensymphony.xwork2.Action;

/** 
 * 描述: 动产抵押 Action 类<br>
 * @author gaotong
 * @date 2015-10-24
 */
public class CrDcdyApplyinfoAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrDcdyApplyinfoService crDcdyApplyinfoService;
	private CrDcdyApplyinfo crDcdyApplyinfo;
	private String[] crDcdyApplyinfoIds;
	private String corpid;
	private List<CrDcdyApplyinfo> crDcdyApplyinfoList;
	private String ajaxUrl;
	/**
	 * 描述: 查看列表
	 * @auther gaotong
	 * @date 2015-10-24
	 * @return
	 * @throws Exception
	 */
	public String doReadCrDcdyApplyinfoListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 动产抵押信息
	 * @auther yulirong
	 * @date 2015-10-24
	 * @return
	 * @throws Exception
	 */
	public String doReadPermissionCrDcdyApplyinfoListJSON() throws Exception {
		Map<String,Object> qryMap  = new HashMap<String, Object>();
		qryMap.put("corpid", corpid);
		crDcdyApplyinfoList = crDcdyApplyinfoService.doGetList(qryMap);
			for(CrDcdyApplyinfo list:crDcdyApplyinfoList){//脱敏处理
				if(StringUtils.isNotBlank(list.getMortgageeName())&&list.getMortgageeName().length()<5){
					list.setMortgageeCertNo(StringUtil.replacePartString(list.getMortgageeCertNo(), "*", 6, 14));
				}
			}
		this.addAjaxResults("dataList", crDcdyApplyinfoList);
		return AJAX;
	}
	
	/**
	 * 描述: 个人详情关联动产抵押信息
	 * @auther gaotong
	 * @date 2015-10-22
	 * @return
	 * @throws Exception
	 */
	public String doReadPermissionPeopleCrDcdyApplyinfoListJSON() throws Exception{
		PaginationContext context = doGetContextRequestMap();
		context.setPageSize(5);
		context.setNavigationTemplate("ajax.ftl");
		context.setPageParamName("pageNo4");
		Map<String,Object> qryMap  = context.getAllRequestMap();
		qryMap.put("sfzjhm", AESEUtil.decryptContext(qryMap.get("mortgagorCertNo").toString()));
		qryMap.remove("mortgagorCertNo");
		context.getSkipResult();
		crDcdyApplyinfoList = crDcdyApplyinfoService.doGetList(qryMap);
		for(CrDcdyApplyinfo list:crDcdyApplyinfoList){//脱敏处理
			if(StringUtils.isNotBlank(list.getMortgageeName())&&list.getMortgageeName().length()<5){
				list.setMortgageeCertNo(StringUtil.replacePartString(list.getMortgageeCertNo(), "*", 6, 14));
			}
		}
	    AjaxPagination pagination = new AjaxPagination(crDcdyApplyinfoList,crDcdyApplyinfoService.doGetTotal(qryMap),context);
		pagination.setDataUrl(ajaxUrl);
		pagination.setShowId("ajax4");
		this.addAjaxResults("dataList", pagination.getDataList());
		this.addAjaxResults("skipResult", pagination.getSkipResult());
		this.addAjaxResults("paginationHtml", pagination.getPageHtml());
		return AJAX;
	}
	
	/**
	 * 描述: 进入增加(修改)页面
	 * @auther gaotong
	 * @date 2015-10-24
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditCrDcdyApplyinfoAction() throws Exception {
		if(crDcdyApplyinfo!=null && crDcdyApplyinfo.getId()!=null){
			crDcdyApplyinfo =  crDcdyApplyinfoService.doGetById(crDcdyApplyinfo.getId());
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 增加(修改)信息
	 * @auther gaotong
	 * @date 2015-10-24
	 * @return
	 * @throws Exception
	 */
	public String doAddAndEditCrDcdyApplyinfoAction() throws Exception {
		if(crDcdyApplyinfo!=null && crDcdyApplyinfo.getId()!=null){
		    crDcdyApplyinfoService.doMod(crDcdyApplyinfo);
		}
		else{
			crDcdyApplyinfoService.doSave(crDcdyApplyinfo);
		}
		this.addAjaxResults("success", "true");
		return AJAX;
	}

	/**
	 * 描述: 批量删除
	 * @auther gaotong
	 * @date 2015-10-24
	 * @return
	 * @throws Exception
	 */
	public String doDelCrDcdyApplyinfoAction() throws Exception{
		crDcdyApplyinfoService.doRmBatch(crDcdyApplyinfoIds);
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	public CrDcdyApplyinfoService getCrDcdyApplyinfoService()
	{
		return crDcdyApplyinfoService;
	}
	public void setCrDcdyApplyinfoService(CrDcdyApplyinfoService crDcdyApplyinfoService)
	{
		this.crDcdyApplyinfoService = crDcdyApplyinfoService;
	}

	public CrDcdyApplyinfo getCrDcdyApplyinfo()
	{
		return crDcdyApplyinfo;
	}

	public void setCrDcdyApplyinfo(CrDcdyApplyinfo crDcdyApplyinfo)
	{
		this.crDcdyApplyinfo = crDcdyApplyinfo;
	}

	public String[] getCrDcdyApplyinfoIds()
	{
		return crDcdyApplyinfoIds;
	}

	public void setCrDcdyApplyinfoIds(String[] crDcdyApplyinfoIds)
	{
		this.crDcdyApplyinfoIds = crDcdyApplyinfoIds;
	}

	public String getCorpid() {
		return corpid;
	}

	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}

	public List<CrDcdyApplyinfo> getCrDcdyApplyinfoList() {
		return crDcdyApplyinfoList;
	}

	public void setCrDcdyApplyinfoList(List<CrDcdyApplyinfo> crDcdyApplyinfoList) {
		this.crDcdyApplyinfoList = crDcdyApplyinfoList;
	}

	public String getAjaxUrl() {
		return ajaxUrl;
	}

	public void setAjaxUrl(String ajaxUrl) {
		this.ajaxUrl = ajaxUrl;
	}

	
}
