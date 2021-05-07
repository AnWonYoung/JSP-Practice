<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>수정하기</title>
</head>
<body>
	<form action="/mod" method="post">
	<input type="hidden" name="iboard" value="${data.iboard}">
	<div>
		제목 : <input type="text" name ="title" value="${data.title}">
	</div>
	<div>
		내용 : <textarea rows="30" cols="50" name="content">${data.content}</textarea>
	</div>
	
	<div>
		<input type="hidden" name="no" value="${param.iboard}">
		<input type="submit" value="등록하기">
		<input type="reset" value="초기화">
	</div>
	</form>
</body>
</html>