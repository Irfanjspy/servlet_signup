package package_SignUp_Servlet;

import java.io.IOException;
       
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sun.xml.fastinfoset.util.QualifiedNameArray;

import antlr.collections.List;
import dao.UserDao;
import dto.User;



@WebServlet("/login")
public class Login extends HttpServlet
{
   @Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	  
	   String email=req.getParameter("email");
		String password=req.getParameter("password");
		
		User user=new User();
		
		UserDao userDao=new UserDao();
	      user=  userDao.find(email);
	     if(user==null){
	    	 res.getWriter().print("<h1>"+"Invalid Email</h1>");
	    		req.getRequestDispatcher("login_page_html.html").include(req, res);
	     }
	     else
	    	 if(user.getPassword().equals(password))
			    {
	    		 req.getSession().setAttribute("id", "sdsdf6783");
	    		 
	    		java.util.List<User> list=userDao.fetchAll();
	    		 req.setAttribute("list", list);
	    		 req.getRequestDispatcher("Result.jsp").forward(req, res);
			    } 
//				res.getWriter().print("<h1>"+"login successfullyy</h1>");
//	    		 
//	              java.util.List<User> l = userDao.fetchAll();
//	              for(User d:l){
//	              res.getWriter().print("<h1>"+d.getName()+"  "+d.getPassword()+" "+d.getGender()+"</h1>");
//			  }
				
				
//	            EntityManagerFactory factory=Persistence.createEntityManagerFactory("dev");
//	            EntityManager manager=factory.createEntityManager();
//	            EntityTransaction transaction=manager.getTransaction();
//	                 Query q=manager.createQuery("select e from user e", User.class);
//	                 
//	                 List<User> l=q.getResultList();
//	                 for(User d:l){
//	                	 System.out.println(d.getAddress()+"--"+d.getClass()+"--"+d.getName()+" "+d.getMobile());
//	                 }
	                 
	            
				
				// res.sendRedirect("https://www.youtube.com/");
				
  // }    
//			else
//				res.getWriter().print("<h1>"+"Invalid Password</h1>");
//	    		req.getRequestDispatcher("login_page_html.html").include(req, res);
//		
  
	     }
		
}
	
	
		

