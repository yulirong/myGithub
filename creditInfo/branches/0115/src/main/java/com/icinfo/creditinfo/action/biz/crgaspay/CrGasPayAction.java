/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-03
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crgaspay;

import com.icinfo.creditinfo.bean.biz.crgaspay.CrGasPay;
import com.icinfo.creditinfo.service.biz.crgaspay.CrGasPayService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.pagination.Pagination;

/** 
 * 描述: 用气量信息表 Action 类<br>
 * @author myw
 * @date 2015-11-03
 */
public class CrGasPayAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrGasPayService crGasPayService;
	private CrGasPay crGasPay;
	private String[] crGasPayIds;

	/**
	 * 描述: 查看列表
	 * @auther myw
	 * @date 2015-11-03
	 * @return
	 * @throws Exception
	 */
	public String doReadCrGasPayListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 分页查询信息
	 * @auther myw
	 * @date 2015-11-03
	 * @return
	 * @throws Exception
	 */
	public String doReadCrGasPayListJSONAction() throws Exception {
		this.addAjaxResults("pagination", new Pagination(crGasPayService.doGetList(doGetRequestMap()), 
				crGasPayService.doGetTotal(doGetRequestMap()),pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}
	
	/**
	 * 描述: 进入增加(修改)页面
	 * @auther myw
	 * @date 2015-11-03
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditCrGasPayAction() throws Exception {
		if(crGasPay!=null && crGasPay.getId()!=null){
			crGasPay =  crGasPayService.doGetById(crGasPay.getId());
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 增加(修改)信息
	 * @auther myw
	 * @date 2015-11-03
	 * @return
	 * @throws Exception
	 */
	public String doAddAndEditCrGasPayAction() throws Exception {
		if(crGasPay!=null && crGasPay.getId()!=null){
		    crGasPayService.doMod(crGasPay);
		}
		else{
			crGasPayService.doSave(crGasPay);
		}
		this.addAjaxResults("success", "true");
		return AJAX;
	}

	/**
	 * 描述: 批量删除
	 * @auther myw
	 * @date 2015-11-03
	 * @return
	 * @throws Exception
	 */
	public String doDelCrGasPayAction() throws Exception{
		crGasPayService.doRmBatch(crGasPayIds);
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	public CrGasPayService getCrGasPayService()
	{
		return crGasPayService;
	}
	public void setCrGasPayService(CrGasPayService crGasPayService)
	{
		this.crGasPayService = crGasPayService;
	}

	public CrGasPay getCrGasPay()
	{
		return crGasPay;
	}

	public void setCrGasPay(CrGasPay crGasPay)
	{
		this.crGasPay = crGasPay;
	}

	public String[] getCrGasPayIds()
	{
		return crGasPayIds;
	}

	public void setCrGasPayIds(String[] crGasPayIds)
	{
		this.crGasPayIds = crGasPayIds;
	}

	
}
