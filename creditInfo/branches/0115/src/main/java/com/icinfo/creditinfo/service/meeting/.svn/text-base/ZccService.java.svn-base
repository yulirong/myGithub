package com.icinfo.creditinfo.service.meeting;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.relationalnet.CorpNode;
import com.icinfo.creditinfo.bean.meeting.Zcc;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

public interface ZccService extends HxBaseService<Zcc>{
	
	public Map<String, Object> doBuildData(List<Zcc> dataList,String userName) throws Exception;
	
	/** 
	 * 描述: 获取关系节点和关系连线数据
	 * 
	 * @author zhuyong
	 * @date 2015-10-31 
	 * @param entName
	 * @param corpid
	 * @return
	 * @throws Exception 
	 */
	
	public Map<String,Object> doGetNodeAndLink(CorpNode corpNode,Map<String,String> paramMap) throws Exception;
}
