/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 系统文件 <br/>
 * @author 胡义振
 * @date 2013-5-14
 * @version 1.0
 */
package com.icinfo.plugin.log;
import org.aspectj.lang.JoinPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * 描述: 日志拦截器<br>
 * @author 胡义振
 * @date 2013-5-14 
 * 
 *
 */
public class LogAdvice 
{
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	/**
	 * 
	 * 描述: 方法执行发生异常拦截
	 * @auther 胡义振
	 * @date 2013-5-14 
	 * 
	 * @param vobjJoinPoint 接入点
	 * @param throwable 异常
	 *
	 */
	public void doExceptionLog(final JoinPoint vobjJoinPoint, final Throwable throwable)
	{
		try
		{
			String pstrMethod =  vobjJoinPoint.getTarget().getClass().getName()+"."+vobjJoinPoint.getSignature().getName()+"()";
			StringBuilder pstrErrMess = new StringBuilder();
			pstrErrMess.append("\n    ");
			pstrErrMess.append(throwable.toString());
	
	        for (StackTraceElement st:((throwable.getCause()==null)?throwable:throwable.getCause()).getStackTrace()){
	        	pstrErrMess.append("\n    ");
	        	pstrErrMess.append(st.toString());
	        }
	        logger.info("\n    Call "+pstrMethod+",出现异常 ："+pstrErrMess);
		}
		catch(Exception paramExp){
			logger.info("\n    Call LogAdvice ,出现异常 " + paramExp.getMessage()); 
		}
	}
	
	/**
	 * 
	 * 描述: 方法执行前拦截
	 * @auther 胡义振
	 * @date 2013-5-14 
	 * 
	 * @param vobjJoinPoint
	 *
	 */
	public void doBeforeLog(final JoinPoint vobjJoinPoint)
	{
		String pstrMethod =  vobjJoinPoint.getTarget().getClass().getName()+"."+vobjJoinPoint.getSignature().getName()+"()";
		logger.info("\n    Call "+pstrMethod+" start");
	}
	
	/**
	 * 
	 * 描述: 方法执行后拦截
	 * @auther 胡义振
	 * @date 2013-5-14 
	 * 
	 * @param vobjJoinPoint
	 *
	 */
	public void doAfterLog(final JoinPoint vobjJoinPoint)
	{
		String pstrMethod =  vobjJoinPoint.getTarget().getClass().getName()+"."+vobjJoinPoint.getSignature().getName()+"()";
		logger.info("\n    Call "+pstrMethod+" end");
	}
	
}
