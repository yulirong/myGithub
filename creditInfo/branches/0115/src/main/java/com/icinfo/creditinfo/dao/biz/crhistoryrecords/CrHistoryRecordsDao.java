/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-12
 * @version 1.0
 */
package com.icinfo.creditinfo.dao.biz.crhistoryrecords;

import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crhistoryrecords.CrHistoryRecords;
import com.icinfo.plugin.hxbasedaoservice.dao.HxBaseDao;

/**
 * 
 * 描述: 浏览记录 Dao 接口<br>
 * @author yulirong
 * @date 2015-10-12
 */
public interface CrHistoryRecordsDao extends HxBaseDao<CrHistoryRecords>
{

	/**
	 * 描述：清除所有浏览记录
	 * 
	 * @author yulirong
	 * @date 2015-10-13
	 * @param qryMap
	 * @throws Exception
	 */
	public void doDelAllCrHistoryRecords(Map<String,Object> qryMap) throws Exception;
}