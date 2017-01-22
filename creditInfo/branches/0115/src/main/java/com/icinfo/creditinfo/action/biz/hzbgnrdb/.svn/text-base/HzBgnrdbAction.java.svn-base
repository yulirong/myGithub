/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-10-31
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.hzbgnrdb;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import net.sf.json.JSONArray;

import com.icinfo.creditinfo.bean.biz.crentbaseinfo.CrEntBaseInfo;
import com.icinfo.creditinfo.bean.biz.hzbgnrdb.HzBgnrdb;
import com.icinfo.creditinfo.bean.biz.hzbgnrdb.RegCapHistory;
import com.icinfo.creditinfo.pagination.AjaxPagination;
import com.icinfo.creditinfo.service.biz.crentbaseinfo.CrEntBaseInfoService;
import com.icinfo.creditinfo.service.biz.hzbgnrdb.HzBgnrdbService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.icinfo.plugin.common.AESEUtil;
import com.icinfo.plugin.pagination.WebPagination;
import com.icinfo.plugin.pagination.context.PaginationContext;

/** 
 * 描述: 变更记录 Action 类<br>
 * @author zhuyong
 * @date 2015-10-31
 */
public class HzBgnrdbAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private HzBgnrdbService hzBgnrdbService;
	private CrEntBaseInfoService crEntBaseInfoService;
	private HzBgnrdb hzBgnrdb;
	private String corpid;
	private String ajaxUrl;
	/**
	 * 描述: 获取资本历史数据
	 * 
	 * @author zhuyong
	 * @date 2015-10-31
	 * @return
	 * @throws Exception
	 */
	public String doReadEntAnalyRegCapJSONAction() throws Exception {
		if(StringUtils.isBlank(corpid)){
			return null;
		}
		if (corpid.length() > 16) {
			corpid = AESEUtil.decryptContext(corpid);
		}
		Map<String,Object> qryMap = new HashMap<String, Object>();
		qryMap.put("corpid", corpid);
		CrEntBaseInfo baseInfo = crEntBaseInfoService.doGetList(qryMap).get(0);//基本信息
		qryMap.put("nbxh", corpid);
		qryMap.put("bgsx", "05");
		List<HzBgnrdb> bgList = hzBgnrdbService.doGetList(qryMap);//变更记录
		List<RegCapHistory> hisList = hzBgnrdbService.doBuildDataList(baseInfo, bgList);
		this.addAjaxResults("catgtype", baseInfo.getEntTypeCatg()=="21"?"万美元":"万元");
		this.addAjaxResults("dataList", JSONArray.fromObject(hisList));
		return AJAX;
	}
	
	
	/**
	 * 描述：获取变更历史信息
	 * 
	 * @author zhuyong
	 * @date 2015-11-10
	 * @return
	 * @throws Exception
	 */
	public String doReadRegCapHistoryListJSONAction() throws Exception{
		PaginationContext context = doGetContextRequestMap();
		Map<String,Object> qryMap = context.getAllRequestMap();
		corpid = qryMap.get("corpid").toString();
		if(StringUtils.isBlank(corpid)){
			return SUCCESS;
		}
		if(corpid.length() > 16) {
			corpid = AESEUtil.decryptContext(corpid);
		}
		qryMap.put("nbxh", corpid);
		WebPagination webPagination=new WebPagination(hzBgnrdbService.doGetRegCapHisList(qryMap), 
					hzBgnrdbService.doGetRegCapHisTotal(qryMap), context);
	    this.addJstlResults("dataList", webPagination.getDataList());
		this.addJstlResults("paginationHtml", webPagination.getPageHtml());
		this.addJstlResults("currentPage", webPagination.getCurrentPage());
		this.addJstlResults("pageSize", webPagination.getPageSize());
		this.addJstlResults("skipResult", webPagination.getSkipResult());
		return SUCCESS;
	}
	
	
	public String getCorpid() {
		return corpid;
	}

	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}

	public HzBgnrdbService getHzBgnrdbService()
	{
		return hzBgnrdbService;
	}
	public void setHzBgnrdbService(HzBgnrdbService hzBgnrdbService)
	{
		this.hzBgnrdbService = hzBgnrdbService;
	}

	public HzBgnrdb getHzBgnrdb()
	{
		return hzBgnrdb;
	}

	public void setHzBgnrdb(HzBgnrdb hzBgnrdb)
	{
		this.hzBgnrdb = hzBgnrdb;
	}


	public CrEntBaseInfoService getCrEntBaseInfoService() {
		return crEntBaseInfoService;
	}


	public void setCrEntBaseInfoService(CrEntBaseInfoService crEntBaseInfoService) {
		this.crEntBaseInfoService = crEntBaseInfoService;
	}


	public String getAjaxUrl() {
		return ajaxUrl;
	}


	public void setAjaxUrl(String ajaxUrl) {
		this.ajaxUrl = ajaxUrl;
	}


	
}
