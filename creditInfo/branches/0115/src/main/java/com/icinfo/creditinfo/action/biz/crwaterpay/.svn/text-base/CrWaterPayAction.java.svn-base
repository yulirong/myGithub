/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-03
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crwaterpay;

import com.icinfo.creditinfo.bean.biz.crwaterpay.CrWaterPay;
import com.icinfo.creditinfo.service.biz.crwaterpay.CrWaterPayService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.pagination.Pagination;

/** 
 * 描述: 用水量信息统计表 Action 类<br>
 * @author myw
 * @date 2015-11-03
 */
public class CrWaterPayAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrWaterPayService crWaterPayService;
	private CrWaterPay crWaterPay;
	private String[] crWaterPayIds;

	/**
	 * 描述: 查看列表
	 * @auther myw
	 * @date 2015-11-03
	 * @return
	 * @throws Exception
	 */
	public String doReadCrWaterPayListAction() throws Exception 
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
	public String doReadCrWaterPayListJSONAction() throws Exception {
		this.addAjaxResults("pagination", new Pagination(crWaterPayService.doGetList(doGetRequestMap()), 
				crWaterPayService.doGetTotal(doGetRequestMap()),pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}
	
	/**
	 * 描述: 进入增加(修改)页面
	 * @auther myw
	 * @date 2015-11-03
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditCrWaterPayAction() throws Exception {
		if(crWaterPay!=null && crWaterPay.getId()!=null){
			crWaterPay =  crWaterPayService.doGetById(crWaterPay.getId());
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
	public String doAddAndEditCrWaterPayAction() throws Exception {
		if(crWaterPay!=null && crWaterPay.getId()!=null){
		    crWaterPayService.doMod(crWaterPay);
		}
		else{
			crWaterPayService.doSave(crWaterPay);
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
	public String doDelCrWaterPayAction() throws Exception{
		crWaterPayService.doRmBatch(crWaterPayIds);
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	public CrWaterPayService getCrWaterPayService()
	{
		return crWaterPayService;
	}
	public void setCrWaterPayService(CrWaterPayService crWaterPayService)
	{
		this.crWaterPayService = crWaterPayService;
	}

	public CrWaterPay getCrWaterPay()
	{
		return crWaterPay;
	}

	public void setCrWaterPay(CrWaterPay crWaterPay)
	{
		this.crWaterPay = crWaterPay;
	}

	public String[] getCrWaterPayIds()
	{
		return crWaterPayIds;
	}

	public void setCrWaterPayIds(String[] crWaterPayIds)
	{
		this.crWaterPayIds = crWaterPayIds;
	}

	
}
