<%@page import="com.gnt.corp.vo.corpVo"%>
<%@page import="com.gnt.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	String path = request.getContextPath();
	MemberVo memberVo = (MemberVo)request.getSession().getAttribute("loginMember");
	corpVo corpVo = (corpVo)request.getSession().getAttribute("loginCorp");
	String alertMsg = (String)session.getAttribute("alertMsg");
	session.removeAttribute("alertMsg");
%>

<c:set var="path" value="<%=path %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gibu n Take</title>
<link rel="shortcut icon" type="image/x-icon" href="../resources/img/free-icon-giving-5017478.png" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&display=swap" rel="stylesheet">
<style>
    *{
        font-family: 'IBM Plex Sans KR', sans-serif;
        box-sizing: border-box;
    }

    #site_header{
        width: 100%;
        vertical-align: middle;
        padding-top: 15px;
        padding-bottom: 15px;
        border-bottom: 2px solid #14AE5C;
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
        margin-right: 18px;
    }

	#logout{
		margin-right:25px;
		margin-top:5px;
	}
    
    #login_serch>a{
        vertical-align: middle;
    }

    .selected_bg{
        background-color: #EBF5E0;
        border-radius: 10px;
        margin-right: 4px;
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
        font-size: 28px;
        border-radius: 15px;
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
        width: 500px;
        margin-left: 100px;
    }
    
    #login_serch{
        width: 400px;
        display: flex;
        justify-content: flex-end;
    }

</style>
</head>
<body>
    <!-- 아이콘 출처 : <a href="https://www.flaticon.com/kr/free-icons/" title=" 아이콘"> 아이콘  제작자: Smashicons - Flaticon</a> -->
    <!-- 헤더 수정 넓이 100% -->
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
            		<c:when test="${!empty loginMember }">
            			<a href="<%=path %>/member/MyPage"><span id="login">${loginMember.name}님</span></a>
            			<a href="<%=path %>/logout" id="logout">로그아웃</a>
                		<a href="<%=path %>/search"><img id="serch_icon" src="<%=path %>/resources/img/free-icon-search-149309.png" alt="검색아이콘"></a>
            		</c:when>
            			<c:when test="${!empty loginCorp }">
 	            		<a href="<%=path %>/corp/corpMyPage"><span id="login">${loginCorp.name}님</span></a>
                		<a href="<%=path %>/logout" id="logout">로그아웃</a>
                		<a href="<%=path %>/search"><img id="serch_icon" src="<%=path %>/resources/img/free-icon-search-149309.png" alt="검색아이콘"></a>
            		</c:when>
            		<c:otherwise>
            			<a href="<%=path %>/login"><span id="login">로그인</span></a>
		                <a href="<%=path %>/search"><img id="serch_icon" src="<%=path %>/resources/img/free-icon-search-149309.png" alt="검색아이콘"></a>	
            		</c:otherwise>
            	</c:choose>
            		
            </div>
        </div>
    </header>
    
    <script>
      <%if(alertMsg != null){%>
      	alert('<%= alertMsg%>');
      <%}%>
    </script>
</body>
</html>