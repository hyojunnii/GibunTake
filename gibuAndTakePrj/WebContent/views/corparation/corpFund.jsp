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
	
		#naviIn{
			margin-top:-815px;
			width:200px;
   			height:550px;
   			margin-right:200px;
		}
		
		#btn_group{
			margin-top:100px;
			margin-left:350px;
		}
		#fundingI{
			margin-right:-4px;
			border-top-left-radius: 10px;
			border-bottom-left-radius:10px;
			
		}
		
		#fundingC{
			margin-left:-3px;
			border-top-right-radius: 0px;
			border-bottom-right-radius:px;
		}
		
		#campainC{
			margin-left:-4px;
			border-top-right-radius: 10px;
			border-bottom-right-radius:10px;
		}
		
		#btn_group button{
			border:2px solid #acdac2;
			background-color: white;
			color: #2e6c4a ;
			width:250px;
			height:100px;
		}
		
		#btn_group button:hover{
			color: white;
			background-color: #83DDAD;
		}
		
		
		
    .card{
        width: 267px;
        height: 363px;
        border: 1px solid #83DDAD;
        margin-left:270px;
        border-radius: 10px;
        background-color: #DAFFEB;
        margin-top:100px;
        
    }
    
     .card2{
        width: 267px;
        height: 363px;
        border: 1px solid #83DDAD;
        margin-left:300px;
        border-radius: 10px;
        background-color: #DAFFEB;
        margin-top:-328px;
        
    }
     .cardLink{
    	text-decoration:none;
    	color:black;
    	margin-left:70px;
    	font-size:20px;
    	font-weight: bold;
    	margin-top: 50px;
    	
    }
    
     .cardLink2{
    	text-decoration:none;
    	color:black;
    	margin-left:70px;
    	font-size:20px;
    	font-weight: bold;
    	margin-top: 0px;
    }
    #img{
        height: 50%;
    }
    
    #img2{
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
	
			
	
		
    .gibuPercent{
        color: #64D498;
        margin-left: 20px;
        font-weight: 500;
        font-size: 25px;
        margin-top: 40px;
       
        
    }
    .gibuPeople{
        margin-left:120px;
        margin-top: 15px;
        font-size: 20px;
        font-weight: 600;
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
		<div id="memberMgEvery">
		<h1 id="myPageTxt">기업 마이페이지</h1>
		<div class="headLine">
			
		</div>	
		<div id="btn_group">
		<a href="/gibuAndTakePrj/corp/corpGibuAppl"><button id="fundingI" style="font-size: 20px"> 기부 신청 내역</button></a>
		<a href="/gibuAndTakePrj/corp/corpFundAppl"><button id="fundingC" style="font-size: 20px">펀딩 신청 내역</button></a>
		<a href="/gibuAndTakePrj/corp/corpCampAppl"><button id="campainC" style="font-size: 20px">캠페인 신청 내역</button></a>
		</div>
		
		<div id = "memShortOuter">
		<h1 id="shortTitle" style="">신청 펀딩목록</h1>
	
        <div class="card">
       
             <div id="img">
                 <img src="/gibuAndTakePrj/resources/img/gibuman.png" width = 100% height =100% alt="">
             </div>
             <div>
             <br><br>
                <a href="" class="cardLink" >펀딩프로젝트명</a>
                <br><br>
                 <pre>승인안됨</pre>
                  
             </div>
         
             <div class="card2">
        	
             <div id="img2">
                  <img src="/gibuAndTakePrj/resources/img/gibuman.png" width = 100% height =100% alt="">
             </div>
             <div>
             	<br><br>
                  <a href="" class="cardLink2" align="center">펀딩프로젝트명</a>
                  <br><br>
                 <pre>승인안됨</pre>
                
             </div>
         </a>
				<br>
			
			</div>		
		</div>
			
			
			
			</div>	
			
		<div id="naviIn"><%@ include file="/views/mypageNav/corpNavi.jsp" %></div>
		</div>
	
		<div id="footIn"><%@ include file="/views/common/footer.jsp" %></div>
		
		
</body>
</html>