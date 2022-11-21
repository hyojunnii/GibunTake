<%@page import="com.gnt.manager.vo.ManagerVo"%>
<%@page import="com.gnt.notice.vo.NoticeVo"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%
	ManagerVo loginMember = (ManagerVo)session.getAttribute("loginMember");
	NoticeVo vo = (NoticeVo)request.getAttribute("vo");
	
	String contextPath = request.getContextPath();
	String path = request.getContextPath();
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>      
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="shortcut icon" type="image/x-icon" href="resources/img/free-icon-giving-5017478.png" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&display=swap" rel="stylesheet">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
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
        padding: 30px 0px 30px 430px;
    }
    
    #gap{
    	padding-bottom: 50px;
    }

    #table-main{
        border: 1px solid #2e6c4a;
        width: 1050px;
        height: 600px;
        margin: 0px 430px;
        border-radius: 10px;
        border-collapse: collapse;
    }
    
    #a{
        border: 1px solid #2e6c4a;
        color: #2e6c4a;
        width: 100%;
        height: 60px;
		font-weight: bold;
		text-indent: 15px;
		
    }

    #b{
        border: 1px solid #2e6c4a;
        color: #2e6c4a;
        width: 100%;
        height: 600px;
        vertical-align : top;
        text-indent: 15px;
    }

	#c{
		padding: 10px 0px 0px 0px;
	}
    
    .date{
        text-align: right;
        font-weight: 100;
        padding: 0px 70px 0px 0px;
    }


    #tag{
        padding: 50px;
        margin-bottom: 30px;
        margin-left: 750px;
    }
    
    #list{
       	background-color: #b3e0c9;
    	border: 2px solid #acdac2;
        font-weight: bold;
        padding: 10px;
        margin: 0px 60px 0px 0px;
        border-radius: 15px;
    }

    #modify{
        background-color: #b3e0c9;
    	border: 2px solid #acdac2;
        font-weight: bold;
        padding: 10px 20px 10px 20px;
        border-radius: 15px;
        color: black;
    }

    #list:hover{
    	background-color: #93e1b7;
        cursor: pointer;
    }  
    
    #modify:hover{
    	background-color: #93e1b7;
        cursor: pointer;
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
							<a href="/gibuAndTakePrj/manager/logout">로그아웃</a>
						<%}else{%>
							<a href="/gibuAndTakePrj/manager/login">로그인</a>
						<%}%>&nbsp&nbsp
		                <a href="<%=path %>/search"><img id="serch_icon" src="<%=path %>/resources/img/free-icon-search-149309.png" alt="검색아이콘"></a>	
            		</c:otherwise>
            	</c:choose>
            </div>
        </div>
    </header>
	
	<div id="title">공지사항</div>
    <div id="gap"></div>
    
    <table id="table-main">
    	<tr id="a" class="border">
			<td><%=vo.getTitle() %></td>
			<td class="date"><%=vo.getDate()%></td>
    	</tr>
    	<tr id="b" class="border">
			<td id="c"><%=vo.getContent()%></td>
			<td></td>
    	</tr>
    </table>
    
    <div id="tag">
        <a id="list" onclick="location.href='/gibuAndTakePrj/notice/list'">공지사항 목록</a>
        
        <% if(loginMember != null && "admin".equals(loginMember.getId())) {%> 
        <a id="modify" href="/gibuAndTakePrj/notice/modify?num=<%=vo.getNo()%>">수정/삭제</a>
    	<%} %> 
    </div>
        
    
    <%@include file="/views/common/footer.jsp" %>
      
       
</body>
</html>