<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

   		#leftNav{
   			width:300px;
   			background-color: white;
   			border-right:2px solid #acdac2;
   			height:550px;
   			margin-top: 20px;
   			margin-left:-85px;
   		}
   		
   		
   		
   		#home{
   			height:10px ;
   			line-height:30px;
   			display:block ;
   			padding:0 20px;
   			font-size:15px ;
   			color:#555 ;
   			text-decoration: none;
   			margin-top: 30px;
   			margin-left:30px ;
   			text-align: center ;
   		}
   		
   		#home:hover{
   			color:#64D498;
   			}
   		
   		#memberInfor{
   			height:10px ;
   			line-height:30px;
   			display:block ;
   			padding:0 20px;
   			font-size:15px ;
   			color:#555 ;
   			text-decoration: none;
   			margin-top: 30px;
   			margin-left:30px ;
   			text-align: center ;
   		}
   		
   		#memberInfor:hover{
   			color:#64D498;
   			}
   			
   		#Active{
   			height:10px ;
   			line-height:30px;
   			display:block ;
   			padding:0 20px;
   			font-size:15px ;
   			color:#555 ;
   			text-decoration: none;
   			margin-top: 30px;
   			margin-left:30px ;
   			text-align: center ;
   		}
   		
   		#Active:hover{
   			color:#64D498;
   			}
   		#dona{
   			height:10px ;
   			line-height:30px;
   			display:block ;
   			padding:0 20px;
   			font-size:15px ;
   			color:#555 ;
   			text-decoration: none;
   			margin-top: 30px;
   			margin-left:30px ;
   			text-align: center ;
   		}
   		
   		#dona:hover{
   			color:#64D498;
   			}
   		#funding-menu{
   			height:10px ;
   			line-height:30px;
   			display:block ;
   			padding:0 20px;
   			font-size:15px ;
   			color:#555 ;
   			text-decoration: none;
   			margin-top: 30px;
   			margin-left:30px ;
   			text-align: center ;
   		}
   		
   		#funding-menu:hover{
   			color:#64D498;
   			}
   		#camp{
   			height:10px ;
   			line-height:30px;
   			display:block ;
   			padding:0 20px;
   			font-size:15px ;
   			color:#555 ;
   			text-decoration: none;
   			margin-top: 30px;
   			margin-left:30px ;
   			text-align: center ;
   		}
   		
   		#camp:hover{
   			color:#64D498;
   			}
   		#payment{
   			height:10px ;
   			line-height:30px;
   			display:block ;
   			padding:0 20px;
   			font-size:15px ;
   			color:#555 ;
   			text-decoration: none;
   			margin-top: 30px;
   			margin-left:30px ;
   			text-align: center ;
   		}
   		
   		#payment:hover{
   			color:#64D498;
   			}
   		
   		#donament{
   			height:10px ;
   			line-height:30px;
   			display:block ;
   			padding:0 20px;
   			font-size:15px ;
   			color:#555 ;
   			text-decoration: none;
   			margin-top: 30px;
   			margin-left:30px ;
   			text-align: center ;
   		}
   		
   		
   		#donament:hover{
   			color:#64D498;
   			}
   		
   		#middleLine  {
   			margin-top: 50px;
   			margin-left:50px;
   			margin-right:30px;
   			border-style:solid;
   			border-color:#acdac2;
   			border-width: 1px;
   			width:190px;
   			
   		}
   		
   		
   		.menu{
   			 list-style:none;
   			 
   		}

   		
   
  	
</style>
 
</head>
<body>
	
	
	
	<div id="leftNav">
		<ul class="menu">
			<li><a onclick="location.href='/gibuAndTakePrj/member/MyPage'" id="home" style="font-weight:bold">MY 홈</a></li>
			<div id="middleLine"></div>
			<li><a onclick="location.href='/gibuAndTakePrj/member/MemberUpdate'" id="memberInfor"  style="font-weight:bold">회원정보</a></li>
			<div id="middleLine"></div>
			<li><a href="#" id="Active"  style="font-weight:bold">활동내역</a></li>
			<li><a onclick="location.href='/gibuAndTakePrj/member/MemberGibu'" id="dona" style="font-size: 12px">기부</a></li>
			<li><a onclick="location.href='/gibuAndTakePrj/member/MemberFunding'" id="funding-menu" style="font-size: 12px">펀딩</a></li>
			<li><a onclick="location.href='/gibuAndTakePrj/member/MemberCamp'" id="camp" style="font-size: 12px" >캠페인</a></li>
			<div id="middleLine"></div>
			<li><a href="#" id="payment"  style="font-weight:bold">결제 내역</a></li>
			<li><a onclick="location.href='/gibuAndTakePrj/member/breakList'" id="donament" style="font-weight:bold">기부 내역</a></li>
		</ul>
		
	</div>	
		
		
  		
  		
		
		
</body>
</html>