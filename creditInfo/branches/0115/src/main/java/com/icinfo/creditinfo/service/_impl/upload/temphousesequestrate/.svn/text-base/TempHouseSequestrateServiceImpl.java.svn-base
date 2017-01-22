/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-11
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.upload.temphousesequestrate;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;

import com.icinfo.creditinfo.bean.upload.temphousesequestrate.TempHouseSequestrate;
import com.icinfo.creditinfo.dao.upload.temphousesequestrate.TempHouseSequestrateDao;
import com.icinfo.plugin.common.upfilemsginfo.ExcelFormVerification;
import com.icinfo.plugin.common.upfilemsginfo.UpfileMsgInfo;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.upload.temphousesequestrate.TempHouseSequestrateService;
/**
 * 
 * 描述: 房产查封 Service 实现<br>
 * @author liyafeng
 * @date 2015-11-11
 */
public class TempHouseSequestrateServiceImpl extends HxBaseServiceImpl<TempHouseSequestrate> implements TempHouseSequestrateService
{
	

	public TempHouseSequestrateDao doGetTempHouseSequestrateDao()
	{
		return (TempHouseSequestrateDao)hxBaseDao;
	}
    /**
     * 
     * 描述: 导入房产查封信息
     * @author  yulirong
     * @date 2015年12月23日 
     * @param sheet
     * @return
     * @throws Exception 
     */
	@Override
	public Map<String,Object> doBatchImportTempHouseSequestrateInfo(HSSFSheet sheet,String depName,String depCode) throws Exception {
		List<TempHouseSequestrate> tempHouseSequestrateList=new ArrayList<TempHouseSequestrate>();
		HSSFRow rowTitle = sheet.getRow(0);
		int i=1;
		Row row = sheet.getRow(i);//创建ROW
		int rowNum = sheet.getLastRowNum();
		try {
			if("ZF330682003".equals(depCode)){//建设局
				if (row == null) {
					return UpfileMsgInfo.errMsgInfo(0, "表格内容为空", "");
				}
				while(i<=rowNum){
					if(row.getCell(1) != null && !ExcelFormVerification.isValidDate(row.getCell(1)))
						return UpfileMsgInfo.errMsgInfo(i+1,rowTitle.getCell(1).toString()+"日期格式错误", "");
					if(row.getCell(3) == null || row.getCell(3).toString().equals(""))
						return UpfileMsgInfo.errMsgInfo(i+1,rowTitle.getCell(3).toString()+"不能为空", "");
					if(row.getCell(5) == null || row.getCell(5).toString().equals(""))
						return UpfileMsgInfo.errMsgInfo(i+1,rowTitle.getCell(5).toString()+"不能为空", "");
					if(row.getCell(6) == null || row.getCell(6).toString().equals(""))
						return UpfileMsgInfo.errMsgInfo(i+1,rowTitle.getCell(6).toString()+"不能为空", "");
					if(!ExcelFormVerification.isBlankCell(row.getCell(7))&& !ExcelFormVerification.isValidDate(row.getCell(7)))
						return UpfileMsgInfo.errMsgInfo(i+1,rowTitle.getCell(7).toString()+"日期格式错误", "");
					TempHouseSequestrate tempHouseSequestrate = doSetTempHouseSequestrate(depName, row);
					i++;
					row = sheet.getRow(i);
					tempHouseSequestrateList.add(tempHouseSequestrate);
					} 
			}
			else{
				return UpfileMsgInfo.errMsgInfo(-1, "非所属部门文件", "");
			}
			
		}catch(Exception e){
			return UpfileMsgInfo.errMsgInfo(i+1, "数据格式错误","");
		}
		doGetTempHouseSequestrateDao().insertBatch(tempHouseSequestrateList);
		return UpfileMsgInfo.sucMsgInfo(tempHouseSequestrateList.size(), true);
	}
	
	/**
	 * 
	 * @param depName
	 * @param row
	 * @return
	 */
	private TempHouseSequestrate doSetTempHouseSequestrate(String depName,Row row) {
		TempHouseSequestrate tempHouseSequestrate=new TempHouseSequestrate();
		tempHouseSequestrate.setSequestrateNo(ExcelFormVerification.parseCellValueToString(row.getCell(0)));//查封文号
		tempHouseSequestrate.setSequestrateApplyDate(ExcelFormVerification.parseDateCellToDate(row.getCell(1)));//查封申请日期
		tempHouseSequestrate.setSequestrateLoc(ExcelFormVerification.parseCellValueToString(row.getCell(2)));//查封房屋坐落
		tempHouseSequestrate.setSequestrateApplyName(ExcelFormVerification.parseCellValueToString(row.getCell(3)));//申请查封单位
		tempHouseSequestrate.setState(ExcelFormVerification.parseCellValueToString(row.getCell(4)));//状态
		tempHouseSequestrate.setPropertyOwnerCertNo(ExcelFormVerification.parseCellValueToString(row.getCell(5)));//房产证号
		tempHouseSequestrate.setPropertyOwner(ExcelFormVerification.parseCellValueToString(row.getCell(6)));//被查封单位
		tempHouseSequestrate.setCancelDate(ExcelFormVerification.parseDateCellToDate(row.getCell(7)));//撤销查封日期
		tempHouseSequestrate.setHouseNo(ExcelFormVerification.parseCellValueToString(row.getCell(8)));//房屋编号
		tempHouseSequestrate.setOrgCode(ExcelFormVerification.parseCellValueToString(row.getCell(9)));//被查封单位组织机构代码
		tempHouseSequestrate.setImportFrom(depName);
		tempHouseSequestrate.setImportDate(new Date());
		return tempHouseSequestrate;
	}
}
