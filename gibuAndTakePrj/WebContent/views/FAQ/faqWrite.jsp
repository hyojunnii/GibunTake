<%@page import="com.gnt.faq.vo.CategoryVo"%>
<%@page import="java.util.List"%>
<%@page import="com.gnt.faq.vo.FaqVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.gnt.manager.vo.ManagerVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	ManagerVo loginMember = (ManagerVo)session.getAttribute("loginMember");
	ArrayList<FaqVo> vo = (ArrayList<FaqVo>)request.getAttribute("vo");
	
	String contextPath = request.getContextPath();
	String path = request.getContextPath();
	
	List<CategoryVo> list = (List<CategoryVo>)request.getAttribute("list");
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<title>Insert title here</title>
<style>
	*{
        font-family: 'IBM Plex Sans KR', sans-serif;
        box-sizing: border-box;
    }

	#head {
        background-color: #8bdcb1;
        width: 1905px;
        text-align: left;
        font-weight: bold;
        font-size: 36px;
       	padding: 30px 0px 30px 100px;
    }

    
    #category{
    		color: #15462b;
            margin: 0px 70px 0px 215px;
            font-weight: bold;         
    }
    
    #title{
    		color: #15462b;
            margin: 0px 70px 0px 230px;
            font-weight: bold;         
    }

    #content{
    		color: #15462b;
            margin: 0px 70px 0px 230px;
            font-weight: bold;
    }

    
    #input1{
			border: 2px solid #acdac2;
			border-radius: 10px;    
            width: 650px;
            height: 40px;
            color: black;
            margin: 5px 0px 0px 15px;
    }

    #input2{
    		border: 2px solid #acdac2;
			border-radius: 10px;
            width: 650px;
            height: 400px;
            color: black;                      
            margin: 5px 0px 0px 15px;
            vertical-align: middle;
    }

    #btn{
        background-color: #b3e0c9;
    	border: 2px solid #acdac2;
        margin: 0px 630px;
        margin-top: 20px;
        padding: 10px;
        font-weight: bold;
        border-radius: 15px;
    }

    #btn:hover{
    	background-color: #93e1b7;
        cursor: pointer;
    }
    
    #a{
    	border: 2px solid #acdac2;
		border-radius: 10px;
    	width: 650px;
    	height: 40px;
    }
    
    .click{
    	background-color: white;
    	color: green;
    	margin-left: 120px;
    	margin-top: 30px;
    	font-weight: bold;
    	border-radius: 15px;
    	border: 0px;
    }
    
    .click:hover{
    	cursor: pointer;
    }
    
    #campaign{
    	margin-left: 115px;
    }
    
    #last {    
        padding: 340px;
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
	
	<div id="head">FAQ 작성</div>
	
		<div style="border: 1px solid #72d09e; float: left; width: 20%; height:720px; padding:0px 0px 0px 20px;">
		<form action="" method="get">
			<input class="click" type="submit" value="기부">
		</form>
		
		<form action="" method="get">
			<input class="click" type="submit" value="펀딩">
		</form>
		
		<form action="" method="get">
			<input id="campaign" class="click" type="submit" value="캠페인">
		</form>
		<form action="" method="get">
			<input class="click" type="submit" value="기타">
		</form>
	 </div>
	 <div style="border: 1px solid #72d09e; float: left; width: 80%; height:720px; padding:50px 0px 0px 0px;">			
    	
    	<form action="/gibuAndTakePrj/faq/write1" method="post">
	 	<input type="hidden" name="no" value="<%=loginMember.getNo() %>">
	 	<label id="category">카테고리</label>                   
	    	<td>
                 <select name="cate" id="a">
                     <%for(CategoryVo c : list){ %>
                 <option value="<%=c.getCategoryName()%>"><%=c.getCategoryName()%></option>
                <%} %>
                 </select>
             </td>
	    <br><br>
	    
    	<label id="title">제목</label>
	    <input id="input1" type="text" name="title" required>
	    <br><br>
	    <label id="content">내용</label> 
	    <textarea id="input2" name="content"></textarea>
	    <div >
            <input id="btn" type="submit" value="작성하기">
        </div>
	    
    </form>
    </div>
	<div id="last"></div>
	
	<%@include file="/views/common/footer.jsp" %>
</body>
</html>