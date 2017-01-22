/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-11-28
 * @version 1.0
 */
package com.icinfo.creditinfo.action.analy.cranalyenttown;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icinfo.creditinfo.bean.analy.cranalyenttown.CrAnalyEntTown;
import com.icinfo.creditinfo.service.analy.cranalyenttown.CrAnalyEntTownService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.pagination.Pagination;

/** 
 * 描述: 特色小镇 Action 类<br>
 * @author yulirong
 * @date 2015-11-28
 */
public class CrAnalyEntTownAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrAnalyEntTownService crAnalyEntTownService;
	private CrAnalyEntTown crAnalyEntTown;
	private String[] crAnalyEntTownIds;
	private List<BigDecimal> smalltownList;
	private List<CrAnalyEntTown> crAnalyEntTownList;
	private String tipname;
	private String operationStatus;
	/**
	 * 描述: 查看列表
	 * @auther yulirong
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public String doReadCrAnalyEntTownListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	/**
	 * 描述: 进入特色小镇页面
	 * @auther yulirong
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public String doEnCrAnalyEntTownAction() throws Exception 
	{
		crAnalyEntTown = crAnalyEntTownService.doGetQyCount();
		smalltownList = new ArrayList<BigDecimal>();
		if(crAnalyEntTown!=null){
			smalltownList.add(crAnalyEntTown.getCharactTownXxys());
			smalltownList.add(crAnalyEntTown.getCharactTownTz());
			smalltownList.add(crAnalyEntTown.getCharactTownSy());
			smalltownList.add(crAnalyEntTown.getCharactTownJnhbcx());
			smalltownList.add(crAnalyEntTown.getCharactTownTlf());
			smalltownList.add(crAnalyEntTown.getCharactTownHzwht());
			smalltownList.add(crAnalyEntTown.getCharactTownQc());
			smalltownList.add(crAnalyEntTown.getCharactTownQngc());
			smalltownList.add(crAnalyEntTown.getCharactTownEy());
			
		}
		addAjaxResults("smalltownList", smalltownList);
		return SUCCESS;
	}
	
	/**
	 * 描述: 产业特点
	 * @auther yulirong
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public String doGetIndustryCharacterAction() throws Exception 
	{
		Map<String, Object> qryMap = new HashMap<String, Object>();
		List<String> industryList = new ArrayList<String>();
		List<BigDecimal> dataList = new ArrayList<BigDecimal>();
		qryMap.put("havaTrade", 1);
		qryMap.put("industryTown", doGetTipname(tipname));
		crAnalyEntTownList = crAnalyEntTownService.doGetIndustryCharacter(qryMap);
		if(crAnalyEntTownList!=null){
			for(CrAnalyEntTown list:crAnalyEntTownList){
				industryList.add(list.getTrade());
				dataList.add(list.getQyCount());
			}
		}
		addAjaxResults("industryList", industryList);
		addAjaxResults("dataList", dataList);
		return AJAX;
	}
	/**
	 * 描述: 进入特色小镇页面
	 * @auther yulirong
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	private String doGetTipname(String name)throws Exception {
		if(StringUtils.isBlank(name)){return "CHARACT_TOWN_SY";}
		if(name.equals("休闲养生小镇")){return "CHARACT_TOWN_XXYS";}
		if(name.equals("童装小镇")){return "CHARACT_TOWN_TZ";}
		if(name.equals("伞艺小镇")){return "CHARACT_TOWN_SY";}
		if(name.equals("节能环保小镇")){return "CHARACT_TOWN_JNHBCX";}
		if(name.equals("江南吐鲁番小镇")){return "CHARACT_TOWN_TLF";}
		if(name.equals("海上花田小镇")){return "CHARACT_TOWN_HZWHT";}
		if(name.equals("青瓷小镇")){return "CHARACT_TOWN_QC";}
		if(name.equals("千年古城小镇")){return "CHARACT_TOWN_QNGC";}
		if(name.equals("e游小镇")){return "CHARACT_TOWN_EY";}
		return "CHARACT_TOWN_SY";
		
	}
	
	/**
	 * 描述: 资产总额
	 * @auther yulirong
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public String doGetTotalAssetAction() throws Exception 
	{
		Map<String, Object> qryMap = new HashMap<String, Object>();
		List<String> industryList = new ArrayList<String>();
		List<BigDecimal> dataList = new ArrayList<BigDecimal>();
		qryMap.put("industryTown", doGetTipname(tipname));
		crAnalyEntTownList = crAnalyEntTownService.doGetTotalAsset(qryMap);
		if(crAnalyEntTownList!=null){
			for(CrAnalyEntTown list:crAnalyEntTownList){
				industryList.add(list.getTime());
				dataList.add(list.getIncome().divide(new BigDecimal(1),2,BigDecimal.ROUND_HALF_UP));
			}
		}
		addAjaxResults("industryList", industryList);
		addAjaxResults("dataList", dataList);
		return AJAX;
	}
	/**
	 * 描述: 运营状态
	 * @auther yulirong
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public String doGetOperationStatusAction() throws Exception 
	{
		Map<String, Object> qryMap = new HashMap<String, Object>();
		List<String> industryList = new ArrayList<String>();
		List<BigDecimal> dataList = new ArrayList<BigDecimal>();
		List<Double> proportionList = new ArrayList<Double>();
		qryMap.put("characterTown", doGetTipname(tipname));
		List<CrAnalyEntTown> entnumList = crAnalyEntTownService.doGetProfitTotal(qryMap);
		qryMap.put("industryTown", doGetTipname(tipname));
		qryMap.put("operationStatus", operationStatus);
		crAnalyEntTownList = crAnalyEntTownService.doGetOperationStatus(qryMap);
		if(crAnalyEntTownList!=null&&entnumList!=null){
			for(int i=0;i<crAnalyEntTownList.size();i++){
				industryList.add(crAnalyEntTownList.get(i).getTime());
				dataList.add(crAnalyEntTownList.get(i).getIncome());
				if(!entnumList.get(i).getQyCount().equals(BigDecimal.ZERO)&&
				   entnumList.get(i).getQyCount()!=null&&
				   crAnalyEntTownList.get(i).getIncome()!=null){
					 proportionList.add(crAnalyEntTownList.get(i).getIncome().divide(entnumList.get(i).getQyCount(),2,BigDecimal.ROUND_HALF_UP).doubleValue());
				}else{
					proportionList.add((double) 0);
				}
			}
		}
		addAjaxResults("industryList", industryList);
		addAjaxResults("dataList", dataList);
		addAjaxResults("proportionList", proportionList);
		return AJAX;
	}
	
	/**
	 * 描述: 盈利状况
	 * @auther yulirong
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public String doGetProfitStatusAction() throws Exception 
	{
		Map<String, Object> qryMap = new HashMap<String, Object>();
		List<String> industryList = new ArrayList<String>();
		List<BigDecimal> dataList = new ArrayList<BigDecimal>();
		List<Double> proportionList = new ArrayList<Double>();
		qryMap.put("industryTown", doGetTipname(tipname));
		crAnalyEntTownList = crAnalyEntTownService.doGetProfitStatus(qryMap);
		qryMap.clear();
		qryMap.put("characterTown", doGetTipname(tipname));
		List<CrAnalyEntTown> profitList = crAnalyEntTownService.doGetProfitTotal(qryMap);
		qryMap.put("profit", 1);
		List<CrAnalyEntTown> profitList2 = crAnalyEntTownService.doGetProfitTotal(qryMap);
		if(profitList!=null&&profitList2!=null){
			for(int i=0;i<profitList2.size();i++){
				if(profitList2.get(i).getQyCount()!=null&&
				   profitList.get(i).getQyCount()!=null&&
				   !profitList.get(i).getQyCount().equals(BigDecimal.ZERO)){
					proportionList.add(profitList2.get(i).getQyCount().divide(profitList.get(i).getQyCount(),2,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).doubleValue());
				}else{
					proportionList.add((double) 0);
				}
			}
		}
		if(crAnalyEntTownList!=null){
			for(CrAnalyEntTown list:crAnalyEntTownList){
				industryList.add(list.getTime());
				dataList.add(list.getIncome().divide(new BigDecimal(1),2,BigDecimal.ROUND_HALF_UP));
			}
		}
		addAjaxResults("industryList", industryList);
		addAjaxResults("dataList", dataList);
		addAjaxResults("proportionList", proportionList);
		return AJAX;
	}
	
	/**
	 * 描述: 对周边经济的影响程度
	 * @auther yulirong
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public String doGetLocalEconomyAction() throws Exception 
	{
		Map<String, Object> qryMap = new HashMap<String, Object>();
		List<String> industryList = new ArrayList<String>();
		List<Double> incomeList = new ArrayList<Double>();
		List<Double> totalList = new ArrayList<Double>();
		qryMap.put("industryTown", doGetTipname(tipname));
		crAnalyEntTownList = crAnalyEntTownService.doGetLocalEconomy(qryMap);
		qryMap.clear();
		if(crAnalyEntTownList!=null&&crAnalyEntTownList.get(0).getRegUnit()!=null){qryMap.put("regUnit", crAnalyEntTownList.get(0).getRegUnit());}
		List<CrAnalyEntTown> crAnalyEntTownList2 = crAnalyEntTownService.doGetLocalEconomy(qryMap);
		if(crAnalyEntTownList2!=null){
			for(int i=0;i<crAnalyEntTownList.size();i++){
				industryList.add(crAnalyEntTownList.get(i).getTime());
				incomeList.add(crAnalyEntTownList.get(i).getIncome().divide(crAnalyEntTownList2.get(i).getIncome(),3, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).doubleValue());
					totalList.add(crAnalyEntTownList.get(i).getTotalAssets().divide(crAnalyEntTownList2.get(i).getTotalAssets(),3, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).doubleValue());
			}
		}
		addAjaxResults("industryList", industryList);
		addAjaxResults("incomeList", incomeList);
		addAjaxResults("totalList", totalList);
		return AJAX;
	}
	/**
	 * 描述: 对行业的影响程度
	 * @auther yulirong
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public String doGetLocalIndustryAction() throws Exception 
	{
		DecimalFormat df = new DecimalFormat("######0.00");   
		Map<String, Object> qryMap = new HashMap<String, Object>();
		List<String> industryList = new ArrayList<String>();
		List<String> tradeList = new ArrayList<String>();
		List<Double> incomeList = new ArrayList<Double>();
		List<Double> totalList = new ArrayList<Double>();
		List<String> mediumList = new ArrayList<String>();
		List<Double> startList = new ArrayList<Double>();
		qryMap.put("industryTown", doGetTipname(tipname));
		qryMap.put("havaTrade", 1);
		crAnalyEntTownList = crAnalyEntTownService.doGetLocalIndustry(qryMap);
		if(crAnalyEntTownList!=null){
			for(CrAnalyEntTown list:crAnalyEntTownList){
				tradeList.add(list.getTrade());
			}
		}
		qryMap.clear();
		qryMap.put("intrade", tradeList);
		List<CrAnalyEntTown> crAnalyEntTownList2 = crAnalyEntTownService.doGetLocalIndustry(qryMap);
		if(crAnalyEntTownList2!=null){
			for(int i=0;i<crAnalyEntTownList.size();i++){
				industryList.add(crAnalyEntTownList.get(i).getMyTrade());
				if(crAnalyEntTownList.get(i).getIncome()==null||
				   crAnalyEntTownList.get(i).getTotalAssets()==null||
				   crAnalyEntTownList2.get(i).getIncome()==null||
				   crAnalyEntTownList2.get(i).getIncome().equals(BigDecimal.ZERO)||
				   crAnalyEntTownList2.get(i).getTotalAssets()==null||
				   crAnalyEntTownList2.get(i).getTotalAssets().equals(BigDecimal.ZERO)){
					incomeList.add((double) 0);
					totalList.add((double) 0);
				}else{
					incomeList.add(crAnalyEntTownList.get(i).getIncome().divide(crAnalyEntTownList2.get(i).getIncome(),3, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).doubleValue());
					totalList.add(crAnalyEntTownList.get(i).getTotalAssets().divide(crAnalyEntTownList2.get(i).getTotalAssets(),3, BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).doubleValue());
				}
			}
			for(int j=0;j<incomeList.size();j++){
				mediumList.add(df.format(Math.abs(incomeList.get(j)-totalList.get(j))));
				if(incomeList.get(j)-totalList.get(j)>0){
					startList.add(totalList.get(j));
				}else{startList.add(incomeList.get(j));}
			}
		}
		addAjaxResults("industryList", industryList);
		addAjaxResults("incomeList", incomeList);
		addAjaxResults("totalList", totalList);
		addAjaxResults("mediumList", mediumList);
		addAjaxResults("startList", startList);
		return AJAX;
	}
	
	/**
	 * 描述: 就业贡献
	 * @auther yulirong
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public String doGetEmploymentContributionAction() throws Exception 
	{
		Map<String, Object> qryMap = new HashMap<String, Object>();
		List<String> industryList = new ArrayList<String>();
		List<BigDecimal> dataList = new ArrayList<BigDecimal>();
		List<Double> peoplepercentList = new ArrayList<Double>();
		List<CrAnalyEntTown> peopleList = crAnalyEntTownService.doGetEmploymentContribution(qryMap);
		qryMap.put("industryTown", doGetTipname(tipname));
		crAnalyEntTownList = crAnalyEntTownService.doGetEmploymentContribution(qryMap);
		if(peopleList!=null&&crAnalyEntTownList!=null){
			for(int i=0;i<peopleList.size();i++){
				industryList.add(peopleList.get(i).getTime());
					dataList.add(crAnalyEntTownList.get(i).getSocialSecurityNum());
				if(crAnalyEntTownList.get(i).getSocialSecurityNum()!=null&&
				   peopleList.get(i).getSocialSecurityNum()!=null&&
				   !peopleList.get(i).getSocialSecurityNum().equals(BigDecimal.ZERO)){
					 peoplepercentList.add(crAnalyEntTownList.get(i).getSocialSecurityNum().divide(peopleList.get(i).getSocialSecurityNum(),4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).doubleValue());
				}else{
					peoplepercentList.add((double) 0);
				}
			}
		}
		addAjaxResults("industryList", industryList);
		addAjaxResults("dataList", dataList);
		addAjaxResults("peoplepercentList", peoplepercentList);
		return AJAX;
	}
	
	/**
	 * 描述: 纳税贡献
	 * @auther yulirong
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public String doGetTaxContributionAction() throws Exception 
	{
		Map<String, Object> qryMap = new HashMap<String, Object>();
		List<String> industryList = new ArrayList<String>();
		List<BigDecimal> dataList = new ArrayList<BigDecimal>();
		List<Double> taxpercentList = new ArrayList<Double>();
		List<CrAnalyEntTown> taxList = crAnalyEntTownService.doGetEmploymentContribution(qryMap);
		qryMap.put("industryTown", doGetTipname(tipname));
		crAnalyEntTownList = crAnalyEntTownService.doGetEmploymentContribution(qryMap);
		if(taxList!=null&&crAnalyEntTownList!=null){
			for(int i=0;i<taxList.size();i++){
				industryList.add(taxList.get(i).getTime());
					dataList.add(crAnalyEntTownList.get(i).getTax().divide(new BigDecimal(1),2,BigDecimal.ROUND_HALF_UP));
				if(crAnalyEntTownList.get(i).getTax()!=null&&
				   taxList.get(i).getTax()!=null&& 
				   !taxList.get(i).getTax().equals(BigDecimal.ZERO)){
					 taxpercentList.add(crAnalyEntTownList.get(i).getTax().divide(taxList.get(i).getTax(),4,BigDecimal.ROUND_HALF_UP).multiply(new BigDecimal(100)).doubleValue());
				}else{taxpercentList.add((double) 0);}
			}
		}
		addAjaxResults("industryList", industryList);
		addAjaxResults("dataList", dataList);
		addAjaxResults("taxpercentList", taxpercentList);
		return AJAX;
	}
	/**
	 * 描述: 分页查询信息
	 * @auther yulirong
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public String doReadCrAnalyEntTownListJSONAction() throws Exception {
		this.addAjaxResults("pagination", new Pagination(crAnalyEntTownService.doGetList(doGetRequestMap()), 
				crAnalyEntTownService.doGetTotal(doGetRequestMap()),pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}
	
	
	/**
	 * 描述：获取企业规模
	 * 
	 * @author zhuyong
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	public String doGetQyScaleJSONAction() throws Exception{
		Map<String,Object> qryMap = new HashMap<String, Object>();
		qryMap.put("charactType", doGetTipname(tipname));
		List<CrAnalyEntTown> dataList = crAnalyEntTownService.doGetQyScaleDataList(qryMap);
		qryMap = crAnalyEntTownService.doBuildQyScale(dataList);
		this.addAjaxResults("dataList", qryMap.get("dataList"));
		this.addAjaxResults("legendList", qryMap.get("legendList"));
		return AJAX;
	}
	
	public CrAnalyEntTownService getCrAnalyEntTownService()
	{
		return crAnalyEntTownService;
	}
	public void setCrAnalyEntTownService(CrAnalyEntTownService crAnalyEntTownService)
	{
		this.crAnalyEntTownService = crAnalyEntTownService;
	}

	public CrAnalyEntTown getCrAnalyEntTown()
	{
		return crAnalyEntTown;
	}

	public void setCrAnalyEntTown(CrAnalyEntTown crAnalyEntTown)
	{
		this.crAnalyEntTown = crAnalyEntTown;
	}

	public String[] getCrAnalyEntTownIds()
	{
		return crAnalyEntTownIds;
	}

	public void setCrAnalyEntTownIds(String[] crAnalyEntTownIds)
	{
		this.crAnalyEntTownIds = crAnalyEntTownIds;
	}
	public List<BigDecimal> getSmalltownList() {
		return smalltownList;
	}
	public void setSmalltownList(List<BigDecimal> smalltownList) {
		this.smalltownList = smalltownList;
	}
	public List<CrAnalyEntTown> getCrAnalyEntTownList() {
		return crAnalyEntTownList;
	}
	public void setCrAnalyEntTownList(List<CrAnalyEntTown> crAnalyEntTownList) {
		this.crAnalyEntTownList = crAnalyEntTownList;
	}
	public String getTipname() {
		return tipname;
	}
	public void setTipname(String tipname) {
		this.tipname = tipname;
	}
	public String getOperationStatus() {
		return operationStatus;
	}
	public void setOperationStatus(String operationStatus) {
		this.operationStatus = operationStatus;
	}

	
}
