<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% %>

<h1>Hello World!....</h1>

 <%-- Scriptlet tag--%>
<%   int a=5;%> <% 
System.out.println(a);
response.getWriter().print(a);
%>   

<h1> <% out.print(a); %></h1>

 <%-- Expresion tag--%>
<h1>First: <%=a %></h1>

<%-- Declarative tag --%>
<%!  int a=9; %>
<h1> Secound:<%=this.a %></h1>

<%  List list=new ArrayList();
list.add(1);
list.add(2);
%>
<%=list %>






</body>
</html>