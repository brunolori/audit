package com.bvlsh.audit.dao.sql;

import java.util.Date;

public class DossierSQL {

	Date fromDate;
	Date toDate;
	String dossierNo;
	String auditingStatusCode;
	String riskLevelCode;
	Integer structureId;
	Integer userId;
	Integer firstResult;
	Integer maxResult;

	public Date getFromDate() {
		return fromDate;
	}

	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}

	public Date getToDate() {
		return toDate;
	}

	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}

	public String getDossierNo() {
		return dossierNo;
	}

	public void setDossierNo(String dossierNo) {
		this.dossierNo = dossierNo;
	}

	public String getAuditingStatusCode() {
		return auditingStatusCode;
	}

	public void setAuditingStatusCode(String auditingStatusCode) {
		this.auditingStatusCode = auditingStatusCode;
	}

	public String getRiskLevelCode() {
		return riskLevelCode;
	}

	public void setRiskLevelCode(String riskLevelCode) {
		this.riskLevelCode = riskLevelCode;
	}

	public Integer getStructureId() {
		return structureId;
	}

	public void setStructureId(Integer structureId) {
		this.structureId = structureId;
	}

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Integer getFirstResult() {
		return firstResult;
	}

	public void setFirstResult(Integer firstResult) {
		this.firstResult = firstResult;
	}

	public Integer getMaxResult() {
		return maxResult;
	}

	public void setMaxResult(Integer maxResult) {
		this.maxResult = maxResult;
	}
	
	

	@Override
	public String toString() {
		return "DossierSQL [" + (fromDate != null ? "fromDate=" + fromDate + ", " : "")
				+ (toDate != null ? "toDate=" + toDate + ", " : "")
				+ (dossierNo != null ? "dossierNo=" + dossierNo + ", " : "")
				+ (auditingStatusCode != null ? "auditingStatusCode=" + auditingStatusCode + ", " : "")
				+ (riskLevelCode != null ? "riskLevelCode=" + riskLevelCode + ", " : "")
				+ (structureId != null ? "structureId=" + structureId + ", " : "")
				+ (userId != null ? "userId=" + userId + ", " : "")
				+ (firstResult != null ? "firstResult=" + firstResult + ", " : "")
				+ (maxResult != null ? "maxResult=" + maxResult : "") + "]";
	}

	
	
	
	
	
	
}