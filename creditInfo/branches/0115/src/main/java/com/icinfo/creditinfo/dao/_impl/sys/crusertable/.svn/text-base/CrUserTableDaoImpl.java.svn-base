/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-10-12
 * @version 1.0
 */
package com.icinfo.creditinfo.dao._impl.sys.crusertable;

import com.icinfo.creditinfo.bean.sys.crusertable.CrUserTable;
import com.icinfo.creditinfo.dao.sys.crusertable.CrUserTableDao;
import com.icinfo.plugin.hxbasedaoservice.dao._impl.HxBaseDaoImpl;

/**
 * 描述: 用户数据查询范围关联表 Dao 实现<br>
 * @author zhuyong
 * @date 2015-10-12
 */
public class CrUserTableDaoImpl extends HxBaseDaoImpl<CrUserTable> implements CrUserTableDao
{
	/**
	 * 描述：根据userid删除用户数据查询范围关联
	 * 
	 * @author zhuyong
	 * @date 2015-10-12
	 * @param userid
	 * @throws Exception
	 */
	public void doDelCrUserTableByUserId(String userid) throws Exception{
		getBaseSqlMapDao().delete("ibatis-crusertable.deleteCrUserTableByUserId",userid);
	}
}