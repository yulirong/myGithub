/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 系统文件 <br/>
 * @author 胡义振
 * @date 2013-5-10
 * @version 1.0
 */
package com.icinfo.creditinfo.action;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;







import com.icinfo.creditinfo.bean.sys.sysuser.SysUser;
import com.icinfo.plugin.common.HxConstants;
import com.icinfo.plugin.common.HxRequestUtil;
import com.icinfo.plugin.hxpermission.util.HxGenerateId;
import com.icinfo.plugin.interceptor.JstlSupport;
import com.icinfo.plugin.pagination.Pagination;
import com.icinfo.plugin.pagination.context.PaginationContext;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;

/** 
 * 描述: 基础Action类，所有Action类均继承该类<br>
 * @author 胡义振
 * @date 2013-5-10 
 */
public class HxBaseAction extends ActionSupport implements Serializable,JstlSupport
{
	private static final long	serialVersionUID	= -1438364299836612626L;
	Logger logger = Logger.getLogger(HxBaseAction.class);
	// AJAX result view
	public static final String AJAX = "ajax";
	// 分页类
	protected Pagination pagination;
	// AJAX调用时，服务端往客户端传递的数据（Map形式）
	protected Map<String, Object> ajaxResults = new HashMap<String, Object>();
	//普通调用时，服务端往客户端传的数据
	protected Map<String, Object> jstlResults = new HashMap<String, Object>();
	
	
	/**
	 * 描述：获取项目路径
	 * 
	 * @author zhuyong
	 * @date 2015-11-16
	 * @return
	 */
	public String doGetRealPath(){
		return ServletActionContext.getServletContext().getRealPath("/").replace('\\', '/');
	}
	
	/**
	 * 描述：直接跳转
	 * 
	 * @author 朱勇
	 * @date 2015-08-11
	 * @return
	 */
	public String doSkipAction(){
		return SUCCESS;
	}
	
	/**
	 * 
	 * 描述: 添加jstlResults对象
	 * @auther 夏俊伟
	 * @date Apr 2, 2015
	 * @param key
	 * @param value
	 */
	public void addJstlResults(String key,Object value){
		jstlResults.put(key, value);
	}
	@Override
	public Map<String, Object> getJstlResults() {
		return jstlResults;
	}
	@Override
	public void removeJstlResults() {
		jstlResults.clear();
	}

	
	/**
	 * 描述：获取系统登录用户
	 * 
	 * @author 朱勇
	 * @date 2015-4-13
	 * @return
	 */
	public SysUser doGetSysUser(){
		return (SysUser)doGetSession(HxConstants.SESSION_USER);
	}
	
	/**
     * 描述: 添加 ajaxResults 对象
     * @auther 胡义振
     * @date 2014-10-14 
     * @param key
     * @param value
     */
	public void addAjaxResults(String key, Object value){
		getAjaxResults().put(key, value);
	}
	
	/**
	 * 描述: 获取 request 请求中的参数 （含分页）
	 * @auther 胡义振
	 * @date 2014-10-13 
	 * @return
	 */
	protected Map<String, Object> doGetRequestMap() {
        Map<String,String> qryMap =  HxRequestUtil.getAllParam(doGetRequst());
		Map<String, Object> tempMap = new HashMap<String, Object>();
		tempMap.putAll(qryMap);
		//附加分页参数
        if (pagination != null)
		{
        	tempMap.put("maxResult", pagination.getMaxResult());
        	tempMap.put("skipResult", pagination.getSkipResult());
        	
        	if(pagination.getPageSize()>10000){
        	    tempMap.put("pageSize", 10000);
        	}
        	else{
        		tempMap.put("pageSize", pagination.getPageSize());
        	}
		}
		else
		{
			tempMap.put("maxResult", HxConstants.PAGINATION_DEFAULT_MAX_RESULT);
			tempMap.put("skipResult", HxConstants.PAGINATION_DEFAULT_SKIP_RESULT);
			tempMap.put("pageSize", HxConstants.PAGINATION_DEFAULT_MAX_RESULT);
		}
		return tempMap;
    }
	
	
	/** 
	 * 描述: 分页参数处理
	 * @auther gqf
	 * @date 2015年4月9日 
	 * @param context
	 * @return 
	 */
	
	protected  PaginationContext  doGetContextRequestMap(){
		    PaginationContext contextTemp = new PaginationContext(ServletActionContext.getRequest());
		    contextTemp.setNavigationTemplate("pagination.ftl");
		    contextTemp.setPageSize(5);
		return contextTemp;
	}
	/**
     * Desc: 通过反射机制来将pojo类反射成<k,v>的map
     *
     * @param qryMap
     * @param reason
     * @throws IllegalAccessException
     */
    protected Map<String, Object> doGetPojoMap(final Object pojo, Map<String, Object> qryMap)
            throws Exception {
        Map<String, Object> pojoMap = new HashMap<String, Object>();
        if (pojo != null) {
            Field[] fldArr = pojo.getClass().getDeclaredFields();
            for (Field fld : fldArr) {
                fld.setAccessible(Boolean.TRUE);
                if (fld.get(pojo) != null
                        && fld.getType().getName().equals("java.lang.String")) {
                    if (doGetRequst().getMethod().equals("POST")) {
                        if (fld.get(pojo) != null) {
                            pojoMap.put(fld.getName(), URLDecoder.decode(fld
                                    .get(pojo).toString(), "utf-8"));
                        }
                    } else {
                        pojoMap.put(fld.getName(), fld.get(pojo));
                    }
                } else {
                    pojoMap.put(fld.getName(), fld.get(pojo));
                }
            }
        }
        pojoMap.putAll(qryMap);
        return pojoMap;
    }

    /**
     * 描述: 生成ID
     * @auther 胡义振
     * @date 2014-10-11 
     * @return
     */
    public String doGetGenerateId(){
    	return HxGenerateId.getGenerateId(this.doGetRequst());
    }
    
	/**
	 * 描述: 获取Request对象
	 * @auther 胡义振
	 * @date 2013-5-10 
	 * @return 
	 */
	protected HttpServletRequest doGetRequst()
	{
		return ServletActionContext.getRequest();
	}
	
	/**
	 * 描述: 获取Response对象
	 * @auther 胡义振
	 * @date 2013-5-10 
	 * @return 
	 */
	protected HttpServletResponse doGetResponse()
	{
		return ServletActionContext.getResponse();
	}
	
	/**
	 * 描述: 获取User Session对象
	 * @auther 胡义振
	 * @date 2013-5-29 
	 * @param key session键
	 * @return
	 */
    public Object doGetSession(String key)
	{
    	return (Object) ServletActionContext.getRequest().getSession().getAttribute(key);
	}
    
    /**
     * desc:生成ID
     * 
     * @author zhuyong
     * @date 20150906
     * @return
     */
	public String getGenerateId(){
		return UUID.randomUUID().toString().replaceAll("-","").toUpperCase(); 
	}

    /**
     * 描述: 设置Session值
     * @auther 胡义振
     * @date 2013-5-29 
     * @param key session键
     * @param obj session值
     */
	public void doSetSession(String key,Object object)
	{
		ServletActionContext.getRequest().getSession().setAttribute(key, object);
	}
	
    /**
     * 描述: 注销Session值
     * @auther 胡义振
     * @date 2013-5-31 
     * @param key session键
     */
	public void doRemoveSession(String key)
	{
		ServletActionContext.getRequest().getSession().removeAttribute(key); 
	}


    /**
     * 描述: 打印出  request 中错误的数据类型
     * @auther 胡义振
     * @date 2014-10-14
     */
    @SuppressWarnings("unchecked")
	public void validate() {
        ValueStack vc = ActionContext.getContext().getValueStack();
        Map<String, String[]> ferrors = (Map<String, String[]>) vc.findValue("fieldErrors");
        for (Map.Entry<String, String[]> entry : ferrors.entrySet()) {
        	logger.info("\n  验证失败 key:" + entry.getKey() + "  value:" + entry.getValue());
        }
    }

	
	public Pagination getPagination() {
		return pagination;
	}

	public void setPagination(Pagination pagination) {
		this.pagination = pagination;
	}

	public Map<String, Object> getAjaxResults() {
		return ajaxResults;
	}
	public void setAjaxResults(Map<String, Object> ajaxResults)	{
		this.ajaxResults = ajaxResults;
	}


}
