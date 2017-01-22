/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-03
 * @version 1.0
 */
package com.icinfo.creditinfo.dao.biz.crwatersewagedischargepay;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crwatersewagedischargepay.CrWaterSewageDischargePay;
import com.icinfo.plugin.hxbasedaoservice.dao.HxBaseDao;

/**
 * 
 * 描述: 污水排放信息表 Dao 接口<br>
 * @author myw
 * @date 2015-11-03
 */
public interface CrWaterSewageDischargePayDao extends HxBaseDao<CrWaterSewageDischargePay>
{

	/**
	 * 描述：获取排污水量统计信息
	 * @author 马亚伟
	 * @date 2015-11-02
	 * @param qryMap
	 * @return List<CrWaterSewageDischargePay>
	 * @throws Exception
	 */
	List<CrWaterSewageDischargePay> selectAnalyWaterSewageDischargePayList(
			Map<String, Object> qryMap) throws Exception;

}