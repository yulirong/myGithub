/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-11
 * @version 1.0
 */
package com.icinfo.creditinfo.service.upload.tempsocialsecurity;

import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFSheet;

import com.icinfo.creditinfo.bean.upload.tempsocialsecurity.TempSocialSecurity;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 社保信息 Service 接口<br>
 * @author liyafeng
 * @date 2015-11-11
 */
public interface TempSocialSecurityService extends HxBaseService<TempSocialSecurity>{
	
    /**
     * 
     * 描述:导入社保信息
     * @author LiYaFeng
     * @date 2015年11月11日 
     * @param sheet
     * @return
     * @throws Exception
     */
	public Map<String, Object> doBatchImportTempSocialSecurityInfo(HSSFSheet sheet,String deptName,String depCode) throws Exception;
	

}
