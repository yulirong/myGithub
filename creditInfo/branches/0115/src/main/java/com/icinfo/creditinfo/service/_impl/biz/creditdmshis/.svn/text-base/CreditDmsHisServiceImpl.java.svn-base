/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author lyf
 * @date 2015-10-30
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.biz.creditdmshis;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;

import com.icinfo.creditinfo.bean.biz.creditdmshis.CreditDmsHis;
import com.icinfo.creditinfo.dao.biz.creditdmshis.CreditDmsHisDao;
import com.icinfo.plugin.common.HxDateUtil;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.biz.creditdmshis.CreditDmsHisService;

/**
 * 
 * 描述: 信用维度历史 Service 实现<br>
 * 
 * @author lyf
 * @date 2015-10-30
 */
public class CreditDmsHisServiceImpl extends HxBaseServiceImpl<CreditDmsHis> implements CreditDmsHisService {

	public CreditDmsHisDao doGetCreditDmsHisDao() {
		return (CreditDmsHisDao) hxBaseDao;
	}

	/**
	 * 
	 * 描述: 获取公司的行业
	 * 
	 * @author LiYaFeng
	 * @date 2015年11月3日
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> doGetDmsEntTrade(Map<String, Object> qryMap) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<CreditDmsHis> creditDmsHisList = doGetCreditDmsHisDao().selectList(qryMap);
		if (creditDmsHisList.size() != 0) {
			resultMap.put("dmsEntTrade", creditDmsHisList.get(0).getDmsEntTrade());
		} else {
			resultMap.put("dmsEntTrade", "");
		}
		return resultMap;
	}

	/**
	 * 
	 * 描述: 获得公司分数、平均分数、日期
	 * 
	 * @author LiYaFeng
	 * @date 2015年11月17日
	 * @param qryMap1
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> doGetDateListAndAvgScoreListAndScoreList(Map<String, Object> qryMap1) throws Exception {
		Map<String, Object> resultMap = new HashMap<String, Object>();
		List<BigDecimal> scoreList = new ArrayList<BigDecimal>();
		List<BigDecimal> avgScoreList = new ArrayList<BigDecimal>();
		List<String> dateList = new ArrayList<String>();
		String name = (String) ServletActionContext.getRequest().getParameter("name");
		List<CreditDmsHis> creditDmsHisList = doGetCreditDmsHisDao().selectDateListAndAvgScoreListAndScoreList(qryMap1);
		if (creditDmsHisList.size() != 0) {
			for (CreditDmsHis crCreditDmsHis : creditDmsHisList) {
				dateList.add(HxDateUtil.dateToString(crCreditDmsHis.getDmsDate()));
				if ("资本实力".equals(name)) {
					avgScoreList.add(crCreditDmsHis.getAvg1());
					scoreList.add(crCreditDmsHis.getDmsDim1Score());
				} else if ("运营能力".equals(name)) {
					avgScoreList.add(crCreditDmsHis.getAvg2());
					scoreList.add(crCreditDmsHis.getDmsDim2Score());
				} else if ("盈利能力".equals(name)) {
					avgScoreList.add(crCreditDmsHis.getAvg3());
					scoreList.add(crCreditDmsHis.getDmsDim3Score());
				} else if ("偿付能力".equals(name)) {
					avgScoreList.add(crCreditDmsHis.getAvg4());
					scoreList.add(crCreditDmsHis.getDmsDim4Score());
				}
				/*
				 * else if("抵押担保".equals(name)){
				 * scoreList.add(crCreditDmsHis.getDmsDim5Score());}
				 */
				else {
					avgScoreList.add(crCreditDmsHis.getAvg5());
					scoreList.add(crCreditDmsHis.getDmsDim5Score());
				}
			}
		}
		resultMap.put("avgScoreList", avgScoreList);
		resultMap.put("scoreList", scoreList);
		resultMap.put("dateList", dateList);
		return resultMap;
	}
   /**
    * 
    * 描述:得到本期与上一期的信用评分
    * @author  LiYaFeng
    * @date 2015年11月25日 
    * @param qryMap
    * @return
    */
	@Override
	public List<BigDecimal> doGetScoreListByCopyId(Map<String, Object> qryMap) {
		return doGetCreditDmsHisDao().selectScoreListByCopyId(qryMap);
	}

}
