/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-10-21
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.hzqytzf;

import com.icinfo.creditinfo.bean.biz.hzqytzf.HzQytzf;
import com.icinfo.creditinfo.service.biz.hzqytzf.HzQytzfService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.pagination.Pagination;

/** 
 * 描述: 企业投资方 Action 类<br>
 * @author gaotong
 * @date 2015-10-21
 */
public class HzQytzfAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private HzQytzfService hzQytzfService;
	private HzQytzf hzQytzf;
	private String[] hzQytzfIds;

	/**
	 * 描述: 查看列表
	 * @auther gaotong
	 * @date 2015-10-21
	 * @return
	 * @throws Exception
	 */
	public String doReadHzQytzfListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 分页查询信息
	 * @auther gaotong
	 * @date 2015-10-21
	 * @return
	 * @throws Exception
	 */
	public String doReadHzQytzfListJSONAction() throws Exception {
		this.addAjaxResults("pagination", new Pagination(hzQytzfService.doGetList(doGetRequestMap()), 
				hzQytzfService.doGetTotal(doGetRequestMap()),pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}
	
	/**
	 * 描述: 进入增加(修改)页面
	 * @auther gaotong
	 * @date 2015-10-21
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditHzQytzfAction() throws Exception {

		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 增加(修改)信息
	 * @auther gaotong
	 * @date 2015-10-21
	 * @return
	 * @throws Exception
	 */
	public String doAddAndEditHzQytzfAction() throws Exception {

		return AJAX;
	}

	/**
	 * 描述: 批量删除
	 * @auther gaotong
	 * @date 2015-10-21
	 * @return
	 * @throws Exception
	 */
	public String doDelHzQytzfAction() throws Exception{
		hzQytzfService.doRmBatch(hzQytzfIds);
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	public HzQytzfService getHzQytzfService()
	{
		return hzQytzfService;
	}
	public void setHzQytzfService(HzQytzfService hzQytzfService)
	{
		this.hzQytzfService = hzQytzfService;
	}

	public HzQytzf getHzQytzf()
	{
		return hzQytzf;
	}

	public void setHzQytzf(HzQytzf hzQytzf)
	{
		this.hzQytzf = hzQytzf;
	}

	public String[] getHzQytzfIds()
	{
		return hzQytzfIds;
	}

	public void setHzQytzfIds(String[] hzQytzfIds)
	{
		this.hzQytzfIds = hzQytzfIds;
	}

	
}
