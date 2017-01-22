/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-11-06
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.analy.cranalyzone;

import java.math.BigDecimal;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.icinfo.creditinfo.bean.analy.cranalyzone.CrAnalyZone;
import com.icinfo.creditinfo.dao.analy.cranalyzone.CrAnalyZoneDao;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.analy.cranalyzone.CrAnalyZoneService;
/**
 * 
 * 描述: 地域分布 Service 实现<br>
 * @author zhuyong
 * @date 2015-11-06
 */
public class CrAnalyZoneServiceImpl extends HxBaseServiceImpl<CrAnalyZone> implements CrAnalyZoneService
{
	/**
	 * 描述：构建返回参数
	 * 
	 * @author zhuyong
	 * @date 2015-11-06
	 * @param zoneList
	 * @return
	 * @throws Exception
	 */
	public JSONArray doBuildDataList(List<CrAnalyZone> zoneList,String typeName) throws Exception{
		if(zoneList==null || zoneList.size()==0 || StringUtils.isBlank(typeName)){
			return null;
		}
		JSONArray arr = new JSONArray();
		JSONObject obj = new JSONObject();
		for (CrAnalyZone zone : zoneList) {
			if(StringUtils.isNotBlank(zone.getZoneName())){
				obj.put("name", zone.getZoneName());
				if(typeName.equals("企业数量")){
					obj.put("value", zone.getZoneCorpCount());
				}else {
					obj.put("value", zone.getZoneManCount());
				}
				arr.add(obj);
				obj = new JSONObject();
			}
		}
		return arr;
	}
	
	/***
	 * 描述：构建返回值-总量
	 * 
	 * @author zhuyong
	 * @param zoneList
	 * @param typeName
	 * @return
	 * @throws Exception
	 */
	public BigDecimal doBuildTotalNum(List<CrAnalyZone> zoneList,String typeName) throws Exception{
		if(zoneList==null || zoneList.size()==0 || StringUtils.isBlank(typeName)){
			return new BigDecimal(0);
		}
		BigDecimal rst = new BigDecimal(0);
		for (CrAnalyZone zone : zoneList) {
			if(StringUtils.isNotBlank(zone.getZoneCode())&&zone.getZoneCode().contains("330682")){
				if(typeName.equals("企业数量")){
					rst = rst.add(zone.getZoneCorpCount()==null?new BigDecimal(0):zone.getZoneCorpCount());
				}else {
					rst = rst.add(zone.getZoneManCount()==null?new BigDecimal(0):zone.getZoneManCount());
				}
			}
		}
		return rst;
	}

	/**
	 * 描述：获取企业总数
	 * 
	 * @author yulirong
	 * @date 2015-11-09
	 * @param zoneList
	 * @return
	 * @throws Exception
	 */
	public BigDecimal doGetAllEntNum(List<CrAnalyZone> zoneList) throws Exception{
		BigDecimal big = new BigDecimal(0);
		for(CrAnalyZone list:zoneList){
			big = big.add(list.getZoneCorpCount());
		}
		return big;
	}
	
	public CrAnalyZoneDao doGetCrAnalyZoneDao()
	{
		return (CrAnalyZoneDao)hxBaseDao;
	}
}
