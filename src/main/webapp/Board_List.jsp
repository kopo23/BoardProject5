<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="kr.ac.kopo.kopo23.domain.*"%>
<%@ page import="kr.ac.kopo.kopo23.service.*"%>
<%
request.setCharacterEncoding("UTF-8");
%>
<%@ page session="true"%>
<!DOCTYPE html>
<html>
<head profile="http://www.w3.org/2005/10/profile">
<meta charset="EUC-KR">
<title>Insert title here</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
<link rel="stylesheet" type="text/css" href="Board.css" />
<script>
	function logout() {
		sessionStorage.clear();
		window.location = "http://192.168.23.87:8080/Login/main.jsp"
	}

	function Search_title() {
		let keywords = $("#search_keywords").val();
		let type = $("#search_type").val();
		if (keywords.trim().length == 0 || keywords == null) {
			alert("검색어를 입력해주세요.");
			keywords.focus;
			return false;

		}

		if (type == null) {
			alert("종류를 선택하세요.");
			type.focus;
			return false;
		}

		window.location = "Board_List.jsp?type=" + type + "&keywords="
				+ keywords;
	}
</script>
<%

//boardService 객체생성
BoardService boardService = new BoardServiceImpl();
String type = ""; String keywords = "";
PagingService paging;
int size = 0; boolean search_true = false;

if ((request.getParameter("type") != null && request.getParameter("keywords") != null) && ((request.getParameter("type") != "" && (request.getParameter("keywords") != "")))) { //검색일때
	search_true = true;
	type = request.getParameter("type");
	keywords = request.getParameter("keywords");
	
} else { //검색이아닐때
	search_true = false;
}

size = boardService.searchAll(type, keywords, search_true).size();
paging = new PagingService(request.getParameter("page_amount"), request.getParameter("from_num"), size);
//페이징처리 constructor 로 객체 생성. 인자는 (한페이지 출력수), 시작번호, 전체 데이터수. 


String session_user = (String) session.getAttribute("userid"); //세션

if (request.getParameter("loginID") == null && session_user == null) {
	session_user = "비로그인";

} else if (request.getParameter("loginID") != null) {
	String user = request.getParameter("loginID");
	session.setAttribute("userid", user);
	session_user = (String) session.getAttribute("userid");
}

%>
</head>
<body>
	<button style="width: 400px;" class="">
		User:
		<%=session_user%></button>
	<br>
	<p>
		<%
		if (search_true == true) {
			%>
			<b style="font-size: 25px;">'<%=keywords%>' 에 대한 검색결과가 '<%=size%>'개 있습니다.</b>
			<%
		}
		%>
	</p>
	<br>
	<table>
		<tr>
			<td>번 호</td>
			<td style="width: 200px;">제 목</td>
			<td>작 성 자</td>
			<td>작 성 일 자</td>
		</tr>
		<%
		BoardService replyService = new BoardServiceImpl();
		for (int i = paging.getFrom_num(); i < paging.getTo_num(); i++) {
		%>
		<tr>
			<td><%=boardService.searchAll(type, keywords, search_true).get(i).getId()%></td>
			<td><a
				href='Board_ShowOne.jsp?id=<%=boardService.searchAll(type, keywords, search_true).get(i).getId()%>'><%=boardService.searchAll(type, keywords, search_true).get(i).getTitle()%>
				<% 
				int reply = replyService.selectReply(boardService.selectAll().get(i).getId()).size();
				if (reply != 0) {
					out.print("(" +reply+")");
				} %>
			</a></td>
			<td><%=boardService.selectAll().get(i).getUserid()%></td>
			<td style="font-size: 12px;"><%=boardService.searchAll(type, keywords, search_true).get(i).getDate()%></td>
		</tr>
		<%
		}
		%>
	</table>
	<%
	out.print(paging.getFirstPage(type,keywords)); 
	for (int j = paging.getStart_page(); j < paging.getLast_page(); j++) {
		out.print("<a href='http://localhost:8086/Board_List.jsp?from_num=" + (j * paging.getPage_amount())
		+ "&page_amount=" + paging.getPage_amount() + "&type="+type+"&keywords="+keywords+"'> " + (j + 1) + " </a>");
	}
	out.print(paging.getFinalPage(type,keywords));
	%>

	<br>
	<select name="search_type" id="search_type">
		<option selected disabled>종류를 선택하세요.</option>
		<option value ="title">제목</option>
		<option value ="content">내용</option>
		<option value ="userid">작성자</option>
	</select>
	<input type="text" name="search_keywords" id="search_keywords"
		style="width: 100px; height: 20px;">
	<button type="button" onClick="Search_title()"
		style="width: 50px; height: 20px;">
		<font size="1">검색</font>
	</button>
	<br>
	<button onclick="location.href='Board_List.jsp'">메인으로</button>
	<button onclick="location.href='Board_Write.jsp'">글쓰기</button>
	<button onclick="logout()">로그아웃</button>
	<br>
</body>
</html>



