package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.UsersDAO;
import impl.UsersDAOImpl;
import model.Users;
import validations.ValidateUsers;

@WebServlet(urlPatterns = "/AddUsersToDB")
public class AddUsersToDB extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String Username= req.getParameter("Username");
		String Password = req.getParameter("Password");
		String Email = req.getParameter("Email");
		String Phonenumber = req.getParameter("phoneNumber");
		String Address = req.getParameter("Address");

		System.out.printf("UserName: %s, Password: %s, email: %s, PhoneNumber: %s, Address: %s", Username, Password, Email,
				Phonenumber, Address);

		Users c = new Users();
		
		c.setUsername(Username);
		c.setPassword(Password);
		c.setEmail(Email);
		c.setPhoneNo(Phonenumber);
		c.setAddress(Address);

		System.out.println(c);

		ValidateUsers vusers = new ValidateUsers();
		
		if( vusers.validateUsers(c).isEmpty() ) {
			UsersDAO cdao = new UsersDAOImpl();

			cdao.insert(c);

			System.out.println("INSERTED SUCCESSFULLY");

			resp.sendRedirect("ViewUsers.jsp");
		}else {
			
			req.setAttribute("currentUser", c);
			req.setAttribute("errorMap", vusers.validateUsers(c));
			
			req.getRequestDispatcher("AddUsers.jsp").forward(req, resp);
		}
		
		
		
	}

}
