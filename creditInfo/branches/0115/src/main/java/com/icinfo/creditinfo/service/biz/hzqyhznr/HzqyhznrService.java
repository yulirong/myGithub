/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gqf
 * @date 2015-10-14
 * @version 1.0
 */
package com.icinfo.creditinfo.service.biz.hzqyhznr;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.hzqyhznr.Hzqyhznr;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

/**
 * 描述: 异常名录 Service 接口<br>
 * @author gqf
 * @date 2015-10-14
 */
public interface HzqyhznrService extends HxBaseService<Hzqyhznr>{
	
 /** 
 * 描述:sub
 * @auther gqf
 * @date 2015年10月14日 
 * @return
 * @throws Exception 
 */

public List<Hzqyhznr> doGetSubHzqyhznrList(Map<String,Object> qryMap) throws Exception;
}
