
package com.icinfo.plugin.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

	/**
	 * 以指定的格式来格式化日期
	 * 
	 * @param date
	 *            日期
	 * @param format
	 *            日期格式 String
	 */
	public static String dateToString(java.util.Date date, String format) {
		String result = "";
		if (date != null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				result = sdf.format(date);
			} catch (Exception ex) {
				result = "";
			}
		}
		return result;
	}
	/**
	 * 以指定的格式来格式化日期
	 * 
	 * @param date
	 *            日期
	 * @param format
	 *            日期格式 String
	 */
	public static String dateToString(java.util.Date date) {
		String result = "";
		if (date != null) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
				result = sdf.format(date);
			} catch (Exception ex) {
				result = "";
			}
		}
		return result;
	}
	
	/**
	 * 把字符转为日期
	 * 
	 * @param strDate
	 * @param
	 * @return
	 */
	public static Date stringToDate(String strDate, String format) {
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(strDate);
		} catch (Exception er) {
			return null;
		}
	}
	/** 
	 * 描述: 中文日期转化日期格式
	 * @auther gqf
	 * @date 2015年5月15日 
	 * @param strDate
	 * @param format
	 * @return 
	 */
	
	public static Date chineseStrToDate(String strDate, String format){
		strDate = strDate.replace("年", "-");
		strDate = strDate.replace("月", "-");
		strDate = strDate.replace("日", "-");
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			return sdf.parse(strDate);
		} catch (Exception er) {
			return null;
		}
	}
	/**
	 * 获取当前完整时间
	 */
	public static String getCurrentTime() {
		return dateToString(new Date(), "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 获取当前完整年份
	 */
	public static String getCurrentYear() {
		return dateToString(new Date(), "yyyy");
	}
	
	/**
	 * 获取当前完整日期
	 */
	public static String getCurrentDate() {
		return dateToString(new Date(), "yyyyMMdd");
	}

	/**
	 * 获取当前完整日期
	 */
	public static String getCurrentSimpleTime() {
		return dateToString(new Date(), "HH:mm:ss");
	}

	/**
	 * 获取当前完整日期
	 */
	public static String getCurrentSimpleDate() {
		return dateToString(new Date(), "yyyyMMdd");
	}

	/**
	 * 把日期转成完整格式。如：2007-1-1 转化后为 2007-01-01
	 * 
	 * @param date
	 * @return
	 */
	public static String toComplexDate(String strDate, String regex) {
		try {
			String tmp_date[] = strDate.split(regex);
			String tmp_year = tmp_date[0];
			String tmp_month = tmp_date[1];
			String tmp_day = tmp_date[2];
			if (Integer.parseInt(tmp_month) <= 9) {
				tmp_month = "0" + tmp_month;
			}
			if (Integer.parseInt(tmp_day) <= 9) {
				tmp_day = "0" + tmp_day;
			}
			return tmp_year + "-" + tmp_month + "-" + tmp_day;
		} catch (Exception er) {
			return strDate;
		}
	}

	/**
	 * 获取N年后时间
	 * 
	 * @param N
	 * @return
	 */
	public static String getNyearlater(Date date, int N) {
		try {
			Calendar now = Calendar.getInstance();
			now.setTime(date);
			now.add(Calendar.DAY_OF_YEAR, 365 * N);
			SimpleDateFormat formatter = new SimpleDateFormat(
					"yyyy-MM-dd HH:mm:ss");
			return formatter.format(now.getTime());
		} catch (Exception er) {
			return getCurrentTime();
		}
	}

	/**
	 * 获取N年后日期
	 * 
	 * @param N
	 * @return
	 */
	public static String getNyearlaterDate(Date date, int N) {
		try {
			Calendar now = Calendar.getInstance();
			now.setTime(date);
			now.add(Calendar.DAY_OF_YEAR, 365 * N);
			SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
			return formatter.format(now.getTime());
		} catch (Exception er) {
			return getCurrentTime();
		}
	}
	
	/**
	 * 获取N年后日期对象
	 * 
	 * @param N
	 * @return
	 */
	public static Date getNyearlaterDateObject(Date date, int N) {
		Calendar now = Calendar.getInstance();
		try {
		
			now.setTime(date);
			now.add(Calendar.DAY_OF_YEAR, 365 * N);
			
		} catch (Exception er) {
			er.printStackTrace();
		}
		return now.getTime();
	}

	/**
	 * 获取N月后时间
	 * 
	 * @param N
	 * @return
	 */
	public static String getNmonthlater(Date date, int N) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.MONTH, N);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return formatter.format(now.getTime());
	}

	/**
	 * 获取N月后日期
	 * 
	 * @param N
	 * @return
	 */
	public static String getNmonthlaterDate(Date date, int N) {
		Calendar now = Calendar.getInstance();
		now.setTime(date);
		now.add(Calendar.MONTH, N);
		SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
		return formatter.format(now.getTime());
	}

	/**
	 * 获取N天后日期(字符串形式)
	 * 
	 * @param N
	 * @return
	 */
	public static String getNdaylater(Date date, int N,String format) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat(format);
			return formatter.format(getNdaylaterDate(date, N) );
		} catch (Exception er) {
			return getCurrentTime();
		}
	}
	/**
	 * 获取N天后日期(字符串形式)
	 * 
	 * @param N
	 * @return
	 */
	public static String getNdaylater(Date date, int N) {
		try {
			SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMdd");
			return formatter.format(getNdaylaterDate(date, N) );
		} catch (Exception er) {
			return getCurrentTime();
		}
	}
	/**
	 * 获取N天后日期
	 * 
	 * @param N
	 * @return
	 */
	public static Date getNdaylaterDate(Date date, int N) {
			Calendar now = Calendar.getInstance();
			now.setTime(date);
			now.add(Calendar.DAY_OF_YEAR, N);
			return now.getTime();
	}
	


	/**
	 * 获取N小时后时间
	 * 
	 * @param N
	 * @return
	 */
	public static Date getNhourlater(Date date, int N) {
		long myTime = (date.getTime() / 1000) + 60 * 60 * N;
		date.setTime(myTime * 1000);
		return date;
	}

	/**
	 * 获取N分钟后时间
	 * 
	 * @param N
	 * @return
	 */
	public static Date getNMinutelater(Date date, int N) {
		long myTime = (date.getTime() / 1000) + 60 * N;
		date.setTime(myTime * 1000);
		return date;
	}
	
	/** 描述:返回两个日期之间的时间 单位分钟
	 * @param beforeDate
	 * @param nowDate
	 * @return
	 */
	public static long getBetweenDaysToMut(Date beforeDate,Date nowDate){
		long myTime = (nowDate.getTime() / 1000)-(beforeDate.getTime() / 1000);
		return myTime/60;
	}

	/**
	 * 计算两日期相差天数
	 * 
	 * @param beforeDate
	 * @param afterDate
	 * @return
	 */
	public static int getBetweenDays(String beforeDate, String afterDate) {
		try {
			DateFormat format = new SimpleDateFormat("yyyyMMdd");
			int betweenDays = 0;
			Date d1 = format.parse(beforeDate);
			Date d2 = format.parse(afterDate);
			Calendar c1 = Calendar.getInstance();
			Calendar c2 = Calendar.getInstance();
			c1.setTime(d1);
			c2.setTime(d2);
			// 保证第二个时间一定大于第一个时间
			//if (c1.after(c2)) {
			//	c1 = c2;
			//	c2.setTime(d1);
			//}
			int betweenYears = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
			betweenDays = c2.get(Calendar.DAY_OF_YEAR)
					- c1.get(Calendar.DAY_OF_YEAR);
			for (int i = 0; i < betweenYears; i++) {
				c1.set(Calendar.YEAR, (c1.get(Calendar.YEAR) + 1));
				betweenDays += c1.getMaximum(Calendar.DAY_OF_YEAR);
			}
			return betweenDays;
		} catch (Exception er) {
			return 0;
		}
	}
	
	
	public static void main(String[] args){
		//int bDays = DateUtil.getBetweenDays("2010-05-30","2010-06-30");
		//System.out.print(""+getBetweenDaysToMut(new Date(),getNMinutelater(new Date(),50)));
		for (int j = 5; j > 0; j--){
		
		System.out.println(
		DateUtil.getNdaylater(
				DateUtil.stringToDate("20140530","yyyyMMdd"), -j));
		}
	}

	/**
	 * 计算两日期相差月数
	 * 
	 * @param beforeDate
	 * @param afterDate
	 * @return
	 */
	public static int getBetweenMonths(String beforeDate, String afterDate) {
		try {
			int iMonth = 0;
			int flag = 0;
			try {
				DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				Date d1 = format.parse(beforeDate);
				Date d2 = format.parse(afterDate);

				Calendar objCalendarDate1 = Calendar.getInstance();
				objCalendarDate1.setTime(d1);

				Calendar objCalendarDate2 = Calendar.getInstance();
				objCalendarDate2.setTime(d2);

				if (objCalendarDate2.equals(objCalendarDate1))
					return 0;
				if (objCalendarDate1.after(objCalendarDate2)) {
					Calendar temp = objCalendarDate1;
					objCalendarDate1 = objCalendarDate2;
					objCalendarDate2 = temp;
				}
				if (objCalendarDate2.get(Calendar.DAY_OF_MONTH) < objCalendarDate1
						.get(Calendar.DAY_OF_MONTH))
					flag = 1;

				if (objCalendarDate2.get(Calendar.YEAR) > objCalendarDate1
						.get(Calendar.YEAR))
					iMonth = ((objCalendarDate2.get(Calendar.YEAR) - objCalendarDate1
							.get(Calendar.YEAR))
							* 12 + objCalendarDate2.get(Calendar.MONTH) - flag)
							- objCalendarDate1.get(Calendar.MONTH);
				else
					iMonth = objCalendarDate2.get(Calendar.MONTH)
							- objCalendarDate1.get(Calendar.MONTH) - flag;

			} catch (Exception e) {
				e.printStackTrace();
			}
			return iMonth;

		} catch (Exception er) {
			return 0;
		}
	}
	
	
	public static Date addMonth(Date d, int i) {
		Date date = null;
		GregorianCalendar gc = new GregorianCalendar();
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		gc.setTime(d);
		gc.add(Calendar.MONTH, i);
		try {
			date = sf.parse(sf.format(gc.getTime()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}
	
	/** 
	* @Title: convertHourToMilliseconds 
	* @Description: 获取小时对应的毫秒数
	* @param @param hour
	* @param @return    设定文件 
	* @return long    返回类型 
	* @throws 
	*/  
	public static long convertHourToMilliseconds(float hour){
		return (long) (hour*60*60*1000);
	}
	
	/** 
	* @Title: getYearCheckYear 
	* @Description: 根据系统当前时间自动获取上一年度
	* @param @return    设定文件 
	* @return String    返回类型 
	* @throws 
	*/  
	public static String getPreYear(){
		Calendar curr = Calendar.getInstance();
		curr.set(Calendar.YEAR,curr.get(Calendar.YEAR)-1);
		return String.valueOf(curr.get(Calendar.YEAR));
	}

}
