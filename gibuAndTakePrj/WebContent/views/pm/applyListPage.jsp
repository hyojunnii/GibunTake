<%@page import="com.gnt.common.PageVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	PageVo pv = (PageVo)request.getAttribute("pv");
	
	int currentPage = pv.getCurrentPage();
	int startPage = pv.getStartPage();
	int endPage = pv.getEndPage();
	int maxPage = pv.getMaxPage();
%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>

    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>

    <style>
      #body {
        width: 1200px;
        margin: 0 auto;
      }
      
      a{
      	text-decoration: none;
      	color: #000000;
      }
      
      #pm-header {
        width: 100%;
        height: 100px;
        background-color: #8bdcb1;
        display: flex;
        align-items: center;
      }
      
      #pm-nav ul {
      	margin: 0 auto;
       	width: 100%;
       	text-align: center;
      }
      
      #pm-nav ul li {
      	width: 50%;
      	height: 50px;
      	padding-top: 10px;
      	font-size: 18px;
      	font-weight: 600;
      }
      
      .current-nav {
      	background-color: #dff9ed;
      }

      #pm-header h1 {
        width: 100%;
        margin: 0 12%;
        font-size: 34px;
        font-weight: 900;
      }

      #apply-title {
        text-align: center;
        margin: 4% 15% 1%;
        height: 100px;
        border-bottom: 4px solid #72d09e;
      }

      #apply-title h1 {
        padding-top: 10px;
        font-size: 34px;
        font-weight: 900;
      }

      .button {
        margin: 0 auto;
        background-color: #b3e0c9;
        border: none;
        border-radius: 10px;
        width: 80%;
        height: 40px;
        font-size: 16px;
        font-weight: 600;
        color: #2e6c4a;
        text-decoration: none;
        padding: 8px;
      }

      .button:hover {
        background-color: #93e1b7;
        color: #000000;
      }

       .contents {
        margin: 0 20%;
        height: 120px;
        display: flex;
        align-items: center;
        justify-content: space-between;
        border-bottom: 2px solid #93e1b7;
      }

      .content-info {
        display: flex;
        width: 75%;
        padding-left: 5%;
      }
      .content-info2 {
        display: flex;
        width: 20%;
        justify-content: flex-end;
        align-items: center;
        margin-right: 10px;
      }
      .content-info3 {
      	width: 15%;
      }

      .content-info-title {
        margin: auto 4%;
        display: flex;
        flex-direction: column;
      }

      .content-info-title span {
        padding: 4px 0;
        font-size: 15px;
      }
      
      .content-info-title span:first-child {
        padding: 2px 0;
        font-size: 14px;
      }
      
      .content-info-title span:nth-child(2) {
      	font-size : 18px;
      	font-weight: 600;
      }

      .content-info-state {
        color: #2e6c4a;
        font-weight: 600;
        margin-right: 25%;
        font-size: 20px;
      }
      
      .content-info-state2 {
        color: gray;
        font-weight: 600;
        margin-right: 25%;
        font-size: 20px;
      }

      .content-info-status {
        display: flex;
        flex-direction: column;
        margin-right: 8%;
      }
      
      #page-area {
        width: 80%;
        text-align: center;
        margin: auto;
        padding-top: 20px;
        margin-bottom: 50px;
      }

      #page-area a {
        color: #2e6c4a;
        font-weight: 600;
        margin: 0 3px;
        padding: 0 7px;
      }
      
      .currentPage {
      	background-color: #e3f3ec;
      	border-radius: 10px;
      }
    </style>
  </head>
  <body>
    <%@ include file="/views/common/header.jsp" %>

    <div id="body">
      <div id="pm-header">
        <h1><a>프로젝트 관리</a></h1>
      </div>
      <nav id="pm-nav">
      	<ul class="list-group list-group-horizontal">
        	<li class="list-group-item"><a href="<%=path%>/pm/apply/main">프로젝트 신청</a></li>
        	<li class="list-group-item current-nav"><a href="<%=path%>/pm/apply/list">신청내역 조회</a></li>
      	</ul>
      </nav>
      <div id="apply-title">
        <h1>프로젝트 신청 내역</h1>
      </div>
      <div id="apply-list">
	      <c:forEach items ="${applyList}" var="l">
	      	<c:choose>
	      		<c:when test="${l.pass eq 'N' && empty l.deny}"> <!-- 패스안하고 반려사유 없음 -->
	      			<div class="contents">
			           <div class="content-info">
			             <div class="content-info-title">
			             	<span>${l.category}</span>
			               <span>${l.title}</span>
			             </div>
			           </div>
				         <div class="content-info2">
				           <span class="content-info-state">
				           	심사 중
				           </span>
				         </div>
			         </div>
	      		</c:when>
	      		<c:when test="${l.pass eq 'N' && not empty l.deny}"> <!-- 반려됨 -->
	      			<div class="contents">
			           <div class="content-info">
			             <div class="content-info-title">
			             	<span>${l.category}</span>
			               <span>${l.title}</span>
			             </div>
			           </div>
			           <div class="content-info2">
			             <span class="content-info-state">
			             	반려됨
			             </span>
			           </div>
			           <div class="content-info3">
			          	<a type="button" class="button" data-bs-container="div" data-bs-toggle="popover" data-bs-placement="left" data-bs-content="${l.deny}">
						  반려 사유
						</a>
			           </div>
			        </div>
	      		</c:when>
	      		<c:otherwise> <!-- 통과 -->
	      			<div class="contents">
			           <div class="content-info">
			             <div class="content-info-title">
			             	<span>${l.category}</span>
			               <span>${l.title}</span>
			             </div>
			           </div>
				         <div class="content-info2">
				           <span class="content-info-state">
				           	등록 완료
				           </span>
				         </div>
			         </div>
	      		</c:otherwise>
	      	</c:choose>
	      </c:forEach>
      </div>
      <div id="page-area">
		<% if(currentPage != 1) {%>
      		<a href="<%=path%>/pm/apply/list?p=<%=currentPage-1%>">&lt;</a>
      	<%}%>
         
		<% for(int i = startPage; i <= endPage; i++) {%>
			<% if(i == currentPage) {%>
		 		<a class="currentPage"><%=i%></a>
			<%} else {%>
		 		<a href="<%=path%>/pm/apply/list?p=<%=i%>"><%=i%></a>
		 	<%} %>
		 <%} %>
		 
		 <% if(currentPage != maxPage) {%>
        	<a href="<%=path%>/pm/apply/list?p=<%=currentPage+1%>">&gt;</a>
        <%} %>
       </div>
    </div>

    <%@ include file="/views/common/footer.jsp" %>
    
    <script>
	    var popoverTriggerList = [].slice.call(document.querySelectorAll('[data-bs-toggle="popover"]'))
	    var popoverList = popoverTriggerList.map(function (popoverTriggerEl) {
	      return new bootstrap.Popover(popoverTriggerEl)
	    })
    </script>
  </body>
</html>