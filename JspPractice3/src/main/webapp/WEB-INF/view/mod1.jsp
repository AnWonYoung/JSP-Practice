<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>mod</title>
</head>
<body>
	<form action="/mod1" method="post">
		<input type="hidden" name="iboard" value="${param.iboard}">
		<div>
			제목 : <input type="text" name="title" value="${data.title}">
		</div>
		<div>
			내용 : <textarea rows="40" cols="100" name="ctnt">${data.ctnt}</textarea>
		</div>
		
		<input type="hidden" name="no" value="${param.no}">
		<input type="submit" value="수정완료">
		<input type="reset" value="모두 삭제">
	</form>
</body>
</html>