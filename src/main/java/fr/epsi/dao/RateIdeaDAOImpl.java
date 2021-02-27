package fr.epsi.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import fr.epsi.entite.Idea;
import fr.epsi.entite.RateIdea;

public class RateIdeaDAOImpl implements RateIdeaDAO {
	
	EntityManager em;
	UserTransaction utx;
	
	public RateIdeaDAOImpl(EntityManager em, UserTransaction utx) {
		this.em=em;
		this.utx=utx;
	}

	public List<RateIdea> getRateIdea(Idea idea) {
		return em.createQuery("Select r from RateIdea r where r.idea=:idea", RateIdea.class)
				.setParameter("idea", idea)
				.getResultList();
	}

	public void add(RateIdea rateIdea) {
		try {
			utx.begin();
			em.persist(rateIdea);
			utx.commit();
		} catch (NotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
