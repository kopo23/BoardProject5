<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%request.setCharacterEncoding("UTF-8");%>
<%@ page import="kr.ac.kopo.kopo23.domain.*" %>
<%@ page import="kr.ac.kopo.kopo23.service.*" %>

<%	
	Integer id = Integer.parseInt(request.getParameter("id"));
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href = "http://localhost:8086/BoardProject5/Board.css" />
</head>
<body>
<%
	BoardService boardService = new BoardServiceImpl();
	Board boardShow = boardService.selectOne(id);

%>

	<table border ="1">
		<tr>
			<td>번호</td>
			<td><%=boardShow.getId()%></td>
		</tr>
		<tr>
			<td>제목</td>
			<td><%=boardShow.getTitle()%></td>
		</tr>
		<tr>
			<td>작성일자</td>
			<td><%=boardShow.getDate()%></td>
		</tr>
		<tr>
			<td>내용</td>
			<td><%=boardShow.getContent()%></td>
		</tr>
	</table>
	<button class = "btn" onclick="location.href='Board_List.jsp'">돌아가기</button>
	
	<!-- 여기 수정하기 / 삭제하기버튼 -->
	
</body>
</html>