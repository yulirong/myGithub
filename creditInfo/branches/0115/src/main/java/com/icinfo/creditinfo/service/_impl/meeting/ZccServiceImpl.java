package com.icinfo.creditinfo.service._impl.meeting;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.icinfo.creditinfo.bean.analy.cranalyentrelation.CrAnalyEntRelation;
import com.icinfo.creditinfo.bean.biz.crrelationnetall.CrRelationNetAll;
import com.icinfo.creditinfo.bean.biz.relationalnet.CorpNode;
import com.icinfo.creditinfo.bean.meeting.Zcc;
import com.icinfo.creditinfo.dao.meeting.ZccDao;
import com.icinfo.creditinfo.service.meeting.ZccService;
import com.icinfo.plugin.common.StringUtil;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.plugin.util.EntNameUtil;

public class ZccServiceImpl extends HxBaseServiceImpl<Zcc> implements ZccService{
	
	/** 
	 * 描述: 获取关系节点和关系连线数据
	 * 
	 * @author zhuyong
	 * @date 2015-10-31 
	 * @param entName
	 * @param corpid
	 * @return
	 * @throws Exception 
	 */
	
	public Map<String,Object> doGetNodeAndLink(CorpNode corpNode,Map<String,String> paramMap) throws Exception{
		Map<String,Object> qryMap = new HashMap<String,Object>();
		List<String> nodeList = new ArrayList<String>();
		List<String> linkList = new ArrayList<String>();
		nodeList.add("{category:0, name: '"+corpNode.getName()+"',label:'"+corpNode.getName()+"',value : 10,nodeType:'1',corpid:'"+corpNode.getName()+"',certNo:''}");
//		paramMap.put("noCorpid", corpNode.getCorpid());
		List<CorpNode> nextNodeList = new ArrayList<CorpNode>();
		nextNodeList.add(corpNode);
		/** 获取所有的 节点数据 和 关系数据 */
		nextNodeList = doGetAllChidNodeAndLink(nextNodeList,nodeList,linkList,paramMap);
		nextNodeList = removeDuplicateCorpNode(nextNodeList);
		nodeList = removeDuplicate(nodeList);
		linkList = removeDuplicate(linkList);
		qryMap.put("nodeList", nodeList);
		qryMap.put("linkList", linkList);
		return qryMap;
	}
	
	/** 
	 * 描述: 获取关系数据
	 * 
	 * @author zhuyong
	 * @date 2015-11-30 
	 * @param corpNodeList
	 * @param nodeList
	 * @param linkList
	 * @return
	 * @throws Exception 
	 */
	
	public List<CorpNode> doGetAllChidNodeAndLink(List<CorpNode> corpNodeList,List<String> nodeList,List<String> linkList,Map<String,String> paramMap) throws Exception{
		List<CorpNode> tempNodeList = new ArrayList<CorpNode>();
		List<CorpNode> tempotherNodeList = new ArrayList<CorpNode>();
		for(CorpNode corpNode: corpNodeList){
			tempNodeList.addAll(doGetCorpChildNodeAndLink(corpNode,tempotherNodeList,nodeList,linkList,paramMap));
		}
		return tempNodeList;
	}
	
	
	/** 
	 * 描述: 企业关联关系
	 * 
	 * @author zhuyong
	 * @date 2015-11-30
	 * @param entName
	 * @param parentCorpid
	 * @param nodeList
	 * @param linkList
	 * @return
	 * @throws Exception 
	 */
	
	public  List<CorpNode> doGetCorpChildNodeAndLink(CorpNode corpNode,List<CorpNode> corpNodeList,List<String> nodeList,List<String> linkList,Map<String,String> paramMap) throws Exception{
		Map<String,Object> baseMap = new HashMap<String,Object>();
		baseMap.put("relSource", corpNode.getCorpid());
		List<Zcc> dataList = new ArrayList<Zcc>();
		List<Zcc> allList = new ArrayList<Zcc>();
		dataList = doGetZccDao().selectList(baseMap);
		allList.addAll(dataList);
		for (Zcc bean : allList) {
			nodeList.add("{category:2, name: '"+bean.getRelTarget()+"',label:'"+bean.getRelTarget()+"',value : 2,corpid:'"+bean.getRelTarget()+"',certNo:'',nodeType:'1'}");
			corpNodeList.add(new CorpNode(bean.getRelTarget(),"",bean.getRelTarget(),"","1"));
			String lineColor = "blue";
			linkList.add("{source : '"+bean.getRelSource()+"', target : '"+bean.getRelTarget()+"', weight : 1,itemStyle: { normal: {width: 1,color: '"+lineColor+"'}},name: '"+bean.getRelTarget()+"'}");
		}
		return corpNodeList;
	}
	
	
	/** 
	 * 描述: 移除重复数据
	 * 
	 * @author zhuyong
	 * @date 2015-10-31  
	 * @param list
	 * @return 
	 */
	
	List<String> removeDuplicate(List<String> list)
	{
		HashSet<String> hashSet = new HashSet<String>(list);
		list.clear();
		list.addAll(hashSet);
		return list;
	}
	
	/** 
	 * 描述: 对象相等
	 * 
	 * @author zhuyong
	 * @date 2015-11-30
	 * @param list
	 * @return 
	 */
	
	List<CorpNode> removeDuplicateCorpNode(List<CorpNode> list){
		List<CorpNode> tempList= new ArrayList<CorpNode>(); 
		for(CorpNode tempNode:list){
			if(!tempList.contains(tempNode)) tempList.add(tempNode);
		}
	
		return tempList;
	}
	
	
	
	
	public Map<String, Object> doBuildData(List<Zcc> dataList,String userName) throws Exception{
		Map<String,Object> rstMap = new HashMap<String, Object>();
		JSONArray nodeArr = new JSONArray();
		JSONArray linkArr = new JSONArray();
		JSONObject nodeObj = new JSONObject();
		JSONObject linkObj = new JSONObject();
		List<String> nameList = new ArrayList<String>();
		if(dataList!=null && dataList.size()>0){
			for (Zcc data : dataList) {
				nodeObj = new JSONObject();
				if(!nameList.contains(data.getRelSource())){
					nameList.add(data.getRelSource());
					nodeObj = new JSONObject();
					nodeObj.put("name", data.getRelSource());
					if(data.getRelSource().equals(userName)){
						nodeObj.put("category", "1");	
					}else {
						nodeObj.put("category", "0");
					}
					nodeObj.put("label", data.getRelSource());
					nodeArr.add(nodeObj);
				}
				if(!nameList.contains(data.getRelTarget())){
					nameList.add(data.getRelTarget());
					nodeObj = new JSONObject();
					nodeObj.put("name", data.getRelTarget());
					if(data.getRelTarget().equals(userName)){
						nodeObj.put("category", "1");	
					}else {
						nodeObj.put("category", "0");
					}
					nodeObj.put("label", data.getRelTarget());
					nodeArr.add(nodeObj);
				}

				linkObj.put("source", data.getRelSource());
				linkObj.put("target", data.getRelTarget());
				linkArr.add(linkObj);
			}
		}
		rstMap.put("nodeList", nodeArr);
		rstMap.put("linkList", linkArr);
		return rstMap;
	}
	
	public ZccDao doGetZccDao(){
		return (ZccDao)hxBaseDao;
	}
}
