/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-10-30
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.analy.cranaylguarantnodedata;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

import org.apache.commons.lang3.StringUtils;

import com.icinfo.creditinfo.bean.analy.cranaylguarantnodedata.CrAnaylGuarantNodeData;
import com.icinfo.creditinfo.dao.analy.cranaylguarantnodedata.CrAnaylGuarantNodeDataDao;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.analy.cranaylguarantnodedata.CrAnaylGuarantNodeDataService;
/**
 * 
 * 描述: 担保相关指标数据 Service 实现<br>
 * @author zhuyong
 * @date 2015-10-30
 */
public class CrAnaylGuarantNodeDataServiceImpl extends HxBaseServiceImpl<CrAnaylGuarantNodeData> implements CrAnaylGuarantNodeDataService
{
	
	/**
	 * desc：构建企业名称集合
	 * 
	 * @author zhuyong
	 * @param nodeList
	 * @return
	 * @throws Exception
	 */
	public List<String> doBuildNameList(List<CrAnaylGuarantNodeData> nodeList) throws Exception{
		nodeList = doUpsideDown(nodeList);
		if(nodeList == null || nodeList.size()==0){
			return null;
		}
		List<String> nameList = new ArrayList<String>();
		for (CrAnaylGuarantNodeData node : nodeList) {
			nameList.add(node.getNodeName());
		}
		return nameList;
	}
	/**
	 * desc：构建担保数量集合
	 * 
	 * @author zhuyong
	 * @param nodeList
	 * @return
	 * @throws Exception
	 */
	public List<BigDecimal> doBuildRelationList(List<CrAnaylGuarantNodeData> nodeList,String type) throws Exception{
		nodeList = doUpsideDown(nodeList);
		if(nodeList == null || nodeList.size()==0){
			return null;
		}
		List<BigDecimal> relationList = new ArrayList<BigDecimal>();
		for (CrAnaylGuarantNodeData node : nodeList) {
			if(StringUtils.isBlank(type)){//双向担保
				relationList.add(node.getNodeTotalRelation());
			}else if (type.equals("guain")) {//被担保
				relationList.add(node.getNodeGuaranteedNum());
			}else{//对外担保
				relationList.add(node.getNodeExterGuaranteeNum());
			}
		}
		return relationList;
	}
	/**
	 * desc：构建担保金额集合
	 * 
	 * @author zhuyong
	 * @param nodeList
	 * @return
	 * @throws Exception
	 */
	public List<BigDecimal> doBuildAmoutList(List<CrAnaylGuarantNodeData> nodeList,String type) throws Exception{
		nodeList = doUpsideDown(nodeList);
		if(nodeList == null || nodeList.size()==0){
			return null;
		}
		List<BigDecimal> amountList = new ArrayList<BigDecimal>();
		for (CrAnaylGuarantNodeData node : nodeList) {
			if(StringUtils.isBlank(type)){//双向担保
				amountList.add(node.getNodeHappenAmount());
			}else if (type.equals("guain")) {//被担保
				amountList.add(node.getNodeGuaranteedAmount());
			}else{//对外担保
				amountList.add(node.getNodeExterGuaranteeAmount());
			}
		}
		return amountList;
	}
	
	/**
	 * 描述：倒序list
	 * 
	 * @author zhuyong
	 * @param nodeList
	 * @return
	 * @throws Exception
	 */
	private List<CrAnaylGuarantNodeData> doUpsideDown(List<CrAnaylGuarantNodeData> nodeList) throws Exception{
		List<CrAnaylGuarantNodeData> rstList = new ArrayList<CrAnaylGuarantNodeData>();
		Stack<CrAnaylGuarantNodeData> stack=new Stack<CrAnaylGuarantNodeData>();
		for(CrAnaylGuarantNodeData node:nodeList){
			stack.push(node);
		}
		while(!stack.isEmpty()){
			rstList.add(stack.pop());
		}
		return rstList;
	}
	
	
	
	public CrAnaylGuarantNodeDataDao doGetCrAnaylGuarantNodeDataDao()
	{
		return (CrAnaylGuarantNodeDataDao)hxBaseDao;
	}
}
