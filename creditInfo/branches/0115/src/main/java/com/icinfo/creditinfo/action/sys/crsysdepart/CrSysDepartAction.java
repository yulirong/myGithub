/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-10-10
 * @version 1.0
 */
package com.icinfo.creditinfo.action.sys.crsysdepart;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icinfo.creditinfo.bean.sys.crsysdepart.CrSysDepart;
import com.icinfo.creditinfo.service.sys.crsysdepart.CrSysDepartService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;

/** 
 * 描述: 部门管理 Action 类<br>
 * @author zhuyong
 * @date 2015-10-10
 */
public class CrSysDepartAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrSysDepartService crSysDepartService;

	private CrSysDepart crSysDepart;
	private String[] crSysDepartIds;
	private List<CrSysDepart> crSysDepartList;
	private String oper;
	private String ptype;//大类
	private String checkedDepartCode;//选中的部门code集

	/**
	 * 描述: 查看列表
	 * @author zhuyong
	 * @date 2015-10-10
	 * @return
	 * @throws Exception
	 */
	public String doReadCrSysDepartListAction() throws Exception 
	{
		crSysDepartList = crSysDepartService.doGetList(null);
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 分页查询信息
	 * 
	 * @author zhuyong
	 * @date 2015-10-10
	 * @return
	 * @throws Exception
	 */
	public String doReadCrSysDepartListJSONAction() throws Exception {
		this.addAjaxResults("departmentList", crSysDepartService.doGetList(doGetRequestMap()));
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	/**
	 * 描述: 进入增加(修改)页面
	 * 
	 * @author zhuyong
	 * @date 2015-10-10
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditCrSysDepartAction() throws Exception {
		if(oper.equals("add")){
			return Action.SUCCESS;
		}
		crSysDepart =  crSysDepartService.doGetById(crSysDepart.getId());
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 增加(修改)信息
	 * @author zhuyong
	 * @date 2015-10-10
	 * @return
	 * @throws Exception
	 */
	public String doAddAndEditCrSysDepartAction() throws Exception {
		if(crSysDepart!=null && crSysDepart.getId()!=null && !crSysDepart.getId().equals("")){
			crSysDepartService.doMod(crSysDepart);
		}else{
			Map<String,Object> qryMap = new HashMap<String, Object>();
			qryMap.put("depCode", crSysDepart.getDepCode());
			if(crSysDepartService.doGetTotal(qryMap)>0){
				this.addAjaxResults("success", "codeIsExist");
				return AJAX;
			}
			crSysDepart.setDepSetDate(new Date());
			crSysDepart.setDepSetName(doGetSysUser().getLoginName());
			String id = crSysDepartService.doSave(crSysDepart);
			crSysDepart.setId(id);
		}
		this.addAjaxResults("success", "true");
		this.addAjaxResults("nowResource", crSysDepart);
		return AJAX;
	}

	/**
	 * 描述: 批量删除
	 * @author zhuyong
	 * @date 2015-10-10
	 * @return
	 * @throws Exception
	 */
	public String doDelCrSysDepartAction() throws Exception{
		crSysDepartService.doRmBatch(crSysDepartIds);
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	/**
	 * 描述：进入部门数据范围页面
	 * 
	 * @author yulirong
	 * @date 2016-1-14
	 * @return
	 * @throws Exception
	 */
	public String doGetCrSysDepartTreeAction() throws Exception{
		List<CrSysDepart> departList = crSysDepartService.doGetList(doGetRequestMap());
		this.addAjaxResults("departTreeJSON", assemblyList(departList));
		this.addAjaxResults("success", "true");
        return AJAX;
	}
	
	/**
	 * 描述：比较部门是否被选中
	 * 
	 * @author yulirong
	 * @date 2016-1-14
	 * @param scopeList
	 * @return
	 * @throws Exception
	 */
	private List<CrSysDepart> assemblyList(List<CrSysDepart> departList) throws Exception{
		if(StringUtils.isBlank(checkedDepartCode)){
			return departList;
		}
		if(departList==null||departList.size()==0){
			return departList;
		}
		List<CrSysDepart> newdepartList = new ArrayList<CrSysDepart>();
		String[] codeArr = checkedDepartCode.split("_");
		for (CrSysDepart c : departList) {
			c.setChecked("false");
			if(Arrays.asList(codeArr).contains(c.getDepCode())){
				c.setChecked("true");
			}
			newdepartList.add(c);
		}
		return newdepartList;
	}
	
	public CrSysDepartService getCrSysDepartService()
	{
		return crSysDepartService;
	}
	public void setCrSysDepartService(CrSysDepartService crSysDepartService)
	{
		this.crSysDepartService = crSysDepartService;
	}

	public CrSysDepart getCrSysDepart()
	{
		return crSysDepart;
	}

	public void setCrSysDepart(CrSysDepart crSysDepart)
	{
		this.crSysDepart = crSysDepart;
	}

	public String[] getCrSysDepartIds()
	{
		return crSysDepartIds;
	}

	public void setCrSysDepartIds(String[] crSysDepartIds)
	{
		this.crSysDepartIds = crSysDepartIds;
	}

	public List<CrSysDepart> getCrSysDepartList() {
		return crSysDepartList;
	}

	public void setCrSysDepartList(List<CrSysDepart> crSysDepartList) {
		this.crSysDepartList = crSysDepartList;
	}

	public String getOper() {
		return oper;
	}
	public void setOper(String oper) {
		this.oper = oper;
	}

	public String getPtype() {
		return ptype;
	}

	public void setPtype(String ptype) {
		this.ptype = ptype;
	}

	public String getCheckedDepartCode() {
		return checkedDepartCode;
	}

	public void setCheckedDepartCode(String checkedDepartCode) {
		this.checkedDepartCode = checkedDepartCode;
	}

	

}
