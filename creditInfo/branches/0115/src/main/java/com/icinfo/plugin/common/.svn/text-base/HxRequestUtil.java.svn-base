package com.icinfo.plugin.common;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;

/**
 * 描述: Request 工具类
 * @author 胡义振
 * @date 2014-10-13
 */
public class HxRequestUtil {
 
	/**
	 * 描述: 获取 request 中所有参数
	 * @auther 胡义振
	 * @date 2014-10-14 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static Map<String, String> getAllParam(HttpServletRequest request) {
		Map<String,String> tempMap = new HashMap<String,String>();
		Enumeration enuParam = request.getParameterNames();  
		while(enuParam.hasMoreElements()){  
			String paramName = (String) enuParam.nextElement();
			String [] arrParamValue = request.getParameterValues(paramName);
			String paramValue = HxStringUtil.arrayToString(arrParamValue, ",");
			// 过滤掉空值
			if(paramValue!=null && paramValue.length()>0){
			    tempMap.put(paramName, paramValue);
			}
		}  
		return tempMap;
	}
	
	/**
	 * 描述: 过滤  request 中特殊字符
	 * @auther 胡义振
	 * @date 2014-5-16 
	 * @param request
	 * @return
	 */
	@SuppressWarnings("rawtypes")
	public static HttpServletRequest filterSpecialCharacter(HttpServletRequest request)
	{
		Enumeration enuParam = request.getParameterNames(); 
		// 循环读取参数
		while(enuParam.hasMoreElements())
		{
			String paramValue = "";
			String paramName = (String) enuParam.nextElement();
			String[] arrParamValue = request.getParameterValues(paramName);
			for (String tempValue : arrParamValue)
			{
				if(paramValue.equals("")){
					paramValue = HxStringUtil.strToHtml(tempValue) ;
				}
				else{
				    paramValue = paramValue + ", " + HxStringUtil.strToHtml(tempValue) ;
				}
			}
			request.setAttribute(HxStringUtil.strToHtml(paramName), paramValue);
		}
		return request;
	}
	
	
	/**
	 * 描述: 通过 request 对象获取IP地址
	 * @auther 胡义振
	 * @date 2014-10-13 
	 * @param request
	 * @return
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
	 * 描述: 从 request 中获取 cookie 值
	 * @auther 胡义振
	 * @date 2014-10-13 
	 * @param request
	 * @param cookieName
	 * @return
	 */
	public static Cookie getCookieValue(HttpServletRequest request,String cookieName) {
		Cookie[] cookie = request.getCookies();
		for (int i = 0; cookie != null && i < cookie.length; i++) {
			if (cookie[i].getName().equals(cookieName))
				return cookie[i];
		}
		return null;
	}
	

	/**
	 * 描述: 从 request 中获取字符串信息
	 * @auther 胡义振
	 * @date 2014-10-13
	 * @param request
	 * @param encode
	 * @return
	 */
	public static String getStringFromStream(HttpServletRequest request,String encode) {
		String requestXML = "";
		try
		{
			InputStream inputStream = request.getInputStream();
			if(inputStream!=null){
				InputStreamReader inStreamRead = new InputStreamReader(inputStream,encode);
				BufferedReader buffRead = new BufferedReader(inStreamRead);
				String line;
				while((line = buffRead.readLine()) != null)
				{
					requestXML += line;
				}
			}
		}
		catch(Exception er){
			er.printStackTrace();
		}
		return requestXML;
	}
	
	
	

	/**
	 * 描述: POST 流提交,解析返回的ZLib压缩的二进制流
	 * @auther 胡义振
	 * @date 2014-10-13 
	 * @param strUrl  请求地址
	 * @param content 请求内容
	 * @param encode  编码
	 * @return
	 */
	public static String postStreamForZLib(String strUrl, String content, String encode) 
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

			ByteArrayOutputStream byteStream = new ByteArrayOutputStream(); 
			int read = -1; 
	        while((read = urlCon.getInputStream().read())!=-1){
	        	byteStream.write(read); 
	        } 
	        byte bXml [] = byteStream.toByteArray();
	        String respXML = new String(HxStringUtil.ZLibUnCompress(bXml));
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
		

	/**
	 * 描述: POST 参数提交
	 * @auther 胡义振
	 * @date 2014-10-13 
	 * @param strUrl  请求地址
	 * @param requestMap 请求参数
	 * @param encode  编码
	 * @return
	 */
	public static String postParam(String strUrl, Map<String,String> requestMap,String encode)
	{
		PrintWriter out = null;
		BufferedReader in = null;
		StringBuffer result = new StringBuffer();
		try
		{
			URL url = new URL(strUrl);
			HttpURLConnection urlCon = (HttpURLConnection)url.openConnection();
			// 设置通用的请求属性
			urlCon.setRequestMethod("POST");
			urlCon.setRequestProperty("accept", "*/*");
			urlCon.setDoOutput(true);
			out = new PrintWriter(urlCon.getOutputStream());
			out.print(HxStringUtil.maptToUrlParam(requestMap,encode));
			out.flush();
			
			// 定义BufferedReader输入流来读取URL的响应
			in = new BufferedReader(new InputStreamReader(urlCon.getInputStream(),encode));
			String line = "";
			while ((line = in.readLine()) != null)
			{
				result.append(line);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			try
			{
				if (out != null)
				{
					out.close();
					out = null;
				}
				if (in != null)
				{
					in.close();
					in = null;
				}
			}
			catch (Exception ex)
			{

			}
		}
		return result.toString();
	}
	
	/**
	 * 描述: POST 流提交
	 * @auther 胡义振
	 * @date 2014-10-13 
	 * @param strUrl  请求地址
	 * @param content 请求内容
	 * @param encode  编码
	 * @return
	 */
	public static String postStream(String strUrl, String content, String encode) 
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
	        
			BufferedReader in = new BufferedReader(new InputStreamReader(urlCon.getInputStream(), encode));

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
