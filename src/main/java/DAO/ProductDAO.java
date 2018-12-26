package DAO;

import java.util.List;
import java.util.Map;

import model.Product;

public interface ProductDAO {
	
	void insert(Product c);

	void update(Product c);

	void delete(int cid);

	Product getproduct(int cid);

	List<Product> getproduct();
	
	List<Product> getProduct(String categoryName);
	
	Map<String, List<Product>> getProductsByCategory();
	

}



