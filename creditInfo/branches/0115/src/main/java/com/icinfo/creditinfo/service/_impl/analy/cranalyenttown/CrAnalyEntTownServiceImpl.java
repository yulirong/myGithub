/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-11-28
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.analy.cranalyenttown;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.icinfo.creditinfo.bean.analy.cranalyenttown.CrAnalyEntTown;
import com.icinfo.creditinfo.dao.analy.cranalyenttown.CrAnalyEntTownDao;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.analy.cranalyenttown.CrAnalyEntTownService;
/**
 * 
 * 描述: 特色小镇 Service 实现<br>
 * @author yulirong
 * @date 2015-11-28
 */
public class CrAnalyEntTownServiceImpl extends HxBaseServiceImpl<CrAnalyEntTown> implements CrAnalyEntTownService
{
	/**
	 * 描述: 获取特色小镇企业数量
	 * 
	 * @author ylr
	 * @date 2015-11-28
	 * @throws Exception
	 */
	public CrAnalyEntTown doGetQyCount() throws Exception{
		return doGetCrAnalyEntTownDao().doGetQyCount();
	}
	/**
	 * 描述: 获取产业特点企业数量
	 * 
	 * @author ylr
	 * @date 2015-11-28
	 * @throws Exception
	 */
	public List<CrAnalyEntTown> doGetIndustryCharacter(Map<String, Object> qryMap) throws Exception{
		return doGetCrAnalyEntTownDao().doGetIndustryCharacter(qryMap);
	}
	
	/**
	 * 描述：获取企业规模大小数据
	 * 
	 * @author zhuyong
	 * @date 2015-11-28
	 * @param dataList
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyEntTown> doGetQyScaleDataList(Map<String,Object> qryMap) throws Exception{
		return doGetCrAnalyEntTownDao().doSelectQyScaleDataList(qryMap);
	}
	
	
	/**
	 * 描述：构建企业规模大小返回数据
	 * 
	 * @author zhuyong
	 * @date 2015-11-28
	 * @param dataList
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> doBuildQyScale(List<CrAnalyEntTown> dataList) throws Exception{
		Map<String,Object> rstMap = new HashMap<String, Object>();
		rstMap.put("dataList", null);
		rstMap.put("legendList", null);
		if(dataList==null || dataList.size()==0){
			return rstMap;
		}
		JSONArray dataArr = new JSONArray();
		JSONObject dataObj = new JSONObject();
		JSONArray legArr = new JSONArray();
		JSONObject legObj = new JSONObject();
		for (CrAnalyEntTown town : dataList) {
			if(!doRefelectQyScale(town.getQyScale()).equals("")){
				dataObj.put("name", doRefelectQyScale(town.getQyScale()));
				legObj.put("name",doRefelectQyScale(town.getQyScale()));
				dataObj.put("value", town.getQyCount());
				dataArr.add(dataObj);
				legArr.add(legObj);
			}
		}
		rstMap.put("dataList", dataArr);
		rstMap.put("legendList", legArr);
		return rstMap;
	}

	
	/**
	 * 描述：构建规模范围
	 * 
	 * @author zhuyong
	 * @param scale
	 * @return
	 */
	private String doRefelectQyScale(String scale){
		if(StringUtils.isBlank(scale)){
			return "";
		}
		if(scale.equals("1")){
			return "10万以下";
		}else if(scale.equals("2")){
			return "10-50万";
		}else if(scale.equals("3")){
			return "50-100万";
		}else if(scale.equals("4")){
			return "100-500万";
		}else if(scale.equals("5")){
			return "500万以上";
		}
		return "";
		
	}
	/**
	 * 描述：运营状况
	 * 
	 * @author ylr
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyEntTown> doGetOperationStatus(Map<String, Object> qryMap) throws Exception{
		return doGetCrAnalyEntTownDao().doGetOperationStatus(qryMap);
	}
	/**
	 * 描述：资产总额
	 * 
	 * @author ylr
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyEntTown> doGetTotalAsset(Map<String, Object> qryMap) throws Exception{
		return doGetCrAnalyEntTownDao().doGetTotalAsset(qryMap);
	}
	/**
	 * 描述：盈利状况
	 * 
	 * @author ylr
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyEntTown> doGetProfitStatus(Map<String, Object> qryMap) throws Exception{
		return doGetCrAnalyEntTownDao().doGetProfitStatus(qryMap);
	}
	/**
	 * 描述：盈利企业数量
	 * 
	 * @author ylr
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyEntTown> doGetProfitTotal(Map<String, Object> qryMap) throws Exception{
		return doGetCrAnalyEntTownDao().doGetProfitTotal(qryMap);
	}
	/**
	 * 描述：对周边经济的影响程度
	 * 
	 * @author ylr
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyEntTown> doGetLocalEconomy(Map<String, Object> qryMap) throws Exception{
		return doGetCrAnalyEntTownDao().doGetLocalEconomy(qryMap);
	}
	/**
	 * 描述：对行业的影响程度
	 * 
	 * @author ylr
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyEntTown> doGetLocalIndustry(Map<String, Object> qryMap) throws Exception{
		return doGetCrAnalyEntTownDao().doGetLocalIndustry(qryMap);
	}
	/**
	 * 描述：就业贡献
	 * 
	 * @author ylr
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyEntTown> doGetEmploymentContribution(Map<String, Object> qryMap) throws Exception{
		return doGetCrAnalyEntTownDao().doGetEmploymentContribution(qryMap);
	}
	
	
	public CrAnalyEntTownDao doGetCrAnalyEntTownDao()
	{
		return (CrAnalyEntTownDao)hxBaseDao;
	}
}
