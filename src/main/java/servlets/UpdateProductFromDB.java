package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.ProductDAO;
import impl.ProductDAOImpl;
import model.Product;

@WebServlet(urlPatterns="/UpdateProductFromDB")
public class UpdateProductFromDB extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int id = Integer.parseInt( req.getParameter("Id") );

		String name = req.getParameter("name");
		String description = req.getParameter("description");
		
		ProductDAO cdao = new ProductDAOImpl();
		
		Product c = cdao.getproduct(id);
	
		c.setDescription(description);
		c.setName(name);
		
		cdao.update(c);
		
		resp.sendRedirect("ViewProduct.jsp");
		
	}

	
	
}
