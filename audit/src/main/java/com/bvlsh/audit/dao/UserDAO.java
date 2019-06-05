package com.bvlsh.audit.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.bvlsh.audit.entities.User;


@SuppressWarnings("unchecked")
@Repository
public class UserDAO {
	
	@PersistenceContext
	EntityManager em;
	
	public User findByUsername(String username) {
		List<User> list = em.createQuery("From User u where u.username=:username").setParameter("username", username)
				.getResultList();
		if (list != null && !list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

}
