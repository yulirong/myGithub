/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-10-16
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crguaranteesuminfo;

import java.util.Date;

import com.icinfo.creditinfo.bean.biz.crguaranteesuminfo.CrGuaranteeSumInfo;
import com.icinfo.creditinfo.service.biz.crguaranteesuminfo.CrGuaranteeSumInfoService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.pagination.Pagination;

/** 
 * 描述: 保函汇总 Action 类<br>
 * @author gaotong
 * @date 2015-10-16
 */
public class CrGuaranteeSumInfoAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrGuaranteeSumInfoService crGuaranteeSumInfoService;
	private CrGuaranteeSumInfo crGuaranteeSumInfo;
	private String[] crGuaranteeSumInfoIds;

	/**
	 * 描述: 查看列表
	 * @auther gaotong
	 * @date 2015-10-16
	 * @return
	 * @throws Exception
	 */
	public String doReadCrGuaranteeSumInfoListAction() throws Exception 
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
	public String doReadCrGuaranteeSumInfoListJSONAction() throws Exception {
		this.addAjaxResults("pagination", new Pagination(crGuaranteeSumInfoService.doGetList(doGetRequestMap()), 
				crGuaranteeSumInfoService.doGetTotal(doGetRequestMap()),pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}
	
	/**
	 * 描述: 进入增加(修改)页面
	 * @auther gaotong
	 * @date 2015-10-16
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditCrGuaranteeSumInfoAction() throws Exception {
		if(crGuaranteeSumInfo!=null && crGuaranteeSumInfo.getId()!=null){
			crGuaranteeSumInfo =  crGuaranteeSumInfoService.doGetById(crGuaranteeSumInfo.getId());
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
	public String doAddAndEditCrGuaranteeSumInfoAction() throws Exception {
		if(crGuaranteeSumInfo!=null && crGuaranteeSumInfo.getId()!=null&&!crGuaranteeSumInfo.getId().equals("")){
		    crGuaranteeSumInfoService.doMod(crGuaranteeSumInfo);
		}
		else{
			crGuaranteeSumInfo.setGuaUserid(doGetSysUser().getId());
			crGuaranteeSumInfo.setGuaOptTime(new Date());
			crGuaranteeSumInfoService.doSave(crGuaranteeSumInfo);
		}
		this.addAjaxResults("success", "true");
		return AJAX;
	}

	/**
	 * 描述: 删除
	 * @auther gaotong
	 * @date 2015-10-16
	 * @return
	 * @throws Exception
	 */
	public String doDelCrGuaranteeSumInfoAction() throws Exception{
		crGuaranteeSumInfoService.doRm(crGuaranteeSumInfo.getId());
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	public CrGuaranteeSumInfoService getCrGuaranteeSumInfoService()
	{
		return crGuaranteeSumInfoService;
	}
	public void setCrGuaranteeSumInfoService(CrGuaranteeSumInfoService crGuaranteeSumInfoService)
	{
		this.crGuaranteeSumInfoService = crGuaranteeSumInfoService;
	}

	public CrGuaranteeSumInfo getCrGuaranteeSumInfo()
	{
		return crGuaranteeSumInfo;
	}

	public void setCrGuaranteeSumInfo(CrGuaranteeSumInfo crGuaranteeSumInfo)
	{
		this.crGuaranteeSumInfo = crGuaranteeSumInfo;
	}

	public String[] getCrGuaranteeSumInfoIds()
	{
		return crGuaranteeSumInfoIds;
	}

	public void setCrGuaranteeSumInfoIds(String[] crGuaranteeSumInfoIds)
	{
		this.crGuaranteeSumInfoIds = crGuaranteeSumInfoIds;
	}

	
}
