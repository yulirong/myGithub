/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-09
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crcoderistidx;

import com.icinfo.creditinfo.bean.biz.crcoderistidx.CrCodeRistIdx;
import com.icinfo.creditinfo.service.biz.crcoderistidx.CrCodeRistIdxService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.pagination.Pagination;

/** 
 * 描述: 风险指数明细 Action 类<br>
 * @author liyafeng
 * @date 2015-11-09
 */
public class CrCodeRistIdxAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrCodeRistIdxService crCodeRistIdxService;
	private CrCodeRistIdx crCodeRistIdx;

	/**
	 * 描述: 查看列表
	 * @auther liyafeng
	 * @date 2015-11-09
	 * @return
	 * @throws Exception
	 */
	public String doReadCrCodeRistIdxListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 分页查询信息
	 * @auther liyafeng
	 * @date 2015-11-09
	 * @return
	 * @throws Exception
	 */
	public String doReadCrCodeRistIdxListJSONAction() throws Exception {
		this.addAjaxResults("pagination", new Pagination(crCodeRistIdxService.doGetList(doGetRequestMap()), 
				crCodeRistIdxService.doGetTotal(doGetRequestMap()),pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}
	
	/**
	 * 描述: 进入增加(修改)页面
	 * @auther liyafeng
	 * @date 2015-11-09
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditCrCodeRistIdxAction() throws Exception {
		if(crCodeRistIdx!=null){
			crCodeRistIdx =  crCodeRistIdxService.doGetcrCodeRistIdxById(crCodeRistIdx.getId());
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 增加(修改)信息
	 * @auther liyafeng
	 * @date 2015-11-09
	 * @return
	 * @throws Exception
	 */
	public String doAddAndEditCrCodeRistIdxAction() throws Exception {
		if(crCodeRistIdx!=null&&crCodeRistIdx.getId()!=0){
		    crCodeRistIdxService.doMod(crCodeRistIdx);
		}
		else{
			crCodeRistIdxService.doSaveCrCodeRistIdx(crCodeRistIdx);
		}
		this.addAjaxResults("success", "true");
		return AJAX;
	}

	/**
	 * 描述: 批量删除
	 * @auther liyafeng
	 * @date 2015-11-09
	 * @return
	 * @throws Exception
	 */
	public String doDelCrCodeRistIdxByIdAction() throws Exception{
		crCodeRistIdxService.doRm(crCodeRistIdx.getId());
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	public CrCodeRistIdxService getCrCodeRistIdxService()
	{
		return crCodeRistIdxService;
	}
	public void setCrCodeRistIdxService(CrCodeRistIdxService crCodeRistIdxService)
	{
		this.crCodeRistIdxService = crCodeRistIdxService;
	}

	public CrCodeRistIdx getCrCodeRistIdx()
	{
		return crCodeRistIdx;
	}

	public void setCrCodeRistIdx(CrCodeRistIdx crCodeRistIdx)
	{
		this.crCodeRistIdx = crCodeRistIdx;
	}

}
