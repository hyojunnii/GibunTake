<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
		
		
		#memberMpEvery{
			width:1200px;
   			margin:0 auto;
		}
	
		
		#myPageTxt {
			color:#2e6c4a;
			margin-top:60px;
			margin-left:30px;
		}
		
		
		.headLine{
			border:solid 1px #acdac2;
			width:1200px;
			margin:0 auto;
			margin-top:10px;
			
		}
		
		
	
		#naviIn{
			margin-top:-300px;
			
			width:200px;
   			height:550px;
   			margin-right:200px;
		}
		
		#memDonateM {
			margin-left:350px;
			margin-top:50px;
			width:800px;
			height:250px;
			border-radius:15px;
			background:#64D498;
			
		}
		
		#myDonM{
			font-size:30px;
			font-weight:bold;
		}
		
		#money{
			font-size:30px;
			font-weight:bold;
			color:white;
		}
		
		#goFunding{
			font-size:20px;
			padding-left:410px;
			color:white;
			
		}
		
		#gogibu{
			font-size:20px;
			padding-left:50px;
			color:white;
		}
		#middleLin{
			border:solid 1px #acdac2;
			width:800px;
			margin-top:150px;
		
		}
		
		#log{
			font-weight: bold;
			margin-left: 270px;
		}
		
		#footIn{
			margin-top:1200px;
			
   			width:100%;
   			height:200px;
		}
</style>
</head>
<body>	
		
		<div id="headIn"><%@ include file="/views/common/header.jsp" %></div>
		<div id="memberMpEvery">
		<h1 id="myPageTxt">마이페이지</h1>
		<div class="headLine">
			
		</div>
		<div id="memDonateM">
				<br>
				<span id="myDonM" style="padding-left:100px" >나의 기부 금액</span>
				<span id="money" style="padding-left:300px">10000원</span>
				<br><br><br><br><br>
				<a onclick="location.href='/gibuAndTakePrj/view/funding'" id="goFunding">펀딩 바로가기</a>
				<a onclick="location.href='/gibuAndTakePrj/view/gibu'"id="gogibu">기부 바로가기</a>
				<div id="middleLin"></div>
				<h2 id= "log" style="margin-top: 100px">최근 활동 내역이 없습니다</h2>
			</div>		
				
				
		<div id="naviIn"><%@ include file="/views/mypageNav/mypageNavi.jsp" %></div>
		
		</div>
		<div id="footIn"><%@ include file="/views/common/footer.jsp" %></div>
		
		
</body>
</html>