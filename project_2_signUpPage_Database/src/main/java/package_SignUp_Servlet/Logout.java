package package_SignUp_Servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/logout")
public class Logout extends HttpServlet {
  @Override
protected void service(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
	req.getSession().invalidate();
	res.getWriter().print("<h1> Logout successfully</h1>");
	req.getRequestDispatcher("login_page_html.html").include(req, res);
}
}
