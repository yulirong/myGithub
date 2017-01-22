/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-03
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.biz.crwatersewagedischargepay;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.icinfo.creditinfo.bean.biz.crwatersewagedischargepay.CrWaterSewageDischargePay;
import com.icinfo.creditinfo.dao.biz.crwatersewagedischargepay.CrWaterSewageDischargePayDao;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.biz.crwatersewagedischargepay.CrWaterSewageDischargePayService;
/**
 * 
 * 描述: 污水排放信息表 Service 实现<br>
 * @author myw
 * @date 2015-11-03
 */
public class CrWaterSewageDischargePayServiceImpl extends HxBaseServiceImpl<CrWaterSewageDischargePay> implements CrWaterSewageDischargePayService
{
	
	/**
	 * 描述：获取排污水量统计信息
	 * @author 马亚伟
	 * @date 2015-11-03
	 * @param qryMap
	 * @return JSONArray
	 * @throws Exception
	 */
	@Override
	public JSONArray doGetAnalyWaterSewageDischargePayList(
			Map<String, Object> qryMap) throws Exception {
		//获得按时间排序的排污水量统计集合
		List<CrWaterSewageDischargePay> analyWaterSewageDischargePayLsit = doGetCrWaterSewageDischargePayDao().selectAnalyWaterSewageDischargePayList(qryMap);
		if(analyWaterSewageDischargePayLsit==null) return null;
		List<String> timeList = new ArrayList<String>();
		List<BigDecimal> waterSewageDisAmountTotal = new ArrayList<BigDecimal>();
		for (CrWaterSewageDischargePay crWaterSewageDischargePay : analyWaterSewageDischargePayLsit) {
			timeList.add(crWaterSewageDischargePay.getAnalyMeterReadingDateStr());
			waterSewageDisAmountTotal.add(crWaterSewageDischargePay.getAnalySewageDisAmountTotal());
		}
		Map<String,Object> analyWaterSewageDischargePayMap = new HashMap<String, Object>();
		analyWaterSewageDischargePayMap.put("timeList", timeList);
		analyWaterSewageDischargePayMap.put("dataList",waterSewageDisAmountTotal);
		JSONArray json = new JSONArray().fromObject(analyWaterSewageDischargePayMap);
		return json;
	}

	public CrWaterSewageDischargePayDao doGetCrWaterSewageDischargePayDao()
	{
		return (CrWaterSewageDischargePayDao)hxBaseDao;
	}
}
