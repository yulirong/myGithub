/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author mayawei
 * @date 2015-10-29
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.analy.cranalyentlife;

import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.icinfo.creditinfo.bean.analy.cranalyentlife.CrAnalyEntLife;
import com.icinfo.creditinfo.bean.biz.yccodeindustrytype.YcCodeIndustryType;
import com.icinfo.creditinfo.dao.analy.cranalyentlife.CrAnalyEntLifeDao;
import com.icinfo.plugin.common.HxDateUtil;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.analy.cranalyentlife.CrAnalyEntLifeService;
import com.icinfo.creditinfo.service.biz.yccodeindustrytype.YcCodeIndustryTypeService;
/**
 * 
 * 描述: 企业新生消亡趋势分析 Service 实现<br>
 * @author mayawei
 * @date 2015-10-29
 */
public class CrAnalyEntLifeServiceImpl extends HxBaseServiceImpl<CrAnalyEntLife> implements CrAnalyEntLifeService
{
	private YcCodeIndustryTypeService ycCodeIndustryTypeService	;
	/**
	 * 描述：获得行业新生消亡数据
	 * @author 马亚伟
	 * @date 2015-10-29
	 * @return JSONArray
	 * @throws Exception
	 */
	@Override
	public JSONArray doGetCrAnalyEntLifeJson(Map<String, Object> qryMap) throws Exception {
		
		if(qryMap==null) qryMap = new HashMap<String, Object>();
		Map<String,List<?>> entLifeMap = new HashMap<String, List<?>>();
		List<String> timeList =new ArrayList<String>();
		List<BigDecimal> estNumList =new ArrayList<BigDecimal>();
		List<BigDecimal> dieNumList =new ArrayList<BigDecimal>();
		
		List<CrAnalyEntLife> allEntLifeList = doGetCrAnalyEntLifeDao().selectAnalyEntLifeList(qryMap);
		qryMap.put("entFlag",1);
		List<CrAnalyEntLife> estEntLifeList = doGetCrAnalyEntLifeDao().selectAnalyEntLifeList(qryMap);
		qryMap.put("entFlag",2);
		List<CrAnalyEntLife> dieEntLifeList = doGetCrAnalyEntLifeDao().selectAnalyEntLifeList(qryMap);
		if(allEntLifeList==null || allEntLifeList.size()==0)return null;
		//获得时间集合
		timeList = HxDateUtil.getDateStrList(allEntLifeList.get(0).getEntAnalyDate(),allEntLifeList.get(allEntLifeList.size()-1).getEntAnalyDate());
		if(timeList==null||timeList.size()==0)return null;
		//处理新生数据
		if(estEntLifeList!=null&&estEntLifeList.size()!=0){//有新生企业
			//获得新生时间集合
			estNumList = parseEntLifeNumList(timeList, estEntLifeList);
		}else{//没有获取到新生企业
			for(int i=0;i<timeList.size();i++){
				estNumList.add(new BigDecimal(0));
			}
		}
		//处理消亡数据
		if(dieEntLifeList!=null&&dieEntLifeList.size()!=0){//有新生企业
			//获得取消亡时间集合
			dieNumList = parseEntLifeNumList(timeList, dieEntLifeList);
		}else{//没有获取到新生企业
			for(int i=0;i<timeList.size();i++){
				dieNumList.add(new BigDecimal(0));
			}
		}
		entLifeMap.put("timeList",timeList);
		entLifeMap.put("estNumList", estNumList);
		entLifeMap.put("dieNumList", dieNumList);
		JSONArray jsonArray = JSONArray.fromObject(entLifeMap);
		return jsonArray;
	}

	/**
	 * 描述：解析新生消亡企业数
	 * @author 马亚伟
	 * @date 2015-10-30
	 * @param timeList
	 * @param paramEntLifeList
	 * @return
	 */
	private List<BigDecimal> parseEntLifeNumList(List<String> timeList,
			List<CrAnalyEntLife> paramEntLifeList) {
		
		List<BigDecimal> tempNumList = new ArrayList<BigDecimal>();
		Map<String,BigDecimal> tempMap = new HashMap<String, BigDecimal>();
		for (String timeStr : timeList) {
			tempMap.put(timeStr,new BigDecimal(0));
		}
		for (CrAnalyEntLife entLife : paramEntLifeList) {
			tempMap.put(entLife.getEntAnalyDate(), entLife.getEntAnalyCount());
		}
		for (String timeStr : timeList) {
			tempNumList.add(tempMap.get(timeStr));
		}
		return tempNumList;
	}
	
	
	/**
	 * 描述：获得年、行业类型、企业数的CrAnalyEntLife的json
	 * @author 马亚伟
	 * @date 2015-10-31
	 * @param qryMap
	 * @return Map<String,Object>
	 * @throws Exception
	 */
	@Override
	public Map<String,Object> doGetCrAnalyEntLifeJsonForCharts(Map<String, Object> qryMap) throws Exception {
		
		if(qryMap==null) qryMap= new HashMap<String, Object>();
		List<String> yearList = new ArrayList<String>();
		List<String> entTypeCodeList = new ArrayList<String>();
		List<String> entTypeContentList = new ArrayList<String>();
		
		//获得行业类型
		List<YcCodeIndustryType> industryTypeList = ycCodeIndustryTypeService.doGetList(null);
		if(industryTypeList==null||industryTypeList.size()==0) return null;
		for (YcCodeIndustryType industryType : industryTypeList) {
			entTypeCodeList.add(industryType.getCode());
			entTypeContentList.add(industryType.getContent());
		}
		//解析数据
		List<CrAnalyEntLife> allEntLife = doGetCrAnalyEntLifeDao().selectCrAnalyEntLifeJsonForCharts(qryMap);
		if(allEntLife==null || allEntLife.size()==0) return null;
		qryMap.put("entFlag", 1);
		List<CrAnalyEntLife> estEntLife = doGetCrAnalyEntLifeDao().selectCrAnalyEntLifeJsonForCharts(qryMap);
		qryMap.put("entFlag", 2);
		List<CrAnalyEntLife> dieEntLife = doGetCrAnalyEntLifeDao().selectCrAnalyEntLifeJsonForCharts(qryMap);
		
		//年份集合
		int firstYear = Integer.parseInt(allEntLife.get(0).getEntAnalyDate());
		int LastYear = Integer.parseInt(allEntLife.get(allEntLife.size()-1).getEntAnalyDate());
		for (int i = firstYear; i <= LastYear; i++) {
			yearList.add(""+i);
		}

		//获得新生数目
		Map<String,Object> AllEntLifeMap = new HashMap<String,Object>();
		for (String year : yearList) {
			List<BigDecimal> estEntLifeTotalList = parseEntLifeTotalList(entTypeCodeList, estEntLife, year);
			List<BigDecimal> dieEntLifeTotalList = parseEntLifeTotalList(entTypeCodeList, dieEntLife, year);
			Map<String,List<BigDecimal>> tempMap = new HashMap<String, List<BigDecimal>>();
			tempMap.put("estEntLifeTotalList", estEntLifeTotalList);
			tempMap.put("dieEntLifeTotalList", dieEntLifeTotalList);
			AllEntLifeMap.put(year, tempMap);
		}
		AllEntLifeMap.put("timeList", yearList);
		AllEntLifeMap.put("entTypeContentList", entTypeContentList);
		
		return AllEntLifeMap;
	}

	/**
	 * 描述：获得每年对应的行业新生或消亡数量
	 * @author 马亚伟
	 * @date 2015-10-31
	 * @param entTypeList
	 * @param entLifeList
	 * @param year
	 * @return
	 */
	private List<BigDecimal> parseEntLifeTotalList(List<String> entTypeList,
		List<CrAnalyEntLife> entLifeList, String year) {
		List<BigDecimal> tempCountList = new ArrayList<BigDecimal>();
		Map<String,BigDecimal> tempEntCountMap = new HashMap<String, BigDecimal>();//存放行业和企业数
		//赋初值
		for(String entType : entTypeList){
			tempEntCountMap.put(entType, new BigDecimal(0));
		}
		//获得该年对用行业类型的新生或消亡数量
		if(entLifeList!=null){
			for (CrAnalyEntLife entLife : entLifeList) {
				if(!year.equals(entLife.getEntAnalyDate()))continue;//不是该年的数据，继续
				//是该年的数据
				tempEntCountMap.put(entLife.getEntSupTrade(), entLife.getEntAnalyCount());
			}
			//获得对用的数量List集合
			for(String entType : entTypeList){
				tempCountList.add(tempEntCountMap.get(entType));
			}
		}
		return tempCountList;
	}
	
	
	/**
	 * 描述：获取三大产业统计值
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyEntLife> doGetBigEntList(Map<String, Object> qryMap) throws Exception{
		return doGetCrAnalyEntLifeDao().selectBigEntList(qryMap);
	}
	
	/**
	 * 描述：构建三大产业统计值返回结果
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public JSONArray doBuildBigEntList(List<CrAnalyEntLife> entList) throws Exception{
		JSONArray jarr  = new JSONArray();
		JSONObject obj = new JSONObject();
		if(entList==null || entList.size()==0){
			return jarr;
		}
		for (CrAnalyEntLife ent : entList) {
			obj.put("value", ent.getEntCount());
			obj.put("name", ent.getEntSupTrade());
			jarr.add(obj);
			obj = new JSONObject();
		}
		return jarr;
	}
	
	
	/**
	 * 描述：获得最新的更新日期
	 * @author 马亚伟
	 * @date 2015-11-15
	 * @return
	 * @throws Exception
	 */
	@Override
	public String doGetLastCrEntLifeTime() throws Exception {
		CrAnalyEntLife analyEntLife = doGetCrAnalyEntLifeDao().selectLastCrEntLife();
		if(analyEntLife==null) return "";
		Date checkDate = analyEntLife.getEntCheckDate();
		String dateStr = new SimpleDateFormat("yyyy年MM月dd日").format(checkDate);
		return dateStr;
	}

	public CrAnalyEntLifeDao doGetCrAnalyEntLifeDao()
	{
		return (CrAnalyEntLifeDao)hxBaseDao;
	}

	public YcCodeIndustryTypeService getYcCodeIndustryTypeService() {
		return ycCodeIndustryTypeService;
	}

	public void setYcCodeIndustryTypeService(
			YcCodeIndustryTypeService ycCodeIndustryTypeService) {
		this.ycCodeIndustryTypeService = ycCodeIndustryTypeService;
	}
	

}

