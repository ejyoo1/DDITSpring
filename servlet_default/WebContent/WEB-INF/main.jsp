<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	String msg = (String) request.getAttribute("msg");
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
<title>회원 관리 시스템</title>
<%
	if(msg != null){
		%>
		<script>
			alert('<%= msg %>');
		</script>
		<%
	}
%>
</head>
<body>
<h1>메인화면</h1>
<a type='button' href='memberList'>로그인</a>
<a type='button' href='insertMember'>회원가입</a>
<a type='button' href='memberList'>회원목록</a>
</body>
</html>