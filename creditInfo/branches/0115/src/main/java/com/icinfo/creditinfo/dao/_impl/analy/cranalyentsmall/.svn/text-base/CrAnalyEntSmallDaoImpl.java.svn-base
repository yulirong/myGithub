/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-28
 * @version 1.0
 */
package com.icinfo.creditinfo.dao._impl.analy.cranalyentsmall;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.analy.cranalyentsmall.CrAnalyEntSmall;
import com.icinfo.creditinfo.dao.analy.cranalyentsmall.CrAnalyEntSmallDao;
import com.icinfo.plugin.hxbasedaoservice.dao._impl.HxBaseDaoImpl;

/**
 * 描述: 小微企业 Dao 实现<br>
 * @author liyafeng
 * @date 2015-11-28
 */
public class CrAnalyEntSmallDaoImpl extends HxBaseDaoImpl<CrAnalyEntSmall> implements CrAnalyEntSmallDao
{
    /**
     * 
     * 描述: 获得年份
     * @author  LiYaFeng
     * @date 2015年11月28日 
     * @throws Exception
     */
	@Override
	public List<BigDecimal> selectYearList() throws Exception {
		return (List<BigDecimal>)getBaseSqlMapDao().queryForList("ibatis-cranalyentsmall.selectYearList");
	}
    /**
     * 
     * 描述: 获得区域小微企业数
     * @author  LiYaFeng
     * @date 2015年11月28日 
     * @param qryMap
     * @return
     * @throws Exception
     */
	@Override
	public List<CrAnalyEntSmall> selectCrAnalyEntSmallListByZone(Map<String, Object> qryMap) throws Exception {
		return (List<CrAnalyEntSmall>)getBaseSqlMapDao().queryForList("ibatis-cranalyentsmall.selectCrAnalyEntSmallListByZone",qryMap);
	}
	/**
	 * 
	 * 描述: 获得小微企业活跃度
	 * @author  LiYaFeng
	 * @date 2015年11月28日 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public CrAnalyEntSmall selectEntAllTotal(Map<String, Object> qryMap) throws Exception {
		return (CrAnalyEntSmall) getBaseSqlMapDao().queryForObject("ibatis-cranalyentsmall.selectEntAllTotal",qryMap);
	}
	/**
	 * 
	 * 描述: 获得小微企业集合
	 * @author  LiYaFeng
	 * @date 2015年11月28日 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CrAnalyEntSmall> selectCrAnalyEntSmallList(Map<String, Object> qryMap) throws Exception {
		return (List<CrAnalyEntSmall>)getBaseSqlMapDao().queryForList("ibatis-cranalyentsmall.selectCrAnalyEntSmallListByDate",qryMap);
	}
	/**
	 * 
	 * 描述: TODO .
	 * @author  LiYaFeng
	 * @date 2015年11月28日 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CrAnalyEntSmall> selectOperateStateListAndDateList(Map<String, Object> qryMap) throws Exception {
		return (List<CrAnalyEntSmall>)getBaseSqlMapDao().queryForList("ibatis-cranalyentsmall.selectOperateStateListAndDateList",qryMap);
	}
	/**
	 * 
	 * 描述: 获得平均每企业从业人数
	 * @author  LiYaFeng
	 * @date 2015年11月28日 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public BigDecimal selectAvgEmpNum(Map<String, Object> qryMap) throws Exception {
		return (BigDecimal)getBaseSqlMapDao().queryForObject("ibatis-cranalyentsmall.selectAvgEmpNum", qryMap);
	}
	/**
	 * 
	 * 描述: 获得就业情况
	 * @author  LiYaFeng
	 * @date 2015年11月28日 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CrAnalyEntSmall> selectEmpStatus(Map<String, Object> qryMap) throws Exception {
		return (List<CrAnalyEntSmall>)getBaseSqlMapDao().queryForList("ibatis-cranalyentsmall.selectEmpStatus",qryMap);
	}
	/**
	 * 
	 * 描述: 三年成长轨迹.
	 * @author  LiYaFeng
	 * @date 2015年11月29日 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CrAnalyEntSmall> selectThreeYearGrow(Map<String, Object> qryMap) throws Exception {
		return (List<CrAnalyEntSmall>)getBaseSqlMapDao().queryForList("ibatis-cranalyentsmall.selectThreeYearGrow",qryMap);
	}
	
	@Override
	public CrAnalyEntSmall selectEntOpenTotal(Map<String, Object> qryMap) throws Exception {
		return (CrAnalyEntSmall) getBaseSqlMapDao().queryForObject("ibatis-cranalyentsmall.selectEntOpenTotal",qryMap);
	}
	/**
	 * 
	 * 描述:获得最新月
	 * @author  LiYaFeng
	 * @date 2015年12月1日 
	 * @return
	 */
	@Override
	public CrAnalyEntSmall selectCrAnalyEntSmallLast(Map<String, Object> qryMap) {
		return (CrAnalyEntSmall) getBaseSqlMapDao().queryForObject("ibatis-cranalyentsmall.selectCrAnalyEntSmallLast",qryMap);
	}

}