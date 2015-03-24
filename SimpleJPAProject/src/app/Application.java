package app;

import java.util.logging.Level;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import model.Product;
import model.ProductCategory;

public class Application {
	private static final Logger logger = Logger.getLogger(Product.class.getName());
	
	public static void main(String[] args) {
		EntityManager em = Persistence.createEntityManagerFactory("sample.jpa").createEntityManager();

		// Begin transaction
		em.getTransaction().begin();

		ProductCategory oldProductCategory = em.find(ProductCategory.class, 1);
		Product oldProduct1 = em.find(Product.class, 1);
		Product oldProduct2 = em.find(Product.class, 2);
		
		if (oldProductCategory!= null) em.remove(oldProductCategory);
		if (oldProduct1 != null) em.remove(oldProduct1);
		if (oldProduct2 != null) em.remove(oldProduct2);
		
		ProductCategory newProductCat = new ProductCategory();
		newProductCat.setId(1);
		newProductCat.setCategoryName("Book");
		em.persist(newProductCat);
		
		Product newProduct1 = new Product();
		newProduct1.setProductid(1);
		newProduct1.setProductname("Java Web Application");
		newProduct1.setProductCategory(newProductCat);
		newProductCat.getProducts().add(newProduct1);
		em.persist(newProduct1);
		
		Product newProduct2 = new Product();
		newProduct2.setProductid(2);
		newProduct2.setProductname("Java Web Service");
		newProduct2.setProductCategory(newProductCat);
		newProductCat.getProducts().add(newProduct2);
		em.persist(newProduct2);
		
		// Commit transaction
		em.getTransaction().commit();
		
		for (Product p : em.find(ProductCategory.class, 1).getProducts()) {
			logger.log(Level.INFO, "productid= " + p.getProductid()
					+ ", productname=" + p.getProductname()
					+ ", categoryname=" + p.getProductCategory().getCategoryName());
		}
		
		em.close();
	}
}
