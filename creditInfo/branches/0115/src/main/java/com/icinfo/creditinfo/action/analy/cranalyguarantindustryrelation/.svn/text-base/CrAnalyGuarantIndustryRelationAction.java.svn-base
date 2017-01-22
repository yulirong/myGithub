/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-10-23
 * @version 1.0
 */
package com.icinfo.creditinfo.action.analy.cranalyguarantindustryrelation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import com.icinfo.creditinfo.bean.analy.cranalyguarantindustryrelation.CrAnalyGuarantIndustryRelation;
import com.icinfo.creditinfo.bean.analy.cranalyguarantindustryrelation.GuarantIndustryNode;
import com.icinfo.creditinfo.service.analy.cranalyguarantindustryrelation.CrAnalyGuarantIndustryRelationService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;

/** 
 * 描述: 行业担保关系 Action 类<br>
 * @author zhuyong
 * @date 2015-10-23
 */
public class CrAnalyGuarantIndustryRelationAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrAnalyGuarantIndustryRelationService crAnalyGuarantIndustryRelationService;
	private CrAnalyGuarantIndustryRelation crAnalyGuarantIndustryRelation;
	private String[] crAnalyGuarantIndustryRelationIds;

	/**
	 * 描述: 查看列表
	 * @author zhuyong
	 * @date 2015-10-23
	 * @return
	 * @throws Exception
	 */
	public String doReadCrAnalyGuarantIndustryRelationListAction() throws Exception {
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 查询信息
	 * @author zhuyong
	 * @date 2015-10-23
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String doReadCrAnalyGuarantIndustryRelationListJSONAction() throws Exception {
		List<String> typeList = crAnalyGuarantIndustryRelationService.doGetIndustryTypeList(null);//获取所有行业种类
		List<CrAnalyGuarantIndustryRelation> dataList =crAnalyGuarantIndustryRelationService.doGetList(null);//获取担保关系所有数据

		List<String> legendList = new ArrayList<String>();//图示例数据
		legendList.addAll(typeList);
		legendList.add("");legendList.add("对外");legendList.add("对内");
		
		List<GuarantIndustryNode> nodeList = crAnalyGuarantIndustryRelationService.doBuildNodeList(typeList);//节点集合
		
		Map<String,Object> dataMap = crAnalyGuarantIndustryRelationService.doBuildDataMap(typeList, dataList);//返回数据map
		
		List<List<Integer>> inDataList = (List<List<Integer>>)dataMap.get("inDataList");//数据集合
		List<List<Integer>> outDataList = (List<List<Integer>>)dataMap.get("outDataList");//数据集合
		this.addAjaxResults("legendList",JSONArray.fromObject(legendList));
		this.addAjaxResults("nodeList",JSONArray.fromObject(nodeList));
		this.addAjaxResults("inDataList",crAnalyGuarantIndustryRelationService.doBuildDataStr(inDataList));
		this.addAjaxResults("outDataList", crAnalyGuarantIndustryRelationService.doBuildDataStr(outDataList));
		return AJAX;
	}
	
	

	
	public CrAnalyGuarantIndustryRelationService getCrAnalyGuarantIndustryRelationService()
	{
		return crAnalyGuarantIndustryRelationService;
	}
	public void setCrAnalyGuarantIndustryRelationService(CrAnalyGuarantIndustryRelationService crAnalyGuarantIndustryRelationService)
	{
		this.crAnalyGuarantIndustryRelationService = crAnalyGuarantIndustryRelationService;
	}

	public CrAnalyGuarantIndustryRelation getCrAnalyGuarantIndustryRelation()
	{
		return crAnalyGuarantIndustryRelation;
	}

	public void setCrAnalyGuarantIndustryRelation(CrAnalyGuarantIndustryRelation crAnalyGuarantIndustryRelation)
	{
		this.crAnalyGuarantIndustryRelation = crAnalyGuarantIndustryRelation;
	}

	public String[] getCrAnalyGuarantIndustryRelationIds()
	{
		return crAnalyGuarantIndustryRelationIds;
	}

	public void setCrAnalyGuarantIndustryRelationIds(String[] crAnalyGuarantIndustryRelationIds)
	{
		this.crAnalyGuarantIndustryRelationIds = crAnalyGuarantIndustryRelationIds;
	}

	
}
