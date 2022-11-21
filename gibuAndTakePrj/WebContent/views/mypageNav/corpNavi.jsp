<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

   		#leftcorpNav{
   			width:300px;
   			background-color: white;
   			border-right:2px solid #acdac2;
   			height:550px;
   			margin-top: 20px;
   			margin-left:-85px;
   		}
   		
   		
   		
   		#corphome{
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
   		
   		#corphome:hover{
   			color:#64D498;
   			}
   		
   		#corpInfor{
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
   		
   		#corpInfor:hover{
   			color:#64D498;
   			}
   			
   		#corpActive{
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
   		
   		#corpActive:hover{
   			color:#64D498;
   			}
   		#corpdona{
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
   		
   		#corpdona:hover{
   			color:#64D498;
   			}
   		#corpfunding-menu{
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
   		
   		#corpfunding-menu:hover{
   			color:#64D498;
   			}
   		#corpcamp{
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
   		
   		#corpcamp:hover{
   			color:#64D498;
   			}
   		#corppayment{
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
   		
   		#corppayment:hover{
   			color:#64D498;
   			}
   		
   		#corpdonament{
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
   		
   		
   		#corpdonament:hover{
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
   		
   		
   		.corpmenu{
   			 list-style:none;
   			 
   		}

   		
   
  	
</style>
 
</head>
<body>
	
	
	
	<div id="leftcorpNav">
		<ul class="corpmenu">
			<li><a onclick="location.href='/gibuAndTakePrj/corp/corpMyPage'" id="corphome" style="font-weight:bold">MY 홈</a></li>
			<div id="middleLine"></div>
			<li><a onclick="location.href='/gibuAndTakePrj/corp/corpUpdate'" id="corpInfor"  style="font-weight:bold">회원정보</a></li>
			<div id="middleLine"></div>
			<li><a onclick="location.href='/gibuAndTakePrj/corp/corpGibuAppl'" id="corpActive"  style="font-weight:bold">활동내역</a></li>
			<li><a onclick="location.href='/gibuAndTakePrj/corp/corpGibu'" id="corpdona" style="font-size: 12px">기부</a></li>
			<li><a onclick="location.href='/gibuAndTakePrj/corp/stmtList'" id="corpdona" style="font-size: 12px">기부 명세서</a></li>
			<li><a onclick="location.href='/gibuAndTakePrj/corp/corpFunding'" id="corpfunding-menu" style="font-size: 12px">펀딩</a></li>
			<li><a onclick="location.href='/gibuAndTakePrj/corp/corpCamp'" id="corpcamp" style="font-size: 12px" >캠페인</a></li>
			<div id="middleLine"></div>
			<li><a href="#" id="corppayment"  style="font-weight:bold">결제 내역</a></li>
			<li><a href="#" id="corpdonament" style="font-weight:bold">기부 내역</a></li>
		</ul>
		
	</div>	
		
		
  		
  		
		
		
</body>
</html>