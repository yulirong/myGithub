/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author 朱勇
 * @date 2015-01-23
 * @version 1.0
 */
package com.icinfo.creditinfo.dao._impl.biz.entappcon;
import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.entappcon.EntAppConInfo;
import com.icinfo.creditinfo.dao.biz.entappcon.EntAppConDao;
import com.icinfo.plugin.hxbasedaoservice.dao._impl.HxBaseDaoImpl;

/**
 * 描述: 企业核准内容 Dao 实现<br>
 * @author 朱勇
 * @date 2015-01-23
 */
public class EntAppConPrestoDaoImpl extends HxBaseDaoImpl<EntAppConInfo> implements EntAppConDao
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
	@SuppressWarnings("unchecked")
	@Override
	public List<EntAppConInfo> selectEntAppConInfoListForIndex(
			Map<String, Object> qryMap) throws Exception {
		return (List<EntAppConInfo>)getBaseSqlMapDao().queryForList("presto-ibatis-entappcon.selectEntAppConInfoListForIndex", qryMap);
	}

}