/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author mayawei
 * @date 2015-10-26
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crleprep;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crleprep.CrLepRep;
import com.icinfo.creditinfo.service.biz.crleprep.CrLepRepService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.pagination.Pagination;
import com.icinfo.plugin.pagination.WebPagination;
import com.icinfo.plugin.pagination.context.PaginationContext;

/** 
 * 描述: 企业法人代表 Action 类<br>
 * @author mayawei
 * @date 2015-10-26
 */
public class CrLepRepAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrLepRepService crLepRepService;
	private CrLepRep crLepRep;
	private String[] crLepRepIds;
	//搜索参数
	private String searchParam;
	private List<CrLepRep> crLepRepList;

	/**
	 * 描述: 查看列表
	 * @auther mayawei
	 * @date 2015-10-26
	 * @return
	 * @throws Exception
	 */
	public String doReadCrLepRepListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 分页查询信息
	 * @auther mayawei
	 * @date 2015-10-26
	 * @return
	 * @throws Exception
	 */
	public String doReadCrLepRepListJSONAction() throws Exception {
		this.addAjaxResults("pagination", new Pagination(crLepRepService.doGetList(doGetRequestMap()), 
				crLepRepService.doGetTotal(doGetRequestMap()),pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}
	
	/**
	 * 描述: 进入增加(修改)页面
	 * @auther mayawei
	 * @date 2015-10-26
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditCrLepRepAction() throws Exception {
		if(crLepRep!=null && crLepRep.getId()!=null){
			crLepRep =  crLepRepService.doGetById(crLepRep.getId());
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 增加(修改)信息
	 * @auther mayawei
	 * @date 2015-10-26
	 * @return
	 * @throws Exception
	 */
	public String doAddAndEditCrLepRepAction() throws Exception {
		if(crLepRep!=null && crLepRep.getId()!=null){
		    crLepRepService.doMod(crLepRep);
		}
		else{
			crLepRepService.doSave(crLepRep);
		}
		this.addAjaxResults("success", "true");
		return AJAX;
	}

	/**
	 * 描述: 批量删除
	 * @auther mayawei
	 * @date 2015-10-26
	 * @return
	 * @throws Exception
	 */
	public String doDelCrLepRepAction() throws Exception{
		crLepRepService.doRmBatch(crLepRepIds);
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	/**
	 * 描述：跳转法人查询页面
	 * @author 马亚伟
	 * @date 2015-10-26
	 * @return
	 * @throws Exception
	 */
	public String doEnCrLepRepSearchAction() throws Exception{
		return Action.SUCCESS;
	}
	
	/**
	 * 描述：法人查询
	 * @author 马亚伟
	 * @date 2015-10-26
	 * @return
	 * @throws Exception
	 */
	public String doGetCrLepRepSearchListAction() throws Exception {
		
		PaginationContext context = doGetContextRequestMap();
		Map<String,Object> qryMap = doGetPojoMap(crLepRepService, context.getAllRequestMap());
		WebPagination webPagination=new WebPagination(crLepRepService.doGetCrLepRepSearchList(qryMap), crLepRepService.doGetCrLepRepSearchTotal(qryMap), context);
		crLepRepList=(List<CrLepRep>) webPagination.getDataList();
		if(crLepRepList!=null){//添加任法人代表企业数
			for (int i=0;i<crLepRepList.size();i++) {
				Map<String,Object> qryLepRepMap = new HashMap<String, Object>();
				CrLepRep crLepRep = crLepRepList.get(i);
				if(crLepRep!=null){
					qryLepRepMap.put("lepCertNo", crLepRep.getLepCertNo());
					Integer lepRepCount = crLepRepService.doGetTotal(qryLepRepMap);
					crLepRep.setLepRepCount(lepRepCount);
				}
			}
		}
		this.addJstlResults("dataList", crLepRepList);
		this.addJstlResults("paginationHtml", webPagination.getPageHtml());
		this.addJstlResults("currentPage", webPagination.getCurrentPage());
		this.addJstlResults("pageSize", webPagination.getPageSize());
		return Action.SUCCESS;
	}
	
	
	
	public CrLepRepService getCrLepRepService()
	{
		return crLepRepService;
	}
	public void setCrLepRepService(CrLepRepService crLepRepService)
	{
		this.crLepRepService = crLepRepService;
	}

	public CrLepRep getCrLepRep()
	{
		return crLepRep;
	}

	public void setCrLepRep(CrLepRep crLepRep)
	{
		this.crLepRep = crLepRep;
	}

	public String[] getCrLepRepIds()
	{
		return crLepRepIds;
	}

	public void setCrLepRepIds(String[] crLepRepIds)
	{
		this.crLepRepIds = crLepRepIds;
	}

	public String getSearchParam() {
		return searchParam;
	}

	public void setSearchParam(String searchParam) {
		this.searchParam = searchParam;
	}

	public List<CrLepRep> getCrLepRepList() {
		return crLepRepList;
	}

	public void setCrLepRepList(List<CrLepRep> crLepRepList) {
		this.crLepRepList = crLepRepList;
	}


}
