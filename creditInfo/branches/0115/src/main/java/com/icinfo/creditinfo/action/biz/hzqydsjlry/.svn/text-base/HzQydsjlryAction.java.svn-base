/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-23
 * @version 1.0
 */
package com.icinfo.creditinfo.action.biz.hzqydsjlry;

import java.util.List;
import java.util.Map;

import com.icinfo.creditinfo.bean.biz.hzqydsjlry.HzQydsjlry;
import com.icinfo.creditinfo.pagination.AjaxPagination;
import com.icinfo.creditinfo.service.biz.hzqydsjlry.HzQydsjlryService;
import com.icinfo.creditinfo.action.HxBaseAction;
import com.opensymphony.xwork2.Action;
import com.icinfo.plugin.common.AESEUtil;
import com.icinfo.plugin.pagination.context.PaginationContext;

/** 
 * 描述: 高管信息 Action 类<br>
 * @author yulirong
 * @date 2015-10-23
 */
public class HzQydsjlryAction extends HxBaseAction
{
    private static final long    serialVersionUID    = 1L;

    private HzQydsjlryService hzQydsjlryService;
    private HzQydsjlry hzQydsjlry;
    private String[] hzQydsjlryIds;
    private String ajaxUrl;
    private List<HzQydsjlry> hzQydsjlryList;
    private String corpid;

    /**
     * 描述: 查看列表
     * @auther yulirong
     * @date 2015-10-21
     * @return
     * @throws Exception
     */
    public String doReadHzQydsjlryListAction() throws Exception 
    {
        return Action.SUCCESS;
    }

    /**
     * 描述: 高管信息获取
     * @auther yulirong
     * @date 2015-10-21
     * @return
     * @throws Exception
     */
    public String doReadPermissionHzQydsjlryListJSON() throws Exception {
                PaginationContext context = doGetContextRequestMap();
                context.setPageSize(5);
                context.setNavigationTemplate("ajax.ftl");
                context.setPageParamName("pageNo4");
                Map<String,Object> qryMap  = context.getAllRequestMap();
                qryMap.put("nbxh", corpid);
                context.getSkipResult();
                hzQydsjlryList = hzQydsjlryService.doGetHzQydsjlryList(qryMap);
                if(hzQydsjlryList.size()>0){
                for(HzQydsjlry list:hzQydsjlryList){
                	if(list.getSfzjhm() == null) continue;
                	list.setSfzjhm(AESEUtil.encryptContext(list.getSfzjhm()));
                }
                }
                AjaxPagination pagination = new AjaxPagination(hzQydsjlryList,hzQydsjlryService.doGetTotal(qryMap),context);
                pagination.setDataUrl(ajaxUrl);
                pagination.setShowId("ajax4");
                this.addAjaxResults("dataList", pagination.getDataList());
                this.addAjaxResults("skipResult", pagination.getSkipResult());
                this.addAjaxResults("paginationHtml", pagination.getPageHtml());
                return AJAX;
    }

    public HzQydsjlryService getHzQydsjlryService() {
        return hzQydsjlryService;
    }

    public void setHzQydsjlryService(HzQydsjlryService hzQydsjlryService) {
        this.hzQydsjlryService = hzQydsjlryService;
    }

    public HzQydsjlry getHzQydsjlry() {
        return hzQydsjlry;
    }

    public void setHzQydsjlry(HzQydsjlry hzQydsjlry) {
        this.hzQydsjlry = hzQydsjlry;
    }

    public String[] getHzQydsjlryIds() {
        return hzQydsjlryIds;
    }

    public void setHzQydsjlryIds(String[] hzQydsjlryIds) {
        this.hzQydsjlryIds = hzQydsjlryIds;
    }

    public String getAjaxUrl() {
        return ajaxUrl;
    }

    public void setAjaxUrl(String ajaxUrl) {
        this.ajaxUrl = ajaxUrl;
    }

    public List<HzQydsjlry> getHzQydsjlryList() {
        return hzQydsjlryList;
    }

    public void setHzQydsjlryList(List<HzQydsjlry> hzQydsjlryList) {
        this.hzQydsjlryList = hzQydsjlryList;
    }

    public String getCorpid() {
        return corpid;
    }

    public void setCorpid(String corpid) {
        this.corpid = corpid;
    }





}