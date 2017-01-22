package com.icinfo.plugin.common;

import java.util.Random;
public final class StringOperate
{
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
	 * 检查字符串是否存在（如：str = "25,26,28,29"， ）
	 * 
	 * @param allStr
	 * @param str
	 * @return
	 */
	public static boolean checkIncludeString(String allStr, String checkedStr)
	{
		try
		{
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
			str = str.replaceAll("\r\n", "<br>");
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
			str = str.replaceAll("&amp;", "&");
			str = str.replaceAll("&lt;", "<");
			str = str.replaceAll("&gt;", ">");
			str = str.replaceAll("&nbsp;", " ");
			str = str.replaceAll("<br>", "\n");
			str = str.replaceAll("&#39", "'");
			str = str.replaceAll("&quot;", "\"");
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
		if(string.length()>10)
		{
			return string.substring(0,10); 
		}
		else
		{
			for(int i=0;i<10-string.length();i++)
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
	
}
