/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-09
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.analy.cranalymacidx;

import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.icinfo.creditinfo.bean.analy.cranalymacidx.CrAnalyMacIdx;
import com.icinfo.creditinfo.dao.analy.cranalymacidx.CrAnalyMacIdxDao;
import com.icinfo.plugin.common.DateUtil;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.analy.cranalymacidx.CrAnalyMacIdxService;
/**
 * 
 * 描述: 经济指数风险指数统计表 Service 实现<br>
 * @author myw
 * @date 2015-11-09
 */
public class CrAnalyMacIdxServiceImpl extends HxBaseServiceImpl<CrAnalyMacIdx> implements CrAnalyMacIdxService
{
	
	/**
	 * 描述:获取经济指数与信贷风险指数
	 * @author 马亚伟
	 * @date 2015-11-09
	 * @param qryMap
	 * @return
	 */
	@Override
	public JSONArray doGetLateMacIdxJson(Map<String, Object> qryMap) throws Exception {
		CrAnalyMacIdx crAnalyMacIdx = doGetCrAnalyMacIdxDao().doGetLateMacIdx(qryMap);
		if(crAnalyMacIdx==null)return null;
		JSONArray macIdxJsonArr = new JSONArray();
		JSONObject ecomcIdxJson = new JSONObject();
		JSONObject ristIdxJson = new JSONObject();
		JSONObject updateDateJson = new JSONObject();
		ecomcIdxJson.put("name", "景气指数");
		ecomcIdxJson.put("value", crAnalyMacIdx.getIdxEcomcValue());
		ristIdxJson.put("name", "信贷风险指数");
		ristIdxJson.put("value", crAnalyMacIdx.getIdxRistValue());
		updateDateJson.put("updateDate", DateUtil.dateToString(crAnalyMacIdx.getIdxCreateDate(), "yyyy-MM-dd"));
		macIdxJsonArr.add(ecomcIdxJson);
		macIdxJsonArr.add(ristIdxJson);
		macIdxJsonArr.add(updateDateJson);
		
		return macIdxJsonArr;
	}

	public CrAnalyMacIdxDao doGetCrAnalyMacIdxDao()
	{
		return (CrAnalyMacIdxDao)hxBaseDao;
	}
}
