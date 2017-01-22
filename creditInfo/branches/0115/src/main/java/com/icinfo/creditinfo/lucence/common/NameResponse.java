/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 查重返回
 * @author 徐建军
 * @date 2013-9-27
 * @version 1.0
 */
package com.icinfo.creditinfo.lucence.common;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

/**
 * 描述: 查询数据返回
 * 
 * @author zhuyong
 * @date 2015-10-19
 */
public class NameResponse {

	// 总记录数
	private Integer totalCount;
	// 提示信息
	private String message;
	// 查询条件
	private String name;
	// 企业信息列表
	private List<AppConInfo> appConInfoList;
	
	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<AppConInfo> getAppConInfoList() {
		return appConInfoList;
	}

	public void setAppConInfoList(List<AppConInfo> appConInfoList) {
		this.appConInfoList = appConInfoList;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
