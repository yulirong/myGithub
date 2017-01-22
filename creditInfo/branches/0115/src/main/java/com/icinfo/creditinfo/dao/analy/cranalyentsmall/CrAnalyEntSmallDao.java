/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-28
 * @version 1.0
 */
package com.icinfo.creditinfo.dao.analy.cranalyentsmall;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.analy.cranalyentsmall.CrAnalyEntSmall;
import com.icinfo.plugin.hxbasedaoservice.dao.HxBaseDao;

/**
 * 
 * 描述: 小微企业 Dao 接口<br>
 * @author liyafeng
 * @date 2015-11-28
 */
public interface CrAnalyEntSmallDao extends HxBaseDao<CrAnalyEntSmall>
{
    /**
     * 
     * 描述: 获得年份
     * @author LiYaFeng
     * @date 2015年11月28日 
     * @return
     * @throws Exception
     */
	public List<BigDecimal> selectYearList() throws Exception;
   /**
    * 
    * 描述: 获得区域企业数
    * @author LiYaFeng
    * @date 2015年11月28日 
    * @param qryMap
    * @return
    * @throws Exception
    */
	public List<CrAnalyEntSmall> selectCrAnalyEntSmallListByZone(Map<String, Object> qryMap)throws Exception;
    /**
     * 
     * 描述: 获得小微企业活跃度
     * @author LiYaFeng
     * @date 2015年11月28日 
     * @param qryMap
     * @return
     */
	public CrAnalyEntSmall selectEntAllTotal(Map<String, Object> qryMap) throws Exception;
	/**
	 * 
	 * 描述:获得小微企业集合
	 * @author LiYaFeng
	 * @date 2015年11月28日 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyEntSmall> selectCrAnalyEntSmallList(Map<String, Object> qryMap) throws Exception;
	/**
	 * 
	 * 描述: 获得小微企业集合——经营参数
	 * @author LiYaFeng
	 * @date 2015年11月28日 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyEntSmall> selectOperateStateListAndDateList(Map<String, Object> qryMap)throws Exception;
	/**
	 * 
	 * 描述: 获得平均每企业的从业人数
	 * @author LiYaFeng
	 * @date 2015年11月28日 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public BigDecimal selectAvgEmpNum(Map<String, Object> qryMap)throws Exception;
	/**
	 * 
	 * 描述: 获得就业情况
	 * @author LiYaFeng
	 * @date 2015年11月28日 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyEntSmall> selectEmpStatus(Map<String, Object> qryMap)throws Exception;
	/**
	 * 
	 * 描述: 三年成长轨迹
	 * @author LiYaFeng
	 * @date 2015年11月29日 
	 * @param qryMap
	 * @return
	 * @throws Exception
	 */
	public List<CrAnalyEntSmall> selectThreeYearGrow(Map<String, Object> qryMap)throws Exception;
	/**
	 * 
	 * 描述: TODO .
	 * @author LiYaFeng
	 * @date 2015年11月30日 
	 * @param qryMap
	 * @return
	 */
	public CrAnalyEntSmall selectEntOpenTotal(Map<String, Object> qryMap)throws Exception;
	/**
	 * 
	 * 描述: 获得最新月
	 * @author LiYaFeng
	 * @date 2015年12月1日 
	 * @return
	 */
	public CrAnalyEntSmall selectCrAnalyEntSmallLast(Map<String, Object> qryMap);

}