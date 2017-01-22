/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-28
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.analy.cranalyentblock;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.icinfo.creditinfo.bean.analy.cranalyentblock.CrAnalyEntBlock;
import com.icinfo.creditinfo.dao.analy.cranalyentblock.CrAnalyEntBlockDao;
import com.icinfo.plugin.common.HxDateUtil;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.analy.cranalyentblock.CrAnalyEntBlockService;
/**
 * 
 * 描述: 块状经济专题分析表 Service 实现<br>
 * @author myw
 * @date 2015-11-28
 */
public class CrAnalyEntBlockServiceImpl extends HxBaseServiceImpl<CrAnalyEntBlock> implements CrAnalyEntBlockService
{
	
	//private CrAnalyEntBlockService crAnalyEntBlockService;
	/**
	 * 描述：获得块经济表中的统计年份
	 * @author mayawei
	 * @date 2015-11-28 
	 * @return List<String>
	 * @throws Exception
	 */
	@Override
	public List<String> doGetYearList() throws Exception {
		//获取chart4-2中的待选年份
		List<CrAnalyEntBlock> crAnalyEntBlockYearList = doGetCrAnalyEntBlockDao().selectEntBlockYearList();
		List<String> yearsList = new ArrayList<String>();
		if(crAnalyEntBlockYearList.size()!=0){
			int beginYear = crAnalyEntBlockYearList.get(0).getEntYear().intValue();
			int endYear = crAnalyEntBlockYearList.get(crAnalyEntBlockYearList.size()-1).getEntYear().intValue();
			for (int i = beginYear; i <=endYear; i++) {
				yearsList.add(i+"");
			}
		}
		return yearsList;
	}

	/**
	 * 描述：获取块经济产业数据chart1
	 * @author mayawei
	 * @param qryMap
	 * @return JSONObject
	 * @throws Exception
	 */
	@Override
	public JSONObject doGetEachTradeDataJSON(Map<String, Object> qryMap) throws Exception {
		//块状经济产业
		String[] names = new String[]{"机械仪器","伞件","风机","铜管","劳保袜业","消防器材","童装","汽车零部件"};
		//自定义chart面积
		Integer[]  values = new Integer[]{11,9,8,2,6,5,10,7};
		//解析块经济产业市场主体数量
		List<CrAnalyEntBlock> crAnalyEntBlockList = doGetCrAnalyEntBlockDao().selectEntBlockListForChart1(qryMap);
		if(crAnalyEntBlockList.size()==0) return null;
		Map<String, Object> resultMap = new HashMap<String, Object>();
		//解析统计结果
		CrAnalyEntBlock entBlock = crAnalyEntBlockList.get(0);
		Map<String, BigDecimal> tempMap = new HashMap<String, BigDecimal>();
		tempMap.put("机械仪器", entBlock.getBlockEcoJxyq());
		tempMap.put("伞件", entBlock.getBlockEcoSy());
		tempMap.put("风机", entBlock.getBlockEcoFj());
		tempMap.put("铜管", entBlock.getBlockEcoTg());
		tempMap.put("劳保袜业", entBlock.getBlockEcoLbwy());
		tempMap.put("消防器材", entBlock.getBlockEcoXfqc());
		tempMap.put("童装", entBlock.getBlockEcoTz());
		tempMap.put("汽车零部件", entBlock.getBlockEcoQclbj());
		JSONObject obj;
		String maxTradeName="";
		BigDecimal maxTradeValue = new BigDecimal(0);
		Map<String, BigDecimal> maxMap = new HashMap<String, BigDecimal>();
		long temp =0;
		JSONArray objArr = new JSONArray();
		for (int i = 0; i < names.length; i++) {
			//封装数据
			obj = new JSONObject();
			obj.put("name", names[i]);
			obj.put("value", values[i]);//自定义面积
			//obj.put("value", tempMap.get(names[i]));//根据数量定义面积
			obj.put("real", tempMap.get(names[i]));
			//获取最大的块状经济产业
			if(temp<tempMap.get(names[i]).longValue()){
				temp=tempMap.get(names[i]).longValue();
				maxTradeName = names[i];
				maxTradeValue =tempMap.get(names[i]);
				maxMap.put(names[i],tempMap.get(names[i]));
			}
			objArr.add(obj);
		}
		//返回处理结果	
		resultMap.put("dataMap", objArr);//chart数据
		resultMap.put("updateTime",entBlock.getDateStr());//更新的时间
		resultMap.put("maxTradeName",maxTradeName);//最大的块经济产业
		resultMap.put("maxTradeValue",maxTradeValue);
		JSONObject json = new JSONObject().fromObject(resultMap);
		return json;
	}

	/**
	 * 描述：获取块经济产业基本信息数据 chart2
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return JSONObject
	 * @throws Exception
	 */
	@Override
	public JSONObject doGetEachTradeDataJSONForChart2(Map<String, Object> qryMap)
			throws Exception {
		/*
		 * 市场主体类型分布 chart2-1
		 */
		//获取数据的时间，yyyy
		List<CrAnalyEntBlock> entBlockYearList = doGetCrAnalyEntBlockDao().selectTradeDataDateForChart2(qryMap);
		List<String> yearStrList = new ArrayList<String>();
		if(entBlockYearList.size()!=0){
			int startYear = entBlockYearList.get(0).getEntYear().intValue();
			int endYear = entBlockYearList.get(entBlockYearList.size()-1).getEntYear().intValue();
			for(int i=startYear;i<=endYear;i++){
				yearStrList.add(i+"");
			}
		}
		//获取主体个数、个体户、企业的统计数据
		List<CrAnalyEntBlock> crAnalyEntBlockList = doGetCrAnalyEntBlockDao().selectTradeDataJSONForChart2(qryMap);
		if(crAnalyEntBlockList.size()==0)return null;
		List<BigDecimal> geTiList = new ArrayList<BigDecimal>();
		List<BigDecimal> entList = new ArrayList<BigDecimal>();
		List<BigDecimal> industryCountList = new ArrayList<BigDecimal>();
		Map<String,BigDecimal> geTiMap = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> entMap = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> industryCountMap = new HashMap<String, BigDecimal>();
		//初始化map,为存放数据准备
		for (int i = 0; i < yearStrList.size(); i++) {
			geTiMap.put(yearStrList.get(i), new BigDecimal(0));
			entMap.put(yearStrList.get(i), new BigDecimal(0));
			industryCountMap.put(yearStrList.get(i), new BigDecimal(0));
		}
		//解析数据
		for (CrAnalyEntBlock entBlock : crAnalyEntBlockList) {
			if("50".equals(entBlock.getEntCatg())){//个体户
				geTiMap.put(entBlock.getEntYear()+"", entBlock.getQyCount());
			}else if("100".equals(entBlock.getEntCatg())){//企业
				entMap.put(entBlock.getEntYear()+"", entBlock.getQyCount());
			}else if("150".equals(entBlock.getEntCatg())){//全部市场主体类型个数
				industryCountMap.put(entBlock.getEntYear()+"", entBlock.getIndustryCount());
			}
		}
		//封装数据
		for (String year : yearStrList) {
			geTiList.add(geTiMap.get(year));
			entList.add(entMap.get(year));
			industryCountList.add(industryCountMap.get(year));
		}
		//结果集
		Map<String,Object> resultMap = new HashMap<String, Object>();
		resultMap.put("geTiList", geTiList);
		resultMap.put("entList", entList);
		resultMap.put("yearList", yearStrList);
		resultMap.put("geTiVal", geTiList.get(yearStrList.size()-1));//个体户
		resultMap.put("entVal", entList.get(yearStrList.size()-1));//企业
		resultMap.put("precGeTiVal", (geTiList.get(yearStrList.size()-1).doubleValue()*100)/(geTiList.get(yearStrList.size()-1).doubleValue()+entList.get(yearStrList.size()-1).doubleValue()));
		resultMap.put("precEntVal", (entList.get(yearStrList.size()-1).doubleValue()*100)/(geTiList.get(yearStrList.size()-1).doubleValue()+entList.get(yearStrList.size()-1).doubleValue()));
		resultMap.put("industryCount", industryCountList.get(yearStrList.size()-1).longValue());
		resultMap.put("tradeTotal", geTiList.get(yearStrList.size()-1).longValue()+entList.get(yearStrList.size()-1).longValue());
		
		/*
		 * 规模分布  chart2_2
		 */
		//获取数据
		List<CrAnalyEntBlock> entBlockListForchart22 = doGetCrAnalyEntBlockDao().selectTradeDataJSONForChart22(qryMap);
		String[] names2 = new String[]{"10万以下","10-50万","50-100万","100-500万","500万以上"};
		//初始化
		Map<String, String> namesMap = new HashMap<String, String>();
		for (int i = 1; i < names2.length+1; i++) {
			namesMap.put(i+"",names2[i-1]);
		}
		//解析数据
		JSONObject obj2;
		JSONArray objArr2 = new JSONArray();
		long entLt500Count=0;
		long entAllCount = 0;
		String lastYear = "";
		if(entBlockListForchart22.size()!=0){
			lastYear = entBlockListForchart22.get(entBlockListForchart22.size()-1).getDateStr();
		}
		for (int i = 0; i < entBlockListForchart22.size(); i++) {
			if(lastYear.equals(entBlockListForchart22.get(i).getDateStr())){
				obj2 = new JSONObject();
				obj2.put("name", namesMap.get(entBlockListForchart22.get(i).getQyScale()));
				obj2.put("value",entBlockListForchart22.get(i).getQyCount());
				objArr2.add(obj2);
				//统计500万以下
				if(!"5".equals(entBlockListForchart22.get(i).getQyScale())){//5表示五百万以上
					entLt500Count+=entBlockListForchart22.get(i).getQyCount().longValue();
				}
				entAllCount+=entBlockListForchart22.get(i).getQyCount().longValue();
			}
		}
		resultMap.put("dataMap", objArr2);
		//500万以下的比例
		resultMap.put("entLt500Count", entLt500Count);
		if(entAllCount!=0){
			resultMap.put("precEntLt500", (entLt500Count*100)/(entAllCount+0.0));
		}else{
			resultMap.put("precEntLt500", 0);
		}
		
		/*
		 * 行业分布 chart2-3
		 */
		List<CrAnalyEntBlock> entBlockListForchart23 = doGetCrAnalyEntBlockDao().selectTradeDataJSONForChart23(qryMap);
		String lastYear2 = "";
		List<String> entNamesList = new ArrayList<String>();
		List<BigDecimal> entCountList = new ArrayList<BigDecimal>();
		if(entBlockListForchart23.size()!=0){
			lastYear2 = entBlockListForchart23.get(entBlockListForchart23.size()-1).getDateStr();
		}
		for (int i = 0; i < entBlockListForchart23.size(); i++) {
			if(lastYear2.equals(entBlockListForchart23.get(i).getDateStr())){
				entNamesList.add(entBlockListForchart23.get(i).getTradeName());
				entCountList.add(entBlockListForchart23.get(i).getQyCount());
			}
		}
		resultMap.put("entNamesList", entNamesList);
		resultMap.put("entCountList", entCountList);
		
		JSONObject json = new JSONObject().fromObject(resultMap);
		return json;
	}

	/**
	 * 描述：获得块经济chart3数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public JSONObject doGetEachTradeDataJSONForChart3(Map<String, Object> qryMap)
			throws Exception {
		/*
		 * 资产总额chart3-1
		 */
		Map<String,Object> resultMap = new HashMap<String, Object>();
		//获取数据
		List<CrAnalyEntBlock> crAnalyEntBlockList = doGetCrAnalyEntBlockDao().selectTradeDataJSONForChart31(qryMap);
		if(crAnalyEntBlockList.size()==0) return null;
		//获取时间集合，yyyy-MM
		List<String> timeList = new ArrayList<String>();
		List<BigDecimal> valueList = new ArrayList<BigDecimal>();
		String beignDate = crAnalyEntBlockList.get(0).getDateStr();
		String endDate = crAnalyEntBlockList.get(crAnalyEntBlockList.size()-1).getDateStr();
		timeList = HxDateUtil.getDateStrList(beignDate, endDate);
		//解析数据
		Map<String, BigDecimal> tempMap = new HashMap<String, BigDecimal>();
		for (String dateStr : timeList) {
			tempMap.put(dateStr, new BigDecimal(0));
		}
		for (CrAnalyEntBlock entBlock : crAnalyEntBlockList) {
			tempMap.put(entBlock.getDateStr(), entBlock.getTotalAssets());
		}
		for (String dateStr : timeList) {
			valueList.add(tempMap.get(dateStr));
		}
		resultMap.put("timeList", timeList);
		resultMap.put("valueList", valueList);
		
		/*
		 * 盈利状况，盈利企业占比与净利润 chart3-3
		 */
		//获得数据
		List<CrAnalyEntBlock> entBlockList = doGetCrAnalyEntBlockDao().selectTradeDataJSONForChart33(qryMap);
		List<String> timeList2 = new ArrayList<String>();
		List<BigDecimal> profitValList = new ArrayList<BigDecimal>();
		List<BigDecimal> precProfitValList = new ArrayList<BigDecimal>();
		if(entBlockList.size()!=0){
			//解析时间 yyyy-MM
			String beignDate2 = entBlockList.get(0).getDateStr();
			String endDate2 = entBlockList.get(entBlockList.size()-1).getDateStr();
			timeList2 = HxDateUtil.getDateStrList(beignDate2, endDate2);
			Map<String,BigDecimal> profileMap = new HashMap<String, BigDecimal>();
			Map<String,BigDecimal> profileCountMap = new HashMap<String, BigDecimal>();
			Map<String,BigDecimal> allProfileMap = new HashMap<String, BigDecimal>();
			Map<String,BigDecimal> allProfileCountMap = new HashMap<String, BigDecimal>();
			profitValList = new ArrayList<BigDecimal>();
			precProfitValList = new ArrayList<BigDecimal>();
			//解析数据
			for (String timeStr : timeList2) {
				profileMap.put(timeStr, new BigDecimal(0));
				profileCountMap.put(timeStr, new BigDecimal(0));
				allProfileMap.put(timeStr, new BigDecimal(0));
				allProfileCountMap.put(timeStr, new BigDecimal(0));
			}
			for(CrAnalyEntBlock entBlock:entBlockList){
				if("1".equals(entBlock.getIsProfit())){//1代表盈利企业数据集合
					profileMap.put(entBlock.getDateStr(), entBlock.getNetProfit());
					profileCountMap.put(entBlock.getDateStr(), entBlock.getQyCount());
				}else if("0".equals(entBlock.getIsProfit())){//0代表全部数据集合
					allProfileMap.put(entBlock.getDateStr(), entBlock.getNetProfit());
					allProfileCountMap.put(entBlock.getDateStr(), entBlock.getQyCount());
				}
			}
			for(String timeStr : timeList2){
				profitValList.add(allProfileMap.get(timeStr));
				if(allProfileCountMap.get(timeStr).longValue()!=0){
					//盈利企业占比
					precProfitValList.add(new BigDecimal((profileCountMap.get(timeStr).doubleValue()*100)/allProfileCountMap.get(timeStr).doubleValue()));
				}
			}
		}
		resultMap.put("profitValList", profitValList);
		resultMap.put("precProfitValList", precProfitValList);
		resultMap.put("timeList2", timeList2);
		
		JSONObject json = new JSONObject().fromObject(resultMap);
		return json;
	}
	
	/**
	 * 描述：获得块经济chart4数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public JSONObject doGetEachTradeDataJSONForChart4(Map<String, Object> qryMap)
			throws Exception {
		/*
		 * 对上虞经济的影响程度chart4-1、纳税贡献chart4-3、就业贡献chart4-4
		 */
		//获取数据
		Map<String,Object> resultMap = new HashMap<String, Object>();
		List<CrAnalyEntBlock> crAnalyEntBlockList = doGetCrAnalyEntBlockDao().selectTradeDataJSONForChart41(qryMap);
		if(crAnalyEntBlockList.size()==0) return null;
		//获取时间集合
		List<String> timeList = new ArrayList<String>();
		String beignDate = crAnalyEntBlockList.get(0).getDateStr();
		String endDate = crAnalyEntBlockList.get(crAnalyEntBlockList.size()-1).getDateStr();
		timeList = HxDateUtil.getDateStrList(beignDate, endDate);
		//营业
		Map<String,BigDecimal> incomeMap = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> allIncomeMap = new HashMap<String, BigDecimal>();
		//总资产
		Map<String,BigDecimal> assetsMap = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> allAssetsMap = new HashMap<String, BigDecimal>();
		//税额
		Map<String,BigDecimal> taxMap = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> allTaxMap = new HashMap<String, BigDecimal>();
		//就业人数
		Map<String,BigDecimal> personNumMap = new HashMap<String, BigDecimal>();
		Map<String,BigDecimal> allPersonNumMap = new HashMap<String, BigDecimal>();
		
		//数据集合
		List<BigDecimal> precIncomeList = new ArrayList<BigDecimal>();  
		List<BigDecimal> precAssetsList = new ArrayList<BigDecimal>();
		List<BigDecimal> taxCountList = new ArrayList<BigDecimal>();
		List<BigDecimal> precTaxList = new ArrayList<BigDecimal>();
		List<BigDecimal> personNumList = new ArrayList<BigDecimal>();
		List<BigDecimal> precPersonNumList = new ArrayList<BigDecimal>();
		//初始化集合
		for (String dateStr : timeList) {
			incomeMap.put(dateStr, new BigDecimal(0));
			allIncomeMap.put(dateStr, new BigDecimal(0));
			assetsMap.put(dateStr, new BigDecimal(0));
			allAssetsMap.put(dateStr, new BigDecimal(0));
			taxMap.put(dateStr, new BigDecimal(0));
			allTaxMap.put(dateStr, new BigDecimal(0));
			personNumMap.put(dateStr, new BigDecimal(0));
			allPersonNumMap.put(dateStr, new BigDecimal(0));
		}
		//解析数据
		for (CrAnalyEntBlock entBlock : crAnalyEntBlockList) {
			if("1".equals(entBlock.getIsLocal())){//1代表该块经济产业的数据
				incomeMap.put(entBlock.getDateStr(), entBlock.getIncome());
				taxMap.put(entBlock.getDateStr(), entBlock.getTax());
				assetsMap.put(entBlock.getDateStr(), entBlock.getTotalAssets());
				personNumMap.put(entBlock.getDateStr(), entBlock.getSocialSecurityNum());
				
			}else if("0".equals(entBlock.getIsLocal())){//0代表全部块经济产业数据
				allIncomeMap.put(entBlock.getDateStr(), entBlock.getIncome());
				allAssetsMap.put(entBlock.getDateStr(), entBlock.getTotalAssets());
				allTaxMap.put(entBlock.getDateStr(), entBlock.getTax());
				allPersonNumMap.put(entBlock.getDateStr(), entBlock.getSocialSecurityNum());
			}
		}
		for (String dateStr : timeList) {
			if(allIncomeMap.get(dateStr).longValue()!=0){
				precIncomeList.add(new BigDecimal((incomeMap.get(dateStr).doubleValue()*100)/allIncomeMap.get(dateStr).doubleValue()));
			}else{
				precIncomeList.add(new BigDecimal(0));
			}
			if(allAssetsMap.get(dateStr).longValue()!=0){
				precAssetsList.add(new BigDecimal((assetsMap.get(dateStr).doubleValue()*100)/allAssetsMap.get(dateStr).doubleValue()));
			}else{
				precAssetsList.add(new BigDecimal(0));
			}
			taxCountList.add(taxMap.get(dateStr));
			if(allTaxMap.get(dateStr).longValue()!=0){
				precTaxList.add(new BigDecimal((taxMap.get(dateStr).doubleValue()*100)/allTaxMap.get(dateStr).doubleValue()));
			}else{
				precTaxList.add(new BigDecimal(0));
			}
			personNumList.add(personNumMap.get(dateStr));
			if(allPersonNumMap.get(dateStr) == null){
				continue;
			}
			if(allPersonNumMap.get(dateStr).longValue()!=0){
				precPersonNumList.add(new BigDecimal((personNumMap.get(dateStr).doubleValue()*100)/allPersonNumMap.get(dateStr).doubleValue()));
			}else{
				precPersonNumList.add(new BigDecimal(0));
			}
			 
		}
		resultMap.put("timeList", timeList);//时间集合
		resultMap.put("precIncomeList", precIncomeList);//收入比重
		resultMap.put("precAssetsList", precAssetsList);//资产总额比重
		resultMap.put("taxCountList", taxCountList);//税收
		resultMap.put("precTaxList", precTaxList);//税收比重
		resultMap.put("personNumList", personNumList);//就业人数
		resultMap.put("precPersonNumList", precPersonNumList);//就业比重
		
		JSONObject json = new JSONObject().fromObject(resultMap);
		return json;
	}

	/**
	 * 描述：获得块经济chart42数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public JSONObject doGetEachTradeDataJSONForChart42(Map<String, Object> qryMap)
			throws Exception {
		/*
		 * 对上下游产业链的影响chart4-2
		 */
		List<String> yearList = new ArrayList<String>();
		//对比年份
		String selectYear = qryMap.get("selectYear")+" 年";
		//获取行业大类code与name数据
		Map<String,Object> resultMap = new HashMap<String, Object>();
		List<CrAnalyEntBlock> crAnalyEntBlockTradeCodeList = doGetCrAnalyEntBlockDao().selectTradeCodeListForChart42(qryMap);
		if(crAnalyEntBlockTradeCodeList.size()==0)return null;
		List<String> tradeCodeList = new ArrayList<String>();
		List<String> tradeNameList = new ArrayList<String>();
		List<BigDecimal> selectDataList = new ArrayList<BigDecimal>();
		List<BigDecimal> currentDataList = new ArrayList<BigDecimal>();
		Map<String, BigDecimal> selectTempMap = new HashMap<String, BigDecimal>();
		Map<String, BigDecimal> currentTempMap = new HashMap<String, BigDecimal>();
		//解析封装行业大类code与name
		for (CrAnalyEntBlock entBlockTradeCode : crAnalyEntBlockTradeCodeList) {
			tradeCodeList.add(entBlockTradeCode.getTrade());
			tradeNameList.add(entBlockTradeCode.getTradeName());
		}
		for(String tradeCode : tradeCodeList){
			selectTempMap.put(tradeCode, new BigDecimal(0));
			currentTempMap.put(tradeCode, new BigDecimal(0));
		}
		//所选定对比的年份数据获取与封装
		List<CrAnalyEntBlock> crAnalyEntBlockList = doGetCrAnalyEntBlockDao().selectTradeDataJSONForChart42(qryMap);
		for (CrAnalyEntBlock crAnalyEntBlock : crAnalyEntBlockList) {
			selectTempMap.put(crAnalyEntBlock.getTrade(), crAnalyEntBlock.getQyCount());
		}
		for(String tradeCode : tradeCodeList){
			selectDataList.add(selectTempMap.get(tradeCode));
		}
		
		//当前年份的数据获取与封装
		List<String> entBlockYearList =doGetYearList();
		String lastYear;
		if(entBlockYearList.size()!=0){
			lastYear = entBlockYearList.get(entBlockYearList.size()-1);
		}else{
			lastYear = HxDateUtil.getCurrentYear();
		}
		qryMap.put("selectYear",lastYear);
		List<CrAnalyEntBlock> crAnalyEntBlockDataList = doGetCrAnalyEntBlockDao().selectTradeDataJSONForChart42(qryMap);
		for (CrAnalyEntBlock crAnalyEntBlockData : crAnalyEntBlockDataList) {
			currentTempMap.put(crAnalyEntBlockData.getTrade(), crAnalyEntBlockData.getQyCount());
		}
		for(String tradeCode : tradeCodeList){
			currentDataList.add(currentTempMap.get(tradeCode));
		}
		
		yearList.add(lastYear+"年");//当前年份
		yearList.add(selectYear);//所选对比年份
		resultMap.put("tradeNameList", tradeNameList);//行业大类名称
		resultMap.put("currentDataList", currentDataList);//当前年份的数据集合
		resultMap.put("selectDataList", selectDataList);//所选对比年份集合
		resultMap.put("yearList", yearList);//时间集合，当前年份与选定年份
		
		JSONObject json = new JSONObject().fromObject(resultMap);
		return json;
	}
	
	/**
	 * 描述：获得块经济chart32数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public JSONObject doGetEachTradeDataJSONForChart32(Map<String, Object> qryMap)
			throws Exception {
		/*
		 * 运营状况 chart3-2
		 */
		Map<String,Object> resultMap = new HashMap<String, Object>();
		//用于营业收入、用电量、用水量统计
		List<BigDecimal> dataList = new ArrayList<BigDecimal>();
		//用于进出口额统计
		List<BigDecimal> dataList1 = new ArrayList<BigDecimal>();
		List<BigDecimal> dataList2 = new ArrayList<BigDecimal>();
		if("imex".equals(qryMap.get("resName"))){//进出口统计,imex代表进出口
			Map<String,Object> qryMap2 = new HashMap<String, Object>();
			qryMap2.put("tradeName", qryMap.get("tradeName"));
			qryMap2.put("resName", "EXP_NUM");
			//出口额
			List<CrAnalyEntBlock> crAnalyEntBlockList1 = doGetCrAnalyEntBlockDao().selectTradeDataJSONForChart32(qryMap2);
			if(crAnalyEntBlockList1.size()==0) return null;
			//进口额
			qryMap2.put("resName", "IMP_NUM");
			List<CrAnalyEntBlock> crAnalyEntBlockList2 = doGetCrAnalyEntBlockDao().selectTradeDataJSONForChart32(qryMap2);
			if(crAnalyEntBlockList2.size()==0) return null;
			//解析数据
			List<CrAnalyEntBlock> crAnalyEntBlockList3 = doGetCrAnalyEntBlockDao().selectTradeTimeJSONForChart32(qryMap2);
			String beignDate1 = crAnalyEntBlockList3.get(0).getDateStr();
			String endDate1 = crAnalyEntBlockList3.get(crAnalyEntBlockList3.size()-1).getDateStr();
			List<String> timeList1 = HxDateUtil.getDateStrList(beignDate1, endDate1);
			//封装数据
			dataList1 = parseEntBlockData(crAnalyEntBlockList1, timeList1);
			dataList2 = parseEntBlockData(crAnalyEntBlockList2, timeList1);
			resultMap.put("timeList1", timeList1);
			resultMap.put("dataList1", dataList1);
			resultMap.put("dataList2", dataList2);
			JSONObject json1 = new JSONObject().fromObject(resultMap);
			return json1;
			
		}
		//营业收入、用电量、用水量统计
		List<CrAnalyEntBlock> crAnalyEntBlockList = doGetCrAnalyEntBlockDao().selectTradeDataJSONForChart32(qryMap);
		if(crAnalyEntBlockList.size()==0) return null;
		List<String> timeList = new ArrayList<String>();
		String beignDate = crAnalyEntBlockList.get(0).getDateStr();
		String endDate = crAnalyEntBlockList.get(crAnalyEntBlockList.size()-1).getDateStr();
		timeList = HxDateUtil.getDateStrList(beignDate, endDate);
		dataList = parseEntBlockData(crAnalyEntBlockList, timeList);
		
		resultMap.put("timeList", timeList);
		resultMap.put("dataList", dataList);
		JSONObject json = new JSONObject().fromObject(resultMap);
		return json;
	}

	/**
	 * 描述：解析数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param paramCrAnalyEntBlockList
	 * @param paramTimeList
	 * @return List<BigDecimal>
	 */
	private List<BigDecimal> parseEntBlockData(
			List<CrAnalyEntBlock> paramCrAnalyEntBlockList,
			List<String> paramTimeList) {
		Map<String,BigDecimal> tempMap = new HashMap<String, BigDecimal>();
		List<BigDecimal> tempList = new ArrayList<BigDecimal>();
		for (String dateStr:paramTimeList) {
			tempMap.put(dateStr, new BigDecimal(0));
		}
		for(CrAnalyEntBlock entBlock : paramCrAnalyEntBlockList){
			tempMap.put(entBlock.getDateStr(), entBlock.getResTotal());
		}
		for (String dateStr:paramTimeList) {
			tempList.add(tempMap.get(dateStr));
		}
		return tempList;
	}
	
	
	public CrAnalyEntBlockDao doGetCrAnalyEntBlockDao()
	{
		return (CrAnalyEntBlockDao)hxBaseDao;
	}

	
}
