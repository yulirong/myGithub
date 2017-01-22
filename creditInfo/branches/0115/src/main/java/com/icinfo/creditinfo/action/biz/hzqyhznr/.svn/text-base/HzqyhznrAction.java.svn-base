/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gqf
 * @date 2015-10-14
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.hzqyhznr;

import com.icinfo.creditinfo.bean.biz.hzqyhznr.Hzqyhznr;
import com.icinfo.creditinfo.service.biz.hzqyhznr.HzqyhznrService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.pagination.Pagination;

/** 
 * 描述: 异常名录 Action 类<br>
 * @author gqf
 * @date 2015-10-14
 */
public class HzqyhznrAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private HzqyhznrService hzqyhznrService;
	private Hzqyhznr hzqyhznr;
	private String[] hzqyhznrIds;

	/**
	 * 描述: 查看列表
	 * @auther gqf
	 * @date 2015-10-14
	 * @return
	 * @throws Exception
	 */
	public String doReadHzqyhznrListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 分页查询信息
	 * @auther gqf
	 * @date 2015-10-14
	 * @return
	 * @throws Exception
	 */
	public String doReadHzqyhznrListJSONAction() throws Exception {
		this.addAjaxResults("pagination", new Pagination(hzqyhznrService.doGetList(doGetRequestMap()), 
				hzqyhznrService.doGetTotal(doGetRequestMap()),pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}
	
	/**
	 * 描述: 进入增加(修改)页面
	 * @auther gqf
	 * @date 2015-10-14
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditHzqyhznrAction() throws Exception {
		if(hzqyhznr!=null && hzqyhznr.getId()!=null){
			hzqyhznr =  hzqyhznrService.doGetById(hzqyhznr.getId());
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 增加(修改)信息
	 * @auther gqf
	 * @date 2015-10-14
	 * @return
	 * @throws Exception
	 */
	public String doAddAndEditHzqyhznrAction() throws Exception {
		if(hzqyhznr!=null && hzqyhznr.getId()!=null){
		    hzqyhznrService.doMod(hzqyhznr);
		}
		else{
			hzqyhznrService.doSave(hzqyhznr);
		}
		this.addAjaxResults("success", "true");
		return AJAX;
	}

	/**
	 * 描述: 批量删除
	 * @auther gqf
	 * @date 2015-10-14
	 * @return
	 * @throws Exception
	 */
	public String doDelHzqyhznrAction() throws Exception{
		hzqyhznrService.doRmBatch(hzqyhznrIds);
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	public HzqyhznrService getHzqyhznrService()
	{
		return hzqyhznrService;
	}
	public void setHzqyhznrService(HzqyhznrService hzqyhznrService)
	{
		this.hzqyhznrService = hzqyhznrService;
	}

	public Hzqyhznr getHzqyhznr()
	{
		return hzqyhznr;
	}

	public void setHzqyhznr(Hzqyhznr hzqyhznr)
	{
		this.hzqyhznr = hzqyhznr;
	}

	public String[] getHzqyhznrIds()
	{
		return hzqyhznrIds;
	}

	public void setHzqyhznrIds(String[] hzqyhznrIds)
	{
		this.hzqyhznrIds = hzqyhznrIds;
	}

	
}
