/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-10-31
 * @version 1.0
 */
package com.icinfo.creditinfo.dao._impl.biz.hzbgnrdb;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.hzbgnrdb.HzBgnrdb;
import com.icinfo.creditinfo.bean.biz.hzbgnrdb.RegCapHistory;
import com.icinfo.creditinfo.dao.biz.hzbgnrdb.HzBgnrdbDao;
import com.icinfo.plugin.hxbasedaoservice.dao._impl.HxBaseDaoImpl;

/**
 * 描述: 变更记录 Dao 实现<br>
 * @author zhuyong
 * @date 2015-10-31
 */
public class HzBgnrdbDaoImpl extends HxBaseDaoImpl<HzBgnrdb> implements HzBgnrdbDao
{
	/**
	 * 描述：获取注册资本和股东变更历史
	 * 
	 * @author zhuyong
	 * @param qrymapMap
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<RegCapHistory> doGetRegCapHisList(Map<String,Object> qryMap) throws Exception{
		return (List<RegCapHistory>)getBaseSqlMapDao().queryForList("ibatis-hzbgnrdb.selectRegCapHisList",qryMap);
	}

	@Override
	public Integer doGetRegCapHisTotal(Map<String, Object> qryMap) throws Exception {
		return  (Integer)getBaseSqlMapDao().queryForObject("ibatis-hzbgnrdb.selectRegCapHisTotal",qryMap);
	}
	
}