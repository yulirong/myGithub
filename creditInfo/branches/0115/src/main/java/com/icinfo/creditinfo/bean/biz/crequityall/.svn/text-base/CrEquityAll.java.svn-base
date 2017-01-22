/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-10-26
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.biz.crequityall;

import java.io.Serializable;
import java.util.Date;

import org.apache.struts2.json.annotations.JSON;

/** 
 * 描述: 出质信息 实体类<br>
 * @author gaotong
 * @date 2015-10-26
 * 
 */
public class CrEquityAll implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private String id;
    // 
    private String nbxh;
    // 
    private String xh;
    // 登记编号
    private String zqdjbh;
    // 出资人
    private String czrxm;
    // 证件号
    private String czrzzhm;
    // 出资股权数额（万元）
    private String czgqse;
    // 质权人
    private String zqrxm;
    // 证件号
    private String zqrzzhm;
    // 股权出资登记日
    private Date barq;
    // 
    private String zt;
    // 
    private Date slrq;
    // 
    private String zxyy;
    // 
    private String equitySource;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public String getNbxh() {
        return nbxh;
    }
    public void setNbxh(String nbxh) {
        this.nbxh = nbxh;
    }


    public String getXh() {
        return xh;
    }
    public void setXh(String xh) {
        this.xh = xh;
    }


    public String getZqdjbh() {
        return zqdjbh;
    }
    public void setZqdjbh(String zqdjbh) {
        this.zqdjbh = zqdjbh;
    }


    public String getCzrxm() {
        return czrxm;
    }
    public void setCzrxm(String czrxm) {
        this.czrxm = czrxm;
    }


    public String getCzrzzhm() {
        return czrzzhm;
    }
    public void setCzrzzhm(String czrzzhm) {
        this.czrzzhm = czrzzhm;
    }


    public String getCzgqse() {
        return czgqse;
    }
    public void setCzgqse(String czgqse) {
        this.czgqse = czgqse;
    }


    public String getZqrxm() {
        return zqrxm;
    }
    public void setZqrxm(String zqrxm) {
        this.zqrxm = zqrxm;
    }


    public String getZqrzzhm() {
        return zqrzzhm;
    }
    public void setZqrzzhm(String zqrzzhm) {
        this.zqrzzhm = zqrzzhm;
    }

    @JSON(format = "yyyy年MM月dd日")
    public Date getBarq() {
        return barq;
    }
    public void setBarq(Date barq) {
        this.barq = barq;
    }


    public String getZt() {
    	if ("B".equals(this.zt)){
    		return "变更";
    	}
    	if ("C".equals(this.zt)){
    		return "撤销";
    	}
    	if ("X".equals(this.zt)){
    		return "注销";
    	}
        return "开业";
    }
    public void setZt(String zt) {
        this.zt = zt;
    }


    public Date getSlrq() {
        return slrq;
    }
    public void setSlrq(Date slrq) {
        this.slrq = slrq;
    }


    public String getZxyy() {
        return zxyy;
    }
    public void setZxyy(String zxyy) {
        this.zxyy = zxyy;
    }


    public String getEquitySource() {
        return equitySource;
    }
    public void setEquitySource(String equitySource) {
        this.equitySource = equitySource;
    }

}
