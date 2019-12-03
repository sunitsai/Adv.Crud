<%@page import="com.bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	Student s=null;
	if(session!=null)
	{
		if(session.getAttribute("student")!=null)
		{
			s=(Student)session.getAttribute("student");
%>
	Welcome, <%=s.getFname() %> <%=s.getLname() %>
<%
		}
		else
		{
			response.sendRedirect("login.jsp");
		}
	}
	else
	{
		response.sendRedirect("login.jsp");
	}
%>
</body>
</html>