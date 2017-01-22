/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: TODO <br/>
 * @author 胡义振
 * @date 2013-4-1
 * @version 1.0
 */
package com.icinfo.plugin.exception;

/** 
 * 描述: TODO<br>
 * @author 胡义振
 * @date 2013-4-1 
 * 
 *
 */
public enum ExceptionType
{
    NOT_LOGIN("001","未登陆"),
    DATABASE_EXCEPTION("002","数据库操作异常");
    
    private String gstrExpType;
    private String gstrExpConten;
    
    ExceptionType(String vstrType,String vstrConten){
    	
    	gstrExpType = vstrType;
    	gstrExpConten = vstrConten;
    }

    public static String getExpConten(String vstrType) {  
        for (ExceptionType c : ExceptionType.values()) {  
            if (c.getGstrExpType().equals(vstrType)) {  
                return c.getGstrExpConten();  
            }  
        }  
        return null;  
    }  
    
	public String getGstrExpType()
	{
		return gstrExpType;
	}

	public void setGstrExpType(String gstrExpType)
	{
		this.gstrExpType = gstrExpType;
	}

	public String getGstrExpConten()
	{
		return gstrExpConten;
	}

	public void setGstrExpConten(String gstrExpConten)
	{
		this.gstrExpConten = gstrExpConten;
	}

    
}
