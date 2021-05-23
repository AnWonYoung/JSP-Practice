<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<h1> 글 목록 </h1>
<div>
							<!--  검색 기능 구현 -->
	<div>
		<form action="list" method="get">
			<div>
				<input type="search" name="search">
				<input type="submit" value = "검색하기">
			</div>
		</form>
	</div>
</div>
	<table>
		<tr>
			<td>글 번호</td>
			<td>글 제목</td>
			<td>글 작성자</td>
			<td>등록시간</td>
		</tr>
		<c:forEach items="${requestScope.list}" var="items">
		<tr>
			<td>${items.iboard}</td>
			<td>${items.title}</td>
			<td>${items.unm}</td>
			<td>${items.regdt}</td>	
		</tr>
		</c:forEach>
	</table>
						<!-- 페이징 기능 구현 -->
	<div>
		<c:forEach begin="1" end="${requestScope.totalPage}" var="cnt">
			<a href="list?page=${cnt}&search${param.search}"><span>${cnt}</span></a>
		</c:forEach>
	</div>
</html>