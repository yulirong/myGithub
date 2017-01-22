package com.icinfo.plugin.util.hxdicutil;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * DESC:connection database 
 * 
 * @author zhuyong
 * @date 2015-10-21
 */
public class DBConnUtil {
    static {
        try {
            DriverManager.registerDriver((Driver)Class.forName(PropertiesUtil.getSpringProperty("driverClass")).newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * desc:get db connection
     * 
     * @author zhuyong
     * @return
     * @throws SQLException
     */
    public static Connection getConnection() throws SQLException {
        Properties props =new Properties();
        props.put("remarksReporting","true");
        props.put("user",PropertiesUtil.getSpringProperty("user"));
        props.put("password",PropertiesUtil.getSpringProperty("password"));
        Connection conn = DriverManager.getConnection(PropertiesUtil.getSpringProperty("jdbcUrl"),props);
        return conn;
    }
    
    /**
     * desc:close db connection
     * 
     * @author zhuyong
     * @date 2015-11-18
     * @param conn
     */
    public static void closeConnection(Connection conn){
    	if(conn!=null){
	    	try {
	    		conn.close();
			} catch (SQLException e) {
				System.out.println("数据库关闭出现异常："+e.getMessage());
				e.printStackTrace();
			}
    	}
    }
}
