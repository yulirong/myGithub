/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-11
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.upload.temptaxreportlocal;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.icinfo.creditinfo.bean.upload.temptaxpay.TempTaxPay;
import com.icinfo.creditinfo.bean.upload.temptaxreportlocal.TempTaxReportLocal;
import com.icinfo.creditinfo.dao.upload.temptaxreportlocal.TempTaxReportLocalDao;
import com.icinfo.plugin.common.upfilemsginfo.ExcelFormVerification;
import com.icinfo.plugin.common.upfilemsginfo.UpfileMsgInfo;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.upload.temptaxreportlocal.TempTaxReportLocalService;
/**
 * 
 * 描述: 财务报表 Service 实现<br>
 * @author gaotong
 * @date 2015-11-11
 */
public class TempTaxReportLocalServiceImpl extends HxBaseServiceImpl<TempTaxReportLocal> implements TempTaxReportLocalService
{
	
    /**
     * 
     * 描述: 导入财务报表信息
     * @author  gaotong
     * @date 2015年11月11日 
     * @param sheet
     * @return
     * @throws Exception 
     */
	public Map<String,Object> doBatchImportTempTaxReportLocal(Sheet sheet,String deptName,String deptCode) throws Exception{
		List<TempTaxReportLocal> tempTaxReportLocalList=new ArrayList<TempTaxReportLocal>();
		if("ZF330682002".equals(deptCode)||"ZF330682001".equals(deptCode)){//地税 国税
			Row rowTitle = sheet.getRow(0);//标题行
			int i = 1;
			Row row = sheet.getRow(i);//创建ROW
			int rowNum = sheet.getLastRowNum();
			if (row == null) {
				return UpfileMsgInfo.errMsgInfo(0, "表格内容为空", "");
			}
			try {
				while(i<=rowNum){
				TempTaxReportLocal tempTaxReportLocal=new TempTaxReportLocal();
				if (ExcelFormVerification.isBlankCell(row.getCell(0)))
					return UpfileMsgInfo.errMsgInfo(i+1, "企业名称为空", "");
				/*if(!ExcelFormVerification.isValidDate(row.getCell(3))&&row.getCell(3)!=null){
					return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(3).toString()+"日期格式错误", "");
				}*/
				
				for (int j = 4; j < 100; j++) {
					if(!ExcelFormVerification.isBlankCell(row.getCell(j))&&!ExcelFormVerification.isValidNumber(row.getCell(j))){
						return UpfileMsgInfo.errMsgInfo(i+1, rowTitle.getCell(j).toString()+"数字格式错误", "");
					}
				}
				tempTaxReportLocal.setEntName(ExcelFormVerification.parseCellValueToString(row.getCell(0)));//企业名称
				tempTaxReportLocal.setTaxNo(ExcelFormVerification.parseCellValueToString(row.getCell(1)));//税务登记证
				tempTaxReportLocal.setTableNo(ExcelFormVerification.parseCellValueToString(row.getCell(2)));//表证单书编码
				tempTaxReportLocal.setReportMonth(ExcelFormVerification.parseCellValueToString(row.getCell(3)));//所属年月
				tempTaxReportLocal.setN1(row.getCell(4)==null?null:new BigDecimal(row.getCell(4).getNumericCellValue()));
				tempTaxReportLocal.setN2(row.getCell(5)==null?null:new BigDecimal(row.getCell(5).getNumericCellValue()));
				tempTaxReportLocal.setN3(row.getCell(6)==null?null:new BigDecimal(row.getCell(6).getNumericCellValue()));
				tempTaxReportLocal.setN4(row.getCell(7)==null?null:new BigDecimal(row.getCell(7).getNumericCellValue()));
				tempTaxReportLocal.setN5(row.getCell(8)==null?null:new BigDecimal(row.getCell(8).getNumericCellValue()));
				tempTaxReportLocal.setN6(row.getCell(9)==null?null:new BigDecimal(row.getCell(9).getNumericCellValue()));
				tempTaxReportLocal.setN7(row.getCell(10)==null?null:new BigDecimal(row.getCell(10).getNumericCellValue()));
				tempTaxReportLocal.setN8(row.getCell(11)==null?null:new BigDecimal(row.getCell(11).getNumericCellValue()));
				tempTaxReportLocal.setN9(row.getCell(12)==null?null:new BigDecimal(row.getCell(12).getNumericCellValue()));
				tempTaxReportLocal.setN10(row.getCell(13)==null?null:new BigDecimal(row.getCell(13).getNumericCellValue()));
				tempTaxReportLocal.setN11(row.getCell(14)==null?null:new BigDecimal(row.getCell(14).getNumericCellValue()));
				tempTaxReportLocal.setN12(row.getCell(15)==null?null:new BigDecimal(row.getCell(15).getNumericCellValue()));
				tempTaxReportLocal.setN13(row.getCell(16)==null?null:new BigDecimal(row.getCell(16).getNumericCellValue()));
				tempTaxReportLocal.setN14(row.getCell(17)==null?null:new BigDecimal(row.getCell(17).getNumericCellValue()));
				tempTaxReportLocal.setN15(row.getCell(18)==null?null:new BigDecimal(row.getCell(18).getNumericCellValue()));
				tempTaxReportLocal.setN16(row.getCell(19)==null?null:new BigDecimal(row.getCell(19).getNumericCellValue()));
				tempTaxReportLocal.setN17(row.getCell(20)==null?null:new BigDecimal(row.getCell(20).getNumericCellValue()));
				tempTaxReportLocal.setN18(row.getCell(21)==null?null:new BigDecimal(row.getCell(21).getNumericCellValue()));
				tempTaxReportLocal.setN19(row.getCell(22)==null?null:new BigDecimal(row.getCell(22).getNumericCellValue()));
				tempTaxReportLocal.setN20(row.getCell(23)==null?null:new BigDecimal(row.getCell(23).getNumericCellValue()));
				tempTaxReportLocal.setN21(row.getCell(24)==null?null:new BigDecimal(row.getCell(24).getNumericCellValue()));
				tempTaxReportLocal.setN22(row.getCell(25)==null?null:new BigDecimal(row.getCell(25).getNumericCellValue()));
				tempTaxReportLocal.setN23(row.getCell(26)==null?null:new BigDecimal(row.getCell(26).getNumericCellValue()));
				tempTaxReportLocal.setN24(row.getCell(27)==null?null:new BigDecimal(row.getCell(27).getNumericCellValue()));
				tempTaxReportLocal.setN25(row.getCell(28)==null?null:new BigDecimal(row.getCell(28).getNumericCellValue()));
				tempTaxReportLocal.setN26(row.getCell(29)==null?null:new BigDecimal(row.getCell(29).getNumericCellValue()));
				tempTaxReportLocal.setN27(row.getCell(30)==null?null:new BigDecimal(row.getCell(30).getNumericCellValue()));
				tempTaxReportLocal.setN28(row.getCell(31)==null?null:new BigDecimal(row.getCell(31).getNumericCellValue()));
				tempTaxReportLocal.setN29(row.getCell(32)==null?null:new BigDecimal(row.getCell(32).getNumericCellValue()));
				tempTaxReportLocal.setN30(row.getCell(33)==null?null:new BigDecimal(row.getCell(33).getNumericCellValue()));
				tempTaxReportLocal.setN31(row.getCell(34)==null?null:new BigDecimal(row.getCell(34).getNumericCellValue()));
				tempTaxReportLocal.setN32(row.getCell(35)==null?null:new BigDecimal(row.getCell(35).getNumericCellValue()));
				tempTaxReportLocal.setN33(row.getCell(36)==null?null:new BigDecimal(row.getCell(36).getNumericCellValue()));
				tempTaxReportLocal.setN34(row.getCell(37)==null?null:new BigDecimal(row.getCell(37).getNumericCellValue()));
				tempTaxReportLocal.setN35(row.getCell(38)==null?null:new BigDecimal(row.getCell(38).getNumericCellValue()));
				tempTaxReportLocal.setN36(row.getCell(39)==null?null:new BigDecimal(row.getCell(39).getNumericCellValue()));
				tempTaxReportLocal.setN37(row.getCell(40)==null?null:new BigDecimal(row.getCell(40).getNumericCellValue()));
				tempTaxReportLocal.setN38(row.getCell(41)==null?null:new BigDecimal(row.getCell(41).getNumericCellValue()));
				tempTaxReportLocal.setN39(row.getCell(42)==null?null:new BigDecimal(row.getCell(42).getNumericCellValue()));
				tempTaxReportLocal.setN40(row.getCell(43)==null?null:new BigDecimal(row.getCell(43).getNumericCellValue()));
				tempTaxReportLocal.setN41(row.getCell(44)==null?null:new BigDecimal(row.getCell(44).getNumericCellValue()));
				tempTaxReportLocal.setN42(row.getCell(45)==null?null:new BigDecimal(row.getCell(45).getNumericCellValue()));
				tempTaxReportLocal.setN43(row.getCell(46)==null?null:new BigDecimal(row.getCell(46).getNumericCellValue()));
				tempTaxReportLocal.setN44(row.getCell(47)==null?null:new BigDecimal(row.getCell(47).getNumericCellValue()));
				tempTaxReportLocal.setN45(row.getCell(48)==null?null:new BigDecimal(row.getCell(48).getNumericCellValue()));
				tempTaxReportLocal.setN46(row.getCell(49)==null?null:new BigDecimal(row.getCell(49).getNumericCellValue()));
				tempTaxReportLocal.setN47(row.getCell(50)==null?null:new BigDecimal(row.getCell(50).getNumericCellValue()));
				tempTaxReportLocal.setN48(row.getCell(51)==null?null:new BigDecimal(row.getCell(51).getNumericCellValue()));
				tempTaxReportLocal.setN49(row.getCell(52)==null?null:new BigDecimal(row.getCell(52).getNumericCellValue()));
				tempTaxReportLocal.setN50(row.getCell(53)==null?null:new BigDecimal(row.getCell(53).getNumericCellValue()));
				tempTaxReportLocal.setN51(row.getCell(54)==null?null:new BigDecimal(row.getCell(54).getNumericCellValue()));
				tempTaxReportLocal.setN52(row.getCell(55)==null?null:new BigDecimal(row.getCell(55).getNumericCellValue()));
				tempTaxReportLocal.setN53(row.getCell(56)==null?null:new BigDecimal(row.getCell(56).getNumericCellValue()));
				tempTaxReportLocal.setN54(row.getCell(57)==null?null:new BigDecimal(row.getCell(57).getNumericCellValue()));
				tempTaxReportLocal.setN55(row.getCell(58)==null?null:new BigDecimal(row.getCell(58).getNumericCellValue()));
				tempTaxReportLocal.setN56(row.getCell(59)==null?null:new BigDecimal(row.getCell(59).getNumericCellValue()));
				tempTaxReportLocal.setN57(row.getCell(60)==null?null:new BigDecimal(row.getCell(60).getNumericCellValue()));
				tempTaxReportLocal.setN58(row.getCell(61)==null?null:new BigDecimal(row.getCell(61).getNumericCellValue()));
				tempTaxReportLocal.setN59(row.getCell(63)==null?null:new BigDecimal(row.getCell(62).getNumericCellValue()));
				tempTaxReportLocal.setN60(row.getCell(63)==null?null:new BigDecimal(row.getCell(63).getNumericCellValue()));
				tempTaxReportLocal.setN61(row.getCell(64)==null?null:new BigDecimal(row.getCell(64).getNumericCellValue()));
				tempTaxReportLocal.setN62(row.getCell(65)==null?null:new BigDecimal(row.getCell(65).getNumericCellValue()));
				tempTaxReportLocal.setN63(row.getCell(66)==null?null:new BigDecimal(row.getCell(66).getNumericCellValue()));
				tempTaxReportLocal.setN64(row.getCell(67)==null?null:new BigDecimal(row.getCell(67).getNumericCellValue()));
				tempTaxReportLocal.setN65(row.getCell(68)==null?null:new BigDecimal(row.getCell(68).getNumericCellValue()));
				tempTaxReportLocal.setN66(row.getCell(69)==null?null:new BigDecimal(row.getCell(69).getNumericCellValue()));
				tempTaxReportLocal.setN67(row.getCell(70)==null?null:new BigDecimal(row.getCell(70).getNumericCellValue()));
				tempTaxReportLocal.setN68(row.getCell(71)==null?null:new BigDecimal(row.getCell(71).getNumericCellValue()));
				tempTaxReportLocal.setN69(row.getCell(72)==null?null:new BigDecimal(row.getCell(72).getNumericCellValue()));
				tempTaxReportLocal.setN70(row.getCell(73)==null?null:new BigDecimal(row.getCell(73).getNumericCellValue()));
				tempTaxReportLocal.setN71(row.getCell(74)==null?null:new BigDecimal(row.getCell(74).getNumericCellValue()));
				tempTaxReportLocal.setN72(row.getCell(75)==null?null:new BigDecimal(row.getCell(75).getNumericCellValue()));
				tempTaxReportLocal.setN73(row.getCell(76)==null?null:new BigDecimal(row.getCell(76).getNumericCellValue()));
				tempTaxReportLocal.setN74(row.getCell(77)==null?null:new BigDecimal(row.getCell(77).getNumericCellValue()));
				tempTaxReportLocal.setN75(row.getCell(78)==null?null:new BigDecimal(row.getCell(78).getNumericCellValue()));
				tempTaxReportLocal.setN76(row.getCell(79)==null?null:new BigDecimal(row.getCell(79).getNumericCellValue()));
				tempTaxReportLocal.setN77(row.getCell(80)==null?null:new BigDecimal(row.getCell(80).getNumericCellValue()));
				tempTaxReportLocal.setN78(row.getCell(81)==null?null:new BigDecimal(row.getCell(81).getNumericCellValue()));
				tempTaxReportLocal.setN79(row.getCell(82)==null?null:new BigDecimal(row.getCell(82).getNumericCellValue()));
				tempTaxReportLocal.setN80(row.getCell(83)==null?null:new BigDecimal(row.getCell(83).getNumericCellValue()));
				tempTaxReportLocal.setN81(row.getCell(84)==null?null:new BigDecimal(row.getCell(84).getNumericCellValue()));
				tempTaxReportLocal.setN82(row.getCell(85)==null?null:new BigDecimal(row.getCell(85).getNumericCellValue()));
				tempTaxReportLocal.setN83(row.getCell(86)==null?null:new BigDecimal(row.getCell(86).getNumericCellValue()));
				tempTaxReportLocal.setN84(row.getCell(87)==null?null:new BigDecimal(row.getCell(87).getNumericCellValue()));
				tempTaxReportLocal.setN85(row.getCell(88)==null?null:new BigDecimal(row.getCell(88).getNumericCellValue()));
				tempTaxReportLocal.setN86(row.getCell(89)==null?null:new BigDecimal(row.getCell(89).getNumericCellValue()));
				tempTaxReportLocal.setN87(row.getCell(90)==null?null:new BigDecimal(row.getCell(90).getNumericCellValue()));
				tempTaxReportLocal.setN88(row.getCell(91)==null?null:new BigDecimal(row.getCell(91).getNumericCellValue()));
				tempTaxReportLocal.setN89(row.getCell(92)==null?null:new BigDecimal(row.getCell(92).getNumericCellValue()));
				tempTaxReportLocal.setN90(row.getCell(93)==null?null:new BigDecimal(row.getCell(93).getNumericCellValue()));
				tempTaxReportLocal.setN91(row.getCell(94)==null?null:new BigDecimal(row.getCell(94).getNumericCellValue()));
				tempTaxReportLocal.setN92(row.getCell(95)==null?null:new BigDecimal(row.getCell(95).getNumericCellValue()));
				tempTaxReportLocal.setN93(row.getCell(96)==null?null:new BigDecimal(row.getCell(96).getNumericCellValue()));
				tempTaxReportLocal.setN94(row.getCell(97)==null?null:new BigDecimal(row.getCell(97).getNumericCellValue()));
				tempTaxReportLocal.setN95(row.getCell(98)==null?null:new BigDecimal(row.getCell(98).getNumericCellValue()));
				tempTaxReportLocal.setN96(row.getCell(99)==null?null:new BigDecimal(row.getCell(99).getNumericCellValue()));
				tempTaxReportLocal.setCorpid("");
				tempTaxReportLocalList.add(tempTaxReportLocal);
				i++;
				row = sheet.getRow(i);
				}
			} catch (Exception e) {
				return UpfileMsgInfo.errMsgInfo(i+1, "数据格式错误", "");
	
			}
		}else{
			return UpfileMsgInfo.errMsgInfo(-1, "非所属部门文件", "");
		}	
		List<String> resultList = doGetTempTaxReportLocalDao().insertBatch(tempTaxReportLocalList);
		if(resultList.size()!=0){
			return UpfileMsgInfo.sucMsgInfo(tempTaxReportLocalList.size(), true);
		}else{
			return UpfileMsgInfo.sucMsgInfo(0, false);
		}

	}
	public TempTaxReportLocalDao doGetTempTaxReportLocalDao()
	{
		return (TempTaxReportLocalDao)hxBaseDao;
	}
}
