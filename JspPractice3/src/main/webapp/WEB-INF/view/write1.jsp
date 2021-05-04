<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>write1</title>
</head>
<body>
	<form action="/write1" method="post">
		<div>
			제목 : <input type="text" name="title">
		</div>
		<div>
			내용 : <textarea rows="50" cols="100" name="ctnt"></textarea>
		</div>
		<input type="submit" value="등록하기">
		<input type="reset" value="모두 지우기">
	</form>
</body>
</html>