/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author 胡义振
 * @date 2013-5-16
 * @version 1.0
 */
package com.icinfo.creditinfo.servlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 
 * 描述: 用户登录Servlet处理<br>
 * @author 胡义振
 * @date 2013-5-16 
 */
public class UserLoginServlet extends HttpServlet
{
	private static final long serialVersionUID = 2617317873265109709L;

	//登录用到的配置参数
	private String userParam;

	public void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {

	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)   throws ServletException, IOException 
	{
		System.out.println("userParam:"+userParam);
		System.out.println("userName:"+request.getParameter("gobjUser.loginName"));
		response.getWriter().print("Servlet Login Success!");
	}
	
	public void init(ServletConfig servletConfig) throws ServletException  
	{
		setUserParam(servletConfig.getInitParameter("userParam"));
	}

	public String getUserParam()
	{
		return userParam;
	}
	public void setUserParam(String userParam)
	{
		this.userParam = userParam;
	}

}
