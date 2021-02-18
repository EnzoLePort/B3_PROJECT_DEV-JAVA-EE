package fr.epsi.service;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.dao.RateDAO;
import fr.epsi.dao.RateDAOImpl;


@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class RateServiceImpl implements RateService {
	
	@PersistenceContext
	EntityManager em;
	
	@Resource
	UserTransaction utx;

	public void checkDataTopFlop() {
		RateDAO dao = new RateDAOImpl(em, utx);
		dao.checkDataTopFlop();
	}

}
