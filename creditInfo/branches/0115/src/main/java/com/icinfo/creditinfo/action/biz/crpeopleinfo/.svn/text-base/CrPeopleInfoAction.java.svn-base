/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-10-21
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crpeopleinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icinfo.creditinfo.action.HxBaseAction;
import com.icinfo.creditinfo.bean.biz.crdcdyapplyinfo.CrDcdyApplyinfo;
import com.icinfo.creditinfo.bean.biz.crequityall.CrEquityAll;
import com.icinfo.creditinfo.bean.biz.crleprep.CrLepRep;
import com.icinfo.creditinfo.bean.biz.crpeopleinfo.CrEntInfo;
import com.icinfo.creditinfo.bean.biz.crpunish.CrPunish;
import com.icinfo.creditinfo.bean.biz.hzqydsjlry.HzQydsjlry;
import com.icinfo.creditinfo.pagination.AjaxPagination;
import com.icinfo.creditinfo.service.biz.crdcdyapplyinfo.CrDcdyApplyinfoService;
import com.icinfo.creditinfo.service.biz.crleprep.CrLepRepService;
import com.icinfo.creditinfo.service.biz.crpeopleinfo.CrPeopleInfoService;
import com.icinfo.creditinfo.service.biz.crpunish.CrPunishService;
import com.icinfo.creditinfo.service.biz.crsequestrateall.CrSequestrateAllService;
import com.icinfo.creditinfo.service.biz.hzqydsjlry.HzQydsjlryService;
import com.icinfo.creditinfo.service.biz.mortgagereg.MortgageRegService;
import com.icinfo.plugin.common.AESEUtil;
import com.icinfo.plugin.pagination.context.PaginationContext;
import com.opensymphony.xwork2.Action;

/** 
 * 描述: 个人详情 Action 类<br>
 * @author gaotong
 * @date 2015-10-22
 */
public class CrPeopleInfoAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	private CrPeopleInfoService crPeopleInfoService;//个人详情Action
	private CrPunishService crPunishService;
	private MortgageRegService mortgageRegService;
	private CrDcdyApplyinfoService crDcdyApplyinfoService;
	private CrSequestrateAllService crSequestrateAllService;
	private CrLepRepService crLepRepService;
	
	private String ajaxUrl;
	private List<CrEntInfo> crEntInfoList;
	private List<CrPunish> crPunishList;

	private List<CrDcdyApplyinfo> crDcdyApplyinfoList;
	private List<CrEquityAll> crEquityAllList;
	private String sfzjhm;//身份证件号码
	private String corpid;
	private String crSequestrateHouseExit;//有无房产查封
	private String crSequestrateLandExit;//有无土地查封
	private String crSequestrateExit;//有无查封
	private String mortgageRegExit;//有无抵押
	private Integer crEntInfoCount;//关联企业数量
	private Integer crPunishCount;//关联处罚数量
	private CrLepRep crLepRep=new CrLepRep();
	private String xm;
	private String xb;
	private HzQydsjlry hzQydsjlry;
	private HzQydsjlryService hzQydsjlryService;
	private List<HzQydsjlry> hzQydsjlryList;
	
	/**
	 * 描述: 个人基本信息及查封信息
	 * @auther gaotong
	 * @date 2015-10-22
	 * @return
	 * @throws Exception
	 */
	public String doReadCrPeopleInfo() throws Exception{
		if(StringUtils.isNotBlank(corpid)&&corpid.length()>16){
		 corpid =AESEUtil.decryptContext(corpid);
		}
		if(StringUtils.isNotBlank(sfzjhm)&&sfzjhm.length()>30){
			sfzjhm =AESEUtil.decryptContext(sfzjhm);
			}
		Map<String,Object> qryMap  =new HashMap<String,Object>();
		if(StringUtils.isNotBlank(sfzjhm)){
			qryMap.put("sfzjhm", sfzjhm);
			hzQydsjlryList = hzQydsjlryService.doGetList(qryMap);
			if(hzQydsjlryList.size()!=0){
				hzQydsjlry = hzQydsjlryList.get(0);
				xm = hzQydsjlry.getXm();
				xb = hzQydsjlry.getXb();
			}else{
				sfzjhm="";
				return Action.NONE;
			}
			sfzjhm=AESEUtil.encryptContext(sfzjhm);
		}else{
			qryMap.put("corpid", corpid);
		List<CrLepRep> crLepRepList=crLepRepService.doGetList(qryMap);
		if(crLepRepList!=null&&crLepRepList.size()==1){
			crLepRep=crLepRepList.get(0);
		}
		if(crLepRep==null||StringUtils.isBlank(crLepRep.getLepCertNo())){
			sfzjhm="";
			return Action.NONE;
		}
		qryMap.clear();
		qryMap.put("sfzjhm", crLepRep.getLepCertNo());
		sfzjhm=AESEUtil.encryptContext(crLepRep.getLepCertNo());
		}
		crEntInfoCount=crPeopleInfoService.doGetCrEntTotal(qryMap);
		crPunishCount=crPunishService.doGetTotal(qryMap);
		qryMap.put("importFrom", "建设局");
		crSequestrateHouseExit= crSequestrateAllService.doGetTotal(qryMap)==0?"无":"有";
		qryMap.put("importFrom", "国土资源局");
		crSequestrateLandExit= crSequestrateAllService.doGetTotal(qryMap)==0?"无":"有";
		crSequestrateExit=(crSequestrateHouseExit.equals("有")||crSequestrateLandExit.equals("有"))?"有":"无";
		qryMap.remove("importFrom");
		mortgageRegExit=(mortgageRegService.doGetTotal(qryMap)+crDcdyApplyinfoService.doGetTotal(qryMap))==0?"无":"有";
		return Action.SUCCESS;
	}
	/**
	 * 描述: 个人详情关联企业
	 * @auther gaotong
	 * @date 2015-10-22
	 * @return
	 * @throws Exception
	 */
	public String doReadCrEntInfoListJSONAction() throws Exception{
		PaginationContext context = doGetContextRequestMap();
		context.setPageSize(5);
		context.setNavigationTemplate("ajax.ftl");
		context.setPageParamName("pageNo1");
		Map<String,Object> qryMap  = context.getAllRequestMap();
		qryMap.put("sfzjhm", AESEUtil.decryptContext(qryMap.get("sfzjhm").toString()));
		context.getSkipResult();
		List<CrEntInfo> crEntInfoListTemp = crPeopleInfoService.doGetList(qryMap);
		crEntInfoList=new ArrayList<CrEntInfo>();
		for (CrEntInfo crEntInfo: crEntInfoListTemp) {
			crEntInfo.setCorpid(AESEUtil.encryptContext(crEntInfo.getCorpid()));
			crEntInfoList.add(crEntInfo);
		}
	    AjaxPagination pagination = new AjaxPagination(crEntInfoList,crPeopleInfoService.doGetTotal(qryMap),context);
		pagination.setDataUrl(ajaxUrl);
		pagination.setShowId("ajax1");
		this.addAjaxResults("dataList", pagination.getDataList());
		this.addAjaxResults("skipResult", pagination.getSkipResult());
		this.addAjaxResults("paginationHtml", pagination.getPageHtml());
		return AJAX;
	}


	public List<CrEquityAll> getCrEquityAllList() {
		return crEquityAllList;
	}
	public void setCrEquityAllList(List<CrEquityAll> crEquityAllList) {
		this.crEquityAllList = crEquityAllList;
	}
	public CrPeopleInfoService getCrPeopleInfoService() {
		return crPeopleInfoService;
	}
	public void setCrPeopleInfoService(CrPeopleInfoService crPeopleInfoService) {
		this.crPeopleInfoService = crPeopleInfoService;
	}
	public CrPunishService getCrPunishService() {
		return crPunishService;
	}
	public void setCrPunishService(CrPunishService crPunishService) {
		this.crPunishService = crPunishService;
	}
	public List<CrEntInfo> getCrEntInfoList() {
		return crEntInfoList;
	}
	public void setCrEntInfoList(List<CrEntInfo> crEntInfoList) {
		this.crEntInfoList = crEntInfoList;
	}
	public List<CrPunish> getCrPunishList() {
		return crPunishList;
	}
	public void setCrPunishList(List<CrPunish> crPunishList) {
		this.crPunishList = crPunishList;
	}
	public String getAjaxUrl() {
		return ajaxUrl;
	}

	public void setAjaxUrl(String ajaxUrl) {
		this.ajaxUrl = ajaxUrl;
	}
	public MortgageRegService getMortgageRegService() {
		return mortgageRegService;
	}
	public void setMortgageRegService(MortgageRegService mortgageRegService) {
		this.mortgageRegService = mortgageRegService;
	}
	public String getSfzjhm() {
		return sfzjhm;
	}
	public void setSfzjhm(String sfzjhm) {
		this.sfzjhm = sfzjhm;
	}
	public CrDcdyApplyinfoService getCrDcdyApplyinfoService() {
		return crDcdyApplyinfoService;
	}
	public void setCrDcdyApplyinfoService(
			CrDcdyApplyinfoService crDcdyApplyinfoService) {
		this.crDcdyApplyinfoService = crDcdyApplyinfoService;
	}
	public List<CrDcdyApplyinfo> getCrDcdyApplyinfoList() {
		return crDcdyApplyinfoList;
	}
	public void setCrDcdyApplyinfoList(List<CrDcdyApplyinfo> crDcdyApplyinfoList) {
		this.crDcdyApplyinfoList = crDcdyApplyinfoList;
	}
	public String getCrSequestrateHouseExit() {
		return crSequestrateHouseExit;
	}
	public void setCrSequestrateHouseExit(String crSequestrateHouseExit) {
		this.crSequestrateHouseExit = crSequestrateHouseExit;
	}
	public String getCrSequestrateLandExit() {
		return crSequestrateLandExit;
	}
	public void setCrSequestrateLandExit(String crSequestrateLandExit) {
		this.crSequestrateLandExit = crSequestrateLandExit;
	}
	public CrSequestrateAllService getCrSequestrateAllService() {
		return crSequestrateAllService;
	}
	public void setCrSequestrateAllService(
			CrSequestrateAllService crSequestrateAllService) {
		this.crSequestrateAllService = crSequestrateAllService;
	}
	public String getCrSequestrateExit() {
		return crSequestrateExit;
	}
	public void setCrSequestrateExit(String crSequestrateExit) {
		this.crSequestrateExit = crSequestrateExit;
	}
	public String getMortgageRegExit() {
		return mortgageRegExit;
	}
	public void setMortgageRegExit(String mortgageRegExit) {
		this.mortgageRegExit = mortgageRegExit;
	}
	public Integer getCrEntInfoCount() {
		return crEntInfoCount;
	}
	public void setCrEntInfoCount(Integer crEntInfoCount) {
		this.crEntInfoCount = crEntInfoCount;
	}
	public Integer getCrPunishCount() {
		return crPunishCount;
	}
	public void setCrPunishCount(Integer crPunishCount) {
		this.crPunishCount = crPunishCount;
	}
	public CrLepRepService getCrLepRepService() {
		return crLepRepService;
	}
	public void setCrLepRepService(CrLepRepService crLepRepService) {
		this.crLepRepService = crLepRepService;
	}
	public CrLepRep getCrLepRep() {
		return crLepRep;
	}
	public void setCrLepRep(CrLepRep crLepRep) {
		this.crLepRep = crLepRep;
	}
	public String getCorpid() {
		return corpid;
	}
	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}
	public String getXm() {
		return xm;
	}
	public void setXm(String xm) {
		this.xm = xm;
	}
	public String getXb() {
		return xb;
	}
	public void setXb(String xb) {
		this.xb = xb;
	}
	public HzQydsjlry getHzQydsjlry() {
		return hzQydsjlry;
	}
	public void setHzQydsjlry(HzQydsjlry hzQydsjlry) {
		this.hzQydsjlry = hzQydsjlry;
	}
	public HzQydsjlryService getHzQydsjlryService() {
		return hzQydsjlryService;
	}
	public void setHzQydsjlryService(HzQydsjlryService hzQydsjlryService) {
		this.hzQydsjlryService = hzQydsjlryService;
	}
	public List<HzQydsjlry> getHzQydsjlryList() {
		return hzQydsjlryList;
	}
	public void setHzQydsjlryList(List<HzQydsjlry> hzQydsjlryList) {
		this.hzQydsjlryList = hzQydsjlryList;
	}

	
}
