<%@page import="com.gnt.common.PageVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%
	PageVo pv = (PageVo)session.getAttribute("pv");
	
	int currentPage = pv.getCurrentPage();
	int startPage = pv.getStartPage();
	int endPage = pv.getEndPage();
	int maxPage = pv.getMaxPage();
%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Document</title>

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

      #search {
        width: 100%;
        height: 100px;
        background-color: #8bdcb1;
        display: flex;
        align-items: center;
        justify-content: space-around;
        padding: 0 14%;
      }

      .search-bar {
        height: 40px;
        width: 90%;
      }

      .search-icon {
        width: 30px;
        height: 40px;
        margin: 0 20px;
        border: none;
        background-color: rgba(255, 255, 255, 0);
      }

      .search-icon img {
        width: 50px;
        height: 50px;
        position: relative;
        top: -6px;
      }

      #category-search-outer {
        margin: 0 10%;
        padding: 20px 5% 20px;
        border-bottom: 3px solid #72d09e;
        display: flex;
        align-items: center;
        justify-content: center;
      }

      .category-search-title {
        width: 15%;
        position: relative;
        top: 4px;
      }

      .category-search-title h6 {
        font-weight: 600;
        color: #2e6c4a;
      }

      .category-search-subtitle {
        font-weight: 600;
        color: #2e6c4a;
        padding: 5px 6px 5px 20px;
      }

      .category-search-menu {
        width: 30%;
        display: flex;
      }

      .category-button {
        margin-left: 10%;
        height: 35px;
        background-color: #e3f3ec;
        border-radius: 10px;
        font-size: 15px;
        width: 120px;
      }

      #searched-content {
        margin-bottom: 10%;
      }

      #searched-content-header {
        margin: 1% 12%;
        display: flex;
        justify-content: space-between;
      }

      #searched-header-sort button {
        position: relative;
        top: -1px;
      }
      
      #searched-header-title {
        font-size: 18px;
      }
      
      #searched-content-body {
      	min-height: 800px;
      }

      .searched-none {
        font-weight: 600;
      }

      .contents {
        margin: 1% 10% 2%;
        background-color: #e3f3ec;
        height: 140px;
        display: flex;
        align-items: center;
        justify-content: space-between;
      }

      .content-info {
        display: flex;
        width: 70%;
      }
      .content-info2 {
        display: flex;
        width: 30%;
        justify-content: flex-end;
        align-items: center;
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
      
      .content-title {
      	font-size : 18px;
      	font-weight: 600;
      }

      .content-info img {
        width: 130px;
        height: 90px;
        margin-left: 5%;
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

      #searched-page-area {
        width: 80%;
        text-align: center;
        margin: auto;
        padding-top: 20px;
      }

      #searched-page-area a {
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
      <form id="search" action="<%=path%>/search/content" method="post" name="searchform">
        <c:choose>
        	<c:when test="${not empty searchedList}">
        		<input name="search" type="text" class="form-control search-bar" value="${par}" readonly />
        		<input type="hidden" name="s" value="0"/>
        		<a class="search-icon" href="<%=path%>/search"><img src="../resources/img/premium-icon-reset-2618245.png"></a>
        	</c:when>
        	<c:when test="${NullList eq 0}">
        		<input name="search" type="text" class="form-control search-bar" value="${param.search}" readonly />
        		<a class="search-icon" href="<%=path%>/search"><img src="../resources/img/premium-icon-reset-2618245.png"></a>
        	</c:when>
        	<c:when test="${empty recommendList and empty searchedList or not empty searchedList}">
        		<input name="search" type="text" class="form-control search-bar" value="" readonly />
        		<a class="search-icon" href="<%=path%>/search"><img src="../resources/img/premium-icon-reset-2618245.png"></a>
        	</c:when>
        	<c:otherwise>
        		<input name="search" type="text" class="form-control search-bar" placeholder="검색어를 입력하세요." />
        		<button type="submit" class="search-icon"><img src="resources/img/free-icon-search-7233469.png" /></button>
        	</c:otherwise>
        </c:choose>
      </form>
      <div id="category-search-outer">
        <div class="category-search-title"><h6>주제별 찾기</h6></div>
        <div class="category-search-menu">
          <span class="category-search-subtitle" id="">기부</span>
          <button id="donation-status" class="category-button btn dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="true">카테고리</button>
          <ul id="donation-type" class="dropdown-menu">
            <li><a class="dropdown-item" href="<%=path%>/search/category?pr=기부&c=아동청소년">아동/청소년</a></li>
            <li><a class="dropdown-item" href="<%=path%>/search/category?pr=기부&c=어르신">어르신</a></li>
            <li><a class="dropdown-item" href="<%=path%>/search/category?pr=기부&c=장애인">장애인</a></li>
            <li><a class="dropdown-item" href="<%=path%>/search/category?pr=기부&c=다문화">다문화</a></li>
            <li><a class="dropdown-item" href="<%=path%>/search/category?pr=기부&c=지구촌">지구촌</a></li>
            <li><a class="dropdown-item" href="<%=path%>/search/category?pr=기부&c=가족여성">가족/여성</a></li>
            <li><a class="dropdown-item" href="<%=path%>/search/category?pr=기부&c=시민사회">시민사회</a></li>
            <li><a class="dropdown-item" href="<%=path%>/search/category?pr=기부&c=동물">동물</a></li>
          </ul>
        </div>
        <div class="category-search-menu">
          <span class="category-search-subtitle" id="">펀딩</span>
          <button id="funding-status" class="category-button btn dropdown-toggle" type="button" data-bs-toggle="dropdown" aria-expanded="true">카테고리</button>
          <ul id="funding-type" class="dropdown-menu">
            <li><a class="dropdown-item" href="<%=path%>/search/category?pr=펀딩&c=일자리창출">일자리창출</a></li>
            <li><a class="dropdown-item" href="<%=path%>/search/category?pr=펀딩&c=공정무역">공정무역</a></li>
            <li><a class="dropdown-item" href="<%=path%>/search/category?pr=펀딩&c=친환경">친환경</a></li>
            <li><a class="dropdown-item" href="<%=path%>/search/category?pr=펀딩&c=기부">기부</a></li>
            <li><a class="dropdown-item" href="<%=path%>/search/category?pr=펀딩&c=작은가게">작은가게</a></li>
            <li><a class="dropdown-item" href="<%=path%>/search/category?pr=펀딩&c=미디어">미디어</a></li>
            <li><a class="dropdown-item" href="<%=path%>/search/category?pr=펀딩&c=창작자">창작자</a></li>
          </ul>
        </div>
      </div>
      <div id="searched-content">
          <c:choose>
          	<c:when test="${not empty searchedList}">
	          	<div id="searched-content-header">
		          <div id="searched-header-title">
		            <span class="searched-none">'${par}'</span>
		            <span>검색 결과 ></span>
		            <a href = "<%=path%>/search" style="font-size: 14px">돌아가기</a>
		          </div>
		          <div id="searched-header-sort">
		         	<span><a href="#" onclick="location.href='<%=path%>/search/content?search=${par}'">최신순</a> | <a href="#" onclick="location.href='<%=path%>/search/content?search=${par}&s=1'">인기순</a></span>
		          </div>
		        </div>
		        <div id="searched-content-body">
	          		<c:forEach items ="${searchedList}" var="l">
				         <div class="contents">
				           <div class="content-info">
				             <img src="../resources/upload/${l.url}" />
				             <div class="content-info-title">
				             	<span>${l.category}</span>
				             	<c:choose>
				             		<c:when test="${l.category eq '기부'}">
				               			<a class="content-title" href="<%=path%>/view/gibu_detail?type=0&num=${l.regNo}">${l.title}</a>
				             		</c:when>
				             		<c:when test="${l.category eq '펀딩'}">
				               			<a class="content-title" href="<%=path%>/view/funding_detail?type=0&num=${l.regNo}">${l.title}</a>
				             		</c:when>
				             		<c:when test="${l.category eq '캠페인'}">
				               			<a class="content-title" href="<%=path%>/view/campaign_detail?num=${l.regNo}">${l.title}</a>
				             		</c:when>
				             	</c:choose>
				               <span>${l.mNo}</span>
				             </div>
				           </div>
				           <div class="content-info2">
				             <span class="content-info-state">
				             	<c:choose>
				             		<c:when test="${l.fin eq 'N'}">진행중</c:when>
				             		<c:otherwise>종료</c:otherwise>
				             	</c:choose>
				             </span>
				           </div>
				         </div>
			        </c:forEach>
			        <div id="searched-page-area">
						<% if(currentPage != 1) {%>
				      		<a href="<%=path%>/search/content?p=<%=currentPage-1%>&search=${par}">&lt;</a>
				      	<%}%>
				         
						<% for(int i = startPage; i <= endPage; i++) {%>
							<% if(i == currentPage) {%>
						 		<a class="currentPage"><%=i%></a>
							<%} else {%>
						 		<a href="<%=path%>/search/content?p=<%=i%>&search=${par}"><%=i%></a>
						 	<%} %>
						 <%} %>
						 
						 <% if(currentPage != maxPage) {%>
				        	<a href="<%=path%>/search/content?p=<%=currentPage+1%>&search=${par}">&gt;</a>
				        <%} %>
			        </div>
			    </div>
          	</c:when>
          	<c:when test="${NullList eq 0}">
	          	<div id="searched-content-header">
		          <div id="searched-header-title">
		            <span class="searched-none">'${param.search}'</span>
		            <span>검색 결과 ></span>
		            <a href = "<%=path%>/search" style="font-size: 14px">돌아가기</a>
		          </div>
		          <div id="searched-header-sort">
		         	<span><a>최신순</a> | <a>인기순</a></span>
		          </div>
		        </div>
		        <div id="searched-content-body">
		        	<br>
		        	<h4 align="center">검색 데이터가 없습니다.</h4>
			    </div>
          	</c:when>
          	<c:when test="${not empty categoryList}">
	          	<div id="searched-content-header">
		          <div id="searched-header-title">
		          	<span class="searched-none">'${c}'</span>
		            <span>카테고리 검색 결과</span>
		          </div>
		          <div id="searched-header-sort">
		         	<span><a href="#" onclick="location.href='<%=path%>/search/category?pr=${pr}&c=${c}'">최신순</a> | <a href="#" onclick="location.href='<%=path%>/search/category?pr=${pr}&c=${c}&s=1'">인기순</a></span>
		          </div>
		        </div>
		        <div id="searched-content-body">
	          		<c:forEach items ="${categoryList}" var="l">
				         <div class="contents">
				           <div class="content-info">
				             <img src="../resources/upload/${l.url}" />
				             <div class="content-info-title">
				             	<span>${l.category}</span>
				             	<c:choose>
				             		<c:when test="${l.category eq '기부'}">
				               			<a class="content-title" href="<%=path%>/view/gibu_detail?type=0&num=${l.regNo}">${l.title}</a>
				             		</c:when>
				             		<c:when test="${l.category eq '펀딩'}">
				               			<a class="content-title" href="<%=path%>/view/funding_detail?type=0&num=${l.regNo}">${l.title}</a>
				             		</c:when>
				             		<c:when test="${l.category eq '캠페인'}">
				               			<a class="content-title" href="<%=path%>/view/campaign_detail?num=${l.regNo}">${l.title}</a>
				             		</c:when>
				             	</c:choose>
				               <span>${l.mNo}</span>
				             </div>
				           </div>
				           <div class="content-info2">
				             <span class="content-info-state">
				             	<c:choose>
				             		<c:when test="${l.fin eq 'N'}">진행중</c:when>
				             		<c:otherwise>종료</c:otherwise>
				             	</c:choose>
				             </span>
				           </div>
				         </div>
			        </c:forEach>
			        <div id="searched-page-area">
						<% if(currentPage != 1) {%>
				      		<a href="<%=path%>/search/category?pr=${pr}&c=${c}&p=<%=currentPage-1%>">&lt;</a>
				      	<%}%>
				         
						<% for(int i = startPage; i <= endPage; i++) {%>
							<% if(i == currentPage) {%>
						 		<a class="currentPage"><%=i%></a>
							<%} else {%>
						 		<a href="<%=path%>/search/category?pr=${pr}&c=${c}&p=<%=i%>"><%=i%></a>
						 	<%} %>
						 <%} %>
						 
						 <% if(currentPage != maxPage) {%>
				        	<a href="<%=path%>/search/category?pr=${pr}&c=${c}&p=<%=currentPage+1%>">&gt;</a>
				        <%} %>
			        </div>
			    </div>
          	</c:when>
          	<c:when test="${not empty recommendList}">
          		<div id="searched-content-header">
		          <div id="searched-header-title">
		            <span class="searched-none" id="searched-num">오늘의 프로젝트</span>
		          </div>
		          <div id="searched-header-sort">
		         	<span><a href="<%=path%>/search?p=1">최신순</a> | <a href="<%=path%>/search?p=1&s=1">인기순</a></span>
		          </div>
		        </div>
		        <div id="searched-content-body">
			        <c:forEach items ="${recommendList}" var="l">
				         <div class="contents">
				           <div class="content-info">
				             <img src="resources/upload/${l.url}" />
				             <div class="content-info-title">
				               <span>${l.category}</span>
				               <c:choose>
				             		<c:when test="${l.category eq '기부'}">
				               			<a class="content-title" href="<%=path%>/view/gibu_detail?type=0&num=${l.regNo}">${l.title}</a>
				             		</c:when>
				             		<c:when test="${l.category eq '펀딩'}">
				               			<a class="content-title" href="<%=path%>/view/funding_detail?type=0&num=${l.regNo}">${l.title}</a>
				             		</c:when>
				             		<c:when test="${l.category eq '캠페인'}">
				               			<a class="content-title" href="<%=path%>/view/campaign_detail?num=${l.regNo}">${l.title}</a>
				             		</c:when>
				             	</c:choose>
				               <span>${l.mNo}</span>
				             </div>
				           </div>
				           <div class="content-info2">
				             <span class="content-info-state">
				             	<c:choose>
				             		<c:when test="${l.fin eq 'N'}">진행중</c:when>
				             		<c:otherwise>종료</c:otherwise>
				             	</c:choose>
				             </span>
				           </div>
				         </div>
			        </c:forEach>
			        <div id="searched-page-area">
						<% if(currentPage != 1) {%>
				      		<a href="<%=path%>/search?p=<%=currentPage-1%>">&lt;</a>
				      	<%}%>
				         
						<% for(int i = startPage; i <= endPage; i++) {%>
							<% if(i == currentPage) {%>
						 		<a class="currentPage"><%=i%></a>
							<%} else {%>
						 		<a href="<%=path%>/search?p=<%=i%>"><%=i%></a>
						 	<%} %>
						 <%} %>
						 
						 <% if(currentPage != maxPage) {%>
				        	<a href="<%=path%>/search?p=<%=currentPage+1%>">&gt;</a>
				        <%} %>
			        </div>
			     </div>
          	</c:when>
          	<c:otherwise>
	          	<div id="searched-content-header">
		          <div id="searched-header-title">
		            <span class="searched-none" id="searched-num">검색 결과</span>
		            <a href = "<%=path%>/search" style="font-size: 14px">> 돌아가기</a>
		          </div>
		          <div id="searched-header-sort">
		         	<span><a>최신순</a> | <a>인기순</a></span>
		          </div>
		        </div>
		        <div id="searched-content-body">
		        	<br>
		        	<h4 align="center">프로젝트가 없습니다.</h4>
			    </div>
          	</c:otherwise>
          </c:choose>
      </div>
    </div>

    <%@ include file="/views/common/footer.jsp" %>
  </body>
</html>
