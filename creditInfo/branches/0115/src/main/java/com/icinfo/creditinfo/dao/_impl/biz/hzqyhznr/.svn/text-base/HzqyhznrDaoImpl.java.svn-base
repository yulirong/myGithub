/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gqf
 * @date 2015-10-14
 * @version 1.0
 */
package com.icinfo.creditinfo.dao._impl.biz.hzqyhznr;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.hzqyhznr.Hzqyhznr;
import com.icinfo.creditinfo.dao.biz.hzqyhznr.HzqyhznrDao;
import com.icinfo.plugin.hxbasedaoservice.dao._impl.HxBaseDaoImpl;

/**
 * 描述: 异常名录 Dao 实现<br>
 * @author gqf
 * @date 2015-10-14
 */
public class HzqyhznrDaoImpl extends HxBaseDaoImpl<Hzqyhznr> implements HzqyhznrDao
{

	@SuppressWarnings("unchecked")
	@Override
	public List<Hzqyhznr> doGetSubSelectHzqyhznr(Map<String, Object> qryMap)
			throws Exception {
		return getBaseSqlMapDao().queryForList("ibatis-hzqyhznr.selectSubHzqyhznrList", qryMap);
	}

}