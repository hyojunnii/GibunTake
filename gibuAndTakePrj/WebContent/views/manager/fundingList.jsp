<%@page import="com.gnt.manager.vo.ManagerVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ManagerVo loginMember = (ManagerVo)session.getAttribute("loginMember");
	
	String alertMsg = (String)session.getAttribute("alertMsg");
	session.removeAttribute("alertMsg");
	
	String contextPath = request.getContextPath();
	String path = request.getContextPath();
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>펀딩내역관리</title>
<link rel="shortcut icon" type="image/x-icon" href="resources/img/free-icon-giving-5017478.png" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&display=swap" rel="stylesheet">
<style>
	*{
        font-family: 'IBM Plex Sans KR', sans-serif;
        box-sizing: border-box;
    }

	#title {
       	background-color: #8bdcb1;
       	width: 1905px;
        text-align: left;
        font-weight: bold;
        font-size: 36px;
        padding: 30px 0px 30px 135px;
    }
    
    #name{
    	color: #15462b;
		text-align: center;
    	font-size: 25px;
    	font-weight: bold;
        padding-bottom: 40px;
    }
    
    #outer1{
        border: 1px solid #2e6c4a;
        color: black;
        width: 55%;
        margin: 0 auto;
        padding-bottom: 50px;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-wrap: wrap;
        text-align: center;
        flex-direction: column;
        margin-top: 20px;
    }
    
   #nav1{
			display : flex;
        	justify-content : space-evenly;
            height: 50px;
            width: 100%;
            margin: 0 auto;
            text-align: center;
            font-size: 1.2rem;
            padding-top: 30px;
    }
    
    .tag{
    	color: green;
    }
    
    #outer2{
        border: 1px solid #2e6c4a;
        color: black;
        width: 55%;
        margin: 0 auto;
        padding-bottom: 30px;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-wrap: wrap;
        flex-direction: column;
        margin-top: 30px;
    }

    #table-main1{
        border: 1px solid white;
        width: 92%;
        margin-top: 10px;
        line-height: 2em;
        padding-top: 20px;
        margin-left: 120px;
    }

	.tr{
		color: green;
	}
    
    #table-main2{
        border: 1px solid white;
        width: 100%;
        margin-top: 10px;
        line-height: 2em;
        padding-top: 20px;
        margin-left: 120px;
    }
    
    #category1{
    	width: 100px;
    	height: 40px;
    	border-radius: 15px;
    	margin-left: 250px;
    	border: 1px solid #2e6c4a;
    }
    
    #category2{
    	width: 100px;
    	height: 40px;
    	border-radius: 15px;
    	margin-left: 5px;
    	border: 1px solid #2e6c4a;
    }
    
    #outer3{
    	background-color: lightgray;
        border: 1px solid #2e6c4a;
        color: black;
        width: 55%;
        margin-top: 30px;
        margin-left: 340px;
        padding: 20px 0px 20px 0px;

    }
    
    #search{
    	background-color: #8bdcb1;
    	border-radius: 15px;
    	width: 100px;
    	height: 40px;
    	margin: 0px 0px 0px 20px;
    }
    
    #search:hover{
    	background-color: #93e1b7;
        cursor: pointer;
    }
    
    #outer4{
        border: 1px solid #2e6c4a;
        color: black;
        width: 55%;
        margin: 0 auto;
        padding-bottom: 50px;
        display: flex;
        justify-content: center;
        align-items: center;
        flex-wrap: wrap;
        text-align: center;
        flex-direction: column;
        margin-top: 30px;
    }

    #table-main3{
        border: 1px solid white;
        width: 100%;
        margin-top: 10px;
        line-height: 2.5em;
    }
    
    #head{
    	font-weight: bold;
    }
    
    #body1:hover{
    	background-color: #93e1b7
    }
    
    #body2:hover{
    	background-color: #93e1b7
    }
    
    #body3:hover{
    	background-color: #93e1b7
    }
    
    #a:hover{
    	cursor: pointer;
    }
    
    #b:hover{
    	cursor: pointer;
    }
    
    #c:hover{
    	cursor: pointer;
    }
    
    #a{
    	width: 40px;
    	height: 40px;
    	border: 1px solid black;
    	background-color: white;
        font-weight: bold;
    }
    
    #b{
    	width: 40px;
    	height: 40px;
    	border: 1px solid black;
    	background-color: white;
        font-weight: bold;
    }
    
    #c{
    	width: 40px;
    	height: 40px;
    	border: 1px solid black;
    	background-color: white;
        font-weight: bold;
    }

    
    .input{
    	background-color: white;
    	color: green;
    	margin-left: 130px;
    	margin-top: 30px;
    	font-weight: bold;
    	border-radius: 15px;
    	border: 0px;
    }
    
    .input:hover{
    	cursor: pointer;
    }
    
    #btn1{
    	margin-left: 130px;
    }
    
    #btn2{
    	margin-left: 130px;
    }
    
    #btn{
    	margin-top: 80px;
    	text-align: center;
    }
    
    #a:hover{
    	cursor: pointer;
    }
    
    #b:hover{
    	cursor: pointer;
    }
    
    #c:hover{
    	cursor: pointer;
    }
    
    #a{
    	width: 40px;
    	height: 40px;
    	border: 1px solid #2e6c4a;
    	color: #2e6c4a;
        font-weight: bold;
    }
    
    #b{
    	width: 40px;
    	height: 40px;
    	border: 1px solid #2e6c4a;
    	color: #2e6c4a;
        font-weight: bold;
    }
    
    #c{
    	width: 40px;
    	height: 40px;
    	border: 1px solid #2e6c4a;
    	color: #2e6c4a;
        font-weight: bold;
    }
    
    #last{
    	padding: 600px;
    }
    
    #site_header{
        width: 100%;
        vertical-align: middle;
        padding-top: 15px;
        padding-bottom: 15px;
        border-bottom: 1px solid #14AE5C;
        display : flex;
        align-items: center;
    	justify-content: space-evenly;
    }

    #site_header>div{
        vertical-align: middle;
    }

    

    #siteName{
        font-size: 30px;
        vertical-align: bottom;
    }
    
    #logo_name>*{
        text-decoration: none;
    }

    
    
    #site_header a{
    	text-decoration: none;
    	color: black;
    }

    #logo_name>a>*{
        vertical-align: middle;
        height: 45px;
    }

    #siteName_small{
        font-size: 15px;
        
        
    }

    

    #serch_icon{
        width: 35px;
        height: 35px;
    }

    #login{
        font-size: 20px;
        margin-right: 15px;
    }

    #login_serch>a{
        vertical-align: middle;
    }

    .selected_bg{
        background-color: #EBF5E0;
    }

    .greenBold{
        color: #086C37;
        font-weight: bold;
    }

    .top_menu_click{
        margin-left: 5px;
        margin-right: 5px;
        padding-left : 4px;
        padding-right : 4px; 
        font-size: 30px;
        border-radius: 15px
    }
    
    .top_menu_click:hover{
        background-color: #EBF5E0;
        color : #086C37;
        font-weight: 900;
    }

    .float_right{
        float: right;
    }
    .float_right::after{
        clear: both;
    }

    #header_wrap{
        width: 1200px;
        display: flex;
        align-items: center;
        justify-content: space-evenly;
    }

    #logo{
        width: 45px;
        height: 45px;
    }

    #logo_name{
        width: 400px;
    }

    #top_menu{
        width: 450px;
    }

    #login_serch{
        width: 400px;
        display: flex;
        justify-content: flex-end;
    }
</style>
</head>
<body>
 	<header id="site_header">
        <div id="header_wrap">
            <div id="logo_name">
                <a href="<%=request.getContextPath()%>">
                    <img id="logo" src="<%=path %>/resources/img/free-icon-giving-5017478.png" alt="홈페이지 로고">
                    <span id="siteName"><span class="greenBold selected_bg">기부 앤 테이크</span><span id="siteName_small" class="greenBold">Gibu n Take</span></span>
                </a>
            </div>
            <div id="top_menu" class="">
                <nav>
                    <span>
                        <a href="<%=path %>/introduce/site" class="top_menu_click">소개</a>
                        <a href="<%=path %>/view/gibu" class="top_menu_click">기부</a>
                        <a href="<%=path %>/view/funding" class="top_menu_click">펀딩</a>
                        <a href="<%=path %>/view/campaign" class="top_menu_click">캠페인</a>
                        <a href="<%=request.getContextPath()%>/story" class="top_menu_click">스토리</a>
                    </span>
                </nav>
            </div>
            <div id="login_serch" class="">
            	<c:choose>
            		<c:when test="${!empty memberVo }">
            			<a href="<%=path %>/member/MyPage"><span id="login">${memberVo.name}님</span></a>
                		<a href="<%=path %>/search"><img id="serch_icon" src="<%=path %>/resources/img/free-icon-search-149309.png" alt="검색아이콘"></a>
            		</c:when>
            		<c:otherwise>
        	    		<%if(loginMember != null){%>
							<a href="/gibuAndTakePrj/manager/login">로그아웃</a>
						<%}else{%>
							<a href="/gibuAndTakePrj/manager/login">로그인</a>
						<%}%>&nbsp&nbsp
		                <a href="<%=path %>/search"><img id="serch_icon" src="<%=path %>/resources/img/free-icon-search-149309.png" alt="검색아이콘"></a>	
            		</c:otherwise>
            	</c:choose>
            </div>
        </div>
    </header>
    <div id="title">관리자</div>
    
	 <div style="border: 1px solid #72d09e; float: left; width: 20%; height:1200px; padding:10px;">
		
		<form action="/gibuAndTakePrj/manager/list" method="get">
			<input class="input" type="submit" value="활동내역관리">
		</form>
		
		<form action="/gibuAndTakePrj/manager/pay" method="get">
			<input class="input" type="submit" value="결제내역관리">
		</form>
		
		<form action="/gibuAndTakePrj/manager/sanction" method="get">
			<input id="btn1" class="input" type="submit" value="사용자 제재">
		</form>
		
		<form action="/gibuAndTakePrj/manager/approvelist" method="get">
			<input id="btn2" class="input" type="submit" value="승인목록">
		</form>
	 </div>
	 
	 <div style="border: 1px solid #72d09e; float: left; width: 80%; height:1200px; padding:50px 0px 0px 0px;">
	
			<div id="name">펀딩 내역 관리</div>
			
			<div id="outer1">
			<nav id="nav1">
				<a href="/gibuAndTakePrj/manager/list">전체내역</a>
		        <a href="/gibuAndTakePrj/manager/donation">기부내역</a>
		        <a href="/gibuAndTakePrj/manager/funding" class="tag">펀딩내역</a>
			</nav>
			</div>
			
			<div id="outer2">		
	        <table id="table-main1">
	            <thead id="head">
	                <tr>
	                    <td>후원한 총 모금함</td>
	                    <td>총 기부금액</td>
	                </tr>
	            </thead>
	            
	            <tbody>        
                    <tr class="tr">
                        <td>2개</td>
                        <td >10000원</td>
                    </tr>
            	</tbody>            
        </table>
    	</div>
    	
    	<div id="outer2">		
	        <table id="table-main2">
	            <thead id="head">
	                <tr>
	                    <td>이번 달 후원 모금함</td>
	                    <td>이번 달 기부금액</td>
	                </tr>
	            </thead>
	            
	            <tbody>        
                    <tr class="tr">
                        <td>1개</td>
                        <td >5000원</td>
                    </tr>
            	</tbody>            
        </table>
    	</div>
		
		<div id="outer3">
			<td>
                 <select id="category1">
                 	 <option value="1">전체기간</option>
                     <option value="10">1월</option>
                     <option value="20">2월</option>
                     <option value="30">3월</option>
                     <option value="40">4월</option>
                     <option value="50">5월</option>
                     <option value="60">6월</option>
                     <option value="70">7월</option>
                     <option value="80">8월</option>
                     <option value="90">9월</option>
                     <option value="100">10월</option>
                     <option value="110">11월</option>
                     <option value="120">12월</option>
                 </select>
             </td>
             ~
	    	<td>
                 <select id="category2">
                 	 <option value="1">전체기간</option>
                     <option value="10">1월</option>
                     <option value="20">2월</option>
                     <option value="30">3월</option>
                     <option value="40">4월</option>
                     <option value="50">5월</option>
                     <option value="60">6월</option>
                     <option value="70">7월</option>
                     <option value="80">8월</option>
                     <option value="90">9월</option>
                     <option value="100">10월</option>
                     <option value="110">11월</option>
                     <option value="120">12월</option>
                 </select>
             </td>
             <button id="search">검색</button>
		</div>
		
		<div id="outer4">		
	        <table id="table-main3">
	            <thead id="head">
	                <tr>
	                    <td>날짜</td>
	                    <td>제목</td>
	                    <td>기업</td>
	                    <td>금액</td>
	                </tr>
	            </thead>
	            
	            <tbody>        
                    <tr id="body1">
                        <td>2022/08/05</td>
                        <td>펀딩</td>
                        <td>기업</td>
                        <td>50,000원</td>
                    </tr>
                    <tr id="body2">
                        <td>2022/08/04</td>
                        <td>펀딩</td>
                        <td>기업</td>
                        <td>70,000원</td>
                    </tr>
                    <tr id="body3">
                        <td>2022/08/03</td>
                        <td>펀딩</td>
                        <td>기업</td>
                        <td>50,000원</td>
                    </tr>
            	</tbody>            
        </table>
    	</div>
    	
    	<div id="btn">
	    	<a id="a">&nbsp&nbsp<&nbsp&nbsp</a>
	        <a id="b">&nbsp&nbsp1&nbsp&nbsp</a>
	        <a id="b">&nbsp&nbsp2&nbsp&nbsp</a>
	        <a id="b">&nbsp&nbsp3&nbsp&nbsp</a>
	        <a id="b">&nbsp&nbsp4&nbsp&nbsp</a>
	        <a id="b">&nbsp&nbsp5&nbsp&nbsp</a>
	        <a id="c">&nbsp&nbsp>&nbsp&nbsp</a>
	    </div>
    
   		<%-- <div id="page-area">
				<%if(currentPage != 1){%>
					<a class="btn btn-sm btn-primary" href="/semi/board/list?p=<%=currentPage-1%>"> &lt; </a>
				<%} %>
				<% for(int i = startPage; i <= endPage; ++i) {%>
					<%if(i == currentPage) {%>
						<a class="btn btn-sm btn-primary"><%=i%></a>
					<%}else{ %>
						<a class="btn btn-sm btn-primary" href="<%=contextPath%>/board/list?p=<%=i%>"><%=i%></a>
					<%} %>
				<%} %>
				
				<%if(currentPage != maxPage){%>
					<a class="btn btn-sm btn-primary" href="/semi/board/list?p=<%=currentPage+1%>"> &gt; </a>
				<%} %>
			</div> --%>
		
	</div>
    	<div id="last"></div>
       <%@include file="/views/common/footer.jsp" %>
       
       
</body>
</html>
