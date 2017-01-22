/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author 胡义振
 * @date 2013-08-06
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.sys.sysuser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icinfo.creditinfo.bean.sys.sysuser.SysUser;
import com.icinfo.creditinfo.dao.sys.sysuser.SysUserDao;
import com.icinfo.creditinfo.service.sys.sysuser.SysUserService;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.plugin.hxpermission.bean.HxResource;


/**
 * 
 * 描述: 系统用户Service实现<br>
 * @author 胡义振
 * @date 2013-08-06
 */
public class SysUserServiceImpl extends HxBaseServiceImpl<SysUser> implements SysUserService
{

	/** 
	 * 描述: 通过用户名、密码登陆
	 * @auther 胡义振
	 * @date 2013-8-16 
	 * @param sysUser
	 * @return 
	 */
	@Override
	public SysUser doGetSysUserForLogin(SysUser sysUser)
	{
		try
		{
			sysUser = getSysUserDao().selectSysUserForLogin(sysUser);
		}
		catch(Exception er){
			er.printStackTrace();
			return null;
		}
		return sysUser;
	}

	/** 
	 * 描述: 检测登录名是否存在
	 * @auther 胡义振
	 * @date 2014-1-9 
	 * @param loginName
	 * @return 
	 */
	@Override
	public boolean doCheckSysUserLoginNameExist(String loginName,String userId) throws Exception
	{
		Map<String, Object> qryMap = new HashMap<String,Object>();
		qryMap.put("loginName", loginName);
		//检测新增用户的登录名
		if(userId!=null && !userId.equals("")){
			qryMap.put("id", userId);
		}
		Integer searchCount = getSysUserDao().selectSysUserForCheckLoginName(qryMap);
		if(searchCount!=null && searchCount>0){
			return true;
		}
		return false;
	}
	
	/** 
	 * 描述: 认证用户信息
	 * @auther 胡义振
	 * @date 2013-8-16 
	 * @param authenMap 
	 * @return 返回为 0 表示正确，返回其他为错误信息
	 */
	@Override
	public String authenSysUser(Map<String, String> authenMap)
	{
		if(authenMap==null){
			return "用户身份参数为空！";
		}
		else if(authenMap.get("loginName")==null){
			return "用户登录名为空！";
		}
		else if(authenMap.get("loginPass")==null){
			return "用户密码为空！";
		}
		else{
			SysUser sysUser = new SysUser();
			sysUser.setLoginName(authenMap.get("loginName"));
			sysUser.setLoginPass(authenMap.get("loginPass"));
			sysUser = doGetSysUserForLogin(sysUser);
			if(sysUser==null){
				return "用户身份认证失败！";
			}
			else{
				return "0";
			}
		}
	}

	/**
	 * 描述:菜单排序
	 * @return 
	 */
	public List<HxResource> doGetHxResourceForMenuList(List<HxResource> hxResourceList){
		List<HxResource> menuList = new ArrayList<HxResource>();
		List<HxResource> parentMenuList = new ArrayList<HxResource>();
		List<HxResource> childMenuList = new ArrayList<HxResource>();
		for (Iterator<HxResource> iterator = hxResourceList.iterator(); iterator.hasNext();) {
			HxResource hxResource = (HxResource) iterator.next();
			if(hxResource.getParentId().equals("0")){
				parentMenuList.add(hxResource);
			}else{
				childMenuList.add(hxResource);
			}
		}
		HxResource[] parentMenuArray = new HxResource[parentMenuList.size()];
		HxResource[] childMenuArray = new HxResource[childMenuList.size()];
		parentMenuList.toArray(parentMenuArray);
		parentMenuArray = sort(parentMenuArray.clone());
		childMenuList.toArray(childMenuArray);
		childMenuArray = sort(childMenuArray.clone());
		for (HxResource parent : parentMenuArray) {
			menuList.add(parent);
			for (HxResource child : childMenuArray) {
				if(child.getParentId().equals(parent.getId())){
					menuList.add(child);
				}
			}
		}
		return menuList;
	}
	
	private HxResource[] sort(HxResource[] array){
		for (int i = 0; i<array.length-1;i++){
			for (int j = 0; j <array.length-1-i;j++){
				HxResource current = array[j];
				HxResource next = array[j+1];
				if(current.getResOrderNum()==null){
					current.setResOrderNum("0");
				}
				if(next.getResOrderNum()==null){
					next.setResOrderNum("0");
				}
				if (Integer.parseInt(next.getResOrderNum()) < Integer.parseInt(current.getResOrderNum()) || (Integer.parseInt(next.getResOrderNum()) == Integer.parseInt(current.getResOrderNum()) && next.getId().compareTo(current.getId()) > 0 )){
					array[j] = next;
					array[j + 1] = current;
				}
			}
		}
		return array;
	}
	
	
	public SysUserDao getSysUserDao()
	{
		return (SysUserDao)hxBaseDao;
	}

}
