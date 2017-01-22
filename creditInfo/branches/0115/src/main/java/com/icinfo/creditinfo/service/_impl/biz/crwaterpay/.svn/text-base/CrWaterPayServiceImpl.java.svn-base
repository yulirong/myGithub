/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-03
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.biz.crwaterpay;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.icinfo.creditinfo.bean.biz.crelecpay.CrElecPay;
import com.icinfo.creditinfo.bean.biz.crwaterpay.CrWaterPay;
import com.icinfo.creditinfo.dao.biz.crwaterpay.CrWaterPayDao;
import com.icinfo.plugin.common.HxDateUtil;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.biz.crwaterpay.CrWaterPayService;
/**
 * 
 * 描述: 用水量信息统计表 Service 实现<br>
 * @author myw
 * @date 2015-11-03
 */
public class CrWaterPayServiceImpl extends HxBaseServiceImpl<CrWaterPay> implements CrWaterPayService
{
	
	/**
	 * 描述：获取用水量统计信息
	 * @author 马亚伟
	 * @date 2015-11-03
	 * @param qryMap
	 * @return JSONObject
	 * @throws Exception
	 */
	@Override
	public JSONObject doGetAnalyWaterPayList(Map<String, Object> qryMap)
			throws Exception {
		
		//结果集
		Map<String,Object> resultMap = new HashMap<String, Object>();
		//获得按时间排序的用水量统计集合
		List<CrWaterPay> analyWaterPayLsit = doGetCrWaterPayDao().selectAnalyWaterPayList(qryMap);
		if(analyWaterPayLsit==null||analyWaterPayLsit.size()==0) return null;
		List<String> timeList = new ArrayList<String>();
		String beginDate = analyWaterPayLsit.get(0).getAnalyRecordDateStr();
		String endDate = analyWaterPayLsit.get(analyWaterPayLsit.size()-1).getAnalyRecordDateStr();
		timeList = HxDateUtil.getDateStrList(beginDate, endDate);
		//解析数据
		Map<String, BigDecimal> tempMap = new HashMap<String, BigDecimal>(); 
		for (String dateStr : timeList) {
			tempMap.put(dateStr, new BigDecimal(0));
		}
		for (CrWaterPay crWaterPay : analyWaterPayLsit) {
			tempMap.put(crWaterPay.getAnalyRecordDateStr(), crWaterPay.getAnalyWaterConsumptionTotal());
		}
		List<BigDecimal> waterConsumptionTotal = new ArrayList<BigDecimal>();
		for (String dateStr : timeList) {
			waterConsumptionTotal.add(tempMap.get(dateStr));
		}
		resultMap.put("timeList", timeList);
		resultMap.put("dataList",waterConsumptionTotal);
		resultMap.put("entName", analyWaterPayLsit.get(0).getEntName());
		JSONObject json = new JSONObject().fromObject(resultMap);
		return json;
	}

	public CrWaterPayDao doGetCrWaterPayDao()
	{
		return (CrWaterPayDao)hxBaseDao;
	}
}
