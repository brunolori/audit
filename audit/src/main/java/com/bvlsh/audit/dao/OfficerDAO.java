package com.bvlsh.audit.dao;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.bvlsh.audit.dao.sql.OfficerSQL;
import com.bvlsh.audit.entities.Officer;
import com.bvlsh.audit.utils.StringUtil;

@SuppressWarnings("unchecked")
@Repository
public class OfficerDAO {

	@PersistenceContext
	EntityManager em;

	@SuppressWarnings("rawtypes")
	public List<Officer> search(OfficerSQL criterias) {
		HashMap<String, Object> params = new HashMap<>();

		String sql = "FROM Officer o WHERE 1=1 ";
		String order = "ORDER BY o.name,o.surname";

		if (StringUtil.isValid(criterias.getName())) {
			sql += "AND UPPER(o.name) LIKE :name ";
			params.put("name", StringUtil.toUpper(criterias.getName()));
		}

		if (StringUtil.isValid(criterias.getSurname())) {
			sql += "AND UPPER(o.surname) LIKE :name ";
			params.put("name", StringUtil.toUpper(criterias.getSurname()));
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
	
	
	public List<Officer> queryOfficer(String query) {
		return em.createQuery("FROM Officer o WHERE  (UPPER(o.name) LIKE :on OR UPPER(o.surname) LIKE :os ) " + "ORDER BY o.name,o.surname")
				.setParameter("on", "%" + query.toUpperCase() + "%").setParameter("os", "%" + query.toUpperCase() + "%")
				.getResultList();
	}

}
