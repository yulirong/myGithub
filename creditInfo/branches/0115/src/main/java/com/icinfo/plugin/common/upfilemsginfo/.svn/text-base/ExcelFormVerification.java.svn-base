package com.icinfo.plugin.common.upfilemsginfo;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.CellRangeAddress;

import com.icinfo.plugin.common.HxDateUtil;

/**
 * 描述：Excel数据格式校验
 * 
 * @author MaYawei
 * @date 2015-12-22
 * 
 */
public class ExcelFormVerification {

	/**
	 * @描述：<br/>判断cell是否可转为数字类型
	 * @author MaYawei
	 * @date 2015-12-22
	 * @param paramCell
	 *            Cell
	 * @return boolean<br/>
	 *         true：数字类型、false:非数字类型
	 */
	public static Boolean isValidNumber(Cell paramCell) {
		boolean flag = false;// true：数字类型 false:非数字类型
		if (isBlankCell(paramCell)) return false;
		try {
			int cellType = paramCell.getCellType();
			if (cellType == 0) {// 数字格式
				double cellVal = paramCell.getNumericCellValue();
				if (!Double.isInfinite(cellVal)) flag = true;
			} else if (cellType == 1) {// 文本格式
				String strCell = paramCell.getStringCellValue();
				if ("e".contains(strCell) || "E".contains(strCell))
					return false;
				if(strCell!=null && "/".equals(strCell.trim()))
					return true;
				double dbl = Double.parseDouble(strCell);
				if (!Double.isInfinite(dbl))flag = true;
			}
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	/**
	 * 描述：<br/>判断cell是否为yyyy/MM/dd日期类型
	 * @author MaYawei
	 * @date 2015-12-22
	 * @param paramCell Cell
	 * @return <br/>
	 *         true：日期类型、false:非日期类型
	 */
	public static Boolean isValidDate(Cell paramCell) {
		if (isBlankCell(paramCell)) return false;
		boolean flag = false;// true：数字类型 false:非数字类型
		try {
			if(paramCell!=null && "/".equals(paramCell.toString().trim()))
				return true;
			Date tempDate = parseCellToDate(paramCell);
			if(tempDate!=null)
				flag = true;
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}
	
	/**
	 * 
	 * 描述: 判断string是否为可以转化为日期格式
	 * @author LiYaFeng
	 * @date 2015年12月28日 
	 * @param partOfCell
	 * @return
	 */
     public static Boolean isStringToDate(String partOfCell){
    	 if (partOfCell == null||"".equals(partOfCell.trim())) return false;
    	 boolean flag = false;//true:日期格式 false:非日期格式
    	 Date tempDate = null;
    	 try {
    		 /*if(partOfCell.contains("-")&&Pattern.compile(".+[0-9]$").matcher(partOfCell).find()
    				 && HxDateUtil.stringToDate(partOfCell, "yyyy-MM-dd")!=null){
    			 flag=true;
    	     }*/
    		 tempDate = HxDateUtil.stringToDate(partOfCell,"yyyy年MM月dd日");
 			if(tempDate==null)
 				tempDate = HxDateUtil.stringToDate(partOfCell,"yyyy-MM-dd");
 			if(tempDate==null)
 				tempDate = HxDateUtil.stringToDate(partOfCell,"yyyy.MM.dd");
 			if(tempDate==null)
 				tempDate = HxDateUtil.stringToDate(partOfCell,"yyyy/MM/dd");
 			if(tempDate!=null)
 				flag = true;
    	 }catch (Exception e) {
 			flag = false;
 		}
    	 return flag;
     }
     
	/**
	 * 描述：日期格式Cell转换为yyyy-MM-dd HH:mm:ss格式的日期字符串
	 * @author MaYawei
	 * @date 2015-12-23
	 * @param paramCell Cell
	 * @return String <br/>yyyy-MM-dd HH:mm:ss格式的日期字符串
	 */
	public static String parseDateCellToString(Cell paramCell){
		if (isBlankCell(paramCell)) return null;
		String dateStr = null;
		try {
			Date tempDate = parseCellToDate(paramCell);
			if(tempDate!=null)
				dateStr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(tempDate);
		} catch (Exception e) {
			dateStr = null;
		}
		return dateStr;
	}

	/**
	 * 描述：将yyyy年MM月dd日，yyyy-MM-dd，yyyy.MM.dd，yyyy/MM/dd格式Cell转换为指定格式format 日期字符串
	 * @author MaYawei
	 * @date 2015-12-23
	 * @param paramCell Cell
	 * @return String <br/>  format格式的日期字符串
	 */
	public static String parseDateCellToString(Cell paramCell,String format){
		
		if (isBlankCell(paramCell)) return null;
		String dateStr = null;
		try {
			Date tempDate = parseCellToDate(paramCell);
			if(tempDate!=null)
				dateStr = new SimpleDateFormat(format).format(tempDate);
		} catch (Exception e) {
			dateStr = null;
		}
		return dateStr;
	}
	
	/**
	 * 描述：将yyyy年MM月dd日，yyyy-MM-dd，yyyy.MM.dd，yyyy/MM/dd格式Cell转换为Date类型
	 * @author MaYawei
	 * @date 2015-12-23
	 * @param paramCell Cell
	 * @return String <br/>yyyy-MM-dd HH:mm:ss格式的日期字符串
	 */
	public static Date parseDateCellToDate(Cell paramCell){
		
		if (isBlankCell(paramCell)) return null;
		Date tempDate = null;
		try {
			tempDate = parseCellToDate(paramCell);
		} catch (Exception e) {
			tempDate = null;
		}
		return tempDate;
	}

	/**
	 * 描述：解析cell成Date
	 * @author MaYawei
	 * @date 2015-12-31
	 * @param paramCell
	 * @param paramDate
	 * @return
	 */
	private static Date parseCellToDate(Cell paramCell) {
		if(isBlankCell(paramCell)) return null;
		Date paramDate = null;
		if (paramCell.getCellType() == 0 && 
				(paramCell.toString().contains("月")||paramCell.toString().contains("-"))){//数值格式 非中文
			paramDate = paramCell.getDateCellValue();
		}else if (paramCell.getCellType() == 0){//数值格式 中文
			paramDate = DateUtil.getJavaDate(paramCell.getNumericCellValue());
		}else if (paramCell.getCellType() == 1){//文本格式
			String cellStrVal = paramCell.getStringCellValue();
			paramDate = HxDateUtil.stringToDate(cellStrVal,"yyyy年MM月dd日");
			if(paramDate==null)
				paramDate = HxDateUtil.stringToDate(cellStrVal,"yyyy-MM-dd");
			if(paramDate==null)
				paramDate = HxDateUtil.stringToDate(cellStrVal,"yyyyMMdd");
			if(paramDate==null)
				paramDate = HxDateUtil.stringToDate(cellStrVal,"yyyy.MM.dd");
			if(paramDate==null)
				paramDate = HxDateUtil.stringToDate(cellStrVal,"yyyy/MM/dd");
			if(paramDate==null)
				paramDate = HxDateUtil.stringToDate(cellStrVal,"yyyy-MM-dd HH:mm:ss");
		}
		return paramDate;
	}
	
	 /**
   * 描述：是否为有效的行政许可 文件
   * @author MaYawei
   * @date 2015-12-23
   * @param row 
   * @return boolean <br/> true:是，false：不是
   */
  public static boolean isValidLicence(Row row){
    if(row==null) return false;
    boolean flag = true;
    String[] titleNameArr = new String[]{"企业名称","工商注册号","许可机关","许可文件编号","许可文件名称",
        "许可有效期限自","许可有效期限至","许可内容","状态","组织机构代码","统一信用代码"};
    for (int i = 0; i < titleNameArr.length; i++) {
      row.getCell(i).toString().contains(titleNameArr[i]);
      if(!row.getCell(i).toString().contains(titleNameArr[i])){
        flag = false;
      }
    }
    return flag;
  }
  
  /**
   * 描述：是否为有效行政处罚 文件
   * @author MaYawei
   * @date 2015-12-23
   * @param row
   * @return boolean <br/> true:是，false：不是
   */
  public static boolean isValidPunish(Row row){
    if(row==null) return false;
    boolean flag = true;
    String[] titleNameArr = new String[]{"所属地区行政区划编码","所属地区名称","执法部门名称",
        "执法部门组织编码","行政处罚决定书文号","案件名称","被处罚对象类别","被处罚对象名称",
        "被处罚对象证件类型","被处罚对象证件号码","被处罚单位法定代表人姓名","被处罚单位法定代表人证件类型",
        "被处罚单位法定代表人证件号","行政处罚权力事项名称","权力内部编码（权力事项唯一码）",
        "对外公开的行政处罚决定书全文或摘要","作出行政处罚的日期","状态标记","撤销处罚的原因说明","涉案金额"};
    for (int i = 0; i < titleNameArr.length; i++) {
      row.getCell(i).toString().contains(titleNameArr[i]);
      if(!row.getCell(i).toString().contains(titleNameArr[i])){
        flag = false;
      }
    }
    return flag;
  }
  
	
	/**
	 * 描述：将Cell的内容转为String。<br/>适用于汉字信息、序号等，<br/>不适用于带小数点的数量 转为String,如123.45
	 * @author MaYawei
	 * @date 2015-12-26
	 * @param cell
	 * @return String
	 */
	public static String parseCellValueToString(Cell cell){
		if(isBlankCell(cell)) return null;
		String str=null;
		try{
			if(cell.getCellType()==0){
				str = String.valueOf(new BigDecimal(cell.getNumericCellValue()).toBigInteger());
			}else if(cell.getCellType()==1){
				str = cell.getStringCellValue();
			}else{
				str = String.valueOf(cell);
			}
		}catch(Exception e){
			str = null;
		}
		//return str;
		return str==null?null:str.trim();
	}
	
	/**
	 * 描述：将Cell的内容转为数字形式的String。<br/>适用于带小数点的数量 转为String,如123.45
	 * @author MaYawei
	 * @date 2015-12-26
	 * @param cell
	 * @return String
	 */
	public static String parseCellValueToNumericString(Cell cell){
		if(isBlankCell(cell)) return null;
		String str=null;
		try{
			if(cell.getCellType()==0){
				str = String.valueOf(cell.getNumericCellValue());
			}else if(cell.getCellType()==1){
				str = cell.getStringCellValue();
				new BigDecimal(str);
			}
		}catch(Exception e){
			str = null;
		}
		return str==null?null:str.trim();
	}
  
	/**
	 * 描述：将Cell的内容转为BigDecimal
	 * @author MaYawei
	 * @date 2015-12-26
	 * @param cell
	 * @return BigDecimal
	 */
	public static BigDecimal parseCellValueToBigDecimal(Cell cell){
		if(isBlankCell(cell)  || cell.toString().equals("/")) return new BigDecimal(0);
		BigDecimal bd;
		try{
			if(cell.getCellType()==0){
				bd =new BigDecimal(cell.getNumericCellValue());
			}else if(cell.getCellType()==1){
				bd = new BigDecimal(cell.getStringCellValue());
			}else{
				bd = new BigDecimal(String.valueOf(cell));
			}
		}catch(Exception e){
			bd = null;
		}
		//return bd==null? null:bd.setScale(2,BigDecimal.ROUND_HALF_UP);//保留两位小数
		return bd;
	}
	
	/**
	 * 描述：判断cell是否为 小于等于 指定长度的字符串
	 * @author MaYawei
	 * @date 2016-01-11
	 * @param paramCell 
	 * @param strLength 指定长度
	 * @return Boolean 
	 */
	public static Boolean isAssignLenStr(Cell paramCell,int strLength){
		if(isBlankCell(paramCell)) return true;
		String str="";
		try{
			if(paramCell.getCellType()==0){
				str = String.valueOf(new BigDecimal(paramCell.getNumericCellValue()).toBigInteger());
			}else if(paramCell.getCellType()==1){
				str = paramCell.getStringCellValue();
			}else{
				str = String.valueOf(paramCell);
			}
		}catch(Exception e){
			
		}
		if(str.length()<=strLength)
			return true;
		else
			return false;
		
	}
	
	
	/**
	 * 描述：判断cell是否为null或空格
	 * @author MaYawei
	 * @date 2016-01-04
	 * @param paramCell
	 * @return boolean<br/>
	 *         true：为空、false:非空
	 */
	public static Boolean isBlankCell(Cell paramCell){
		boolean flag = false;
		if(paramCell==null||"".equals(paramCell.toString().trim()))
				flag = true;
		
		return flag;
	}

	/**
	 * 描述：合并单元格补全处理
	 * @author MaYawei
	 * @date 2016-01-05
	 * @param sheet
	 * @return HSSFSheet
	 */
	public static HSSFSheet getFullCellSheet(HSSFSheet sheet) {
		// 获得 sheet中合并单元格的数量
		int sheetmergerCount = sheet.getNumMergedRegions();
		// 遍历合并单元格
		for (int i = 0; i < sheetmergerCount; i++) {
			//合并单元格补全处理
			CellRangeAddress cra = sheet.getMergedRegion(i);
			int rowFirst = cra.getFirstRow();
			int rowLast = cra.getLastRow();
			int colFirst = cra.getFirstColumn();
			int colLast = cra.getLastColumn();
			for (int j = colFirst; j <= colLast; j++) {
				for (int k = rowFirst; k <= rowLast; k++) {
					HSSFCell cell = sheet.getRow(rowFirst).getCell(colFirst);
					if(cell.getCellType()==0){
						sheet.getRow(k).getCell(j).setCellValue(cell.getNumericCellValue());
					}else{
						sheet.getRow(k).getCell(j).setCellValue(cell.toString());
					}
				}
			}

		}
		return sheet;
	}
}