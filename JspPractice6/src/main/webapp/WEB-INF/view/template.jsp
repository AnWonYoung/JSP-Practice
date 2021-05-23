<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<header>
		<ul>
			<li>메뉴 1</li>
			<li>메뉴 2</li>
			<li>메뉴 3</li>
		</ul>
	</header>
	
	<section>
		<jsp:include page="/WEB-INF/view/${requestScope.page}.jsp"></jsp:include>
	</section>
</body>
</html>