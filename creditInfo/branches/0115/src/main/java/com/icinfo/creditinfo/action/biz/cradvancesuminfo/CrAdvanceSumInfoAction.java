/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-10-16
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.cradvancesuminfo;

import java.util.Date;

import com.icinfo.creditinfo.bean.biz.cradvancesuminfo.CrAdvanceSumInfo;
import com.icinfo.creditinfo.service.biz.cradvancesuminfo.CrAdvanceSumInfoService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.pagination.Pagination;

/** 
 * 描述: 垫款汇总 Action 类<br>
 * @author gaotong
 * @date 2015-10-16
 */
public class CrAdvanceSumInfoAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrAdvanceSumInfoService crAdvanceSumInfoService;
	private CrAdvanceSumInfo crAdvanceSumInfo;
	private String[] crAdvanceSumInfoIds;

	/**
	 * 描述: 查看列表
	 * @auther gaotong
	 * @date 2015-10-16
	 * @return
	 * @throws Exception
	 */
	public String doReadCrAdvanceSumInfoListAction() throws Exception 
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
	public String doReadCrAdvanceSumInfoListJSONAction() throws Exception {
		this.addAjaxResults("pagination", new Pagination(crAdvanceSumInfoService.doGetList(doGetRequestMap()), 
				crAdvanceSumInfoService.doGetTotal(doGetRequestMap()),pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}
	
	/**
	 * 描述: 进入增加(修改)页面
	 * @auther gaotong
	 * @date 2015-10-16
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditCrAdvanceSumInfoAction() throws Exception {
		if(crAdvanceSumInfo!=null && crAdvanceSumInfo.getId()!=null){
			crAdvanceSumInfo =  crAdvanceSumInfoService.doGetById(crAdvanceSumInfo.getId());
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
	public String doAddAndEditCrAdvanceSumInfoAction() throws Exception {
		if(crAdvanceSumInfo!=null && crAdvanceSumInfo.getId()!=null&&!crAdvanceSumInfo.getId().equals("")){
		    crAdvanceSumInfoService.doMod(crAdvanceSumInfo);
		}
		else{
			crAdvanceSumInfo.setAdvUserid(doGetSysUser().getId());
			crAdvanceSumInfo.setAdvOptTime(new Date());
			crAdvanceSumInfoService.doSave(crAdvanceSumInfo);
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
	public String doDelCrAdvanceSumInfoAction() throws Exception{
		crAdvanceSumInfoService.doRm(crAdvanceSumInfo.getId());
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	public CrAdvanceSumInfoService getCrAdvanceSumInfoService()
	{
		return crAdvanceSumInfoService;
	}
	public void setCrAdvanceSumInfoService(CrAdvanceSumInfoService crAdvanceSumInfoService)
	{
		this.crAdvanceSumInfoService = crAdvanceSumInfoService;
	}

	public CrAdvanceSumInfo getCrAdvanceSumInfo()
	{
		return crAdvanceSumInfo;
	}

	public void setCrAdvanceSumInfo(CrAdvanceSumInfo crAdvanceSumInfo)
	{
		this.crAdvanceSumInfo = crAdvanceSumInfo;
	}

	public String[] getCrAdvanceSumInfoIds()
	{
		return crAdvanceSumInfoIds;
	}

	public void setCrAdvanceSumInfoIds(String[] crAdvanceSumInfoIds)
	{
		this.crAdvanceSumInfoIds = crAdvanceSumInfoIds;
	}

	
}
