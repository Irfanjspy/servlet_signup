package package_SignUp_Servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.Servlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;

import dao.UserDao;
import dao.whatsapp_UserDao;
import dto.User;
import dto.whatsapp_User;
@WebServlet("/whatsapp")
public class whatsapp extends GenericServlet {

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		
		whatsapp_User user=new whatsapp_User();
		
	    user.setName(req.getParameter("name"));
	    user.setEmail(req.getParameter("email"));
	    user.setNumber(Long.parseLong(req.getParameter("num")));
		
		
		
	   whatsapp_UserDao dao=new whatsapp_UserDao();
		
		dao.save(user);
		res.getWriter().print(        "<h2>");
		
		
	}
	


}
