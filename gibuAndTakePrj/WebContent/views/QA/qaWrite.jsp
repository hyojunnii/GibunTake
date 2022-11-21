<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>문의작성</title>
<style>
	#head {
        background-color: #8bdcb1;
        width: 1905px;
        text-align: left;
        font-weight: bold;
        font-size: 36px;
       	padding: 30px 0px 30px 100px;
    }
    
    .click{
    	background-color: white;
    	color: green;
    	margin-left: 90px;
    	margin-top: 30px;
    	font-weight: bold;
    	border-radius: 15px;
    	border: 0px;
    }
    
    .click:hover{
    	cursor: pointer;
    }
    
    #email{
    		color: #15462b;
            margin: 0px 50px 0px 255px;
            font-weight: bold;         
    }
    
    #phone{
    		color: #15462b;
            margin: 0px 50px 0px 255px;
            font-weight: bold;         
    }
    
    #category{
    		color: #15462b;
            margin: 0px 75px 0px 260px;
            font-weight: bold;         
    }
    
    #title{
    		color: #15462b;
            margin: 0px 60px 0px 260px;
            font-weight: bold;         
    }

    #content{
    		color: #15462b;
            margin: 0px 60px 0px 260px;
            font-weight: bold;
    }
    
    #input1{
    		border: 2px solid #acdac2;
			border-radius: 10px;
            width: 650px;
            height: 40px;
            color: black;
            margin: 5px 0px 0px 15px;
    }
    
    #input2{
    		border: 2px solid #acdac2;
			border-radius: 10px;
            width: 650px;
            height: 40px;
            color: black;
            margin: 5px 0px 0px 15px;
    }

    
    #input3{
			border: 2px solid #acdac2;
			border-radius: 10px;    
            width: 650px;
            height: 40px;
            color: black;
            margin: 5px 0px 0px 15px;
    }

    #input4{
    		border: 2px solid #acdac2;
			border-radius: 10px;
            width: 650px;
            height: 400px;
            color: black;                      
            margin: 5px 0px 0px 15px;
            vertical-align: middle;
    }

    #btn{
        background-color: #b3e0c9;
    	border: 2px solid #acdac2;
        margin: 0px 680px;
        margin-top: 20px;
        padding: 10px;
        font-weight: bold;
        border-radius: 15px;
    }

    #btn:hover{
    	background-color: #93e1b7;
        cursor: pointer;
    }
    
    #a{
    	border: 2px solid #acdac2;
		border-radius: 10px;
    	width: 650px;
    	height: 40px;
    	
    }
    
    #last {    
        padding: 420px;
    }
    
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	
	<div id="head">문의하기</div>
	
	<div style="border: 1px solid #72d09e; float: left; width: 20%; height:850px; padding:0px 0px 0px 20px;">
		<form action="" method="get">
			<input class="click" type="submit" value="서비스 이용문의">
		</form>
		
		<form action="" method="get">
			<input class="click" type="submit" value="모금제안 문의">
		</form>
		
		<form action="" method="get">
			<input class="click" type="submit" value="결제/영수증 이용문의">
		</form>
		<form action="" method="get">
			<input class="click" type="submit" value="1:1문의">
		</form>
	 </div>
	 <div style="border: 1px solid #72d09e; float: left; width: 80%; height:850px; padding:30px 0px 0px 0px;">
		
		<form action="/gibuAndTakePrj/qa/list" method="get">
		
		<label id="email">이메일 주소</label>
	    <input id="input1" type="text" name="id">
	    <br><br>
	    
	    <label id="phone">휴대폰 번호</label>
	    <input id="input2" type="text" name="id">
	    <br><br>			
    	
	 	<label id="category">문의 분류</label>                   
	    	<td>
                        <select name="category" id="a">
                            <!-- CTEGORY 테이블로부터 조회해오기 -->
                            <option value="10"></option>
                            <option value="20">서비스 이용문의</option>
                            <option value="30">모금제안 문의</option>
                            <option value="40">결제/영수증 이용문의</option>
                            <option value="50">1:1문의</option>
                        </select>
             </td>
	    <br><br>
	    
    	<label id="title">문의 제목</label>
	    <input id="input3" type="text" name="id">
	    <br><br>
	    <label id="content">문의 내용</label> 
	    <textarea id="input4" name="content"></textarea>
	    <div >
            <input id="btn" type="submit" value="문의접수">
        </div>
	    
    </form>
    </div>
	<div id="last"></div>
	
	<%@include file="/views/common/footer.jsp" %>
</body>
</html>