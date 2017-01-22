package com.icinfo.creditinfo.hxservice.impl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.jws.WebService;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.icinfo.creditinfo.bean.biz.crelecpay.CrElecPay;
import com.icinfo.creditinfo.hxservice.JxwDataService;
import com.icinfo.creditinfo.hxservice.dto.crelecpay.CrElecPayDTO;
import com.icinfo.creditinfo.hxservice.dto.crelecpay.CrElecPayDTOWrapper;
import com.icinfo.creditinfo.hxservice.util.BeanUtil;
import com.icinfo.creditinfo.hxservice.util.DealXmlUtils;
import com.icinfo.creditinfo.service.biz.crelecpay.CrElecPayService;
import com.icinfo.plugin.util.TransferUtil;
@WebService(endpointInterface = "com.icinfo.creditinfo.hxservice.JxwDataService") 
public class JxwDataServiceImpl implements JxwDataService {
	private static final Log LOG = LogFactory.getLog(JxwDataServiceImpl.class);
	@Resource
	CrElecPayService crElecPayService;

	/** 
	 * 描述:电力局 接口<br>
	 * @auther gqf
	 * @date 2015年12月24日 
	 * @param startDate
	 * @return 
	 */
	@Override
	public String doGetElecData(String startDate,String begin,String entOrgNo,String year){
		LOG.info("电力公司接口调用开始-----");
		Map<String,Object> qryMap = new HashMap<String, Object>();
		qryMap.put("startDate", startDate);
		//Integer total = crElecPayService.doGetServiceCrElecPayTotal(qryMap);
		qryMap.put("skipResult", begin);
		qryMap.put("pageSize", 100);
		qryMap.put("orgNO", TransferUtil.doSplitStringToSqlFormat(entOrgNo, ","));
		qryMap.put("entYear",year);
		List<CrElecPay> tempCrElecPayList = null;
		CrElecPayDTOWrapper elecPayDtoWrapper = new CrElecPayDTOWrapper();
		try {
		    tempCrElecPayList = crElecPayService.doGetServiceCrElecPayList(qryMap);
			List<CrElecPayDTO> CrElecPayDTOList = doBeanListToDtoList(tempCrElecPayList);
			elecPayDtoWrapper = new CrElecPayDTOWrapper(CrElecPayDTOList);
		} catch (Exception e) {
			LOG.error("电力公司接口异常",e);
		}
		if(tempCrElecPayList == null || tempCrElecPayList.size()==0){
			LOG.info("sorry,请重新输入查询条件！");
			return "-1";
		}
		LOG.info("成功调用电力公司数据接口！读取数据量："+tempCrElecPayList.size());
		return DealXmlUtils.toRequestXml(elecPayDtoWrapper, CrElecPayDTOWrapper.class, false, null);
	}
	
	
	
	/** 
	 * 描述: TODO
	 * @auther gqf
	 * @date 2015年12月29日 
	 * @param crElecPayList
	 * @return
	 * @throws Exception 
	 */
	
	public List<CrElecPayDTO> doBeanListToDtoList(List<CrElecPay> crElecPayList) throws Exception{
		if(crElecPayList == null){
			return null;
		}
		List<CrElecPayDTO> tempDtoList = new ArrayList<CrElecPayDTO>();
		try {
			for(CrElecPay crElecPay:crElecPayList){
				CrElecPayDTO crElecPayDTO =new CrElecPayDTO();
				tempDtoList.add((CrElecPayDTO)BeanUtil.CopyBeanToBean(crElecPay, crElecPayDTO));
			}
		} catch (Exception e) {
			LOG.error("bean转换为DTO错误类JxwDataServiceImpl:"+e.getMessage());
			e.printStackTrace();
		}
		return tempDtoList;
	}
	

	public CrElecPayService getCrElecPayService() {
		return crElecPayService;
	}

	public void setCrElecPayService(CrElecPayService crElecPayService) {
		this.crElecPayService = crElecPayService;
	}
    
	
}
