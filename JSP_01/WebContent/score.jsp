<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%! 
	public int total(int kor,int eng,int mat,int sci){
		int result = kor + eng + mat + sci;
		return result;
	}
%>
<%
	String korParam=request.getParameter("kor");
	String engParam=request.getParameter("eng");
	String matParam=request.getParameter("mat");
	String sciParam=request.getParameter("sci");
	
	float avg = 0.0f;
	try{
		int kor = Integer.parseInt(korParam);
		int eng = Integer.parseInt(engParam);
		int mat = Integer.parseInt(matParam);
		int sci = Integer.parseInt(sciParam);
		
		int total = total(kor,eng,mat,sci);
		
		avg = total / 4.0f;
	} catch(Exception e){
		out.println("입력값이 올바르지 않습니다.");
		return;
	}
	
	pageContext.setAttribute("avg", avg);
%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html"; charset="UTF-8">
<title></title>
</head>
<body>
<h2>평균구하는 사이트</h2>
<script>
	alert('국어 : ${param.kor}, 영어 : ${param.eng})');
	alert('평균 : ${avg}');
</script>
</body>
</html>