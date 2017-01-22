/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author 胡义振
 * @date 2013-08-06
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.sys.sysuser;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;
import net.sf.json.JSONArray;
import com.icinfo.creditinfo.bean.sys.crusertable.CrUserTable;
import com.icinfo.plugin.hxpermission.bean.HxResource;
import com.icinfo.plugin.hxpermission.bean.HxRole;

/**
 * 描述: 系统用户<br>
 * 
 * @author zhuyong
 * @date 2015-09-26
 */
public class SysUser implements Serializable
{

	

	//TODO
	private static final long serialVersionUID = 5037503580494159915L;
	// ID
	private String				id;
	// 登录名
	private String				loginName;
	// 老密码
	private String              oldLoginPass;
	// 登录密码
	private String				loginPass;
	// 确认密码
	private String              repeatLoginPass;
	// 真实姓名
	private String				realName;
	// 手机号
	private String              mobile;
	// 电话号码
	private String              telephone;
	// 电子邮件
	private String              email;
	// 用户状态  0:正常  1：停用
	private String				userStatus;
	// 建立时间
	private Date				createTime;
	// 用户资源
	private List<HxResource>	hxResourceList; 
	// 用户菜单资源
	private List<HxResource>    hxResourceMenuList;
	
	private JSONArray     hxResourceMenuListJson;
	// 数据查询范围
	private List<CrUserTable> 	crUserTableList;
	// 用户菜单资源
	// 用户角色
	private List<HxRole>		hxRoleList;
	// 验证码
	private String				verifyCode;
	// 用户分配的角色ID集
	private String		        hxRoleIds;
	//部门编码
	private String depCode;
	//部门名称
	private String depName;
	//数据查询范围
	private String scopeCode;
	//数据查询范围名称
	private String scopeName;
	//证书序列号
	private String keySeries;
	//用户类型   1：查询   2：部门  3：管理员
	private String userType;
	//身份证号
	private String userId;
	//QQ
	private String userQq;
	
	//验证码
	private String kaptcha;
	
	
	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getLoginName()
	{
		return loginName;
	}

	public void setLoginName(String loginName)
	{
		this.loginName = loginName;
	}

	public String getLoginPass()
	{
		return loginPass;
	}

	public void setLoginPass(String loginPass)
	{
		this.loginPass = loginPass;
	}

	public String getRealName()
	{
		return realName;
	}

	public void setRealName(String realName)
	{
		this.realName = realName;
	}

	public Date getCreateTime()
	{
		return createTime;
	}

	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}

	public List<HxResource> getHxResourceList()
	{
		return hxResourceList;
	}

	public void setHxResourceList(List<HxResource> hxResourceList)
	{
		this.hxResourceList = hxResourceList;
	}

	public List<HxRole> getHxRoleList()
	{
		return hxRoleList;
	}

	public void setHxRoleList(List<HxRole> hxRoleList)
	{
		this.hxRoleList = hxRoleList;
	}

	public String getVerifyCode()
	{
		return verifyCode;
	}

	public void setVerifyCode(String verifyCode)
	{
		this.verifyCode = verifyCode;
	}

	public List<HxResource> getHxResourceMenuList()
	{
		return hxResourceMenuList;
	}

	public void setHxResourceMenuList(List<HxResource> hxResourceMenuList)
	{
		this.hxResourceMenuList = hxResourceMenuList;
	}

	public String getHxRoleIds()
	{
		return hxRoleIds;
	}

	public void setHxRoleIds(String hxRoleIds)
	{
		this.hxRoleIds = hxRoleIds;
	}
	public String getMobile()
	{
		return mobile;
	}

	public void setMobile(String mobile)
	{
		this.mobile = mobile;
	}

	public String getTelephone()
	{
		return telephone;
	}
	public void setTelephone(String telephone)
	{
		this.telephone = telephone;
	}

	public String getEmail()
	{
		return email;
	}
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getUserStatus()
	{
		return userStatus;
	}
	public void setUserStatus(String userStatus)
	{
		this.userStatus = userStatus;
	}

	public String getOldLoginPass()
	{
		return oldLoginPass;
	}

	public void setOldLoginPass(String oldLoginPass)
	{
		this.oldLoginPass = oldLoginPass;
	}

	public String getRepeatLoginPass()
	{
		return repeatLoginPass;
	}

	public void setRepeatLoginPass(String repeatLoginPass)
	{
		this.repeatLoginPass = repeatLoginPass;
	}

	public String getDepCode() {
		return depCode;
	}
	public void setDepCode(String depCode) {
		this.depCode = depCode;
	}
	public String getDepName() {
		return depName;
	}
	public void setDepName(String depName) {
		this.depName = depName;
	}

	public String getScopeCode() {
		return scopeCode;
	}

	public void setScopeCode(String scopeCode) {
		this.scopeCode = scopeCode;
	}

	public String getScopeName() {
		return scopeName;
	}

	public void setScopeName(String scopeName) {
		this.scopeName = scopeName;
	}

	public List<CrUserTable> getCrUserTableList() {
		return crUserTableList;
	}

	public void setCrUserTableList(List<CrUserTable> crUserTableList) {
		this.crUserTableList = crUserTableList;
	}

	public String getKeySeries() {
		return keySeries;
	}

	public void setKeySeries(String keySeries) {
		this.keySeries = keySeries;
	}

	public JSONArray getHxResourceMenuListJson() {
		return hxResourceMenuListJson;
	}

	public void setHxResourceMenuListJson(JSONArray hxResourceMenuListJson) {
		this.hxResourceMenuListJson = hxResourceMenuListJson;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getUserQq() {
		return userQq;
	}

	public void setUserQq(String userQq) {
		this.userQq = userQq;
	}

	public String getKaptcha() {
		return kaptcha;
	}

	public void setKaptcha(String kaptcha) {
		this.kaptcha = kaptcha;
	}

	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}

}
