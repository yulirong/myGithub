/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-12
 * @version 1.0
 */
package com.icinfo.creditinfo.dao._impl.biz.crhistoryrecords;

import java.util.Map;

import com.icinfo.creditinfo.bean.biz.crhistoryrecords.CrHistoryRecords;
import com.icinfo.creditinfo.dao.biz.crhistoryrecords.CrHistoryRecordsDao;
import com.icinfo.plugin.hxbasedaoservice.dao._impl.HxBaseDaoImpl;

/**
 * 描述: 浏览记录 Dao 实现<br>
 * @author yulirong
 * @date 2015-10-12
 */
public class CrHistoryRecordsDaoImpl extends HxBaseDaoImpl<CrHistoryRecords> implements CrHistoryRecordsDao
{

	/**
	 * 描述：清除所有浏览记录
	 * 
	 * @author yulirong
	 * @date 2015-10-13
	 * @param qryMap
	 * @throws Exception
	 */
	public void doDelAllCrHistoryRecords(Map<String,Object> qryMap) throws Exception{
		getBaseSqlMapDao().delete("ibatis-crhistoryrecords.deleteAllCrHistoryRecords",qryMap);
	}
}