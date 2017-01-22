/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-10-12
 * @version 1.0
 */
package com.icinfo.creditinfo.dao.sys.crusertable;

import com.icinfo.creditinfo.bean.sys.crusertable.CrUserTable;
import com.icinfo.plugin.hxbasedaoservice.dao.HxBaseDao;

/**
 * 
 * 描述: 用户数据查询范围关联表 Dao 接口<br>
 * @author zhuyong
 * @date 2015-10-12
 */
public interface CrUserTableDao extends HxBaseDao<CrUserTable>
{
	/**
	 * 描述：根据userid删除用户数据查询范围关联
	 * 
	 * @author zhuyong
	 * @date 2015-10-12
	 * @param userid
	 * @throws Exception
	 */
	public void doDelCrUserTableByUserId(String userid) throws Exception;
}