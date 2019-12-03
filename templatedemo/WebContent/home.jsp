<%@page import="com.bean.controlbean"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	controlbean l = null;
	if(session != null){
		
		
		if(session.getAttribute("control")!=null){
			
			l = (controlbean)session.getAttribute("control");
%>
	Welcome ,<%=l.getEmail() %> <%=l.getMobile() %>
<%
		}
		else{
			
			response.sendRedirect("index.html");
		}
	}
	else{
		response.sendRedirect("index.html");
	}

%>
</body>
</html>