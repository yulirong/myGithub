/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-03
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.biz.crgaspay;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.icinfo.creditinfo.bean.biz.crelecpay.CrElecPay;
import com.icinfo.creditinfo.bean.biz.crgaspay.CrGasPay;
import com.icinfo.creditinfo.dao.biz.crgaspay.CrGasPayDao;
import com.icinfo.plugin.common.HxDateUtil;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.biz.crgaspay.CrGasPayService;
/**
 * 
 * 描述: 用气量信息表 Service 实现<br>
 * @author myw
 * @date 2015-11-03
 */
public class CrGasPayServiceImpl extends HxBaseServiceImpl<CrGasPay> implements CrGasPayService
{
	
	/**
	 * 描述：获取用气量统计信息
	 * @author 马亚伟
	 * @date 2015-11-02
	 * @param qryMap
	 * @return JSONArray
	 * @throws Exception
	 */
	@Override
	public JSONObject doGetAnalyGasPayList(Map<String, Object> qryMap)
			throws Exception {
		//结果集
		Map<String,Object> resultMap = new HashMap<String, Object>();
		//获得按时间排序的用电量统计集合
		List<CrGasPay> analyGasPayLsit = doGetCrGasPayDao().selectAnalyGasPayList(qryMap);
		if(analyGasPayLsit==null||analyGasPayLsit.size()==0) return null;
		List<String> timeList = new ArrayList<String>();
		String beginDate = analyGasPayLsit.get(0).getAnalyMeterReadingDateStr();
		String endDate = analyGasPayLsit.get(analyGasPayLsit.size()-1).getAnalyMeterReadingDateStr();
		timeList = HxDateUtil.getDateStrList(beginDate, endDate);
		//解析数据
		Map<String, BigDecimal> tempMap = new HashMap<String, BigDecimal>(); 
		for (String dateStr : timeList) {
			tempMap.put(dateStr, new BigDecimal(0));
		}
		for (CrGasPay crGasPay : analyGasPayLsit) {
			tempMap.put(crGasPay.getAnalyMeterReadingDateStr(), crGasPay.getAnalyPresentAmountTotal());
		}
		List<BigDecimal> gasPresentAmountTotal = new ArrayList<BigDecimal>();
		for (String dateStr : timeList) {
			gasPresentAmountTotal.add(tempMap.get(dateStr));
		}
		resultMap.put("timeList", timeList);
		resultMap.put("dataList",gasPresentAmountTotal);
		resultMap.put("entName", analyGasPayLsit.get(0).getEntName());
		JSONObject json = new JSONObject().fromObject(resultMap);
		return json;
	}

	public CrGasPayDao doGetCrGasPayDao()
	{
		return (CrGasPayDao)hxBaseDao;
	}
}
