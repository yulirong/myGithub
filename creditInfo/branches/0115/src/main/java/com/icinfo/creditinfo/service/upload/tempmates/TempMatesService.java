/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-12-24
 * @version 1.0
 */
package com.icinfo.creditinfo.service.upload.tempmates;

import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.icinfo.creditinfo.bean.upload.tempmates.TempMates;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 民政局 Service 接口<br>
 * @author yulirong
 * @date 2015-12-24
 */
public interface TempMatesService extends HxBaseService<TempMates>{
	
	/**
     * 
     * 描述: 导入基本信息
     * @author yulirong
     * @date 2015年12月25日 
     * @param sheet
     * @return
     */
	public Map<String, Object> doBatchImportTempMatesInfo(HSSFSheet sheet,String depName,String depCode) throws Exception;
}
