<%@page import="java.net.URLDecoder"%>
<%@page import="ejyoo.vo.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
// 	request.setCharacterEncoding("UTF-8");

	List<MemberDTO> memberList = (List<MemberDTO>) request.getAttribute("memberList");
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
<h1>회원 목록</h1>
<table>
	<thead>
		<tr>
			<th>아이디</th>
			<th>비밀번호</th>
			<th>전화번호</th>
			<th>이메일</th>
			<th>관리</th>
		</tr>
	</thead>
	<tbody>
<%
	int memberListSize = 0;
	if(memberList != null){
		memberListSize = memberList.size();
	}
	if(memberListSize > 0){
		for(int i = 0 ; i < memberListSize ; i++){
			%>
			<tr>
				<td><%= memberList.get(i).getUserId() %></td>
				<td><%= memberList.get(i).getUserPw() %></td>
				<td><%= memberList.get(i).getUserPhone() %></td>
				<td><%= memberList.get(i).getUserEmail() %></td>
				<td>
					<a type='button' href='updateMember?userId=<%= memberList.get(i).getUserId() %>'>수정</a>
					<a type='button' href='deleteMember?userId=<%= memberList.get(i).getUserId() %>'>삭제</a>
				</td>
			</tr>
			<%
		}
	} else {
		%>
		<tr>
			<td rowspan='4'>목록을 불러올 수 없습니다.</td>
		</tr>
		<%
	}
%>
		<tr>
			<td rowspan='4'>
				<a type='button' href='insertMember'>회원등록</a>
			</td>
		</tr>
	</tbody>
</table>
</body>
</html>