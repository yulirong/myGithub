/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-20
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crentbaseinfo;

import com.icinfo.creditinfo.bean.biz.crentbaseinfo.CrEntBaseInfo;
import com.icinfo.creditinfo.service.biz.crentbaseinfo.CrEntBaseInfoService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.pagination.Pagination;

/** 
 * 描述: 企业基本信息 Action 类<br>
 * @author yulirong
 * @date 2015-10-20
 */
public class CrEntBaseInfoAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrEntBaseInfoService crEntBaseInfoService;
	private CrEntBaseInfo crEntBaseInfo;
	private String[] crEntBaseInfoIds;

	/**
	 * 描述: 查看列表
	 * @auther yulirong
	 * @date 2015-10-20
	 * @return
	 * @throws Exception
	 */
	public String doReadCrEntBaseInfoListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 分页查询信息
	 * @auther yulirong
	 * @date 2015-10-20
	 * @return
	 * @throws Exception
	 */
	public String doReadCrEntBaseInfoListJSONAction() throws Exception {
		this.addAjaxResults("pagination", new Pagination(crEntBaseInfoService.doGetList(doGetRequestMap()), 
				crEntBaseInfoService.doGetTotal(doGetRequestMap()),pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}
	
	/**
	 * 描述: 进入增加(修改)页面
	 * @auther yulirong
	 * @date 2015-10-20
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditCrEntBaseInfoAction() throws Exception {
		if(crEntBaseInfo!=null && crEntBaseInfo.getId()!=null){
			crEntBaseInfo =  crEntBaseInfoService.doGetById(crEntBaseInfo.getId());
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 增加(修改)信息
	 * @auther yulirong
	 * @date 2015-10-20
	 * @return
	 * @throws Exception
	 */
	public String doAddAndEditCrEntBaseInfoAction() throws Exception {
		if(crEntBaseInfo!=null && crEntBaseInfo.getId()!=null){
		    crEntBaseInfoService.doMod(crEntBaseInfo);
		}
		else{
			crEntBaseInfoService.doSave(crEntBaseInfo);
		}
		this.addAjaxResults("success", "true");
		return AJAX;
	}

	/**
	 * 描述: 批量删除
	 * @auther yulirong
	 * @date 2015-10-20
	 * @return
	 * @throws Exception
	 */
	public String doDelCrEntBaseInfoAction() throws Exception{
//		crEntBaseInfoService.doRmBatch(crEntBaseInfoIds);
//		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	public CrEntBaseInfoService getCrEntBaseInfoService()
	{
		return crEntBaseInfoService;
	}
	public void setCrEntBaseInfoService(CrEntBaseInfoService crEntBaseInfoService)
	{
		this.crEntBaseInfoService = crEntBaseInfoService;
	}

	public CrEntBaseInfo getCrEntBaseInfo()
	{
		return crEntBaseInfo;
	}

	public void setCrEntBaseInfo(CrEntBaseInfo crEntBaseInfo)
	{
		this.crEntBaseInfo = crEntBaseInfo;
	}

	public String[] getCrEntBaseInfoIds()
	{
		return crEntBaseInfoIds;
	}

	public void setCrEntBaseInfoIds(String[] crEntBaseInfoIds)
	{
		this.crEntBaseInfoIds = crEntBaseInfoIds;
	}

	
}
