/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-03
 * @version 1.0
 */
package com.icinfo.creditinfo.dao.biz.crwaterpay;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crwaterpay.CrWaterPay;
import com.icinfo.plugin.hxbasedaoservice.dao.HxBaseDao;

/**
 * 
 * 描述: 用水量信息统计表 Dao 接口<br>
 * @author myw
 * @date 2015-11-03
 */
public interface CrWaterPayDao extends HxBaseDao<CrWaterPay>
{

	/**
	 * 描述：获取用水量统计信息
	 * @author 马亚伟
	 * @date 2015-11-02
	 * @param qryMap
	 * @return List<CrElecPay>
	 * @throws Exception
	 */
	List<CrWaterPay> selectAnalyWaterPayList(Map<String, Object> qryMap) throws Exception;

}