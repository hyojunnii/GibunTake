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
			margin-top:-615px;
			width:200px;
   			height:550px;
   			margin-right:200px;
		}
		
		#memDonateM {
			margin-left:350px;
			margin-top:50px;
			width:230px;
			height:250px;
			border-radius:15px;
			background:#64D498;
			
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
        margin-top:-315px;
        
    }
    
    .cardLink{
    	text-decoration:none;
    	color:black;
    	margin-left:70px;
    	font-size:20px;
    	font-weight: bold;
    	margin-top: -20px;
    }
    
     .cardLink2{
    	text-decoration:none;
    	color:black;
    	margin-left:70px;
    	font-size:20px;
    	font-weight: bold;
    	margin-top: -20px;
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
		
	#g_progress{
    width: 90%;
    margin-left: 5%;
    margin-right: 5%;
    height: 10px;
    -webkit-appearance: none;
	}
	#g_progress::-webkit-progress-bar{
    background-color: #DAFFEB;
    border: 1px solid black;
	}
	#g_progress::-webkit-progress-value{
	    background-color: #64D498;
	}		
	
    .gibuPercent{
        color: #64D498;
        margin-left: 20px;
        font-weight: 500;
        font-size: 25px;
        margin-top: 40px;
       text-decoration: none;
        
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
		<h1 id="myPageTxt">마이페이지</h1>
		<div class="headLine">
			
		</div>
		
		<div id = "memShortOuter">
		<h1 id="shortTitle" style="">기부 내역</h1>
	
        <div class="card">
       
             <div id="img">
                  <img src="/gibuAndTakePrj/resources/img/gibuman.png" width = 100% height =100% alt="">
             </div>
             <div>
                  <a href="" class="cardLink" align="center">기부프로젝트명</a>
                 <pre>기업이름</pre>
                 <progress id="g_progress" value="50" max="100" style="text-decoration: none"></progress>
                 <span class="gibuPercent">50%</span>
                 <span class="gibuPeople">500명</span>
             </div>
         	  
             <div class="card2">
        	
             <div id="img2">
                  <img src="/gibuAndTakePrj/resources/img/gibuman.png" width = 100% height =100% alt="">
             </div>
             <div>
                <a href="" class="cardLink2" align="center">기부프로젝트명</a>
                 <pre>기업이름</pre>
                 <progress id="g_progress" value="50" max="100"></progress>
                 <span class="gibuPercent">50%</span>
                 <span class="gibuPeople">500명</span>
             </div>
       
				<br>
			
			</div>		
		</div>
			
			
			
			</div>	
			
		<div id="naviIn"><%@ include file="/views/mypageNav/mypageNavi.jsp" %></div>
		</div>
	
		<div id="footIn"><%@ include file="/views/common/footer.jsp" %></div>
		
		
</body>
</html>