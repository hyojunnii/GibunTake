<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
		
		
		#memberMgEvery{
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
		
		#shortTitle{
			margin-left:650px;
			margin-top:100px;
		}
		
		#corpText {
			margin-left:200px;
		}
		
		#img2{
			margin-top: 50px;
			margin-left: 525px;
		}
		
		
	
		#naviIn{
			margin-top:-1090px;
			width:200px;
   			height:550px;
   			margin-left:0px;
		}
		
		
		#btn_group{
			margin-top:700px;
			margin-left:730px;
		}
		#fundingI{
			margin-right:-4px;
			border-top-left-radius: 10px;
			border-bottom-left-radius:10px;
			
		}
		
		#fundingC{
			margin-left:-3px;
			border-top-right-radius: 10px;
			border-bottom-right-radius:10px;
		}
		
		#btn_group button{
			border:2px solid #acdac2;
			background-color: white;
			color: #2e6c4a ;
			width:400px;
			height:100px;
		}
		
		#btn_group button:hover{
			color: white;
			background-color: #83DDAD;
		}
		
		#footIn{
			margin-top:1200px;
			
   			width:100%;
   			height:200px;
		}
		
		#memberHeader {
			display: flex;
			justify-content: space-between;
		}
		
		#memberHeader a {
			margin: 5% 15% 2%;
			text-decoration: none;
			font-size: 20px;
			background-color: #acdac2;
			border-radius: 15px;
			padding: 12px;
			color: black;
			font-weight: 600;
		}
		
		#memberHeader a:hover {
			background-color: #83DDAD;
		}
</style>
</head>
<body>	
		
		<div id="headIn"><%@ include file="/views/common/header.jsp" %></div>
		<div id="memberMgEvery">
			<div id="memberHeader">
				<h1 id="myPageTxt">기업 마이페이지</h1>
				<a href="<%=path%>/pm/apply/main">프로젝트 관리하기</a>
			</div>
			<div class="headLine">
			
		</div>
		
		<div id = "memShortOuter">
		<h1 id="shortTitle" style="">기업 소개</h1>
	
        
				<br>
				
			 <div id="img2">
                 <img src="/gibuAndTakePrj/resources/img/purme.png"  alt="">
             </div>
					<p style="margin: 100px 0px 0px 320px">
					장애인이 행복하면 모두가 행복한 사회,
					푸르메재단이 열어가겠습니다.
					‘푸른 산’을 의미하는 ‘푸르메’라는 이름으로 
					<br>
					2004년 창립발기인 대회를 거쳐
					2005년 재단이 설립된 이래, 장애인과 가족이 믿을 수 있는 재활병원을 만들어
					장애인<br>의 재활과 자립을 돕겠다는 일념으로 쉼 없이 달려왔습니다.
					
					2009년 4월 재활병원 건립 선포식을 가진 지 꼭 6년만인 <br>2015년, 1만여 명의 시민과
					500여 기업 및 단체, 지자체의 정성으로 ‘푸르메재단 넥슨어린이재활병원’이 탄생했습니다.<br>
					이곳에서는 매일 5백여 명, 매년 15만여 명의 장애어린이들이 치료받고,
					희망찬 미래를 그릴 수 있습니다.
					
					푸르메재단이<br> 어린이재활병원 건립의 꿈을 현실로 이뤄낼 수 있었던 건 장애어린이와 그 가족의
					아픔에 공감해 정성을 모아 준 아름다운 <br>분들이 계셨기 때문입니다.
					앞으로도 푸르메재단은 늘 버팀목이 되어 주시는 여러분들과 함께 지나온 길을 되돌아보고,<br>
					다가올 새로운 미래를 준비하겠습니다. ‘장애인이 행복하면 모두가 행복한 사회’ 실현을 위해
					최선의 노력을 다할 것을 <br>약속드립니다. 함께 해주시는 여러분, 참 고맙습니다
					</p>
				</div>
			
					
		
			
			
			
			
		<div id="naviIn"><%@ include file="/views/mypageNav/corpNavi.jsp" %></div>
		</div>
		
		<div id="footIn"><%@ include file="/views/common/footer.jsp" %></div>
		
		
</body>
</html>