package package_SignUp_Servlet;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;

import dao.UserDao;
import dto.User;


//@WebServlet("/Signup")
public class SignUP extends GenericServlet
{

	@Override
	public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
		// to resive the values from user from browser by dynamic input
		
//		String name=req.getParameter("name");
//		long mobile=Long.parseLong(req.getParameter("pn"));
//		String email=req.getParameter("email");
//		String password=req.getParameter("pass");
//		String gender=req.getParameter("gender");
//		String address=req.getParameter("add");            
		
		// to give the value for another web page when user enter submit button
		//    all the values will be present in another web page
		
//		res.getWriter().print("<h1> Name:"+name+"<br>");
//		res.getWriter().print("<h1> number:"+mobile+"<br>");
//		res.getWriter().print("<h1> email:"+email+"<br>");
//		res.getWriter().print("<h1> passwrod:"+password+"<br>");
//		res.getWriter().print("<h1> Gender:"+gender+"<br>");
//		res.getWriter().print("<h1> Address:"+address+"<br>");
		
		///////////////////////////////////////////////////////////////////////////
//		user user=new user();
//		user.setName(name);
//		user.setAddress(address);
//		user.setEmail(email);
//		user.setGender(gender);
//		user.setMobile(mobile);
//		user.setPassword(password);
		 
		//user user=new user();
		User user=new User();
		user.setName(req.getParameter("name"));
		user.setAddress(req.getParameter("add"));
		user.setEmail(req.getParameter("email"));
		user.setGender(req.getParameter("gender"));
		user.setMobile(Long.parseLong(req.getParameter("pn")));
		user.setPassword(req.getParameter("pass"));
		
		
	    UserDao dao=new UserDao();
		try{
	    dao.save(user);
		
	    
		//res.getWriter().print("<h1> Account sign up Successfully");
		
		
		// To print value along with login page link should display
		//res.getWriter().print("<h1>"+"Account signup successfully"+"</h1><br> <a href=\"login_page_html.html\">clike hear to login</a>");
	                                                              
		/////////////////
		
		
		// when we want  LOGIN PAGE after SIGNUP PAGE we have to use RequestDispatcher 
		res.getWriter().print("<h1> Account created Successfully</h1>");
		req.getRequestDispatcher("login_page_html.html").include(req, res);
		}
		catch(Exception e){
			res.getWriter().print("<h1> Email already exists</h1>");
			req.getRequestDispatcher("login_page_html.html").include(req, res);
		}
		
	
		
		
	}
	}