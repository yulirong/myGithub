package com.icinfo.creditinfo.service.biz.relationalnet;

import java.util.List;
import java.util.Map;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.apache.commons.lang3.StringUtils;

import com.icinfo.creditinfo.bean.biz.relationalnet.CorpLink;
import com.icinfo.creditinfo.bean.biz.relationalnet.CorpNode;


public interface RelationalNetService {
	/** 
	 * 描述: 节点
	 * @auther yulirong
	 * @date 2015年10月31日 
	 * @return
	 * @throws Exception 
	 */
	
	public List<CorpNode> doGetCorpNode(String entName,String corpid) throws Exception;
	
	/** 
	 * 描述: 关系
	 * @auther yulirong
	 * @date 2015年10月31日 
	 * @return
	 * @throws Exception 
	 */
	
	public List<CorpLink> doGetCorpLink(String entName,String corpid) throws Exception;
	
	/** 
	 * 描述: TODO
	 * @auther yulirong
	 * @date 2015年10月31日 
	 * @param entName
	 * @param corpid
	 * @return
	 * @throws Exception 
	 */
	
	public Map<String,Object> doGetNodeAndLink(CorpNode corpNode,Map<String,String> paramMap) throws Exception;

	
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
	public String doBuildRelationRist(List<CorpNode> nodeList,List<String> corpidList,String flag) throws Exception;
}
