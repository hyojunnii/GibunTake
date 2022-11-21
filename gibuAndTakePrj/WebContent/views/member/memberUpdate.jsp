<%@page import="com.gnt.member.vo.MemberVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVo loginMember = (MemberVo)session.getAttribute("loginMember");
	String alertMsg = (String)session.getAttribute("alertMsg");
	session.removeAttribute("alertMsg");
	
	String contextPath = request.getContextPath();
%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
	<!-- Latest compiled and minified CSS -->
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
	
	<!-- Latest compiled JavaScript -->
	<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
	
<style>

	#selEvery{
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
		width:500px;
		
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
        margin: auto;
        height: 60px;
        border-radius: 20px 20px;
        font-size: large;
        background-color: white;
        border-style: calc() ;
        align:center;
        
    }
	
	.input{
		width: 300px;
		height: 30px;
        border-radius: 20px 20px;
        font-size: small;
        border-width: 2px 2px 2px 2px;
        padding-left:-30px;
        border-style: solid ;
        border-color:#acdac2;
       
	}
	
	#updatediv{
		text-align: center;
		margin-left:400px;
	}
	
	#pwdupdatediv{
		text-align: center;
		margin-left:400px;
	}
	
	#quitdiv{
		text-align: center;
		margin-left:400px;
	}
	#update {
		 width:120px;
       	 float:left;
       	 margin-left:20px;
	}
	
	#pwdupdate{
		 width:120px;
       	 float:left;
       	  margin-left:20px;
	}
	
	#quit{
		 width:120px;
       	  float:left;
       	   margin-left:20px;
       }
	
	#check {
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
	.first{
		padding-left: 10px;
		color:#2e6c4a;
	}
	 
	 #memberDelQuit{
		text-align: center;
    }
   
    .log{
        text-decoration: none;
        color: black;
        font-size: 15pt;
       	font-weight: bold;
    }
    
      #modal-outer {
        width: 400px;
      }

      #modal-form{
        height: 400px;
        border: 3px solid #72d09e;
        border-radius: 15px;
      }

      #modal-header {
        justify-content: center;
        border-bottom: 3px solid #8bd0ab;
        background-color: #d8eee2;
        border-top-left-radius: 15px;
        border-top-right-radius: 15px;
      }
      
       #modal-header h4 {
        font-weight: 600;
        color: #2e6c4a;
        margin-left:120px;
      }
	  #memberP{
	  	 height:30px;
         width: 180px;
         border-radius: 15px;
         margin: 5% auto;
         margin-right: -50px;
         border: 1px solid #acdac2;
	  }
	  
	   #memberPnew {
	  	 height: 30px;
         width: 180px;
         border-radius: 15px;
          margin: 5% auto;
         margin-right: -50px;
         border: 1px solid #acdac2;
	  }
	  
	  #memberPnew2 {
	  	 height: 30px;
        width: 180px;
         border-radius: 15px;
         margin: 5% auto;
        margin-right: -50px;
         border: 1px solid #acdac2;
	  }
	  
	   .modal-form-button {
        width: 300%;
        border-radius: 15px;
        border: none;
        height: 55px;
        margin-left:100px;
        font-size: 18px;
        background-color: #e0e0e0;
      }

      .modal-form-button:hover {
        font-weight: 600;
        box-shadow: 0.5px 0.5px 3px 0px #dadada;
      }

      #modal-form-buttons input[type="submit"] {
        background-color: #b3e0c9;
      }

      #modal-form-buttons {
        margin: 0 auto;
        color: #2e6c4a;
        font-size: 20px;
        font-weight: 900;
        margin-top: 40px;
        display: flex;
        justify-content:center;
      }
      
       .modal-form-button2 {
        width: 500%;
        border-radius: 15px;
        border: none;
        height: 55px;
        margin-left:20px;
        font-size: 18px;
        background-color: #e0e0e0;
      }

      .modal-form-button2:hover {
        font-weight: 600;
        box-shadow: 0.5px 0.5px 3px 0px #dadada;
      }
	
	  #pwdFormOuter{
		display: flex;
		justify-content: center;
	}
	
	#pwdFormOuter td:last-child{
		display: flex;
		justify-content: right;
	}
	
	  #updatediv{
		text-align: center;
		margin-left:400px;
	}
	
	#pwdupdatediv{
		text-align: center;
		margin-left:400px;
	}
	
	#quitdiv{
		text-align: center;
		margin-left:400px;
		
	}
	#update {
		 width:120px;
       	 float:left;
       	 margin-left:20px;
       	 height:40px;
       	 border-radius: 20px 20px;
       	 font-size: small;
       	 background-color: #5CD394;
       	 border: none;
	}
	
	  #update:hover {
	        text-align: center;
	        width: 130px;
	       	margin-left:20px;
	        height: 45px;
	        border-radius: 20px 20px;
	        font-size: small;
	        background-color: #EBF5E0;
	        border: none;
	        color: #086C37;
	        font-weight: bold;
	      	transition:background 0.7s ease-in-out;
	      
	    }
	
	#pwdupdate{
		 width:120px;
       	 float:left;
       	 margin-left:20px;
       	 height:40px;
       	 border-radius: 20px 20px;
       	 font-size: small;
       	 background-color: #5CD394;
       	 border: none;
	}
	
	#pwdupdate:hover{
		    text-align: center;
	        width: 130px;
	       	margin-left:20px;
	        height: 45px;
	        border-radius: 20px 20px;
	        font-size: small;
	        background-color: #EBF5E0;
	        border: none;
	        color: #086C37;
	        font-weight: bold;
	      	transition:background 0.7s ease-in-out;
	}
	#quit{
		 width:120px;
       	 float:left;
       	 margin-left:20px;
       	 height:40px;
       	 border-radius: 20px 20px;
       	 font-size: small;
       	 background-color: #5CD394;
       	 border: none;
       }
       
       #quit:hover{
		    text-align: center;
	        width: 130px;
	       	margin-left:20px;
	        height: 45px;
	        border-radius: 20px 20px;
	        font-size: small;
	        background-color: #EBF5E0;
	        border: none;
	        color: #086C37;
	        font-weight: bold;
	      	transition:background 0.7s ease-in-out;
       }
      
	
</style>
</head>
<body>
	
	
	<main>
		  <div id="selEvery">

		  <div id="logo_name">
           	 <a href="<%=request.getContextPath()%>">
                    <img id="logo" src="/gibuAndTakePrj/resources/img/free-icon-giving-5017478.png" alt="홈페이지 로고">
                    <span id="siteName"><span class="greenBold selected_bg">기부 앤 테이크</span><span id="siteName_small" class="greenBold">Gibu n Take</span></span>
                </a>
           </div>
		
		<div id="line"></div>
		<h3 align="center" style="font-size: 25px; ">회원 정보 조회</h3>
		<form action="/gibuAndTakePrj/member/MemberUpdate" method="post" name="memberUpdate">
		<input type="hidden" value="<%=loginMember.getNo()%>" name="memberNo">
			<table>
				<tr>
					<td class="first" style="font-weight: bold">아이디 *</td>
					<%--input 안에다가 히든밸류 값 넣어주기 getNo... --%>
					<td><input type="text" name="memberId" class="input" id="memberId" value="<%=loginMember.getId() %>" readonly></td>
					
				</tr>
				
				<tr>
					<td class="first" style="font-weight: bold">이름 *</td>
					<td><input type="text" name="memberName" id="memberName" class="input" value="<%=loginMember.getName() %>" ></td>
			
				</tr>
				<tr>
					<td class="first" style="font-weight: bold">닉네임 *</td>
					<td><input type="text" class="input" name="memberNick"  id="memberNick" value="<%=loginMember.getNick() %>" ></td>
					
				</tr>
				<tr>
					<td  class="first" style="font-weight: bold">주민등록번호 *</td>
					<td><input type="text" name="memberRegnum" id="memberRegnum" class="input" value="<%=loginMember.getRegnum() %>" readonly></td>
				
				</tr>
				<tr>
					<td class="first" style="font-weight: bold">휴대전화 *</td>
					<td><input type="text" name="memberPhone"  id="memberPhone" class="input" value="<%=loginMember.getPhone() %>" ></td>
					
					
				</tr>
				<tr>
					<td class="first" style="font-weight: bold">이메일 *</td>
					<td><input type="tel" name="memberEmail" id = "memberEmail" class="input" value="<%=loginMember.getEmail() %>" ></td>
				
				</tr>
				<tr>
					<td class="first" style="font-weight: bold">주소 *</td>
					<td><input type="tel" id="memberAddr"  name="memberAddr" class="input"  value="<%=loginMember.getAddr() %>" ></td>
				
				</tr>
				
			
				<tr></tr><tr></tr><tr></tr><tr></tr><tr></tr>
				
			</table>
				<div id="updatediv">
				<button id ="update">수정하기</button>
				</div>
			</form>
			<div id="pwdupdatediv">
			<button type="button" data-bs-toggle="modal" data-bs-target="#pwdChange" id="pwdupdate">비밀번호변경</button>
			</div>
			<div id="quitdiv">
			<form action="/gibuAndTakePrj/member/quit" method="get">
				<button id="quit">회원탈퇴</button>
			</form>
			</div>
		</div>
		
		<div style="padding-top: 100px">
           <%@ include file="../common/footer.jsp" %>
        </div>
	</main>
	
	<!-- The Modal -->
	<div class="modal" id="pwdChange">
	  <div class="modal-dialog" id="modal-outer">
	    <div class="modal-content" id="modal-form">
	
	      <!-- Modal Header -->
	      <div class="modal-header" id="modal-header">
	        <h4 class="modal-title">비밀번호 변경</h4>
	        <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
	      </div>
	
	      <!-- Modal body -->
	      <div class="modal-body" id="modal-body">
	        <div id="pwdFormOuter">
	        	<form action="/gibuAndTakePrj/member/pwd" method="post">
	        		<input type="hidden" name="memberId" value="<%=loginMember.getId()%>">
		        	<table>
		        		<tr>
		        			<td>기존 비밀번호</td>
		        			<td><input type="password" id="memberP" name="memberPwd"></td>
		        		</tr>
		        		<tr>
		        			<td>신규 비밀번호</td>
		        			<td><input type="password" id="memberPnew"name="memberPwdNew"></td>
		        		</tr>
		        		<tr>
		        			<td>신규 비밀번호 확인</td>
		        			<td><input type="password" id="memberPnew2" name="memberPwdNew2"></td>
		        		</tr>
		        		<tr>
		        			<td  id="modal-form-buttons">
		        				<input type="submit" class="modal-form-button" value="변경하기" onclick="return checkPwd();">
		        				<input type="button" class="modal-form-button2"  data-bs-dismiss="modal" value="취소">
		        			</td>
		        		</tr>
		        	</table>
		        </form>
	        </div>
	      </div>
	
	    </div>
	  </div>
	</div>
	
	<script>
	function checkPwd(){
		isSame = $('input[name=memberPwdNew]').val() == $('input[name=memberPwdNew2]').val();
		if(isSame){
			return true;
		}else{
			alert("신규 비밀번호가 일치하지 않습니다.");
			return false;
		}
		
	}
	
	</script>
</body>
</html>