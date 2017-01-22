package com.icinfo.creditinfo.dao._impl.biz.hzqyhznr;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.hzqyhznr.Hzqyhznr;
import com.icinfo.creditinfo.dao.biz.hzqyhznr.HzqyhznrDao;
import com.icinfo.plugin.hxbasedaoservice.dao._impl.HxBaseDaoImpl;

public class HzqyhznrPrestoDaoImpl extends HxBaseDaoImpl<Hzqyhznr> implements HzqyhznrDao{

	/** 
	 * 描述: sub
	 * @auther gqf
	 * @date 2015年10月14日 
	 * @param qryMap
	 * @return
	 * @throws Exception 
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Hzqyhznr> doGetSubSelectHzqyhznr(Map<String, Object> qryMap)
			throws Exception {
		return getBaseSqlMapDao().queryForList("presto-ibatis-hzqyhznr.selectSubHzqyhznrList", qryMap);
	}
}
