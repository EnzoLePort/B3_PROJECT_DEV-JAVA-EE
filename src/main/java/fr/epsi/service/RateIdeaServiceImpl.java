package fr.epsi.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.dao.RateIdeaDAO;
import fr.epsi.dao.RateIdeaDAOImpl;
import fr.epsi.entite.Idea;
import fr.epsi.entite.RateIdea;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class RateIdeaServiceImpl implements RateIdeaService {
	
	@PersistenceContext
	EntityManager em;
	
	@Resource
	UserTransaction utx;

	public void add(RateIdea rateIdea) {
		RateIdeaDAO dao = new RateIdeaDAOImpl(em, utx);
		// dao.add(rateIdea);
	}
	
	
	public List<RateIdea> getRateIdea(Idea idea) {
		RateIdeaDAO dao = new RateIdeaDAOImpl(em, utx);
		return dao.getRateIdea(idea);
	}

	
}
