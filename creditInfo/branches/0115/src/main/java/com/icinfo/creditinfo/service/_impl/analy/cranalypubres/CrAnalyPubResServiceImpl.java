/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-07
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.analy.cranalypubres;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.icinfo.creditinfo.bean.analy.cranalypubres.CrAnalyPubRes;
import com.icinfo.creditinfo.dao.analy.cranalypubres.CrAnalyPubResDao;
import com.icinfo.plugin.common.HxDateUtil;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.analy.cranalypubres.CrAnalyPubResService;
/**
 * 
 * 描述: 公共资源统计表 Service 实现<br>
 * @author myw
 * @date 2015-11-07
 */
public class CrAnalyPubResServiceImpl extends HxBaseServiceImpl<CrAnalyPubRes> implements CrAnalyPubResService
{
	
	/**
	 * 描述：获得公共资源的统计数据
	 * @author 马亚伟
	 * @date 2015-11-07
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public JSONObject doGetAnalyPubResByType(Map<String, Object> qryMap)
			throws Exception {
		
		//趋势图数据
		List<CrAnalyPubRes> crAnalyPubResList = doGetCrAnalyPubResDao().selectAnalyPubResByType(qryMap);
		if(crAnalyPubResList==null||crAnalyPubResList.size()==0) return null;
		List<String> timeList = new ArrayList<String>();
		List<BigDecimal> analyPubResTotal = new ArrayList<BigDecimal>();
		
		Map<String,BigDecimal> tempMap = new HashMap<String, BigDecimal>();
		String start = crAnalyPubResList.get(0).getBalancePeriod(); 
		String end = crAnalyPubResList.get(crAnalyPubResList.size()-1).getBalancePeriod(); 
		timeList = HxDateUtil.getDateStrList(start, end);
		if(timeList==null||timeList.size()==0)return null;
		//统计数据置零
		for (String dateStr : timeList) {
			tempMap.put(dateStr, new BigDecimal(0));
		}
		//保存数据
		for (CrAnalyPubRes crPubRes : crAnalyPubResList) {
			String dateStr = crPubRes.getBalancePeriod();
			dateStr = dateStr.substring(0, 4)+"-"+dateStr.substring(4);
			tempMap.put(dateStr, crPubRes.getPresentAmountTotal());
		}
		//获得取统计集合
		for (String dateStr : timeList) {
			analyPubResTotal.add(tempMap.get(dateStr));
		}

		Map<String,Object> analyPubResMap = new HashMap<String, Object>();
		analyPubResMap.put("timeList", timeList);
		analyPubResMap.put("dataList",analyPubResTotal);

		//区域图数据
		List<CrAnalyPubRes> crAnalyPubResZoneList = doGetCrAnalyPubResDao().selectZonePubResByType(qryMap); 
		List<String> yearList = new ArrayList<String>();
		
		Map<String,Object> mapData = new HashMap<String, Object>();
		if(crAnalyPubResZoneList!=null&&crAnalyPubResZoneList.size()!=0){
			//解析区域公共资源的统计年份
			BigDecimal maxTotal = new BigDecimal(0);
			BigDecimal minTotal = crAnalyPubResZoneList.get(0).getPresentAmountTotal();
			for(CrAnalyPubRes pubResZone :crAnalyPubResZoneList){
				BigDecimal amountTotal = pubResZone.getPresentAmountTotal();
				if(maxTotal.compareTo(amountTotal)<0){
					maxTotal = amountTotal;
				}
				if(minTotal.compareTo(amountTotal)>0){
					minTotal = amountTotal;
				}
				if(yearList.contains(pubResZone.getBalancePeriod()))continue;
				yearList.add(pubResZone.getBalancePeriod());
			}
			//封装区域公共资源数据
			for(String year : yearList){
				JSONArray dataArr = new JSONArray();
				JSONObject pubResZoneData;
				for(CrAnalyPubRes pubResZone :crAnalyPubResZoneList){
					if(year.equals(pubResZone.getBalancePeriod())){
						//封装数据
						pubResZoneData = new JSONObject();
						pubResZoneData.put("name", pubResZone.getAnalyZoneName());
						pubResZoneData.put("value", pubResZone.getPresentAmountTotal());
						dataArr.add(pubResZoneData);
					}
				}
				mapData.put(year, dataArr);
			}
			mapData.put("yearList", yearList);
			mapData.put("maxTotal", maxTotal);
			mapData.put("minTotal", minTotal);
			//添加数据
			analyPubResMap.put("mapData", mapData);
		}
		
		JSONObject json = new JSONObject().fromObject(analyPubResMap);
		return json;
	}

	public CrAnalyPubResDao doGetCrAnalyPubResDao()
	{
		return (CrAnalyPubResDao)hxBaseDao;
	}
}
