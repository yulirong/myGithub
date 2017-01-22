/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-11-28
 * @version 1.0
 */
package com.icinfo.creditinfo.dao._impl.analy.cranalyenttown;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.analy.cranalyenttown.CrAnalyEntTown;
import com.icinfo.creditinfo.dao.analy.cranalyenttown.CrAnalyEntTownDao;
import com.icinfo.plugin.hxbasedaoservice.dao._impl.HxBaseDaoImpl;

/**
 * 描述: 特色小镇 Dao 实现<br>
 * @author yulirong
 * @date 2015-11-28
 */
public class CrAnalyEntTownDaoImpl extends HxBaseDaoImpl<CrAnalyEntTown> implements CrAnalyEntTownDao
{
	/**
	 * 描述: 获取特色小镇企业数量
	 * 
	 * @author ylr
	 * @date 2015-11-28
	 * @throws Exception
	 */
	public CrAnalyEntTown doGetQyCount() throws Exception{
		return (CrAnalyEntTown) getBaseSqlMapDao().queryForObject("ibatis-cranalyenttown.selectCrAnalyEntTownForQyCount");
	}
	/**
	 * 描述: 获取产业特点企业数量
	 * 
	 * @author ylr
	 * @date 2015-11-28
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CrAnalyEntTown> doGetIndustryCharacter(Map<String, Object> qryMap) throws Exception{
		return getBaseSqlMapDao().queryForList("ibatis-cranalyenttown.selectCrAnalyEntTownForIndustryCharacter",qryMap);
	}

	
	/**
	 * 描述：获取企业规模大小数据
	 * 
	 * @author zhuyong
	 * @date 2015-11-28
	 * @param dataList
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CrAnalyEntTown> doSelectQyScaleDataList(Map<String,Object> qryMap) throws Exception{
		return getBaseSqlMapDao().queryForList("ibatis-cranalyenttown.selectQyScaleDataList",qryMap);
	}
	/**
	 * 描述：运营状况
	 * 
	 * @author ylr
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CrAnalyEntTown> doGetOperationStatus(Map<String, Object> qryMap) throws Exception{
		return getBaseSqlMapDao().queryForList("ibatis-cranalyenttown.selectOperationStatus",qryMap);
	}
	/**
	 * 描述：资产总额
	 * 
	 * @author ylr
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CrAnalyEntTown> doGetTotalAsset(Map<String, Object> qryMap) throws Exception{
		return getBaseSqlMapDao().queryForList("ibatis-cranalyenttown.selectTotalAsset",qryMap);
	}
	/**
	 * 描述：盈利状况
	 * 
	 * @author ylr
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CrAnalyEntTown> doGetProfitStatus(Map<String, Object> qryMap) throws Exception{
		return getBaseSqlMapDao().queryForList("ibatis-cranalyenttown.selectProfitStatus",qryMap);
	}
	/**
	 * 描述：盈利企业数量
	 * 
	 * @author ylr
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CrAnalyEntTown> doGetProfitTotal(Map<String, Object> qryMap) throws Exception{
		return getBaseSqlMapDao().queryForList("ibatis-cranalyenttown.selectProfitTotal",qryMap);
	}
	/**
	 * 描述：对周边经济的影响程度
	 * 
	 * @author ylr
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CrAnalyEntTown> doGetLocalEconomy(Map<String, Object> qryMap) throws Exception{
		return getBaseSqlMapDao().queryForList("ibatis-cranalyenttown.selectLocalEconomy",qryMap);
	}
	/**
	 * 描述：对行业的影响程度
	 * 
	 * @author ylr
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CrAnalyEntTown> doGetLocalIndustry(Map<String, Object> qryMap) throws Exception{
		return getBaseSqlMapDao().queryForList("ibatis-cranalyenttown.selectLocalIndustry",qryMap);
	}
	/**
	 * 描述：就业贡献
	 * 
	 * @author ylr
	 * @date 2015-11-28
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<CrAnalyEntTown> doGetEmploymentContribution(Map<String, Object> qryMap) throws Exception{
		return getBaseSqlMapDao().queryForList("ibatis-cranalyenttown.selectEmploymentContribution",qryMap);
	}

}