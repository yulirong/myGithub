package com.icinfo.creditinfo.arithmetic.pathseach;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


/** 
 * 描述:核心算法类
 * @author gqf
 * @date 2015年11月20日  
 */
public class PathPractise {
	public PathPractise(List<NodeRoad> roads,Set<String> allNodes ) {
		this.roadList = roads;
		this.allNodes = allNodes;
	}

	List<NodeRoad> roadList = null; //已知的路径
	List<String> backList = new ArrayList<String>(); //存放已经访问过的节点
	Set<String> resultSet = new HashSet<String>(); //目的路径--访问结果
	//Set<NodeRoad> cirList = new HashSet<NodeRoad>(); 	//回路
	Set<String> resultNode =  new HashSet<String>(); 
	Set<String> allNodes = new HashSet<String>(); 
	/** 
	 * 路径遍历的核心算法
	 * @auther gqf
	 * @date 2015年11月20日 
	 * @param start
	 * @param destination 
	 */
	boolean flag = false;
	int num = 0;
	
	public void getAllRoad(String start, String destination) {
		Map<String,String> nodeMap = new HashMap<String, String>();
		nodeMap.put(start, start);
		String shortPath = getPath(nodeMap,destination);
		
		resultSet.add("["+shortPath+"]");
		
		
		//System.out.println("----------------------");
		//backList.add(start);
		
		//resultNode.add(start);
		/*for (int z = 0; z < roadList.size(); z++) {
			if (roadList.get(z).getBegin().equals(start)) { //寻找找以start开始的路径
				num++;
				if(num > 200000){ //认为找不到关系，不在继续计算
					flag = true;
				}
				//System.out.println(roadList.get(z).getBegin()+":"+roadList.get(z).getEnd());
				if (roadList.get(z).getEnd().equals(destination)) { //如果以destination结尾，则为一条有效路径
					resultSet.add(backList.toString().substring(0, backList.toString().lastIndexOf("]")) + "," + destination + "]");
					//System.out.println(backList.toString().substring(0, backList.toString().lastIndexOf("]")) + "," + destination + "]");

					flag = true;
					break;
					//continue;
				}
				if (!backList.contains(roadList.get(z).getEnd())) {//此节点仍未遍历，则继续迭代
					if(flag){
						return;
					}
				//	getAllRoad(roadList.get(z).getEnd(), destination);
				}
			}
		}*/
		/*if(flag){
			return;
		}
		backList.remove(start);*/
	}
	
	
	/*
	 * 遍历所有节点
	 */
	public String getPath(Map<String, String> nodeMap, String destination){
		 boolean bool = checkAllContain(nodeMap);
		 Map<String,String> map = new HashMap<String, String>();
		 map = getChild(nodeMap,destination);
		 Iterator<String> keys = map.keySet().iterator(); 
		 while(keys.hasNext()) { 
			   String key = (String) keys.next(); 
			   String value  = map.get(key); 
			   if(key.equals(destination)){
				   return value;
			   }
		 }
		 if(bool)
			 return "";
		 return getPath(map,destination);
	}
	boolean checkAllContain(Map<String, String> nodeMap){
		
		Iterator<String> keys = nodeMap.keySet().iterator(); 
		 while(keys.hasNext()) { 
			 if(!backList.contains((String) keys.next())){
				return false;
			 }
		 }
		 return true;
	}
	/*
	 * 获取所有子节点，如果子节点为目标节点，则只返回目标节点，否则返回所有子节点。
	 */
	public Map<String, String> getChild(Map<String, String> nodeMap ,String destination) {
		Map<String,String> map = new HashMap<String, String>();
		
		 Iterator<String> keys = nodeMap.keySet().iterator(); 
		 while(keys.hasNext()) { 
			   String key = (String) keys.next(); 
			   String value  = nodeMap.get(key); 
			   System.out.println("key:"+key+"->value:"+value);
			   if(key!=destination)
					backList.add(key);
			   for(NodeRoad  nodeRoad :roadList){
				   if(nodeRoad.getBegin().equals(key)){
					   map.put(nodeRoad.getEnd(), value+","+nodeRoad.getEnd());
				   }
			   }
		 }
		 return map;
	}
	
		
	/*
	 * 获取所有子节点，如果子节点为目标节点，则只返回目标节点，否则返回所有子节点。
	 */
	public String getAllRoad2(String start, String destination) {
		if(start!=destination)
			backList.add(start);
		String child = "";
		for(NodeRoad  nodeRoad :roadList){
			if(nodeRoad.getBegin().equals(start)){
				child +=nodeRoad.getEnd()+",";
				if(nodeRoad.getEnd().equals(destination)){
					return nodeRoad.getEnd();
				}
			}
		}
		if(child.endsWith(","))
			child = child.substring(0,child.length()-1);
		
		return child;
		
		
		/*
		//resultNode.add(start);
		for (int z = 0; z < roadList.size(); z++) {
			if (roadList.get(z).getBegin().equals(start)) { //寻找找以start开始的路径
				num++;
				if(num > 200000){ //认为找不到关系，不在继续计算
					flag = true;
				}
				System.out.println(roadList.get(z).getBegin()+":"+roadList.get(z).getEnd());
				if (roadList.get(z).getEnd().equals(destination)) { //如果以destination结尾，则为一条有效路径
					resultSet.add(backList.toString().substring(0, backList.toString().lastIndexOf("]")) + "," + destination + "]");
					System.out.println(backList.toString().substring(0, backList.toString().lastIndexOf("]")) + "," + destination + "]");

					flag = true;
					break;
					//continue;
				}
				if (!backList.contains(roadList.get(z).getEnd())) {//此节点仍未遍历，则继续迭代
					if(flag){
						return;
					}
					getAllRoad(roadList.get(z).getEnd(), destination);
				}
			}
		}
		if(flag){
			return;
		}
		backList.remove(start);*/
	}
	
	/** 
	 * 描述: 结果节点处理
	 * @auther gqf
	 * @date 2015年11月23日  
	 */
	
	public void getRoadResultNode() {
		if(resultSet == null){
			return;
		}
        String nodeArr = resultSet.toString();
		String[] tempnode = nodeArr.split(",");
		for(int i=0;i<tempnode.length;i++){
			resultNode.add(tempnode[i].replace("[", "").replace("]", "").trim());
		}
	}
	

	/*public Set<NodeRoad> getCirList() {
		return cirList;
	}

	public void setCirList(Set<NodeRoad> cirList) {
		this.cirList = cirList;
	}*/

	public Set<String> getResultNode() {
		return resultNode;
	}

	public void setResultNode(Set<String> resultNode) {
		this.resultNode = resultNode;
	}
	public List<NodeRoad> getroadList() {
		return roadList;
	}

	public void setroadList(List<NodeRoad> roadList) {
		this.roadList = roadList;
	}

	public List<String> getbackList() {
		return backList;
	}

	public void setbackList(List<String> backList) {
		this.backList = backList;
	}

	public Set<String> getresultSet() {
		return resultSet;
	}

	public void setresultSet(Set<String> resultSet) {
		this.resultSet = resultSet;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}
}
