/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author lyf
 * @date 2015-10-30
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.creditdmshis;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.icinfo.creditinfo.action.HxBaseAction;
import com.icinfo.creditinfo.bean.biz.crcreditdms.CrCreditDms;
import com.icinfo.creditinfo.bean.biz.creditdmshis.CreditDmsHis;
import com.icinfo.creditinfo.service.biz.crcreditdms.CrCreditDmsService;
import com.icinfo.creditinfo.service.biz.creditdmshis.CreditDmsHisService;
import com.icinfo.plugin.common.AESEUtil;
import com.icinfo.plugin.common.HxDateUtil;
import com.opensymphony.xwork2.Action;


/** 
 * 描述: 信用维度历史 Action 类<br>
 * @author lyf
 * @date 2015-10-30
 */
public class CreditDmsHisAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CreditDmsHisService creditDmsHisService;
	private CreditDmsHis creditDmsHis;
	private String corpid;// 内部序号
	private String entName;
	private int flag;
	private CrCreditDmsService crCreditDmsService;
	private CrCreditDms crCreditDms;
	private String[] creditDmsHisIds;

	/**
	 * 描述: 查看列表
	 * @auther lyf
	 * @date 2015-10-30
	 * @return
	 * @throws Exception
	 */
	public String doReadCreditDmsHisListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	/**
	 * 
	 * 描述: 进入信用历史图示页面
	 * 
	 * @author LiYaFeng
	 * @date 2015年10月29日
	 * @return
	 * @throws Exception
	 */
	public String doEnCreditHistoryAction() throws Exception {
		if (StringUtils.isNotBlank(corpid) && corpid.length() > 16) {
			corpid = AESEUtil.decryptContext(corpid);
		}
		crCreditDms = crCreditDmsService.doGetById(corpid);
		if (crCreditDms == null) {
			corpid = AESEUtil.encryptContext(corpid);
			return NONE;
		}
		Map<String, Object> qryMap = new HashMap<String, Object>();
		qryMap.put("corpid", corpid);
		int total = creditDmsHisService.doGetTotal(qryMap);
		List<BigDecimal> scoreList=creditDmsHisService.doGetScoreListByCopyId(qryMap);//得到本期与上一期的信用评分
		List<CreditDmsHis> creditDmsHisList=creditDmsHisService.doGetList(qryMap);
		String percent="";
		if(scoreList.size()==2){
		double CurrentScore=scoreList.get(0).doubleValue();
		double lastScore=scoreList.get(1).doubleValue();
		double rate=(CurrentScore-lastScore)/lastScore;
		NumberFormat nf = NumberFormat.getPercentInstance();
		nf.setMinimumFractionDigits(2);//设置保留小数位
		nf.setRoundingMode(RoundingMode.HALF_UP); //设置舍入模式
		 percent = nf.format(rate);}
		if(scoreList.size()==0&&creditDmsHisList.size()!=0){
			flag=0;
		}else if(creditDmsHisList.size()==0&&scoreList.size()!=0) {
			flag=-1;
		}else if(scoreList.size()==0&&creditDmsHisList.size()==0){
			flag=-2;
		}else{
			flag=1;
		}
		ServletActionContext.getRequest().setAttribute("total", total);
		ServletActionContext.getRequest().setAttribute("rate", percent);
		return SUCCESS;
	}
	/**
	 * 描述: 查询历史评分信息
	 * 
	 * @auther lyf
	 * @date 2015-10-30
	 * @return
	 * @throws Exception
	 */
	public String doReadCrCreditResultHisListJSONAction() throws Exception {
		if (crCreditDms.getCorpid() != null && !"".equals(crCreditDms.getCorpid())) {
			Map<String, Object> qryMap = new HashMap<String, Object>();
			qryMap.put("corpid", crCreditDms.getCorpid());
			qryMap.put("orderByClause", "dms_date asc");
			List<CreditDmsHis> creditList = creditDmsHisService.doGetList(qryMap);
			List<String> dateList = new ArrayList<String>();
			List<BigDecimal> scoreList = new ArrayList<BigDecimal>();
			List<BigDecimal> scoreList1 = new ArrayList<BigDecimal>();
			List<BigDecimal> scoreList2 = new ArrayList<BigDecimal>();
			List<BigDecimal> scoreList3 = new ArrayList<BigDecimal>();
			if(creditList.size()!=0){
				for (CreditDmsHis c : creditList) {
					String date = HxDateUtil.dateToString(c.getDmsDate(), "yyyy-MM-dd");
					dateList.add(date);
					scoreList.add(c.getDmsScore());
					scoreList1.add(new BigDecimal(30));
					scoreList2.add(new BigDecimal(75));
					scoreList3.add(new BigDecimal(100));
				}
			}
			this.addAjaxResults("dateList", JSONArray.fromObject(dateList));
			this.addAjaxResults("scoreList", JSONArray.fromObject(scoreList));
			this.addAjaxResults("scoreList1", JSONArray.fromObject(scoreList1));
			this.addAjaxResults("scoreList2", JSONArray.fromObject(scoreList2));
			this.addAjaxResults("scoreList3", JSONArray.fromObject(scoreList3));
		}
		return AJAX;
	}
	/**
	 * 
	 * 描述: 查询某个纬度历史的分数与日期
	 * @author LiYaFeng
	 * @date 2015年10月31日 
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public String doReadCreditDmsHisListJSONAction() throws Exception {
		if(creditDmsHis.getCorpid()!=null&&!"".equals(creditDmsHis.getCorpid())){
		Map<String,Object> qryMap = new HashMap<String,Object>();
		qryMap.put("corpid", creditDmsHis.getCorpid());
		qryMap.put("orderByClause", "dms_date asc");
		List<String> dateList=new ArrayList<String>();//日期集合
		List<BigDecimal> scoreList=new ArrayList<BigDecimal>();//公司各个纬度分数集
		List<BigDecimal> avgScoreList=new ArrayList<BigDecimal>();//平均各个纬度分数集
		//获取结果集
		Map<String, Object> resultMap=creditDmsHisService.doGetDmsEntTrade(qryMap);
		String dmsEntTrade=(String) resultMap.get("dmsEntTrade");
		if(!dmsEntTrade.equals("")){
			
		Map<String,Object> qryMap1 = new HashMap<String,Object>();
		qryMap1.put("dmsEntTrade", dmsEntTrade);
		qryMap1.put("corpid", creditDmsHis.getCorpid());
		qryMap1.put("orderByClause", "dms_date asc");
		Map<String, Object> resultMap1=creditDmsHisService.doGetDateListAndAvgScoreListAndScoreList(qryMap1);
		dateList=(List<String>) resultMap1.get("dateList");
		avgScoreList=(List<BigDecimal>) resultMap1.get("avgScoreList");
		scoreList=(List<BigDecimal>) resultMap1.get("scoreList");
		}
		this.addAjaxResults("scoreList",JSONArray.fromObject(scoreList));
		this.addAjaxResults("dateList",JSONArray.fromObject(dateList));
		this.addAjaxResults("avgScoreList",JSONArray.fromObject(avgScoreList));
		}
		return AJAX;
	}
	
	/**
	 * 描述: 进入增加(修改)页面
	 * @auther lyf
	 * @date 2015-10-30
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditCreditDmsHisAction() throws Exception {
		if(creditDmsHis!=null && creditDmsHis.getId()!=null){
			creditDmsHis =  creditDmsHisService.doGetById(creditDmsHis.getId());
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 增加(修改)信息
	 * @auther lyf
	 * @date 2015-10-30
	 * @return
	 * @throws Exception
	 */
	public String doAddAndEditCreditDmsHisAction() throws Exception {
		if(creditDmsHis!=null && creditDmsHis.getId()!=null){
		    creditDmsHisService.doMod(creditDmsHis);
		}
		else{
			creditDmsHisService.doSave(creditDmsHis);
		}
		this.addAjaxResults("success", "true");
		return AJAX;
	}

	/**
	 * 描述: 批量删除
	 * @auther lyf
	 * @date 2015-10-30
	 * @return
	 * @throws Exception
	 */
	public String doDelCreditDmsHisAction() throws Exception{
		creditDmsHisService.doRmBatch(creditDmsHisIds);
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	public CreditDmsHisService getCreditDmsHisService()
	{
		return creditDmsHisService;
	}
	public void setCreditDmsHisService(CreditDmsHisService creditDmsHisService)
	{
		this.creditDmsHisService = creditDmsHisService;
	}

	public CreditDmsHis getCreditDmsHis()
	{
		return creditDmsHis;
	}

	public void setCreditDmsHis(CreditDmsHis creditDmsHis)
	{
		this.creditDmsHis = creditDmsHis;
	}

	public String[] getCreditDmsHisIds()
	{
		return creditDmsHisIds;
	}

	public void setCreditDmsHisIds(String[] creditDmsHisIds)
	{
		this.creditDmsHisIds = creditDmsHisIds;
	}
	public String getCorpid() {
		return corpid;
	}
	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}
	public String getEntName() {
		return entName;
	}
	public void setEntName(String entName) {
		this.entName = entName;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
	public CrCreditDmsService getCrCreditDmsService() {
		return crCreditDmsService;
	}
	public void setCrCreditDmsService(CrCreditDmsService crCreditDmsService) {
		this.crCreditDmsService = crCreditDmsService;
	}
	public CrCreditDms getCrCreditDms() {
		return crCreditDms;
	}
	public void setCrCreditDms(CrCreditDms crCreditDms) {
		this.crCreditDms = crCreditDms;
	}
    
	
}
