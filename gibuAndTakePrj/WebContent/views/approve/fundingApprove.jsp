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
<title>펀딩 승인</title>
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
        padding: 30px 0px 30px 550px;
    }
	
    div{
        box-sizing: border-box;
    }
    
    table {
        width: 820px;
        height: 700px;
        border-top: 1px solid black;
        border-collapse: collapse;
    } 
    
    .wrap{
        width: 800px;
        height: 850px;
        margin: auto;
        padding: 30px 0px 0px 0px;
    }

    .wrap>div{width: 100%;}
     #one{height: 7%;}
     #two{ height: 7%;}
     #three{height: 5%;}
     #four{height: 7%;}
     #five{height: 7%;}
     #eleven{height: 7%;}
     
     #two_1{width: 10%;}
     #two_2{width: 40%;}
     #two_3{width: 40%;}
    
     #four_1{width: 40%;}
     #four_2{width: 40%;}
     
    #one{
    	border: 1px solid #2e6c4a;
    	width: 820px;
    	height: 150px;
        margin: auto;
    }
    
    #a {
        width: 820px;
        margin: auto;
        padding: 5px 0px;
        text-indent: 1em;
    }

    #b{
    	padding: 20px 0px 0px 0px;
        text-align: center;
        font-size: 20px;
        font-weight: 700;
    }
    
    #two{
    	border: 1px solid #2e6c4a;
    	width: 820px;
    	height: 70px;	
        margin: auto;
    }
    
    #two_1{
    	border: 1px solid #2e6c4a;
    	width: 309px;
    	vertical-align : top;
        margin: auto;
    }
    
    #two_2{
    	border: 1px solid #2e6c4a;
    	width: 200px;
        margin: auto;
        vertical-align : top;
    }
    
    #three{
    	border: 1px solid #2e6c4a;
    	width: 820px;
    	height: 30px;
        margin: auto;
    }
    
    #four{
    	border: 1px solid #2e6c4a;
    	width: 820px;
    	height: 70px;
        margin: auto;
    }
    
    #four_1{
    	border: 1px solid #2e6c4a;
      	vertical-align : top;
    }
    
    #four_2{
    	border: 1px solid #2e6c4a;
      	vertical-align : top;
    }
    
    #five_1{
    	border: 1px solid #2e6c4a;
     	vertical-align : top;
    }
    
    #five_2{
    	border: 1px solid #2e6c4a;
      	vertical-align : top;
    }
    
    #eleven_1{
    	border: 1px solid #2e6c4a;
     	vertical-align : top;
    }
    
    #eleven_2{
    	border: 1px solid #2e6c4a;
      	vertical-align : top;
    }
    
    #six{
    	border: 1px solid #2e6c4a;
    	width: 820px;
    	height: 350px;
    }
    
    #seven {
        width: 820px;
        margin: auto;
        padding: 5px 0px;
        text-indent: 1em;
    }
    
    #eight{
    	width: 800px;
    	padding: 50px 15px;
        margin: auto;
        text-align: right;
    }

	#nine{
		width: 800px;
		padding: 20px;
		text-align: center;
	}
	
	#ten{
		border: 1px solid red;
		color: red;
		width: 500px;
		padding: 10px;
		text-align: center;
	}
	
	.line1{
		width: 320px;
		height: 70px;
	}
	
	.line2{
		width: 320px;
		height: 70px;
	}
	
	#btn{
        background-color: #b3e0c9;
    	border: 2px solid #acdac2;
        width:100px;
        margin: 50px auto;
        display:block;
        border-radius: 15px;
        font-size: 20px;
        font-weight: 700;
    }
    
    #btn:hover{
    	background-color: #93e1b7;
    	cursor: pointer;
    }
	
	#last {    
        padding: 260px;
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
    
	<div id="title">펀딩 승인</div>
	
	<form action="/gibuAndTakePrj/manager/fundinglist" method="get">
     <div class="wrap">
	<div id="one">
		<div id="a">승인번호 제&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp호</div>
		<div id="b">펀딩 사업 승인증</div>
	</div>

    <table border="1">
        <tr id="two">
            <td style="text-align: center;">승인대상자</td>
            <td colspan="2" class="line" id="two_1">기업명
            	<input type="text" size="20" style="width:100%; height:60%; border: 0; outline:none; text-align: center;">
            </td>
           
        </tr>
        <tr id="three">
            <td colspan="3"></td>
        </tr>
        <tr id="four">
            <td rowspan="3" style="text-align: center;">실시계획<br>승인<br>(신고수리)</td>
            <td class="line" id="four_1">제목
            	<input type="text" name="text" size="20" style="width:100%; height:60%; border: 0; outline:none; text-align: center;">
            </td>
            <td class="line" id="four_2">제품명
            	<input type="text" name="text" size="20" style="width:100%; height:60%; border: 0; outline:none; text-align: center;">
            </td>
                    
        </tr>
        <tr id="five">
            <td class="line2" id="five_1">기간
            	<input type="text" name="text" size="20" style="width:100%; height:60%; border: 0; outline:none; text-align: center;">
            </td> 
            <td class="line2" id="five_2">수량
            	<input type="text" name="text" size="20" style="width:100%; height:60%; border: 0; outline:none; text-align: center;">
            </td>
        </tr>
        <tr id="eleven">
            <td class="line2" id="eleven_1">금액
            	<input type="text" name="text" size="20" style="width:100%; height:60%; border: 0; outline:none; text-align: center;">
            </td> 
            <td class="line2" id="eleven_2">목표 금액
            	<input type="text" name="text" size="20" style="width:100%; height:60%; border: 0; outline:none; text-align: center;">
            </td>
        </tr>
        </table>
   
   
    <div id="six">
		<div id="seven">제 00조 00항에 의하여 실시 사업 계획을 승인(신고 수리) 합니다. </div>
		<div id="eight"><input type="text" name="text" size="20" style="width:100%; height:10%; border: 0; outline:none; text-align: right;"></div>
		<div id="nine">추천관리청의 장&nbsp&nbsp&nbsp<span id="ten">직인</span></div>
	</div>
	
	<div>
		<input id="btn"  type="submit" value="승인">
	</div>
	
   </div>
  </form>
    
    <div id="last"></div> 
    
       <%@include file="/views/common/footer.jsp" %>
</body>
</html>
