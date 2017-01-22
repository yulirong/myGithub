/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-11-05
 * @version 1.0
 */
package com.icinfo.creditinfo.action.analy.cranalytrade;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import com.icinfo.creditinfo.bean.analy.cranalytrade.CrAnalyTrade;
import com.icinfo.creditinfo.service.analy.cranalytrade.CrAnalyTradeService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;

/** 
 * 描述: 企业数量就业人数 Action 类<br>
 * @author yulirong
 * @date 2015-11-05
 */
public class CrAnalyTradeAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrAnalyTradeService crAnalyTradeService;
	private CrAnalyTrade crAnalyTrade;
	private String[] crAnalyTradeIds;
	private String selectTypeName;

	/**
	 * 描述: 查看列表
	 * @auther yulirong
	 * @date 2015-11-05
	 * @return
	 * @throws Exception
	 */
	public String doReadCrAnalyTradeListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	
	
	/**
	 * 描述: 获取企业数量
	 * @auther yulirong
	 * @date 2015-11-05
	 * @return
	 * @throws Exception
	 */
	public String doGetCrEntEmpNumListAction() throws Exception {
		List<String> hyList = new ArrayList<String>();
		List<BigDecimal> dataList = new ArrayList<BigDecimal>();
		List<CrAnalyTrade> crAnalyTradeList = new ArrayList<CrAnalyTrade>();
		if(selectTypeName.equals("企业数量")){
			 crAnalyTradeList = crAnalyTradeService.doGetCrEntNumList(null);
			for(CrAnalyTrade crAnalyTrade:crAnalyTradeList){
				hyList.add(crAnalyTrade.getTradeSupCode());
				if(crAnalyTrade.getTradeCorpCount()==null){
					dataList.add(new BigDecimal(0));
				}else{
					dataList.add(crAnalyTrade.getTradeCorpCount());
				}
			}
		}
		if(selectTypeName.equals("就业人数")){
			 crAnalyTradeList = crAnalyTradeService.doGetCrEmpNumList(null);
			for(CrAnalyTrade crAnalyTrade:crAnalyTradeList){
				hyList.add(crAnalyTrade.getTradeSupCode());
				if(crAnalyTrade.getTradeManCount()==null){
					dataList.add(new BigDecimal(0));
				}else{
					dataList.add(crAnalyTrade.getTradeManCount());
				}
			}
		}
		
		this.addAjaxResults("hyList", hyList);
		this.addAjaxResults("dataList", dataList);
		this.addAjaxResults("selectTypeName", selectTypeName);
		return AJAX;
	}

	
	public CrAnalyTradeService getCrAnalyTradeService()
	{
		return crAnalyTradeService;
	}
	public void setCrAnalyTradeService(CrAnalyTradeService crAnalyTradeService)
	{
		this.crAnalyTradeService = crAnalyTradeService;
	}

	public CrAnalyTrade getCrAnalyTrade()
	{
		return crAnalyTrade;
	}

	public void setCrAnalyTrade(CrAnalyTrade crAnalyTrade)
	{
		this.crAnalyTrade = crAnalyTrade;
	}

	public String[] getCrAnalyTradeIds()
	{
		return crAnalyTradeIds;
	}

	public void setCrAnalyTradeIds(String[] crAnalyTradeIds)
	{
		this.crAnalyTradeIds = crAnalyTradeIds;
	}


	public String getSelectTypeName() {
		return selectTypeName;
	}


	public void setSelectTypeName(String selectTypeName) {
		this.selectTypeName = selectTypeName;
	}

	
}
