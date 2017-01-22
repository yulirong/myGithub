/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-10-30
 * @version 1.0
 */
package com.icinfo.creditinfo.service.analy.cranaylguarantnodedata;

import java.math.BigDecimal;
import java.util.List;

import com.icinfo.creditinfo.bean.analy.cranaylguarantnodedata.CrAnaylGuarantNodeData;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 担保相关指标数据 Service 接口<br>
 * @author zhuyong
 * @date 2015-10-30
 */
public interface CrAnaylGuarantNodeDataService extends HxBaseService<CrAnaylGuarantNodeData>{
	
	/**
	 * desc：构建企业名称集合
	 * 
	 * @author zhuyong
	 * @param nodeList
	 * @return
	 * @throws Exception
	 */
	public List<String> doBuildNameList(List<CrAnaylGuarantNodeData> nodeList) throws Exception;
	/**
	 * desc：构建担保数量集合
	 * 
	 * @author zhuyong
	 * @param nodeList
	 * @return
	 * @throws Exception
	 */
	public List<BigDecimal> doBuildRelationList(List<CrAnaylGuarantNodeData> nodeList,String type) throws Exception;
	/**
	 * desc：构建担保金额集合
	 * 
	 * @author zhuyong
	 * @param nodeList
	 * @return
	 * @throws Exception
	 */
	public List<BigDecimal> doBuildAmoutList(List<CrAnaylGuarantNodeData> nodeList,String type) throws Exception;
	

}
