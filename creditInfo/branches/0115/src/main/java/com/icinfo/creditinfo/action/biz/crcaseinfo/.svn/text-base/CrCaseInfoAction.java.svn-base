/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-27
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crcaseinfo;

import com.icinfo.creditinfo.bean.biz.crcaseinfo.CrCaseInfo;
import com.icinfo.creditinfo.service.biz.crcaseinfo.CrCaseInfoService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.pagination.Pagination;

/** 
 * 描述: 法院案件判决和执行信息 Action 类<br>
 * @author yulirong
 * @date 2015-10-27
 */
public class CrCaseInfoAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrCaseInfoService crCaseInfoService;
	private CrCaseInfo crCaseInfo;
	private String[] crCaseInfoIds;
	private String corpid;

	/**
	 * 描述: 查看列表
	 * @auther yulirong
	 * @date 2015-10-27
	 * @return
	 * @throws Exception
	 */
	public String doReadCrCaseInfoListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 分页查询信息
	 * @auther yulirong
	 * @date 2015-10-27
	 * @return
	 * @throws Exception
	 */
	public String doReadCrCaseInfoListJSONAction() throws Exception {
		this.addAjaxResults("pagination", new Pagination(crCaseInfoService.doGetList(doGetRequestMap()), 
				crCaseInfoService.doGetTotal(doGetRequestMap()),pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}
	
	public CrCaseInfoService getCrCaseInfoService()
	{
		return crCaseInfoService;
	}
	public void setCrCaseInfoService(CrCaseInfoService crCaseInfoService)
	{
		this.crCaseInfoService = crCaseInfoService;
	}

	public CrCaseInfo getCrCaseInfo()
	{
		return crCaseInfo;
	}

	public void setCrCaseInfo(CrCaseInfo crCaseInfo)
	{
		this.crCaseInfo = crCaseInfo;
	}

	public String[] getCrCaseInfoIds()
	{
		return crCaseInfoIds;
	}

	public void setCrCaseInfoIds(String[] crCaseInfoIds)
	{
		this.crCaseInfoIds = crCaseInfoIds;
	}

	public String getCorpid() {
		return corpid;
	}

	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}

	
}
