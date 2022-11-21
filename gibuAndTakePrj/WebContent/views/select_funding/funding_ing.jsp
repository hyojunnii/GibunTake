<%@page import="com.gnt.funding.vo.FundingVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	List<FundingVo> list = (List<FundingVo>)request.getAttribute("fundingvo"); 
	int fundingcnt = (Integer)request.getAttribute("fundingcnt");
%>
<!DOCTYPE html>

<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    *{
        box-sizing: border-box;
    }

    #group_catelist ul{
        margin: 0 10%;
        height: 80px;
        background-color: #8bdcb1;
        border-radius: 10px;
    }
    
    #group_catelist ul li{
        list-style: none;
        float: left;
        width: 12.5%;
        height:100%;
        text-align: center;
        line-height: 15px;
    }
    
    #group_catelist ul li a span{
        font-size: 20px;
        line-height: 50px;
    }
    /* #group_catelist ul li a img{
        margin-top: 5%;
        width: 50px;
        height: 50px;
        object-fit: cover;
    } */
    
    
    .container{
        margin: 0 10%;
        margin-top: 30px;
        height: auto;
    }
    .container>p {
        font-weight: 800;
        font-size: 30px;
    }
    
    .card:hover{
        text-decoration: none;
    }
    
    .card{
        float: left;
        width: 267px;
        height: 363px;
        border: 1px solid #83DDAD;
        margin: 30px 0 30px 30px;
        border-radius: 10px;    
    }
    
    .card div{
        height: 50%;
    }
    .card div p{
        margin-top: 10px;
        font-size: 20px;
        font-weight: 700;
    }
    .card div pre{
        margin-top: 5px;
        font-size: 15px;
        font-weight: 700;
        text-align: center;
    }
    
    progress{
        width: 90%;
        margin-left: 5%;
        margin-right: 5%;
        height: 10px;
        -webkit-appearance: none;
    }
    progress::-webkit-progress-bar{
        background-color: #8bdcb1;
        border: 1px solid black;
    }
    progress::-webkit-progress-value{
        background-color: red;
    }
    .i_date{
        color: red;
        margin-right: 5%;
        font-weight: 500;
        display: block;
        text-align: right;
        margin-top: 5%;
        font-size: 20px;
    }
    .i_prog_percent{
        color: red;
        margin-left: 5%;
        font-weight: 500;
        font-size: 30px;
        margin-top: 5px;
    }
    .i_total_money{
        margin-right: 5%;
        float: right;
        margin-top: 5%;
        font-size: 20px;
        font-weight: 600;
    }
    .card img{
        width: 100%;
        height: 100%;
        border-radius: 10px;
    }
    
    #outer{
	width: 1200px;
	margin: 0 auto;
	
}
#titleNo{
	color: #83DDAD;
}
</style>
</head>
<body>
    <%@ include file="../common/header.jsp" %>
    <%@ include file="funding_header.jsp" %>

	<div id="outer">
    <div id="group_catelist">
        <ul>
            <li>

                <a href="/gibuAndTakePrj/view/funding?type=0">
                    <br>
                    <span>전체보기</span>
                </a>
            </li>

            <li>
                <a href="/gibuAndTakePrj/view/funding?type=1">
                    <br>
                    <span>일자리 창출</span>
                </a>
            </li>

            <li>
                <a href="/gibuAndTakePrj/view/funding?type=2">
                    <br>
                    <span>공정 무역</span>
                </a>
            </li>

            <li>
                <a href="/gibuAndTakePrj/view/funding?type=3">
                    <br>
                    <span>친환경</span>
                </a>
            </li>

            <li>
                <a href="/gibuAndTakePrj/view/funding?type=4">
                    <br>
                    <span>기부</span>
                </a>
            </li>

            <li>
                <a href="/gibuAndTakePrj/view/funding?type=5">
                    <br>
                    <span>작은가게</span>
                </a>
            </li>

            <li>
                <a href="/gibuAndTakePrj/view/funding?type=6">
                    <br>
                    <span>미디어</span>
                </a>
            </li>

            <li>
                <a href="/gibuAndTakePrj/view/funding?type=7">
                    <br>
                    <span>창작자</span>
                </a>
            </li>

        </ul>
    </div>


    <div class="container">
      
        <p>진행중인 펀딩 <span id="titleNo"><%= fundingcnt %></span>개</p>
         
        <%for(FundingVo f : list) {%>
         <a href="/gibuAndTakePrj/view/funding_detail?type=0&num=<%=f.getRegno() %>" class="card">
             <div>
                 <img src="../resources/upload/<%= f.getImgsrc()%>">
             </div>
             <div>
                 <p align="center"><%= f.getRegname() %></p>
                 <pre><%= f.getMnick() %></pre>
                 <span class="i_date"><%= f.getRegfdate() %>까지</span>
                 <span class="i_prog_percent"><%= f.getMoneypercent() %>%</span>
                 <span class="i_total_money"><%= f.getFpmoney() %>원</span>
             </div>
         </a>

         <%} %>        
        

        
    </div>
    <br clear="both">
    </div>
    <%@ include file="../common/footer.jsp" %>
</body>
</html>