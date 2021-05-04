<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>detail</title>
</head>
<body>
	<a href="/del1?iboard=${param.iboard}"><button>삭제</button></a>
	<a href="/mod1?iboard=${param.iboard}"><button>수정</button></a>
	<div>
		제목 : ${data.title}
	</div>
	<div>
		작성일 = ${data.regdt}
	</div>
	<div>
		${data.ctnt}
	</div>
</body>
</html>