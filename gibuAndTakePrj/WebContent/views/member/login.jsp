<%@page import="com.gnt.corp.vo.corpVo"%>
<%@page import="com.gnt.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	String alertMsg = (String)session.getAttribute("alertMsg");
	session.removeAttribute("alertMsg");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
   
   #loginEvery{
   		width:1200px;
   		margin:0 auto;
   }
   
    #square{
     width: 500px;   
     height: 580px;
     border: solid black;
     margin: 0 auto;
     margin-top: 200px;
     border-radius: 8%;  
     border-width: 2px 2px 2px 2px;
     border-style: solid ;
     border-color: #acdac2;
    }

    #loginInfo {
        text-align: center;
        margin: 0 auto;
        margin-top: 150px;
        border-collapse: separate;
        border-spacing: 0 5px;
    }
    
     #logo_name{
    	text-align:center;
    	margin-top:50px;
    	margin-bottom:-120px;

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

    #ID {
        text-align: left;
        width: 350px;
        height: 60px;
        border-radius: 20px 20px;
        font-size: large;
        border-width: 2px 2px 2px 2px;
        border-style: solid ;
    	border-color: #acdac2;
    	margin-top:30px;
    }

    #PWD {
        text-align: left;
        width: 350px;
        height: 60px;
        border-radius: 20px 20px;
        font-size: large;
        border-width: 2px 2px 2px 2px;
        border-style: solid ;
    	border-color: #acdac2;
    }
	
	  .selected_bg{
        background-color: #EBF5E0;
    }
    
    #login {
        text-align: center;
        width: 260px;
        margin-top: 40px;
        height: 60px;
        border-radius: 20px 20px;
        font-size: large;
        background-color: #5CD394;
        border: none;
      
    }
    
   #login:hover {
        text-align: center;
        width: 260px;
        margin-top: 40px;
        height: 60px;
        border-radius: 20px 20px;
        font-size: large;
        background-color: #EBF5E0;
        border: none;
        color: #086C37;
        font-weight: bold;
      	transition:background 0.7s ease-in-out;
      
    }
	
	#member{
			margin-left:-250px;
	}
  
	#corp {
		margin-left:-400px;
	}
	
    #alink {
        margin-top: 30px;
        display: flex;
        justify-content: space-evenly;
        color: #2e6c4a;
    }
   
    .log{
        text-decoration: none;
        color: black;
        font-size: 11pt;
    }

</style>
<body>	
		<div id="loginEvery">
		<form action="/gibuAndTakePrj/member/login" method="post">
            <div id ="square">
                <table id= "loginInfo">
                    <div id="logo_name">
           			 <a href="<%=request.getContextPath()%>">
                    <img id="logo" src="/gibuAndTakePrj/resources/img/free-icon-giving-5017478.png" alt="???????????? ??????">
                    <span id="siteName"><span class="greenBold selected_bg">?????? ??? ?????????</span><span id="siteName_small" class="greenBold">Gibu n Take</span></span>
               		 </a>
          			 </div>
					    
					    <tr>
						    
					    <td><input type="radio" name="check_log" id="member" value="1" checked><label for="member">?????? ??????</label></td>
						
          				<td><input type="radio" name="check_log" id="corp" value="2" ><label for="corp">?????? ??????</label></td>		
          				</tr>
						
	                <tr>
	                    <td colspan="4"><input type="text" name="memberId" id="ID" placeholder="?????????"></td>
	                </tr>
	                <tr>
	                   <td colspan="4"><input type="password" name="memberPwd" id="PWD" placeholder="????????????"></td>
	                </tr>
	                <tr>
	                    <td><button id="login">?????????</button></td>
	                </tr>
                   <tr id="alink">
                    <td><a onclick="location.href='/gibuAndTakePrj/member/Join'"  class="log">?????? ???????????? |</a></td>
                    <td><a onclick="location.href='/gibuAndTakePrj/corp/Join'"  class="log"> &nbsp;?????? ????????????</a></td>
                    <td></td><td></td><td></td><td></td><td></td> <td></td><td></td><td></td><td></td><td></td> <td></td><td></td><td></td><td></td><td></td> <td></td><td></td><td></td><td></td><td></td> <td></td><td></td><td></td><td></td><td></td> 
                    <td><a onclick="location.href='/gibuAndTakePrj/member/idSearch'"class="log">????????? ?????? |</a></td>
                    <td><a onclick="location.href='/gibuAndTakePrj/member/pwdSearch'"> &nbsp;???????????? ??????</a></td>
                    </tr>
                </table>
                </div>
                </form>
              </div>  
                  
                <div style="padding-top: 100px" style = "margin:0 auto">
               <%@ include file="../common/footer.jsp" %>
          		</div>
    		
    <script>
      <%if(alertMsg != null){%>
      	alert('<%= alertMsg%>');
      <%}%>
    </script>
		
       
</body>
</html>