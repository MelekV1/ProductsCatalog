package dao;
import java.util.List;

public class Test {
	public static void main(String[] args) {
		//EntityManagerFactory emf =Persistence.createEntityManagerFactory("UP_CAT");
		CatalogueDaoImpl dao = new CatalogueDaoImpl();
		dao.addProduit(new Produit("P1",8000,4));
		dao.addProduit(new Produit("P2",6700,2));
		dao.addProduit(new Produit("P3",5300,1));
		System.out.println("---------------------------------------");
		List<Produit> prods =dao.listProduits();
		for(Produit p:prods) {
			System.out.println(p.getDesignation());
		}
	}
}

/*
System.out.println("---------------------------------------");
		System.out.println("---Consulter un produit----");
		List<Produit> prod2 =dao.produitsParMC("P");
		for(Produit p:prod2) {
			System.out.println(p.getDesignation());
		}
		System.out.println("---------------------------------------");
*/