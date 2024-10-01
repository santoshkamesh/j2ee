package sk;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet("/cookies1")
public class GetCookies extends HttpServlet{
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		String name=req.getParameter("name");
		String pass=req.getParameter("password");
		
		
		Cookie cookie1=new Cookie("k1", name);
		
		Cookie cookie2=new Cookie("k2", pass);
		
		resp.addCookie(cookie1);
		resp.addCookie(cookie2);
		
		req.getRequestDispatcher("cookies2").forward(req, resp);
		
	
	}

}
