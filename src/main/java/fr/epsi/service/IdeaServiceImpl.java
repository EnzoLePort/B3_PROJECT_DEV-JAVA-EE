package fr.epsi.service;

import java.util.List;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;

import fr.epsi.dao.IdeaDAO;
import fr.epsi.dao.IdeaDAOImpl;
import fr.epsi.entite.Idea;

@Stateless
@TransactionManagement(TransactionManagementType.BEAN)
public class IdeaServiceImpl implements IdeaService {
	
	@PersistenceContext
	EntityManager em;
	
	@Resource
	UserTransaction utx;


	public List<Idea> getIdeas() {
		IdeaDAO dao = new IdeaDAOImpl(em, utx);
		return dao.getIdeas();
	}


	public void add(Idea idea) {
		IdeaDAO dao = new IdeaDAOImpl(em, utx);
		dao.add(idea);
	}


	public List<Idea> getTopRatingIdeas() {
		IdeaDAO dao = new IdeaDAOImpl(em, utx);
		return dao.getTopRatingIdeas();
	}


	public List<Idea> getBestRatingIdeas() {
		IdeaDAO dao = new IdeaDAOImpl(em, utx);
		return dao.getBestRatingIdeas();
	}

}
