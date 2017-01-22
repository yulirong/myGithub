/**
 * Copyright© 2003-2014 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author 徐建军
 * @date 2014-1-20
 * @version 1.0
 */
package com.icinfo.creditinfo.service.search;

import com.icinfo.creditinfo.lucence.common.NameResponse;

/**
 * 描述: 企业信息查询<br>
 * 
 * @author 徐建军
 * @date 2014-1-20
 */
public interface AppSearchService {
	/**
	 * 描述: 获取查询结果
	 *
	 * @author 朱勇
	 * @date 2015-10-19
	 * @throws Exception
	 */
	public NameResponse doGetAppConInfoResult(String sc,String searchType,String path,int pageSize,int currentPage,int resultSize) throws Exception;

	/**
	 * 描述: 创建索引
	 * 
	 * @author 徐建军
	 * @date 2014-1-20
	 * @param baseIndexPath 父目录
	 * @throws Exception
	 */
	public void doCreateIndex(String baseIndexPath) throws Exception;

}
