<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kr.ac.kopo.kopo23.domain.*" %>
<%@ page import="kr.ac.kopo.kopo23.service.*" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
	BoardService boardService = new BoardServiceImpl();
	Board board1 = boardService.selectOne(1);
	
	
%>
hello world
board title: <%= board1.getTitle() %>
abcdfjkdsl
</body>
</html>








