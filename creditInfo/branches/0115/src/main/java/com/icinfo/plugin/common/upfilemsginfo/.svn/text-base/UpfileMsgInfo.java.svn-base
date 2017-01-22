package com.icinfo.plugin.common.upfilemsginfo;

import java.util.HashMap;
import java.util.Map;

public class UpfileMsgInfo {

	/**
	 * 描述：上传Excel文件提示信息
	 * @author 马亚伟
	 * @date 2015-11-12
	 * @param paramTotal 上传条数
	 * @param paramState 上传状态  成功 ：true 或者 失败： false
	 * @return Map<String,Object>
	 */
	public static Map<String,Object> sucMsgInfo (int paramTotal,boolean paramState){
		Map<String,Object> sucMsgInfoMap =  new HashMap<String, Object>();
		sucMsgInfoMap.put("total", paramTotal+"");
		if(paramState){
			sucMsgInfoMap.put("state", "1");//1 表示成功
			sucMsgInfoMap.put("msgInfo", "");
		}else{
			sucMsgInfoMap.put("state", "0");//0表示失败
			sucMsgInfoMap.put("msgInfo", "导入失败！");
		} 
		sucMsgInfoMap.put("entName", "");
		sucMsgInfoMap.put("posRowNum", "");
		
		return sucMsgInfoMap;
	}
	
	/**
	 * 描述：Excel内容重复或格式错误的提示信息
	 * @author 马亚伟
	 * @date 2015-11-12
	 * @param paramPosRowNum 出错的行号
	 * @param paramMsgInfo 错误信息："重复内容" 或 "xxx格式错误"
	 * @param paramEntName 企业名称
	 * @return
	 */
	public static Map<String,Object> errMsgInfo (int paramPosRowNum,String paramMsgInfo,String paramEntName){
		Map<String,Object> errMsgInfoMap =  new HashMap<String, Object>();
		errMsgInfoMap.put("posRowNum", paramPosRowNum+"");
		errMsgInfoMap.put("msgInfo", paramMsgInfo);
		if(paramEntName!=null){
			errMsgInfoMap.put("entName", paramEntName);
		}else{
			errMsgInfoMap.put("entName", "");
		}
		errMsgInfoMap.put("state", "0");//0 表示失败
		errMsgInfoMap.put("total", "0");
		return errMsgInfoMap;
	}


	
	 
}
