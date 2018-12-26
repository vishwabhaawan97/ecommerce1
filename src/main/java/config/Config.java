package config;

import java.sql.Connection;
import java.sql.DriverManager;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebServlet;

@WebServlet
public class Config implements ServletContextListener {

	public static Connection conn = null;

	public void contextDestroyed(ServletContextEvent arg0) {

		try {
			conn.close();

			System.out.println("DB Disconnected");

		}

		catch (Exception e) {
			e.printStackTrace();

		}

		System.out.println("hello");

	}

	public void contextInitialized(ServletContextEvent arg0) {
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname", "root", "root");

			System.out.println("DB Connected");

		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("INIT");

	}

}
