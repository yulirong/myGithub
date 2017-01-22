/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-03
 * @version 1.0
 */
package com.icinfo.creditinfo.dao.biz.crelecpay;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crelecpay.CrElecPay;
import com.icinfo.plugin.hxbasedaoservice.dao.HxBaseDao;

/**
 * 
 * 描述: 用电量信息表 Dao 接口<br>
 * @author myw
 * @date 2015-11-03
 */
public interface CrElecPayDao extends HxBaseDao<CrElecPay>
{
	/**
	 * 描述：获取用电量统计信息
	 * @author 马亚伟
	 * @date 2015-11-02
	 * @param qryMap
	 * @return List<CrElecPay>
	 * @throws Exception
	 */
	List<CrElecPay> selectAnalyElecPayList(Map<String, Object> qryMap) throws Exception;
	
	/** 
	 * 描述: TODO
	 * @auther gqf
	 * @date 2015年12月28日 
	 * @param qryMap
	 * @return
	 * @throws Exception 
	 */
	
	List<CrElecPay> selectCrElecPayListByJxwService(Map<String, Object> qryMap) throws Exception;
	
	/** 
	 * 描述: TODO
	 * @auther gqf
	 * @date 2015年12月30日 
	 * @param qryMap
	 * @return
	 * @throws Exception 
	 */
	
	Integer selectCrElecPayListByJxwServiceTotal(Map<String, Object> qryMap) throws Exception;

}