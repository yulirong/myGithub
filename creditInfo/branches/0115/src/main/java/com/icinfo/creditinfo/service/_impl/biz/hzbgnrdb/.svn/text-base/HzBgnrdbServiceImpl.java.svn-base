/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-10-31
 * @version 1.0
 */
package com.icinfo.creditinfo.service._impl.biz.hzbgnrdb;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.icinfo.creditinfo.bean.biz.crentbaseinfo.CrEntBaseInfo;
import com.icinfo.creditinfo.bean.biz.hzbgnrdb.HzBgnrdb;
import com.icinfo.creditinfo.bean.biz.hzbgnrdb.RegCapHistory;
import com.icinfo.creditinfo.bean.biz.hzbgnrdb.RegCapItem;
import com.icinfo.creditinfo.dao.biz.hzbgnrdb.HzBgnrdbDao;
import com.icinfo.plugin.common.HxDateUtil;
import com.icinfo.plugin.hxbasedaoservice.service._impl.HxBaseServiceImpl;
import com.icinfo.creditinfo.service.biz.hzbgnrdb.HzBgnrdbService;
/**
 * 
 * 描述: 变更记录 Service 实现<br>
 * @author zhuyong
 * @date 2015-10-31
 */
public class HzBgnrdbServiceImpl extends HxBaseServiceImpl<HzBgnrdb> implements HzBgnrdbService
{
	/**
	 * 描述：获取注册资本和股东变更历史
	 * 
	 * @author zhuyong
	 * @param qrymapMap
	 * @return
	 * @throws Exception
	 */
	public List<RegCapHistory> doGetRegCapHisList(Map<String,Object> qryMap) throws Exception{
		return doGetHzBgnrdbDao().doGetRegCapHisList(qryMap);
	}
	
	/**
	 * 描述：获取注册资本和股东变更历史总和
	 * 
	 * @author zhuyong
	 * @param qrymapMap
	 * @return
	 * @throws Exception
	 */
	public Integer doGetRegCapHisTotal(Map<String,Object> qryMap) throws Exception{
		return doGetHzBgnrdbDao().doGetRegCapHisTotal(qryMap);
	}
	
	/**
	 * desc:获取返回数据
	 * 
	 * @author zhuyong
	 * @param CrEntBaseInfo
	 * @param bgList
	 * @return
	 * @throws Exception
	 */
	public List<RegCapHistory> doBuildDataList(CrEntBaseInfo baseInfo,List<HzBgnrdb> bgList) throws Exception{
		if(baseInfo.getEntEstDate()==null || baseInfo.getEntRegCap()==null){
			return null;
		}
		List<RegCapHistory> dataList = new ArrayList<RegCapHistory>();
		String estDate = HxDateUtil.dateToString(baseInfo.getEntEstDate(), "yyyy-MM-dd");//成立日期
		BigDecimal regCap = baseInfo.getEntRegCap();//注册资本
		String nowDate = HxDateUtil.dateToString(new Date(),"yyyy-MM-dd");//当天日期
		RegCapHistory his = new RegCapHistory();
		RegCapItem item = new RegCapItem();
		List<RegCapItem> itemList = new ArrayList<RegCapItem>();
		if(bgList==null || bgList.size()==0){
			his.setName(regCap.toString());
			his.setWeight(regCap);
			item.setTime(estDate);
			item.setValue(10);
			itemList.add(item);
			item = new RegCapItem();
			item.setTime(nowDate);
			item.setValue(10);
			itemList.add(item);
			his.setEvolution(itemList);
			dataList.add(his);
			return dataList;
		}
		
		his.setName(doRemoveHZ(bgList.get(0).getBgnr()));
		his.setWeight(new BigDecimal(doRemoveHZ(bgList.get(0).getBgnr())));
		item.setTime(estDate);
		item.setValue(10);
		itemList.add(item);
		item = new RegCapItem();
		item.setTime(HxDateUtil.dateToString(bgList.get(0).getHzrq(),"yyyy-MM-dd"));
		item.setValue(10);
		itemList.add(item);
		his.setEvolution(itemList);
		dataList.add(his);
		for (int i = 0; i < bgList.size(); i++) {
			his = new RegCapHistory();
			item = new RegCapItem();
			itemList = new ArrayList<RegCapItem>();
			his.setName(doRemoveHZ(bgList.get(i).getBghnr()));
			his.setWeight(new BigDecimal(doRemoveHZ(bgList.get(i).getBgnr())));
			item.setTime(HxDateUtil.dateToString(bgList.get(i).getHzrq(),"yyyy-MM-dd"));
			item.setValue(10);
			itemList.add(item);
			item = new RegCapItem();
			if(i==(bgList.size()-1)){
				item.setTime(nowDate);
			}else{
				item.setTime(HxDateUtil.dateToString(bgList.get(i+1).getHzrq(),"yyyy-MM-dd"));
			}
			item.setValue(10);
			itemList.add(item);
			his.setEvolution(itemList);
			dataList.add(his);
		}
		
		return dataList;
	}
	
	/**
	 * 描述：去除变更内容里面的汉字
	 * 
	 * @param param
	 * @return
	 * @throws Exception
	 */
	public String doRemoveHZ(String param) throws Exception{
		StringBuffer buf = new StringBuffer(""); 
		Pattern p = Pattern.compile("[0-9||\\.]");
		Matcher m = p.matcher(param);
		while (m.find()) {
		  buf.append(m.group());
		}
		return buf.toString();
	}
	

	public HzBgnrdbDao doGetHzBgnrdbDao()
	{
		return (HzBgnrdbDao)hxBaseDao;
	}
}
