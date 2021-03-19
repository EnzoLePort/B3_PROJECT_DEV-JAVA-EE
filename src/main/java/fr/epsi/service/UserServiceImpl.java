package fr.epsi.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.dao.UserDAO;
import fr.epsi.dao.UserDAOImpl;
import fr.epsi.entite.User;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class UserServiceImpl implements UserService {
	
	@PersistenceContext
	EntityManager em;
	
	@Resource
	UserTransaction utx;

	public User get(String email, String password) {
		UserDAO dao = new UserDAOImpl(em, utx);
		return dao.get(email, password);
	}

	public void subscribe(User user) {
		UserDAO dao = new UserDAOImpl(em, utx);
		dao.subscribe(user);
	}

	public List<User> getSubscribeWaiting() {
		UserDAO dao = new UserDAOImpl(em, utx);
		return dao.getSubscribeWaiting();
	}

	public void approveSubscribe(Long id) {
		UserDAO dao = new UserDAOImpl(em, utx);
		dao.approveSubscribe(id);
	}

}
