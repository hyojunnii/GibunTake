<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기부앤테이크 소개</title>
<style>

    #int-nav{
        display: flex;
        justify-content : space-evenly;
        height: 50px;
        width: 800px;
        margin: 0 auto;
        text-align: center;
        font-size: 20px;
        margin-top: 20px;
    }

    #int-nav a{
        text-decoration: none;
        text-align: center;
        line-height: 40px;
        padding: 5px;
    }

    #int-nav a:hover{
        background-color: #EBF5E0;
        color: #2e6c4a;
		border-radius: 15px;
        font-weight: bolder;
    }

    #category{
		width: 100%;
		height: 100px;
		background-color: #8bdcb1;
		text-align: left;
		font-size: 25px;
		font-weight: 700;
		line-height: 100px;
		margin: 0 0 0 0;
        margin-top: 20px;
	}
	#category a {
		margin: 0 0 0 20px;
	}

    a { text-decoration: none; color: black; }
    a:visited { text-decoration: none; }
    a:hover { text-decoration: none; }
    a:focus { text-decoration: none; }
    a:hover, a:active { text-decoration: none; }

</style>
</head>
<body>

    <%@include file="/views/common/header.jsp" %>
    <nav id="int-nav">
        <a href="<%=contextPath %>/introduce/site" id="what">기부앤테이크?</a>
        <a href="<%=contextPath %>/introduce/way" id="way">참여하는 법</a>
    </nav>

</body>
</html>