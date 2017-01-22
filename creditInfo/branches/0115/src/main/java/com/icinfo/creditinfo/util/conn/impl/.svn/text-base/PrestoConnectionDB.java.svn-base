package com.icinfo.creditinfo.util.conn.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.util.conn.ConnectionDB;


public class PrestoConnectionDB implements ConnectionDB{
	 /** 
     * 数据库驱动类名称 
     */  
    private static final String DRIVER = "com.facebook.presto.jdbc.PrestoDriver";  
  
    /** 
     * 连接字符串 
     */  
    private static final String URLSTR = "jdbc:presto://192.168.1.224:9090";  
  
    /** 
     * 用户名 
     */  
    private static final String USERNAME = "sa";  
  
    /** 
     * 密码 
     */  
    private static final String USERPASSWORD = "111111";  
  
    /** 
     * 创建数据库连接对象 
     */  
    private Connection connnection = null;  
  
    /** 
     * 创建结果集对象 
     */  
    private ResultSet resultSet = null;  
    
    private  Statement stmt = null;
    
    static {  
        try {  
            // 加载数据库驱动程序  
            Class.forName(DRIVER);  
        } catch (ClassNotFoundException e) {  
            System.out.println("加载驱动错误");  
            System.out.println(e.getMessage());  
        }  
    }  
    
    
	/** 
	 * 描述: 建立连接
	 * @auther gqf
	 * @date 2015年10月9日 
	 * @return 
	 */
	@Override
	public Connection getConnection() {
		  try {  
	            // 获取连接  
	            connnection = DriverManager.getConnection(URLSTR, USERNAME,  
	                    USERPASSWORD);
	            connnection.setCatalog("hive");
	        } catch (SQLException e) {  
	            System.out.println(e.getMessage());  
	        }  
	        return connnection;  
	}

	
	
    /** 
     * 描述: SQL 查询将查询结果直接放入ResultSet中 
     * @auther gqf
     * @date 2015年10月9日 
     * @param sql
     * @return 
     */
    
    private ResultSet executeQueryRS(String sql) {  
        try {  
            // 获得连接  
            connnection = this.getConnection();  
            stmt = connnection.createStatement();
            resultSet = stmt.executeQuery(sql);

        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        }   
  
        return resultSet;  
    }  
	/** 
	 * 描述:返回list
	 * @auther gqf
	 * @date 2015年10月9日 
	 * @param sql
	 * @return 
	 */
	@Override
	public List<Object> getObjList(String sql) {
		  // 执行SQL获得结果集
		long time1 = System.currentTimeMillis();
		System.out.print("");
		resultSet = executeQueryRS(sql); 
		long time2 = System.currentTimeMillis();
		System.out.println("executeQueryRS时间:"+(time2-time1));  
        // 创建ResultSetMetaData对象  
        ResultSetMetaData rsmd = null;  
        // 结果集列数  
        int columnCount = 0;  
        try {  
            rsmd = resultSet.getMetaData();  
              
            // 获得结果集列数  
            columnCount = rsmd.getColumnCount();  
        } catch (SQLException e1) {  
            System.out.println(e1.getMessage());  
        }  
        
        // 创建List  
        List<Object> list = new ArrayList<Object>();  
  
        try {  
            // 将ResultSet的结果保存到List中  
            while (resultSet.next()) {  
                Map<String, Object> map = new HashMap<String, Object>();  
                for (int i = 1; i <= columnCount; i++) {  
                    map.put(rsmd.getColumnLabel(i), resultSet.getObject(i));  
                }  
                list.add(map);  
            }  
        } catch (SQLException e) {  
            System.out.println(e.getMessage());  
        } finally {  
            // 关闭所有资源  
            closeAll();  
        } 
        System.out.println("时间2:"+(System.currentTimeMillis()-time2));  
        return list;
	}

	@Override
	public void closeAll() {
		  // 关闭结果集对象  
        if (resultSet != null) {  
            try {  
                resultSet.close();  
            } catch (SQLException e) {  
                System.out.println(e.getMessage());  
            }  
        }  
        //关闭stmt
       if(stmt != null){
    	   try {  
    		   stmt.close();  
           } catch (SQLException e) {  
               System.out.println(e.getMessage());  
           }  
       }
      
        // 关闭Connection 对象  
        if (connnection != null) {  
            try {  
                connnection.close();  
            } catch (SQLException e) {  
                System.out.println(e.getMessage());  
            }  
        }  
		
	}

	
}
