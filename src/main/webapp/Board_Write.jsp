<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="kr.ac.kopo.kopo23.domain.*" %>
<%@ page import="kr.ac.kopo.kopo23.service.*" %>
<%request.setCharacterEncoding("UTF-8");%>
<%@ page session = "true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href = "Board.css"/>
<script>
	function WriteBoard() {
		
		if ($("#title").val().trim().length == 0 || $("#title").val() == null ){
			
			alert("제목은 공백이 될 수 없습니다.");
			$("#title").focus;
			return false;
		}
		
		writeform.action = "Board_Write.jsp";
		writeform.submit();
	}
</script>
</head>
<body>
	<% 
	
	if (request.getParameter("content") == (null) && request.getParameter("title") == null) {
		
		%>
		<form method = "post" id = "writeform" name = "writeform">
	  		<table border ="1" align="center">
				<tr>
					<td align="center" style= "width: 200px;"><font size="1">제목</font></td>
					<td align="left"><input type="text" name = "title" id = "title" style = "width: 500px;"  placeholder ="제목을 입력하세요."></td>
				</tr>
				<tr>
					<td align="center"><font size="1">작성자</font></td>
					<td align="left" ><%=session.getAttribute("userid")%></td>
				</tr>
				<tr>
					<td align="center" style= "height: 500px;">내용</td>
					<td align="left" style = "height: 500px;"><textarea name = "content" id = "content" style = "width: 500px;  height: 700px;"placeholder="내용을 입력하세요."></textarea></td>
				</tr>
			</table>
			
			<button type = "button" class = "btn" onclick ='WriteBoard()'>작성하기</button> 
			<button type = "button" class = "btn" onclick="location.href='Board_List.jsp'">돌아가기</button>
		</form>
		 <%
	
	} else {
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String userid = (String) session.getAttribute("userid");
		
		BoardService boardService = new BoardServiceImpl();
		Board board = new Board();
		
		board.setTitle(title);
		board.setContent(content);
		board.setUserid(userid);
		
		boardService.create(board);
		
		%> <script>alert("저장되었습니다.")
				window.location ='Board_List.jsp'
		   </script> <%
	}
	%>
</body>
</html>