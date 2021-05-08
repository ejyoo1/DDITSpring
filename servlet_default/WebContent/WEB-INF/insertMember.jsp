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
</head>
<body>
	<h1>회원 등록</h1>
	<form id="fm" action="insertMember" method="post">
		아이디 : <input type="text" id="userId" name="userId" /><br/>
		비밀번호 : <input type="text" id="userPw" name="userPw" /><br/>
		휴대전화 : <input type="text" id="userPhone" name="userPhone" /><br/>
		이메일 : <input type="text" id="userEmail" name="userEmail" /><br/>
		<a type="button" onclick="validation()">가입</a>
	</form>
</body>
<script>
	function validation(){
		var userId = document.getElementById("userId").value;
		var userPw = document.getElementById("userPw").value;
		var userPhone = document.getElementById("userPhone").value;
		var userEmail = document.getElementById("userEmail").value;
		
		if(userId == "" || userPw == "" || userPhone == "" || userEmail == ""){
			alert('모든 필드를 입력해 주세요.');
			return;
		} else {
			goPost('insertMember');
		}
	}
	function goPost(url){
		var fm = document.getElementById("fm");
		
		fm.action = url;
		fm.method = "post";
		fm.submit();
	}
</script>
</html>