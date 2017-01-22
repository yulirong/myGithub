/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-11-04
 * @version 1.0
 */
package com.icinfo.creditinfo.dao._impl.biz.crristindex;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crristindex.CrRistIndex;
import com.icinfo.creditinfo.dao.biz.crristindex.CrRistIndexDao;
import com.icinfo.plugin.hxbasedaoservice.dao._impl.HxBaseDaoImpl;

/**
 * 描述: 风险指数 Dao 实现<br>
 * @author zhuyong
 * @date 2015-11-04
 */
public class CrRistIndexDaoImpl extends HxBaseDaoImpl<CrRistIndex> implements CrRistIndexDao
{
	/**
	 * 描述：获取值得关注的高风险企业（top10）数据
	 * 
	 * @author yulirong
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CrRistIndex> doGetCrRistIndexToptList(Map<String,Object> qryMap) throws Exception{
		return getBaseSqlMapDao().queryForList("ibatis-crristindex.selectCrRistIndexToptList",qryMap);
	}
    /**
     * 
     * 描述: 获取风险日期，指数，行业平均指数集合
     * @author  LiYaFeng
     * @date 2015年12月18日 
     * @param qryMap
     * @return
     * @throws Exception
     */
	@Override
	public List<CrRistIndex> selectCrRistIndexList(Map<String, Object> qryMap) throws Exception {
		return  getBaseSqlMapDao().queryForList("ibatis-crristindex.selectCrRistIndexAllList",qryMap);
	}

}