/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.analy.cranalyguarantrelationdata;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.icinfo.creditinfo.bean.analy.cranalyguarantrelationdata.CrAnalyGuarantRelationData;
import com.icinfo.creditinfo.dao.analy.cranalyguarantrelationdata.CrAnalyGuarantRelationDataDao;
import com.icinfo.plugin.common.AESEUtil;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.plugin.util.EntNameUtil;
import com.icinfo.creditinfo.service.analy.cranalyguarantrelationdata.CrAnalyGuarantRelationDataService;
/**
 * 
 * 描述: 担保圈分析 Service 实现<br>
 * @author zhuyong
 * @date 2015-11-12
 */
public class CrAnalyGuarantRelationDataServiceImpl extends HxBaseServiceImpl<CrAnalyGuarantRelationData> implements CrAnalyGuarantRelationDataService
{
	
	/**
	 * 描述：获取担保圈涉及的企业数和人数
	 * 
	 * @author zhuyong
	 * @date 2015-11-24
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyGuarantRelationData> doGetGuarantEntryTotal(Map<String,Object> qryMap) throws Exception{
		return doGetCrAnalyGuarantRelationDataDao().doSelectGuarantEntryTotal(qryMap);
	}
	
	/**
	 * 描述：获取担保群数
	 * 
	 * @author zhuyong
	 * @date 2015-11-24
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public Integer doGetGuarantGroupTotal(Map<String,Object> qryMap) throws Exception{
		return doGetCrAnalyGuarantRelationDataDao().doSelectGuarantGroupTotal(qryMap);
	}
	
	
	/**
	 * 描述：获取双向担保详情
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyGuarantRelationData> doGetDoubleGuarantList(Map<String,Object> qryMap) throws Exception{
		return doGetCrAnalyGuarantRelationDataDao().doSelectDoubleGuarantList(qryMap);
	}
	
	/**
	 * 描述：获取无反担保企业数量
	 * 
	 * @author 朱勇
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public Integer doGetNoReturnGuarantTotal(Map<String,Object> qryMap) throws Exception{
		return doGetCrAnalyGuarantRelationDataDao().doSelectNoReturnGuarantTotal(qryMap);
	}
	
	/**
	 * 描述：构建返回Map
	 * 
	 * @author zhuyong
	 * @param dataList
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> doBuildResultMap(List<CrAnalyGuarantRelationData> dataList) throws Exception{
		Map<String,Object> rstMap = new HashMap<String, Object>();
		JSONArray nodeArr = new JSONArray();
		JSONArray linkArr = new JSONArray();
		JSONArray cateArr = new JSONArray();
		JSONObject nodeObj = new JSONObject();
		JSONObject linkObj = new JSONObject();
		JSONObject cateObj = new JSONObject();
		List<String> nameList = new ArrayList<String>();
		List<String> cateList = new ArrayList<String>();
		for (CrAnalyGuarantRelationData data : dataList) {
			/** 担保圈圈类别 */
			if(!cateList.contains(data.getRelGuaNo())){
				cateList.add(data.getRelGuaNo());
				cateObj = new JSONObject();
				cateObj.put("name", data.getRelGuaNo());
				cateObj.put("symbol", "circle");
				cateObj.put("symbolSize", 4);
				cateArr.add(cateObj);
			}
			nodeObj = new JSONObject();
			if(!nameList.contains(data.getRelGuaranteeName())){
				nameList.add(data.getRelGuaranteeName());
				nodeObj = new JSONObject();
				nodeObj.put("name", data.getRelGuaranteeName());
				nodeObj.put("label", EntNameUtil.getShortName(data.getRelGuaranteeName()));
				nodeObj.put("value", 1);
				nodeObj.put("category", data.getRelGuaNo());
				if(StringUtils.isBlank(data.getCorpid())){
					nodeObj.put("corpid", "-1");
				}else{
					nodeObj.put("corpid", AESEUtil.encryptContext(data.getCorpid()));
				}
				nodeArr.add(nodeObj);
			}
			if(!nameList.contains(data.getRelGuarantorName())){
				nameList.add(data.getRelGuarantorName());
				nodeObj = new JSONObject();
				nodeObj.put("name", data.getRelGuarantorName());
				nodeObj.put("label", EntNameUtil.getShortName(data.getRelGuarantorName()));
				nodeObj.put("value", 1);
				nodeObj.put("category", data.getRelGuaNo());
				nodeObj.put("corpid", "-1");
				nodeArr.add(nodeObj);
			}
			
			linkObj.put("target", data.getRelGuarantorName());
			linkObj.put("source", data.getRelGuaranteeName());
			linkArr.add(linkObj);
		}
		rstMap.put("nodeList", nodeArr);
		rstMap.put("linkList", linkArr);
		rstMap.put("cateList", cateArr);
		return rstMap;
	}
	
	
	/**
	 * 描述：构建返回Map
	 * 
	 * @author zhuyong
	 * @param dataList
	 * @return
	 * @throws Exception
	 */
	public Map<String, Object> doBuildFullScreenResultMap(List<CrAnalyGuarantRelationData> dataList) throws Exception{
		Map<String,Object> rstMap = new HashMap<String, Object>();
		JSONArray nodeArr = new JSONArray();
		JSONArray linkArr = new JSONArray();
		JSONArray cateArr = new JSONArray();
		JSONObject nodeObj = new JSONObject();
		JSONObject linkObj = new JSONObject();
		JSONObject cateObj = new JSONObject();
		List<String> nameList = new ArrayList<String>();
		List<String> cateList = new ArrayList<String>();
		/** 担保圈圈类别 */
		cateObj = new JSONObject();
		cateObj.put("name","0");
		cateObj.put("symbol", "circle");
		cateObj.put("symbolSize", 10);
		cateArr.add(cateObj);
		for (CrAnalyGuarantRelationData data : dataList) {
			nodeObj = new JSONObject();
			if(!nameList.contains(data.getRelGuaranteeName())){
				nameList.add(data.getRelGuaranteeName());
				nodeObj = new JSONObject();
				nodeObj.put("name", data.getRelGuaranteeName());
				nodeObj.put("label", EntNameUtil.getShortName(data.getRelGuaranteeName()));
				nodeObj.put("value", "1");
				nodeObj.put("category", "0");
				if(StringUtils.isBlank(data.getCorpid())){
					nodeObj.put("corpid", "-1");
				}else{
					nodeObj.put("corpid", AESEUtil.encryptContext(data.getCorpid()));
				}
				nodeArr.add(nodeObj);
			}
			if(!nameList.contains(data.getRelGuarantorName())){
				nameList.add(data.getRelGuarantorName());
				nodeObj = new JSONObject();
				nodeObj.put("name", data.getRelGuarantorName());
				nodeObj.put("label", EntNameUtil.getShortName(data.getRelGuarantorName()));
				nodeObj.put("value", "1");
				nodeObj.put("category", "0");
				nodeObj.put("corpid", "-1");
				nodeArr.add(nodeObj);
			}
			
			linkObj.put("target", data.getRelGuarantorName());
			linkObj.put("source", data.getRelGuaranteeName());
			linkArr.add(linkObj);
		}
		rstMap.put("nodeList", nodeArr);
		rstMap.put("linkList", linkArr);
		rstMap.put("cateList", cateArr);
		return rstMap;
	}

	public CrAnalyGuarantRelationDataDao doGetCrAnalyGuarantRelationDataDao()
	{
		return (CrAnalyGuarantRelationDataDao)hxBaseDao;
	}
}
