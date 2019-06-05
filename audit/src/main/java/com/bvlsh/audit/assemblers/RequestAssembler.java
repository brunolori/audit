package com.bvlsh.audit.assemblers;

import com.bvlsh.audit.api.req.DossierReq;
import com.bvlsh.audit.dao.sql.DossierSQL;

public class RequestAssembler {

	public DossierSQL toSql(DossierReq req) {
		
		if (req == null)
			return null;

		DossierSQL sql = new DossierSQL();

		sql.setFromDate(req.getFromDate());
		sql.setToDate(req.getToDate());
		sql.setDossierNo(req.getDossierNo());
		sql.setAuditingStatusCode(req.getAuditingStatusCode());
		sql.setRiskLevelCode(req.getRiskLevelCode());
		sql.setStructureId(req.getStructureId());
		sql.setUserId(req.getUserId());
		sql.setFirstResult(req.getFirstResult());
		sql.setMaxResult(req.getMaxResult());

		return sql;
	}

}
