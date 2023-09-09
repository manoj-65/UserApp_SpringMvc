package edu.jsp.userappspringmvc.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import edu.jsp.userappspringmvc.dto.User;

@Component
public class UserDao {
	@Autowired
	private EntityManager em;

	public User saveUser(User user) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.persist(user);
		transaction.commit();
		return user;
	}

	public User findUserById(long id) {
		return em.find(User.class, id);
	}

	public void updateUser(User user) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.merge(user);
		transaction.commit();
	}

	public void deletUser(User user) {
		EntityTransaction transaction = em.getTransaction();
		transaction.begin();
		em.remove(user);
		transaction.commit();
	}

	public List<User> findAllUser() {
		String sql = "SELECT u FROM User u";
		Query query = em.createQuery(sql);
		return query.getResultList();
	}

}
