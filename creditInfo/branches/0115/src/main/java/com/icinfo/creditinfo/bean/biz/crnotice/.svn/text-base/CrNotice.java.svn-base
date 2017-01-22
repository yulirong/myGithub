/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author yulirong
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.biz.crnotice;

import java.io.Serializable;
import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

/** 
 * 描述: 发布公告 实体类<br>
 * @author yulirong
 * @date 2015-11-12
 * 
 */
public class CrNotice implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private String id;
    // 标题
    private String ticTitle;
    // 内容
    private String ticContent;
    // 发布人
    private String ticMan;
    // 发布部门
    private String ticDepart;
    // 发布日期
    private Date ticDate;
    // 是否有效1：有效
    private String ticStatus;
    //
	private String startTicTime;
	//
	private String endTicTime;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public String getTicTitle() {
        return ticTitle;
    }
    public void setTicTitle(String ticTitle) {
        this.ticTitle = ticTitle;
    }


    public String getTicContent() {
        return ticContent;
    }
    public void setTicContent(String ticContent) {
        this.ticContent = ticContent;
    }


    public String getTicMan() {
        return ticMan;
    }
    public void setTicMan(String ticMan) {
        this.ticMan = ticMan;
    }


    public String getTicDepart() {
        return ticDepart;
    }
    public void setTicDepart(String ticDepart) {
        this.ticDepart = ticDepart;
    }

    @JSON(format = "yyyy-MM-dd")
    public Date getTicDate() {
        return ticDate;
    }
    public void setTicDate(Date ticDate) {
        this.ticDate = ticDate;
    }


    public String getTicStatus() {
        return ticStatus;
    }
    public void setTicStatus(String ticStatus) {
        this.ticStatus = ticStatus;
    }
	public String getStartTicTime() {
		return startTicTime;
	}
	public void setStartTicTime(String startTicTime) {
		this.startTicTime = startTicTime;
	}
	public String getEndTicTime() {
		return endTicTime;
	}
	public void setEndTicTime(String endTicTime) {
		this.endTicTime = endTicTime;
	}

}
