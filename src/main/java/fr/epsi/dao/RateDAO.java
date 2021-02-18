package fr.epsi.dao;

public interface RateDAO {
	
	// Vérification de la présence des données flop et top dans la table rate. Sinon remplissage de ces données
	void checkDataTopFlop();

}
