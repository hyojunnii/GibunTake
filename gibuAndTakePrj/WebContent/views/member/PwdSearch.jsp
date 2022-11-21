<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>

	#every{
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

    
    
    a{
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

	#join{
        text-align: center;
        width: 260px;
       	margin-top:60px;
       	margin-left:280px;
        height: 60px;
        border-radius: 20px 20px;
        font-size: large;
        background-color: white;
        border-style: calc() ;
        align:center;
        border-style: solid ;
        border-color:#acdac2;
        color:#2e6c4a;
    }
	
	#join:hover{
        text-align: center;
        width: 260px;
        margin-top:60px;
       	margin-left:280px;
        height: 60px;
        border-radius: 20px 20px;
        font-size: large;
        color:white;
        border-style: calc() ;
        align:center;
        background-color: #5CD394;
        transition:background 0.7s ease-in-out;
    }
	
	#join2{
        text-align: center;
        width: 260px;
        margin-top:60px;
       	margin-left:50px;
        height: 60px;
        border-radius: 20px 20px;
        font-size: large;
        background-color: white;
        border-style: calc() ;
        align:center;
        border-style: solid ;
        border-color:#acdac2;
        color:#2e6c4a;
    }
	
	#join2:hover{
        text-align: center;
        width: 260px;
        margin-top:60px;
       	margin-left:50px;
        height: 60px;
        border-radius: 20px 20px;
        font-size: large;
        color:white;
        border-style: calc() ;
        align:center;
        background-color: #5CD394;
        transition:background 0.7s ease-in-out;
    }
	#input{
		width: 300px;
		height: 30px;
        border-radius: 20px 20px;
        font-size: small;
        border-width: 1px 1px 1px 1px;
        padding-left:20px;
       	border-style: solid ;
        border-color:#acdac2;
       

       
	}
	
	#inputId{
		width: 300px;
		height: 30px;
        border-radius: 20px 20px;
        font-size: small;
        border-width: 1px 1px 1px 1px;
        padding-left:20px;
       	border-style: solid ;
        border-color:#acdac2;
       

       
	}
	
	#check_button{
		text-align: center;
        width: 100px;
        margin-top: 0 auto;
        height: 30px;
        border-radius: 20px 20px;
        font-size: small;
        background-color: white;
        border: solid:black;
        border-width: 2px 2px 2px 2px;
        margin-left: -110px;
       	font-weight: bold;
       	border-style: solid ;
        border-color:#acdac2;
        color:#2e6c4a;
	}
	
	#check_button:hover{
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
	
	.first{
		padding-left: 100px;
		color:#2e6c4a;
	}
</style>
</head>
<body>
	
	
	<main>
	
		  <div id="every">
		 <div id="logo_name">
           	 <a href="<%=request.getContextPath()%>">
                    <img id="logo" src="/gibuAndTakePrj/resources/img/free-icon-giving-5017478.png" alt="홈페이지 로고">
                    <span id="siteName"><span class="greenBold selected_bg">기부 앤 테이크</span><span id="siteName_small" class="greenBold">Gibu n Take</span></span>
                </a>
           </div>
		
		<div id="line"></div>
		<h3 align="center" style="font-size: 25px">비밀번호 찾기</h3>
		<form action="/gibuAndTakePrj/member/pwdSearch" method="post">
			<table>
				<tr>
					<td class="first" style="font-weight: bold">아이디 *</span></td>
					<td><input type="text" name="id" id="inputId" maxlength="10" ></td>
				</tr>
				
				<tr>
					<td class="first" style="font-weight: bold">이메일 *</td>
					<td><input type="text" name="email" id="input" maxlength="10"></td>
					<td></td>
				</tr>
				
				<tr></tr><tr></tr><tr></tr><tr></tr>
				
					
				
			</table>
			
					<button id="join">찾기</button>
					
						</div>
			  <div style="padding-top: 100px">
               <%@ include file="../common/footer.jsp" %>
          		</div>

		</form>
	</main>

</body>
</html>