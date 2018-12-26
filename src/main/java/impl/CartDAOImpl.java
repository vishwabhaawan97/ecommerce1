package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import DAO.CartDAO;
import config.Config;
import model.Cart;
import model.Product;

public class CartDAOImpl implements CartDAO {

	public void insert(Cart c) {
		// TODO Auto-generated method stub
		String query = "insert into Cart (username, productid, quantity, sa, ba) values(?,?,?,?,?)";
		try {

			Connection conn = Config.conn;

			PreparedStatement p = conn.prepareStatement(query);

			p.setString(1, c.getUsername());
			p.setString(4, c.getSaddress());
			p.setString(5, c.getBaddress());

			p.setInt(3, c.getQuantity());
			p.setInt(2, c.getProductid());

			p.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(int cid) {
		// TODO Auto-generated method stub
		String query = "delete from cart where id=?";

		try {

			Connection conn = Config.conn;

			PreparedStatement p = conn.prepareStatement(query);

			p.setInt(1, cid);

			p.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public Cart getCart(int cid) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<Cart> getCart(String Username) {
		List<Cart> list = new ArrayList<Cart>();
		String query = "select * from Cart where username=?";
		try {

			Connection conn = Config.conn;

			PreparedStatement p = conn.prepareStatement(query);

			p.setString(1, Username);

			ResultSet rs = p.executeQuery();

			while (rs.next()) {

				Cart c = new Cart();

				c.setId(rs.getInt("id"));
				c.setUsername(rs.getString("username"));
				c.setQuantity(rs.getInt("quantity"));
				c.setProductid(rs.getInt("productid"));
				c.setBaddress(rs.getString("ba"));
				c.setSaddress(rs.getString("sa"));

				c.setProduct(new ProductDAOImpl().getproduct(c.getProductid()));

				list.add(c);

			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		return list;
	}

	public List<Cart> getCart() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getBillingAddress(String username) {
		String query = "select ba from Cart where username=?";
		try {

			Connection conn = Config.conn;

			PreparedStatement p = conn.prepareStatement(query);

			p.setString(1, username);

			ResultSet rs = p.executeQuery();
			if (rs.next()) {

				return rs.getString("ba");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	public String getShippingAddress(String username) {
		// TODO Auto-generated method stub
		String query = "select sa from Cart where username=?";
		try {

			Connection conn = Config.conn;

			PreparedStatement p = conn.prepareStatement(query);

			p.setString(1, username);

			ResultSet rs = p.executeQuery();
			if (rs.next()) {

				return rs.getString("sa");

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public void updateBillingAndShippingAddress(String username, String billingAddress, String shippingAddress) {
		// TODO Auto-generated method stub
		String query = "update Cart set sa=? ,ba= ? where username=?";
		try {

			Connection conn = Config.conn;

			PreparedStatement p = conn.prepareStatement(query);

			p.setString(1, shippingAddress);
			p.setString(2, billingAddress);
			p.setString(3, username);

			p.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void delete(String username) {
		// TODO Auto-generated method stub
		String query = "delete from Cart where username=?";

		try {

			Connection conn = Config.conn;

			PreparedStatement p = conn.prepareStatement(query);

			p.setString(1, username);

			p.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getCount(String username) {

		// TODO Auto-generated method stub
		String query = "select * from Cart where username=?";
		try {

			Connection conn = Config.conn;

			PreparedStatement p = conn.prepareStatement(query);

			p.setString(1, username);

			ResultSet rs = p.executeQuery();

			int count = 0;

			while (rs.next()) {
				count++;
			}

			return count;
		} catch (Exception e) {

			e.printStackTrace();
		}

		return 0;
	}

}
