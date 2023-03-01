package package_SignUp_Servlet;

import java.io.IOException; 

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UserDao;
import dto.User;


@WebServlet("/update")
public class Update extends HttpServlet
{
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    	User user=new User();
    	user.setId(Integer.parseInt(req.getParameter("id")));
		user.setName(req.getParameter("name"));
		user.setAddress(req.getParameter("add"));
		user.setEmail(req.getParameter("email"));
		user.setGender(req.getParameter("gender"));
		user.setMobile(Long.parseLong(req.getParameter("pn")));
		user.setPassword(req.getParameter("pass"));
		    
	    UserDao dao=new UserDao();
		dao.update(user);
		
		java.util.List<User> list=dao.fetchAll();
		 req.setAttribute("list", list);
		 req.getRequestDispatcher("Result.jsp").forward(req, res);
    }
}
