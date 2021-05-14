<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<%
	List<Integer> intList = (ArrayList<Integer>)request.getAttribute("intList");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
<title></title>
</head>
<body>
	<%
		for(int i : intList){
	%>
		<span><%=i %></span>&nbsp;
	<%
		}
	%>
</body>
</html>