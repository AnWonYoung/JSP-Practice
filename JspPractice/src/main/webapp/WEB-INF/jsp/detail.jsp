<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import= "com.an.wonyoung.*" %>

<% String no = request.getParameter("no"); %> <!-- 자동 숫자를 데려오는 Parameter -->
<% BoardField b = (BoardField)request.getAttribute("data"); %> <!-- 사용자의 데이터를 데려오는 Attribute -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
</head>
<body>
	<h1> 글 내용 </h1>
	<!-- post 방식으로 삭제하기 -->
	<form action="/del" method="post">
	<input type="hidden" name= "no" value="<%=no %>">
	<input type="submit" value="삭제">
	</form>
	
	<a href="/mod?no=<%=no %>"><button>수정하기</button></a>
	
	<div>제목 : <%=b.getTitle() %></div>
	<div> <%=b.getCtnt() %></div>
</body>
</html>