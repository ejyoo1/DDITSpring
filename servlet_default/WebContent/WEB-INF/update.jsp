<%@page import="java.util.List"%>
<%@page import="ejyoo.vo.MemberDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	List<MemberDTO> memberList = (List<MemberDTO>) request.getAttribute("memberList");
	String script = (String) request.getAttribute("script");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 관리 시스템</title>
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
<style>
	th, td{
		text-align: center;
	}
</style>
</head>
<body>
<h1>수정페이지</h1>
<form id="fm">
	<table border='1'>
		<tbody>
			<tr>
				<td>#</td>
				<td><input type="text" id="userNo" name="userNo" value="<%= memberList.get(0).getUserNo()%>" disabled></td>
			</tr>
			<tr>
				<td>아이디 : </td>
				<td><input type="text" id="userId" name="userId" value="<%= memberList.get(0).getUserId()%>"></td>
			</tr>
			<tr>
				<td>비밀번호 : </td>
				<td><input type="text" id="userPw" name="userPw" value="<%= memberList.get(0).getUserPw()%>"></td>
			</tr>
			<tr>
				<td>전화번호 : </td>
				<td><input type="text" id="userPhone" name="userPhone" value="<%= memberList.get(0).getUserPhone()%>"></td>
			</tr>
			<tr>
				<td>이메일 : </td>
				<td><input type="text" id="userEmail" name="userEmail" value="<%= memberList.get(0).getUserEmail()%>"></td>
			</tr>
			<tr>
				<td colspan="2">
					<a type="button" onclick="validation('updateMember')">수정</a>
					<a type="button" onclick="javascript:location.href='javascript:history.go(-1);'">이전으로</a>
				</td>
			</tr>
		</tbody>
	</table>
</form>
</body>
</html>