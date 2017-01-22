/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-10-23
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.mortgagereg;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icinfo.creditinfo.bean.biz.mortgagereg.MortgageReg;
import com.icinfo.creditinfo.pagination.AjaxPagination;
import com.icinfo.creditinfo.service.biz.mortgagereg.MortgageRegService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.common.AESEUtil;
import com.icinfo.plugin.common.StringUtil;
import com.icinfo.plugin.pagination.Pagination;
import com.icinfo.plugin.pagination.context.PaginationContext;

/** 
 * 描述: 抵押信息 Action 类<br>
 * @author gaotong
 * @date 2015-10-23
 */
public class MortgageRegAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private MortgageRegService mortgageRegService;
	private MortgageReg mortgageReg;
	private String[] mortgageRegIds;
	private String ajaxUrl;
	private String corpid;
	private List<MortgageReg> mortgageRegList;

	private List<MortgageReg> mortgageRegHouseList;
	private List<MortgageReg> mortgageRegLandList;
	/**
	 * 描述: 查看列表
	 * @auther gaotong
	 * @date 2015-10-23
	 * @return
	 * @throws Exception
	 */
	public String doReadMortgageRegListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 分页查询信息
	 * @auther gaotong
	 * @date 2015-10-23
	 * @return
	 * @throws Exception
	 */
	public String doReadMortgageRegListJSONAction() throws Exception {
		this.addAjaxResults("pagination", new Pagination(mortgageRegService.doGetList(doGetRequestMap()), 
				mortgageRegService.doGetTotal(doGetRequestMap()),pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}
	
	/**
	 * 描述: 房产抵押信息
	 * @auther yulirong
	 * @date 2015-10-23
	 * @return
	 * @throws Exception
	 */
	public String doReadPermissionHomeMortgageListJSONAction() throws Exception {
		PaginationContext context = doGetContextRequestMap();
		context.setPageSize(5);
		context.setNavigationTemplate("ajax.ftl");
		context.setPageParamName("pageNo6");
		Map<String,Object> qryMap  = context.getAllRequestMap();
		List<String> importFromList = new ArrayList<String>();
		importFromList.add("公证处");importFromList.add("上虞市场监管局");
		qryMap.put("importFrom",importFromList);
		context.getSkipResult();
		mortgageRegList = mortgageRegService.doGetList(qryMap);
			for(MortgageReg list:mortgageRegList){//脱敏处理
				if(StringUtils.isNotBlank(list.getMortgageeName())&&list.getMortgageeName().length()<5){
					list.setMortgageeCertNo(StringUtil.replacePartString(list.getMortgageeCertNo(), "*", 6, 14));
				}
			}
	    AjaxPagination pagination = new AjaxPagination(mortgageRegList,mortgageRegService.doGetTotal(qryMap),context);
		pagination.setDataUrl(ajaxUrl);
		pagination.setShowId("ajax6");
		this.addAjaxResults("dataList", pagination.getDataList());
		this.addAjaxResults("skipResult", pagination.getSkipResult());
		this.addAjaxResults("paginationHtml", pagination.getPageHtml());
		return AJAX;
	}
	
	/**
	 * 描述: 土地抵押信息
	 * @auther yulirong
	 * @date 2015-10-26
	 * @return
	 * @throws Exception
	 */
	public String doReadPermissionLandMortgageListJSON() throws Exception {
		Map<String,Object> qryMap  = new HashMap<String, Object>();
		qryMap.put("corpid", corpid);
		qryMap.put("importFrom", "国土资源局");
		mortgageRegList = mortgageRegService.doGetList(qryMap);
		this.addAjaxResults("dataList", mortgageRegList);
		return AJAX;
	}
	
	/**
	 * 描述: 个人详情关联房产抵押信息
	 * @auther gaotong
	 * @date 2015-10-22
	 * @return
	 * @throws Exception
	 */
	public String doReadPermissionMortgageRegHouseListJSON() throws Exception{
		PaginationContext context = doGetContextRequestMap();
		context.setPageSize(5);
		context.setNavigationTemplate("ajax.ftl");
		context.setPageParamName("pageNo3");
		Map<String,Object> qryMap  = context.getAllRequestMap();
		qryMap.put("sfzjhm", AESEUtil.decryptContext(qryMap.get("mortgagorCertNo").toString()));
		qryMap.remove("mortgagorCertNo");
		context.getSkipResult();
		qryMap.put("importFrom", "公证处");
		mortgageRegHouseList = mortgageRegService.doGetList(qryMap);
		for(MortgageReg list:mortgageRegHouseList){//脱敏处理
			if(StringUtils.isNotBlank(list.getMortgageeName())&&list.getMortgageeName().length()<5){
				list.setMortgageeCertNo(StringUtil.replacePartString(list.getMortgageeCertNo(), "*", 6, 14));
			}
		}
	    AjaxPagination pagination = new AjaxPagination(mortgageRegHouseList,mortgageRegService.doGetTotal(qryMap),context);
		pagination.setDataUrl(ajaxUrl);
		pagination.setShowId("ajax3");
		this.addAjaxResults("dataList", pagination.getDataList());
		this.addAjaxResults("skipResult", pagination.getSkipResult());
		this.addAjaxResults("paginationHtml", pagination.getPageHtml());
		return AJAX;
	}
	/**
	 * 描述: 个人详情关联土地抵押信息
	 * @auther gaotong
	 * @date 2015-10-22
	 * @return
	 * @throws Exception
	 */
	public String doReadPermissionMortgageRegLandListJSON() throws Exception{
		PaginationContext context = doGetContextRequestMap();
		context.setPageSize(5);
		context.setNavigationTemplate("ajax.ftl");
		context.setPageParamName("pageNo5");
		Map<String,Object> qryMap  = context.getAllRequestMap();
		qryMap.put("sfzjhm", AESEUtil.decryptContext(qryMap.get("mortgagorCertNo").toString()));
		qryMap.remove("mortgagorCertNo");
		context.getSkipResult();
		qryMap.put("importFrom", "国土资源局");
		mortgageRegLandList = mortgageRegService.doGetList(qryMap);
	    AjaxPagination pagination = new AjaxPagination(mortgageRegLandList,mortgageRegService.doGetTotal(qryMap),context);
		pagination.setDataUrl(ajaxUrl);
		pagination.setShowId("ajax5");
		this.addAjaxResults("dataList", pagination.getDataList());
		this.addAjaxResults("skipResult", pagination.getSkipResult());
		this.addAjaxResults("paginationHtml", pagination.getPageHtml());
		return AJAX;
	}
	
	public MortgageRegService getMortgageRegService()
	{
		return mortgageRegService;
	}
	public void setMortgageRegService(MortgageRegService mortgageRegService)
	{
		this.mortgageRegService = mortgageRegService;
	}

	public MortgageReg getMortgageReg()
	{
		return mortgageReg;
	}

	public void setMortgageReg(MortgageReg mortgageReg)
	{
		this.mortgageReg = mortgageReg;
	}

	public String[] getMortgageRegIds()
	{
		return mortgageRegIds;
	}

	public void setMortgageRegIds(String[] mortgageRegIds)
	{
		this.mortgageRegIds = mortgageRegIds;
	}

	public String getAjaxUrl() {
		return ajaxUrl;
	}

	public void setAjaxUrl(String ajaxUrl) {
		this.ajaxUrl = ajaxUrl;
	}

	public String getCorpid() {
		return corpid;
	}

	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}

	public List<MortgageReg> getMortgageRegList() {
		return mortgageRegList;
	}

	public void setMortgageRegList(List<MortgageReg> mortgageRegList) {
		this.mortgageRegList = mortgageRegList;
	}

	
}
