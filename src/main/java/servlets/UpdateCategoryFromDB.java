package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.CategoryDAO;
import impl.CategoryDAOImpl;
import model.category;

@WebServlet(urlPatterns="/UpdateCategoryFromDB")
public class UpdateCategoryFromDB extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt( req.getParameter("Id") );

		String name = req.getParameter("name");
		String description = req.getParameter("description");
		
		CategoryDAO cdao = new CategoryDAOImpl();
		
		category c = cdao.getCategory(id);
	
		c.setDescription(description);
		c.setName(name);
		
		cdao.update(c);
		
		resp.sendRedirect("ViewCategory.jsp");
		
	}

	
	
}
