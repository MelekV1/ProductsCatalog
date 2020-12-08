package dao;

import java.util.List;
import javax.persistence.*;

public class CatalogueDaoImpl implements ICatalogueDao{
	/*Declaration de l'objet EntityManager qui permet de gérer les entités*/
	private EntityManager entityManager;
	/* Constructeur */
	public CatalogueDaoImpl() {
		/*création de l'objet Entity Manager Facotry*/
		EntityManagerFactory entityManagerFactory = 
				Persistence.createEntityManagerFactory("UP_CAT");
		/* Création de l'objet Entity Manager */
		entityManager = entityManagerFactory.createEntityManager();
	}
	
	public void addProduit(Produit p) {
		/*Création d'une transaction */
		EntityTransaction transaction = entityManager.getTransaction();
		/*Demarrer la transaction */
		transaction.begin();
		try {
			/*enregistrer le produit*/
			entityManager.persist(p);
			transaction.commit();
		}catch(Exception e) {
			/*Annuler la transaction */
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	public List<Produit> listProduits() {
		Query query = entityManager.createQuery("select p from Produit p");
		return query.getResultList();
	}
	
	public List<Produit> produitsParMC(String mc) {
		Query query = entityManager.createQuery("select p from Produit p"
				+ "where p.designation like :x");
		query.setParameter("x", "%"+mc+"%");
		return query.getResultList();
	}
	
	public Produit getProduit(Long idProduit) {
		Produit p = entityManager.find(Produit.class, idProduit);
		return p;
	}
	
	public void updateProduit(Produit p) {
		entityManager.merge(p);
	}
	
	public void deleteProduit(Long idP) {
		Produit p = entityManager.find(Produit.class, idP);
		entityManager.remove(p);	
	}	
}
