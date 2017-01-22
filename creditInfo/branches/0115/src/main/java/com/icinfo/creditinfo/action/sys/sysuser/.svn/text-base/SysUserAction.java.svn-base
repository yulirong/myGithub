/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2013-12-13
 * @version 1.0
 */
package com.icinfo.creditinfo.action.sys.sysuser;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.apache.struts2.ServletActionContext;

import com.google.code.kaptcha.Constants;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.icinfo.creditinfo.bean.sys.crusertable.CrUserTable;
import com.icinfo.creditinfo.bean.sys.sysuser.SysUser;
import com.icinfo.creditinfo.service.login.LoginService;
import com.icinfo.creditinfo.service.sys.crusertable.CrUserTableService;
import com.icinfo.creditinfo.service.sys.sysuser.SysUserService;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.icinfo.plugin.common.HxConstants;
import com.icinfo.plugin.hxpermission.LoginResult;
import com.icinfo.plugin.hxpermission.bean.HxRole;
import com.icinfo.plugin.hxpermission.service.HxResourceService;
import com.icinfo.plugin.hxpermission.service.HxRoleService;
import com.icinfo.plugin.hxpermission.service.HxUserRoleService;
import com.icinfo.plugin.hxpermission.shiroexp.HxUsernamePasswordToken;
import com.icinfo.plugin.pagination.Pagination;
import com.icinfo.plugin.util.HxMd5Util;

/**
 * 描述: 系统用户ACTION<br>
 * 
 * @author zhuyong
 * @date 2015-09-26
 */
public class SysUserAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private HxRoleService hxRoleService;	// 汇信角色服务

	private SysUserService sysUserService;
	
	private HxResourceService hxResourceService;//资源管理
	
	private HxUserRoleService hxUserRoleService;// 用户角色服务类
	
	private CrUserTableService crUserTableService;
	
	private LoginService loginService;

	private SysUser sysUser;
	/** 
	 * 描述: 用户登录
	 * 
	 * @author gqf
	 * @date 2015年9月25日 
	 * @return
	 * @throws Exception 
	 */
	public String doSysUserLoginAction() throws Exception{
		if(sysUser == null){
			return Action.INPUT;
		}
		if(!checkKaptcha(sysUser.getKaptcha())){
			ActionContext.getContext().put("errLogin", "验证码错误，请检查！");
		    return Action.INPUT;	
		}
		String password = HxMd5Util.MD5Encode(sysUser.getLoginPass()+sysUser.getLoginName());
		sysUser.setLoginPass(password);
		final SysUser loginSysUser = sysUserService.doGetSysUserForLogin(sysUser);
      
		if (loginSysUser == null || loginSysUser.getId()==null){			
			ActionContext.getContext().put("errLogin", "用户名或密码错误，请检查！");
		    return Action.INPUT;
		}
		
		if("1".equals(loginSysUser.getUserStatus())){
			ActionContext.getContext().put("errLogin", "该账号已停用");
			return Action.INPUT;
		}
		Map<String,Object> qryMap = new HashMap<String, Object>();
		qryMap.put("userId", loginSysUser.getId());
		loginSysUser.setCrUserTableList(crUserTableService.doGetList(qryMap));
		HxUsernamePasswordToken token = loginService.doGetToken(loginSysUser);
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.login(token);
		SysUser usersession = (SysUser) ((LoginResult) currentUser.getPrincipal()).getUserObject();
		doSetSession(HxConstants.SESSION_USER, usersession);
		return Action.SUCCESS;
	}
	
	/**
	 * 描述：检查验证码是否正确
	 * 
	 * @author zhuyong
	 * @date 2016-01-06
	 * @param kaptcha
	 * @return
	 * @throws Exception
	 */
	public boolean checkKaptcha(String kaptcha) throws Exception{
		if(StringUtils.isBlank(kaptcha)){
			return false;
		}
		Object objectVerifyCode = doGetSession(Constants.KAPTCHA_SESSION_KEY);
		String kaptachaVerifyCode = objectVerifyCode!=null ? objectVerifyCode.toString() : "";
		if (!kaptcha.equals(kaptachaVerifyCode)){
			return false;
		}
		return true;
	}
	
	/**
	 * 描述：证书用户登陆
	 * 
	 * @author zhuyong
	 * @date 2015-10-13
	 * @return
	 * @throws Exception
	 */
	public String doKeyUserLoginAction() throws Exception{
//		String loginName = this.doGetRequst().getParameter("cn").toString().trim();//登录名称
		String keySeries = this.doGetRequst().getParameter("keySeries").toString().trim();//证书序列号
		//String validEndTime = this.doGetRequst().getParameter("validEndTime");
		// 新网关日期格式 2016-10-07-14-33-54
//		if(StringUtils.isBlank(loginName)||StringUtils.isBlank(keySeries)){
//			addActionError("该证书无效！");
//			return INPUT;
//		}
		Map<String,Object> qryMap = new HashMap<String, Object>();
//		qryMap.put("keyUserLoginName",loginName);
		qryMap.put("keySeries", keySeries);
		List<SysUser> sysUserList = sysUserService.doGetList(qryMap);
		if(sysUserList==null||sysUserList.size()==0){
			addActionError("该证书用户不存在！");
			return INPUT;
		}
		final SysUser loginSysUser = sysUserList.get(0);
		if("1".equals(loginSysUser.getUserStatus())){
			addActionError("该账号已停用！");
			return INPUT;
		}
		qryMap.put("userId", loginSysUser.getId());
		loginSysUser.setCrUserTableList(crUserTableService.doGetList(qryMap));
		HxUsernamePasswordToken token = loginService.doGetToken(loginSysUser);
		Subject currentUser = SecurityUtils.getSubject();
		currentUser.login(token);
		SysUser usersession = (SysUser) ((LoginResult) currentUser.getPrincipal()).getUserObject();
		doSetSession(HxConstants.SESSION_USER, usersession);
		return SUCCESS;
	}
	
	/** 
	 * 描述: 退出登录
	 * 
	 * @author zhuyong
	 * @date 2015-10-09 
	 * @return 
	 */
	public String doLoginOutAction() {
		ServletActionContext.getRequest().getSession().invalidate();
		return Action.SUCCESS;
	}
	
	
	/**
	 * 描述: 修改密码
	 * 
	 * @author 朱勇
	 * @date 2015-10-09
	 * @return
	 * @throws Exception
	 */
	public String doEditSysUserPswAction() throws Exception{
		SysUser currSysUser = (SysUser) doGetSession(HxConstants.SESSION_USER);
		String password = HxMd5Util.MD5Encode(sysUser.getOldLoginPass()+currSysUser.getLoginName());
		if(!currSysUser.getLoginPass().equals(password)){
			this.addAjaxResults("success", "passError");
			return AJAX;
		}
		currSysUser.setLoginPass(HxMd5Util.MD5Encode(sysUser.getLoginPass()+currSysUser.getLoginName()));
		sysUserService.doMod(currSysUser);
		doSetSession(HxConstants.SESSION_USER, currSysUser);
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	
	/**
	 * 描述: 分页查询信息
	 * 
	 * @author zhuyong
	 * @date 2015-09-26
	 * @return
	 * @throws Exception
	 */
	public String doReadSysUserListJSONAction() throws Exception{
		Map<String, Object> qryMap = doGetRequestMap();
		if(qryMap.get("depCode") != null){
			String[] depCode = qryMap.get("depCode").toString().split("_");
			qryMap.put("depCode", depCode);
		}
		this.addAjaxResults("pagination", new Pagination(sysUserService.doGetList(qryMap),
				sysUserService.doGetTotal(qryMap), pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}

	/**
	 * 描述: 进入增加(修改)页面
	 * 
	 * @author zhuyong
	 * @date 2015-09-29
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditSysUserAction() throws Exception{
		try{
			if (sysUser != null && sysUser.getId()!=null && !"".equals(sysUser.getId())) {
				sysUser = sysUserService.doGetById(sysUser.getId());
				Map<String,Object> qryMap = new HashMap<String, Object>();
				qryMap.put("userId", sysUser.getId());
				List<CrUserTable> crUserTableList = crUserTableService.doGetList(qryMap);
				sysUser.setScopeCode(doBuildScopeCodeStr(crUserTableList));
				sysUser.setScopeName(doBuildScopeNameStr(crUserTableList));
			}else{
				if(sysUser==null){
				   sysUser = new SysUser();
				}
			}
			// 设置角色
			List<HxRole> hxRoleList = hxRoleService.doGetAllHxRoleListWithUserOwner(sysUser.getId());
			sysUser.setHxRoleList(hxRoleList);
		}catch(Exception er){
			er.printStackTrace();
		}
		return Action.SUCCESS;
	}

	/**
	 * 描述：构造数据查询范围的code集
	 * 
	 * @author zhuyong
	 * @date 2015-10-12
	 * @return
	 * @throws Exception
	 */
	private String doBuildScopeCodeStr(List<CrUserTable> crUserTableList) throws Exception{
		if(crUserTableList==null || crUserTableList.size()==0){
			return "";
		}
		StringBuffer buf = new StringBuffer();
		for (CrUserTable c: crUserTableList) {
			buf.append(c.getTabCode()).append("_");
		}
		return buf.toString();
	}
	
	/**
	 * 描述：构造数据查询范围的name集
	 * 
	 * @author zhuyong
	 * @date 2015-10-12
	 * @return
	 * @throws Exception
	 */
	private String doBuildScopeNameStr(List<CrUserTable> crUserTableList) throws Exception{
		if(crUserTableList==null || crUserTableList.size()==0){
			return "";
		}
		StringBuffer buf = new StringBuffer();
		for (CrUserTable c: crUserTableList) {
			buf.append(c.getTabName()).append(";");
		}
		return buf.toString();
	}

	/**
	 * 描述: 增加(修改)用户信息
	 * 
	 * @author zhuyong
	 * @date 2013-12-13
	 * @return
	 * @throws Exception
	 */
	public String doAddAndEditSysUserAction() throws Exception{
		if (sysUser != null && sysUser.getId() != null && !sysUser.getId().equals("") )	{
			//检测用户名是否存在
			boolean isExist = sysUserService.doCheckSysUserLoginNameExist(sysUser.getLoginName(),sysUser.getId().toString());
			if(isExist){
				this.addAjaxResults("success", "loginNameIsExist");
				return AJAX;
			}
			if(StringUtils.isNotBlank(sysUser.getLoginPass()) && sysUser.getLoginPass().length()<32){
				sysUser.setLoginPass(HxMd5Util.MD5Encode(sysUser.getLoginPass()+sysUser.getLoginName()));	
			}
			sysUserService.doMod(sysUser);
			crUserTableService.doDelCrUserTableByUserId(sysUser.getId());
			crUserTableService.doSaveBatch(doBuildDataSearchScopeBeanList(sysUser.getScopeCode(),sysUser.getId()));
		}else{
			boolean isExist = sysUserService.doCheckSysUserLoginNameExist(sysUser.getLoginName(),null);
			if(isExist){
				this.addAjaxResults("success", "loginNameIsExist");
				return AJAX;
			}
			sysUser.setUserStatus(HxConstants.SYSUSER_STATUS_NORMAL);
			sysUser.setLoginPass(HxMd5Util.MD5Encode(sysUser.getLoginPass()+sysUser.getLoginName()));	
			String userid = sysUserService.doSave(sysUser);
			crUserTableService.doDelCrUserTableByUserId(userid);
			crUserTableService.doSaveBatch(doBuildDataSearchScopeBeanList(sysUser.getScopeCode(),userid));
		}
		
		hxUserRoleService.doModUserRole(sysUser.getId(), loginService.doGetRoles(sysUser));
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	/**
	 * 描述：构建数据查询关联实体集
	 * 
	 * @author zhuyong
	 * @date 2015-10-12
	 * @param codeStr
	 * @param userid
	 * @return
	 * @throws Exception
	 */
	private List<CrUserTable> doBuildDataSearchScopeBeanList(String codeStr,String userid) throws Exception{
		if(StringUtils.isBlank(codeStr)||StringUtils.isBlank(userid)){
			return null;
		}
		String[] codeArr = codeStr.split("_");
		CrUserTable table = new CrUserTable();
		List<CrUserTable> tableList = new ArrayList<CrUserTable>();
		for (String code : codeArr) {
			table = new CrUserTable();
			table.setTabCode(code);
			table.setUserId(userid);
			tableList.add(table);
		}
		return tableList;
	}
	
	/**
	 * 描述:量删除
	 * @author zhuyong
	 * @date 2015-09-29
	 * @return
	 * @throws Exception
	 */
	public String doDelSysUserAction() throws Exception{
		this.addAjaxResults("success", "false");
		if(StringUtils.isNotBlank(sysUser.getId())) {
			if(sysUser.getId().equals(((SysUser) doGetSession(HxConstants.SESSION_USER)).getId())){
				return AJAX;
			}
			sysUserService.doRm(sysUser.getId());
			this.addAjaxResults("success", "true");
		}
		return AJAX;
	}
	
	/**
	 * 描述：修改密码
	 * 
	 * @author zhuyong
	 * @date 2015-06-01
	 * @return
	 * @throws Exception
	 */
	public String doEnSysuserModifyPasswordAction() {
		return SUCCESS;
	}
	
	
	
	public void setSysUserService(SysUserService sysUserService)
	{
		this.sysUserService = sysUserService;
	}

	public SysUser getSysUser()
	{
		return sysUser;
	}

	public void setSysUser(SysUser sysUser)
	{
		this.sysUser = sysUser;
	}

	
	public void setHxRoleService(HxRoleService hxRoleService)
	{
		this.hxRoleService = hxRoleService;
	}

	public LoginService getLoginService() {
		return loginService;
	}

	public void setLoginService(LoginService loginService) {
		this.loginService = loginService;
	}

	public SysUserService getSysUserService() {
		return sysUserService;
	}

	public HxRoleService getHxRoleService() {
		return hxRoleService;
	}

	public HxResourceService getHxResourceService() {
		return hxResourceService;
	}

	public void setHxResourceService(HxResourceService hxResourceService) {
		this.hxResourceService = hxResourceService;
	}

	public HxUserRoleService getHxUserRoleService() {
		return hxUserRoleService;
	}

	public void setHxUserRoleService(HxUserRoleService hxUserRoleService) {
		this.hxUserRoleService = hxUserRoleService;
	}

	public CrUserTableService getCrUserTableService() {
		return crUserTableService;
	}

	public void setCrUserTableService(CrUserTableService crUserTableService) {
		this.crUserTableService = crUserTableService;
	}

}
