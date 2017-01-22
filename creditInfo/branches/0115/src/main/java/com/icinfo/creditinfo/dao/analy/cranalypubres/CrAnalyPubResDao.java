/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author myw
 * @date 2015-11-07
 * @version 1.0
 */
package com.icinfo.creditinfo.dao.analy.cranalypubres;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.analy.cranalypubres.CrAnalyPubRes;
import com.icinfo.plugin.hxbasedaoservice.dao.HxBaseDao;

/**
 * 
 * 描述: 公共资源统计表 Dao 接口<br>
 * @author myw
 * @date 2015-11-07
 */
public interface CrAnalyPubResDao extends HxBaseDao<CrAnalyPubRes>
{

	/**
	 * 描述：查询公共信息统计数据
	 * @author 马亚伟
	 * @date 2015-11-07
	 * @param qryMap
	 * @return
	 */
	List<CrAnalyPubRes> selectAnalyPubResByType(Map<String, Object> qryMap) throws Exception;
	
	/**
	 * 描述：查询公共资源、区域、时间的统计信息
	 * @author 马亚伟
	 * @date 2015-11-09
	 * @param qryMap
	 * @return
	 */
	List<CrAnalyPubRes> selectZonePubResByType(Map<String, Object> qryMap);

}