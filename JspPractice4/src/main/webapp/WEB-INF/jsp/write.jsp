<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">s
<title>글쓰기</title>
</head>
<body>
	<form action="/write" method="post">
		<div>
			제목 : <input type="text" name="title">
		</div>
		<div>
			내용 : <textarea rows="30" cols="50" name="content"></textarea>
		</div>
		
		<div>
			<input type="submit" value="전송">
			<input type="reset" value="초기화">
		</div>
	</form>
</body>
</html>