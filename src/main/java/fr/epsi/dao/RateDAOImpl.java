package fr.epsi.dao;

import javax.persistence.EntityManager;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

import fr.epsi.entite.Rate;

public class RateDAOImpl implements RateDAO {
	
	EntityManager em;
	UserTransaction utx;
	
	public RateDAOImpl(EntityManager em, UserTransaction utx) {
		this.em=em;
		this.utx=utx;
	}

	// Vérification de la présence des données flop et top dans la table rate. Sinon remplissage de ces données
	public void checkDataTopFlop() {
		Long count = (Long) em.createQuery("Select COUNT(r) from Rate r").getSingleResult();
		
		if(count == 0) {
			Rate rateTop = new Rate();
			rateTop.setName("Top");
			Rate rateFlop = new Rate();
			rateFlop.setName("Flop");
			try {
				utx.begin();
				em.persist(rateFlop);
				em.persist(rateTop);
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

}
