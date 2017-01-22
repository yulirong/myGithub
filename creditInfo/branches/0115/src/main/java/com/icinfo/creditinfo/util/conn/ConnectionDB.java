package com.icinfo.creditinfo.util.conn;

import java.sql.Connection;
import java.util.List;

public interface ConnectionDB {

    /** 
     * 描述: 获取连接
     * @auther gqf
     * @date 2015年10月9日 
     * @return 
     */
    
    public Connection getConnection();
    
    /** 
     * 描述: 获取list列表
     * @auther gqf
     * @date 2015年10月9日 
     * @param sql
     * @return 
     */
    
    public List<Object> getObjList(String sql);
    
    /** 
     * 描述: 关闭资源
     * @auther gqf
     * @date 2015年10月9日  
     */
    public void closeAll();
}
