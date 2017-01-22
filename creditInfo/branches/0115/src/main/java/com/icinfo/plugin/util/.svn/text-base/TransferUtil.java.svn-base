package com.icinfo.plugin.util;

import org.apache.commons.lang.StringUtils;

public class TransferUtil {
	
	 /** 
	 * 描述: 字符按照规则转换
	 * @auther gqf
	 * @date 2016年1月12日 
	 * @param string
	 * @param pattern
	 * @return 
	 */
	
	public static String doSplitStringToSqlFormat(String string, String pattern) {
	    	if(StringUtils.isBlank(string)) return "";
	        StringBuilder result = new StringBuilder("");
	        String arr[] = string.split(pattern);
	        if (arr.length > 0) {
	            for (int i = 0; i < arr.length; i++) {
	                if ("".equals(result.toString())) {
	                    result.append("'");
	                    result.append(arr[i]);
	                    result.append("'");
	                } else {
	                    result.append(",");
	                    result.append("'");
	                    result.append(arr[i]);
	                    result.append("'");
	                }
	            }
	        } else {
	            result.append(string);
	        }
	        return result.toString();
	    }

}
