<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!-- import 해주기! -->
<%@ page import="java.util.*" %>
<%@ page import="com.an.wonyoung.*" %>

<!-- 형변환 해주면서 list불러오기 (반복 돌려줘야 함) -->

<%
	List<BoardField> list = (List<BoardField>)request.getAttribute("data");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>List</title>
<style>
	table, th, td {
		border: 1px solid black;
		border-collapse: collapse; 
	}
	
	table {
		width: 80%;
		height: 50%;
	}
	
	th, td {
		text-align: center;
	}
</style>
</head>
<body>
	<h1> 글 목록 </h1>
	<div>
		<a href="/write">글쓰기</a>
	</div>
	
	<div>
		<table>
			<tr>
				<th>글 번호</th>
				<th>글 제목</th>
			</tr>
			<% for(int i=0; i<list.size(); i++) { %>
			<% 	BoardField b = list.get(i);       %>
				<tr>
					<td><%=i %></td>
					<td>
					<a href="/detail?no=<%=i %>"><%=b.getTitle()%></a>
					</td>
				</tr>
				<% } %>
		</table>
	</div>
</body>
</html>