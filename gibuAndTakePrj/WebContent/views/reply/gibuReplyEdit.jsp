<%@page import="com.gnt.common.ReplyVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    ReplyVo vo = (ReplyVo)request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
 #edit_contain{
 	width: 800px;
 	margin: 0 auto;
 	height: 200px;
 }
 #comment_area{
 	resize: none;
	width: 100%;
	height: 100%;
 }
 #comment_area_btn{
	width: 100%;
	height: 96%;
    background-color: #b3e0c9;
    border-radius: 10px;
	border: 0px;
 }
 table{
	width: 100%;
	height: 100%;
 }
</style>
</head>
<body>
<%@ include file="../common/header.jsp" %>


<br><br>
<br><br>
<br><br>


<div id="edit_contain">
	<form action="<%= path %>/view/gibuDetail/edit" method="post">
		<h1 align="center">댓글 수정하기</h1>
		<table>
			<input type="hidden" name="mno" value="<%= vo.getMno() %>">
			<input type="hidden" name="regno" value="<%= vo.getRegno() %>">
			<input type="hidden" name="repno" value="<%= vo.getRepno() %>">
			<tr>
				<td width="70%" height="100%">
					<textarea name="comment_area" id="comment_area" rows="5" ><%= vo.getRepcontent() %></textarea>
				</td>
				<td width="30%" height="100%">
					<input id="comment_area_btn" type="submit" value="등록하기" height="100%">
				</td>
			</tr>
		</table>
	</form>
</div>



<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<br><br>
<%@ include file="../common/footer.jsp" %>
</body>
</html>