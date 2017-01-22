/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author mayawei
 * @date 2015-10-26
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.hzqyfddbr;

import com.icinfo.creditinfo.bean.biz.hzqyfddbr.HzQyfddbr;
import com.icinfo.creditinfo.service.biz.hzqyfddbr.HzQyfddbrService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.pagination.Pagination;

/** 
 * 描述: 企业法人代表 Action 类<br>
 * @author mayawei
 * @date 2015-10-26
 */
public class HzQyfddbrAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private HzQyfddbrService hzQyfddbrService;
	private HzQyfddbr hzQyfddbr;
	private String[] hzQyfddbrIds;

	/**
	 * 描述: 查看列表
	 * @auther mayawei
	 * @date 2015-10-26
	 * @return
	 * @throws Exception
	 */
	public String doReadHzQyfddbrListAction() throws Exception 
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
	public String doReadHzQyfddbrListJSONAction() throws Exception {
		this.addAjaxResults("pagination", new Pagination(hzQyfddbrService.doGetList(doGetRequestMap()), 
				hzQyfddbrService.doGetTotal(doGetRequestMap()),pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}
	
	/**
	 * 描述: 进入增加(修改)页面
	 * @auther mayawei
	 * @date 2015-10-26
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditHzQyfddbrAction() throws Exception {
		if(hzQyfddbr!=null && hzQyfddbr.getId()!=null){
			hzQyfddbr =  hzQyfddbrService.doGetById(hzQyfddbr.getId());
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
	public String doAddAndEditHzQyfddbrAction() throws Exception {
		if(hzQyfddbr!=null && hzQyfddbr.getId()!=null){
		    hzQyfddbrService.doMod(hzQyfddbr);
		}
		else{
			hzQyfddbrService.doSave(hzQyfddbr);
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
	public String doDelHzQyfddbrAction() throws Exception{
		hzQyfddbrService.doRmBatch(hzQyfddbrIds);
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	public HzQyfddbrService getHzQyfddbrService()
	{
		return hzQyfddbrService;
	}
	public void setHzQyfddbrService(HzQyfddbrService hzQyfddbrService)
	{
		this.hzQyfddbrService = hzQyfddbrService;
	}

	public HzQyfddbr getHzQyfddbr()
	{
		return hzQyfddbr;
	}

	public void setHzQyfddbr(HzQyfddbr hzQyfddbr)
	{
		this.hzQyfddbr = hzQyfddbr;
	}

	public String[] getHzQyfddbrIds()
	{
		return hzQyfddbrIds;
	}

	public void setHzQyfddbrIds(String[] hzQyfddbrIds)
	{
		this.hzQyfddbrIds = hzQyfddbrIds;
	}

	
}
