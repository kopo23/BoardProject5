<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%request.setCharacterEncoding("UTF-8");%>
<%@ page import="kr.ac.kopo.kopo23.domain.*" %>
<%@ page import="kr.ac.kopo.kopo23.service.*" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href = "http://localhost:8086/BoardProject5/Board.css" />
<script>
	function WriteBoard() {
				
	}
</script>
</head>
<body>
	  		<table cellspacing =1 width=800 border ="1" align="center">
				<tr>
					<td align="center" style= "width: 70px;"><font size="1">제목</font></td>
					<td align="left" style = "width: 700px;"><input type="text" id = "title" id ="title" style = "width: 730px;"  placeholder ="제목을 입력하세요."></td>
				</tr>
				<tr>
					<td align="center" style= "width: 70px; height: 500px;">내용</td>
					<td align="left" style = "width: 700px; height: 500px;"><textarea id = "content" style = "width: 730px;  height: 500px;"placeholder="내용을 입력하세요."></textarea></td>
				</tr>
			</table>
			
	<button class = "btn" onclick =''>작성하기</button> 
	
	<!-- 이 버튼을 여기서 값을받아서 바로 처리하는방법은없는가.. -->
	
	<button class = "btn" onclick="location.href='Board_List.jsp'">돌아가기</button>
</body>
</html>