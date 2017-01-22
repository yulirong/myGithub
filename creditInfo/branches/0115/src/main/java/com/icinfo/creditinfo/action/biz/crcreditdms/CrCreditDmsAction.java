/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-10-30
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.crcreditdms;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.icinfo.creditinfo.action.HxBaseAction;
import com.icinfo.creditinfo.bean.biz.crcreditdms.CrCreditDms;
import com.icinfo.creditinfo.service.biz.crcreditdms.CrCreditDmsService;

/** 
 * 描述: 信用维度 Action 类<br>
 * @author gaotong
 * @date 2015-10-30
 */
public class CrCreditDmsAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrCreditDmsService crCreditDmsService;
	private CrCreditDms crCreditDms;
	private String[] crCreditDmsIds;
	/**
	 * 描述: 查询纬度信息
	 * @auther liyafeng
	 * @date 2015-10-30
	 * @return
	 * @throws Exception
	 */
	public String doReadCrCreditDmsListJSONAction() throws Exception {
		if(crCreditDms.getCorpid()!=null&&!"".equals(crCreditDms.getCorpid())){
		String corpid=crCreditDms.getCorpid();
		List<BigDecimal> scorelist=new ArrayList<BigDecimal>();
		List<BigDecimal> avgScoreList=new ArrayList<BigDecimal>();
		Map<String, Object> paramQryMap = new HashMap<String, Object>();
		paramQryMap.put("corpid", corpid);
		List<CrCreditDms> crCreditDmsList=crCreditDmsService.doGetList(paramQryMap);
		if(crCreditDmsList.size()!=0){
		crCreditDms=crCreditDmsList.get(0);
		scorelist.add(crCreditDms.getDmsDim1Score());
		scorelist.add(crCreditDms.getDmsDim2Score());
		scorelist.add(crCreditDms.getDmsDim3Score());
		scorelist.add(crCreditDms.getDmsDim4Score());
		scorelist.add(crCreditDms.getDmsDim5Score());
		Map<String,Object> qryMap = new HashMap<String,Object>();
		qryMap.put("dmsEntTrade", crCreditDms.getDmsEntTrade());
		CrCreditDms crCreditDmsAvg=crCreditDmsService.getAvgScoreListByTrade(qryMap);
		avgScoreList.add(crCreditDmsAvg.getAvgDmsDim1Score());
		avgScoreList.add(crCreditDmsAvg.getAvgDmsDim2Score());
		avgScoreList.add(crCreditDmsAvg.getAvgDmsDim3Score());
		avgScoreList.add(crCreditDmsAvg.getAvgDmsDim4Score());
		avgScoreList.add(crCreditDmsAvg.getAvgDmsDim5Score());
		}
		this.addAjaxResults("scorelist",JSONArray.fromObject(scorelist));
		this.addAjaxResults("avgScoreList",JSONArray.fromObject(avgScoreList));
		}
		return AJAX;
	}
	/**
	 * 描述: 查看信用得分
	 * @auther gaotong
	 * @date 2015-10-31
	 * @return
	 * @throws Exception
	 */
	public String doReadCrCreditResultByIdJSONAction() throws Exception {
		if(crCreditDms.getCorpid()!=null&&!"".equals(crCreditDms.getCorpid())){
			crCreditDms=crCreditDmsService.doGetById(crCreditDms.getCorpid());
			if(crCreditDms==null){
				return AJAX;
			}
			Map<String,Object> qryMap = new HashMap<String,Object>();
			qryMap.put("dmsEntTrade", crCreditDms.getDmsEntTrade());
			CrCreditDms crCreditDmsAvg=crCreditDmsService.getAvgScoreListByTrade(qryMap);
			this.addAjaxResults("dmsScore", crCreditDms.getDmsScore().toString());
			this.addAjaxResults("dmsAvgScore", crCreditDmsAvg.getAvgDmsScore().toString());
		}
		return AJAX;
	}
	public CrCreditDmsService getCrCreditDmsService()
	{
		return crCreditDmsService;
	}
	public void setCrCreditDmsService(CrCreditDmsService crCreditDmsService)
	{
		this.crCreditDmsService = crCreditDmsService;
	}
	public CrCreditDms getCrCreditDms()
	{
		return crCreditDms;
	}

	public void setCrCreditDms(CrCreditDms crCreditDms)
	{
		this.crCreditDms = crCreditDms;
	}

	public String[] getCrCreditDmsIds()
	{
		return crCreditDmsIds;
	}

	public void setCrCreditDmsIds(String[] crCreditDmsIds)
	{
		this.crCreditDmsIds = crCreditDmsIds;
	}

	
}
