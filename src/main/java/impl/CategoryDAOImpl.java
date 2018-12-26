package impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import config.Config;
import DAO.CategoryDAO;
import model.category;

public class CategoryDAOImpl implements CategoryDAO {

	public void insert (category c) {
		String query = "insert into Category (name,description) values (?,?)";

	try
	{

		Connection conn = Config.conn;
		
		PreparedStatement p = conn.prepareStatement(query);

		p.setString(1, c.getName());
		p.setString(2, c.getDescription ());

		p.executeUpdate();

	}

	catch(Exception e) {
		e.printStackTrace();
	}
	}
	
		
	

	public void update(category c) {
		// TODO Auto-generated method stub

		String query = "update Category set name= ?, description=? where Id=?";
		try {

			
			Connection conn = Config.conn;

			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setString(1, c.getName());
			pstmt.setString(2, c.getDescription());
			pstmt.setInt(3, c.getId());

			pstmt.executeUpdate();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}
	



	public void delete (int cid) {
		// TODO Auto-generated method stub
		String query = "delete from Category where id=?";
		try {

			Connection conn = Config.conn;

			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setInt (1, cid);

			pstmt.executeUpdate();

		}

		catch (Exception e) {
			e.printStackTrace();
		}

	}

	

	public category getCategory(int cid) {
		// TODO Auto-generated method stub

		category c = new category();

		String query = "select * from Category where id= ?";

		try {

			Connection conn = Config.conn;

			PreparedStatement pstmt = conn.prepareStatement(query);

			pstmt.setInt(1, cid);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setDescription(rs.getString("description"));

				return c;

			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public List<category> getCategory() {

		List<category> list = new ArrayList<category>();

		String query = "select * from Category";

		try {

			Connection conn = Config.conn;

			PreparedStatement pstmt = conn.prepareStatement(query);

			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {

				category c = new category();

				c.setId(rs.getInt("id"));
				c.setName(rs.getString("name"));
				c.setDescription(rs.getString("description"));

				list.add(c);

			}

		} catch (Exception e) {
			
			e.printStackTrace();
		}
	
		return list;
	}


}

	