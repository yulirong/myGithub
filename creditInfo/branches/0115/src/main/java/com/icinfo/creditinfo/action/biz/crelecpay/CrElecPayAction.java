/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-03
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crelecpay;

import com.icinfo.creditinfo.bean.biz.crelecpay.CrElecPay;
import com.icinfo.creditinfo.service.biz.crelecpay.CrElecPayService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.pagination.Pagination;

/** 
 * 描述: 用电量信息表 Action 类<br>
 * @author myw
 * @date 2015-11-03
 */
public class CrElecPayAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrElecPayService crElecPayService;
	private CrElecPay crElecPay;
	private String[] crElecPayIds;

	/**
	 * 描述: 查看列表
	 * @auther myw
	 * @date 2015-11-03
	 * @return
	 * @throws Exception
	 */
	public String doReadCrElecPayListAction() throws Exception 
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
	public String doReadCrElecPayListJSONAction() throws Exception {
		this.addAjaxResults("pagination", new Pagination(crElecPayService.doGetList(doGetRequestMap()), 
				crElecPayService.doGetTotal(doGetRequestMap()),pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}
	
	/**
	 * 描述: 进入增加(修改)页面
	 * @auther myw
	 * @date 2015-11-03
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditCrElecPayAction() throws Exception {
		if(crElecPay!=null && crElecPay.getId()!=null){
			crElecPay =  crElecPayService.doGetById(crElecPay.getId());
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
	public String doAddAndEditCrElecPayAction() throws Exception {
		if(crElecPay!=null && crElecPay.getId()!=null){
		    crElecPayService.doMod(crElecPay);
		}
		else{
			crElecPayService.doSave(crElecPay);
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
	public String doDelCrElecPayAction() throws Exception{
		crElecPayService.doRmBatch(crElecPayIds);
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	public CrElecPayService getCrElecPayService()
	{
		return crElecPayService;
	}
	public void setCrElecPayService(CrElecPayService crElecPayService)
	{
		this.crElecPayService = crElecPayService;
	}

	public CrElecPay getCrElecPay()
	{
		return crElecPay;
	}

	public void setCrElecPay(CrElecPay crElecPay)
	{
		this.crElecPay = crElecPay;
	}

	public String[] getCrElecPayIds()
	{
		return crElecPayIds;
	}

	public void setCrElecPayIds(String[] crElecPayIds)
	{
		this.crElecPayIds = crElecPayIds;
	}

	
}
