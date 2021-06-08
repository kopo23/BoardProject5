<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ page import="kr.ac.kopo.kopo23.domain.*" %>
<%@ page import="kr.ac.kopo.kopo23.service.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href = "http://localhost:8086/BoardProject5/Board.css" />
<style>
body{
	text-align:center;
}

a{
	color: gray;
}

table{
	width: 558px;
	background-color: #fff;
	border: 1;
	border-radius:10px 0 10px 0;
	color:#000;
	text-align: center;
	margin: auto;
	cursor: pointer;
	height: 60px;
}
</style>
</head>
<body>
<table border ="1">
	<tr>
		<td>번 호</td>
		<td>제 목</td>
		<td>작성일자</td>
	</tr>
<%
	
	BoardService boardService = new BoardServiceImpl();
	for (int i = 0; i < boardService.selectAll().size(); i++) {
		%>
		<tr>
			<td><%=boardService.selectAll().get(i).getId()%></td>
			<td><a href = 'Board_ShowOne.jsp?id=<%=boardService.selectAll().get(i).getId()%>'><%=boardService.selectAll().get(i).getTitle()%></a></td>
			<td><%=boardService.selectAll().get(i).getDate()%></td>
		</tr>
		
		<%	
	}
	
%>
</table>

<button onclick = "location.href='Board_Write.jsp'" class = "btn">글쓰기</button>
</body>
</html>



