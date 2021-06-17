<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<%@ page import="kr.ac.kopo.kopo23.domain.*" %>
<%@ page import="kr.ac.kopo.kopo23.service.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<%
Integer id = Integer.parseInt(request.getParameter("id"));
String mode = request.getParameter("mode");


if (mode != null && mode.equals("delete")){
	
	Integer selfnum = Integer.parseInt(request.getParameter("selfnum"));
	BoardService boardService = new BoardServiceImpl();
	Board board = new Board();
	
	board.setR_id(id);
	board.setR_selfnum(selfnum);
	
	boardService.delete_reply(board);
	
} else if (mode != null && mode.equals("create")) {
	
	String userid = request.getParameter("userid");
	String content = request.getParameter("content");
	
	BoardService boardService = new BoardServiceImpl();
	Board board = new Board();
	
	board.setR_id(id);
	board.setR_userid(userid);
	board.setR_content(content);
	
	boardService.create_reply(board);
	
} else if (mode != null && mode.equals("edit")) {
	
}


%>
</head>
<body>
	<script>
		window.location = "Board_ShowOne.jsp?id=<%=id%>"
	</script>
</body>
</html>