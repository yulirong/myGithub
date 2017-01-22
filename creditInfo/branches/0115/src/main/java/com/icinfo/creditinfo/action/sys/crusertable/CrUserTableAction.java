/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-10-12
 * @version 1.0
 */
package com.icinfo.creditinfo.action.sys.crusertable;

import com.icinfo.creditinfo.bean.sys.crusertable.CrUserTable;
import com.icinfo.creditinfo.service.sys.crusertable.CrUserTableService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.pagination.Pagination;

/** 
 * 描述: 用户数据查询范围关联表 Action 类<br>
 * @author zhuyong
 * @date 2015-10-12
 */
public class CrUserTableAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrUserTableService crUserTableService;
	private CrUserTable crUserTable;
	private String[] crUserTableIds;

	/**
	 * 描述: 查看列表
	 * @auther zhuyong
	 * @date 2015-10-12
	 * @return
	 * @throws Exception
	 */
	public String doReadCrUserTableListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 分页查询信息
	 * @auther zhuyong
	 * @date 2015-10-12
	 * @return
	 * @throws Exception
	 */
	public String doReadCrUserTableListJSONAction() throws Exception {
		this.addAjaxResults("pagination", new Pagination(crUserTableService.doGetList(doGetRequestMap()), 
				crUserTableService.doGetTotal(doGetRequestMap()),pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}
	
	/**
	 * 描述: 进入增加(修改)页面
	 * @auther zhuyong
	 * @date 2015-10-12
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditCrUserTableAction() throws Exception {
		if(crUserTable!=null && crUserTable.getId()!=null){
			crUserTable =  crUserTableService.doGetById(crUserTable.getId());
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 增加(修改)信息
	 * @auther zhuyong
	 * @date 2015-10-12
	 * @return
	 * @throws Exception
	 */
	public String doAddAndEditCrUserTableAction() throws Exception {
		if(crUserTable!=null && crUserTable.getId()!=null){
		    crUserTableService.doMod(crUserTable);
		}
		else{
			crUserTableService.doSave(crUserTable);
		}
		this.addAjaxResults("success", "true");
		return AJAX;
	}

	/**
	 * 描述: 批量删除
	 * @auther zhuyong
	 * @date 2015-10-12
	 * @return
	 * @throws Exception
	 */
	public String doDelCrUserTableAction() throws Exception{
		crUserTableService.doRmBatch(crUserTableIds);
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	public CrUserTableService getCrUserTableService()
	{
		return crUserTableService;
	}
	public void setCrUserTableService(CrUserTableService crUserTableService)
	{
		this.crUserTableService = crUserTableService;
	}

	public CrUserTable getCrUserTable()
	{
		return crUserTable;
	}

	public void setCrUserTable(CrUserTable crUserTable)
	{
		this.crUserTable = crUserTable;
	}

	public String[] getCrUserTableIds()
	{
		return crUserTableIds;
	}

	public void setCrUserTableIds(String[] crUserTableIds)
	{
		this.crUserTableIds = crUserTableIds;
	}

	
}
