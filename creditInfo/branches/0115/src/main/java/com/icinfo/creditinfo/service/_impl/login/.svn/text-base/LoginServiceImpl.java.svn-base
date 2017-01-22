package com.icinfo.creditinfo.service._impl.login;

import java.util.List;

import net.sf.json.JSONArray;





import com.icinfo.creditinfo.bean.sys.sysuser.SysUser;
import com.icinfo.creditinfo.service.login.LoginService;
import com.icinfo.creditinfo.service.sys.sysuser.SysUserService;
import com.icinfo.plugin.hxpermission.LoginResult;
import com.icinfo.plugin.hxpermission.UserLoginInterface;
import com.icinfo.plugin.hxpermission.bean.HxResource;
import com.icinfo.plugin.hxpermission.bean.HxRole;
import com.icinfo.plugin.hxpermission.service.HxResourceService;
import com.icinfo.plugin.hxpermission.service.HxRoleService;
import com.icinfo.plugin.hxpermission.shiroexp.HxUsernamePasswordToken;

public class LoginServiceImpl implements LoginService{ 
	private HxRoleService hxRoleService;
	private HxResourceService hxResourceService;
	private SysUserService sysUserService;
	@Override
	public HxUsernamePasswordToken doGetToken(final SysUser sysUser) {
		HxUsernamePasswordToken token = new HxUsernamePasswordToken
				(
					sysUser.getLoginName(),
					sysUser.getLoginPass(),
					new UserLoginInterface(){
						@Override
						public LoginResult doCallLogin() throws Exception{
							List<HxRole> hxRoleList = hxRoleService.doGetHxRoleListByUserId(sysUser.getId());
							//设置用户角色ID
							String hxRoleIds = "";
							if(hxRoleList!=null){
								for(HxRole hxRole: hxRoleList){
									hxRoleIds = hxRoleIds + "," + hxRole.getId();
								}
								sysUser.setHxRoleIds(hxRoleIds);
							}
							//设置用户角色对象
							sysUser.setHxRoleList(hxRoleList);
							LoginResult loginResult = new LoginResult();
							List<HxResource> menuList = sysUserService.doGetHxResourceForMenuList(hxResourceService.doGetHxResourceMenuListByUserId(sysUser.getId()));
							sysUser.setHxResourceMenuList(menuList);
							sysUser.setHxResourceMenuListJson(JSONArray.fromObject(menuList));
							loginResult.setUserId(sysUser.getId());
							loginResult.setUserObject(sysUser);
							loginResult.setLoginSuccess(true);
							return loginResult;
						}
				    }
				);
		return token;
	}
	@Override
	public String[] doGetRoles(SysUser sysUser) {
		String [] hxRoleDecIds = new String[]{};
		if(sysUser.getHxRoleIds()!=null){
			String [] hxRoleIds = sysUser.getHxRoleIds().split(",");
			hxRoleDecIds = new String[hxRoleIds.length];
			for(int i = 0;i<hxRoleIds.length;i++){
				hxRoleDecIds[i]=new String(hxRoleIds[i]);
			}
		}
		return hxRoleDecIds;
	}

	public void setHxRoleService(HxRoleService hxRoleService) {
		this.hxRoleService = hxRoleService;
	}
	public void setHxResourceService(HxResourceService hxResourceService) {
		this.hxResourceService = hxResourceService;
	}
	public void setSysUserService(SysUserService sysUserService) {
		this.sysUserService = sysUserService;
	}
	
}
