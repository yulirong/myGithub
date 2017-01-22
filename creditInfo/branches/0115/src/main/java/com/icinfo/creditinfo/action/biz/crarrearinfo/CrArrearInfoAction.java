/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-23
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crarrearinfo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icinfo.creditinfo.bean.biz.crabnormalcreditinfo.CrAbnormalCreditInfo;
import com.icinfo.creditinfo.bean.biz.cradvancesuminfo.CrAdvanceSumInfo;
import com.icinfo.creditinfo.bean.biz.crarrearinfo.CrArrearInfo;
import com.icinfo.creditinfo.bean.biz.crbaddebtinfo.CrBadDebtInfo;
import com.icinfo.creditinfo.bean.biz.crcreditsuminfo.CrCreditSumInfo;
import com.icinfo.creditinfo.bean.biz.crguaranteesuminfo.CrGuaranteeSumInfo;
import com.icinfo.creditinfo.bean.biz.crtradesuminfo.CrTradeSumInfo;
import com.icinfo.creditinfo.service.biz.crabnormalcreditinfo.CrAbnormalCreditInfoService;
import com.icinfo.creditinfo.service.biz.cradvancesuminfo.CrAdvanceSumInfoService;
import com.icinfo.creditinfo.service.biz.crarrearinfo.CrArrearInfoService;
import com.icinfo.creditinfo.service.biz.crbaddebtinfo.CrBadDebtInfoService;
import com.icinfo.creditinfo.service.biz.crcreditsuminfo.CrCreditSumInfoService;
import com.icinfo.creditinfo.service.biz.crguaranteesuminfo.CrGuaranteeSumInfoService;
import com.icinfo.creditinfo.service.biz.crtradesuminfo.CrTradeSumInfoService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.icinfo.plugin.common.AESEUtil;
import com.opensymphony.xwork2.Action;

/** 
 * 描述: 逾期和欠费信息 Action 类<br>
 * @author yulirong
 * @date 2015-10-23
 */
public class CrArrearInfoAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrArrearInfoService crArrearInfoService;
	private CrArrearInfo crArrearInfo;
	private String[] crArrearInfoIds;
	private String ajaxUrl;
	private List<CrArrearInfo> crArrearInfoList;
	private String corpid;
	private String fromtable;
	private List<CrAbnormalCreditInfo> crAbnormalCreditInfoList;
	private CrAbnormalCreditInfoService crAbnormalCreditInfoService;
	private List<CrGuaranteeSumInfo> crGuaranteeSumInfoList;
	private CrGuaranteeSumInfoService crGuaranteeSumInfoService;
	private List<CrCreditSumInfo> crCreditSumInfoList;
	private CrCreditSumInfoService crCreditSumInfoService;
	private List<CrBadDebtInfo> crBadDebtInfoList;
	private CrBadDebtInfoService crBadDebtInfoService;
	private List<CrTradeSumInfo> crTradeSumInfoList;
	private CrTradeSumInfoService crTradeSumInfoService;
	private List<CrAdvanceSumInfo> crAdvanceSumInfoList;
	private CrAdvanceSumInfoService crAdvanceSumInfoService;

	/**
	 * 描述: 查看列表
	 * @auther yulirong
	 * @date 2015-10-23
	 * @return
	 * @throws Exception
	 */
	public String doReadCrArrearInfoListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 逾期或欠费信息
	 * @auther yulirong
	 * @date 2015-10-23
	 * @return
	 * @throws Exception
	 */
	public String doReadPermissionCrArrearInfoListJSONAction() throws Exception {
		Map<String,Object> qryMap  = new HashMap<String, Object>();
		qryMap.put("corpid", corpid);
		crArrearInfoList = crArrearInfoService.doGetList(qryMap);
		this.addAjaxResults("dataList", crArrearInfoList);
		return AJAX;
	}
	
	/**
	 * 描述: 银行逾期或欠费信息详情
	 * @auther yulirong
	 * @date 2016-1-6
	 * @return
	 * @throws Exception
	 */
	public String doReadPermissionAllBankArrearListAction() throws Exception {
		Map<String,Object> qryMap  = new HashMap<String, Object>();
		if (StringUtils.isNotBlank(corpid)&&corpid.length() > 16) {
			corpid = AESEUtil.decryptContext(corpid);
		}
		qryMap.put("corpid", corpid);
		if(fromtable.equals("CR_BAD_DEBT_INFO")){
			crBadDebtInfoList = crBadDebtInfoService.doGetList(qryMap);
			this.addAjaxResults("dataList",crBadDebtInfoList);
		}
		if(fromtable.equals("CR_GUARANTEE_SUM_INFO")){
			crGuaranteeSumInfoList = crGuaranteeSumInfoService.doGetList(qryMap);
			this.addAjaxResults("dataList",crGuaranteeSumInfoList);
		}
		if(fromtable.equals("CR_CREDIT_SUM_INFO")){
			crCreditSumInfoList = crCreditSumInfoService.doGetList(qryMap);
			this.addAjaxResults("dataList",crCreditSumInfoList);
		}
		if(fromtable.equals("CR_ADVANCE_SUM_INFO")){
			crAdvanceSumInfoList = crAdvanceSumInfoService.doGetList(qryMap);
			this.addAjaxResults("dataList",crAdvanceSumInfoList);
		}
		if(fromtable.equals("CR_ABNORMAL_CREDIT_INFO")){
			crAbnormalCreditInfoList = crAbnormalCreditInfoService.doGetList(qryMap);
			this.addAjaxResults("dataList",crAbnormalCreditInfoList);
		}
		if(fromtable.equals("CR_TRADE_SUM_INFO")){
			crTradeSumInfoList = crTradeSumInfoService.doGetList(qryMap);
			this.addAjaxResults("dataList",crTradeSumInfoList);
		}
		this.addAjaxResults("skipResult", 0);
		return AJAX;
	}
	
	/**
	 * 描述: 进入逾期或欠费信息详情页面
	 * @auther yulirong
	 * @date 2015-12-7
	 * @return
	 * @throws Exception
	 */
	public String doEnAllArrearListAction() throws Exception {
		Map<String,Object> qryMap  = new HashMap<String, Object>();
		crArrearInfoList = new ArrayList<CrArrearInfo>();
		if (StringUtils.isNotBlank(corpid)&&corpid.length() > 16) {
			corpid = AESEUtil.decryptContext(corpid);
		}
		qryMap.put("corpid", corpid);
		if(fromtable.equals("TEMP_WATER_SEWAGE_DISCHARGE_PAY_ARREAR")||
		   fromtable.equals("TEMP_WATER_PAY_ARREAR")||
		   fromtable.equals("TEMP_GAS_PAY")||
		   fromtable.equals("TEMP_ELEC_PAY_ARREAR")||
		   fromtable.equals("TEMP_TAX_PAY_ARREAR")){
			qryMap.put("fromTable", fromtable);
			fromtable = "arrear";
			crArrearInfoList = crArrearInfoService.doGetAllArrearList(qryMap);
		}
		return SUCCESS;
	}
	
	
	
	
	public CrArrearInfoService getCrArrearInfoService()
	{
		return crArrearInfoService;
	}
	public void setCrArrearInfoService(CrArrearInfoService crArrearInfoService)
	{
		this.crArrearInfoService = crArrearInfoService;
	}

	public CrArrearInfo getCrArrearInfo()
	{
		return crArrearInfo;
	}

	public void setCrArrearInfo(CrArrearInfo crArrearInfo)
	{
		this.crArrearInfo = crArrearInfo;
	}

	public String[] getCrArrearInfoIds()
	{
		return crArrearInfoIds;
	}

	public void setCrArrearInfoIds(String[] crArrearInfoIds)
	{
		this.crArrearInfoIds = crArrearInfoIds;
	}

	public String getAjaxUrl() {
		return ajaxUrl;
	}

	public void setAjaxUrl(String ajaxUrl) {
		this.ajaxUrl = ajaxUrl;
	}

	public List<CrArrearInfo> getCrArrearInfoList() {
		return crArrearInfoList;
	}

	public void setCrArrearInfoList(List<CrArrearInfo> crArrearInfoList) {
		this.crArrearInfoList = crArrearInfoList;
	}

	public String getCorpid() {
		return corpid;
	}

	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}

	public String getFromtable() {
		return fromtable;
	}

	public void setFromtable(String fromtable) {
		this.fromtable = fromtable;
	}

	public CrAbnormalCreditInfoService getCrAbnormalCreditInfoService() {
		return crAbnormalCreditInfoService;
	}

	public void setCrAbnormalCreditInfoService(
			CrAbnormalCreditInfoService crAbnormalCreditInfoService) {
		this.crAbnormalCreditInfoService = crAbnormalCreditInfoService;
	}

	public CrGuaranteeSumInfoService getCrGuaranteeSumInfoService() {
		return crGuaranteeSumInfoService;
	}

	public void setCrGuaranteeSumInfoService(
			CrGuaranteeSumInfoService crGuaranteeSumInfoService) {
		this.crGuaranteeSumInfoService = crGuaranteeSumInfoService;
	}

	public CrCreditSumInfoService getCrCreditSumInfoService() {
		return crCreditSumInfoService;
	}

	public void setCrCreditSumInfoService(
			CrCreditSumInfoService crCreditSumInfoService) {
		this.crCreditSumInfoService = crCreditSumInfoService;
	}

	public CrBadDebtInfoService getCrBadDebtInfoService() {
		return crBadDebtInfoService;
	}

	public void setCrBadDebtInfoService(CrBadDebtInfoService crBadDebtInfoService) {
		this.crBadDebtInfoService = crBadDebtInfoService;
	}

	public CrTradeSumInfoService getCrTradeSumInfoService() {
		return crTradeSumInfoService;
	}

	public void setCrTradeSumInfoService(CrTradeSumInfoService crTradeSumInfoService) {
		this.crTradeSumInfoService = crTradeSumInfoService;
	}

	public CrAdvanceSumInfoService getCrAdvanceSumInfoService() {
		return crAdvanceSumInfoService;
	}

	public void setCrAdvanceSumInfoService(
			CrAdvanceSumInfoService crAdvanceSumInfoService) {
		this.crAdvanceSumInfoService = crAdvanceSumInfoService;
	}

	public List<CrAbnormalCreditInfo> getCrAbnormalCreditInfoList() {
		return crAbnormalCreditInfoList;
	}

	public void setCrAbnormalCreditInfoList(
			List<CrAbnormalCreditInfo> crAbnormalCreditInfoList) {
		this.crAbnormalCreditInfoList = crAbnormalCreditInfoList;
	}

	public List<CrGuaranteeSumInfo> getCrGuaranteeSumInfoList() {
		return crGuaranteeSumInfoList;
	}

	public void setCrGuaranteeSumInfoList(
			List<CrGuaranteeSumInfo> crGuaranteeSumInfoList) {
		this.crGuaranteeSumInfoList = crGuaranteeSumInfoList;
	}

	public List<CrCreditSumInfo> getCrCreditSumInfoList() {
		return crCreditSumInfoList;
	}

	public void setCrCreditSumInfoList(List<CrCreditSumInfo> crCreditSumInfoList) {
		this.crCreditSumInfoList = crCreditSumInfoList;
	}

	public List<CrBadDebtInfo> getCrBadDebtInfoList() {
		return crBadDebtInfoList;
	}

	public void setCrBadDebtInfoList(List<CrBadDebtInfo> crBadDebtInfoList) {
		this.crBadDebtInfoList = crBadDebtInfoList;
	}

	public List<CrTradeSumInfo> getCrTradeSumInfoList() {
		return crTradeSumInfoList;
	}

	public void setCrTradeSumInfoList(List<CrTradeSumInfo> crTradeSumInfoList) {
		this.crTradeSumInfoList = crTradeSumInfoList;
	}

	public List<CrAdvanceSumInfo> getCrAdvanceSumInfoList() {
		return crAdvanceSumInfoList;
	}

	public void setCrAdvanceSumInfoList(List<CrAdvanceSumInfo> crAdvanceSumInfoList) {
		this.crAdvanceSumInfoList = crAdvanceSumInfoList;
	}

	
}
