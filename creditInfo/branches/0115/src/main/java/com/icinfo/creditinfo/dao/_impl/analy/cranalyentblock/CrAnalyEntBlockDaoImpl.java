/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-28
 * @version 1.0
 */
package com.icinfo.creditinfo.dao._impl.analy.cranalyentblock;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.analy.cranalyentblock.CrAnalyEntBlock;
import com.icinfo.creditinfo.dao.analy.cranalyentblock.CrAnalyEntBlockDao;
import com.icinfo.plugin.hxbasedaoservice.dao._impl.HxBaseDaoImpl;

/**
 * 描述: 块状经济专题分析表 Dao 实现<br>
 * @author myw
 * @date 2015-11-28
 */
public class CrAnalyEntBlockDaoImpl extends HxBaseDaoImpl<CrAnalyEntBlock> implements CrAnalyEntBlockDao
{
	
	/**
	 * 描述：获取年份集合
	 * @author mayawei
	 * @date 2015-11-28
	 * @return List<CrAnalyEntBlock>
	 * @throws Exception
	 */
	@Override
	public List<CrAnalyEntBlock> selectEntBlockYearList() throws Exception {
		return getBaseSqlMapDao().queryForList("ibatis-cranalyentblock.selectEntBlockYearList");
	}

	/**
	 * 描述：获得chart1的数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CrAnalyEntBlock> selectEntBlockListForChart1(
			Map<String, Object> qryMap) throws Exception {
		return getBaseSqlMapDao().queryForList("ibatis-cranalyentblock.selectEntBlockListForChart1");
	}

	/**
	 * 描述：获得chart2的数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CrAnalyEntBlock> selectTradeDataJSONForChart2(
			Map<String, Object> qryMap) throws Exception {
		return getBaseSqlMapDao().queryForList("ibatis-cranalyentblock.selectEntBlockListForChart2",qryMap);
	}

	/**
	 * 描述：获得chart2的数据最大最小时间
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CrAnalyEntBlock> selectTradeDataDateForChart2(
			Map<String, Object> qryMap) throws Exception {
		return getBaseSqlMapDao().queryForList("ibatis-cranalyentblock.selectTradeDateForChart2",qryMap);
	}
	
	/**
	 * 描述：获得chart2的数据最大最小时间
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CrAnalyEntBlock> selectTradeDataJSONForChart22(
			Map<String, Object> qryMap) throws Exception {
		return getBaseSqlMapDao().queryForList("ibatis-cranalyentblock.selectTradeDateForChart22",qryMap);
	}
	
	/**
	 * 描述：获得chart2的数据最大最小时间
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CrAnalyEntBlock> selectTradeDataJSONForChart23(
			Map<String, Object> qryMap) throws Exception {
		return getBaseSqlMapDao().queryForList("ibatis-cranalyentblock.selectTradeDateForChart23",qryMap);
	}
	/**
	 * 描述：获得chart31的数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CrAnalyEntBlock> selectTradeDataJSONForChart31(
			Map<String, Object> qryMap) throws Exception {
		return getBaseSqlMapDao().queryForList("ibatis-cranalyentblock.selectTradeDateForChart31",qryMap);
	}
	/**
	 * 描述：获得chart31的数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CrAnalyEntBlock> selectTradeDataJSONForChart33(
			Map<String, Object> qryMap) throws Exception {
		return getBaseSqlMapDao().queryForList("ibatis-cranalyentblock.selectTradeDateForChart33",qryMap);
	}
	
	/**
	 * 描述：获得chart4的数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CrAnalyEntBlock> selectTradeDataJSONForChart41(
			Map<String, Object> qryMap) throws Exception {
		return getBaseSqlMapDao().queryForList("ibatis-cranalyentblock.selectTradeDateForChart41",qryMap);
	}
	
	/**
	 * 描述：获得chart4-2的数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CrAnalyEntBlock> selectTradeDataJSONForChart42(
			Map<String, Object> qryMap) throws Exception {
		return getBaseSqlMapDao().queryForList("ibatis-cranalyentblock.selectTradeDateForChart42",qryMap);
	}
	
	/**
	 * 描述：获得chart4-2的行业
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CrAnalyEntBlock> selectTradeCodeListForChart42(
			Map<String, Object> qryMap) throws Exception {
		return getBaseSqlMapDao().queryForList("ibatis-cranalyentblock.selectTradeCodeForChart42",qryMap);
	}
	
	/**
	 * 描述：获得chart3-2的数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CrAnalyEntBlock> selectTradeDataJSONForChart32(
			Map<String, Object> qryMap) throws Exception {
		return getBaseSqlMapDao().queryForList("ibatis-cranalyentblock.selectTradeDateForChart32",qryMap);
	}
	
	/**
	 * 描述：获得chart3-2的数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	@Override
	public List<CrAnalyEntBlock> selectTradeTimeJSONForChart32(
			Map<String, Object> qryMap) throws Exception {
		return getBaseSqlMapDao().queryForList("ibatis-cranalyentblock.selectTradeTimeJSONForChart32",qryMap);
	}
	
	
	
	
}