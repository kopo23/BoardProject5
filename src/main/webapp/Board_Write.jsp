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
					<td align="center" style= "width: 70px;"><font size="1">����</font></td>
					<td align="left" style = "width: 700px;"><input type="text" id = "title" id ="title" style = "width: 730px;"  placeholder ="������ �Է��ϼ���."></td>
				</tr>
				<tr>
					<td align="center" style= "width: 70px; height: 500px;">����</td>
					<td align="left" style = "width: 700px; height: 500px;"><textarea id = "content" style = "width: 730px;  height: 500px;"placeholder="������ �Է��ϼ���."></textarea></td>
				</tr>
			</table>
			
	<button class = "btn" onclick =''>�ۼ��ϱ�</button> 
	
	<!-- �� ��ư�� ���⼭ �����޾Ƽ� �ٷ� ó���ϴ¹�������°�.. -->
	
	<button class = "btn" onclick="location.href='Board_List.jsp'">���ư���</button>
</body>
</html>