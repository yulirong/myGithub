/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-11-30
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.biz.crrelationnetall;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crrelationnetall.CrRelationNetAll;
import com.icinfo.creditinfo.bean.biz.relationalnet.CorpNode;
import com.icinfo.creditinfo.dao.biz.crrelationnetall.CrRelationNetAllDao;
import com.icinfo.plugin.common.StringUtil;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.plugin.util.EntNameUtil;
import com.icinfo.creditinfo.service.biz.crrelationnetall.CrRelationNetAllService;
/**
 * 
 * 描述: 关系网络汇总信息 Service 实现<br>
 * @author zhuyong
 * @date 2015-11-30
 */
public class CrRelationNetAllServiceImpl extends HxBaseServiceImpl<CrRelationNetAll> implements CrRelationNetAllService
{
	
	/**
	 * 描述：获取关系概要数据
	 * 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public CrRelationNetAll doGetRelationSummaryData(Map<String,Object> qryMap) throws Exception{
		return doGetCrRelationNetAllDao().doSelectRelationSummaryData(qryMap);
	}

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
		nodeList.add("{category:0, name: '"+corpNode.getName()+"',label:'"+corpNode.getName()+"',value : 10,nodeType:'"+corpNode.getNodeType()+"',corpid:'"+corpNode.getCorpid()+"',certNo:'"+corpNode.getCertNo()+"'}");
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
			if("1".equals(corpNode.getNodeType())){
				tempNodeList.addAll(doGetCorpChildNodeAndLink(corpNode,tempotherNodeList,nodeList,linkList,paramMap));
			}else{
				if(null == corpNode.getCertNo()||"".equals(corpNode.getCertNo())){
					continue;
				}
				List<CorpNode> tempNodeListperson =doGetPersonalChildNodeAndLink(corpNode,tempotherNodeList,nodeList,linkList,paramMap);
				tempNodeList.addAll(tempNodeListperson);
			}
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
		Map<String,Object> qryMap = new HashMap<String,Object>();
		baseMap.put("fromCorpid", corpNode.getCorpid());
		String isFrgx = paramMap.get("isFrgx");//法定代表人
		String isGdgx = paramMap.get("isGdgx");//股东关系
		String isGjglgx = paramMap.get("isGjglgx");//高管关系
		String isDbgx = paramMap.get("isDbgx");//担保关系
		List<CrRelationNetAll> dataList = new ArrayList<CrRelationNetAll>();
		List<CrRelationNetAll> allList = new ArrayList<CrRelationNetAll>();
		if("1".equals(isFrgx)){//获取法定代表人信息
			qryMap.clear();
			qryMap.putAll(baseMap);
			qryMap.put("relateName","HZ_QYFDDBR");
			dataList = doGetCrRelationNetAllDao().selectList(qryMap);
			allList.addAll(dataList);
		}
		
		if("1".equals(isGdgx)){//获取股东关系信息
			qryMap.clear();
			qryMap.putAll(baseMap);
			qryMap.put("relateName","HZ_QYTZF");
			qryMap.put("stake",paramMap.get("isGdgxSlt"));
			dataList = doGetCrRelationNetAllDao().selectList(qryMap);
			allList.addAll(dataList);
		}
		
		if("1".equals(isGjglgx)){//获取高管关系信息
			qryMap.clear();
			qryMap.putAll(baseMap);
			qryMap.put("relateName","HZ_QYDSJLRY");
			qryMap.put("zwrel", StringUtil.strSplitAddToList(paramMap.get("isGjglgxSlt")));
			dataList = doGetCrRelationNetAllDao().selectList(qryMap);
			allList.addAll(dataList);
		}
		
		if("1".equals(isDbgx)){//获取担保关系人信息
			qryMap.clear();
			qryMap.putAll(baseMap);
			qryMap.put("relateName","CR_ANALY_GU");
			dataList = doGetCrRelationNetAllDao().selectList(qryMap);
			allList.addAll(dataList);
		}
		
		for (CrRelationNetAll bean : allList) {
			if("2".equals(bean.getToType())){//个人节点
				nodeList.add("{category:1, name: '"+bean.getToName()+"',value : 2,corpid:'',certNo:'"+bean.getToCorpid()+"',nodeType:'2'}");
				corpNodeList.add(new CorpNode(bean.getToName(),"","",bean.getToCorpid(),"2"));
			}else{//企业节点
				nodeList.add("{category:2, name: '"+bean.getToName()+"',label:'"+EntNameUtil.getShortName(bean.getToName())+"',value : 2,corpid:'"+bean.getToCorpid()+"',certNo:'',nodeType:'1'}");
				corpNodeList.add(new CorpNode(bean.getToName(),"",bean.getToCorpid(),"","1"));
			}
			String lineColor = "blue";
			if(bean.getRelateName().equals("HZ_QYDSJLRY")){
				lineColor = "blue";
			}else if(bean.getRelateName().equals("HZ_QYTZF")){
				lineColor = "red";
			}else if(bean.getRelateName().equals("CR_ANALY_GU")){
				lineColor = "maroon";
			}else if(bean.getRelateName().equals("HZ_QYFDDBR")){
				lineColor = "blue";
			}
			linkList.add("{source : '"+corpNode.getName()+"', target : '"+bean.getToName()+"', weight : 1,itemStyle: { normal: {width: 1,color: '"+lineColor+"'}},name: '"+bean.getRelateDetail()+"'}");
		}
		return corpNodeList;
	}
	
	/** 
	 * 描述: 自然人 关联关系
	 * 
	 * @author zhuyong
	 * @date 2015-12-01 
	 * @param frdbsfz
	 * @param parentCorpid
	 * @param nodeList
	 * @param linkList
	 * @return 
	 */
	
	public  List<CorpNode> doGetPersonalChildNodeAndLink(CorpNode corpNode,List<CorpNode> corpNodeList,List<String> nodeList,List<String> linkList,Map<String,String> paramMap) throws Exception {
		Map<String,Object> baseMap = new HashMap<String,Object>();
		Map<String,Object> qryMap = new HashMap<String,Object>();
		baseMap.put("toCorpid", corpNode.getCertNo());
		String isFrgx = paramMap.get("isFrgx");//法定代表人
		String isGdgx = paramMap.get("isGdgx");//股东关系
		String isGjglgx = paramMap.get("isGjglgx");//高管关系
		String isDbgx = paramMap.get("isDbgx");//担保关系
		String isPougx = paramMap.get("isPougx");//配偶关系
		List<CrRelationNetAll> dataList = new ArrayList<CrRelationNetAll>();
		List<CrRelationNetAll> allList = new ArrayList<CrRelationNetAll>();
		if("1".equals(isFrgx)){//获取法定代表人信息
			qryMap.clear();
			qryMap.putAll(baseMap);
			qryMap.put("relateName","HZ_QYFDDBR");
			dataList = doGetCrRelationNetAllDao().selectList(qryMap);
			allList.addAll(dataList);
		}
		
		if("1".equals(isGdgx)){//获取股东关系信息
			qryMap.clear();
			qryMap.putAll(baseMap);
			qryMap.put("relateName","HZ_QYTZF");
			qryMap.put("stake",paramMap.get("isGdgxSlt"));
			dataList = doGetCrRelationNetAllDao().selectList(qryMap);
			allList.addAll(dataList);
		}
		
		if("1".equals(isGjglgx)){//获取高管关系信息
			qryMap.clear();
			qryMap.putAll(baseMap);
			qryMap.put("relateName","HZ_QYDSJLRY");
			qryMap.put("zwrel", StringUtil.strSplitAddToList(paramMap.get("isGjglgxSlt")));
			dataList = doGetCrRelationNetAllDao().selectList(qryMap);
			allList.addAll(dataList);
		}
		
		if("1".equals(isDbgx)){//获取担保关系人信息
			qryMap.clear();
			qryMap.putAll(baseMap);
			qryMap.put("relateName","CR_ANALY_GU");
			dataList = doGetCrRelationNetAllDao().selectList(qryMap);
			allList.addAll(dataList);
		}
		
		if("1".equals(isPougx)){//配偶关系
			qryMap.clear();
			qryMap.putAll(baseMap);
			qryMap.put("relateName","TEMP_MATES");
			dataList = doGetCrRelationNetAllDao().selectList(qryMap);
			for (CrRelationNetAll bean : dataList) {
				nodeList.add("{category:1, name: '"+bean.getFromName()+"',value : 2,corpid:'',certNo:'"+bean.getFromCorpid()+"',nodeType:'2'}");
				corpNodeList.add(new CorpNode(bean.getFromName(),"","",bean.getFromCorpid(),"2"));
				String lineColor = "blue";
				linkList.add("{source : '"+corpNode.getName()+"', target : '"+bean.getFromName()+"', weight : 1,itemStyle: { normal: {width: 1,color: '"+lineColor+"'}},name: '"+bean.getRelateDetail()+"'}");
			}
		}
		
		for (CrRelationNetAll bean : allList) {
			nodeList.add("{category:2, name: '"+bean.getFromName()+"',label:'"+EntNameUtil.getShortName(bean.getFromName())+"',value : 2,corpid:'"+bean.getFromCorpid()+"',certNo:'',nodeType:'1'}");
			corpNodeList.add(new CorpNode(bean.getFromName(),"",bean.getFromCorpid(),"","1"));
			String lineColor = "blue";
			if(bean.getRelateName().equals("HZ_QYDSJLRY")){
				lineColor = "blue";
			}else if(bean.getRelateName().equals("HZ_QYTZF")){
				lineColor = "red";
			}else if(bean.getRelateName().equals("CR_ANALY_GU")){
				lineColor = "maroon";
			}else if(bean.getRelateName().equals("HZ_QYFDDBR")){
				lineColor = "blue";
			}
			linkList.add("{source : '"+bean.getFromName()+"', target : '"+corpNode.getName()+"', weight : 1,itemStyle: { normal: {width: 1,color: '"+lineColor+"'}},name: '"+bean.getRelateDetail()+"'}");
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
	
	public CrRelationNetAllDao doGetCrRelationNetAllDao()
	{
		return (CrRelationNetAllDao)hxBaseDao;
	}
}
