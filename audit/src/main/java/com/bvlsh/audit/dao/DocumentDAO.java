package com.bvlsh.audit.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bvlsh.audit.constants.IStatus;
import com.bvlsh.audit.entities.Document;
import com.bvlsh.audit.entities.Dossier;
import com.bvlsh.audit.utils.StringUtil;

@SuppressWarnings("unchecked")
@Repository
public class DocumentDAO {

	@PersistenceContext
	EntityManager em;

	public List<Document> search(Integer dossierId, String dossierNo, String documentType) {

		String sql = "FROM Document d WHERE d.isDeleted=:isDeleted ";

		if (dossierId != null && dossierId > 0) {
			sql += "and d.dossier=:dossier ";
		}
		if (StringUtil.isValid(documentType)) {
			sql += "and d.documentType.code=:documentType ";
		}
		if (StringUtil.isValid(dossierNo)) {
			sql += "and d.dossier.dossierNo=:dossierNo ";
		}
		
		sql +=" ORDER BY d.id desc";

		Query q = em.createQuery(sql).setParameter("isDeleted", IStatus.NO);

		if (dossierId != null && dossierId > 0) {
			q.setParameter("dossier", new Dossier(dossierId));
		}
		if (StringUtil.isValid(documentType)) {
			q.setParameter("documentType", documentType);
		}
		if (StringUtil.isValid(dossierNo)) {
			q.setParameter("dossierNo", dossierNo);
		}
		
		return q.getResultList();
	}

}
