package com.icinfo.plugin.util.hxdicutil;
import java.io.File;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import com.icinfo.plugin.hxcodebuild.generator.bean.TableColumnInfo;
/**
 * desc:creat excel
 * 
 * @author zhuyong
 */
public class ExcelUtil {
	
	/**
	 * desc: runexe
	 * 
	 * @author zhuyong
	 */
	public static void runExe(){
		Connection conn = null;
		try {
			String tableName = DBOptUtil.getTableName();
			if (StringUtils.isBlank(tableName) || tableName.toUpperCase().equals("ALL")) {//output all table dic for one database
				String schema = null;
				DatabaseMetaData dbmd = null;
				conn = DBConnUtil.getConnection();
				if(PropertiesUtil.getSpringProperty("schema")!=null){
					schema = PropertiesUtil.getSpringProperty("schema").toUpperCase();
				}
				else{
					schema = PropertiesUtil.getSpringProperty("user").toUpperCase();
				}
				dbmd = conn.getMetaData();
				String[] types = {"TABLE"};  
				ResultSet rs = dbmd.getTables(null, schema, "%", types); 
				while(rs.next()){         
					buildHxDic(rs.getString(3));              
			    }
			}else{
				buildHxDic(tableName);//output one table dic
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			DBConnUtil.closeConnection(conn);
		}
	}
	
	/**
	 * desc : get table info and build excel
	 * 
	 * @author zhuyong
	 * @param tableName
	 */
	public static void buildHxDic(String tableName){
		try {
			Map<String, List<TableColumnInfo>> infoMap = DBOptUtil.getTableInfoMap(tableName);
			List<TableColumnInfo> colList = new ArrayList<TableColumnInfo>();//列信息
			for (Entry<String, List<TableColumnInfo>> s : infoMap.entrySet()) {
				colList =  (List<TableColumnInfo>)s.getValue();
			}
			exportExcel(tableName, colList);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * desc:database table export to excel
	 * 
	 * @author zhuyong
	 * @param tableName
	 * @param colList
	 * @throws Exception
	 */
	public static void exportExcel(String tableName,List<TableColumnInfo> colList) throws Exception{
		
        HSSFWorkbook workbook = new HSSFWorkbook();// 声明一个工作薄
        HSSFSheet sheet = workbook.createSheet(tableName); // 生成一个表格
        sheet.setColumnWidth(100,150);
        HSSFRow row_0 = sheet.createRow(0);
        row_0.setHeight((short)400);
        HSSFCell cell_0_0 = row_0.createCell(0);
        cell_0_0.setCellValue("名称");
        HSSFCell cell_0_1 = row_0.createCell(1);
        cell_0_1.setCellValue("字段名称");
        HSSFCell cell_0_2 = row_0.createCell(2);
        cell_0_2.setCellValue("数据类型");
        HSSFCell cell_0_3 = row_0.createCell(3);
        cell_0_3.setCellValue("可为空");
        
        int j = 1;
        for (TableColumnInfo column : colList) {
			HSSFRow row_j = sheet.createRow(j);
			HSSFCell cell_j_0 = row_j.createCell(0);
			cell_j_0.setCellValue(column.getColumnRemarks());
			HSSFCell cell_j_1 = row_j.createCell(1);
			cell_j_1.setCellValue(column.getColumnName());
			HSSFCell cell_j_2 = row_j.createCell(2);
			cell_j_2.setCellValue(doBuildColumnType(column.getColumnType(),column.getSize()));
			HSSFCell cell_j_3 = row_j.createCell(3);
			cell_j_3.setCellValue(column.isNullAble()==false?"N":"");
			j++;
		}
        
		File file =new File("D:\\HXDIC");    
		if  (!file .exists()  && !file .isDirectory()){//如果文件夹不存在则创建               
		    file .mkdir();    
		}  
        FileOutputStream fout = new FileOutputStream("D:/HXDIC/"+tableName+".xls");//将文件存到指定位置   
        workbook.write(fout);  
        fout.close();  
	} 
	
	/**
	 * desc ： build column type
	 * 
	 * @author zhuyong
	 * @date 2015-11-18
	 * @param colType
	 * @param colSize
	 * @return
	 * @throws Exception
	 */
	private static String doBuildColumnType(String colType,int colSize) throws Exception{
		colType = colType.toUpperCase();
		if(colType.equals("DATETIME")||colType.equals("DATE")
				||colType.equals("TIMESTAMP")||colType.equals("TIME")){
			return colType;
		}
		return colType+"("+colSize+")";
	}
}
