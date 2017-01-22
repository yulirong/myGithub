/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-03
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crwatersewagedischargepay;

import com.icinfo.creditinfo.bean.biz.crwatersewagedischargepay.CrWaterSewageDischargePay;
import com.icinfo.creditinfo.service.biz.crwatersewagedischargepay.CrWaterSewageDischargePayService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.pagination.Pagination;

/** 
 * 描述: 污水排放信息表 Action 类<br>
 * @author myw
 * @date 2015-11-03
 */
public class CrWaterSewageDischargePayAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrWaterSewageDischargePayService crWaterSewageDischargePayService;
	private CrWaterSewageDischargePay crWaterSewageDischargePay;
	private String[] crWaterSewageDischargePayIds;

	/**
	 * 描述: 查看列表
	 * @auther myw
	 * @date 2015-11-03
	 * @return
	 * @throws Exception
	 */
	public String doReadCrWaterSewageDischargePayListAction() throws Exception 
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
	public String doReadCrWaterSewageDischargePayListJSONAction() throws Exception {
		this.addAjaxResults("pagination", new Pagination(crWaterSewageDischargePayService.doGetList(doGetRequestMap()), 
				crWaterSewageDischargePayService.doGetTotal(doGetRequestMap()),pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}
	
	/**
	 * 描述: 进入增加(修改)页面
	 * @auther myw
	 * @date 2015-11-03
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditCrWaterSewageDischargePayAction() throws Exception {
		if(crWaterSewageDischargePay!=null && crWaterSewageDischargePay.getId()!=null){
			crWaterSewageDischargePay =  crWaterSewageDischargePayService.doGetById(crWaterSewageDischargePay.getId());
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
	public String doAddAndEditCrWaterSewageDischargePayAction() throws Exception {
		if(crWaterSewageDischargePay!=null && crWaterSewageDischargePay.getId()!=null){
		    crWaterSewageDischargePayService.doMod(crWaterSewageDischargePay);
		}
		else{
			crWaterSewageDischargePayService.doSave(crWaterSewageDischargePay);
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
	public String doDelCrWaterSewageDischargePayAction() throws Exception{
		crWaterSewageDischargePayService.doRmBatch(crWaterSewageDischargePayIds);
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	public CrWaterSewageDischargePayService getCrWaterSewageDischargePayService()
	{
		return crWaterSewageDischargePayService;
	}
	public void setCrWaterSewageDischargePayService(CrWaterSewageDischargePayService crWaterSewageDischargePayService)
	{
		this.crWaterSewageDischargePayService = crWaterSewageDischargePayService;
	}

	public CrWaterSewageDischargePay getCrWaterSewageDischargePay()
	{
		return crWaterSewageDischargePay;
	}

	public void setCrWaterSewageDischargePay(CrWaterSewageDischargePay crWaterSewageDischargePay)
	{
		this.crWaterSewageDischargePay = crWaterSewageDischargePay;
	}

	public String[] getCrWaterSewageDischargePayIds()
	{
		return crWaterSewageDischargePayIds;
	}

	public void setCrWaterSewageDischargePayIds(String[] crWaterSewageDischargePayIds)
	{
		this.crWaterSewageDischargePayIds = crWaterSewageDischargePayIds;
	}

	
}
