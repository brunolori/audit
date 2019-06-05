package com.bvlsh.audit.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bvlsh.audit.constants.IStatus;
import com.bvlsh.audit.dao.sql.DossierSQL;
import com.bvlsh.audit.entities.AuditNotificationStart;
import com.bvlsh.audit.entities.AuditStatus;
import com.bvlsh.audit.entities.Authorization;
import com.bvlsh.audit.entities.Document;
import com.bvlsh.audit.entities.Dossier;
import com.bvlsh.audit.entities.FieldEvidence;
import com.bvlsh.audit.entities.Observation;
import com.bvlsh.audit.entities.Recommandation;
import com.bvlsh.audit.entities.RestrictionProposal;
import com.bvlsh.audit.entities.RiskLevel;
import com.bvlsh.audit.entities.Structure;
import com.bvlsh.audit.utils.StringUtil;

@SuppressWarnings("unchecked")
@Repository
public class DossierDAO {

	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("rawtypes")
	public List<Dossier> search(DossierSQL criterias) {
				
		String sql = "FROM Dossier d WHERE 1=1 ";
		String order = "ORDER BY d.id ";

		HashMap<String, Object> params = new HashMap<>();

		if (criterias.getFromDate() != null) {
			sql += "AND d.createTime>=:fromDate ";
			params.put("fromDate", criterias.getFromDate());
		}

		if (criterias.getToDate() != null) {
			sql += "AND d.createTime<=:toDate ";
			params.put("toDate", criterias.getToDate());
		}

		if (StringUtil.isValid(criterias.getDossierNo())) {
			sql += "AND UPPER(d.dossierNo) LIKE :dno ";
			params.put("dno", criterias.getDossierNo().toUpperCase());
		}

		if (StringUtil.isValid(criterias.getAuditingStatusCode())) {
			sql += "AND d.auditingStatus=:asc ";
			params.put("asc", new AuditStatus(criterias.getAuditingStatusCode()));
		}

		if (StringUtil.isValid(criterias.getRiskLevelCode())) {
			sql += "AND d.riskLevel=:rlc ";
			params.put("rlc", new RiskLevel(criterias.getRiskLevelCode()));
		}

		if (criterias.getStructureId() != null) {
			sql += "AND d.structure=:sid ";
			params.put("sid", new Structure(criterias.getStructureId()));
		}

		if (criterias.getUserId() != null) {
			sql += "AND d.createUser.id=:uid ";
			params.put("uid", criterias.getUserId());
		}

		sql += order;
		
		Query q = em.createQuery(sql);

		Iterator it = params.entrySet().iterator();
		while (it.hasNext()) {
			Map.Entry pair = (Map.Entry) it.next();
			q.setParameter((String) pair.getKey(), pair.getValue());
			it.remove();
		}

		if (criterias.getFirstResult() != null) {
			q.setFirstResult(criterias.getFirstResult());
		}

		if (criterias.getMaxResult() != null) {
			q.setMaxResults(criterias.getMaxResult());
		}

		return q.getResultList();

	}
	
	
	public List<Authorization> getAuthorizations(Integer dossierId)
	{
		return em.createQuery("FROM Authorization a WHERE a.dossier.id=:d ORDER BY a.id DESC")
				.setParameter("d", dossierId)
				.getResultList();
	}
	
	public List<AuditNotificationStart> getAuditNotificationStarts(Integer dossierId)
	{
		
		return em.createQuery("FROM AuditNotificationStart ans WHERE ans.dossier.id=:d ORDER BY ans.id DESC")
				.setParameter("d", dossierId)
				.getResultList();
	}
	
	public List<FieldEvidence> getFieldEvidences(Integer dossierId)
	{
		
		return em.createQuery("FROM FieldEvidence fe WHERE fe.dossier.id=:d ORDER BY fe.id DESC")
				.setParameter("d", dossierId)
				.getResultList();		
	}
	
	public List<Observation> getObservations(Integer dossierId)
	{
		
		return em.createQuery("FROM Observation o WHERE o.dossier.id=:d ORDER BY o.id DESC")
				.setParameter("d", dossierId)
				.getResultList();
	}
	
	public List<Recommandation> getRecommandations(Integer dossierId)
	{
		
		return em.createQuery("FROM Recommandation r WHERE r.dossier.id=:d ORDER BY r.id DESC")
				.setParameter("d", dossierId)
				.getResultList();
	}
	
	public List<RestrictionProposal> getRestrictionProposals(Integer dossierId)
	{
		return em.createQuery("FROM RestrictionProposal rp WHERE rp.dossier.id=:d ORDER BY rp.id DESC")
				.setParameter("d", dossierId)
				.getResultList();
	}
	
	public List<Document> getDocuments(Integer dossierId)
	{
		return em.createQuery("FROM Document doc WHERE doc.dossier.id=:d ORDER BY doc.id DESC")
				.setParameter("d", dossierId)
				.getResultList();
		
	}
	
	
	 public Integer countDossierByAuditStatus(String auditingStatus) {
	   
		 Long v = (Long)em.createQuery("SELECT count(d) FROM Dossier d WHERE d.isDeleted=:isDeleted AND d.auditingStatus.code=:auditingStatus")
				 .setParameter("isDeleted", IStatus.NO) .setParameter("auditingStatus", auditingStatus)
			     .getSingleResult();
	   return v.intValue();
	
   }
   
   

	
}
