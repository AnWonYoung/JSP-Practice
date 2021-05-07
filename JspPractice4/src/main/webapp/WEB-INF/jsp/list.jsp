<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>list</title>
</head>
<body>
	<a href="/write"><button>글 쓰기</button></a>
	<div>
		<table>
			<tr>
				<td>글 번호</td>
				<td>글 제목</td>
				<td>등록시간</td>
			</tr>
			
			<c:forEach var="item" items="${data}">
			<tr onclick="detail(${item.iboard});">
				<td>${item.iboard}</td>
				<td>${item.title}</td>
				<td>${item.b_date}</td>
			</tr>
			</c:forEach>
		</table>
		
		<div>
			<script>
				function detail(iboard) {
					location.href="/detail?iboard=" + iboard;
				}				
			</script>
		</div>
	</div>
</body>
</html>