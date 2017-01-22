/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-11-16
 * @version 1.0
 */
package com.icinfo.creditinfo.action.analy.cranalyentrelation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;

import com.icinfo.creditinfo.bean.analy.cranalyentrelation.CrAnalyEntRelation;
import com.icinfo.creditinfo.bean.biz.crcreditdms.CrCreditDms;
import com.icinfo.creditinfo.bean.biz.crentbaseinfo.CrEntBaseInfo;
import com.icinfo.creditinfo.bean.biz.relationalnet.CorpNode;
import com.icinfo.creditinfo.service.analy.cranalyentrelation.CrAnalyEntRelationService;
import com.icinfo.creditinfo.service.biz.crcreditdms.CrCreditDmsService;
import com.icinfo.creditinfo.service.biz.crentbaseinfo.CrEntBaseInfoService;
import com.icinfo.creditinfo.service.biz.crristdetail.CrRistDetailService;
import com.icinfo.creditinfo.service.biz.relationalnet.RelationalNetService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.icinfo.plugin.common.AESEUtil;
import com.icinfo.plugin.common.HxDateUtil;
import com.icinfo.plugin.common.HxRequestUtil;
import com.icinfo.plugin.common.StringUtil;

/** 
 * 描述: 企业关系 Action 类<br>
 * @author zhuyong
 * @date 2015-11-16
 */
public class CrAnalyEntRelationAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrAnalyEntRelationService crAnalyEntRelationService;
	private CrAnalyEntRelation crAnalyEntRelation;
	private String[] crAnalyEntRelationIds;
	private String corpid;
	private RelationalNetService relationalNetService;
	private String targetCorpid;
	private CrEntBaseInfo crEntBaseInfo;
	private CrCreditDms crCreditDms;
	private Integer creditRate;
	private CrEntBaseInfoService crEntBaseInfoService; 
	private CrCreditDmsService crCreditDmsService;
	private CrRistDetailService crRistDetailService;
	
	
	public String doEnCrAnalyEntRelationListAction() throws Exception{
		if (StringUtils.isNotBlank(corpid) && corpid.length() > 16) {
			corpid = AESEUtil.decryptContext(corpid);
		}
		Map<String,Object> qryMap = new HashMap<String, Object>();
		qryMap.put("corpid", corpid);
		crEntBaseInfo = crEntBaseInfoService.doGetById(corpid);
		qryMap.put("dmsEntTrade", crEntBaseInfo.getEntRealTrade());
		crCreditDms  =crCreditDmsService.doGetById(corpid);//获取企业信用评分
		if(crCreditDms!=null){
		crCreditDms.setAvgDmsScore(crCreditDmsService.getAvgScoreListByTrade(qryMap).getAvgDmsScore());}
		qryMap.put("theStartTime",HxDateUtil.getNowMonthStartDate());
	    creditRate = crRistDetailService.doGetTotal(qryMap);//获取企业风险提示总数
		return SUCCESS;
	}

	/**
	 * 描述: 分页查询信息
	 * @auther zhuyong
	 * @date 2015-11-16
	 * @return
	 * @throws Exception
	 */
	public String doReadCrAnalyEntRelationListJSONAction() throws Exception {
		this.addAjaxResults("result", "error");
		if(StringUtils.isBlank(corpid)){
			return AJAX;
		}
		if(corpid.length() > 16) {
			corpid = AESEUtil.decryptContext(corpid);
		}
		List<CrAnalyEntRelation> dataList = new ArrayList<CrAnalyEntRelation>();
		Map<String,Object> qryMap = new HashMap<String, Object>();
		qryMap.put("nbxh", corpid);
		dataList = crAnalyEntRelationService.doGetList(qryMap);
		if(dataList.size()==0||StringUtils.isBlank(dataList.get(0).getQno())){
			return AJAX;
		}
		qryMap = new HashMap<String, Object>();
		qryMap.put("qno", dataList.get(0).getQno());
		crAnalyEntRelation = crAnalyEntRelationService.doCountEntTotal(qryMap);
		List<CrAnalyEntRelation> countList = crAnalyEntRelationService.doGetRistLevelTotal(qryMap);
		Map<String,Object> levelMap = doBuildRistCount(countList);
		dataList = crAnalyEntRelationService.doGetList(qryMap);
		Map<String,Object> rstMap = crAnalyEntRelationService.doBuildDataList(dataList,corpid);
		this.addAjaxResults("result", "right");
		this.addAjaxResults("totalNum",crAnalyEntRelation.getTotalNum() );
		this.addAjaxResults("entNum",crAnalyEntRelation.getEntNum());
		this.addAjaxResults("perNum",crAnalyEntRelation.getPerNum());
		this.addAjaxResults("level1",levelMap.get("level1"));
		this.addAjaxResults("level2",levelMap.get("level2"));
		this.addAjaxResults("level3",levelMap.get("level3"));
		this.addAjaxResults("nodeList", (JSONArray)rstMap.get("nodeList"));
		this.addAjaxResults("linkList", (JSONArray)rstMap.get("linkList"));
		return AJAX;
	}
	
	/** 
	 * 描述: 路径搜索
	 * @auther gqf
	 * @date 2015年11月25日 
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public String doGetSeachNodePathJSON() throws Exception{
		this.addAjaxResults("matchflag", "error");
		if(targetCorpid.length() > 16) {
			targetCorpid = AESEUtil.decryptContext(targetCorpid);
		}
		if(corpid.length() > 16){
			corpid = AESEUtil.decryptContext(corpid);
		}
		if(targetCorpid.equals(corpid)){
			return AJAX;
		}
		/** 匹配两家企业是否在同一关系网*/
		Map<String, Object> qryMap = new HashMap<String, Object>();
		qryMap.put("sfzjhm",targetCorpid);
		List<CrAnalyEntRelation> targetList1 = crAnalyEntRelationService.doGetList(qryMap);
		qryMap.clear();
		qryMap.put("nbxh",targetCorpid);
		List<CrAnalyEntRelation> targetList = crAnalyEntRelationService.doGetList(qryMap);
		targetList.addAll(targetList1);
		if(targetList==null || targetList.size()==0){
			return AJAX;
		}
		String targetQno = targetList.get(0).getQno();
		qryMap.clear();
		qryMap.put("nbxh", corpid);
		List<CrAnalyEntRelation> CrAnalyEntRelatioList = crAnalyEntRelationService.doGetList(qryMap);
		if(CrAnalyEntRelatioList==null || CrAnalyEntRelatioList.size()==0){
			return AJAX;
		}
		String sourceQno = CrAnalyEntRelatioList.get(0).getQno();
		if(StringUtils.isBlank(sourceQno) || !targetQno.equals(sourceQno)){
			return AJAX;
		}
		
		/**获取同一群号的数据*/
		qryMap.clear();
		qryMap.put("qno", sourceQno);
		CrAnalyEntRelatioList = crAnalyEntRelationService.doGetList(qryMap);
		String begin = corpid; 
		String end = targetCorpid; 
		Map<String,Object> rstMap  = crAnalyEntRelationService.doGetSearchNodePath(CrAnalyEntRelatioList, begin, end);
		if(Integer.parseInt(rstMap.get("num").toString()) > 200000){
			return AJAX;
		}
		List<String> corpidList = StringUtil.strSplitAddToList(HxRequestUtil.getAllParam(ServletActionContext.getRequest()).get("corpidArr[]"));//前台传来的corpid数组、用于过滤
		this.addAjaxResults("rists",  relationalNetService.doBuildRelationRist((List<CorpNode>)rstMap.get("nodeList"),corpidList,"search"));
		this.addAjaxResults("nodeList", (JSONArray)rstMap.get("nodeList"));
		this.addAjaxResults("linkList", (JSONArray)rstMap.get("linkList"));
		this.addAjaxResults("matchflag", "success");
		return AJAX;
	}
	
	
	/**
	 * 描述：获取全网预警页面页面两个点之间的路径
	 * 
	 * @author zhuyong
	 * @date 2015-11-25
	 * @return
	 * @throws Exception
	 */
	public String doGetTwoNodePathJSONAction() throws Exception{
		if(corpid.length() > 16) {
			corpid = AESEUtil.decryptContext(corpid);
		}
		if(targetCorpid.length() > 16) {
			targetCorpid = AESEUtil.decryptContext(targetCorpid);
		}
		if(targetCorpid.equals(corpid)){
			return AJAX;
		}
		Map<String, Object> qryMap = new HashMap<String, Object>();
		qryMap.put("nbxh", corpid);
		List<CrAnalyEntRelation> CrAnalyEntRelatioList = crAnalyEntRelationService.doGetList(qryMap);
		qryMap.clear();
		qryMap.put("qno", "-1");
		if(CrAnalyEntRelatioList!=null && CrAnalyEntRelatioList.size()>0){
			qryMap.put("qno", CrAnalyEntRelatioList.get(0).getQno());
		}
		CrAnalyEntRelatioList = crAnalyEntRelationService.doGetList(qryMap);
		String begin = corpid; 
		String end = targetCorpid; 
		Map<String,Object> rstMap  = crAnalyEntRelationService.doGetSearchNodePath(CrAnalyEntRelatioList, begin, end);
		if(Integer.parseInt(rstMap.get("num").toString()) > 200000){
			this.addAjaxResults("matchflag", "error");
			return AJAX;
		}
		this.addAjaxResults("nodeList", (JSONArray)rstMap.get("nodeList"));
		this.addAjaxResults("linkList", (JSONArray)rstMap.get("linkList"));
		this.addAjaxResults("matchflag", "success");
		return AJAX;
	}
	
	/**
	 * 描述：构建风险不同级别的风险提示种类
	 * 
	 * @param countList
	 * @return
	 * @throws Exception
	 */
	private Map<String,Object> doBuildRistCount(List<CrAnalyEntRelation> countList) throws Exception{
		 Map<String,Object> rstMap = new HashMap<String, Object>();
		 rstMap.put("level1", 0);
		 rstMap.put("level2", 0);
		 rstMap.put("level3", 0);
		 if(countList==null||countList.size()==0){
			 return rstMap;
		 }
		 for (CrAnalyEntRelation ent : countList) {
			if(StringUtils.isNotBlank(ent.getRistLevel())){
				if(ent.getRistLevel().equals("1")){
					rstMap.put("level1", ent.getRistTotal());
				}else if(ent.getRistLevel().equals("2")){
					rstMap.put("level2", ent.getRistTotal());
				}else if(ent.getRistLevel().equals("3")){
					rstMap.put("level3", ent.getRistTotal());
				}
			}
		}
		 return rstMap;
	}
	
	public CrAnalyEntRelationService getCrAnalyEntRelationService()
	{
		return crAnalyEntRelationService;
	}
	public void setCrAnalyEntRelationService(CrAnalyEntRelationService crAnalyEntRelationService)
	{
		this.crAnalyEntRelationService = crAnalyEntRelationService;
	}

	public CrAnalyEntRelation getCrAnalyEntRelation()
	{
		return crAnalyEntRelation;
	}

	public void setCrAnalyEntRelation(CrAnalyEntRelation crAnalyEntRelation)
	{
		this.crAnalyEntRelation = crAnalyEntRelation;
	}

	public String[] getCrAnalyEntRelationIds()
	{
		return crAnalyEntRelationIds;
	}

	public void setCrAnalyEntRelationIds(String[] crAnalyEntRelationIds)
	{
		this.crAnalyEntRelationIds = crAnalyEntRelationIds;
	}

	public String getCorpid() {
		return corpid;
	}

	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}

	public String getTargetCorpid() {
		return targetCorpid;
	}

	public void setTargetCorpid(String targetCorpid) {
		this.targetCorpid = targetCorpid;
	}

	public RelationalNetService getRelationalNetService() {
		return relationalNetService;
	}

	public void setRelationalNetService(RelationalNetService relationalNetService) {
		this.relationalNetService = relationalNetService;
	}

	public CrEntBaseInfo getCrEntBaseInfo() {
		return crEntBaseInfo;
	}

	public void setCrEntBaseInfo(CrEntBaseInfo crEntBaseInfo) {
		this.crEntBaseInfo = crEntBaseInfo;
	}

	public CrCreditDms getCrCreditDms() {
		return crCreditDms;
	}

	public void setCrCreditDms(CrCreditDms crCreditDms) {
		this.crCreditDms = crCreditDms;
	}

	public Integer getCreditRate() {
		return creditRate;
	}

	public void setCreditRate(Integer creditRate) {
		this.creditRate = creditRate;
	}

	public CrEntBaseInfoService getCrEntBaseInfoService() {
		return crEntBaseInfoService;
	}

	public void setCrEntBaseInfoService(CrEntBaseInfoService crEntBaseInfoService) {
		this.crEntBaseInfoService = crEntBaseInfoService;
	}

	public CrCreditDmsService getCrCreditDmsService() {
		return crCreditDmsService;
	}

	public void setCrCreditDmsService(CrCreditDmsService crCreditDmsService) {
		this.crCreditDmsService = crCreditDmsService;
	}

	public CrRistDetailService getCrRistDetailService() {
		return crRistDetailService;
	}

	public void setCrRistDetailService(CrRistDetailService crRistDetailService) {
		this.crRistDetailService = crRistDetailService;
	}

	
}
