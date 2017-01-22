/**
 * Copyright© 2003-2013 浙江汇信科技有限公司, All Rights Reserved <br/>
 * 描述: 业务文件 <br/>
 * @author gaotong
 * @date 2015-11-12
 * @version 1.0
 */
package com.icinfo.creditinfo.bean.upload.tempexecutecase;

import java.io.Serializable;
import java.util.Date;

/** 
 * 描述: 法院执行案件 实体类<br>
 * @author gaotong
 * @date 2015-11-12
 * 
 */
public class TempExecuteCase implements Serializable
{

    private static final long	serialVersionUID	= 1L;

    // 
    private String id;
    // '案件性质
    private String caseNatrue;
    // '案件来源
    private String caseSource;
    // 申请标的
    private String object;
    // 执行费
    private String executeFee;
    // '前审法院
    private String preTrialCourt;
    // 生效裁判案号
    private String effectiveJudgmentNo;
    // 原审承办法官
    private String trialJudge;
    // 案件状态
    private String caseState;
    // 申请执行人
    private String executeApplyName;
    // 被执行人
    private String executedName;
    // 承办部门
    private String undertakeDepart;
    // 承办人
    private String undertaker;
    // 分案日期
    private Date divisionalDate;
    // 分案人
    private String divisionalPeople;
    // 报结日期
    private Date bulletinClosingDate;
    // 结案日期
    private Date closingDate;
    // 结案方式
    private String closingType;
    // 详细结案方式
    private String detailedClosingType;
    // 应执行标的
    private String shouldExecuteObject;
    // 到位标的
    private String executedObject;
    // 执限天数
    private String limitDays;
    // 执行天数
    private String executeDays;
    // 归档日期
    private Date fileDate;
    // 归档人
    private String filePeople;
    // 案号
    private String caseNo;
    // 初执案号
    private String firstCaseNo;
    // 立案人
    private String register;
    // 立案日期
    private Date caseStartDate;
    // 收到材料日期
    private Date receiptDate;
    // 执行依据
    private String executeBasis;
    // 案由
    private String caseCause;
    // 实际案由
    private String realCaseCause;
    // 实际案由
    private String fileSignedPeople;
    // 保管期限
    private String retentionTime;
    // 卷宗册数
    private String fileItems;
    // 恢复结果
    private String recoverResult;
    // 当事人名称
    private String partyName;
    // 执行地位
    private String executeStatus;
    // 公民身份证
    private String idNo;
    // 企业代码
    private String entCode;
    // 法定代表人
    private String legRep;
    // 地址
    private String loc;
    // 联系电话
    private String tel;
    // 文书编号
    private String documentNo;
    // 
    private String importFrom;
    // 
    private Date importDate;
    // 企业内部序号
    private String corpid;


    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }


    public String getCaseNatrue() {
        return caseNatrue;
    }
    public void setCaseNatrue(String caseNatrue) {
        this.caseNatrue = caseNatrue;
    }


    public String getCaseSource() {
        return caseSource;
    }
    public void setCaseSource(String caseSource) {
        this.caseSource = caseSource;
    }


    public String getObject() {
        return object;
    }
    public void setObject(String object) {
        this.object = object;
    }


    public String getExecuteFee() {
        return executeFee;
    }
    public void setExecuteFee(String executeFee) {
        this.executeFee = executeFee;
    }


    public String getPreTrialCourt() {
        return preTrialCourt;
    }
    public void setPreTrialCourt(String preTrialCourt) {
        this.preTrialCourt = preTrialCourt;
    }


    public String getEffectiveJudgmentNo() {
        return effectiveJudgmentNo;
    }
    public void setEffectiveJudgmentNo(String effectiveJudgmentNo) {
        this.effectiveJudgmentNo = effectiveJudgmentNo;
    }


    public String getTrialJudge() {
        return trialJudge;
    }
    public void setTrialJudge(String trialJudge) {
        this.trialJudge = trialJudge;
    }


    public String getCaseState() {
        return caseState;
    }
    public void setCaseState(String caseState) {
        this.caseState = caseState;
    }


    public String getExecuteApplyName() {
        return executeApplyName;
    }
    public void setExecuteApplyName(String executeApplyName) {
        this.executeApplyName = executeApplyName;
    }


    public String getExecutedName() {
        return executedName;
    }
    public void setExecutedName(String executedName) {
        this.executedName = executedName;
    }


    public String getUndertakeDepart() {
        return undertakeDepart;
    }
    public void setUndertakeDepart(String undertakeDepart) {
        this.undertakeDepart = undertakeDepart;
    }


    public String getUndertaker() {
        return undertaker;
    }
    public void setUndertaker(String undertaker) {
        this.undertaker = undertaker;
    }


    public Date getDivisionalDate() {
        return divisionalDate;
    }
    public void setDivisionalDate(Date divisionalDate) {
        this.divisionalDate = divisionalDate;
    }


    public String getDivisionalPeople() {
        return divisionalPeople;
    }
    public void setDivisionalPeople(String divisionalPeople) {
        this.divisionalPeople = divisionalPeople;
    }


    public Date getBulletinClosingDate() {
        return bulletinClosingDate;
    }
    public void setBulletinClosingDate(Date bulletinClosingDate) {
        this.bulletinClosingDate = bulletinClosingDate;
    }


    public Date getClosingDate() {
        return closingDate;
    }
    public void setClosingDate(Date closingDate) {
        this.closingDate = closingDate;
    }


    public String getClosingType() {
        return closingType;
    }
    public void setClosingType(String closingType) {
        this.closingType = closingType;
    }


    public String getDetailedClosingType() {
        return detailedClosingType;
    }
    public void setDetailedClosingType(String detailedClosingType) {
        this.detailedClosingType = detailedClosingType;
    }


    public String getShouldExecuteObject() {
        return shouldExecuteObject;
    }
    public void setShouldExecuteObject(String shouldExecuteObject) {
        this.shouldExecuteObject = shouldExecuteObject;
    }


    public String getExecutedObject() {
        return executedObject;
    }
    public void setExecutedObject(String executedObject) {
        this.executedObject = executedObject;
    }


    public String getLimitDays() {
        return limitDays;
    }
    public void setLimitDays(String limitDays) {
        this.limitDays = limitDays;
    }


    public String getExecuteDays() {
        return executeDays;
    }
    public void setExecuteDays(String executeDays) {
        this.executeDays = executeDays;
    }


    public Date getFileDate() {
        return fileDate;
    }
    public void setFileDate(Date fileDate) {
        this.fileDate = fileDate;
    }


    public String getFilePeople() {
        return filePeople;
    }
    public void setFilePeople(String filePeople) {
        this.filePeople = filePeople;
    }


    public String getCaseNo() {
        return caseNo;
    }
    public void setCaseNo(String caseNo) {
        this.caseNo = caseNo;
    }


    public String getFirstCaseNo() {
        return firstCaseNo;
    }
    public void setFirstCaseNo(String firstCaseNo) {
        this.firstCaseNo = firstCaseNo;
    }


    public String getRegister() {
        return register;
    }
    public void setRegister(String register) {
        this.register = register;
    }


    public Date getCaseStartDate() {
        return caseStartDate;
    }
    public void setCaseStartDate(Date caseStartDate) {
        this.caseStartDate = caseStartDate;
    }


    public Date getReceiptDate() {
        return receiptDate;
    }
    public void setReceiptDate(Date receiptDate) {
        this.receiptDate = receiptDate;
    }


    public String getExecuteBasis() {
        return executeBasis;
    }
    public void setExecuteBasis(String executeBasis) {
        this.executeBasis = executeBasis;
    }


    public String getCaseCause() {
        return caseCause;
    }
    public void setCaseCause(String caseCause) {
        this.caseCause = caseCause;
    }


    public String getRealCaseCause() {
        return realCaseCause;
    }
    public void setRealCaseCause(String realCaseCause) {
        this.realCaseCause = realCaseCause;
    }


    public String getFileSignedPeople() {
        return fileSignedPeople;
    }
    public void setFileSignedPeople(String fileSignedPeople) {
        this.fileSignedPeople = fileSignedPeople;
    }


    public String getRetentionTime() {
        return retentionTime;
    }
    public void setRetentionTime(String retentionTime) {
        this.retentionTime = retentionTime;
    }


    public String getFileItems() {
        return fileItems;
    }
    public void setFileItems(String fileItems) {
        this.fileItems = fileItems;
    }


    public String getRecoverResult() {
        return recoverResult;
    }
    public void setRecoverResult(String recoverResult) {
        this.recoverResult = recoverResult;
    }


    public String getPartyName() {
        return partyName;
    }
    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }


    public String getExecuteStatus() {
        return executeStatus;
    }
    public void setExecuteStatus(String executeStatus) {
        this.executeStatus = executeStatus;
    }


    public String getIdNo() {
        return idNo;
    }
    public void setIdNo(String idNo) {
        this.idNo = idNo;
    }


    public String getEntCode() {
        return entCode;
    }
    public void setEntCode(String entCode) {
        this.entCode = entCode;
    }


    public String getLegRep() {
        return legRep;
    }
    public void setLegRep(String legRep) {
        this.legRep = legRep;
    }


    public String getLoc() {
        return loc;
    }
    public void setLoc(String loc) {
        this.loc = loc;
    }


    public String getTel() {
        return tel;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }


    public String getDocumentNo() {
        return documentNo;
    }
    public void setDocumentNo(String documentNo) {
        this.documentNo = documentNo;
    }


    public String getImportFrom() {
        return importFrom;
    }
    public void setImportFrom(String importFrom) {
        this.importFrom = importFrom;
    }


    public Date getImportDate() {
        return importDate;
    }
    public void setImportDate(Date importDate) {
        this.importDate = importDate;
    }


    public String getCorpid() {
        return corpid;
    }
    public void setCorpid(String corpid) {
        this.corpid = corpid;
    }

}
