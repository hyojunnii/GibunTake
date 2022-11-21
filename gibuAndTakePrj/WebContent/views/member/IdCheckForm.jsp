<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&display=swap" rel="stylesheet">
<style>
      
      
      
      #wrap{
			width: 490px;
			text-align :center;
			margin: 0 auto 0 auto;
			font-family: 'IBM Plex Sans KR', sans-serif;
		}
		
		#chk{
			text-align :center;
			
		}
		
		#userId {
			border-radius:10px;
			border-style: solid ;
        	border-color:#acdac2;
        	height: 18px;
		}
		#btn_check{
			background-color: white;
			border-radius: 15px;
			font-size:14px;
			border-style: solid ;
        	border-color:#acdac2;
        	font-family: 'IBM Plex Sans KR', sans-serif;
		}
		
		#btn_check:hover{
		text-align: center;
        border-radius: 15px 15px;
        border-width: 1px 1px 1px 1px;
       	font-weight: bold;
		background-color: #5CD394;
       	transition:background 0.7s ease-in-out;
       	font-family: 'IBM Plex Sans KR', sans-serif;
	}
		#cancelBtn{
			visibility:visible;
			background-color: white;
			border-radius: 10px;
			border-style: solid ;
        	border-color:#acdac2;
        	font-family: 'IBM Plex Sans KR', sans-serif;
		}
		
		#cancelBtn:hover{
		text-align: center;
        border-radius: 15px 15px;
        border-width: 1px 1px 1px 1px;
       	font-weight: bold;
		background-color: #5CD394;
       	transition:background 0.7s ease-in-out;
		font-family: 'IBM Plex Sans KR', sans-serif;
		}
		#useBtn{
			 visibility:hidden;
		}

</style>
</head>
<body onload="pValue()">
<div id="wrap">
	<br>
	<b><font size="4" color="gray" style="color: #2e6c4a">아이디 중복체크</font></b>
	<hr size="1" width="460">
	<br>
	<div id="chk">
		<form id="checkForm">
			<input type="text" name="idinput" id="userId">
			<input type="button" id ="btn_check"value="중복확인" style="color:#2e6c4a"  onclick="idCheck()">
		</form>
		<div id="msg"></div>
		<br>
		<input id="cancelBtn" type="button" value="취소" style="color:#2e6c4a" onclick="window.close()"><br>
		<input id="useBtn" type="button" value="사용하기" onclick="sendCheckValue()">
	</div>
</div>	
<script>

	function pValue(){
		document.getElementById("userId").value = opener.document.userInfo.id.value;
	}
	
	// 아이디 중복체크
	function idCheck(){

		var id = document.getElementById("userId").value;

		if (!id) {
			alert("아이디를 입력하지 않았습니다.");
			return false;
		} 
		else if((id < "0" || id > "9") && (id < "A" || id > "Z") && (id < "a" || id > "z")){ 
			alert("한글 및 특수문자는 아이디로 사용하실 수 없습니다.");
			return false;
		}
		else
		{
			var param="id="+id
			httpRequest = getXMLHttpRequest();
			httpRequest.onreadystatechange = callback;
			httpRequest.open("POST", "MemberIdCheckAction.do", true);	
			httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); 
			httpRequest.send(param);
		}
	}
	
	function callback(){
		if(httpRequest.readyState == 4){
			// 결과값을 가져온다.
			var resultText = httpRequest.responseText;
			if(resultText == 0){
				alert("사용할수없는 아이디입니다.");
				document.getElementById("cancelBtn").style.visibility='visible';
				document.getElementById("useBtn").style.visibility='hidden';
				document.getElementById("msg").innerHTML ="";
			} 
			else if(resultText == 1){ 
				document.getElementById("cancelBtn").style.visibility='hidden';
				document.getElementById("useBtn").style.visibility='visible';
				document.getElementById("msg").innerHTML = "사용 가능한 아이디입니다.";
			}
		}
	}
	
	// 사용하기 클릭 시 부모창으로 값 전달 
		function sendCheckValue(){
		opener.document.userInfo.idDuplication.value ="idCheck";
		opener.document.userInfo.id.value = document.getElementById("userId").value;
		
		if (opener != null) {
        	opener.chkForm = null;
        	self.close();
		}	
	}	
	
</script>

</body>
</html>