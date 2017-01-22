/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-10-30
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.biz.crcreditdms;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/** 
 * 描述: 信用维度 实体类<br>
 * @author gaotong
 * @date 2015-10-30
 * 
 */
public class CrCreditDms implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private String id;
    // 
    private String corpid;
    // 企业名称
    private String entName;
    // 资本实力得分
    private BigDecimal dmsDim1Score;
    // 资本实力
    private String dmsDim1Comments;
    // 运营能力得分
    private BigDecimal dmsDim2Score;
    // 运营能力解读
    private String dmsDim2Comments;
    // 盈利能力得分
    private BigDecimal dmsDim3Score;
    // 盈利能力解读
    private String dmsDim3Comments;
    // 偿付能力得分
    private BigDecimal dmsDim4Score;
    // 偿付能力 解读
    private String dmsDim4Comments;
    // 发展潜力得分
    private BigDecimal dmsDim5Score;
    // 发展潜力解读
    private String dmsDim5Comments;
    // 总分
    private BigDecimal dmsScore;
    // 解读
    private String dmsComments;
    // 
    private Date dmsDate;
    // 行业
    private String dmsEntTrade;
    // 信用报告编号
    private String reportNum;
    //注册资本
    private BigDecimal dmsRegCap;
    private BigDecimal avgDmsDim1Score;
    private BigDecimal avgDmsDim2Score;
    private BigDecimal avgDmsDim3Score;
    private BigDecimal avgDmsDim4Score;
    private BigDecimal avgDmsDim5Score;
    private BigDecimal avgDmsScore;
    

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public String getCorpid() {
        return corpid;
    }
    public void setCorpid(String corpid) {
        this.corpid = corpid;
    }


    public String getEntName() {
        return entName;
    }
    public void setEntName(String entName) {
        this.entName = entName;
    }


    public BigDecimal getDmsDim1Score() {
        return dmsDim1Score;
    }
    public void setDmsDim1Score(BigDecimal dmsDim1Score) {
        this.dmsDim1Score = dmsDim1Score;
    }


    public String getDmsDim1Comments() {
        return dmsDim1Comments;
    }
    public void setDmsDim1Comments(String dmsDim1Comments) {
        this.dmsDim1Comments = dmsDim1Comments;
    }


    public BigDecimal getDmsDim2Score() {
        return dmsDim2Score;
    }
    public void setDmsDim2Score(BigDecimal dmsDim2Score) {
        this.dmsDim2Score = dmsDim2Score;
    }


    public String getDmsDim2Comments() {
        return dmsDim2Comments;
    }
    public void setDmsDim2Comments(String dmsDim2Comments) {
        this.dmsDim2Comments = dmsDim2Comments;
    }


    public BigDecimal getDmsDim3Score() {
        return dmsDim3Score;
    }
    public void setDmsDim3Score(BigDecimal dmsDim3Score) {
        this.dmsDim3Score = dmsDim3Score;
    }


    public String getDmsDim3Comments() {
        return dmsDim3Comments;
    }
    public void setDmsDim3Comments(String dmsDim3Comments) {
        this.dmsDim3Comments = dmsDim3Comments;
    }


    public BigDecimal getDmsDim4Score() {
        return dmsDim4Score;
    }
    public void setDmsDim4Score(BigDecimal dmsDim4Score) {
        this.dmsDim4Score = dmsDim4Score;
    }


    public String getDmsDim4Comments() {
        return dmsDim4Comments;
    }
    public void setDmsDim4Comments(String dmsDim4Comments) {
        this.dmsDim4Comments = dmsDim4Comments;
    }


    public BigDecimal getDmsDim5Score() {
        return dmsDim5Score;
    }
    public void setDmsDim5Score(BigDecimal dmsDim5Score) {
        this.dmsDim5Score = dmsDim5Score;
    }


    public String getDmsDim5Comments() {
        return dmsDim5Comments;
    }
    public void setDmsDim5Comments(String dmsDim5Comments) {
        this.dmsDim5Comments = dmsDim5Comments;
    }

    public BigDecimal getDmsScore() {
		return dmsScore;
	}
	public void setDmsScore(BigDecimal dmsScore) {
		this.dmsScore = dmsScore;
	}
	public String getDmsComments() {
		return dmsComments;
	}
	public void setDmsComments(String dmsComments) {
		this.dmsComments = dmsComments;
	}
	public Date getDmsDate() {
        return dmsDate;
    }
    public void setDmsDate(Date dmsDate) {
        this.dmsDate = dmsDate;
    }


    public String getDmsEntTrade() {
        return dmsEntTrade;
    }
    public void setDmsEntTrade(String dmsEntTrade) {
        this.dmsEntTrade = dmsEntTrade;
    }


    public String getReportNum() {
        return reportNum;
    }
    public void setReportNum(String reportNum) {
        this.reportNum = reportNum;
    }
	public BigDecimal getAvgDmsDim1Score() {
		return avgDmsDim1Score.setScale(2,BigDecimal.ROUND_HALF_UP);
	}
	public void setAvgDmsDim1Score(BigDecimal avgDmsDim1Score) {
		this.avgDmsDim1Score = avgDmsDim1Score;
	}
	public BigDecimal getAvgDmsDim2Score() {
		return avgDmsDim2Score.setScale(2,BigDecimal.ROUND_HALF_UP);
	}
	public void setAvgDmsDim2Score(BigDecimal avgDmsDim2Score) {
		this.avgDmsDim2Score = avgDmsDim2Score;
	}
	public BigDecimal getAvgDmsDim3Score() {
		return avgDmsDim3Score.setScale(2,BigDecimal.ROUND_HALF_UP);
	}
	public void setAvgDmsDim3Score(BigDecimal avgDmsDim3Score) {
		this.avgDmsDim3Score = avgDmsDim3Score;
	}
	public BigDecimal getAvgDmsDim4Score() {
		return avgDmsDim4Score.setScale(2,BigDecimal.ROUND_HALF_UP);
	}
	public void setAvgDmsDim4Score(BigDecimal avgDmsDim4Score) {
		this.avgDmsDim4Score = avgDmsDim4Score;
	}
	public BigDecimal getAvgDmsDim5Score() {
		return avgDmsDim5Score.setScale(2,BigDecimal.ROUND_HALF_UP);
	}
	public void setAvgDmsDim5Score(BigDecimal avgDmsDim5Score) {
		this.avgDmsDim5Score = avgDmsDim5Score;
	}
	public BigDecimal getDmsRegCap() {
		return dmsRegCap;
	}
	public void setDmsRegCap(BigDecimal dmsRegCap) {
		this.dmsRegCap = dmsRegCap;
	}
	public BigDecimal getAvgDmsScore() {
		if(this.avgDmsScore==null){
			return null;
		}
		return avgDmsScore.setScale(2,BigDecimal.ROUND_HALF_UP);
	}
	public void setAvgDmsScore(BigDecimal avgDmsScore) {
		this.avgDmsScore = avgDmsScore;
	}
   
}
