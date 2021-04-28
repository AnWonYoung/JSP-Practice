<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 쓰기</title>
<style>
* {
	padding: 0;
	margin: 0;
}

body {
	background-color: lavender;
	display: flex;
}

#container {
	margin: 0 auto;
	margin-top: 100px;
}

h1 {
	text-align:center;
	margin-left: 20px;
	margin-top: 20px;
}

}
form {
	justify-content: center;
	display-column: column;
	
}
</style>
</head>
<body>
	<div id="container">
		<h1>글 쓰기</h1>
		<form action="/write" method="post">
			<div>
				제목: <input type="text" name="title">
			</div>
			<br>
			<div>내용:</div>
			<div>
				<textarea name="contents" rows="40" cols="100"></textarea>
			</div>
			<div>
				<input type="submit" value="글쓰기"> <input type="reset"
					value="모두 삭제">
			</div>
	</div>
	</form>
</body>
</html>