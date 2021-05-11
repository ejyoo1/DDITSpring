<%@page import="ejyoo.vo.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	String script = (String) request.getAttribute("script");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 관리 시스템</title>
<style>
	th, td{
		text-align: center;
	}
</style>
<%
	if(script != null){
		%>
		<script>
			<%= script %>
		</script>
		<%
	} 
%>
<script src="<%= request.getContextPath() %>/js/memberSystemUtil.js"></script>
</head>
<body>
	<h1>회원 등록</h1>
	<form id="fm" action="insertMember" method="post">
		<table border="1">
			<tr>
				<td>아이디</td>
				<td><input type="text" id="userId" name="userId" /></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="text" id="userPw" name="userPw" /></td>
			</tr>
			<tr>
				<td>휴대전화</td>
				<td><input type="text" id="userPhone" name="userPhone" /></td>
			</tr>
			<tr>
				<td>이메일</td>
				<td><input type="text" id="userEmail" name="userEmail" /></td>
			</tr>
			<tr>
				<td colspan="2"><a type="button" onclick="validation('insertMember')">가입</a></td>
			</tr>
		</table>
	</form>
</body>

</html>