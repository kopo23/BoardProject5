<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%request.setCharacterEncoding("UTF-8");%>
<%@ page import="kr.ac.kopo.kopo23.domain.*" %>
<%@ page import="kr.ac.kopo.kopo23.service.*" %>

<%	
	Integer id = Integer.parseInt(request.getParameter("id"));
	BoardService boardService = new BoardServiceImpl();
	Board boardShow = boardService.selectOne(id);
	String session_user = (String) session.getAttribute("userid");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href = "Board.css"/>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<script>
	function create_Reply() {
		let content = $("#reply_content").val();
		let userid = $("#reply_userid").val();
		
		if (content.trim() == "" || content == null){
			alert("댓글을 입력해주세요.");
			return false;
		}
		
		if (userid == "비로그인" || userid == null) {
			alert("로그인 후 이용해 주세요.");
			return false;
		}
		
		window.location = "Board_Reply.jsp?id=<%=id%>&content="+content+"&userid= "+userid+"&mode=create";
	}
	
	function delete_reply(selfnum) {
		
		if(confirm("댓글을 삭제하시겠습니까?")){
			window.location = "Board_Reply.jsp?id=<%=id%>&selfnum="+selfnum+"&mode=delete";
		} else {
			return;
		}
	}
</script>
</head>
<body>
	<table border ="1">
		<tr>
			<td style= "width: 150px;">번호</td>
			<td style= "width: 550px;"><%=boardShow.getId()%></td>
		</tr>
		<tr>
			<td>작성자</td>
			<td><%=boardShow.getUserid()%></td>
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
			<td style="height: 500px;">내용</td>
			<td align="left"><%=boardShow.getContent()%></td>
		</tr>
	</table>
	<--------------------댓글------------------->
	<table border = "1">
		<tr>
			<td style= "width: 100px;">작성자</td>
			<td style= "width: 400px;">내용</td>
			<td style= "width: 100px;">작성시간</td>
		</tr>
		<%
		BoardService replyService = new BoardServiceImpl();
		
		for (int i = 0; i < replyService.selectReply(id).size(); i++) {

			%>
			<tr>
				<td><%=replyService.selectReply(id).get(i).getR_userid()%></td>
				<td><%=replyService.selectReply(id).get(i).getR_content()%>
				<%if (session_user.trim().equals(replyService.selectReply(id).get(i).getR_userid().trim())){
					%> <h4 onclick="delete_reply(<%=replyService.selectReply(id).get(i).getR_selfnum()%>)">삭제하기</h4> <%
				} %>
				</td>
				<td><%=replyService.selectReply(id).get(i).getR_date()%></td>
			</tr>
			<%
		}
		
		%>
		<tr>
			<td><input type = "text" id = "reply_userid" readOnly value ="<%=session_user%>"></td>
			<td><input type = "text" id = "reply_content" style="width: 400px;" placeholder="댓글을 입력해주세요."></td>
			<td><button onclick = "create_Reply()" style="width: 110px;">작성</button></td>
		</tr>
	</table>
	<br>
	<button class = "btn" onclick="location.href='Board_List.jsp'">돌아가기</button>
	<%
	if (session_user.equals(boardShow.getUserid())){
		%><button class = "btn" onclick="location.href='Board_Edit.jsp?id=<%=id%>'">수정하기</button><%
	}
	%>
</body>
</html>