/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-28
 * @version 1.0
 */
package com.icinfo.creditinfo.dao.analy.cranalyentblock;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.analy.cranalyentblock.CrAnalyEntBlock;
import com.icinfo.plugin.hxbasedaoservice.dao.HxBaseDao;

/**
 * 
 * 描述: 块状经济专题分析表 Dao 接口<br>
 * @author myw
 * @date 2015-11-28
 */
public interface CrAnalyEntBlockDao extends HxBaseDao<CrAnalyEntBlock>
{

	/**
	 * 描述：获取年份集合
	 * @author mayawei
	 * @date 2015-11-28
	 * @return List<CrAnalyEntBlock>
	 * @throws Exception
	 */
	List<CrAnalyEntBlock> selectEntBlockYearList() throws Exception;

	/**
	 * 描述：获得chart1的数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	List<CrAnalyEntBlock> selectEntBlockListForChart1(Map<String, Object> qryMap) throws Exception;

	/**
	 * 描述：获得chart2的数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	List<CrAnalyEntBlock> selectTradeDataJSONForChart2(Map<String, Object> qryMap) throws Exception;

	/**
	 * 描述：获得chart2的数据最大最小时间
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	List<CrAnalyEntBlock> selectTradeDataDateForChart2(Map<String, Object> qryMap) throws Exception;
	/**
	 * 描述：获得chart22的数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	List<CrAnalyEntBlock> selectTradeDataJSONForChart22(Map<String, Object> qryMap) throws Exception;
	/**
	 * 描述：获得chart23的数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	List<CrAnalyEntBlock> selectTradeDataJSONForChart23(Map<String, Object> qryMap) throws Exception;
	/**
	 * 描述：获得chart31的数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	List<CrAnalyEntBlock> selectTradeDataJSONForChart31(Map<String, Object> qryMap) throws Exception;
	/**
	 * 描述：获得chart31的数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	List<CrAnalyEntBlock> selectTradeDataJSONForChart33(Map<String, Object> qryMap) throws Exception;
	/**
	 * 描述：获得chart41的数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	List<CrAnalyEntBlock> selectTradeDataJSONForChart41(Map<String, Object> qryMap) throws Exception;

	/**
	 * 描述：获得chart42的数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	List<CrAnalyEntBlock> selectTradeDataJSONForChart42(Map<String, Object> qryMap) throws Exception;
	
	/**
	 * 描述：获得chart42的数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	List<CrAnalyEntBlock> selectTradeCodeListForChart42(Map<String, Object> qryMap) throws Exception;
	/**
	 * 描述：获得chart32的数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	List<CrAnalyEntBlock> selectTradeDataJSONForChart32(Map<String, Object> qryMap) throws Exception;
	/**
	 * 描述：获得chart32的数据
	 * @author mayawei
	 * @date 2015-11-28
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	List<CrAnalyEntBlock> selectTradeTimeJSONForChart32(Map<String, Object> qryMap) throws Exception;

}