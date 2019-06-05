package com.bvlsh.audit.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bvlsh.audit.constants.IStatus;
import com.bvlsh.audit.entities.AuditStatus;
import com.bvlsh.audit.entities.DocumentType;
import com.bvlsh.audit.entities.RiskLevel;
import com.bvlsh.audit.entities.Structure;
import com.bvlsh.audit.entities.User;

@SuppressWarnings("unchecked")
@Repository
public class CrudDAO {

	@PersistenceContext
	EntityManager em;

	public <T> T create(T entity) {
		em.persist(entity);
		em.flush();
		return entity;
	}

	public <T> T update(T entity) {
		return em.merge(entity);
	}

	public <T> T findByKey(Class<T> claxx, Object id) {
		return em.find(claxx, id);
	}

	public List<User> loadUsers() {

		return em.createQuery("FROM User u WHERE u.status=:st ORDER BY u.createTime DESC")
				.setParameter("st", IStatus.ACTIVE).getResultList();
	}

	public List<RiskLevel> loadRiskLevels() {

		return em.createQuery("FROM RiskLevel rl WHERE rl.isDeleted=:isDeleted").setParameter("isDeleted", IStatus.NO)
				.getResultList();
	}

	public List<AuditStatus> loadAuditStatuses() {

		return em.createQuery("FROM AuditStatus a WHERE a.isDeleted=:d").setParameter("d", IStatus.NO).getResultList();
	}

	public List<DocumentType> loadDocTypes() {

		return em.createQuery("FROM DocumentType dp").getResultList();

	}

	public List<Structure> loadStructures() {

		return em.createQuery("FROM Structure s ORDER BY s.name").getResultList();

	}

}
