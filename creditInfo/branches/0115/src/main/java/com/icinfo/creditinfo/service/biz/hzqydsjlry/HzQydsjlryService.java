/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gqf
 * @date 2015-04-13
 * @version 1.0
 */
package com.icinfo.creditinfo.service.biz.hzqydsjlry;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.hzqydsjlry.HzQydsjlry;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 董事经理人 Service 接口<br>
 * @author gqf
 * @date 2015-04-13
 */
public interface HzQydsjlryService extends HxBaseService<HzQydsjlry>{
	/**
	 * 描述：获取所有高管人员信息
	 * 
	 * @author 朱勇
	 * @date 2015-5-22
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	
	public List<HzQydsjlry> doGetAllHzQyDsjlr(Map<String, Object> qryMap) throws Exception;
	/**
	 * 描述：获取关系 网络所需关联数据
	 * 
	 * @author peterwoo
	 * @date 2015-6-8
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<HzQydsjlry> doGetHzQydsjlryListForRelation(Map<String, Object> qryMap) throws Exception;
	/**
	 * 描述：获取高管信息
	 * 
	 * @author ylr
	 * @date 2015-10-23
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<HzQydsjlry> doGetHzQydsjlryList(Map<String, Object> qryMap) throws Exception;
	/**
	 * 描述：获取高管人数
	 * 
	 * @author ylr
	 * @date 2015-11-16
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public Integer doGetTotalForRelation(Map<String, Object> qryMap) throws Exception;
	

}
