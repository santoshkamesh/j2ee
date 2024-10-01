package sk;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;


@WebServlet("/formdata")
public class FormData extends GenericServlet{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException{
		int id=Integer.parseInt(req.getParameter("id"));
		String brand=req.getParameter("brand");
		double price=Double.parseDouble(req.getParameter("price"));
		double discount=Double.parseDouble(req.getParameter("discount"));
		
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/school","root","tiger");
			PreparedStatement preparedStatement=connection.prepareStatement("insert into product values(?,?,?,?)");
			preparedStatement.setInt(1, id);
			preparedStatement.setString(2, brand);
			preparedStatement.setDouble(3, price);
			preparedStatement.setDouble(4, discount);
			int a=preparedStatement.executeUpdate();
			
			
			res.getWriter().print(a+" row updated");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
