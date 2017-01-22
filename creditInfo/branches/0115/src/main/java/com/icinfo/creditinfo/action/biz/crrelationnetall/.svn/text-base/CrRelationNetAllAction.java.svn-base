/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-11-30
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crrelationnetall;

import com.icinfo.creditinfo.bean.biz.crrelationnetall.CrRelationNetAll;
import com.icinfo.creditinfo.service.biz.crrelationnetall.CrRelationNetAllService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.pagination.Pagination;

/** 
 * 描述: 关系网络汇总信息 Action 类<br>
 * @author zhuyong
 * @date 2015-11-30
 */
public class CrRelationNetAllAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrRelationNetAllService crRelationNetAllService;
	private CrRelationNetAll crRelationNetAll;
	private String[] crRelationNetAllIds;

	/**
	 * 描述: 查看列表
	 * @auther zhuyong
	 * @date 2015-11-30
	 * @return
	 * @throws Exception
	 */
	public String doReadCrRelationNetAllListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 分页查询信息
	 * @auther zhuyong
	 * @date 2015-11-30
	 * @return
	 * @throws Exception
	 */
	public String doReadCrRelationNetAllListJSONAction() throws Exception {
		this.addAjaxResults("pagination", new Pagination(crRelationNetAllService.doGetList(doGetRequestMap()), 
				crRelationNetAllService.doGetTotal(doGetRequestMap()),pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}
	
	

	
	public CrRelationNetAllService getCrRelationNetAllService()
	{
		return crRelationNetAllService;
	}
	public void setCrRelationNetAllService(CrRelationNetAllService crRelationNetAllService)
	{
		this.crRelationNetAllService = crRelationNetAllService;
	}

	public CrRelationNetAll getCrRelationNetAll()
	{
		return crRelationNetAll;
	}

	public void setCrRelationNetAll(CrRelationNetAll crRelationNetAll)
	{
		this.crRelationNetAll = crRelationNetAll;
	}

	public String[] getCrRelationNetAllIds()
	{
		return crRelationNetAllIds;
	}

	public void setCrRelationNetAllIds(String[] crRelationNetAllIds)
	{
		this.crRelationNetAllIds = crRelationNetAllIds;
	}

	
}
