package com.icinfo.plugin.common;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;


/**
 * 描述：字符串实用类
 * 
 * @author 刘明
 * @date 2013-07-30 
 */
public class StringUtil {
	
	/**
	 * 描述: 将","分割的字符串转成数组形式
	 * 
	 * @author 刘明
	 * @date 2013-5-31
	 * @param strQuesId ","分割的字符串
	 * @return 数组
	 */
	public static String[] strToArray(String strQuesId) {
		String[] arrIntQuesId = null;
		if (strQuesId != null && !strQuesId.equals("")) {
			String arrQuesId[] = strQuesId.split(",");
			int intQuesIdLength = arrQuesId.length;

			arrIntQuesId = new String[intQuesIdLength];
			for (int i = 0; i < intQuesIdLength; i++) {
				arrIntQuesId[i] = arrQuesId[i];
			}
		}
		return arrIntQuesId;
	}
	public static String nullToEmpty(String str){
		if(str ==null) 
			return "";
		return str;
	}
	
	/**
     * 
     * 描述：替换指定长度的字符串
     * @author 金李祥
     * @date  2014-5-16
     */
    public static String replacePartString(String sourceStr,String replaceStr,int startindex,int endindex){
    	StringBuffer sb = new StringBuffer();
    	StringBuffer sb2 = new StringBuffer(sourceStr);
    	for(int i=startindex;i<endindex;i++){
    		sb.append(replaceStr);
    	}
    	sb2.replace(startindex, endindex, sb.toString());
    	return sb2.toString();
    }
    
    /**
	 * 描述：将字符串转成list
	 * 作用：组装成sql查询参数
	 * 
	 * @author 朱勇
	 * @date 2015-4-15
	 * @return
	 */
	public static List<String> strSplitAddToList(String paramStr){
		if(StringUtils.isBlank(paramStr)){return null;}
		List<String> list = new ArrayList<String>();
		String[] strs = paramStr.split(",");
		for (String s : strs) {
			list.add(s);
		}
		return list;
	}
}