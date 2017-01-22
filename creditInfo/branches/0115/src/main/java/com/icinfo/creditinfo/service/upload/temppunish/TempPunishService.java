/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-10
 * @version 1.0
 */
package com.icinfo.creditinfo.service.upload.temppunish;

import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;

import com.icinfo.creditinfo.bean.upload.temppunish.TempPunish;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 行政处罚 Service 接口<br>
 * @author gaotong
 * @date 2015-11-10
 */
public interface TempPunishService extends HxBaseService<TempPunish>{
	/**
	 * 描述：导入TempPunish
	 * 
	 * @author gaotong
	 * @param sheet
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> doBatchImportTempPunishInfo(Sheet sheet,String deptName,String deptCode) throws Exception;
}
