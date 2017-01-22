/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-10-16
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crcreditsuminfo;

import java.util.Date;

import com.icinfo.creditinfo.bean.biz.crcreditsuminfo.CrCreditSumInfo;
import com.icinfo.creditinfo.service.biz.crcreditsuminfo.CrCreditSumInfoService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.pagination.Pagination;

/** 
 * 描述: 信用证汇总 Action 类<br>
 * @author gaotong
 * @date 2015-10-16
 */
public class CrCreditSumInfoAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrCreditSumInfoService crCreditSumInfoService;
	private CrCreditSumInfo crCreditSumInfo;
	private String[] crCreditSumInfoIds;

	/**
	 * 描述: 查看列表
	 * @auther gaotong
	 * @date 2015-10-16
	 * @return
	 * @throws Exception
	 */
	public String doReadCrCreditSumInfoListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 分页查询信息
	 * @auther gaotong
	 * @date 2015-10-16
	 * @return
	 * @throws Exception
	 */
	public String doReadCrCreditSumInfoListJSONAction() throws Exception {
		this.addAjaxResults("pagination", new Pagination(crCreditSumInfoService.doGetList(doGetRequestMap()), 
				crCreditSumInfoService.doGetTotal(doGetRequestMap()),pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}
	
	/**
	 * 描述: 进入增加(修改)页面
	 * @auther gaotong
	 * @date 2015-10-16
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditCrCreditSumInfoAction() throws Exception {
		if(crCreditSumInfo!=null && crCreditSumInfo.getId()!=null){
			crCreditSumInfo =  crCreditSumInfoService.doGetById(crCreditSumInfo.getId());
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 增加(修改)信息
	 * @auther gaotong
	 * @date 2015-10-16
	 * @return
	 * @throws Exception
	 */
	public String doAddAndEditCrCreditSumInfoAction() throws Exception {
		if(crCreditSumInfo!=null && crCreditSumInfo.getId()!=null&&!crCreditSumInfo.getId().equals("")){
		    crCreditSumInfoService.doMod(crCreditSumInfo);
		}
		else{
			crCreditSumInfo.setCreUserid(doGetSysUser().getId());
			crCreditSumInfo.setCreOptTime(new Date());
			crCreditSumInfoService.doSave(crCreditSumInfo);
		}
		this.addAjaxResults("success", "true");
		return AJAX;
	}

	/**
	 * 描述: 批量删除
	 * @auther gaotong
	 * @date 2015-10-16
	 * @return
	 * @throws Exception
	 */
	public String doDelCrCreditSumInfoAction() throws Exception{
		crCreditSumInfoService.doRm(crCreditSumInfo.getId());
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	public CrCreditSumInfoService getCrCreditSumInfoService()
	{
		return crCreditSumInfoService;
	}
	public void setCrCreditSumInfoService(CrCreditSumInfoService crCreditSumInfoService)
	{
		this.crCreditSumInfoService = crCreditSumInfoService;
	}

	public CrCreditSumInfo getCrCreditSumInfo()
	{
		return crCreditSumInfo;
	}

	public void setCrCreditSumInfo(CrCreditSumInfo crCreditSumInfo)
	{
		this.crCreditSumInfo = crCreditSumInfo;
	}

	public String[] getCrCreditSumInfoIds()
	{
		return crCreditSumInfoIds;
	}

	public void setCrCreditSumInfoIds(String[] crCreditSumInfoIds)
	{
		this.crCreditSumInfoIds = crCreditSumInfoIds;
	}

	
}
