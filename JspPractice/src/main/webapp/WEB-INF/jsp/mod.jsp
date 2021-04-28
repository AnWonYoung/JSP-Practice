<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- import 해주고 파라미터 값, 데이터 값을 가져오기 -->
<%@ page import="com.an.wonyoung.*" %>

<% String no = request.getParameter("no"); 
   BoardField b = (BoardField)request.getAttribute("data");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 수정 </title>
</head>
<body>
	<h1> 글 수정 </h1>
	<form action="/mod" method="post">
		<input type="hidden" name="no" value="<%=no %>">
		<div>
			제목: <input type="text" name="title" value=<%=b.getTitle() %>>
		</div>
		<div>
			내용: <textarea name="contents" rows="10" cols="10"><%=b.getCtnt() %></textarea>
		</div>
		<div>
			<input type="submit" value="글 수정">
		</div>
	</form>
</body>
</html>