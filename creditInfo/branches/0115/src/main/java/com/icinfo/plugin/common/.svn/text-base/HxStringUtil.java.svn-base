package com.icinfo.plugin.common;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.Deflater;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.Inflater;

import org.apache.commons.lang3.StringUtils;

/**
 * 描述: 汇信字符串工具类
 * @author 胡义振
 * @date 2014-10-14
 */
public class HxStringUtil {

	/**
	 * 描述: 数组转成字符串
	 * @auther 胡义振
	 * @date 2014-10-14 
	 * @param arrObject 数组对象
	 * @param separator 分隔符
	 * @return
	 */
	public static String arrayToString(Object [] arrObject,String separator) {
		
		// 默认为","号
		if(separator==null || separator.equals("")) separator = "," ;
		
		String returnStrValue = "";
		
		if(arrObject!=null){
			for(Object object:  arrObject){
				if(returnStrValue.equals("")){
					returnStrValue = String.valueOf(object);
				}
				else{
					returnStrValue = returnStrValue + separator + String.valueOf(object);
				}
			}
		}
		return returnStrValue;
	}

	/**
	 * 描述: 可变参数转为一个字符串
	 * @auther 胡义振
	 * @date 2014-10-22 
	 * @param strParam 可变String参数
	 * @return
	 */
	public static String assemblyString(String...strParam){
		StringBuffer stringBuffer = new StringBuffer();
		for(String string : strParam){
			stringBuffer.append(string);
		}
		return stringBuffer.toString();
	}

	/** 
	 * 描述: 处理字符前后的空的问题
	 * @auther gqf
	 * @date 2015年5月18日 
	 * @param strParam
	 * @return 
	 */
	
	public static String StringTrim(String strParam){
		if("".equals(strParam)||null == strParam) return "";
		return strParam.trim();
	}
	
	/**
	 * 描述: 字符串转为数组
	 * @auther 胡义振
	 * @date 2014-10-14 
	 * @param paramStr 字符串
	 * @param separator 分割符
	 * @return
	 */
	public static String[] strToArray(String paramStr,String separator) {
		String arrTempStr[] = null;
		if (paramStr != null && !paramStr.equals("")) {
			String arrStr [] = paramStr.split(separator);
			int arrStrLength = arrStr.length;
			arrTempStr = new String[arrStrLength];
			for (int i = 0; i < arrStrLength; i++) {
				arrTempStr[i] = arrStr[i];
			}
		}
		return arrTempStr;
	}
	
	/**
	 * 描述: 把Map转成参数
	 * @param paramMap map类型数据
	 * @param encode 编码
	 * @auther 胡义振
	 * @date 2013-8-8 
	 * @return URL参数
	 */
	public static String maptToUrlParam(Map<String,String> paramMap,String encode) throws Exception{
		String params = "";
		String tempKey;
		String tempValue;
		Set<String> paramKey = paramMap.keySet();
		Iterator<String> it = paramKey.iterator();
		while(it.hasNext()){
			tempKey = it.next();
			tempValue = paramMap.get(tempKey)!=null ? URLEncoder.encode(paramMap.get(tempKey),encode) : "";
			if(params.equals("")){
				params = tempKey + "=" + tempValue;
			}
			else{
				params = params + "&" + tempKey + "=" + tempValue;
			}
		}
		return params;
	}
	
	/**
	 * 描述: 根据分割符把Map转成String格式。如：key1=value1,key2=valu2  "," 为分割符
	 * @param paramMap map类型数据
	 * @param separator 分割符
	 * @auther 胡义振
	 * @date 2013-8-8 
	 * @return URL参数
	 */
	public static String maptToString(Map<String,String> paramMap,String separator) throws Exception{
		String params = "";
		String tempKey;
		String tempValue;
		Set<String> paramKey = paramMap.keySet();
		Iterator<String> it = paramKey.iterator();
		while(it.hasNext()){
			tempKey = it.next();
			tempValue = paramMap.get(tempKey)!=null ? paramMap.get(tempKey): "";
			if(params.equals("")){
				params = tempKey + "=" + tempValue;
			}
			else{
				params = params + separator + tempKey + "=" + tempValue;
			}
		}
		return params;
	}
	
	/**
	 * 描述: 把Url参数转成Map
	 * @param urlParam URL 参数
	 * @param encode 编码
	 * @auther 胡义振
	 * @date 2013-8-8 
	 * @return UrlMap
	 */
	public static Map<String,String> urlParamToMap(String urlParam) {
		Map<String,String> urlParamMap = new HashMap<String,String>();
		if(urlParam!=null)
		{
			try
			{
				String [] arrParam = urlParam.split("&");
				for(int i=0;i<arrParam.length;i++){
					String [] keyValue = arrParam[i].split("=");
					urlParamMap.put(keyValue[0], keyValue[1]);
				}
			}
			catch(Exception er){
				er.printStackTrace();
			}
		}
		return urlParamMap;
	}
	
	/**
	 * 判断一个字符是Ascill字符还是其它字符（如汉，日，韩文字符）
	 * @param c 字符
	 */
	public static boolean isLetter(char c)
	{
		int k = 0x80;
		return c / k == 0 ? true : false;
	}

	/**
	 * 得到一个字符串的长度,显示的长度,一个汉字或日韩文长度为2,英文字符长度为1
	 * 
	 * @param s 字符串
	 * @return
	 */
	public static int getStringLength(String s)
	{
		if (s == null)
			return 0;
		char[] c = s.toCharArray();
		int len = 0;
		for (int i = 0; i < c.length; i++)
		{
			len++;
			if (!isLetter(c[i]))
			{
				len++;
			}
		}
		return len; 
	}
	
	/**
	 * 根据长度截取字符串
	 * 
	 * @param origin 字符串
	 * @param len 截取长度
	 * @return
	 */
	public static String substring(String origin, int len)
	{
		if (origin == null) return "";
		int n = 0;
		String result = "";
		origin = origin.replaceAll("&nbsp;", " ");
		origin = trimStartAndEnd(origin);
		for (int i = 0; i < origin.length(); i++)
		{
			if (origin.charAt(i) > 255)
			{
				n += 2;
			}
			else
			{
				n++;
			}
			if (n > len)
			{
				return result;
			}
			result += origin.charAt(i);
		}
		return result;
	}
	

	/**
	 * 描述: 去掉前后空格
	 * @auther 胡义振
	 * @date 2014-2-15 
	 * @param str
	 * @return
	 */
	public static String trimStartAndEnd(String str){
		if(str==null){
			return "";
		}
		str = str.trim();
	    while(str.startsWith("　")){
	    	str = str.substring(1,str.length()).trim();
	    }
	    while(str.endsWith("　")){
	    	str = str.substring(0,str.length()-1).trim();
	    }
	    return str;
	}
	/**
	 * 截段取字符串（如：str = "25,26,28,29" 段取 26 后得 str = "25,28,29" ）
	 * 
	 * @param allStr
	 * @param str
	 * @return
	 */
	public static String subPartString(String allStr, String cutStr)
	{
		try
		{
			String astr[] = allStr.split(",");
			String newStr = "";
			for (int i = 0; i < astr.length; i++)
			{
				if (astr[i].equals(cutStr))
				{
					astr[i] = "";
				}
			}

			for (int i = 0; i < astr.length; i++)
			{
				if (astr[i].equals(""))
				{
					astr[i] = "";
				}
				else
				{
					if (newStr.equals(""))
					{
						newStr = astr[i];
					}
					else
					{
						newStr = newStr + "," + astr[i];
					}
				}
			}
			return newStr;
		}
		catch (Exception er)
		{
			return "";
		}
	}

	/**
	 * 检查字符串是否存在（如：allStr = "25,26,28,29"， ）
	 * 
	 * @param allStr 所有字符串
	 * @param checkedStr 检测的字符串
	 * @return
	 */
	public static boolean checkIncludeString(String allStr, String checkedStr)
	{
		try
		{
			if(allStr==null || allStr.trim().length()<1){
				return false;
			}
			else{
				allStr = allStr.replaceAll(" ","");
				checkedStr = checkedStr.replaceAll(" ","");
				String astr[] = allStr.split(","); 
				for (int jj = 0; jj < astr.length; jj++) 
				{
					if (astr[jj].toLowerCase().equals(checkedStr.toLowerCase()))  
					{
						astr = null;
						return true;
					}
				}
				return false;
			}
		}
		catch (Exception er)
		{
			return false;
		}
	}
	
	/**
	 * 获取文件后缀名
	 * 
	 * @param fineName 文件全名
	 * @return String
	 */
	public static String getSuffixName(String fileName)
	{
		try
		{
		    return fileName.substring(fileName.lastIndexOf(".")+1);
		}
		catch(Exception er)
		{
			return fileName;
		}
	}

	/**
	 * 获取去掉后缀的文件名
	 * 
	 * @param fineName 	文件全名 
	 * @return String
	 */
	public static String getPrefixName(String fileName)
	{
		return fileName.substring(0, fileName.lastIndexOf("."));
	}
	
	/**
	 * ISO88591转为 utf-8
	 * @param s
	 * @return
	 */
	public static String ISO8859ToUtf8(String s)
	{
		try
		{
			byte[] b = s.getBytes("iso-8859-1");
			return new String(b, "utf-8");
		}
		catch (Exception e)
		{
			return s;
		}
	}
	
	/**
	 * ISO88591转为 utf-8
	 * @param s
	 * @return
	 */
	public static String ISO8859ToGBK(String s)
	{
		try
		{
			byte[] b = s.getBytes("iso-8859-1");
			return new String(b, "GBK");
		}
		catch (Exception e)
		{
			return s;
		}
	}
	
	/**
	 * ISO88591转为 utf-8
	 * @param s
	 * @return
	 */
	public static String Utf8ToGbk(String s)
	{
		try
		{
			byte[] b = s.getBytes("utf-8");
			return new String(b, "GBK");
		}
		catch (Exception e)
		{
			return s;
		}
	}
	
	public static String Utf8ToGb2312(String s)
	{
		try
		{
			byte[] b = s.getBytes("utf-8");
			return new String(b, "GB2312");
		}
		catch (Exception e)
		{
			return s;
		}
	}
	
	/**
	 * ISO88591转为 utf-8
	 * @param s
	 * @return
	 */
	public static String GbkToUtf8(String s)
	{
		try
		{
			byte[] b = s.getBytes("GBK");
			return new String(b, "utf-8");
		}
		catch (Exception e)
		{
			return s;
		}
	}
	
	
	/**
	 * 把特殊字符转化为html代码
	 * @param str  要转化的字符串
	 * @return
	 */
	public static String strToHtml(String str) {
		if (str != null && !str.equals("")) {
			str = str.replaceAll("&", "&amp;");
			str = str.replaceAll("<", "&lt;");
			str = str.replaceAll(">", "&gt;");
			str = str.replaceAll(" ", "&nbsp;");
			str = str.replaceAll("\r", "<br>");
			str = str.replaceAll("\n", "<br>");
			str = str.replaceAll("'", "&#39");
			str = str.replaceAll("\"", "&quot;");
			return str;
		} else {
			return "";
		}
	} 

	/**
	 * 把特殊字符转化为html代码 
	 * @param str  要转化的字符串
	 * @return
	 */
	public static String HtmlToStr(String str){
		if (str != null && !str.equals("")) {
			str = str.replaceAll("&amp;amp;nbsp;", " ");
			str = str.replaceAll("&amp;", "&");
			str = str.replaceAll("&lt;", "<");
			str = str.replaceAll("&gt;", ">");
			str = str.replaceAll("&nbsp;", " ");
			str = str.replaceAll("<br>", "\n");
			str = str.replaceAll("&#39", "'");
			str = str.replaceAll("&quot;", "\"");
			str = str.trim();
			return str;
		} else {
			return "";
		}
	}
	
	/**
	 * 输入字符的转换
	 * @param string 
	 * @return
	 */
	public static String inputFormate(String string)
	{
		return string;
	}
	
	/**
	 * 补充字符串到指定的位数，位数不够，前面加0补充
	 * @param stringLentgh 原字符串 
	 * @param length  补充到长度
	 * @return
	 */
	public static String fillfulString(String string,int length)  
	{
		String newString = "";
		if(string.length()>length)
		{
			return string.substring(0,length); 
		}
		else
		{
			for(int i=0;i<length-string.length();i++)
			{
				newString = newString + "0";
			}
		}
		return newString + string; 
	}

	
	/**
	 * 获取随机名（字符+字母）
	 * @param length
	 * @return
	 */
	public static String getCharAndNumr(int length)     
	{     
	    String val = "";           
	    Random random = new Random();     
	    for(int i = 0; i < length; i++)     
	    {     
	        String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num"; // 输出字母还是数字     
	                 
	        if("char".equalsIgnoreCase(charOrNum)) // 字符串     
	        {     
	            int choice = random.nextInt(2) % 2 == 0 ? 65 : 97; //取得大写字母还是小写字母     
	            val += (char) (choice + random.nextInt(26));     
	        }     
	        else if("num".equalsIgnoreCase(charOrNum)) // 数字     
	        {     
	            val += String.valueOf(random.nextInt(10));     
	        }     
	    }          
	    return val;     
	}   
	
	/**
	 * 获取随机文件名
	 * 
	 * @param userId 用户ID
	 * @return
	 */
	public static String getRandomFileName(String userId)
	{
		if(userId==null || userId.equals(""))
		{
			userId = getCharAndNumr(10);
		}
		return HxDateUtil.dateToString(new Date(), "yyyyMMddHHmmss") + new Date().getTime() + "_" + userId;
	}

	
	/**
	 * 描述: GZip 压缩
	 * @auther 胡义振
	 * @date 2013-11-27 
	 * @param str 待压缩的字符串  
	 * @return 返回压缩后的字符串
	 * @throws IOException
	 */
    public static String GZipCompress(String str) throws IOException {
        if (null == str || str.length() <= 0) {  
            return str;  
        }  
        // 创建一个新的 byte 数组输出流  
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        // 使用默认缓冲区大小创建新的输出流  
        GZIPOutputStream gzip = new GZIPOutputStream(out);
        // 将 b.length 个字节写入此输出流  
        gzip.write(str.getBytes());
        gzip.close();
        // 使用指定的 charsetName，通过解码字节将缓冲区内容转换为字符串
        return out.toString("ISO-8859-1");
    }  
    
	/**
	 * 描述: GZip 解压缩
	 * @auther 胡义振
	 * @date 2013-11-27 
	 * @param str 待解压缩的字符串  
	 * @return 返回解压缩后的字符串
	 * @throws IOException
	 */
    public static String GZipUnCompress(String str) throws IOException {
        if (null == str || str.length() <= 0) {
            return str;  
        }  
        // 创建一个新的 byte 数组输出流  
        ByteArrayOutputStream out = new ByteArrayOutputStream();  
        // 创建一个 ByteArrayInputStream，使用 buf 作为其缓冲区数组  
        ByteArrayInputStream in = new ByteArrayInputStream(str.getBytes("ISO-8859-1"));  
        // 使用默认缓冲区大小创建新的输入流  
        GZIPInputStream gzip = new GZIPInputStream(in);  
        byte[] buffer = new byte[256];  
        int n = 0;  
        while ((n = gzip.read(buffer)) >= 0) {// 将未压缩数据读入字节数组  
            // 将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此 byte数组输出流  
            out.write(buffer, 0, n);  
        }  
        // 使用指定的 charsetName，通过解码字节将缓冲区内容转换为字符串  
        return out.toString("utf-8");  
    }  
    
    /**
     * 描述: ZLib 压缩
     * @auther 胡义振
     * @date 2013-11-27 
     * @param data  待压缩的数据
     * @return 压缩后的数据
     */
	public static byte[] ZLibCompress(byte[] data)
	{
		byte[] output = new byte[0];
		Deflater compresser = new Deflater();
		compresser.reset();
		compresser.setInput(data);
		compresser.finish();
		ByteArrayOutputStream bos = new ByteArrayOutputStream(data.length);
		try
		{
			byte[] buf = new byte[1024];
			while (!compresser.finished())
			{
				int i = compresser.deflate(buf);
				bos.write(buf, 0, i);
			}
			output = bos.toByteArray();
		}
		catch (Exception e)
		{
			output = data;
			e.printStackTrace();
		}
		finally
		{
			try
			{
				bos.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
		compresser.end();
		return output;
	}  
	
    /**
     * 描述: ZLib 解压缩
     * @auther 胡义振
     * @date 2013-11-27 
     * @param data  待压缩的数据
     * @return 解压缩后的数据
     */
	public static byte[] ZLibUnCompress(byte[] data)
	{
		byte[] output = new byte[0];

		Inflater decompresser = new Inflater();
		decompresser.reset();
		decompresser.setInput(data);

		ByteArrayOutputStream o = new ByteArrayOutputStream(data.length);
		try
		{
			byte[] buf = new byte[1024];
			while (!decompresser.finished())
			{
				int i = decompresser.inflate(buf);
				o.write(buf, 0, i);
			}
			output = o.toByteArray();
		}
		catch (Exception e)
		{
			output = data;
		}
		finally
		{
			try
			{
				o.close();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}

		decompresser.end();
		return output;
	}
	
	/**
	 * 
	 * 描述: 身份证号码转为18位
	 * @auther 胡义振
	 * @date 2014-2-21 
	 * @param century
	 * @param idCardNo
	 * @return
	 */
	public static String formatIdTo18(String idCardNo) 
	{
		try
		{
			if(idCardNo==null || idCardNo.equals("null")) 
			{
				return ""; 
			}
			else if(idCardNo.replaceAll(" ","").length()!=15 && idCardNo.replaceAll(" ","").length()!=18) 
			{
				return idCardNo.replaceAll(" ",""); 
			}
			else
			{
				if(idCardNo.trim().length()==18)
				{
					return idCardNo.trim();
				}
				else
				{
			        int[] weight = new int[] {7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2, 1};
			
			        // 通过加入世纪码, 变成 17 为的新号码本体.
			        String newNoBody = idCardNo.substring(0, 6) + "19" + idCardNo.substring(6);
			
			        //下面算最后一位校验码
			        int checkSum = 0;
			        for(int i=0; i< 17; i++) {
			            int ai = Integer.parseInt("" + newNoBody.charAt(i)); // 位于 i 位置的数值
			            checkSum = checkSum + ai * weight[i];
			        }
			
			        int checkNum = checkSum % 11;
			        String checkChar = null;
			
			        switch(checkNum) {
			            case 0: checkChar = "1"; break; 
			            case 1: checkChar = "0"; break;
			            case 2: checkChar = "X"; break;
			            default: checkChar = "" + (12 - checkNum); 
			        }
			        return newNoBody + checkChar; 
		        }

			}
		}
		catch(Exception er)
		{
			return ""; 
		}
    }

	/** 
	 * 描述: 全角字符转换为半角
	 * @author yushunwei
	 * @date 2014-8-20 
	 * @param src
	 * @return 
	 */
	public static String strFulltoHalf(String src) {
		try{
			if(src==null){
				return "";
			}
			else
			{
				char[] c = src.toCharArray();
				for (int index = 0; index < c.length; index++) {
					if (c[index] == 12288) {// 全角空格 
						c[index] = (char) 32;
				    } else if (c[index] > 65280 && c[index] < 65375) {// 其他全角字符 
				    	c[index] = (char) (c[index] - 65248);
				    }
				}
				return String.valueOf(c);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
		return src;
	}

	/**
	 * 描述: 替换所有空格（包含换行）
	 * @auther 胡义振
	 * @date 2014-9-23 
	 * @param str
	 * @return
	 */
	public static String replaceAllBlank(String str) {
        String dest = "";
        if (str!=null) {
            Pattern p = Pattern.compile("\\s|\u3000|\t|\r\n|\r|\n|\n\r");
            Matcher m = p.matcher(str);
            dest = m.replaceAll(""); 
        }
        return dest;
    }
	
	/**
	 * 描述：将字符串转成特定格式的字符串
	 * 例如：A,B,C... 转成  A','B','C...
	 * 作用：组装成sql查询参数
	 * 
	 * @author 朱勇
	 * @date 2015-4-15
	 * @return
	 */
	public static List<String> strSplitAddToList(String paramStr){
		List<String> list = new ArrayList<String>();
		String[] strs = paramStr.split(",");
		for (String s : strs) {
			list.add(s);
		}
		return list;
	}
	

	/** 
	 * 描述: 把字符串中的身份证号码用　*　代替
	 * 
	 * @author 朱勇
	 * @date 2015-8-31 
	 * @param data
	 * @return 
	 */
	public static String doMarkSFZ(String data){
		if(StringUtils.isNotBlank(data)){
			String regex = "\\d{14,17}[0-9a-zA-Z]";
			Pattern p = Pattern.compile(regex);
			Matcher m = p.matcher(data);
			while (m.find()) {
				if (!"".equals(m.group()))
					if (m.group().length() >= 15 && m.group().length() <= 18) {
						//定义判别用户身份证号的正则表达式（要么是15位，要么是18位，最后一位可以为字母）  
			            Pattern idNumPattern = Pattern.compile("(^[1-9]\\d{7}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}$)|(^[1-9]\\d{5}[1-9]\\d{3}((0\\d)|(1[0-2]))(([0|1|2]\\d)|3[0-1])\\d{3}[0-9a-zA-Z]$)");  
			            //通过Pattern获得Matcher  
			            Matcher idNumMatcher = idNumPattern.matcher(m.group());  
			            //判断用户输入是否为身份证号  
			            if(idNumMatcher.matches()){
			            	data = data.replace(m.group(), "******");
			            }
					}
			}
		}
		return data;
	}
  
}