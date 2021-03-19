package fr.epsi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

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


	public void subscribe(User user) {
		try {
			utx.begin();
			em.persist(user);
			utx.commit();
		} catch (NotSupportedException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (RollbackException e) {
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			e.printStackTrace();
		}
	}


	public List<User> getSubscribeWaiting() {
		return em.createQuery("Select u from User u where u.rank=-1", User.class).getResultList();
	}


	public void approveSubscribe(Long id) {
		try {
			utx.begin();
			em.createQuery("UPDATE User u SET u.rank=0 WHERE u.id=:id").setParameter("id", id).executeUpdate();
			utx.commit();
		} catch (NotSupportedException e) {
			e.printStackTrace();
		} catch (SystemException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (RollbackException e) {
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			e.printStackTrace();
		}
	}

}
