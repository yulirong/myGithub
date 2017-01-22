/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author 朱勇
 * @date 2015-01-23
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.biz.entappcon;

import java.util.List;
import java.util.Map;
import com.icinfo.creditinfo.bean.biz.entappcon.EntAppConInfo;
import com.icinfo.creditinfo.dao.biz.entappcon.EntAppConDao;
import com.icinfo.creditinfo.service.biz.entappcon.EntAppConService;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
/**
 * 
 * 描述: 企业核准内容 Service 实现<br>
 * @author 朱勇
 * @date 2015-01-23
 */
public class EntAppConServiceImpl extends HxBaseServiceImpl<EntAppConInfo> implements EntAppConService
{
	

	/**
	 * 描述: 获取企业核准内容列表
	 * 
	 * @author 朱勇
	 * @date 2015-01-23 
	 * @param qryMap 查询条件
	 * @return
	 * @throws Exception
	 */
	public List<EntAppConInfo> doGetEntAppConInfoListForIndex(
			Map<String, Object> qryMap) throws Exception {
		return (List<EntAppConInfo>)this.doGetEntAppConDao().selectEntAppConInfoListForIndex(qryMap);
	}
	
	
	public EntAppConDao doGetEntAppConDao(){
		return (EntAppConDao)hxBaseDao;
	}
	
	
}
