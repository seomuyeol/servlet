<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="hello.servlet.domain.member.Member" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
成功
<ul>
	<li>id=${member.id}</li>
	<li>username=${member.username}</li>
	<li>age=${member.age}</li>
</ul>
<a href="/index.html">メイン画面</a>
</body>
</html>