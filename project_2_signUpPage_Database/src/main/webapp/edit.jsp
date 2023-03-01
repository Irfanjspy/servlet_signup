<%@page import="dto.User"%>
<%@page import="dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Edit</title>
</head>
<body>
<%
if(session.getAttribute("id")==null){
	  response.getWriter().print("<h1> Invalid session </h1>");
	  request.getRequestDispatcher("login_page_html.html").include(request, response);
	  }
else{
%>  


<% String email=request.getParameter("email"); 
 UserDao dao=new UserDao();
 User user=dao.find(email);

%>
   <form action="update" method="post">
   
   
   
<h1>Update</h1>
<input type="text" name="id" value=<%=user.getId() %> hidden="hidden"><br>
Name    :<input type="text" name="name" value="<%= user.getName()%>"><br><br>
PhNumber:<input type="text" name="pn" value="<%= user.getMobile()%>" ><br><br>
Email   :<input type="text" name="email"  value="<%= user.getEmail()%>  " readonly="readonly" <%-- disabled="disabled"--%> <%--hidden --%>><br><br>
Password:<input type="text" name="pass" value="<%= user.getPassword()%>"><br><br>

Gender:<%-- --%>
<% if(user.getGender().equals("male")) { %>
<input type="radio" name="gender"  value="male" checked="checked">Male
<input type="radio" name="gender" value="female">Female<br><br>
<%}else{ %>
<input type="radio" name="gender"  value="male">Male
<input type="radio" name="gender" value="female" checked="checked">Female
<%} %>
Address :<textarea rows="5" cols="5" name="add" ><%=user.getAddress()%></textarea><br><br>
<button>Update</button><button type="reset">Cancel</button>
</form>
   
<%} %>



</body>
</html>