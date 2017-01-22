package com.icinfo.creditinfo.action.sys.hxresource;

import java.util.List;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.icinfo.plugin.hxpermission.bean.HxResource;
import com.icinfo.plugin.hxpermission.service.HxResourceService;
import com.opensymphony.xwork2.Action;

/** 
 * 描述: 系统资源管理
 * 
 * @author zhuyong
 * @date 2015-09-28 
 */
public class HxResourceAction extends HxBaseAction {

	private static final long serialVersionUID = -3852672233954296972L;
	
	private List<HxResource> hxResourceList; 
	
	private HxResource hxResource;
	
	private HxResourceService hxResourceService;
	
	private String oper;//操作类型
	
	private String [] hxResourceIds;//资源ID集

	/** 
	 * 描述: 进入资源页面
	 * 
	 * @author zhuyong
	 * @date 2015-09-28 
	 * @return
	 * @throws Exception 
	 */
	public String doReadHxResourceListAction() throws Exception 
	{
		hxResourceList = hxResourceService.doGetList(null);
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 进入资源修改（增加）页面
	 * 
	 * @author zhuyong
	 * @date 2015-09-29 
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditHxResourceAction() throws Exception {
		if(oper.equals("add")){
			return Action.SUCCESS;
		}
		hxResource =  hxResourceService.doGetById(hxResource.getId());
		return Action.SUCCESS;
	}
	
	/** 
	 * 描述: 修改（增加）资源
	 * 
	 * @author zhuyong
	 * @date 2015-09-30
	 * @return
	 * @throws Exception 
	 */
	public String doAddAndEditHxResourceAction() throws Exception {
		if(hxResource!=null && hxResource.getId()!=null && !hxResource.getId().equals("")){
			if(hxResource.getResOrderNum()==null || hxResource.getResOrderNum().equals("")){
				hxResource.setResOrderNum("0");
			}
		    hxResourceService.doMod(hxResource);
		}
		else{
			if(hxResource.getResOrderNum()==null || hxResource.getResOrderNum().equals("")){
				hxResource.setResOrderNum("0");
			}
			String id = hxResourceService.doSave(hxResource);
			hxResource.setId(id);
		}
		this.addAjaxResults("success", "true");
		this.addAjaxResults("nowResource", hxResource);
		return AJAX;
	}
	
	/** 
	 * 描述: 删除资源信息
	 * 
	 * @author zhuyong
	 * @date 2015-9-30 
	 * @return
	 * @throws Exception 
	 */
	public String doDelHxResourceAction() throws Exception{
		hxResourceService.doRmHxResource(hxResourceIds);
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	
	public HxResourceService getHxResourceService() {
		return hxResourceService;
	}
	public void setHxResourceService(HxResourceService hxResourceService) {
		this.hxResourceService = hxResourceService;
	}

	public List<HxResource> getHxResourceList() {
		return hxResourceList;
	}
	public void setHxResourceList(List<HxResource> hxResourceList) {
		this.hxResourceList = hxResourceList;
	}

	public HxResource getHxResource() {
		return hxResource;
	}

	public void setHxResource(HxResource hxResource) {
		this.hxResource = hxResource;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public String[] getHxResourceIds() {
		return hxResourceIds;
	}

	public void setHxResourceIds(String[] hxResourceIds) {
		this.hxResourceIds = hxResourceIds;
	}
	
	

}
