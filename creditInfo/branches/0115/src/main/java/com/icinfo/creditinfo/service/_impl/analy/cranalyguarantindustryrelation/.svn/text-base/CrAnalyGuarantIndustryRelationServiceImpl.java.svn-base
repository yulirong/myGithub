/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-10-23
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.analy.cranalyguarantindustryrelation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.analy.cranalyguarantindustryrelation.CrAnalyGuarantIndustryRelation;
import com.icinfo.creditinfo.bean.analy.cranalyguarantindustryrelation.GuarantIndustryNode;
import com.icinfo.creditinfo.dao.analy.cranalyguarantindustryrelation.CrAnalyGuarantIndustryRelationDao;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.analy.cranalyguarantindustryrelation.CrAnalyGuarantIndustryRelationService;
/**
 * 
 * 描述: 行业担保关系 Service 实现<br>
 * @author zhuyong
 * @date 2015-10-23
 */
public class CrAnalyGuarantIndustryRelationServiceImpl 
	extends HxBaseServiceImpl<CrAnalyGuarantIndustryRelation> implements CrAnalyGuarantIndustryRelationService
{
	/***
	 * desc：获取所有行业名称
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<String> doGetIndustryTypeList(Map<String,Object> qryMap) throws Exception{
		return doGetCrAnalyGuarantIndustryRelationDao().doGetIndustryTypeList(qryMap);
	}
	
	/**
	 * 描述：获取行业担保数排行
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyGuarantIndustryRelation> doGetCrAnalyGuarantRelationRank(Map<String,Object> qryMap) throws Exception{
		return doGetCrAnalyGuarantIndustryRelationDao().doSelectCrAnalyGuarantRelationRank(qryMap);
	}

	/**
	 * desc:构造节点数据
	 * 
	 * @author zhuyong
	 * @param typeList
	 * @return
	 * @throws Exception
	 */
	public List<GuarantIndustryNode> doBuildNodeList(List<String> typeList) throws Exception{
		List<GuarantIndustryNode> nodeList = new ArrayList<GuarantIndustryNode>();
		GuarantIndustryNode node = new GuarantIndustryNode();
		for (String name : typeList) {
			node.setName(name);
			nodeList.add(node);
			node = new GuarantIndustryNode();
		}
		return nodeList;
	}
	
	
	/**
	 * desc:构造echarts所需数据
	 * 
	 * @author zhuyong
	 * @param typeList
	 * @param dataList
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> doBuildDataMap(List<String> typeList,List<CrAnalyGuarantIndustryRelation> dataList) throws Exception{
		List<List<Integer>> inDataList = doCreateMatrixList(typeList.size());//对内数据集
		List<List<Integer>> outDataList = doCreateMatrixList(typeList.size());//对外数据集
		Map<String,Object> dataMap = new HashMap<String, Object>();
		int row = 0;
		int col = 0;
		for (int i = 0; i < dataList.size(); i++) {
			CrAnalyGuarantIndustryRelation obj = dataList.get(i);
			if(obj.getIndGuarantee().equals(obj.getIndGuarantor())){//对内担保
				row = typeList.indexOf(obj.getIndGuarantee());
				col = typeList.indexOf(obj.getIndGuarantor());
				inDataList.get(row).set(col,obj.getIndNumber().intValue());
			}else{//对外担保
				row = typeList.indexOf(obj.getIndGuarantee());
				col = typeList.indexOf(obj.getIndGuarantor());
				outDataList.get(row).set(col,obj.getIndNumber().intValue());
			}
		}
		dataMap.put("inDataList",inDataList);
		dataMap.put("outDataList",outDataList);
		return dataMap;
	}
	
	
	/**
	 * desc:构造一个矩阵list
	 * 
	 * @author zhuyong
	 * @param size
	 * @return
	 * @throws Exception
	 */
	public List<List<Integer>> doCreateMatrixList(int size) throws Exception{
		List<List<Integer>> matList = new ArrayList<List<Integer>>();
		List<Integer> intList = new ArrayList<Integer>();
		for (int i = 0; i <size; i++) {
			for (int j = 0; j < size; j++) {
				intList.add(0);
			}
			matList.add(intList);
			intList = new ArrayList<Integer>();
		}
		return matList;
	}
	
	
	/**
	 * desc:构建返回数据字符串
	 * 
	 * @author zhuyong
	 * @param dataList
	 * @return
	 * @throws Exception
	 */
	public String doBuildDataStr(List<List<Integer>> dataList) throws Exception{
		StringBuffer buf = new StringBuffer();
		String temp="";
		String rst = "";
		for (List<Integer> list : dataList) {
			temp = list.toString().replaceAll(" ", "");
			buf.append(temp.substring(1, temp.length()-1));
			buf.append("_");
		}
		rst = buf.toString();
		return rst.substring(0,rst.length()-1);
	}
	
	
	
	public CrAnalyGuarantIndustryRelationDao doGetCrAnalyGuarantIndustryRelationDao()
	{
		return (CrAnalyGuarantIndustryRelationDao)hxBaseDao;
	}
}



