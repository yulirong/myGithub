/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-11-30
 * @version 1.0
 */
package com.icinfo.creditinfo.service.biz.crrelationnetall;

import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crrelationnetall.CrRelationNetAll;
import com.icinfo.creditinfo.bean.biz.relationalnet.CorpNode;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 关系网络汇总信息 Service 接口<br>
 * @author zhuyong
 * @date 2015-11-30
 */
public interface CrRelationNetAllService extends HxBaseService<CrRelationNetAll>{

	/** 
	 * 描述: 获取关系节点和关系连线数据
	 * 
	 * @author zhuyong
	 * @date 2015-10-31 
	 * @param entName
	 * @param corpid
	 * @return
	 * @throws Exception 
	 */
	
	public Map<String,Object> doGetNodeAndLink(CorpNode corpNode,Map<String,String> paramMap) throws Exception;
	
	/**
	 * 描述：获取关系概要数据
	 * 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public CrRelationNetAll doGetRelationSummaryData(Map<String,Object> qryMap) throws Exception;

}
