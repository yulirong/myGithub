/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author 胡义振
 * @date 2013-08-06
 * @version 1.0
 */
package com.icinfo.creditinfo.service.sys.sysuser;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.sys.sysuser.SysUser;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;
import com.icinfo.plugin.hxpermission.bean.HxResource;

/**
 * 描述: 系统用户Service接口<br>
 * @author 胡义振
 * @date 2013-08-06
 */
public interface SysUserService extends HxBaseService<SysUser>{
	
	
	/**
	 * 描述: 通过用户名、密码登陆
	 * @auther 胡义振
	 * @date 2013-8-16 
	 * @param sysUser
	 * @return
	 */
	public SysUser doGetSysUserForLogin(SysUser sysUser);
	
	/**
	 * 描述: 检测用户名是否存在
	 * @auther 胡义振
	 * @date 2014-1-9 
	 * @param loginName
	 * @return
	 */
	public boolean doCheckSysUserLoginNameExist(String loginName,String userId) throws Exception;
	
	/**
	 * 描述: 认证用户信息
	 * @auther 胡义振
	 * @date 2013-8-16 
	 * @param authenMap
	 * @return
	 */
	public String authenSysUser(Map<String, String> authenMap);

	/**
	 * 描述:菜单排序
	 * @return 
	 */
	List<HxResource> doGetHxResourceForMenuList(List<HxResource> hxResources);
	
	
}
