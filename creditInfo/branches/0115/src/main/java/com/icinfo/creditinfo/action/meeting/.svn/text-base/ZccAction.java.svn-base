package com.icinfo.creditinfo.action.meeting;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.struts2.ServletActionContext;

import net.sf.json.JSONArray;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.icinfo.creditinfo.bean.biz.relationalnet.CorpLink;
import com.icinfo.creditinfo.bean.biz.relationalnet.CorpNode;
import com.icinfo.creditinfo.bean.meeting.Zcc;
import com.icinfo.creditinfo.service.meeting.ZccService;
import com.icinfo.plugin.common.HxRequestUtil;

public class ZccAction extends HxBaseAction{

	private static final long serialVersionUID = 1L;
	private ZccService zccService;
	private String userName;
	private String corpid;
	
	
	/**
	 * Desc:TODO
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	public String doGetZccNetAllJSONAction() throws Exception{
		this.addAjaxResults("nodeList", null);
		this.addAjaxResults("linkList", null);
		if(StringUtils.isBlank(userName)){
			return AJAX;
		}
		Map<String, Object> qryMap = new HashMap<String, Object>();
		qryMap.put("relSource", userName);//群号
		List<Zcc> dataList = zccService.doGetList(qryMap);
		if(dataList==null||dataList.size()==0){
			return AJAX;
		}
		qryMap.clear();
		qryMap.put("relQno", dataList.get(0).getRelQno());//群号
		dataList = zccService.doGetList(qryMap);
		Map<String,Object> rstMap = zccService.doBuildData(dataList,userName);
		this.addAjaxResults("nodeList", (JSONArray)rstMap.get("nodeList"));
		this.addAjaxResults("linkList", (JSONArray)rstMap.get("linkList"));
		return AJAX;
	}

	/**
	 * desc:TODO
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	public String doEnRelationAction() throws Exception{
		return SUCCESS;
	}
	
	/**
	 * 描述：TODO
	 * 
	 * @author zhuyong
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public String doGetRelationNetJsonAction() throws Exception{
		if(StringUtils.isBlank(corpid)){
			this.addAjaxResults("nodes",  null);
		    this.addAjaxResults("links",  null);
			return AJAX;
		}
		Map<String,String> paramMap =  HxRequestUtil.getAllParam(ServletActionContext.getRequest());
		CorpNode corpNode = new CorpNode(corpid,"",corpid,"","");
		Map<String,Object> nodeAndLinkMap = zccService.doGetNodeAndLink(corpNode,paramMap);
		List<CorpNode> nodeList = (List<CorpNode>)nodeAndLinkMap.get("nodeList");
		List<CorpLink> linkList = (List<CorpLink>)nodeAndLinkMap.get("linkList");
		this.addAjaxResults("nodes",  JSONArray.fromObject(nodeList));
	    this.addAjaxResults("links",  JSONArray.fromObject(linkList));
		return AJAX;
	}
	
	
	public ZccService getZccService() {
		return zccService;
	}

	public void setZccService(ZccService zccService) {
		this.zccService = zccService;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getCorpid() {
		return corpid;
	}

	public void setCorpid(String corpid) {
		this.corpid = corpid;
	}
	
	

}





