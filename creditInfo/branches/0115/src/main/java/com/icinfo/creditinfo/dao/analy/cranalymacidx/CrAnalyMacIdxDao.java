/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-09
 * @version 1.0
 */
package com.icinfo.creditinfo.dao.analy.cranalymacidx;

import java.util.Map;

import com.icinfo.creditinfo.bean.analy.cranalymacidx.CrAnalyMacIdx;
import com.icinfo.plugin.hxbasedaoservice.dao.HxBaseDao;

/**
 * 
 * 描述: 经济指数风险指数统计表 Dao 接口<br>
 * @author myw
 * @date 2015-11-09
 */
public interface CrAnalyMacIdxDao extends HxBaseDao<CrAnalyMacIdx>
{

	/**
	 * 描述：获取最新的经济指数与信贷风险指数
	 * @author 马亚伟
	 * @date 2015-11-09
	 * @param qryMap
	 * @return
	 */
	CrAnalyMacIdx doGetLateMacIdx(Map<String, Object> qryMap) throws Exception;

}