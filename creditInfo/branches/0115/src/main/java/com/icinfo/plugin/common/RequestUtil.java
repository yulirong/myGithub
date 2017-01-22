
package com.icinfo.plugin.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 描述：请求相关实用类
 * @version 1.1
 * @date 2013-07-25 刘明  加注释
 */
public class RequestUtil {

	/**
	 * 描述：通过请求得到请求参数
	 * @author 刘明
	 * @return 请求参数Map
	 */
	@SuppressWarnings("unchecked")
	public static Map<String, String> getAllParam(HttpServletRequest request) {
		return parseParameterMap(request.getParameterMap());
	}



	/**
	 * 描述:通过请求得到客户端IP
	 * @param request
	 * @return 客户端IP
	 */
	public static String getIpAddress(HttpServletRequest request)
	{
		if(request!=null)
		{
			String ipAddress = request.getHeader("X-Forwarded-For");
		    if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
		    	ipAddress = request.getHeader("Proxy-Client-IP");
		    }
		    if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
		    	ipAddress = request.getHeader("WL-Proxy-Client-IP");
		    }
		    if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
		    	ipAddress = request.getHeader("X-Real-IP");
		    }
		    if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {
		    	ipAddress = request.getRemoteAddr();
		    }
		    return ipAddress;
		}
		else
		{
			return "";
		}
	}
	
	/**
	 * 描述:通过请求得到客户端IP是不是内网
	 * @param request
	 * @return true 内网  false 外网
	 */
	public static boolean isIntranet(HttpServletRequest request)
	{
		String ipAddress = getIpAddress(request);
		if (ipAddress!=null && !ipAddress.equals("") && ( ipAddress.indexOf("10.")==0 || ipAddress.indexOf("192.")==0 || ipAddress.indexOf("172.")==0 ))
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	
	/**
	 * 描述：解析查询参数
	 * @author 刘明
	 * @param paramMap
	 * @return
	 */
	@SuppressWarnings({ "rawtypes" })
	private static Map<String, String> parseParameterMap(
			Map<String, String[]> paramMap) {
		Map<String, String> returnMap = new HashMap<String, String>();
		if (paramMap == null)
			paramMap = new HashMap<String, String[]>();
		for (Iterator it = paramMap.entrySet().iterator(); it.hasNext();) {
			Map.Entry entry = (Map.Entry) it.next();
			String key = (String) entry.getKey();
			String[] value = (String[]) entry.getValue();
			String newValue = "";
			if (value == null) {
				newValue = null;
			} else if (value.length == 0) {
				newValue = "";
			} else if (value.length == 1) {
				newValue = value[0];
			} else {
				for (int i = 0; i < value.length; i++) {
					if (i == 0)
						newValue += value[0];
					else
						newValue += "," + value[i];
				}
			}
			returnMap.put(key, newValue);
		}
		return returnMap;
	}

	/**
	 * 描述：解析cookie, 通过请求和cookie名得到Cookie对象
	 * @author 
	 * @param request
	 * @param cookieName
	 * @return
	 */
	public static Cookie parseCookie(HttpServletRequest request,
			String cookieName) {
		Cookie[] cookie = request.getCookies();
		for (int i = 0; cookie != null && i < cookie.length; i++) {
			if (cookie[i].getName().equals(cookieName))
				return cookie[i];
		}
		return null;
	}
	
	/**
	 * 提交请求
	 * @param strUrl 请求地址
	 * @param content 请求内容
	 * @param encode 编码
	 * @return XML字符串
	 */
	public static String postRequest(String strUrl, String content, String encode) 
	{
		HttpURLConnection urlCon = null;
		try
		{
			URL url = new URL(strUrl);
			urlCon = (HttpURLConnection) url.openConnection();

			urlCon.setRequestMethod("POST");
			urlCon.setRequestProperty("content-type", "text/html");
			urlCon.setDoOutput(true);

			urlCon.getOutputStream().write(content.getBytes(encode));
			urlCon.getOutputStream().flush();
			urlCon.getOutputStream().close();

			BufferedReader in = new BufferedReader(new InputStreamReader(urlCon	.getInputStream(), encode));
			String line;
			String respXML = "";
			while ((line = in.readLine()) != null)
			{
				respXML += line;
			}
			in.close();

			return respXML;
		}
		catch (Exception e)
		{
			e.printStackTrace();
			return null;
		}
		finally
		{
			if (urlCon != null)
			{
				urlCon.disconnect();
			}
		}
    }

}
