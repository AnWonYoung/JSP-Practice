<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 목록</title>
</head>
<body>
	<a href="/write1"><button>글 등록하기</button></a>
	<div>
		<table>
		
			<tr>
				<td>글 순서</td>
				<td>글 제목</td>
				<td>등록시간</td>
			</tr>
			
			<c:forEach items="${list}" var="i">
				<tr onclick="moveToDetail(${i.iboard});">
					<td>${i.iboard}</td>
					<td>${i.title}</td>
					<td>${i.regdt}</td>
				</tr>
			</c:forEach>
			
		</table>
		
	</div>
		<script>
			function moveToDetail(iboard) {
				location.href="/detail1?iboard=" + iboard;
			}
		</script>
</body>
</html>