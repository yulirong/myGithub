/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author zhuyong
 * @date 2015-10-31
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.biz.hzbgnrdb;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * 描述: 变更记录 实体类<br>
 * @author zhuyong
 * @date 2015-10-31
 * 
 */
public class HzBgnrdb implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private String nbxh;
    // 
    private String seqXh;
    // 
    private String bgsx;
    // 
    private String bgnr;
    // 
    private String bghnr;
    // 
    private BigDecimal bgcs;
    // 
    private Date hzrq;
    // 
    private String wzgf;
    // 
    private String nzgf;
    // 
    private String centralsoftArea;


    public String getNbxh() {
        return nbxh;
    }
    public void setNbxh(String nbxh) {
        this.nbxh = nbxh;
    }


    public String getSeqXh() {
        return seqXh;
    }
    public void setSeqXh(String seqXh) {
        this.seqXh = seqXh;
    }


    public String getBgsx() {
        return bgsx;
    }
    public void setBgsx(String bgsx) {
        this.bgsx = bgsx;
    }


    public String getBgnr() {
        return bgnr;
    }
    public void setBgnr(String bgnr) {
        this.bgnr = bgnr;
    }


    public String getBghnr() {
        return bghnr;
    }
    public void setBghnr(String bghnr) {
        this.bghnr = bghnr;
    }


    public BigDecimal getBgcs() {
        return bgcs;
    }
    public void setBgcs(BigDecimal bgcs) {
        this.bgcs = bgcs;
    }


    public Date getHzrq() {
        return hzrq;
    }
    public void setHzrq(Date hzrq) {
        this.hzrq = hzrq;
    }


    public String getWzgf() {
        return wzgf;
    }
    public void setWzgf(String wzgf) {
        this.wzgf = wzgf;
    }


    public String getNzgf() {
        return nzgf;
    }
    public void setNzgf(String nzgf) {
        this.nzgf = nzgf;
    }


    public String getCentralsoftArea() {
        return centralsoftArea;
    }
    public void setCentralsoftArea(String centralsoftArea) {
        this.centralsoftArea = centralsoftArea;
    }

}
