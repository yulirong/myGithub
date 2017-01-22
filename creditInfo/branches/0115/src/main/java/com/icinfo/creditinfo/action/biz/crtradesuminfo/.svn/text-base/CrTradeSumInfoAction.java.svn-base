/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-10-16
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crtradesuminfo;

import java.util.Date;

import com.icinfo.creditinfo.bean.biz.crtradesuminfo.CrTradeSumInfo;
import com.icinfo.creditinfo.service.biz.crtradesuminfo.CrTradeSumInfoService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.pagination.Pagination;

/** 
 * 描述: 贸易融资汇总 Action 类<br>
 * @author gaotong
 * @date 2015-10-16
 */
public class CrTradeSumInfoAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrTradeSumInfoService crTradeSumInfoService;
	private CrTradeSumInfo crTradeSumInfo;
	private String[] crTradeSumInfoIds;

	/**
	 * 描述: 查看列表
	 * @auther gaotong
	 * @date 2015-10-16
	 * @return
	 * @throws Exception
	 */
	public String doReadCrTradeSumInfoListAction() throws Exception 
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
	public String doReadCrTradeSumInfoListJSONAction() throws Exception {
		this.addAjaxResults("pagination", new Pagination(crTradeSumInfoService.doGetList(doGetRequestMap()), 
				crTradeSumInfoService.doGetTotal(null),pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}
	
	/**
	 * 描述: 进入增加(修改)页面
	 * @auther gaotong
	 * @date 2015-10-16
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditCrTradeSumInfoAction() throws Exception {
		if(crTradeSumInfo!=null && crTradeSumInfo.getId()!=null){
			crTradeSumInfo =  crTradeSumInfoService.doGetById(crTradeSumInfo.getId());
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
	public String doAddAndEditCrTradeSumInfoAction() throws Exception {
		if(crTradeSumInfo!=null && crTradeSumInfo.getId()!=null&&!crTradeSumInfo.getId().equals("")){
		    crTradeSumInfoService.doMod(crTradeSumInfo);
		}
		else{
			crTradeSumInfo.setTarUserid(doGetSysUser().getId());
			crTradeSumInfo.setTarOptTime(new Date());
			crTradeSumInfoService.doSave(crTradeSumInfo);
		}
		this.addAjaxResults("success", "true");
		return AJAX;
	}

	/**
	 * 描述: 删除
	 * @auther gaotong
	 * @date 2015-10-19
	 * @return
	 * @throws Exception
	 */
	public String doDelCrTradeSumInfoAction() throws Exception{
		crTradeSumInfoService.doRm(crTradeSumInfo.getId());
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	public CrTradeSumInfoService getCrTradeSumInfoService()
	{
		return crTradeSumInfoService;
	}
	public void setCrTradeSumInfoService(CrTradeSumInfoService crTradeSumInfoService)
	{
		this.crTradeSumInfoService = crTradeSumInfoService;
	}

	public CrTradeSumInfo getCrTradeSumInfo()
	{
		return crTradeSumInfo;
	}

	public void setCrTradeSumInfo(CrTradeSumInfo crTradeSumInfo)
	{
		this.crTradeSumInfo = crTradeSumInfo;
	}

	public String[] getCrTradeSumInfoIds()
	{
		return crTradeSumInfoIds;
	}

	public void setCrTradeSumInfoIds(String[] crTradeSumInfoIds)
	{
		this.crTradeSumInfoIds = crTradeSumInfoIds;
	}

	
}
