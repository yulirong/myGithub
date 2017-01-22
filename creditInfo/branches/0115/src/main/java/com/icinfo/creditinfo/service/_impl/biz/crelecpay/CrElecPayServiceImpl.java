/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-03
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.biz.crelecpay;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.icinfo.creditinfo.bean.biz.crelecpay.CrElecPay;
import com.icinfo.creditinfo.dao.biz.crelecpay.CrElecPayDao;
import com.icinfo.plugin.common.HxDateUtil;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.biz.crelecpay.CrElecPayService;
/**
 * 
 * 描述: 用电量信息表 Service 实现<br>
 * @author myw
 * @date 2015-11-03
 */
public class CrElecPayServiceImpl extends HxBaseServiceImpl<CrElecPay> implements CrElecPayService
{
	
	/**
	 * 描述：获取用电量统计信息
	 * @author 马亚伟
	 * @date 2015-11-02
	 * @param qryMap
	 * @return JSONObject
	 * @throws Exception
	 */
	@SuppressWarnings("static-access")
	@Override
	public JSONObject doGetAnalyElecPayList(Map<String, Object> qryMap)
			throws Exception {
		//结果集
		Map<String,Object> resultMap = new HashMap<String, Object>();
		//获得按时间排序的用电量统计集合
		List<CrElecPay> analyElecPayLsit = doGetCrElecPayDao().selectAnalyElecPayList(qryMap);
		if(analyElecPayLsit==null||analyElecPayLsit.size()==0) return null;
		List<String> timeList = new ArrayList<String>();
		String beginDate = analyElecPayLsit.get(0).getAnalyRecordDateStr();
		String endDate = analyElecPayLsit.get(analyElecPayLsit.size()-1).getAnalyRecordDateStr();
		timeList = HxDateUtil.getDateStrList(beginDate, endDate);
		//解析数据
		Map<String, BigDecimal> tempMap = new HashMap<String, BigDecimal>(); 
		for (String dateStr : timeList) {
			tempMap.put(dateStr, new BigDecimal(0));
		}
		for (CrElecPay crElecPay : analyElecPayLsit) {
			tempMap.put(crElecPay.getAnalyRecordDateStr(), crElecPay.getAnalyElecConsumptionTotal());
		}
		List<BigDecimal> elecConsumptionTotal = new ArrayList<BigDecimal>();
		for (String dateStr : timeList) {
			elecConsumptionTotal.add(tempMap.get(dateStr));
		}
		resultMap.put("timeList", timeList);
		resultMap.put("dataList",elecConsumptionTotal);
		resultMap.put("entName",analyElecPayLsit.get(0).getEntName());
		JSONObject json = new JSONObject().fromObject(resultMap);
		return json;
	}

	
	
	/** 
	 * 描述: TODO
	 * @auther gqf
	 * @date 2015年12月24日 
	 * @param qryMap
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<CrElecPay> doGetCrElecPayList(Map<String, Object> qryMap) throws Exception {
		return doGetCrElecPayDao().selectAnalyElecPayList(qryMap);
	}

	/** 
	 * 描述: 经信委接口
	 * @auther gqf
	 * @date 2015年12月28日 
	 * @param qryMap
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<CrElecPay> doGetServiceCrElecPayList(Map<String, Object> qryMap)
			throws Exception {
		return doGetCrElecPayDao().selectCrElecPayListByJxwService(qryMap);
	}

	/** 
	 * 描述: TODO
	 * @auther gqf
	 * @date 2015年12月30日 
	 * @param qryMap
	 * @return
	 * @throws Exception 
	 */
	@Override
	public Integer doGetServiceCrElecPayTotal(Map<String, Object> qryMap)
			throws Exception {
		 return doGetCrElecPayDao().selectCrElecPayListByJxwServiceTotal(qryMap);
	}



	public CrElecPayDao doGetCrElecPayDao()
	{
		return (CrElecPayDao)hxBaseDao;
	}
}
