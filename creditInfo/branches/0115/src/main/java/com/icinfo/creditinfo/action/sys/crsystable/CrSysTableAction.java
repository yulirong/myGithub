/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-10-10
 * @version 1.0
 */
package com.icinfo.creditinfo.action.sys.crsystable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.icinfo.creditinfo.bean.sys.crsystable.CrSysTable;
import com.icinfo.creditinfo.service.sys.crsystable.CrSysTableService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;

/** 
 * 描述: 数据表菜单维护 Action 类<br>
 * @author zhuyong
 * @date 2015-10-10
 */
public class CrSysTableAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private CrSysTableService crSysTableService;
	private CrSysTable crSysTable;
	private String[] crSysTableIds;
	private List<CrSysTable> crSysTableList;
	private String checkedScopeCode;//选中的部门code集
	private String oper;//操作类型
	/**
	 * 描述: 查看列表
	 * @author zhuyong
	 * @date 2015-10-10
	 * @return
	 * @throws Exception
	 */
	public String doReadCrSysTableListAction() throws Exception 
	{
		crSysTableList = crSysTableService.doGetList(null);
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 分页查询信息
	 * @author zhuyong
	 * 
	 * @date 2015-10-10
	 * @return
	 * @throws Exception
	 */
	public String doReadCrSysTableListJSONAction() throws Exception {
		this.addAjaxResults("tableList", crSysTableService.doGetList(doGetRequestMap()));
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	/**
	 * 描述: 进入增加(修改)页面
	 * @author zhuyong
	 * @date 2015-10-10
	 * @return
	 * @throws Exception
	 */
	public String doEnAddAndEditCrSysTableAction() throws Exception {
		if(crSysTable!=null && crSysTable.getId()!=null){
			crSysTable =  crSysTableService.doGetById(crSysTable.getId());
		}
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 增加(修改)信息
	 * @author zhuyong
	 * @date 2015-10-10
	 * @return
	 * @throws Exception
	 */
	public String doAddAndEditCrSysTableAction() throws Exception {
		this.addAjaxResults("success", "true");
		this.addAjaxResults("nowcrSysTable", crSysTable);
		if(crSysTable!=null && crSysTable.getId()!=null && !crSysTable.getId().equals("")){
			if(crSysTable.getTabSupCode()==null || crSysTable.getTabSupCode().equals("")){
				crSysTable.setTabSupCode("0");
			}
		    crSysTableService.doMod(crSysTable);
		}
		else{
			if(crSysTable.getTabSupCode()==null || crSysTable.getTabSupCode().equals("")){
				crSysTable.setTabSupCode("0");
			}
			Map<String,Object> qryMap = new HashMap<String, Object>();
			qryMap.put("tabCode", crSysTable.getTabCode());
			if(crSysTableService.doGetTotal(qryMap) > 0){
				this.addAjaxResults("success", "false");
			}else{
				String id = crSysTableService.doSave(crSysTable);
				crSysTable.setId(id);
			}
			
		}
		return AJAX;
	}

	/**
	 * 描述: 批量删除
	 * @author zhuyong
	 * @date 2015-10-10
	 * @return
	 * @throws Exception
	 */
	public String doDelCrSysTableAction() throws Exception{
		crSysTableService.doRmBatch(crSysTableIds);
		this.addAjaxResults("success", "true");
		return AJAX;
	}
	
	/**
	 * 描述：进入数据查询范围页面
	 * 
	 * @author zhuyong
	 * @date 2015-10-12
	 * @return
	 * @throws Exception
	 */
	public String doGetScopeTreeAction() throws Exception{
		List<CrSysTable> scopeList = crSysTableService.doGetList(doGetRequestMap());
		this.addAjaxResults("scopeTreeJSON", assemblyList(scopeList));
		this.addAjaxResults("success", "true");
        return AJAX;
	}
	
	/**
	 * 描述：比较部门是否被选中
	 * 
	 * @author zhuyong
	 * @date 2015-10-12
	 * @param scopeList
	 * @return
	 * @throws Exception
	 */
	private List<CrSysTable> assemblyList(List<CrSysTable> scopeList) throws Exception{
		if(StringUtils.isBlank(checkedScopeCode)){
			return scopeList;
		}
		if(scopeList==null||scopeList.size()==0){
			return scopeList;
		}
		List<CrSysTable> newScopeList = new ArrayList<CrSysTable>();
		String[] codeArr = checkedScopeCode.split("_");
		for (CrSysTable c : scopeList) {
			c.setChecked("false");
			if(Arrays.asList(codeArr).contains(c.getTabCode())){
				c.setChecked("true");
			}
			newScopeList.add(c);
		}
		return newScopeList;
	}
	
	
	 /**
	  * 描述: 校验数据表编码是否唯一
	  * @auther yulirong
	  * @date 2015-10-10
	  * @return
	  * @throws Exception
	  */
	 public Boolean doCheckCrSysTable() throws Exception{
	  crSysTableList = crSysTableService.doGetList(null);
	  for(CrSysTable list:crSysTableList){
	   if(list.getTabCode().equals(crSysTable.getTabCode())){
		   return false;
	   }
	  }
	  return true;
	 }
	
	public CrSysTableService getCrSysTableService()
	{
		return crSysTableService;
	}
	public void setCrSysTableService(CrSysTableService crSysTableService)
	{
		this.crSysTableService = crSysTableService;
	}

	public CrSysTable getCrSysTable()
	{
		return crSysTable;
	}

	public void setCrSysTable(CrSysTable crSysTable)
	{
		this.crSysTable = crSysTable;
	}

	public String[] getCrSysTableIds()
	{
		return crSysTableIds;
	}

	public void setCrSysTableIds(String[] crSysTableIds)
	{
		this.crSysTableIds = crSysTableIds;
	}

	public List<CrSysTable> getCrSysTableList() {
		return crSysTableList;
	}

	public void setCrSysTableList(List<CrSysTable> crSysTableList) {
		this.crSysTableList = crSysTableList;
	}

	public String getOper() {
		return oper;
	}

	public void setOper(String oper) {
		this.oper = oper;
	}

	public String getCheckedScopeCode() {
		return checkedScopeCode;
	}

	public void setCheckedScopeCode(String checkedScopeCode) {
		this.checkedScopeCode = checkedScopeCode;
	}

}
