<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
<title></title>
<style>
	td{
		text-align: center;
	}
</style>
</head>
<body>
	<h1>login.jsp</h1>
	
	<form action="/login" method="post">
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
				<td colspan="2"><input type="submit" value="로그인" /></td>
			</tr>
		</table>
	</form>
</body>
</html>