<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>

<% out.println(""); %>
<%= "" %>

<%
	for(int j = 2 ; j < 10 ; j++){
%>
<h3><%=j%>단 입니다.</h3>
<%
		for(int i = 1 ; i < 10 ; i++){
%>
<p><%=j%> * <%=i %> = <%=j*i%></p>
<%
		}
%>
<br />
<%
	}
%>