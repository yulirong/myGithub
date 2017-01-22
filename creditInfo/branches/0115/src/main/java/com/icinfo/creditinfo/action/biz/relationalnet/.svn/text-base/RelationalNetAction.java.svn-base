/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-31
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.relationalnet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import com.icinfo.creditinfo.action.HxBaseAction;
import com.icinfo.creditinfo.bean.biz.crentbaseinfo.CrEntBaseInfo;
import com.icinfo.creditinfo.bean.biz.crrelationnetall.CrRelationNetAll;
import com.icinfo.creditinfo.bean.biz.crristdetail.CrRistDetail;
import com.icinfo.creditinfo.bean.biz.relationalnet.CorpLink;
import com.icinfo.creditinfo.bean.biz.relationalnet.CorpNode;
import com.icinfo.creditinfo.service.analy.cranalyguarantrelationdata.CrAnalyGuarantRelationDataService;
import com.icinfo.creditinfo.service.biz.crentbaseinfo.CrEntBaseInfoService;
import com.icinfo.creditinfo.service.biz.crrelationnetall.CrRelationNetAllService;
import com.icinfo.creditinfo.service.biz.crristdetail.CrRistDetailService;
import com.icinfo.creditinfo.service.biz.hzqydsjlry.HzQydsjlryService;
import com.icinfo.creditinfo.service.biz.hzqytzf.HzQytzfService;
import com.icinfo.creditinfo.service.biz.relationalnet.RelationalNetService;
import com.icinfo.plugin.common.AESEUtil;
import com.icinfo.plugin.common.HxDateUtil;
import com.icinfo.plugin.common.HxRequestUtil;
import com.icinfo.plugin.common.StringUtil;

public class RelationalNetAction extends HxBaseAction{

private static final long serialVersionUID = 1L;
	
	
	private RelationalNetService relationalNetService;
	private CrEntBaseInfoService crEntBaseInfoService;
	private HzQydsjlryService hzQydsjlryService;
	private HzQytzfService hzQytzfService;
	private CrAnalyGuarantRelationDataService crAnalyGuarantRelationDataService;
	
	private String corpid;
	private String entname;
	private String isFrgx = "1";
	private String isGdgx = "1";
	private String isGjglgx = "1";
	private String isDbgx = "1";
	private String isPougx = "1";
	//初始化
	private String isGxcsSlt = "2";
	private String isGdgxSlt= "0";
	private String isGjglgxSlt = "";
	
	private String certNo;
	//类型
	private String nodeType;
	private List<CrRistDetail> ristList;
	private CrRistDetailService crRistDetailService;
	private CrRelationNetAllService crRelationNetAllService;
	
	
	
	/** 
	 * 描述: 力向关系网络
	 * @author yulirong
	 * @date 2015年10月31日 
	 * @return
	 * @throws Exception 
	 */
	
	@SuppressWarnings("unchecked")
	public String doGetNodeAndLinkAjaxJsonAction() throws Exception{
		   if(entname == null)return AJAX;
		   Map<String,String> paramMap =  HxRequestUtil.getAllParam(ServletActionContext.getRequest());
		   paramMap.put("isGxcsSlt", isGxcsSlt);
		   if (StringUtils.isNotBlank(corpid) && corpid.length() > 16) {
				corpid = AESEUtil.decryptContext(corpid);
			}
		    CorpNode corpNode = new CorpNode(entname,"",corpid,certNo,nodeType);
		    Map<String,Object> nodeAndLinkMap = relationalNetService.doGetNodeAndLink(corpNode,paramMap);
	    	List<CorpNode> nodeList = (List<CorpNode>)nodeAndLinkMap.get("nodeList");
	    	List<CorpLink> linkList = (List<CorpLink>)nodeAndLinkMap.get("linkList");
	    	this.addAjaxResults("nodes",  JSONArray.fromObject(nodeList));
	    	this.addAjaxResults("links",  JSONArray.fromObject(linkList));
			return AJAX;
	}
	
	/** 
	 * 描述: 力向关系网络
	 * @author yulirong
	 * @date 2015年10月31日 
	 * @return
	 * @throws Exception 
	 */
	
	public String doGetNewEnRelationalNetByForceAction() throws Exception{
		if (StringUtils.isNotBlank(corpid) && corpid.length() > 16) {
			corpid = AESEUtil.decryptContext(corpid);
		}
		Map<String,Object> qryMap = new HashMap<String, Object>();
		qryMap.put("corpid", corpid);
		qryMap.put("theStartTime",HxDateUtil.getNowMonthStartDate());
		ristList = crRistDetailService.doGetList(qryMap);
			return SUCCESS;
	}
	/** 
	 * 描述: 获取指定节点的子节点
	 * @auther gqf
	 * @date 2015年11月12日 
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	public String doGetNextNodeAndLinkJson() throws Exception{
		  if(entname == null)return AJAX;
		   Map<String,String> paramMap =  HxRequestUtil.getAllParam(ServletActionContext.getRequest());
		   paramMap.put("isGxcsSlt", "1");
		   if (StringUtils.isNotBlank(corpid) && corpid.length() > 16) {
				corpid = AESEUtil.decryptContext(corpid);
		   }
		   List<String> corpidList = StringUtil.strSplitAddToList(paramMap.get("corpidArr[]"));//前台传来的corpid数组、用于过滤
		   CorpNode corpNode = new CorpNode(entname,"",corpid,certNo,nodeType);
		   Map<String,Object> nodeAndLinkMap = relationalNetService.doGetNodeAndLink(corpNode,paramMap);
		   List<CorpNode> nodeList = (List<CorpNode>)nodeAndLinkMap.get("nodeList");
		   List<CorpLink> linkList = (List<CorpLink>)nodeAndLinkMap.get("linkList");
	       this.addAjaxResults("nodes",  JSONArray.fromObject(nodeList));
	       this.addAjaxResults("links",  JSONArray.fromObject(linkList));
	       this.addAjaxResults("rists",  relationalNetService.doBuildRelationRist(nodeList, corpidList,""));
		   return AJAX;
	}
	
	
	

	/**
	 * 描述：获取展开关系网络数据
	 * 
	 * @author zhuyong
	 * @date 2015-11-30
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String doGetOpenRelationNetJsonAction() throws Exception{
		 if(entname == null)return AJAX;
		   Map<String,String> paramMap =  HxRequestUtil.getAllParam(ServletActionContext.getRequest());
		   if (StringUtils.isNotBlank(corpid) && corpid.length() > 16) {
				corpid = AESEUtil.decryptContext(corpid);
		   }
		   List<String> corpidList = StringUtil.strSplitAddToList(paramMap.get("corpidArr[]"));//前台传来的corpid数组、用于过滤
		   CorpNode corpNode = new CorpNode(entname,"",corpid,certNo,nodeType);
		   Map<String,Object> nodeAndLinkMap = crRelationNetAllService.doGetNodeAndLink(corpNode,paramMap);
		   List<CorpNode> nodeList = (List<CorpNode>)nodeAndLinkMap.get("nodeList");
		   List<CorpLink> linkList = (List<CorpLink>)nodeAndLinkMap.get("linkList");
	       this.addAjaxResults("nodes",  JSONArray.fromObject(nodeList));
	       this.addAjaxResults("links",  JSONArray.fromObject(linkList));
	       this.addAjaxResults("rists",  relationalNetService.doBuildRelationRist(nodeList, corpidList,""));
		return AJAX;
	}
	
	

	/** 
	 * 描述: 获取企业分析概要
	 * @author yulirong
	 * @date 2015年11月2日 
	 * @return
	 * @throws Exception 
	 */
	
	public String doGetEntAnalyDateAction() throws Exception{
		if (StringUtils.isNotBlank(corpid) && corpid.length() > 16) {
			corpid = AESEUtil.decryptContext(corpid);
		}
		Map<String, Object> qryMap = new HashMap<String, Object>();
		qryMap.put("fromCorpid", corpid);
		CrRelationNetAll summary = crRelationNetAllService.doGetRelationSummaryData(qryMap);
		this.addAjaxResults("fddbr", summary.getFddbrName()); // 法定代表人
		this.addAjaxResults("ggnum", summary.getGgNum()); // 高管
		this.addAjaxResults("zrrgd", summary.getZrrgdNum());// 自然人股东
		this.addAjaxResults("frgd", summary.getFrgdNum());// 法人股东
		this.addAjaxResults("dbnum", summary.getDbNum());// 担保数
		return AJAX;
	}


	public RelationalNetService getRelationalNetService() {
		return relationalNetService;
	}

	public void setRelationalNetService(RelationalNetService relationalNetService) {
		this.relationalNetService = relationalNetService;
	}

	public String getCorpid() {
		return corpid;
	}

	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}

	public String getEntname() {
		return entname;
	}

	public void setEntname(String entname) {
		this.entname = entname;
	}

	public String getIsFrgx() {
		return isFrgx;
	}

	public void setIsFrgx(String isFrgx) {
		this.isFrgx = isFrgx;
	}

	public String getIsGdgx() {
		return isGdgx;
	}

	public void setIsGdgx(String isGdgx) {
		this.isGdgx = isGdgx;
	}

	public String getIsGjglgx() {
		return isGjglgx;
	}

	public void setIsGjglgx(String isGjglgx) {
		this.isGjglgx = isGjglgx;
	}

	public String getIsGxcsSlt() {
		return isGxcsSlt;
	}

	public void setIsGxcsSlt(String isGxcsSlt) {
		this.isGxcsSlt = isGxcsSlt;
	}

	public String getIsGdgxSlt() {
		return isGdgxSlt;
	}

	public void setIsGdgxSlt(String isGdgxSlt) {
		this.isGdgxSlt = isGdgxSlt;
	}

	public String getIsGjglgxSlt() {
		if(this.isGjglgxSlt.indexOf("1000")!=-1||this.isGjglgxSlt.indexOf("16")!=-1||this.isGjglgxSlt.indexOf("17")!=-1||this.isGjglgxSlt.indexOf("408A")!=-1){isGjglgxSlt = "1000";}
		if(this.isGjglgxSlt.indexOf("13")!=-1||this.isGjglgxSlt.indexOf("14")!=-1||this.isGjglgxSlt.indexOf("15")!=-1||this.isGjglgxSlt.indexOf("1001")!=-1){isGjglgxSlt = "1001";}
		if(this.isGjglgxSlt.indexOf("434R")!=-1||this.isGjglgxSlt.indexOf("434Q")!=-1||this.isGjglgxSlt.indexOf("436A")!=-1){isGjglgxSlt = "410A";}
		if(this.isGjglgxSlt.indexOf("431A")!=-1||this.isGjglgxSlt.indexOf("431B")!=-1||this.isGjglgxSlt.indexOf("432A")!=-1||this.isGjglgxSlt.indexOf("432K")!=-1){isGjglgxSlt = "410B";}
		if(this.isGjglgxSlt.indexOf("410A")!=-1||this.isGjglgxSlt.indexOf("410B")!=-1||this.isGjglgxSlt.indexOf("410C")!=-1){isGjglgxSlt = "410C";}
		if(this.isGjglgxSlt.indexOf("490A")!=-1||this.isGjglgxSlt.indexOf("491A")!=-1||this.isGjglgxSlt.indexOf("491B")!=-1||this.isGjglgxSlt.indexOf("2001")!=-1||this.isGjglgxSlt.indexOf("2002")!=-1){isGjglgxSlt = "431A";}
		return isGjglgxSlt;
	}

	public void setIsGjglgxSlt(String isGjglgxSlt) {
		this.isGjglgxSlt = isGjglgxSlt;
	}


	public CrEntBaseInfoService getCrEntBaseInfoService() {
		return crEntBaseInfoService;
	}


	public void setCrEntBaseInfoService(CrEntBaseInfoService crEntBaseInfoService) {
		this.crEntBaseInfoService = crEntBaseInfoService;
	}


	public HzQydsjlryService getHzQydsjlryService() {
		return hzQydsjlryService;
	}


	public void setHzQydsjlryService(HzQydsjlryService hzQydsjlryService) {
		this.hzQydsjlryService = hzQydsjlryService;
	}


	public HzQytzfService getHzQytzfService() {
		return hzQytzfService;
	}


	public void setHzQytzfService(HzQytzfService hzQytzfService) {
		this.hzQytzfService = hzQytzfService;
	}


	public String getIsDbgx() {
		return isDbgx;
	}


	public void setIsDbgx(String isDbgx) {
		this.isDbgx = isDbgx;
	}


	public String getCertNo() {
		return certNo;
	}


	public void setCertNo(String certNo) {
		this.certNo = certNo;
	}


	public String getNodeType() {
		return nodeType;
	}


	public void setNodeType(String nodeType) {
		this.nodeType = nodeType;
	}


	public CrAnalyGuarantRelationDataService getCrAnalyGuarantRelationDataService() {
		return crAnalyGuarantRelationDataService;
	}


	public void setCrAnalyGuarantRelationDataService(
			CrAnalyGuarantRelationDataService crAnalyGuarantRelationDataService) {
		this.crAnalyGuarantRelationDataService = crAnalyGuarantRelationDataService;
	}

	public List<CrRistDetail> getRistList() {
		return ristList;
	}

	public void setRistList(List<CrRistDetail> ristList) {
		this.ristList = ristList;
	}

	public CrRistDetailService getCrRistDetailService() {
		return crRistDetailService;
	}

	public void setCrRistDetailService(CrRistDetailService crRistDetailService) {
		this.crRistDetailService = crRistDetailService;
	}

	public CrRelationNetAllService getCrRelationNetAllService() {
		return crRelationNetAllService;
	}

	public void setCrRelationNetAllService(
			CrRelationNetAllService crRelationNetAllService) {
		this.crRelationNetAllService = crRelationNetAllService;
	}

	public String getIsPougx() {
		return isPougx;
	}

	public void setIsPougx(String isPougx) {
		this.isPougx = isPougx;
	}
	
	


	

}

