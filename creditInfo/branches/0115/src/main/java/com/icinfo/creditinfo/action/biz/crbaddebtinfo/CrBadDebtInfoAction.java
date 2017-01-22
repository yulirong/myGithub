/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-15
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crbaddebtinfo;

import java.util.Date;

import com.icinfo.creditinfo.bean.biz.crbaddebtinfo.CrBadDebtInfo;
import com.icinfo.creditinfo.service.biz.crbaddebtinfo.CrBadDebtInfoService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.pagination.Pagination;

/** 
 * 描述: 不良类的债务明细 Action 类<br>
 * @author yulirong
 * @date 2015-10-15
 */
public class CrBadDebtInfoAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrBadDebtInfoService crBadDebtInfoService;
	private CrBadDebtInfo crBadDebtInfo;
	private String[] crBadDebtInfoIds;

	/**
	 * 描述: 查看列表
	 * @auther yulirong
	 * @date 2015-10-15
	 * @return
	 * @throws Exception
	 */
	public String doReadCrBadDebtInfoListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 分页查询信息
	 * @auther yulirong
	 * @date 2015-10-15
	 * @return
	 * @throws Exception
	 */
	public String doReadCrBadDebtInfoListJSONAction() throws Exception {
		this.addAjaxResults("pagination", new Pagination(crBadDebtInfoService.doGetList(doGetRequestMap()), 
				crBadDebtInfoService.doGetTotal(doGetRequestMap()),pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}
	
	/**
	 * 描述: 进入增加(修改)页面
	 * @auther yulirong
	 * @date 2015-10-15
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditCrBadDebtInfoAction() throws Exception {
		if(crBadDebtInfo!=null && crBadDebtInfo.getId()!=null && !crBadDebtInfo.getId().equals("")){
			crBadDebtInfo =  crBadDebtInfoService.doGetById(crBadDebtInfo.getId());
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 增加(修改)信息
	 * @auther yulirong
	 * @date 2015-10-15
	 * @return
	 * @throws Exception
	 */
	public String doAddAndEditCrBadDebtInfoAction() throws Exception {
		if(crBadDebtInfo!=null && crBadDebtInfo.getId()!=null && !crBadDebtInfo.getId().equals("")){
		    crBadDebtInfoService.doMod(crBadDebtInfo);
		}
		else{
			crBadDebtInfo.setBadUserId(doGetSysUser().getId());
			crBadDebtInfo.setBadOptTime(new Date());
			crBadDebtInfoService.doSave(crBadDebtInfo);
		}
		this.addAjaxResults("success", "true");
		return AJAX;
	}

	/**
	 * 描述: 删除
	 * @auther yulirong
	 * @date 2015-10-15
	 * @return
	 * @throws Exception
	 */
	public String doDelCrBadDebtInfoAction() throws Exception{
		crBadDebtInfoService.doRm(crBadDebtInfo.getId());
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	public CrBadDebtInfoService getCrBadDebtInfoService()
	{
		return crBadDebtInfoService;
	}
	public void setCrBadDebtInfoService(CrBadDebtInfoService crBadDebtInfoService)
	{
		this.crBadDebtInfoService = crBadDebtInfoService;
	}

	public CrBadDebtInfo getCrBadDebtInfo()
	{
		return crBadDebtInfo;
	}

	public void setCrBadDebtInfo(CrBadDebtInfo crBadDebtInfo)
	{
		this.crBadDebtInfo = crBadDebtInfo;
	}

	public String[] getCrBadDebtInfoIds()
	{
		return crBadDebtInfoIds;
	}

	public void setCrBadDebtInfoIds(String[] crBadDebtInfoIds)
	{
		this.crBadDebtInfoIds = crBadDebtInfoIds;
	}

	
}
