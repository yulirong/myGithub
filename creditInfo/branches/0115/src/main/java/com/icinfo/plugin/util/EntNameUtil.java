package com.icinfo.plugin.util;

import org.apache.commons.lang3.StringUtils;

public class EntNameUtil {
	
	/**
	 * 描述：获取企业名称的短名称
	 *
	 * @author zhuyong
	 * @date 2015-11-20
	 * @param entName
	 * @return
	 * @throws Exception
	 */
	public static String getShortName(String entName) throws Exception{
		if(StringUtils.isBlank(entName)){
			return "";
		}
		if(entName.equals("有限售条件流通股")||entName.equals("无限售条件流通股")){
			return entName;
		}
		entName = entName.replace("浙江", "").replace("绍兴市", "").
				replace("绍兴", "").replace("上虞市", "").replace("上虞区", "").replace("上虞", "").
				replace("有限责任公司", "").replace("有限公司", "").replace("公司", "").replace("专业合作社", "");
//		if(entName.length()>4){
//			entName = entName.substring(0,4);
//		}
		return entName;

	}
	

}
