/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-10
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crimporthis;

import com.icinfo.creditinfo.bean.biz.crimporthis.CrImportHis;
import com.icinfo.creditinfo.service.biz.crimporthis.CrImportHisService;

import java.util.Map;

import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.common.HxDateUtil;
import com.icinfo.plugin.pagination.Pagination;

/** 
 * 描述: 数据导入历史 Action 类<br>
 * @author liyafeng
 * @date 2015-11-10
 */
public class CrImportHisAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrImportHisService crImportHisService;
	private CrImportHis crImportHis;

	/**
	 * 描述: 查看列表
	 * @auther liyafeng
	 * @date 2015-11-10
	 * @return
	 * @throws Exception
	 */
	public String doReadCrImportHisListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 分页查询信息
	 * @auther liyafeng
	 * @date 2015-11-10
	 * @return
	 * @throws Exception
	 */
	public String doReadCrImportHisListJSONAction() throws Exception {
		Map<String,Object> qryMap=doGetRequestMap();
		String  importStartDate= (String) qryMap.get("importStartDate");
		String  importEndDate= (String) qryMap.get("importEndDate");
		if(importStartDate!=null&&importEndDate!=null){
		qryMap.put("importStartDate", importStartDate+" 00:00:00");
		qryMap.put("importEndDate", importEndDate+" 23:59:59");}
		this.addAjaxResults("pagination", new Pagination(crImportHisService.doGetList(qryMap), 
				crImportHisService.doGetTotal(qryMap),pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}
		
	public CrImportHisService getCrImportHisService()
	{
		return crImportHisService;
	}
	public void setCrImportHisService(CrImportHisService crImportHisService)
	{
		this.crImportHisService = crImportHisService;
	}

	public CrImportHis getCrImportHis()
	{
		return crImportHis;
	}

	public void setCrImportHis(CrImportHis crImportHis)
	{
		this.crImportHis = crImportHis;
	}

	
}
