package com.icinfo.plugin.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 描述: 汇信日期工具类<br>
 * @author 胡义振
 * @date 2014-10-17
 */
public final class HxDateUtil
{

	/**
	 * 描述: 日期转为字符串
	 * @auther 胡义振
	 * @date 2014-10-17 
	 * @param date
	 * @param format
	 * @return
	 */
	public static String dateToString(Date date,String format)
	{
		String result = "";
		if (date != null)
		{
			try
			{
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				result = sdf.format(date);
			}
			catch (Exception ex)
			{
				result = "";
			}
		}
		return result;
	}
	
	public static String dateToString(Date date)
	{
		String result = "";
		if (date != null)
		{
			try
			{
				SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
				result = sdf.format(date);
			}
			catch (Exception ex)
			{
				result = "";
			}
		}
		return result;
	}
	
	/**
	 * 描述: 字符串转为日期类型
	 * @auther 胡义振
	 * @date 2014-10-17 
	 * @param strDate 
	 * @param format
	 * @return
	 */
	public static Date stringToDate(String strDate,String format)
	{
		try
		{
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(strDate); 
		}
		catch (Exception er)
		{
			return null;
		}
	}
	

	/**
	 * 描述: 获取当前完整时间
	 * @auther 胡义振
	 * @date 2014-10-17 
	 * @return
	 */
	public static String getCurrentTime()
	{
		return dateToString(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 描述: 获取当前年份
	 * @auther 胡义振
	 * @date 2014-10-17 
	 * @return
	 */
	public static String getCurrentYear()
	{
		return dateToString(new Date(), "yyyy");
	}
	
	/**
	 * 描述: 获取当前月的开始时间
	 * 
	 * @author yulirong
	 * @date 2015-12-09 
	 * @return
	 */
	public static String getNowMonthStartDate(){
		Calendar cal = Calendar.getInstance();   
		SimpleDateFormat df=new SimpleDateFormat("yyyy-MM-dd");  
		cal.set(Calendar.DATE,1);   
		return df.format(cal.getTime())+" 00:00:00";
	}
	/**
	 * 描述: 获取当日零点详细时间
	 * 
	 * @author 朱勇
	 * @date 2015-03-02 
	 * @return
	 */
	public static String getNowDayStartDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 00:00:00");
		return sdf.format(new Date());
	}
	
	/**
	 * 描述: 获取当日结束详细时间
	 * 
	 * @author 朱勇
	 * @date 2015-03-02 
	 * @return
	 */
	public static String getNowDayEndDate(){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd 23:59:59");
		return sdf.format(new Date());
	}
	/**
	 * 描述: 获取当前日期
	 * @auther 胡义振
	 * @date 2014-10-17 
	 * @return
	 */
	public static String getCurrentDate()
	{
		return dateToString(new Date(), "yyyy-MM-dd");
	}
	
	/**
	 * 描述: 获取当前日期
	 * @auther 胡义振
	 * @date 2014-10-17 
	 * @return
	 */
	public static String getCurrentDate2()
	{
		return dateToString(new Date(), "yyyyMMdd");
	}

	/**
	 * 描述: 获取当前时间(时、分、秒)
	 * @auther 胡义振
	 * @date 2014-10-17 
	 * @return
	 */
	public static String getCurrentSimpleTime()
	{
		return dateToString(new Date(), "HH:mm:ss");   
	}

	/**
	 * 描述: 把日期转成完整格式。如：2014-1-1 转化后为 2014-01-01
	 * @auther 胡义振
	 * @date 2014-10-17 
	 * @param strDate
	 * @return
	 */
	public static String toComplexDate(String strDate)
	{
		try
		{
			String tmp_date[] = strDate.split("-");
			String tmp_year = tmp_date[0];
			String tmp_month = tmp_date[1];
			String tmp_day = tmp_date[2];
			if (Integer.parseInt(tmp_month) <= 9)
			{
				tmp_month = "0" + tmp_month;
			}
			if (Integer.parseInt(tmp_day) <= 9)
			{
				tmp_day = "0" + tmp_day;
			}
			return tmp_year + "-" + tmp_month + "-" + tmp_day;
		}
		catch (Exception er)
		{
			return strDate;
		}
	}

	/**
	 * 描述: 获取N年后日期
	 * @auther 胡义振
	 * @date 2014-10-17 
	 * @param date
	 * @param years  年数
	 * @return
	 */
	public static Date getAfterDateByYears(Date date,int years) 
	{
		try
		{
			Calendar now = Calendar.getInstance();
			now.setTime(date);
			now.add(Calendar.YEAR,years);
			return now.getTime();  
		}
		catch(Exception er) 
		{
			return date;   
		}
	}
	
	/**
	 * 描述: 获取N月后日期
	 * @auther 胡义振
	 * @date 2014-10-17 
	 * @param date
	 * @param months 月数
	 * @return
	 */
	public static Date getAfterDateByMonths(Date date,int months) 
	{
		try
		{
			Calendar now = Calendar.getInstance();
			now.setTime(date);
			now.add(Calendar.MONTH,months);
			return now.getTime();  
		}
		catch(Exception er) 
		{
			return date;   
		}
	}
	
	/**
	 * 描述: 获取N天后日期
	 * @auther 胡义振
	 * @date 2014-10-17 
	 * @param date
	 * @param months 月数
	 * @return
	 */
	public static Date getAfterDateByDays(Date date,int days) 
	{
		try
		{
			Calendar now = Calendar.getInstance();
			now.setTime(date);
			now.add(Calendar.DAY_OF_YEAR,days);
			return now.getTime();  
		}
		catch(Exception er) 
		{
			return date;   
		}
	}
	
	/**
	 * 描述: 获取N小时后日期
	 * @auther 胡义振
	 * @date 2014-10-17 
	 * @param date
	 * @param hours 小时数
	 * @return
	 */
	public static Date getAfterDateByHours(Date date,int hours) 
	{
		try
		{
			Calendar now = Calendar.getInstance();
			now.setTime(date);
			now.add(Calendar.HOUR,hours);
			return now.getTime();  
		}
		catch(Exception er) 
		{
			return date;   
		}
	}
	
	/**
	 * 描述: 获取N分钟后日期
	 * @auther 胡义振
	 * @date 2014-10-17 
	 * @param date
	 * @param hours 小时数
	 * @return
	 */
	public static Date getAfterDateByMinutes(Date date,int minutes) 
	{
		try
		{
			Calendar now = Calendar.getInstance();
			now.setTime(date);
			now.add(Calendar.MINUTE,minutes);
			return now.getTime();  
		}
		catch(Exception er) 
		{
			return date;   
		}
	}
	
	/**
	 * 描述: 计算两日期相差天数
	 * @auther 胡义振
	 * @date 2014-10-17 
	 * @param startDate 开始日期
	 * @param endDate 结束日期
	 * @return
	 */
	public static int getBetweenDays(Date startDate,Date endDate) 
	{
		try
		{
			Calendar startCalendar = Calendar.getInstance();
			startCalendar.setTime(startDate);
			long startTime = startCalendar.getTimeInMillis();
		    Calendar endCalendar = Calendar.getInstance();
		    endCalendar.setTime(endDate);
		    long endTime = endCalendar.getTimeInMillis();
		    long between_days = (endTime-startTime)/(1000*60*60*24);
		    return Integer.parseInt(String.valueOf(between_days));
		}
	    catch(Exception er)
	    {
		    return 0;
	    }
	}
	
	/** 
	 * 描述: 返回两个日期之间的时间 单位分钟
	 * @author 朱勇
	 * @date 2015-1-27 
	 * @param beforeDate
	 * @param nowDate
	 * @return 
	 */
	public static long getBetweenDaysToMut(Date beforeDate,Date nowDate){
		long myTime = (nowDate.getTime() / 1000)-(beforeDate.getTime() / 1000);
		return myTime/60;
	}
	/**
	 * 
	 * 描述:判断导入日期格式是否正确.
	 * @author LiYaFeng
	 * @date 2015年11月12日 
	 * @param date
	 * @return
	 */
	public static boolean checkDateFormat(Date date){
		boolean flag = true;
		try {
			String dateStr = HxDateUtil.dateToString(date, "yyyy-MM-dd HH:mm:ss");
			String year = dateStr.split("-")[0];
			if(year.length()>4) flag=false;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	} 
	/**
	 * 描述: 获取当前月份的第一天的日期.
	 * 
	 * @author 李亚锋
	 * @date 2015-11-1
	 * @return
	 */
	public static Date getFirstDayByMonth(){
		try{
			Calendar now = Calendar.getInstance();
			now.add(Calendar.MONTH, 0);
			now.set(Calendar.DAY_OF_MONTH, 1);
			now.set(Calendar.HOUR_OF_DAY, 0);
			now.set(Calendar.MINUTE, 0);
			now.set(Calendar.SECOND, 0);
			return now.getTime();
		}catch(Exception e){
			return null; 
		}	
	}
	
	public static void main(String[] args) {
		System.out.println(getDateStrList("2015.12","2016/5"));
	}
	/**
	 * 描述：获取按月为间隔的时间集合
	 * @author 马亚伟
	 * @date 2015-11-17
	 * @param startDate 格式为
	 * @param endDate
	 * @return <br/> List<String>日期格式为yyyy-MM的List集合
	 */
	public static List<String> getDateStrList(String startDate, String endDate) {
		
		List<String> dateList = new ArrayList<String>();
		startDate = startDate.replace(".", "-").replace("/", "-");
		endDate = endDate.replace(".", "-").replace("/", "-");
		Date start=null;
		Date end=null;
		
		start = stringToDate(startDate, "yyyy-MM");
		if(start==null)
			start = stringToDate(startDate, "yyyyMM");
		if(start!=null){
			end = stringToDate(endDate, "yyyy-MM");
			if(end==null)
				end = stringToDate(endDate, "yyyyMM");
		}
		if(end==null){
			System.err.println("非yyyy-MM、yyyyMM、yyyy.MM格式的日期，不能解析！");
			return dateList;
		}
		//日期交换
		if(start.getTime() > end.getTime()){
			Date temp;
			temp = start;
			start = end;
			end = temp;
		}
		Calendar startC = Calendar.getInstance();
		Calendar endC = Calendar.getInstance();
		startC.setTime(start);
		endC.setTime(end);
		int months =(endC.get(Calendar.YEAR)- startC.get(Calendar.YEAR))*12+(endC.get(Calendar.MONTH)- startC.get(Calendar.MONTH));
		if(months<0) return dateList;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM");
		dateList.add(dateFormat.format(startC.getTime()));
		for (int i = 0; i < months; i++) {
			startC.add(Calendar.MONTH,1);
			dateList.add(dateFormat.format(startC.getTime()));
		}
		return dateList;
	}
	
}
