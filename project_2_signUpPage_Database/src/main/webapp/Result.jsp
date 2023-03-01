<%@page import="dao.UserDao"%>
<%@page import="java.util.List"%>
<%@page import="dto.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Result</title>
</head>
<body>
<%
if(session.getAttribute("id")==null){
	  response.getWriter().print("<h1> Invalid session </h1>");
	  request.getRequestDispatcher("login_page_html.html").include(request, response);
	  }
else{
%>  
    <h1>Hey this is result</h1>  
    <% List<User> list=(List<User>)request.getAttribute("list");
    
    %>
  <%--<%=list %>   It will print address --%>                                                                  
 <table border="2px solid red">
  <tr>
  <th>User NAme</th>
  <th>User Email</th>
  <th>User Mobile</th>
  <th>User Password</th>
  <th>Delete</th>
  <th>Edit</th>
  </tr>	
  
  <% for(User user:list){%>
  <tr>
	<td><%=user.getName() %></td>
	<td><%=user.getEmail() %></td>
	<td><%=user.getMobile() %></td>
	<td><%=user.getPassword() %></td>
	<td> <a href="delete?email=<%=user.getEmail()%>"><button >delete</button></a></td>
	<td>  <a href="edit.jsp?email=<%=user.getEmail()%>"><button >Edit</button></a></td>
	
	
  </tr>
	  <% }%>
 </table>                                                         
    <button onclick="window.print()">Print</button> <br>                                                                
     <button onclick="export_data()">Export</button><br>
     <button href="logout">Logout</button>
      <%} %>                                    
</body>
</html>