<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
	
<title>Insert title here</title>
  	
  	
  	<!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
  
<style>
	
	#corpUpEvery{
   		width:1200px;
   		margin:0 auto;
   }
	main{
		margin:auto;
		
	}
	#logo_name{
    text-align:center;
    margin-top:10px;
    margin-bottom:0px;

    }
    
    #logo{
        width: 65px;
        height: 65px;
    }

    #siteName{
        font-size: 40px;
        vertical-align: middle;
    }
    
   
    
    #logo_name>*{
        text-decoration: none;
    }

    
    
    a {
    	text-decoration: none;
    	color: black;
    }

    #logo_name>a>*{
        vertical-align: middle;
        height: 75px;
    }

    #siteName_small{
        font-size: 20px;
        
        
    }
    
     .selected_bg{
     background-color: #EBF5E0;
    }
    
     .greenBold{
        color: #086C37;
        font-weight: bold;
    }
	
	
	
	main table{
		margin-top: 100px;
		text-align: center;
		margin-left: auto;
		margin-right: auto;
		algin: center;
		border-collapse: separate;
		border-spacing : 0 20px;
		
		
	}
	
	table tr{
		<%--border-style:solid;--%> 
	}
	table tr >td{
		<%--border-style:solid;--%> 
		width:33%; 
		
	}
	
	#line{
		border-bottom: 5px solid #E2F5EB;

	}
	
	#corpUp{
		text-align:center;
		font-size: 25px;
		margin-top:20px;
		font-weight:bold;
		
	}

	#join{
        text-align: center;
        width: 260px;
        margin: auto;
        height: 60px;
        border-radius: 20px 20px;
        font-size: large;
        background-color: white;
        border-style: calc() ;
        align:center;
    }

	.input {
		width: 300px;
		height: 30px;
        border-radius: 20px 20px;
        font-size: small;
        border-width: 2px 2px 2px 2px;
        border-style: solid;
        border-color:#acdac2;
        padding-left:20px;
       
       
	}
	
	textarea{
     	width: 300px;
		height: 150px;
        border-radius: 15px 15px;
        font-size: small;
        border-width: 2px 2px 2px 2px;
        padding-left:20px;
        padding: 10px 10px;
        font-size: 15px;
        border-style: solid;
        border-color: #acdac2;
      }
	
	#check{
		text-align: center;
        width: 100px;
        margin-top: 0 auto;
        height: 30px;
        border-radius: 20px 20px;
        font-size: small;
        background-color: white;
        border: solid:black;
        border-width: 1px 1px 1px 1px;
        margin-right: 140px;
       	font-weight: bold;
	}
	
	#check:hover{
		text-align: center;
        width: 100px;
        margin-top: 0 auto;
        height: 30px;
        border-radius: 20px 20px;
        font-size: small;
        border: solid:black;
        border-width: 1px 1px 1px 1px;
        margin-right: 140px;
       	font-weight: bold;
		background-color: #5CD394;
       	transition:background 0.7s ease-in-out;
	}
	
	.first {
		padding-left: 100px;
		color:#2e6c4a;
	}
	
	.corpText{
		padding-left:100px;	
		padding-bottom: 140px;
		color:#2e6c4a;
	}
	
	 #corpQuit{
		text-align: center;
		font-size:15pt;
		}
		
    .log2 {
    	text-decoration: none;
        color: black;
       	font-weight: bold;
    	
    }
    
   
    
</style>
</head>
<body>
	
	
	<main>
		<div id="corpUpEvery">
		 		<div id="logo_name">
           			 <a href="<%=request.getContextPath()%>">
                    <img id="logo" src="/gibuAndTakePrj/resources/img/free-icon-giving-5017478.png" alt="홈페이지 로고">
                    <span id="siteName"><span class="greenBold selected_bg">기부 앤 테이크</span><span id="siteName_small" class="greenBold">Gibu n Take</span></span>
               		 </a>
          		</div>
		
		<div class="corpUpWrap">
		<div id="line"></div>
		<h3 id= "corpUp">기업 정보 수정</h3>
		<form action="/gibuAndTakePrj/corp/corpUpdate" method="post">
			<table>
			
				<tr>
					<td class="first" style="font-weight: bold">대표자명 *</td>
					<td><input type="text" name="rprName" id="rprName" class="input" maxlength="3" required></td>
					
					
				</tr>
			
				<tr>
					<td class="first" style="font-weight: bold">기업명 *</td>
					<td><input type="tel" name="corpName" id="corpName" class="input" ></td>
					<td></td>
				</tr>
				
				<tr>
					<td class="first" style="font-weight: bold">휴대전화 *</td>
					<td><input type="email" name="corpPhone" id="corpPhone" class="input"></td>
					<td></td>
				</tr>
				<tr>
					<td class="first" style="font-weight: bold">이메일 *</td>
					<td><input type="text" name="corpEmail" id="corpEmail" class="input"></td>
					<td></td>
				</tr>
				
				<tr>
					<td class="first" style="font-weight: bold">주소 *</td>
					<td><input type="text" name="corpAddr"  id="corpAddr" class="input"></td>
					<td></td>
				</tr>
				<tr>
					<td class="first" style="font-weight: bold">사업 유형 *</td>
					<td><input type="text" name="corpType" id ="corpType" class="input"></td>
					<td></td>
				</tr>
				
				<tr>
					<td class="corpText" style="font-weight: bold">기업 설명 *</td>
					<td>
						 <textarea name="corpContent" id ="corpContent" placeholder="100자 이하로 기입하시오"></textarea>
						 </td>
					
				</tr>
				
				<tr></tr><tr></tr><tr></tr><tr></tr>
			

			</table>
			</form>
				<div id="corpQuit">
					<a onclick="location.href='/gibuAndTakePrj/corp/corpInfo'" class="log2">수정하기 /</a>
                    <a onclick="location.href='/gibuAndTakePrj/member/quit'"class="log2">회원 탈퇴</a>
				
				</div>	
					</div>
			</div>
			  <div style="padding-top: 100px">
               <%@ include file="../common/footer.jsp" %>
          		</div>

		
	</main>
	
</body>

	
	
	
	
</html>