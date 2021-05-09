<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 관리 시스템</title>
<%
	String script = (String) request.getAttribute("script");
%>
<script src="<%= request.getContextPath() %>/js/memberSystemUtil.js"></script>

</head>
<body>
<h1>삭제 페이지</h1>
	{
		"script" : "<%=script %>"
	}
</body>
</html>