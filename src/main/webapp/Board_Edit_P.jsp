<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.ac.kopo.kopo23.domain.*" %>
<%@ page import="kr.ac.kopo.kopo23.service.*" %>
<%request.setCharacterEncoding("UTF-8");%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
	<%		
		String mode = request.getParameter("mode");
		Integer id = Integer.parseInt(request.getParameter("id")); 
		BoardService boardService = new BoardServiceImpl();
	%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
</head>
<body>
	<%
		if (mode.equals("edit")) {
			Board board = new Board();
			board.setTitle(request.getParameter("title"));
			board.setContent(request.getParameter("content"));
			board.setId(id);
			boardService.update(board);
			
			%><script>window.location = "Board_ShowOne.jsp?id=<%=id%>"</script><%
			
		} else if (mode.equals("delete")) {
			Board board = new Board();
			board.setId(id);
			boardService.delete(board);
			%><script>window.location = "Board_List.jsp"</script><%
			
		} else {
			
			%><script>alert("Error: mode can't be defined")</script><%
		}
	
	%>
	
	
</body>
</html>