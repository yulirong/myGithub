/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-15
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crabnormalcreditinfo;

import java.util.Date;
import com.icinfo.creditinfo.bean.biz.crabnormalcreditinfo.CrAbnormalCreditInfo;
import com.icinfo.creditinfo.service.biz.crabnormalcreditinfo.CrAbnormalCreditInfoService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.pagination.Pagination;

/** 
 * 描述: 异常信贷记录明细 Action 类<br>
 * @author yulirong
 * @date 2015-10-15
 */
public class CrAbnormalCreditInfoAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrAbnormalCreditInfoService crAbnormalCreditInfoService;
	private CrAbnormalCreditInfo crAbnormalCreditInfo;
	private String[] crAbnormalCreditInfoIds;

	/**
	 * 描述: 查看列表
	 * @auther yulirong
	 * @date 2015-10-15
	 * @return
	 * @throws Exception
	 */
	public String doReadCrAbnormalCreditInfoListAction() throws Exception 
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
	public String doReadCrAbnormalCreditInfoListJSONAction() throws Exception {
		this.addAjaxResults("pagination", new Pagination(crAbnormalCreditInfoService.doGetList(doGetRequestMap()), 
				crAbnormalCreditInfoService.doGetTotal(doGetRequestMap()),pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}
	
	/**
	 * 描述: 进入增加(修改)页面
	 * @auther yulirong
	 * @date 2015-10-15
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditCrAbnormalCreditInfoAction() throws Exception {
		if(crAbnormalCreditInfo!=null && crAbnormalCreditInfo.getId()!=null &&!crAbnormalCreditInfo.getId().equals("")){
			crAbnormalCreditInfo =  crAbnormalCreditInfoService.doGetById(crAbnormalCreditInfo.getId());
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
	public String doAddAndEditCrAbnormalCreditInfoAction() throws Exception {
		if (crAbnormalCreditInfo != null
				&& crAbnormalCreditInfo.getId() != null
				&& !crAbnormalCreditInfo.getId().equals("")) {
			crAbnormalCreditInfoService.doMod(crAbnormalCreditInfo);
		} else {
			crAbnormalCreditInfo.setAbnOptTime(new Date());
			crAbnormalCreditInfo.setAbnUserId(doGetSysUser().getId());
			crAbnormalCreditInfoService.doSave(crAbnormalCreditInfo);
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
	public String doDelCrAbnormalCreditInfoAction() throws Exception{
		crAbnormalCreditInfoService.doRm(crAbnormalCreditInfo.getId());
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	public CrAbnormalCreditInfoService getCrAbnormalCreditInfoService()
	{
		return crAbnormalCreditInfoService;
	}
	public void setCrAbnormalCreditInfoService(CrAbnormalCreditInfoService crAbnormalCreditInfoService)
	{
		this.crAbnormalCreditInfoService = crAbnormalCreditInfoService;
	}

	public CrAbnormalCreditInfo getCrAbnormalCreditInfo()
	{
		return crAbnormalCreditInfo;
	}

	public void setCrAbnormalCreditInfo(CrAbnormalCreditInfo crAbnormalCreditInfo)
	{
		this.crAbnormalCreditInfo = crAbnormalCreditInfo;
	}

	public String[] getCrAbnormalCreditInfoIds()
	{
		return crAbnormalCreditInfoIds;
	}

	public void setCrAbnormalCreditInfoIds(String[] crAbnormalCreditInfoIds)
	{
		this.crAbnormalCreditInfoIds = crAbnormalCreditInfoIds;
	}

	
}
