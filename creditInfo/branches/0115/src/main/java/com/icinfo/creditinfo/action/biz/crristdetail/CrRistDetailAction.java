/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-03
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crristdetail;

import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.json.JSONArray;
import org.apache.commons.lang3.StringUtils;

import com.icinfo.creditinfo.action.HxBaseAction;
import com.icinfo.creditinfo.bean.biz.crristdetail.CrRistDetail;
import com.icinfo.creditinfo.pagination.AjaxPagination;
import com.icinfo.creditinfo.service.biz.crristdetail.CrRistDetailService;
import com.icinfo.plugin.common.AESEUtil;
import com.icinfo.plugin.common.HxDateUtil;
import com.icinfo.plugin.pagination.WebPagination;
import com.icinfo.plugin.pagination.context.PaginationContext;
import com.opensymphony.xwork2.Action;

/** 
 * 描述: 风险指数明细 Action 类<br>
 * @author gaotong
 * @date 2015-11-03
 */
public class CrRistDetailAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	private CrRistDetailService crRistDetailService;
	private CrRistDetail crRistDetail;
	private List<CrRistDetail> crRistDetailList;
	private String[] crRistDetailIds;
	
	private List<CrRistDetail> ristList;
	private List<CrRistDetail> ristTypeList;
	private String ajaxUrl;
	private String levelStr;
	private String fixparam_risttype;
	private String corpid;
	/**
	 * 
	 * 描述: 进入企业风险限制类预警页面
	 * @author LiYaFeng
	 * @date 2015年11月3日 
	 * @return
	 */
	public String doEnRestrictedWarningAction() throws Exception {
		fixparam_risttype="1";//表示限制类预警
		return Action.SUCCESS;
	}
	/**
	 * 
	 * 描述: 进入企业风险警示类预警页面
	 * @author LiYaFeng
	 * @date 2015年11月3日 
	 * @return
	 */
	public String doEnEarlyWarningAction() throws Exception {
		fixparam_risttype="2";//表示警示类预警
		return Action.SUCCESS;
	}
	/**
	 * 
	 * 描述: 进入企业风险关注类预警页面
	 * @author LiYaFeng
	 * @date 2015年11月7日 
	 * @return
	 * @throws Exception
	 */
	public String doEnAttWarningAction() throws Exception {
		fixparam_risttype="3";//表示关注类预警
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 风险企业预警清单
	 * @auther gaotong
	 * @date 2015-11-03
	 * @return
	 * @throws Exception
	 */
	public String doReadRistTypeListJSONAction() throws Exception 
	{
		Map<String,Object> qryMap=doGetRequestMap();
		String option=(String) qryMap.get("timeRange");
		String fixparam_risttype=(String) qryMap.get("fixparam_risttype");
		if("1".equals(fixparam_risttype))
			qryMap.put("idxLevel", "提示");
		else if("2".equals(fixparam_risttype))
			qryMap.put("idxLevel", "警示");
		else if("3".equals(fixparam_risttype))
			qryMap.put("idxLevel", "关注");
		String theEndTime=null;
		String theStartTime=null;
		if(!option.equals("0")){
			if(option.equals("1")) {
				theEndTime=HxDateUtil.getCurrentDate();
				theStartTime=HxDateUtil.dateToString(HxDateUtil.getFirstDayByMonth());
			}else if(option.equals("2")){
				theEndTime=HxDateUtil.dateToString(HxDateUtil.getAfterDateByDays(HxDateUtil.getFirstDayByMonth(), -1));
				theStartTime=HxDateUtil.dateToString(HxDateUtil.getAfterDateByMonths(HxDateUtil.getFirstDayByMonth(), -1));
			}
			qryMap.put("theStartTime", theStartTime+" 00:00:00");
			qryMap.put("theEndTime", theEndTime+" 23:59:59");
		}else{
			if(qryMap.containsKey("theStartTime")&&qryMap.containsKey("theEndTime")){
				qryMap.put("theStartTime", qryMap.get("theStartTime")+" 00:00:00");
				qryMap.put("theEndTime", qryMap.get("theEndTime")+" 23:59:59");
			}
		}
		ristTypeList=crRistDetailService.doGetCountAndNameList(qryMap);
		this.addAjaxResults("dataList", ristTypeList);
		return AJAX;
	}
	/**
	 * 描述: 分页查询-风险企业预警列表
	 * @auther gaotong
	 * @date 2015-11-03
	 * @return
	 * @throws Exception
	 */
	public String doReadWarningListJSONAction() throws Exception {
		PaginationContext context = doGetContextRequestMap();
		context.setPageSize(5);
		context.setNavigationTemplate("ajax.ftl");
		context.setPageParamName("pageNo1");
		Map<String,Object> qryMap=context.getAllRequestMap();
		if(qryMap.get("entName")!=null){
		qryMap.put("entName", URLDecoder.decode(qryMap.get("entName").toString(),"UTF-8"));}	
		String option=(String) qryMap.get("timeRange");
		String fixparam_risttype=(String) qryMap.get("fixparam_risttype");
		if("1".equals(fixparam_risttype))
			qryMap.put("idxLevel", "提示");
		else if("2".equals(fixparam_risttype))
			qryMap.put("idxLevel", "警示");
		else if("3".equals(fixparam_risttype))
			qryMap.put("idxLevel", "关注");
		String theEndTime=null;
		String theStartTime=null;
		if(!option.equals("0")){
			if(option.equals("1")) {
				theEndTime=HxDateUtil.getCurrentDate();
				theStartTime=HxDateUtil.dateToString(HxDateUtil.getFirstDayByMonth());
			}else if(option.equals("2")){
				theEndTime=HxDateUtil.dateToString(HxDateUtil.getAfterDateByDays(HxDateUtil.getFirstDayByMonth(), -1));
				theStartTime=HxDateUtil.dateToString(HxDateUtil.getAfterDateByMonths(HxDateUtil.getFirstDayByMonth(), -1));
			}
			qryMap.put("theStartTime", theStartTime+" 00:00:00");
			qryMap.put("theEndTime", theEndTime+" 23:59:59");
		}else{
			if(qryMap.containsKey("theStartTime")&&qryMap.containsKey("theEndTime")){
				qryMap.put("theStartTime", qryMap.get("theStartTime")+" 00:00:00");
				qryMap.put("theEndTime", qryMap.get("theEndTime")+" 23:59:59");
			}
		}
		context.getSkipResult();
		ristList = crRistDetailService.doGetExtendCrRistDetailList(qryMap);
	    AjaxPagination pagination = new AjaxPagination(ristList,crRistDetailService.doGetExtendCrRistDetailListTotal(qryMap),context);
		pagination.setDataUrl(ajaxUrl);
		pagination.setShowId("ajax1");
		this.addAjaxResults("dataList", pagination.getDataList());
		this.addAjaxResults("skipResult", pagination.getSkipResult());
		this.addAjaxResults("paginationHtml", pagination.getPageHtml());
		return AJAX;
	}

	/**
	 * desc：获取风险指数解读数据
	 * 
	 * @author zhuyong
	 * @date 2015-11-05
	 * @return
	 */
	public String doGetRistIndexRecordsListJSONAction() throws Exception{
		if(StringUtils.isBlank(corpid)){
			return SUCCESS;
		}
		PaginationContext context = doGetContextRequestMap();
		Map<String,Object> qryMap = context.getAllRequestMap();
		if(qryMap.containsKey("levelStr")){
			levelStr = qryMap.get("levelStr").toString();
			qryMap.put("idxLevelList",doBuildLevelParam(qryMap.get("levelStr").toString()));
		}
		WebPagination webPagination=new WebPagination(crRistDetailService.doGetRistIndexRecordList(qryMap), 
					crRistDetailService.doGetRistIndexRecordTotal(qryMap), context);
	    this.addJstlResults("dataList", webPagination.getDataList());
		this.addJstlResults("paginationHtml", webPagination.getPageHtml());
		this.addJstlResults("currentPage", webPagination.getCurrentPage());
		this.addJstlResults("pageSize", webPagination.getPageSize());
		this.addJstlResults("skipResult", webPagination.getSkipResult());
		return SUCCESS;
	}
	
	/**
	 * 描述：构建等级查询参数
	 * 
	 * @author zhuyong
	 * @param levelStr
	 * @return
	 * @throws Exception
	 */
	private List<String> doBuildLevelParam(String levelStr) throws Exception{
		List<String> levelList = new ArrayList<String>();
		if(StringUtils.isBlank(levelStr)){
			return levelList;
		}
		String[] levels = levelStr.split(",");
		for (String string : levels) {
			levelList.add(string);
		}
		return levelList;
	}
	
	
	/**
	 * 描述：获取值得关心的风险类型
	 * 
	 * @author zhuyong
	 * @date 2015-11-09
	 * @return
	 * @throws Exception
	 */
	public String doGetRistTypeJSONAction() throws Exception{
		List<CrRistDetail> ristList = crRistDetailService.doGetRistTypeList(null);
		Map<String,Object> rstMap = crRistDetailService.doBuildRistTypeDataList(ristList);
		this.addAjaxResults("dataList", (JSONArray)rstMap.get("dataList"));
		this.addAjaxResults("legendList", (JSONArray)rstMap.get("legendList"));
		return AJAX;
	}
	
	/**
	 * 描述：获取风险提示
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	public String doGetRistByCorpidAction() throws Exception{
		if(StringUtils.isBlank(corpid)){
			this.addAjaxResults("ristList",null);
			return AJAX;
		}
		if (corpid.length() > 16) {
			corpid = AESEUtil.decryptContext(corpid);
		}
		Map<String,Object> qryMap = new HashMap<String, Object>();
		qryMap.put("corpid", corpid);
		this.addAjaxResults("ristList",crRistDetailService.doGetRistIndexRecordList(qryMap));
		return AJAX;
	}
	
	/**
	 * 获取企业风险提示
	 * 
	 * @author yulirong
	 * @date 2015-11-13
	 * @return
	 * @throws Exception
	 */
	public String doGetEntRistListAction() throws Exception{
		Map<String, Object> qryMap = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(corpid) && corpid.length() > 16) {
			corpid = AESEUtil.decryptContext(corpid);
		}
		qryMap.put("corpid", corpid);
		List<CrRistDetail> ristList = crRistDetailService.doGetList(qryMap);
		if(ristList.size()>0){
			for(int i=0;i<ristList.size();i++){
				this.addAjaxResults("rist"+i,ristList.get(i).getIdxName());
			}
		}
		return AJAX;
	}
	
	public CrRistDetailService getCrRistDetailService()
	{
		return crRistDetailService;
	}
	public void setCrRistDetailService(CrRistDetailService crRistDetailService)
	{
		this.crRistDetailService = crRistDetailService;
	}

	public CrRistDetail getCrRistDetail()
	{
		return crRistDetail;
	}

	public void setCrRistDetail(CrRistDetail crRistDetail)
	{
		this.crRistDetail = crRistDetail;
	}

	public String[] getCrRistDetailIds()
	{
		return crRistDetailIds;
	}

	public void setCrRistDetailIds(String[] crRistDetailIds)
	{
		this.crRistDetailIds = crRistDetailIds;
	}


	public List<CrRistDetail> getRistList() {
		return ristList;
	}
	public void setRistList(List<CrRistDetail> ristList) {
		this.ristList = ristList;
	}
	public List<CrRistDetail> getRistTypeList() {
		return ristTypeList;
	}
	public void setRistTypeList(List<CrRistDetail> ristTypeList) {
		this.ristTypeList = ristTypeList;
	}
	public List<CrRistDetail> getCrRistDetailList() {
		return crRistDetailList;
	}

	public void setCrRistDetailList(List<CrRistDetail> crRistDetailList) {
		this.crRistDetailList = crRistDetailList;
	}


	public String getAjaxUrl() {
		return ajaxUrl;
	}

	public void setAjaxUrl(String ajaxUrl) {
		this.ajaxUrl = ajaxUrl;
	}
	public String getLevelStr() {
		return levelStr;
	}
	public void setLevelStr(String levelStr) {
		this.levelStr = levelStr;
	}

	public String getFixparam_risttype() {
		return fixparam_risttype;
	}

	public void setFixparam_risttype(String fixparam_risttype) {
		this.fixparam_risttype = fixparam_risttype;
	}
	public String getCorpid() {
		return corpid;
	}
	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}
	
}
