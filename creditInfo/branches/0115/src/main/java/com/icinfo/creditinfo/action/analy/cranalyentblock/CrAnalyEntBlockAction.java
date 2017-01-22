/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-28
 * @version 1.0
 */
package com.icinfo.creditinfo.action.analy.cranalyentblock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONObject;

import com.icinfo.creditinfo.bean.analy.cranalyentblock.CrAnalyEntBlock;
import com.icinfo.creditinfo.service.analy.cranalyentblock.CrAnalyEntBlockService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.pagination.Pagination;

/** 
 * 描述: 块状经济专题分析表 Action 类<br>
 * @author myw
 * @date 2015-11-28
 */
public class CrAnalyEntBlockAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrAnalyEntBlockService crAnalyEntBlockService;
	private CrAnalyEntBlock crAnalyEntBlock;
	private String[] crAnalyEntBlockIds;
	private String tradeName;
	private String selectYear;
	private String indexVal;
	/**
	 * 描述: 查看列表
	 * @auther myw
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public String doReadCrAnalyEntBlockListAction() throws Exception 
	{
		List<String> entBlockYearList = crAnalyEntBlockService.doGetYearList();
		List<String> yearsList = new ArrayList<String>();
		if(entBlockYearList.size()>1){
			for(int i=0;i<entBlockYearList.size()-1;i++){
				yearsList.add(entBlockYearList.get(i));
			}
		}
		this.addJstlResults("entBlockYearList", yearsList);
		return Action.SUCCESS;
	}
	
	/**
	 * 描述：获得块经济行业数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public String doReadEachTradeDataJSONForChart1Action() throws Exception{
		Map<String,Object> qryMap = new HashMap<String, Object>();
		JSONObject dataJson = crAnalyEntBlockService.doGetEachTradeDataJSON(qryMap);
		this.addAjaxResults("dataJson", dataJson);
		return AJAX;
	}
	
	/**
	 * 描述：获得块经济基本分布数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public String doReadEachTradeDataJSONForChart2Action() throws Exception{
		Map<String,Object> qryMap = new HashMap<String, Object>();
		JSONObject dataJson=null;
		try {
			qryMap.put("tradeName", getTradeName(tradeName));
			dataJson = crAnalyEntBlockService.doGetEachTradeDataJSONForChart2(qryMap);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.addAjaxResults("dataJson", dataJson);
		return AJAX;
	}
	
	/**
	 * 描述：获得块经济基本分布数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public String doReadEachTradeDataJSONForChart3Action() throws Exception{
		Map<String,Object> qryMap = new HashMap<String, Object>();
		qryMap.put("tradeName", getTradeName(tradeName));
		JSONObject dataJson = crAnalyEntBlockService.doGetEachTradeDataJSONForChart3(qryMap);
		this.addAjaxResults("dataJson", dataJson);
		return AJAX;
	}
	
	/**
	 * 描述：获得块经济基本分布数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public String doReadEachTradeDataJSONForChart4Action() throws Exception{
		Map<String,Object> qryMap = new HashMap<String, Object>();
		qryMap.put("tradeName", getTradeName(tradeName));
		JSONObject dataJson = crAnalyEntBlockService.doGetEachTradeDataJSONForChart4(qryMap);
		this.addAjaxResults("dataJson", dataJson);
		return AJAX;
	}
	/**
	 * 描述：获得块经济chart4-2数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public String doReadEachTradeDataJSONForChart42Action() throws Exception{
		Map<String,Object> qryMap = new HashMap<String, Object>();
		qryMap.put("tradeName", getTradeName(tradeName));
		qryMap.put("selectYear",selectYear);
		JSONObject dataJson = crAnalyEntBlockService.doGetEachTradeDataJSONForChart42(qryMap);
		this.addAjaxResults("dataJson", dataJson);
		return AJAX;
	}
	
	/**
	 * 描述：获得块经济chart3-2数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public String doReadEachTradeDataJSONForChart32Action() throws Exception{
		
		Map<String,Object> qryMap = new HashMap<String, Object>();
		qryMap.put("tradeName", getTradeName(tradeName));
		qryMap.put("resName", getResName(indexVal));
		JSONObject dataJson = crAnalyEntBlockService.doGetEachTradeDataJSONForChart32(qryMap);
		this.addAjaxResults("dataJson", dataJson);
		return AJAX;
	}
	
	
	
	/**
	 * 描述: 获取表列名称
	 * @auther mayawei
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	private String getTradeName(String tradeName){
		if("机械仪器".equals(tradeName)){return "BLOCK_ECO_JXYQ";}
		if("伞件".equals(tradeName)){return "BLOCK_ECO_SY";}
		if("风机".equals(tradeName)){return "BLOCK_ECO_FJ";}
		if("铜管".equals(tradeName)){return "BLOCK_ECO_TG";}
		if("劳保袜业".equals(tradeName)){return "BLOCK_ECO_LBWY";}
		if("消防器材".equals(tradeName)){return "BLOCK_ECO_XFQC";}
		if("童装".equals(tradeName)){return "BLOCK_ECO_TZ";}
		if("汽车零部件".equals(tradeName)){return "BLOCK_ECO_QCLBJ";}
		return "BLOCK_ECO_FJ";
	}
	/**
	 * 描述: 获取资源表列名称
	 * @auther mayawei
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	private String getResName(String resName){
		if("income".equals(resName)){return "INCOME";}
		if("water".equals(resName)){return "WATER_NUM";}
		if("elec".equals(resName)){return "ELEC_NUM";}
		if("imex".equals(resName)){return "imex";}
		return "INCOME";
	}
	

	/**
	 * 描述: 分页查询信息
	 * @auther myw
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public String doReadCrAnalyEntBlockListJSONAction() throws Exception {
		this.addAjaxResults("pagination", new Pagination(crAnalyEntBlockService.doGetList(doGetRequestMap()), 
				crAnalyEntBlockService.doGetTotal(doGetRequestMap()),pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}
	

	public CrAnalyEntBlockService getCrAnalyEntBlockService()
	{
		return crAnalyEntBlockService;
	}
	public void setCrAnalyEntBlockService(CrAnalyEntBlockService crAnalyEntBlockService)
	{
		this.crAnalyEntBlockService = crAnalyEntBlockService;
	}

	public CrAnalyEntBlock getCrAnalyEntBlock()
	{
		return crAnalyEntBlock;
	}

	public void setCrAnalyEntBlock(CrAnalyEntBlock crAnalyEntBlock)
	{
		this.crAnalyEntBlock = crAnalyEntBlock;
	}

	public String[] getCrAnalyEntBlockIds()
	{
		return crAnalyEntBlockIds;
	}

	public void setCrAnalyEntBlockIds(String[] crAnalyEntBlockIds)
	{
		this.crAnalyEntBlockIds = crAnalyEntBlockIds;
	}

	public String getTradeName() {
		return tradeName;
	}

	public void setTradeName(String tradeName) {
		this.tradeName = tradeName;
	}

	public String getSelectYear() {
		return selectYear;
	}

	public void setSelectYear(String selectYear) {
		this.selectYear = selectYear;
	}

	public String getIndexVal() {
		return indexVal;
	}

	public void setIndexVal(String indexVal) {
		this.indexVal = indexVal;
	}

	
}
