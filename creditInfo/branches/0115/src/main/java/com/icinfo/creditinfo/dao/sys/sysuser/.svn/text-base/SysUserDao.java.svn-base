/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author 胡义振
 * @date 2013-08-06
 * @version 1.0
 */
package com.icinfo.creditinfo.dao.sys.sysuser;

import java.util.Map;

import com.icinfo.creditinfo.bean.sys.sysuser.SysUser;
import com.icinfo.plugin.hxbasedaoservice.dao.HxBaseDao;

/**
 * 
 * 描述: 系统用户Dao接口<br>
 * @author 胡义振
 * @date 2013-08-06
 */
public interface SysUserDao extends HxBaseDao<SysUser> 
{
	/**
	 * 描述: 通过用户名、密码登陆
	 * @auther 胡义振
	 * @date 2013-8-16 
	 * @param sysUser
	 * @return
	 */
     public SysUser selectSysUserForLogin(SysUser sysUser);
     
 	/** 
 	 * 描述: 检查用户登录名是否存在
 	 * @auther 胡义振
 	 * @date 2013-8-16 
 	 * @param sysUser
 	 * @return 
 	 */
     public Integer selectSysUserForCheckLoginName(Map<String, Object> qryMap);

}