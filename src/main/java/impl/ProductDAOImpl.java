package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import config.Config;
import DAO.CategoryDAO;
import DAO.ProductDAO;
import model.Product;
import model.category;

public class ProductDAOImpl implements ProductDAO {

	public void insert(Product c) {
		String query = "insert into Product (category, name, quantity, price, description,imageUrl) values(?,?,?,?,?,?)";
		try {

			Connection conn = Config.conn;

			PreparedStatement p = conn.prepareStatement(query);
			
			p.setString(1, c.getCategory());
			p.setString(2, c.getName());
			p.setString(5, c.getDescription());
			p.setString(6, c.getImageUrl());

			p.setInt(3, c.getQuantity());
			p.setInt(4, c.getPrice());
			
			p.executeUpdate();

			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void update(Product c) {
		// TODO Auto-generated method stub
		String query = "update Product set category=?, name=?, quantity=?, price=?, description=?, imageUrl=? where id=?";
		try {

			Connection conn = Config.conn;

			PreparedStatement p = conn.prepareStatement(query);

			p.setString(1, c.getCategory());
			p.setString(2, c.getName());
			p.setString(5, c.getDescription());
			p.setString(6, c.getImageUrl());

			p.setInt(3, c.getQuantity());
			p.setInt(4, c.getPrice());
			
			
			
			p.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void delete(int cid) {
		// TODO Auto-generated method stub
		String query = "delete from Product where id=?";

		try {

			Connection conn = Config.conn;

			PreparedStatement p = conn.prepareStatement(query);

			p.setInt(1, cid);

			p.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

			

	public Product getproduct(int cid) {
		// TODO Auto-generated method stub
				Product c = new Product();

				String query = "select * from Product where id= ?";

				try {

					Connection conn = Config.conn;

					PreparedStatement p = conn.prepareStatement(query);

					p.setInt(1, cid);

					ResultSet rs = p.executeQuery();

					while (rs.next()) {

						c.setId(rs.getInt("id"));
						c.setName(rs.getString("name"));
						c.setCategory(rs.getString("category"));
						c.setQuantity(rs.getInt("quantity"));
						c.setPrice(rs.getInt("price"));
						c.setDescription(rs.getString("description"));
						c.setImageUrl(rs.getString("imageUrl"));

						return c;

					}

				} catch (Exception e) {
					e.printStackTrace();
				}
				return null;
			}
	
	
						


	public List<Product> getproduct() {
		// TODO Auto-generated method stub
				List<Product> list = new ArrayList<Product>();
				String query = "select * from Product";
				try {

					Connection conn = Config.conn;

					PreparedStatement p = conn.prepareStatement(query);

					ResultSet rs = p.executeQuery();

					while (rs.next()) {

						Product c = new Product();

						c.setId(rs.getInt("id"));
						c.setName(rs.getString("name"));
						c.setCategory(rs.getString("category"));
						c.setQuantity(rs.getInt("quantity"));
						c.setPrice(rs.getInt("price"));
						c.setDescription(rs.getString("description"));
						c.setImageUrl(rs.getString("imageUrl"));


						list.add(c);

					}

				} catch (Exception e) {

					e.printStackTrace();

				}

				return list;
	}

	public List<Product> getProduct(String categoryName) {
		// TODO Auto-generated method stub
		List<Product> list = new ArrayList<Product>();
		String query = "select * from Product where category = ?";
		try {

			Connection conn = Config.conn;

			PreparedStatement p = conn.prepareStatement(query);

			p.setString(1, categoryName);
			
			ResultSet rs = p.executeQuery();

			while (rs.next()) {

				Product c = new Product();

				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setCategory(rs.getString("category"));
				c.setQuantity(rs.getInt("quantity"));
				c.setPrice(rs.getInt("price"));
				c.setDescription(rs.getString("description"));
				c.setImageUrl(rs.getString("imageUrl"));


				list.add(c);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return list;
}



	

	public Map<String, List<Product>> getProductsByCategory() {
		// TODO Auto-generated method stub
		Map<String,List<Product>> dataMap = new HashMap<String,List<Product>>();

		CategoryDAO cdao = new CategoryDAOImpl();
		
		for(category c : cdao.getCategory()) {
			
			System.out.println(c.getName());
			
			List<Product> list = this.getProduct(c.getName());
			
			if ( !list.isEmpty() ) {
				
				dataMap.put(c.getName(), list);
			}
			
		}

		return dataMap;
}



}
