package com.icinfo.creditinfo.action.sys.hxrole;

import com.icinfo.creditinfo.action.HxBaseAction;
import com.icinfo.plugin.hxpermission.bean.HxRole;
import com.icinfo.plugin.hxpermission.service.HxRoleResourceService;
import com.icinfo.plugin.hxpermission.service.HxRoleService;
import com.icinfo.plugin.pagination.Pagination;
import com.opensymphony.xwork2.Action;
/** 
 * 描述: 角色管理
 * 
 * @author zhuyong
 * @date 2015-09-28 
 */
public class HxRoleAction extends HxBaseAction{

	private static final long serialVersionUID = -9007727103095887672L;
	
	private HxRole hxRole;
	
	private HxRoleService hxRoleService;
	
    private HxRoleResourceService hxRoleResourceService;
    
  	private String [] hxRoleIdList;  //角色ID集
    
    
	/** 
	 * 描述: 获取角色列表
	 * 
	 * @author zhuyong
	 * @date 2015-09-28 
	 * @return
	 * @throws Exception 
	 */
	public String doReadHxRoleListJSONAction() throws Exception 
	{
		this.addAjaxResults("pagination", new Pagination(hxRoleService.doGetList(doGetRequestMap()), 
				hxRoleService.doGetTotal(doGetRequestMap()), pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}
	
	
	/** 
	 * 描述: 进入修改角色
	 * 
	 * @author zhuyong
	 * @date 2015-09-30 
	 * @return
	 * @throws Exception 
	 */
	public String doEnAddAndEditHxRoleAction() throws Exception 
	{
		if(hxRole!=null){
			hxRole = hxRoleService.doGetHxRoleWithRoleOwnerByRoleId(hxRole.getId());
		}
		else{
			hxRole = hxRoleService.doGetHxRoleWithRoleOwnerByRoleId(null);
		}
		return Action.SUCCESS;
	}
    
	
	/** 
	 * 描述: 添加、修改角色
	 * 
	 * @author zhuyong
	 * @date 2015-9-30 
	 * @return
	 * @throws Exception 
	 */
	public String doAddAndEditHxRoleAction() throws Exception
	{
		if(hxRole.getId()==null || hxRole.getId().equals("")){
			hxRole.setId(this.doGetGenerateId());
			hxRoleService.doSaveHxRole(hxRole);
		}
		else{
			hxRoleService.doModHxRole(hxRole);
		}
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	
	/** 
	 * 描述: 删除角色
	 * 
	 * @author zhuyong
	 * @date 2015-09-30 
	 * @return
	 * @throws Exception 
	 */
	public String doDelHxRoleAction() throws Exception
	{
		if(hxRole!=null && hxRole.getId()!=null){
			hxRoleService.doRmHxRole(hxRole.getId());
		}
		else{
		    hxRoleService.doRmHxRole(hxRoleIdList); 
		}
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	

	public String[] getHxRoleIdList() {
		return hxRoleIdList;
	}

	public void setHxRoleIdList(String[] hxRoleIdList) {
		this.hxRoleIdList = hxRoleIdList;
	}

	public HxRoleService getHxRoleService() {
		return hxRoleService;
	}

	public void setHxRoleService(HxRoleService hxRoleService) {
		this.hxRoleService = hxRoleService;
	}

	public HxRoleResourceService getHxRoleResourceService() {
		return hxRoleResourceService;
	}

	public void setHxRoleResourceService(HxRoleResourceService hxRoleResourceService) {
		this.hxRoleResourceService = hxRoleResourceService;
	}

	public HxRole getHxRole() {
		return hxRole;
	}

	public void setHxRole(HxRole hxRole) {
		this.hxRole = hxRole;
	}
    
    
    

}
