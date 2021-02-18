package fr.epsi.dao;

import javax.persistence.EntityManager;
import javax.transaction.UserTransaction;

import fr.epsi.entite.Idea;
import fr.epsi.entite.User;

public class UserDAOImpl implements UserDAO {
	
	EntityManager em;
	UserTransaction utx;
	
	public UserDAOImpl(EntityManager em, UserTransaction utx) {
		this.em=em;
		this.utx=utx;
	}
	

	public User get(String email, String password) {
		Long count = (Long) em.createQuery("Select COUNT(u) from User u where u.mail=:email and u.password=:password")
					.setParameter("email", email)
					.setParameter("password", password)
					.getSingleResult();
		if(count > 0) {
			return  em.createQuery("Select u from User u where u.mail=:email and u.password=:password", User.class)
								.setParameter("email", email)
								.setParameter("password", password)
								.getSingleResult();
		} else {
			return null;
		}
	}

}
