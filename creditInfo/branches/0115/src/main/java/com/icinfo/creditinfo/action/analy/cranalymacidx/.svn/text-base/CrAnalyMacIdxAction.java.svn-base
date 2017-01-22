/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-09
 * @version 1.0
 */
package com.icinfo.creditinfo.action.analy.cranalymacidx;

import net.sf.json.JSONArray;

import com.icinfo.creditinfo.bean.analy.cranalymacidx.CrAnalyMacIdx;
import com.icinfo.creditinfo.service.analy.cranalymacidx.CrAnalyMacIdxService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;

/** 
 * 描述: 经济指数风险指数统计表 Action 类<br>
 * @author myw
 * @date 2015-11-09
 */
public class CrAnalyMacIdxAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrAnalyMacIdxService crAnalyMacIdxService;
	private CrAnalyMacIdx crAnalyMacIdx;
	private String[] crAnalyMacIdxIds;

	/**
	 * 描述: 查看列表
	 * @auther myw
	 * @date 2015-11-09
	 * @return
	 * @throws Exception
	 */
	public String doReadCrAnalyMacIdxListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 分页查询信息
	 * @auther myw
	 * @date 2015-11-09
	 * @return
	 * @throws Exception
	 */
	public String doReadCrAnalyMacIdxListJSONAction() throws Exception {
		
		JSONArray dataJson = crAnalyMacIdxService.doGetLateMacIdxJson(null);
		this.addAjaxResults("dataJson", dataJson);
		return AJAX;
	}
	
	public CrAnalyMacIdxService getCrAnalyMacIdxService()
	{
		return crAnalyMacIdxService;
	}
	public void setCrAnalyMacIdxService(CrAnalyMacIdxService crAnalyMacIdxService)
	{
		this.crAnalyMacIdxService = crAnalyMacIdxService;
	}

	public CrAnalyMacIdx getCrAnalyMacIdx()
	{
		return crAnalyMacIdx;
	}

	public void setCrAnalyMacIdx(CrAnalyMacIdx crAnalyMacIdx)
	{
		this.crAnalyMacIdx = crAnalyMacIdx;
	}

	public String[] getCrAnalyMacIdxIds()
	{
		return crAnalyMacIdxIds;
	}

	public void setCrAnalyMacIdxIds(String[] crAnalyMacIdxIds)
	{
		this.crAnalyMacIdxIds = crAnalyMacIdxIds;
	}

	
}
