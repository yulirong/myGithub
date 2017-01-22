package com.icinfo.creditinfo.service._impl.biz.relationalnet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;

import com.icinfo.creditinfo.bean.analy.cranalyguarantrelationdata.CrAnalyGuarantRelationData;
import com.icinfo.creditinfo.bean.biz.crentbaseinfo.CrEntBaseInfo;
import com.icinfo.creditinfo.bean.biz.crristdetail.CrRistDetail;
import com.icinfo.creditinfo.bean.biz.hzqydsjlry.HzQydsjlry;
import com.icinfo.creditinfo.bean.biz.hzqyfddbr.HzQyfddbr;
import com.icinfo.creditinfo.bean.biz.hzqytzf.HzQytzf;
import com.icinfo.creditinfo.bean.biz.relationalnet.CorpLink;
import com.icinfo.creditinfo.bean.biz.relationalnet.CorpNode;
import com.icinfo.creditinfo.service.analy.cranalyguarantrelationdata.CrAnalyGuarantRelationDataService;
import com.icinfo.creditinfo.service.biz.relationalnet.RelationalNetService;
import com.icinfo.creditinfo.service.biz.crentbaseinfo.CrEntBaseInfoService;
import com.icinfo.creditinfo.service.biz.crristdetail.CrRistDetailService;
import com.icinfo.creditinfo.service.biz.hzqydsjlry.HzQydsjlryService;
import com.icinfo.creditinfo.service.biz.hzqyfddbr.HzQyfddbrService;
import com.icinfo.creditinfo.service.biz.hzqytzf.HzQytzfService;
import com.icinfo.plugin.common.HxDateUtil;
import com.icinfo.plugin.common.StringUtil;
import com.icinfo.plugin.util.EntNameUtil;

public class RelationalNetServiceImpl implements RelationalNetService {
	private HzQydsjlryService hzQydsjlryService;
	private HzQyfddbrService hzQyfddbrService;
	private HzQytzfService hzQytzfService;
	private CrEntBaseInfoService crEntBaseInfoService;
	private CrAnalyGuarantRelationDataService crAnalyGuarantRelationDataService;
	private CrRistDetailService crRistDetailService;

	/** 
	 * 描述: TODO
	 * @auther yulirong
	 * @date 2015年10月31日 
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<CorpNode> doGetCorpNode(String entName,String corpid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * 描述: TODO
	 * @auther yulirong
	 * @date 2015年10月31日 
	 * @return
	 * @throws Exception 
	 */
	@Override
	public List<CorpLink> doGetCorpLink(String entName,String corpid) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	/** 
	 * 描述: 获取关系网节点数据
	 * @auther yulirong
	 * @date 2015年10月31日 
	 * @param entName
	 * @param corpid
	 * @return
	 * @throws Exception 
	 */
	@Override
	public Map<String, Object> doGetNodeAndLink(CorpNode corpNode,Map<String,String> paramMap)
			throws Exception {
		int isGxcsSlt = Integer.parseInt(paramMap.get("isGxcsSlt"));
		Map<String,Object> qryMap = new HashMap<String,Object>();
		qryMap.put("nbxh", corpNode.getCorpid());
		List<String> nodeList = new ArrayList<String>();
		List<String> linkList = new ArrayList<String>();
		nodeList.add("{category:0, name: '"+corpNode.getName()+"',label:'"+corpNode.getName()+"',value : 10,nodeType:'1',corpid:'"+corpNode.getCorpid()+"'}");
		paramMap.put("noCorpid", corpNode.getCorpid());
		List<CorpNode> nextNodeList = new ArrayList<CorpNode>();
		nextNodeList.add(corpNode);
		for(int i=0;i < isGxcsSlt;i++){//动态显示关系层数
			nextNodeList = doGetAllChidNodeAndLink(nextNodeList,nodeList,linkList,paramMap);
			nextNodeList = removeDuplicateCorpNode(nextNodeList);
		}
		
		nodeList = removeDuplicate(nodeList);
		linkList = removeDuplicate(linkList);
		qryMap.put("nodeList", nodeList);
		qryMap.put("linkList", linkList);
		return qryMap;
	}
	
	
	/** 
	 * 描述: TODO
	 * @auther yulirong
	 * @date 2015年10月31日 
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
	 * @auther yulirong
	 * @date 2015年10月31日 
	 * @param entName
	 * @param parentCorpid
	 * @param nodeList
	 * @param linkList
	 * @return
	 * @throws Exception 
	 */
	
	public  List<CorpNode> doGetCorpChildNodeAndLink(CorpNode corpNode,List<CorpNode> corpNodeList,List<String> nodeList,List<String> linkList,Map<String,String> paramMap) throws Exception{
		Map<String,Object> qryMap = new HashMap<String,Object>();
		qryMap.put("nbxh", corpNode.getCorpid());
		String isFrgx = paramMap.get("isFrgx");
		String isGdgx = paramMap.get("isGdgx");
		String isGjglgx = paramMap.get("isGjglgx");
		String isDbgx = paramMap.get("isDbgx");
		List<HzQyfddbr> hzQyfddbrList = new ArrayList<HzQyfddbr>();
		List<HzQytzf> hzQytzfList = new ArrayList<HzQytzf>();
		List<HzQydsjlry> hzQydsjlryList =new ArrayList<HzQydsjlry>(); 
		List<CrAnalyGuarantRelationData> crAnalyGuarantRelationDataList = new ArrayList<CrAnalyGuarantRelationData>();
		if("1".equals(isFrgx)){
			hzQyfddbrList = hzQyfddbrService.doGetList(qryMap);
		}
		if("1".equals(isGdgx)){
			qryMap.put("stake", paramMap.get("isGdgxSlt"));
			hzQytzfList = hzQytzfService.doGetHzQytzfListForRelationalNet(qryMap);
		}
		if("1".equals(isGjglgx)){
			qryMap.put("zwrel", StringUtil.strSplitAddToList(paramMap.get("isGjglgxSlt")));
			hzQydsjlryList = hzQydsjlryService.doGetHzQydsjlryListForRelation(qryMap);
		}
		if("1".equals(isDbgx)){
			qryMap.put("corpid", corpNode.getCorpid());
			crAnalyGuarantRelationDataList = crAnalyGuarantRelationDataService.doGetList(qryMap);
		}
		qryMap.clear();
		for(int i=0;i<hzQyfddbrList.size();i++){
			nodeList.add("{category:1, name: '"+hzQyfddbrList.get(i).getXm()+"',value : 2,certNo:'"+hzQyfddbrList.get(i).getSfzjhm()+"',nodeType:'2'}");
			linkList.add("{source : '"+corpNode.getName()+"', target : '"+hzQyfddbrList.get(i).getXm()+"', weight : 1, name: '法定代表人'}");
			corpNodeList.add(new CorpNode(hzQyfddbrList.get(i).getXm(),"","",hzQyfddbrList.get(i).getSfzjhm(),"2"));
		}
		for(HzQytzf hzQytzf:hzQytzfList){
			if(hzQytzf.getTzflx().equals("1")){//法人
				Map<String,Object> paraQrymap = new HashMap<String,Object>();
				paraQrymap.put("orQymc", hzQytzf.getQymc());
				paraQrymap.put("orZch", hzQytzf.getZch());
				List<CrEntBaseInfo> crEntBaseInfoList = crEntBaseInfoService.doGetList(paraQrymap);
				String corpid = (crEntBaseInfoList == null||crEntBaseInfoList.size()==0)?"":crEntBaseInfoList.get(0).getCorpid(); 
				nodeList.add("{category:2, name: '"+hzQytzf.getQymc()+"',value : 2,label:'"+EntNameUtil.getShortName(hzQytzf.getQymc())+"',corpid:'"+corpid+"',certNo:'"+hzQytzf.getSfzjhm()+"',nodeType:'1'}");
				linkList.add("{source : '"+corpNode.getName()+"', target : '"+hzQytzf.getQymc()+"', weight : 1,itemStyle: { normal: {width: 1.5,color: 'red'}}, name: '股东关系-持股比例："+hzQytzf.getZbfb()+"%'}");
				if(crEntBaseInfoList == null||crEntBaseInfoList.size()==0) continue;
				corpNodeList.add(new CorpNode(hzQytzf.getQymc(),hzQytzf.getZch(),crEntBaseInfoList.get(0).getCorpid(),hzQytzf.getSfzjhm(),hzQytzf.getTzflx()));
			}else{
				nodeList.add("{category:1, name: '"+hzQytzf.getQymc()+"',value : 2,certNo:'"+hzQytzf.getSfzjhm()+"',nodeType:'2'}");
				linkList.add("{source : '"+corpNode.getName()+"', target : '"+hzQytzf.getQymc()+"', weight : 1,itemStyle: { normal: {width: 1.5,color: 'red'}}, name: '股东关系-持股比例："+hzQytzf.getZbfb()+"%'}");
				corpNodeList.add(new CorpNode(hzQytzf.getQymc(),hzQytzf.getZch(),"",hzQytzf.getSfzjhm(),hzQytzf.getTzflx()));
			}
			
		}
		for(HzQydsjlry hzQydsjlry:hzQydsjlryList){
			nodeList.add("{category:1, name: '"+hzQydsjlry.getXm()+"',value : 2,certNo:'"+hzQydsjlry.getSfzjhm()+"',nodeType:'2'}");
			linkList.add("{source : '"+corpNode.getName()+"', target : '"+hzQydsjlry.getXm()+"', weight : 1,itemStyle: { normal: {width: 1,color: 'blue'}},name: '高管:"+hzQydsjlry.getZwmc()+"'}");
			corpNodeList.add(new CorpNode(hzQydsjlry.getXm(),"","",hzQydsjlry.getSfzjhm(),"2"));
		}
		for(CrAnalyGuarantRelationData list:crAnalyGuarantRelationDataList){
			Map<String,Object> paraQrymap = new HashMap<String,Object>();
			paraQrymap.put("orQymc", list.getRelGuarantorName());
			List<CrEntBaseInfo> crEntBaseInfoList = crEntBaseInfoService.doGetList(paraQrymap);
			String corpid = (crEntBaseInfoList == null||crEntBaseInfoList.size()==0)?"":crEntBaseInfoList.get(0).getCorpid(); 
			if("1".equals(list.getRelType())){
				nodeList.add("{category:2, name: '"+list.getRelGuarantorName()+"',value : 2,corpid:'"+corpid+"',certNo:'',nodeType:'1'}");
			}else{
				nodeList.add("{category:1, name: '"+list.getRelGuarantorName()+"',value : 2,corpid:'',certNo:'',nodeType:'2'}");
			}
			linkList.add("{source : '"+corpNode.getName()+"', target : '"+list.getRelGuarantorName()+"', weight : 1,itemStyle: { normal: {width: 1,color: 'maroon'}},name: '担保关系'}");
			corpNodeList.add(new CorpNode(list.getRelGuarantorName(),"","","",""));
		}
		return corpNodeList;
	}
	/** 
	 * 描述: 自然人 循环取出法人关系，股东关系、高管关系
	 * @auther yulirong
	 * @date 2015年10月31日 
	 * @param frdbsfz
	 * @param parentCorpid
	 * @param nodeList
	 * @param linkList
	 * @return 
	 */
	
	public  List<CorpNode> doGetPersonalChildNodeAndLink(CorpNode corpNode,List<CorpNode> corpNodeList,List<String> nodeList,List<String> linkList,Map<String,String> paramMap) throws Exception {
		Map<String,Object> qryMap = new HashMap<String,Object>();
		String isFrgx = paramMap.get("isFrgx");
		String isGdgx = paramMap.get("isGdgx");
		String isGjglgx = paramMap.get("isGjglgx");
		qryMap.put("sfzjhm", corpNode.getCertNo());
		qryMap.put("zwrel", StringUtil.strSplitAddToList(paramMap.get("isGjglgxSlt")));
		qryMap.put("stake", paramMap.get("isGdgxSlt"));
		qryMap.put("noCorpid", paramMap.get("noCorpid"));
		List<HzQyfddbr> hzQyfddbrList = new ArrayList<HzQyfddbr>();
		List<HzQytzf> hzQytzfList = new ArrayList<HzQytzf>();
		List<HzQydsjlry> hzQydsjlryList =new ArrayList<HzQydsjlry>(); 
		if("1".equals(isFrgx)) hzQyfddbrList = hzQyfddbrService.doGetList(qryMap);
		if("1".equals(isGdgx)) hzQytzfList = hzQytzfService.doGetList(qryMap);
		if("1".equals(isGjglgx)) hzQydsjlryList = hzQydsjlryService.doGetList(qryMap);
		qryMap.clear();
		for(HzQytzf hzQytzf:hzQytzfList){
			CrEntBaseInfo crEntBaseInfo = crEntBaseInfoService.doGetById(hzQytzf.getNbxh());
		    if(crEntBaseInfo == null) continue;
			nodeList.add("{category:2, name: '"+crEntBaseInfo.getEntName()+"',label:'"+EntNameUtil.getShortName(crEntBaseInfo.getEntName())+"',value : 2,corpid:'"+crEntBaseInfo.getCorpid()+"',certNo:'',nodeType:'1'}");
		    linkList.add("{source : '"+crEntBaseInfo.getEntName()+"', target : '"+corpNode.getName()+"', weight : 1,itemStyle: { normal: {width: 1.5,color: 'red'}}, name: '股东关系-持股比例："+hzQytzf.getZbfb()+"%'}");
			corpNodeList.add(new CorpNode(crEntBaseInfo.getEntName(),hzQytzf.getZch(),crEntBaseInfo.getCorpid(),hzQytzf.getSfzjhm(),"1"));
		}
		for( HzQyfddbr hzQyfddbr : hzQyfddbrList ){
			CrEntBaseInfo crEntBaseInfo = crEntBaseInfoService.doGetById(hzQyfddbr.getNbxh());
			if(crEntBaseInfo == null) continue;
			nodeList.add("{category:2, name: '"+crEntBaseInfo.getEntName()+"',label:'"+EntNameUtil.getShortName(crEntBaseInfo.getEntName())+"',value : 2,corpid:'"+crEntBaseInfo.getCorpid()+"',certNo:'',nodeType:'1'}");
			linkList.add("{source : '"+crEntBaseInfo.getEntName()+"', target : '"+corpNode.getName()+"', weight : 1, name: '法定代表人'}");
			corpNodeList.add(new CorpNode(crEntBaseInfo.getEntName(),"",crEntBaseInfo.getCorpid(),hzQyfddbr.getSfzjhm(),"1"));
		}
		for( HzQydsjlry hzQydsjlry : hzQydsjlryList ){
			CrEntBaseInfo crEntBaseInfo = crEntBaseInfoService.doGetById(hzQydsjlry.getNbxh());
		    if(crEntBaseInfo == null) continue;
		    nodeList.add("{category:2, name: '"+crEntBaseInfo.getEntName()+"',label:'"+EntNameUtil.getShortName(crEntBaseInfo.getEntName())+"',value : 2,corpid:'"+crEntBaseInfo.getCorpid()+"',certNo:'',nodeType:'1'}");
			linkList.add("{source : '"+crEntBaseInfo.getEntName()+"', target : '"+corpNode.getName()+"', weight : 1,itemStyle: { normal: {width: 1,color: 'blue'}},name: '高管:"+hzQydsjlry.getZwmc()+"'}");
			corpNodeList.add(new CorpNode(crEntBaseInfo.getEntName(),"",crEntBaseInfo.getCorpid(),hzQydsjlry.getSfzjhm(),"1"));
		}
		return corpNodeList;
	}
	/** 
	 * 描述: TODO
	 * @auther yulirong
	 * @date 2015年10月31日  
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
	 * @auther yulirong
	 * @date 2015年10月31日 
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
	
	
	/**
	 * 描述：构建关联风险返回参数
	 * 
	 * @author zhuyong
	 * @date 2015-11-23
	 * @param nodeList
	 * @param corpidList
	 * @return
	 * @throws Exception
	 */
	public String doBuildRelationRist(List<CorpNode> nodeList,List<String> corpidList,String flag) throws Exception{
		if(nodeList==null || nodeList.size()==0){
			return "";
		}
		StringBuffer buf = new StringBuffer("");
		JSONArray arr = JSONArray.fromObject(nodeList);
		for (Object object : arr) {
			JSONObject obj = (JSONObject) object;
			if(obj.containsKey("corpid") 
					&& StringUtils.isNotBlank(obj.getString("corpid")) 
					&& !corpidList.contains(obj.getString("corpid"))){
				String details = doBuildRistDetails(obj.getString("corpid"));
				if(StringUtils.isNotBlank(details)){
					buf.append("<font style='font-weight: bold;'>");
					if(flag.equals("search")){
						buf.append(obj.getString("mc"));
					}else{
						buf.append(obj.getString("name"));
					}
					buf.append("</font><br/>");
					buf.append(details);
				}
			}
		}
		return buf.toString();
	}
	
	/**
	 * 描述：构建风险详情返回字符串
	 * 
	 * @author zhuyong
	 * @param corpid
	 * @return
	 * @throws Exception
	 */
	private String doBuildRistDetails(String corpid) throws Exception{
		StringBuffer buf = new StringBuffer("");
		Map<String,Object> qryMap = new HashMap<String, Object>();
		qryMap.put("corpid", corpid);
		qryMap.put("theStartTime",HxDateUtil.getNowMonthStartDate());
		List<CrRistDetail> ristList = crRistDetailService.doGetList(qryMap);
		if(ristList==null || ristList.size()==0){
			return "";
		}
		for (CrRistDetail detail : ristList) {
			buf.append(detail.getIdxName());
			buf.append("<br/>");
		}
		return buf.toString();
	}

	public HzQydsjlryService getHzQydsjlryService() {
		return hzQydsjlryService;
	}

	public void setHzQydsjlryService(HzQydsjlryService hzQydsjlryService) {
		this.hzQydsjlryService = hzQydsjlryService;
	}

	public HzQyfddbrService getHzQyfddbrService() {
		return hzQyfddbrService;
	}

	public void setHzQyfddbrService(HzQyfddbrService hzQyfddbrService) {
		this.hzQyfddbrService = hzQyfddbrService;
	}

	public HzQytzfService getHzQytzfService() {
		return hzQytzfService;
	}

	public void setHzQytzfService(HzQytzfService hzQytzfService) {
		this.hzQytzfService = hzQytzfService;
	}

	public CrEntBaseInfoService getCrEntBaseInfoService() {
		return crEntBaseInfoService;
	}

	public void setCrEntBaseInfoService(CrEntBaseInfoService crEntBaseInfoService) {
		this.crEntBaseInfoService = crEntBaseInfoService;
	}

	public CrAnalyGuarantRelationDataService getCrAnalyGuarantRelationDataService() {
		return crAnalyGuarantRelationDataService;
	}

	public void setCrAnalyGuarantRelationDataService(
			CrAnalyGuarantRelationDataService crAnalyGuarantRelationDataService) {
		this.crAnalyGuarantRelationDataService = crAnalyGuarantRelationDataService;
	}

	public CrRistDetailService getCrRistDetailService() {
		return crRistDetailService;
	}

	public void setCrRistDetailService(CrRistDetailService crRistDetailService) {
		this.crRistDetailService = crRistDetailService;
	}
	
	

}
