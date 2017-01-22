/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-10-30
 * @version 1.0
 */
package com.icinfo.creditinfo.action.analy.cranaylguarantnodedata;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import net.sf.json.JSONArray;

import com.icinfo.creditinfo.bean.analy.cranaylguarantnodedata.CrAnaylGuarantNodeData;
import com.icinfo.creditinfo.service.analy.cranaylguarantnodedata.CrAnaylGuarantNodeDataService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;

/** 
 * 描述: 担保相关指标数据 Action 类<br>
 * @author zhuyong
 * @date 2015-10-30
 */
public class CrAnaylGuarantNodeDataAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrAnaylGuarantNodeDataService crAnaylGuarantNodeDataService;
	private CrAnaylGuarantNodeData crAnaylGuarantNodeData;
	private String guaType;//担保方式

	/**
	 * 描述: 查看列表
	 * @author zhuyong
	 * @date 2015-10-30
	 * @return
	 * @throws Exception
	 */
	public String doReadCrAnaylGuarantNodeDataListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 查询信息
	 * 
	 * @author zhuyong
	 * @date 2015-10-30
	 * @return
	 * @throws Exception
	 */
	public String doReadCrAnaylGuarantNodeDataListJSONAction() throws Exception {
		List<CrAnaylGuarantNodeData> dataListL = crAnaylGuarantNodeDataService.doGetList(doBuildMapForRelation(guaType));
		List<CrAnaylGuarantNodeData> dataListR = crAnaylGuarantNodeDataService.doGetList(doBuildMapForAmount(guaType));
		this.addAjaxResults("nameListL", JSONArray.fromObject(crAnaylGuarantNodeDataService.doBuildNameList(dataListL)));
		this.addAjaxResults("dataListL", JSONArray.fromObject(crAnaylGuarantNodeDataService.doBuildRelationList(dataListL, guaType)));
		this.addAjaxResults("nameListR", JSONArray.fromObject(crAnaylGuarantNodeDataService.doBuildNameList(dataListR)));
		this.addAjaxResults("dataListR", JSONArray.fromObject(crAnaylGuarantNodeDataService.doBuildAmoutList(dataListR, guaType)));
		return AJAX;
	}
	
	/**
	 * 描述：构造担保关系数查询参数
	 * 
	 * @author zhuyong
	 * @param type
	 * @return
	 * @throws Exception
	 */
	private Map<String,Object> doBuildMapForRelation(String type) throws Exception{
		Map<String,Object> qryMap = new HashMap<String, Object>();
		if(StringUtils.isBlank(type)){//双向担保
			qryMap.put("guaType", "node_total_relation");
		}else if (type.equals("guain")) {//被担保
			qryMap.put("guaType", "node_guaranteed_num");
		}else{//对外担保
			qryMap.put("guaType", "node_exter_guarantee_num");
		}
		return qryMap;
	}
	
	/**
	 * 描述：构造担保金额数查询参数
	 * 
	 * @author zhuyong
	 * @param type
	 * @return
	 * @throws Exception
	 */
	private Map<String,Object> doBuildMapForAmount(String type) throws Exception{
		Map<String,Object> qryMap = new HashMap<String, Object>();
		if(StringUtils.isBlank(type)){//双向担保
			qryMap.put("guaType", "node_happen_amount");
		}else if (type.equals("guain")) {//被担保
			qryMap.put("guaType", "node_guaranteed_amount");
		}else{//对外担保
			qryMap.put("guaType", "node_exter_guarantee_amount");
		}
		return qryMap;
	}

	public CrAnaylGuarantNodeDataService getCrAnaylGuarantNodeDataService()
	{
		return crAnaylGuarantNodeDataService;
	}
	public void setCrAnaylGuarantNodeDataService(CrAnaylGuarantNodeDataService crAnaylGuarantNodeDataService)
	{
		this.crAnaylGuarantNodeDataService = crAnaylGuarantNodeDataService;
	}

	public CrAnaylGuarantNodeData getCrAnaylGuarantNodeData()
	{
		return crAnaylGuarantNodeData;
	}
	public void setCrAnaylGuarantNodeData(CrAnaylGuarantNodeData crAnaylGuarantNodeData)
	{
		this.crAnaylGuarantNodeData = crAnaylGuarantNodeData;
	}
	public String getGuaType() {
		return guaType;
	}

	public void setGuaType(String guaType) {
		this.guaType = guaType;
	}

}
