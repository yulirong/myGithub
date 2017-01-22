/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-26
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crmortgagesewagedischargeright;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crmortgagesewagedischargeright.CrMortgageSewageDischargeRight;
import com.icinfo.creditinfo.service.biz.crmortgagesewagedischargeright.CrMortgageSewageDischargeRightService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.pagination.context.PaginationContext;

/** 
 * 描述: 排污权抵押 Action 类<br>
 * @author yulirong
 * @date 2015-10-26
 */
public class CrMortgageSewageDischargeRightAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrMortgageSewageDischargeRightService crMortgageSewageDischargeRightService;
	private CrMortgageSewageDischargeRight crMortgageSewageDischargeRight;
	private String[] crMortgageSewageDischargeRightIds;
	private String corpid;
	private List<CrMortgageSewageDischargeRight> crMortgageSewageDischargeRightlist;

	/**
	 * 描述: 查看列表
	 * @auther yulirong
	 * @date 2015-10-26
	 * @return
	 * @throws Exception
	 */
	public String doReadCrMortgageSewageDischargeRightListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 排污权抵押
	 * @auther yulirong
	 * @date 2015-10-26
	 * @return
	 * @throws Exception
	 */
	public String  doReadPermissionCrMortgageSewageDischargeRightListJSON() throws Exception {
		Map<String,Object> qryMap  = new HashMap<String, Object>();
		qryMap.put("corpid", corpid);
		crMortgageSewageDischargeRightlist = crMortgageSewageDischargeRightService.doGetList(qryMap);
		this.addAjaxResults("dataList", crMortgageSewageDischargeRightlist);
		return AJAX;
	}
	
	
	public CrMortgageSewageDischargeRightService getCrMortgageSewageDischargeRightService()
	{
		return crMortgageSewageDischargeRightService;
	}
	public void setCrMortgageSewageDischargeRightService(CrMortgageSewageDischargeRightService crMortgageSewageDischargeRightService)
	{
		this.crMortgageSewageDischargeRightService = crMortgageSewageDischargeRightService;
	}

	public CrMortgageSewageDischargeRight getCrMortgageSewageDischargeRight()
	{
		return crMortgageSewageDischargeRight;
	}

	public void setCrMortgageSewageDischargeRight(CrMortgageSewageDischargeRight crMortgageSewageDischargeRight)
	{
		this.crMortgageSewageDischargeRight = crMortgageSewageDischargeRight;
	}

	public String[] getCrMortgageSewageDischargeRightIds()
	{
		return crMortgageSewageDischargeRightIds;
	}

	public void setCrMortgageSewageDischargeRightIds(String[] crMortgageSewageDischargeRightIds)
	{
		this.crMortgageSewageDischargeRightIds = crMortgageSewageDischargeRightIds;
	}

	public List<CrMortgageSewageDischargeRight> getCrMortgageSewageDischargeRightlist() {
		return crMortgageSewageDischargeRightlist;
	}

	public void setCrMortgageSewageDischargeRightlist(
			List<CrMortgageSewageDischargeRight> crMortgageSewageDischargeRightlist) {
		this.crMortgageSewageDischargeRightlist = crMortgageSewageDischargeRightlist;
	}

	public String getCorpid() {
		return corpid;
	}

	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}

	
}
