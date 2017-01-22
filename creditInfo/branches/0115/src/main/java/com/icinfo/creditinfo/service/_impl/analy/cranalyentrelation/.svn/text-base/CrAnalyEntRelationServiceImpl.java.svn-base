/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-11-16
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.analy.cranalyentrelation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.icinfo.creditinfo.arithmetic.pathseach.NodeRoad;
import com.icinfo.creditinfo.arithmetic.pathseach.PathPractise;
import com.icinfo.creditinfo.arithmetic.pathseach.Visit;
import com.icinfo.creditinfo.bean.analy.cranalyentrelation.CrAnalyEntRelation;
import com.icinfo.creditinfo.dao.analy.cranalyentrelation.CrAnalyEntRelationDao;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.plugin.util.EntNameUtil;
import com.icinfo.creditinfo.service.analy.cranalyentrelation.CrAnalyEntRelationService;
/**
 * 
 * 描述: 企业关系 Service 实现<br>
 * @author zhuyong
 * @date 2015-11-16
 */
public class CrAnalyEntRelationServiceImpl extends HxBaseServiceImpl<CrAnalyEntRelation> implements CrAnalyEntRelationService
{
	Visit visit;
	/**
	 * 描述：统计企业个数
	 * 
	 * @author zhuyong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public CrAnalyEntRelation doCountEntTotal(Map<String,Object> qryMap) throws Exception{
		return doGetCrAnalyEntRelationDao().doCountEntTotal(qryMap);
	}
	
	/**
	 * 描述：获取不同级别数字
	 * 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyEntRelation>  doGetRistLevelTotal(Map<String,Object> qryMap) throws Exception{
		return doGetCrAnalyEntRelationDao().doGetRistLevelTotal(qryMap);
	}
	
	/**
	 * 描述：构建返回结果集
	 * 
	 * @author zhuyong
	 * @date 2015-11-16
	 * @param dataList
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> doBuildDataList(List<CrAnalyEntRelation> dataList,String corpid) throws Exception{
		Map<String,Object> rstMap = new HashMap<String, Object>();
		JSONArray nodeArr = new JSONArray();
		JSONArray linkArr = new JSONArray();
		JSONObject nodeObj = new JSONObject();
		JSONObject linkObj = new JSONObject();
		List<String> nameList = new ArrayList<String>();
		if(dataList!=null && dataList.size()>0){
			for (CrAnalyEntRelation data : dataList) {
				nodeObj = new JSONObject();
				if(!nameList.contains(data.getNbxh())){
					nameList.add(data.getNbxh());
					nodeObj = new JSONObject();
					nodeObj.put("name", data.getNbxh());
					nodeObj.put("value", 1);
					if(corpid.equals(data.getNbxh())){
						nodeObj.put("category", 4);
					}else {
						nodeObj.put("category", doReflectRistLevelCate(data.getRistLevel()));
					}
					nodeObj.put("mc", data.getFromQymc());
					nodeObj.put("label", EntNameUtil.getShortName(data.getFromQymc()));
					nodeObj.put("corpid", data.getNbxh());
					nodeArr.add(nodeObj);
				}

				linkObj.put("source", data.getSfzjhm());
				linkObj.put("target", data.getNbxh());
				linkObj.put("mc", data.getRelName());
				linkArr.add(linkObj);
			}
			for (CrAnalyEntRelation data : dataList) {
				if(!nameList.contains(data.getSfzjhm())){
					nameList.add(data.getSfzjhm());
					nodeObj = new JSONObject();
					nodeObj.put("name", data.getSfzjhm());
					nodeObj.put("value", 1);
					if (corpid.equals(data.getSfzjhm())) {
						nodeObj.put("category",4);
					}else {
						nodeObj.put("category",0);
					}
					nodeObj.put("mc", data.getXm());
					nodeObj.put("label", EntNameUtil.getShortName(data.getXm()));
					nodeObj.put("certNo", data.getSfzjhm());
					nodeArr.add(nodeObj);
				}
			}
		}
		rstMap.put("nodeList", nodeArr);
		rstMap.put("linkList", linkArr);
		return rstMap;
	}
	
	
	/** 
	 * 描述: 确定路径
	 * @auther gqf
	 * @date 2015年11月23日 
	 * @param relationList
	 * @param corpid
	 * @param resultNodeSet
	 * @return 
	 */
	public Map<String,Object> doGetSearchNodePath(List<CrAnalyEntRelation> relationList,String begin,String end) 
	 throws Exception{
		Map<String,Object> rstMap = new HashMap<String, Object>();
		JSONArray nodeArr = new JSONArray();
		JSONArray linkArr = new JSONArray();
		JSONObject nodeObj = new JSONObject();
		JSONObject linkObj = new JSONObject();
		relationList = doWrapRelation(relationList,begin,end);
		/*for(CrAnalyEntRelation crAnalyEntRelation:relationList){
			System.out.println(crAnalyEntRelation);
		}
		System.out.println("--------------------"+relationList.size());*/
		/*
		relationList = doWrapRelation(relationList,begin,end);
		
		
		for(CrAnalyEntRelation crAnalyEntRelation:relationList){
			System.out.println(crAnalyEntRelation);
		}
		System.out.println("--------------------"+relationList.size());*/
		
		List<NodeRoad> roads = visit.init(relationList); 
		Set<String> allNodes = visit.getAllNodes(roads);
		/*for(NodeRoad nodeRoad:roads){
			System.out.println(nodeRoad);
		}
		System.out.println("--------------------"+roads.size());*/
		
		/*Set<String> invalidBegins = new HashSet<String>(); // 无效的起始节点
		Set<String> invalidEnds = new HashSet<String>(); // 无效的结束节点
		Set<String> allNodes = visit.getAllNodes(roads);
		
		visit.filterInvalidNode(allNodes, roads, invalidBegins, invalidEnds,begin,end); //获取到无效开始节点和无效结束点
		Set<NodeRoad> invalidRoads = visit.deleteRoad(invalidBegins, invalidEnds,
				roads); // 获取需要删除的路径
		
		System.out.println("--------------------invalidRoads"+invalidRoads.size());
		roads.removeAll(invalidRoads); // 删除无效的路径
		 */	
		
		
		PathPractise pra = new PathPractise(roads,allNodes);
    	pra.getAllRoad(begin, end);
    	Iterator<String> it = pra.getresultSet().iterator();
     	System.out.println("-----------------从" + begin + "至" + end + "的有效路径如下-----------------");
		while (it.hasNext()) {
			System.out.println(it.next());
		}
    	
    	pra.getRoadResultNode();
    	 Map<String,Object> rstAllMap = doBuildDataList(relationList,begin);
    	 JSONArray nodeAllArr = (JSONArray)rstAllMap.get("nodeList");
    	 JSONArray linkAllArr =(JSONArray)rstAllMap.get("linkList");
    	 for(int i= 0;i < nodeAllArr.size();i++){
    		 nodeObj = nodeAllArr.getJSONObject(i);
    		 if(pra.getResultNode().contains(nodeObj.get("name"))){
    			 if(begin.equals(nodeObj.get("name"))||end.equals(nodeObj.get("name"))){
    				 nodeObj.put("category", "0");
    			 }else{
    				 nodeObj.put("category", "2");
    			 }
    			 if(nodeObj.get("mc") != null && nodeObj.get("mc").toString().length()<5){
    				 nodeObj.put("category", "1");
    			 }
    			 nodeArr.add(nodeObj);
    		 }
    	 }
    	 for(int i=0;i<linkAllArr.size();i++){
    		 linkObj  = linkAllArr.getJSONObject(i);
    		 if(pra.getResultNode().contains(linkObj.get("source"))&&pra.getResultNode().contains(linkObj.get("target"))){
    			 linkArr.add(linkObj);
    		 }
    	 }
    	 
    	 
		
		rstMap.put("nodeList", nodeArr);
		rstMap.put("linkList", linkArr);
		rstMap.put("num", pra.getNum());
		return rstMap;
	}
	  
    /** 
     * 描述: 过滤无用节点
     * 1.判断source节点只有一个同时，
     * 2.source对应的target节点
     * 3.两个同时满足删除
     * @auther gqf
     * @date 2015年11月24日 
     * @return 
     */
    public List<CrAnalyEntRelation> doWrapRelation(List<CrAnalyEntRelation> relationList,String begin,String end){
    	List<CrAnalyEntRelation> tempList = new ArrayList<CrAnalyEntRelation>();
    	for(CrAnalyEntRelation relation:relationList){
    		if(begin.equals(relation.getSfzjhm())||begin.equals(relation.getNbxh())||
    		   end.equals(relation.getSfzjhm())||end.equals(relation.getNbxh())){
    			tempList.add(relation);
    		}else if(isDeleteLink(relationList,relation.getSfzjhm(),relation.getNbxh()) ){
    			continue;
    		}else{
    			tempList.add(relation);
    		}
    	}
    	return tempList;
    }
    // 是否要删除
    public boolean isDeleteLink(List<CrAnalyEntRelation> relationList,String sfzjhm,String nbxh){
        if(countNode(relationList,sfzjhm)){
        	return true;
        }else if(countNbxh(relationList,nbxh)){
        	return true;
        }
    	return false;
    }
    
    public boolean countNode(List<CrAnalyEntRelation> relationList,String nodeName){
    	int source = 0;
    	int target = 0;
    	for(CrAnalyEntRelation relation:relationList){
    		if(nodeName.equals(relation.getSfzjhm())){
    			source++;
    		}else if(nodeName.equals(relation.getNbxh())){
    			target++;
    		}
    	}
    	if(source==1 &&target ==0){
    		return true;
    	}else{
    		return false;
    	}
    }
    
 /*   //统计sourceName节点的数量
    public int countSource(List<CrAnalyEntRelation> relationList,String nodeName){
    	int num= 0;
    	for(CrAnalyEntRelation relation:relationList){
    		if(nodeName.equals(relation.getSfzjhm())){
    			num++;
    		}
    	}
    	return num;
    }
  
    //统计targetName节点的数量
    public int countTarget(List<CrAnalyEntRelation> relationList,String nodeName){
    	int num= 0;
    	for(CrAnalyEntRelation relation:relationList){
    		if(nodeName.equals(relation.getNbxh())){
    			num++;
    		}
    	}
    	return num;
    }*/
  //企业数是1，第二轮删除
    public boolean countNbxh(List<CrAnalyEntRelation> relationList,String nodeName){
    	int num= 0;
    	for(CrAnalyEntRelation relation:relationList){
    		if(nodeName.equals(relation.getNbxh())){
    			num++;
    		}
    	}
    	if (num<2){
    		return true;
    	}
    	return false;
    }
	/**
	 * 描述：预警级别不同、颜色不同
	 * 
	 * @author zhuyong
	 * @date 2015-11-16
	 * @param level
	 * @return
	 */
	private Integer doReflectRistLevelCate(String level){
		if(StringUtils.isBlank(level)){
			return 0;
		}else if(level.equals("1")){
			return 1;
		}else if(level.equals("2")){
			return 2;
		}else if(level.equals("3")){
			return 3;
		}else if(level.equals("4")){
			return 4;
		}
		return 0;
	}

	public Visit getVisit() {
		return visit;
	}

	public void setVisit(Visit visit) {
		this.visit = visit;
	}

	public CrAnalyEntRelationDao doGetCrAnalyEntRelationDao()
	{
		return (CrAnalyEntRelationDao)hxBaseDao;
	}
}
