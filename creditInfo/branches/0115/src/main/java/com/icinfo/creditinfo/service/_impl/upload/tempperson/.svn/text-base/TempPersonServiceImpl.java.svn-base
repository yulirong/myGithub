/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author liyafeng
 * @date 2015-11-11
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.upload.tempperson;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.ss.usermodel.Row;

import com.icinfo.creditinfo.bean.upload.tempperson.TempPerson;
import com.icinfo.creditinfo.dao.upload.tempperson.TempPersonDao;
import com.icinfo.plugin.common.upfilemsginfo.UpfileMsgInfo;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.upload.tempperson.TempPersonService;
/**
 * 
 * 描述: 基本信息 Service 实现<br>
 * @author liyafeng
 * @date 2015-11-11
 */
public class TempPersonServiceImpl extends HxBaseServiceImpl<TempPerson> implements TempPersonService
{
	

	public TempPersonDao doGetTempPersonDao()
	{
		return (TempPersonDao)hxBaseDao;
	}
    /**
     * 
     * 描述: 导入基本信息
     * @author  yulirong
     * @date 2015年12月21日 
     * @param sheet
     * @return
     * @throws Exception
     */
	@Override
	public Map<String, Object> doBatchImportTempPersonInfo(HSSFSheet sheet,String depName,String depCode) throws Exception {
		List<TempPerson> tempPersonList=new ArrayList<TempPerson>();
		List<String> certNoList = new ArrayList<String>();
		HSSFRow rowTitle = sheet.getRow(0);
		int i=1;
		Row row = sheet.getRow(i);//创建ROW
		int rowNum = sheet.getLastRowNum();
		if (row == null) {
			return UpfileMsgInfo.errMsgInfo(0, "表格内容为空", "");
		}
		try {
			while(i <= rowNum) {
				TempPerson tempPerson=new TempPerson();
				if(row.getCell(0) == null || row.getCell(0).toString().equals("")){
					return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(0)+"不能为空", "");
				}
				tempPerson.setName(row.getCell(0).toString());//姓名
				tempPerson.setCertType(row.getCell(1) == null ? "" : row.getCell(1).toString());//证件类型
				if(row.getCell(2) == null || row.getCell(2).toString().equals("")){
					return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(2)+"不能为空", "");
				}
				tempPerson.setCertNo(row.getCell(2).toString());//证件号
				if(certNoList.contains(tempPerson.getCertNo())){
					return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(2)+"与前面重复", "");
				}
				tempPerson.setTel(row.getCell(3) == null ? "" : row.getCell(3).toString());//电话
				tempPerson.setAddr(row.getCell(4) == null ? "" : row.getCell(4).toString());//地址
				tempPerson.setSpouseName(row.getCell(5) == null ? "" : row.getCell(5).toString());//配偶姓名
				tempPerson.setSpouseCertType(row.getCell(6) == null ? "" : row.getCell(6).toString());//配偶证件类型
				tempPerson.setSpouseCertNo(row.getCell(7) == null ? "" : row.getCell(7).toString());//配偶证件号
				tempPerson.setImportFrom(depName);
				tempPerson.setImportDate(new Date());
				i++;
				row = sheet.getRow(i);
				tempPersonList.add(tempPerson);
				certNoList.add(tempPerson.getCertNo());
			} 
		}catch (Exception e) {
			return UpfileMsgInfo.errMsgInfo(i+1, "数据格式错误", "");

		}
		 doGetTempPersonDao().insertBatch(tempPersonList);
		return UpfileMsgInfo.sucMsgInfo(tempPersonList.size(), true);
	}
}
