package com.icinfo.creditinfo.service.meeting;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.meeting.NhFateRisk;
import com.icinfo.plugin.hxbasedaoservice.service.HxBaseService;

public interface NhFateRiskService extends HxBaseService<NhFateRisk> {
	public Map<String, Object> doBuildData(List<NhFateRisk> dataList) throws Exception;

}
