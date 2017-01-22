/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author mayawei
 * @date 2015-10-29
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.yccodeindustrytype;

import java.util.List;

import com.icinfo.creditinfo.bean.biz.yccodeindustrytype.YcCodeIndustryType;
import com.icinfo.creditinfo.service.biz.yccodeindustrytype.YcCodeIndustryTypeService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.pagination.Pagination;

/** 
 * 描述: 行业类型 Action 类<br>
 * @author mayawei
 * @date 2015-10-29
 */
public class YcCodeIndustryTypeAction extends HxBaseAction
{
	private static final long	serialVersionUID	= 1L;
	
	private YcCodeIndustryTypeService ycCodeIndustryTypeService;
	private YcCodeIndustryType ycCodeIndustryType;
	private String[] ycCodeIndustryTypeIds;
	//三大产业
	private String mainIndustries;
	/**
	 * 描述: 查看列表
	 * @auther mayawei
	 * @date 2015-10-29
	 * @return
	 * @throws Exception
	 */
	public String doReadYcCodeIndustryTypeListAction() throws Exception 
	{
		return Action.SUCCESS;
	}
	
	/**
	 * 描述: 分页查询信息
	 * @auther mayawei
	 * @date 2015-10-29
	 * @return
	 * @throws Exception
	 */
	public String doReadYcCodeIndustryTypeListJSONAction() throws Exception {
		this.addAjaxResults("pagination", new Pagination(ycCodeIndustryTypeService.doGetList(doGetRequestMap()), 
				ycCodeIndustryTypeService.doGetTotal(doGetRequestMap()),pagination.getCurrentPage(), pagination.getPageSize()));
		return AJAX;
	}
	
	/**
	 * 描述：按产业查询行业
	 * @author 马亚伟
	 * @date 2015-11-23
	 * @return
	 * @throws Exception
	 */
	public  String doGetCodeIndustryTypeListJsonByMainIndustryAction() throws Exception{

		List<YcCodeIndustryType> codeIndustryTypeList = ycCodeIndustryTypeService.doGetCodeIndustryTypeListJsonByMainIndustry(mainIndustries);
		this.addAjaxResults("codeIndustryTypeList", codeIndustryTypeList);
		return AJAX;
	}
	
	public YcCodeIndustryTypeService getYcCodeIndustryTypeService()
	{
		return ycCodeIndustryTypeService;
	}
	public void setYcCodeIndustryTypeService(YcCodeIndustryTypeService ycCodeIndustryTypeService)
	{
		this.ycCodeIndustryTypeService = ycCodeIndustryTypeService;
	}

	public YcCodeIndustryType getYcCodeIndustryType()
	{
		return ycCodeIndustryType;
	}

	public void setYcCodeIndustryType(YcCodeIndustryType ycCodeIndustryType)
	{
		this.ycCodeIndustryType = ycCodeIndustryType;
	}

	public String[] getYcCodeIndustryTypeIds()
	{
		return ycCodeIndustryTypeIds;
	}

	public void setYcCodeIndustryTypeIds(String[] ycCodeIndustryTypeIds)
	{
		this.ycCodeIndustryTypeIds = ycCodeIndustryTypeIds;
	}

	public String getMainIndustries() {
		return mainIndustries;
	}

	public void setMainIndustries(String mainIndustries) {
		this.mainIndustries = mainIndustries;
	}


	
}
