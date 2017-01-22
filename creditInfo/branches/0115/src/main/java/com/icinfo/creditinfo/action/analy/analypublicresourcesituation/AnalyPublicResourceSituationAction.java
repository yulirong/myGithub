/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author mayawei
 * @date 2015-10-29
 * @version 1.0
 */
package com.icinfo.creditinfo.action.analy.analypublicresourcesituation;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.Timeline;
import com.github.abel533.echarts.Title;
import com.github.abel533.echarts.Toolbox;
import com.github.abel533.echarts.Tooltip;
import com.github.abel533.echarts.code.Orient;
import com.github.abel533.echarts.code.SeriesType;
import com.github.abel533.echarts.code.Trigger;
import com.github.abel533.echarts.code.X;
import com.github.abel533.echarts.feature.Feature;
import com.github.abel533.echarts.json.GsonOption;
import com.github.abel533.echarts.json.GsonUtil;
import com.github.abel533.echarts.series.Series;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.icinfo.creditinfo.service.biz.crelecpay.CrElecPayService;
import com.icinfo.creditinfo.service.biz.crgaspay.CrGasPayService;
import com.icinfo.creditinfo.service.biz.crwaterpay.CrWaterPayService;
import com.icinfo.creditinfo.service.biz.crwatersewagedischargepay.CrWaterSewageDischargePayService;
import com.opensymphony.xwork2.Action;

/** 
 * 描述: 公共资源使用状况 Action 类<br>
 * @author mayawei
 * @date 2015-11-2
 */
public class AnalyPublicResourceSituationAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	//请求资源指标类型
	private String publicSourceType;
	private CrElecPayService crElecPayService;
	private CrWaterPayService crWaterPayService;
	private CrGasPayService crGasPayService;
	private CrWaterSewageDischargePayService crWaterSewageDischargePayService;
	
	/**
	 * 描述: 查看列表
	 * @author mayawei
	 * @date 2015-11-02
	 * @return String
	 * @throws Exception
	 */
	public String doReadAnalyPublicResourceSituationListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 读取信息
	 * @author mayawei
	 * @date 2015-11-02
	 * @return String
	 * @throws Exception
	 */
	public String doReadAnalyPublicResourceSituationListJSONAction() throws Exception {
		Map<String,Object> qryMap = new HashMap<String, Object>();
		JSONArray analyPublicResourceSituation = new JSONArray();
		if(publicSourceType!=null){
			if("elec".equals(publicSourceType)){
				//获得用电量信息
				//analyPublicResourceSituation = crElecPayService.doGetAnalyElecPayList(qryMap);
			}else if("water".equals(publicSourceType)){
				//获取用水量信息
				//analyPublicResourceSituation = crWaterPayService.doGetAnalyWaterPayList(qryMap);
			}else if("gas".equals(publicSourceType)){
				//获取用气量信息
				//analyPublicResourceSituation = crGasPayService.doGetAnalyGasPayList(qryMap);
			}else if("sewage".equals(publicSourceType)){
				//获得排污量信息
				//analyPublicResourceSituation = crWaterSewageDischargePayService.doGetAnalyWaterSewageDischargePayList(qryMap);
			}
			this.addAjaxResults("analyJsonData",analyPublicResourceSituation);
		}
		
		/*********************************测试开始***************************************/
		//封装数据
		List<String> yearList = getTimeList(2000,2016);
		Map<String, JSONArray> dataMap = new HashMap<String, JSONArray>();
		for (String year : yearList) {
			dataMap.put(year, getProvinceOnYear());
		}

		this.addAjaxResults("mapData",dataMap);
		this.addAjaxResults("yearList",yearList);
		
		/*********************************测试结束***************************************/
		
		return AJAX;
	}

	/****************************以下为地图数据测试--开始********************************************/
	
	/**
	 * 描述：获得年份集合
	 * @param start
	 * @param end
	 * @return
	 */
	private static List<String> getTimeList(int start,int end){
		//时间轴
		List<String> yearList = new ArrayList<String>();
		for(int i=start;i<=end;i++){
			yearList.add(""+i);
		}
		
		return yearList;
	}
	
	private static JSONArray getProvinceOnYear(){
		//省份数组
		//String [] provinces = new String[]{"北京","天津","河北","山西","内蒙古","辽宁","吉林","黑龙江","上海","江苏","浙江","安徽","福建","江西","山东","河南","湖北","湖南","广东","广西","海南","重庆","四川","贵州","云南","西藏","陕西","甘肃","青海","宁夏","新疆"};
		//上虞
		String [] provinces = new String[]{"上虞市", "百官街道", "曹娥街道", "东关街道", "道墟镇", "上浦镇", "汤浦镇", "章镇镇", "下管镇", "丰惠镇", "永和镇", "梁湖镇", "驿亭镇", "小越镇", "谢塘镇", "盖北镇", "崧厦镇", "沥海镇", "丁宅乡"};
		
		//数据组
		List<BigDecimal> valueList = new ArrayList<BigDecimal>();
		for (int i = 0; i < provinces.length; i++) {
			valueList.add(new BigDecimal(Math.round(Math.random()*4000)));
		}

		JSONArray dataArr = new JSONArray();
		JSONObject provinceData;
		//封装数据
		for (int i = 0; i < provinces.length; i++) {
			provinceData = new JSONObject();
			provinceData.put("name", provinces[i]);
			provinceData.put("value", valueList.get(i));
			dataArr.add(provinceData);
		}
		
		return dataArr;
	}

	/****************************以上为地图数据测试--结束********************************************/
	
	
	
	
	public String getPublicSourceType() {
		return publicSourceType;
	}

	public void setPublicSourceType(String publicSourceType) {
		this.publicSourceType = publicSourceType;
	}

	public CrElecPayService getCrElecPayService() {
		return crElecPayService;
	}

	public void setCrElecPayService(CrElecPayService crElecPayService) {
		this.crElecPayService = crElecPayService;
	}

	public CrWaterPayService getCrWaterPayService() {
		return crWaterPayService;
	}

	public void setCrWaterPayService(CrWaterPayService crWaterPayService) {
		this.crWaterPayService = crWaterPayService;
	}

	public CrGasPayService getCrGasPayService() {
		return crGasPayService;
	}

	public void setCrGasPayService(CrGasPayService crGasPayService) {
		this.crGasPayService = crGasPayService;
	}

	public CrWaterSewageDischargePayService getCrWaterSewageDischargePayService() {
		return crWaterSewageDischargePayService;
	}

	public void setCrWaterSewageDischargePayService(
			CrWaterSewageDischargePayService crWaterSewageDischargePayService) {
		this.crWaterSewageDischargePayService = crWaterSewageDischargePayService;
	}
	
}
