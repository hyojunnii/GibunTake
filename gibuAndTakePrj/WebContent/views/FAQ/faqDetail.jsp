<%@page import="com.gnt.common.PageVo"%>
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
	
	PageVo pv = (PageVo)request.getAttribute("pv");
	
	int currentPage = pv.getCurrentPage();
	int startPage = pv.getStartPage();
	int endPage = pv.getEndPage();
	int maxPage = pv.getMaxPage();
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<title>FAQ</title>
<style>
	*{
        font-family: 'IBM Plex Sans KR', sans-serif;
        box-sizing: border-box;
    }

	#to{
            width: 100px;
            height: 100px;
            border: 1px solid black;
            background-color: skyblue;
        }
	
    #title {
        background-color: #8bdcb1;
       	width: 1905px;
        text-align: left;
        font-weight: bold;
        font-size: 36px;
        padding: 30px 0px 30px 150px;
    }
    
    .search {
	  position: relative;
	  width: 250px;
      border-radius: 10px;
	  float: right;
	  margin-right: 300px;
	}
	
	#search {
	  width: 100%;
	  border: 1px solid #2e6c4a;
	  border-radius: 10px;
	  padding: 10px 12px;
	  font-size: 14px;
	}
	
	#icon {
	  position : absolute;
	  width: 17px;
	  top: 25px;
	  right: 12px;
	  margin: 0;
	}
	
	.toggle{
    	border: 2px solid #acdac2;
    	background-color: white;
    	border-radius: 10px;
    	width: 650px;
    	height: 40px;
    	margin: 15px 70px 0px 390px;
    	text-align: left;
	}
	
	.toggle:hover{
        cursor: pointer;
	}
	
	.toggle2{
		border: 2px solid #acdac2;
    	background-color: white;
    	border-radius: 10px;
    	width: 650px;
    	height: 80px;
    	margin: 0px 70px 0px 390px;
    	text-align: left;
	}
	
	#toggle{
		margin-top: 30px;
	}
	
	#img{
		background-color: white;
		border: 0;
    	border-radius: 10px;
    	margin: 0px 70px 0px -110px;
    	font-size: 17px;
		text-align: right;
	}
    
    .input{
    	background-color: white;
    	color: green;
    	margin-left: 140px;
    	margin-top: 30px;
    	font-weight: bold;
    	border-radius: 15px;
    	border: 0px;
    }
    
    .input:hover{
    	cursor: pointer;
    }
    
    #campaign{
    	margin-left: 135px;
    }
    
    #category{
    	border: 2px solid #acdac2;
		border-radius: 10px;
    	width: 650px;
    	height: 40px;
    	margin: 0px 70px 0px 350px;
    }
    
    #btn1{
        background-color: #b3e0c9;
    	border: 2px solid #acdac2;
        margin-top: 5px;
        padding: 3px 10px 3px 10px;
        font-weight: bold;
        border-radius: 15px;
        margin-left: 860px;
    }

    #btn1:hover{
    	background-color: #93e1b7;
        cursor: pointer;
    }
    
    #btn2{
        background-color: #b3e0c9;
    	border: 2px solid #acdac2;
        padding: 3px 10px 3px 10px;
        font-weight: bold;
        border-radius: 15px;
        margin: 5px 0px 0px 10px;
    }

    #btn2:hover{
    	background-color: #93e1b7;
        cursor: pointer;
    }
    
    .btn3{
    	float: left;
    }
    
    #page-area{
		margin: auto;
		padding-top: 80px;
		width: 150px;
    	height: 40px;
    	color: #2e6c4a;
        font-weight: bold;
	}
    
    #last{
    	padding: 320px;
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
    
	<div id="title">FAQ
		<div class="search">
				   <input id="search" type="text" placeholder="검색어 입력">
				   <img id="icon" src="https://s3.ap-northeast-2.amazonaws.com/cdn.wecode.co.kr/icon/search.png">
				</div>
	</div>
    
	 <div style="border: 1px solid #72d09e; float: left; width: 20%; height:640px; padding:0px 0px 0px 20px;">
		<form action="/gibuAndTakePrj/faq/list" method="get">
			<input class="input" type="submit" value="기부">
		</form>
		
		<form action="/gibuAndTakePrj/faq/fundinglist" method="get">
			<input class="input" type="submit" value="펀딩">
		</form>
		
		<form action="/gibuAndTakePrj/faq/campaignlist" method="get">
			<input id="campaign" class="input" type="submit" value="캠페인">
		</form>
		
		<form action="/gibuAndTakePrj/faq/otherlist" method="get">
			<input class="input" type="submit" value="기타">
		</form>		
	 </div>
	 <div style="border: 1px solid #72d09e; float: left; width: 80%; height:640px; padding:50px 0px 0px 0px;">                  
	    	
	    	
            
            <form action="/gibuAndTakePrj/faq/list" method="get">
	    	<%for(int i = 0; i < vo.size(); i++) {%>  
	    	<button class="toggle"><%= vo.get(i).getTitle()%><button id="img">▲</button></button>
	    	<button class="toggle2"><%= vo.get(i).getContent()%></button>
	    	
           <%}%> 
            </form>
	    	
	    	<% if(loginMember != null && "admin".equals(loginMember.getId())) {%>
	    	<form action="/gibuAndTakePrj/faq/write1" method="get">
		    	<input id="btn1" class="btn3" type="submit" value="FAQ작성">
	    	</form>
	    	
	    	<form action="/gibuAndTakePrj/faq/modify" method="get">
	        	<input id="btn2" class="btn3" type="submit" value="FAQ수정/삭제">
	    	</form>
	    	<%} %>
	    
	    <div id="page-area">
				<%if(currentPage != 1){%>
					<a href="/gibuAndTakePrj/faq/list?p=<%=currentPage-1%>"> &lt; </a>
				<%} %>
				<% for(int i = startPage; i <= endPage; ++i) {%>
					<%if(i == currentPage) {%>
						<a><%=i%></a>
					<%}else{ %>
						<a href="/gibuAndTakePrj/faq/list?p=<%=i%>"><%=i%></a>
					<%} %>
				<%} %>
				
				<%if(currentPage != maxPage){%>
					<a href="/gibuAndTakePrj/faq/list?p=<%=currentPage+1%>"> &gt; </a>
				<%} %>
				
			</div>
	    
	  </div>
	<div id="last"></div>
	<%@include file="/views/common/footer.jsp" %>
	
	
</body>
</html>