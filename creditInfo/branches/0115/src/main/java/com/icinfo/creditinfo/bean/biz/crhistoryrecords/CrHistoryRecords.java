/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-10-12
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.biz.crhistoryrecords;

import java.io.Serializable;
import java.util.Date;

/** 
 * 描述: 浏览记录 实体类<br>
 * @author yulirong
 * @date 2015-10-12
 * 
 */
public class CrHistoryRecords implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private String id;
    // 内部序号
    private String hisCorpid;
    // 企业名称
    private String hisEntName;
    // 注册号
    private String hisRegNo;
    // 法定代表人
    private String hisLegRep;
    // 登记机关
    private String hisRegOrg;
    // 用户ID
    private String hisUserId;
    // 浏览时间
    private Date hisViewTime;
    // 浏览日期
    private Date hisViewDate;
    // 操作时间
    private Date hisOptTime;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public String getHisCorpid() {
        return hisCorpid;
    }
    public void setHisCorpid(String hisCorpid) {
        this.hisCorpid = hisCorpid;
    }


    public String getHisEntName() {
        return hisEntName;
    }
    public void setHisEntName(String hisEntName) {
        this.hisEntName = hisEntName;
    }


    public String getHisRegNo() {
        return hisRegNo;
    }
    public void setHisRegNo(String hisRegNo) {
        this.hisRegNo = hisRegNo;
    }


    public String getHisLegRep() {
        return hisLegRep;
    }
    public void setHisLegRep(String hisLegRep) {
        this.hisLegRep = hisLegRep;
    }


    public String getHisRegOrg() {
        return hisRegOrg;
    }
    public void setHisRegOrg(String hisRegOrg) {
        this.hisRegOrg = hisRegOrg;
    }


    public String getHisUserId() {
        return hisUserId;
    }
    public void setHisUserId(String hisUserId) {
        this.hisUserId = hisUserId;
    }


    public Date getHisViewTime() {
        return hisViewTime;
    }
    public void setHisViewTime(Date hisViewTime) {
        this.hisViewTime = hisViewTime;
    }


    public Date getHisViewDate() {
        return hisViewDate;
    }
    public void setHisViewDate(Date hisViewDate) {
        this.hisViewDate = hisViewDate;
    }


    public Date getHisOptTime() {
        return hisOptTime;
    }
    public void setHisOptTime(Date hisOptTime) {
        this.hisOptTime = hisOptTime;
    }

}
