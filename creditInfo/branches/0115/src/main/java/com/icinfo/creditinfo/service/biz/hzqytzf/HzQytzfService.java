/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-10-21
 * @version 1.0
 */
package com.icinfo.creditinfo.service.biz.hzqytzf;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.hzqytzf.HzQytzf;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 企业投资方 Service 接口<br>
 * @author gaotong
 * @date 2015-10-21
 */
public interface HzQytzfService extends HxBaseService<HzQytzf>{
	/**
	 * 描述：获取关系 网络所需关联数据
	 * 
	 * @author yulirong
	 * @date 2015-10-31
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<HzQytzf> doGetHzQytzfListForRelationalNet(Map<String, Object> qryMap) throws Exception;
	/**
	 * 描述：获取企业最大股东
	 * 
	 * @author gaotong
	 * @date 2015-11-2
	 * @param corpid
	 * @return
	 * @throws Exception
	 */
	public List<HzQytzf> doSelectHzQytzfListByCorpid(String corpid) throws Exception;

}
