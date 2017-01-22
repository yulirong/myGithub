package com.icinfo.plugin.util.hxdicutil;


import com.icinfo.plugin.hxcodebuild.generator.bean.TableColumnInfo;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * desc:database opertion
 * 
 * @author zhuyong
 */
public class DBOptUtil {


    /**
     * desc : get table name
     * 
     * @author zhuyong
     * @return
     */
    public static String getTableName() {
        return PropertiesUtil.getProperty("tableName");
    }


    /**
     * desc : get table info (include:1.tableName 2.columnInfoList)
     * 
     * @author zhuyong
     * @return
     * @throws SQLException
     */
	public static Map<String, List<TableColumnInfo>> getTableInfoMap(String tableName) throws SQLException
	{
		Connection conn = null;
		String schema = null;
		DatabaseMetaData dbmd = null;
		Map<String, List<TableColumnInfo>> infoMap = new LinkedHashMap<String, List<TableColumnInfo>>();
		try
		{
			conn = DBConnUtil.getConnection();
			if(PropertiesUtil.getSpringProperty("schema")!=null){
				schema = PropertiesUtil.getSpringProperty("schema").toUpperCase();
			}
			else{
				schema = PropertiesUtil.getSpringProperty("user").toUpperCase();
			}
			
			dbmd = conn.getMetaData();
			List<String> pkColumns = getPrimaryKeys(schema, tableName, dbmd);
			infoMap.put(tableName, getColumnsInfoList(schema, tableName, dbmd, pkColumns));
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (null != conn)
			{
				conn.close();
			}
		}
		return infoMap;
	}
    
    /**
     * desc:get table column info list
     * 
     * @author zhuyong
     * @param schema
     * @param tableName
     * @param dbmd
     * @param pkColumns
     * @return
     * @throws SQLException
     */
    private static List <TableColumnInfo> getColumnsInfoList(String schema, String tableName, DatabaseMetaData dbmd, List <String> pkColumns) throws SQLException {

        List <TableColumnInfo> tblInfoList = null;
        ResultSet rs = null;
        try {
            tblInfoList = new ArrayList <TableColumnInfo>();
            
            rs = dbmd.getColumns(null, schema, tableName, "%");
            
            TableColumnInfo tableColumnInfo = null;
            while (rs.next()) {
                tableColumnInfo = new TableColumnInfo();
                tableColumnInfo.setColumnName(rs.getString("COLUMN_NAME"));
                tableColumnInfo.setColumnType(rs.getString("TYPE_NAME"));
                tableColumnInfo.setSize(rs.getInt("COLUMN_SIZE"));
                tableColumnInfo.setColumnRemarks(rs.getString("REMARKS"));
                tableColumnInfo.setNullAble(0 == rs.getInt("NULLABLE") ? false : true);
                if (pkColumns.contains(tableColumnInfo.getColumnName())) {
                    tableColumnInfo.setPrimaryKey(true);
                }
                tblInfoList.add(tableColumnInfo);
            }
            return tblInfoList;
        } finally {
            if (null != rs) {
                rs.close();
            }
        }
    }

    /**
     * desc :get primarykeys 
     * 
     * @author zhuyong
     * @param schema
     * @param tableName
     * @param dbmd
     * @return
     * @throws SQLException
     */
    private static List <String> getPrimaryKeys(String schema, String tableName, DatabaseMetaData dbmd) throws SQLException {
		ResultSet rs = null;
		List<String> pkColumns = new ArrayList<String>();
		try
		{
			rs = dbmd.getPrimaryKeys(null, schema, tableName);
			while (rs.next())
			{
				pkColumns.add(rs.getString("COLUMN_NAME"));
			}
		}
		finally
		{
			if (null != rs)
			{
				rs.close();
			}
		}
		return pkColumns;
    }

}
