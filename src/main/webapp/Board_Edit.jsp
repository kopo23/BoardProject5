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
	Integer id = Integer.parseInt(request.getParameter("id")); 
	BoardService boardService = new BoardServiceImpl();
	Board boardShow = boardService.selectOne(id);
	%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href = "Board.css"/>
<script>
function editBoard(id) {
	if ($("#title").val().trim().length == 0 || $("#title").val() == null){
		
		alert("제목은 공백이 될 수 없습니다.");
		return false;
	}
	
	if (window.confirm("수정하시겠습니까?") == false) {
		return;
	} else {
		alert(id+"번 게시글이 수정되었습니다!");
		editform.action = "Board_Edit_P.jsp?mode=edit";
		editform.submit();
	} 
}

function deleteBoard(id) {
	if (window.confirm("삭제하시겠습니까?") == false) {
		return;
	} else {
		alert(id+"번 게시글이 삭제되었습니다!");
		editform.action = "Board_Edit_P.jsp?mode=delete";
		editform.submit();
	} 
}

</script>
</head>
<body>
	<form method = "post" id = "editform" name = "editform">
	  	<table border ="1" align="center">
			<tr>
				<td align="center" style= "width: 200px;"><font size="1">제목</font></td>
				<td align="left"><input type="text" name = "title" id = "title" style = "width: 500px;"  placeholder ="<%=boardShow.getTitle()%>"></td>
			</tr>
			<tr>
				<td align="center"><font size="1">번호</font></td>
				<td align="left"><input type ="number" name ="id" id = "id" style = "width: 500px;" readOnly value="<%=boardShow.getId()%>"></td>
			</tr>
			<tr>
				<td align="center"><font size="1">작성자</font></td>
				<td align="left"><%=boardShow.getUserid()%></td>
			</tr>
			<tr>
				<td align="center"><font size="1">작성시간</font></td>
				<td align="left"><%=boardShow.getDate()%></td>
			</tr>
			<tr>
				<td align="center" style= "height: 500px;">내용</td>
				<td align="left" style = "height: 500px;"><textarea name = "content" id = "content" style = "width: 500px;  height: 700px;"placeholder="<%=boardShow.getContent()%>"></textarea></td>
			</tr>
		</table>
		<button type = "button" class = "btn" onclick="editBoard(<%=id%>)">수정하기</button>
		<button type = "button" class = "btn" onclick="deleteBoard(<%=id%>)">삭제하기</button>
		<button type = "button" class = "btn" onclick="location.href='Board_List.jsp'">돌아가기</button>
	</form>
</body>
</html>