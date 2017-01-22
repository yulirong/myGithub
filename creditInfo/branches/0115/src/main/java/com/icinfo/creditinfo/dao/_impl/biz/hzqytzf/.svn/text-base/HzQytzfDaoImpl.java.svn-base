/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-10-21
 * @version 1.0
 */
package com.icinfo.creditinfo.dao._impl.biz.hzqytzf;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.hzqytzf.HzQytzf;
import com.icinfo.creditinfo.dao.biz.hzqytzf.HzQytzfDao;
import com.icinfo.plugin.hxbasedaoservice.dao._impl.HxBaseDaoImpl;

/**
 * 描述: 企业投资方 Dao 实现<br>
 * @author gaotong
 * @date 2015-10-21
 */
public class HzQytzfDaoImpl extends HxBaseDaoImpl<HzQytzf> implements HzQytzfDao
{
	/**
	 * 描述：获取关系 网络所需关联数据
	 * 
	 * @author yulirong
	 * @date 2015-10-31
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<HzQytzf> doSelectHzQytzfListForRelationalNet(Map<String, Object> qryMap) throws Exception{
		return (List<HzQytzf>)getBaseSqlMapDao().queryForList("ibatis-hzqytzf.selectHzQytzfListForRelationalNet",qryMap);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<HzQytzf> doSelectHzQytzfListByCorpid(String corpid)
			throws Exception {
		return getBaseSqlMapDao().queryForList("ibatis-hzqytzf.selectHzQytzfListByCorpid", corpid);
	}

}