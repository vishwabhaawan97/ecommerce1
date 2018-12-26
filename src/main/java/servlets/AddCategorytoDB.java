package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import impl.CategoryDAOImpl;
import model.category;

@WebServlet(urlPatterns = "/AddCategorytoDB")

public class AddCategorytoDB extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {

		String name = req.getParameter("name");
		String description = req.getParameter("desc");

		System.out.printf("Name: %s, Description: %s", name, description);

		category c = new category();

		c.setName(name);
		c.setDescription(description);

		System.out.println(c);

		CategoryDAOImpl cdao = new CategoryDAOImpl();

		cdao.insert(c);

		System.out.println("insterted successfully");
		
		resp.sendRedirect("ViewCategory.jsp");

	}

}
