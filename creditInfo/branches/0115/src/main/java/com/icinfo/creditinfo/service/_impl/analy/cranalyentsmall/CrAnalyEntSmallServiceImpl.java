/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-28
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.analy.cranalyentsmall;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.analy.cranalyentsmall.CrAnalyEntSmall;
import com.icinfo.creditinfo.dao.analy.cranalyentsmall.CrAnalyEntSmallDao;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.icinfo.creditinfo.service.analy.cranalyentsmall.CrAnalyEntSmallService;
/**
 * 
 * 描述: 小微企业 Service 实现<br>
 * @author liyafeng
 * @date 2015-11-28
 */
public class CrAnalyEntSmallServiceImpl extends HxBaseServiceImpl<CrAnalyEntSmall> implements CrAnalyEntSmallService
{
	

	public CrAnalyEntSmallDao doGetCrAnalyEntSmallDao()
	{
		return (CrAnalyEntSmallDao)hxBaseDao;
	}
    /**
     * 
     * 描述: 获得年份
     * @author  LiYaFeng
     * @date 2015年11月28日 
     * @throws Exception
     */
	@Override
	public List<BigDecimal> doGetYearList() throws Exception {
		return doGetCrAnalyEntSmallDao().selectYearList();
		
	}
	/**
	 * 
	 * 描述: 获得区域企业数
	 * @author  LiYaFeng
	 * @date 2015年11月28日 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public JSONObject doGetCrAnalyEntSmallNumByZone(Map<String, Object> qryMap) throws Exception {
		//获得最新月
		CrAnalyEntSmall  crAnalyEntSmallLast=doGetCrAnalyEntSmallDao().selectCrAnalyEntSmallLast(qryMap);
		if(crAnalyEntSmallLast==null) return null;
		BigDecimal lastMonth=crAnalyEntSmallLast.getEntMonth();
		qryMap.put("entMonth", lastMonth);
		//区域小微企业数
		List<CrAnalyEntSmall> crAnalyEntSmallList=doGetCrAnalyEntSmallDao().selectCrAnalyEntSmallListByZone(qryMap);
		JSONArray dataArr = new JSONArray();
		JSONObject pubResZoneData;
		BigDecimal minNum=new BigDecimal(0);
		BigDecimal maxNum=new BigDecimal(0);
		Map<String,Object> mapData = new HashMap<String, Object>();
		if(crAnalyEntSmallList.size()!=0){
			minNum=crAnalyEntSmallList.get(0).getZoneEntCount();
		for (CrAnalyEntSmall crAnalyEntSmall : crAnalyEntSmallList) {
			BigDecimal smallEntNum=crAnalyEntSmall.getZoneEntCount();
			if(maxNum.compareTo(smallEntNum)<0){
				maxNum=smallEntNum;
			}
			if(minNum.compareTo(smallEntNum)>0){
				minNum=smallEntNum;
			}
			pubResZoneData = new JSONObject();
			//上虞各区域名字
			pubResZoneData.put("name", crAnalyEntSmall.getZoneName());
			//上虞各区域企业数
			pubResZoneData.put("value", crAnalyEntSmall.getZoneEntCount());
			dataArr.add(pubResZoneData);
		}
		}
		mapData.put("dataArr", dataArr);
		mapData.put("minNum", minNum);
		mapData.put("maxNum", maxNum);
		JSONObject json=new JSONObject().fromObject(mapData);
		return json;
	}
	/**
	 * 
	 * 描述: 小微企业活跃度
	 * @author  LiYaFeng
	 * @date 2015年11月28日 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> doGetCrAnalyEntSmallActive(Map<String, Object> qryMap) throws Exception {
		Map<String, Object> dataMap=new HashMap<String, Object>();
		int totalNum=0;//总企业数
		int smallTotalNum=0;//小微企业数
		int openNum=0;//经营开业数
		CrAnalyEntSmall crAnalyEntSmall=doGetCrAnalyEntSmallDao().selectEntAllTotal(qryMap);
		if(crAnalyEntSmall!=null){
		   totalNum=crAnalyEntSmall.getQyCount().intValue();
		 }
		qryMap.put("smallEnt", "1");
		CrAnalyEntSmall crAnalyEntSmall1=doGetCrAnalyEntSmallDao().selectEntAllTotal(qryMap);
		if(crAnalyEntSmall1!=null){
		   smallTotalNum=crAnalyEntSmall1.getQyCount().intValue();
		 }
		   //获得经营开业数
	    CrAnalyEntSmall crAnalyEntSmall3=doGetCrAnalyEntSmallDao().selectEntOpenTotal(qryMap);
		if(crAnalyEntSmall3!=null){
		   openNum=crAnalyEntSmall3.getQyCount().intValue();
		}
		String smallTotalNumPercent="";
		String openSmallPercent="";
    	if(totalNum!=0){
    	  double rate3=(double)smallTotalNum/totalNum*100;
    	  smallTotalNumPercent=getResTwoDecimalPlaces(rate3);
    	}
    	if(smallTotalNum!=0){
    	  double rate4=(double)openNum/smallTotalNum*100;
    	  openSmallPercent=getResTwoDecimalPlaces(rate4);//经营开业占小微企业百分比
    	}
		dataMap.put("smallTotalNumPercent", smallTotalNumPercent);
		dataMap.put("openSmallPercent", openSmallPercent);
    	dataMap.put("totalNum", totalNum);
    	dataMap.put("openNum", openNum);
    	dataMap.put("smallTotalNum", smallTotalNum);
		return dataMap;
	}
	/**
	 * 
	 * 描述: 获得新生消亡数与时间
	 * @author  LiYaFeng
	 * @date 2015年11月28日 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> doGetNewAndDieAndDateList(Map<String, Object> qryMap) throws Exception {
		Map<String, Object> dataMap=new HashMap<String, Object>();
		List<BigDecimal> newNumList=new ArrayList<BigDecimal>();
		List<BigDecimal> dieNumList=new ArrayList<BigDecimal>();
		List<String> dateList=new ArrayList<String>();
		List<CrAnalyEntSmall> smallList=doGetCrAnalyEntSmallDao().selectCrAnalyEntSmallList(qryMap);
		if(smallList.size()!=0){
			for (CrAnalyEntSmall crAnalyEntSmall : smallList) {
				newNumList.add(crAnalyEntSmall.getNewbornEnt());
				dieNumList.add(crAnalyEntSmall.getDieEnt());
				dateList.add(crAnalyEntSmall.getDateStr());
			}
		}
		dataMap.put("newNumList", newNumList);
		dataMap.put("dieNumList", dieNumList);
		dataMap.put("dateList", dateList);
		return dataMap;
	}
	/**
	 * 
	 * 描述: 获得经营参数
	 * @author  LiYaFeng
	 * @date 2015年11月28日 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> doGetOperateStateListAndDateList(Map<String, Object> qryMap) throws Exception {
		Map<String, Object> dataMap=new HashMap<String, Object>();
		List<BigDecimal> numList=new ArrayList<BigDecimal>();//营业收入、用电量、用水量结合
		List<String> dateList=new ArrayList<String>();//年月集合
		List<BigDecimal> entNumList=new ArrayList<BigDecimal>();//对应企业数集合
		BigDecimal incomelast = new BigDecimal(0);
		String increpercent="";//增长百分比
		int increEntNum=0;//增长企业数
		String percent=""; 
		List<CrAnalyEntSmall> smallEntList=doGetCrAnalyEntSmallDao().selectOperateStateListAndDateList(qryMap);
		for (CrAnalyEntSmall crAnalyEntSmall : smallEntList) {
			dateList.add(crAnalyEntSmall.getDateStr());
			/*entNumList.add(crAnalyEntSmall.getQyCount());*/
			String type=(String) qryMap.get("type");
			if(type.equals("income")){
				entNumList.add(crAnalyEntSmall.getOpenQyCount());//营业收入
				numList.add(crAnalyEntSmall.getIncome());
			}else if(type.equals("elec")){
				entNumList.add(crAnalyEntSmall.getElecQyCount());//用电量
				numList.add(crAnalyEntSmall.getElecNum());
			}else{
				entNumList.add(crAnalyEntSmall.getWaterQyCount());//用水量
				numList.add(crAnalyEntSmall.getWaterNum());
			}
		}
		/*for (int i = 0; i < smallEntList.size()-1; i++) {
			if(smallEntList.get(i+1).getIncome().doubleValue()>smallEntList.get(i).getIncome().doubleValue()){
				increEntNum+=smallEntList.get(i+1).getOpenQyCount().intValue();
			}
		}*/
		if(smallEntList.size()!=0){
			BigDecimal incomelast1=smallEntList.get(smallEntList.size()-1).getIncome();
			 incomelast=new BigDecimal(incomelast1.doubleValue()/10000).setScale(6,BigDecimal.ROUND_HALF_UP);
			 if(smallEntList.size()>1){
			 BigDecimal incomePrelast=smallEntList.get(smallEntList.size()-2).getIncome();
			   if(incomePrelast.doubleValue()!=0){
			     double rate=(incomelast1.doubleValue()-incomePrelast.doubleValue())/incomePrelast.doubleValue()*100;
			     percent=getResTwoDecimalPlaces(rate);
			   }
			 }
		}
		qryMap.remove("smallEnt");
		CrAnalyEntSmall crAnalyEntSmall =doGetCrAnalyEntSmallDao().selectEntAllTotal(qryMap);
		int totalNum=0;
		if(crAnalyEntSmall!=null){
		totalNum=crAnalyEntSmall.getQyCount().intValue();}
		if(totalNum!=0){
			double rate1=(double)increEntNum/totalNum*100;
		    increpercent=getResTwoDecimalPlaces(rate1);
		}
		dataMap.put("increEntNum", increEntNum);
		dataMap.put("percent", percent);
		dataMap.put("incomelast", incomelast);
		dataMap.put("dateList", dateList);
		dataMap.put("entNumList", entNumList);
		dataMap.put("numList", numList);
		dataMap.put("increpercent", increpercent);
		return dataMap;
	}
	/**
	 * 
	 * 描述: 获得就业情况
	 * @author  LiYaFeng
	 * @date 2015年11月28日 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> doGetEmpStatus(Map<String, Object> qryMap) throws Exception {
		Map<String, Object> dataMap=new HashMap<String, Object>();
		List<BigDecimal> empNumList=new ArrayList<BigDecimal>();
		List<String> dateList=new ArrayList<String>();
		List<BigDecimal> entNumList=new ArrayList<BigDecimal>();
		BigDecimal empNumLast=new BigDecimal(0);
		BigDecimal entNumLast=new BigDecimal(0);
		int empNumtotal=0;
		int avgNum=0;
		String empNumLastPercent="";
		List<CrAnalyEntSmall> smallEntList=doGetCrAnalyEntSmallDao().selectEmpStatus(qryMap);
		for (CrAnalyEntSmall crAnalyEntSmall : smallEntList) {
			dateList.add(crAnalyEntSmall.getDateStr());
			empNumList.add(crAnalyEntSmall.getSocialSecurityNum());
			empNumtotal+=crAnalyEntSmall.getSocialSecurityNum().intValue();
			entNumList.add(crAnalyEntSmall.getQyCount());
		}
         if(empNumList.size()!=0){
        	 empNumLast=empNumList.get(empNumList.size()-1);
         }
         if(empNumtotal!=0&&empNumList.size()!=0){
        	 double rate=empNumList.get(empNumList.size()-1).doubleValue()/empNumtotal*100;
        	 empNumLastPercent=getResTwoDecimalPlaces(rate);
        }
         if(entNumList.size()!=0){
        	 entNumLast=entNumList.get(entNumList.size()-1);
        	 if(entNumLast.doubleValue()!=0){
        	  avgNum=empNumLast.intValue()/entNumLast.intValue();
        	 }
         }
        dataMap.put("avgNum", avgNum);
        dataMap.put("empNumLastPercent", empNumLastPercent);
        dataMap.put("empNumLast", empNumLast);
		dataMap.put("dateList", dateList);
		dataMap.put("empNumList", empNumList);
		dataMap.put("entNumList", entNumList);
		return dataMap;
	}
	/**
	 * 
	 * 描述: 获得3年成长轨迹
	 * @author  LiYaFeng
	 * @date 2015年11月29日 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public Map<String, Object> doGetThreeYearGrow(Map<String, Object> qryMap) throws Exception {
		List<CrAnalyEntSmall> smallEntList=doGetCrAnalyEntSmallDao().selectThreeYearGrow(qryMap);
		if(smallEntList.size()==0) return null;
		BigDecimal yearStart=smallEntList.get(0).getEntIncomeYear();
		BigDecimal yearEnd=smallEntList.get(smallEntList.size()-1).getEntIncomeYear();
		Integer [] type = new Integer[]{0,1,2,3,4,5};
		List<String> years = new ArrayList<String>();
		List<Double> incomeCountList = new ArrayList<Double>();
		for(int i=yearStart.intValue();i<=yearEnd.intValue();i++){
			years.add(i+"");
		}
		Map<String, Object> incomeDataMap = new HashMap<String, Object>(); 
		for (String year : years) {
			incomeCountList.clear();
			Map<String, Double> tempMap =  new HashMap<String, Double>();
			for (int i = 0; i < type.length; i++) {
				tempMap.put(i+"", 0.0);
			}
			List<Double> precIncomeCountList = new ArrayList<Double>();
			List<Double> disprecIncomeCountList = new ArrayList<Double>();
			for (CrAnalyEntSmall smallEnt : smallEntList) {
				if(year.equals(smallEnt.getEntIncomeYear().toString())){
					tempMap.put(smallEnt.getIncomeType().toString(), smallEnt.getQyIncomeCount().doubleValue());
				}
			}
			for (int i = 0; i < type.length; i++) {
				incomeCountList.add(tempMap.get(i+""));
			}
			
			double incomeTotal = 0;
			for (double income : incomeCountList) {
				incomeTotal+=income;
			}
			if(incomeTotal>0){
				for (double income : incomeCountList) {
					precIncomeCountList.add((income*100)/incomeTotal);
					disprecIncomeCountList.add(100-(income*100)/incomeTotal);
				}
			}
			Map<String, List<Double>> precMap = new HashMap<String, List<Double>>();
			precMap.put("pos", precIncomeCountList);//正
			precMap.put("dis", disprecIncomeCountList);//反
			incomeDataMap.put(year, precMap);
		}
		incomeDataMap.put("timeList", years);
		return incomeDataMap;
	}
	/**
	 * 
	 * 描述: 保留两位小数
	 * @author LiYaFeng
	 * @date 2015年12月2日 
	 * @param rate
	 * @return
	 */
	public String getResTwoDecimalPlaces(double rate){
		 java.text.DecimalFormat   df   =new   java.text.DecimalFormat("#0.00");
    	 return df.format(rate);
	}
	
}
