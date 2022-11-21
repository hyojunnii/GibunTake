<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        margin: 4% 15%;
        height: 130px;
        border-bottom: 4px solid #72d09e;
      }

      #apply-title h1 {
        padding-top: 30px;
        font-size: 34px;
        font-weight: 900;
      }

      #apply-menu {
        display: flex;
        justify-content: space-around;
        padding: 0 3%;
      }

      #apply-menu {
        margin: 90px 12% 50px;
        display: flex;
        justify-content: space-evenly;
        height: 600px;
      }

      .apply {
        display: flex;
        flex-direction: column;
        border-radius: 10px;
        width: 30%;
        height: 380px;
        /*
        border: 4px solid #acdac2;
        background-color: #d8eee2;
        */
        background-color: #dff9ed;
        border: 4px solid #e1efe8;
        align-items: center;
        justify-content: center;
      }

      .apply img {
        width: 50%;
      }

      .apply-subtitle {
        font-size: 25px;
        margin-top: 45px;
        font-weight: 600;
      }

      .button {
        display: block;
        margin: 0 auto;
        background-color: #b3e0c9;
        border: none;
        border-radius: 15px;
        width: 50%;
        height: 40px;
        margin-top: 30px;
      }

      .button:hover {
        background-color: #93e1b7;
        color: #d8eee2;
      }

      .button > a {
        font-size: 16px;
        font-weight: 600;
        color: #2e6c4a;
        text-decoration: none;
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
        	<li class="list-group-item current-nav"><a href="<%=path%>/pm/apply/main">프로젝트 신청</a></li>
        	<li class="list-group-item"><a href="<%=path%>/pm/apply/list">신청내역 조회</a></li>
      	</ul>
      </nav>
      <div id="apply-title">
        <h1>기부앤테이크 프로젝트 신청</h1>
      </div>
      <div id="apply-menu">
        <div class="apply">
          <img src="../../resources/img/free-icon-donation-2904948.png" />
          <div class="apply-subtitle">기부</div>
          <button class="button"><a href="<%=path%>/pm/apply/donation">신청하기</a></button>
        </div>
        <div class="apply">
          <img src="../../resources/img/free-icon-donation-3208275.png" />
          <div class="apply-subtitle">펀딩</div>
          <button class="button"><a href="<%=path%>/pm/apply/funding">신청하기</a></button>
        </div>
        <div class="apply">
          <img src="../../resources/img/premium-icon-donation-3843326.png" />
          <div class="apply-subtitle">캠페인</div>
          <button class="button"><a href="<%=path%>/pm/apply/campaign">신청하기</a></button>
        </div>
      </div>
    </div>

    <%@ include file="/views/common/footer.jsp" %>
  </body>
</html>
