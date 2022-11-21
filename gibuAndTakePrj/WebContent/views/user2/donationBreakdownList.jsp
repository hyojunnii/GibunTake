<%@page import="com.gnt.breakdown.vo.BreakdownVo"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String contextPath = request.getContextPath();
	ArrayList<BreakdownVo> voList = (ArrayList<BreakdownVo>)request.getAttribute("voList"); 
%>
<!DOCTYPE html>
<html>
<head>
	<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<meta charset="UTF-8">
<title>기부 내역 조회</title>
<style>
	#nav{
		display: flex;
	}

	#naviIn{
		height: 900px;
	}

    #body {
        width: 1200px;
        margin: 0 auto;
    }

	#category{
		width: 100%;
		height: 100px;
		background-color: #8bdcb1;
		text-align: left;
		font-size: 25px;
		font-weight: 700;
		line-height: 100px;
		margin: 0 0 0 0;
	}

	#category a {
		margin: 0 0 0 20px;
	}

	form {
		width: 1000px;
	}
	
	#body-table {
		margin: 20px auto;
		color: #15462b;
		border-collapse: collapse;
		width: 600px;
	}

	#body-table th {
		border-bottom: 3px solid #8bdcb1;
		font-size: 18px;
		padding: 10px;
	}

	#body-table td {
		border-bottom: 1px solid;
		padding: 10 10 10 20;
	}

	#body-table th, #body-table td {
		padding: 5px;
		padding-left: 20px;
	}

	#body-table td:first-child{
		border-right: 1px solid;
		width: 40%;
		font-weight: 900;
	}

	#body-table tbody:last-child{
		border-bottom: 3px solid #8bdcb1;
	}

	#certificate, #receipt {
		background-color: #8bdcb1;
		border: none;
		border-radius: 25px;
		color: #2e6c4a;
		font-weight: bolder;
		font-size: 15px;
		width: 50%;
	}

	hr {
		margin: 50px;
		border: 1px dashed #8bdcb1;
	}

    #certificate:hover, #receipt:hover {
        background-color: #2e6c4a;
        color: #8bdcb1;
    }

	/* modal */
	
	#modal-outer {
        width: 500px;
      }

	#modal-form {
        height: 650px;
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

	#modal-header h5 {
        font-weight: 600;
        color: #2e6c4a;
	}

	#modal-form-title {
        text-align: center;
        margin-top: 1%;
		margin-bottom: 20px;
        font-weight: 500;
		font-size: 30px;
	}

	#modal-form-textarea {
        height: 200px;
        width: 90%;
        border-radius: 15px;
        margin: 6% auto;
        border: 1px solid #acdac2;
	}

	#modal-form-info {
        margin: 5% 7%;
        font-size: 11px;
	}

	.modal-form-button {
        width: 35%;
        border-radius: 15px;
        border: none;
        height: 55px;
        margin: 0 3%;
        font-size: 18px;
        background-color: #e0e0e0;
	}

	.modal-form-button:hover {
        font-weight: 600;
        box-shadow: 0.5px 0.5px 3px 0px #dadada;
	}

	#modal-form-buttons input:last-child {
        background-color: #b3e0c9;
	}

	#modal-form-buttons {
        margin: 0 auto;
        color: #2e6c4a;
        font-size: 20px;
        font-weight: 900;
        margin-top: 40px;
        display: flex;
        justify-content: center;
	}

	/* 모달창 내용 */

	#modal-text-outer {
		margin: auto;
		text-align: center;
	}

	#modal-text-outer div {
		margin: 20px;
	}

	#modal-table {
		margin-left: 30px;
		text-align: justify;
		width: 100%;
	}
	
	#modal-table td {
		line-height: 10px;
	}
	
	#modal-table td:first-child {
		width: 25%;
	}

	#modalTableOuter div{
		text-align : center;
		padding : 5px;
	}

	#modal-table td:after, td h2 {
		content: "";
		width: 100%;
		display: inline-block;
	}
	#modal-table td::before, td h2 {
		content: "";
		width: 100%;
		display: inline-block;
	}

	#modal-sign {
		font-size: 20px;
	}

	a {
        cursor: pointer;
    }

	#modal-body {
		display: flex;
	}
</style>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>

	<%@ include file="/views/common/header.jsp" %>

	<div id="body">

		<div id="category">
			<a>기부 내역 조회</a>
		</div>
		<div id="nav">
			<div id="naviIn"><%@ include file="/views/mypageNav/mypageNavi.jsp" %></div>

			<div id="content">

				<%for (int i = 0; i < voList.size(); i++) {%>
					<form action="<%=contextPath%>/member/breakPrint" method="post">
						<div id="data-area">
							<input type="hidden" value="<%=voList.get(i).getPayNo() %>" name="payNo">
							<input type="hidden" value="<%=voList.get(i).getCorpName() %>" name="corpName" id="corpName">
							<input type="hidden" value="<%=voList.get(i).getCorpClass() %>" name="corpClass" id="corpClass">
						</div>
						<table id="body-table">
							<thead>
								<tr>
									<th colspan="2" style=" font-size: 20px;" id="regName"><%=voList.get(i).getRegName()%></th>
								</tr>
							</thead>
							<tbody>
								<tr>
									<th colspan="2">기부 내역</th>
								</tr>
								<tr>
									<td>결제번호</td>
									<td id="payNo"><%=voList.get(i).getPayNo() %></td> 
								</tr>
								<tr>
									<td>결제수단</td>
									<td id="payName"><%=voList.get(i).getPayName()%></td>
								</tr>
								<tr>
									<td>기부금액</td>
									<td id="payMoney"><fmt:formatNumber value="<%=voList.get(i).getPayMoney()%>" pattern="#,###,###"/></td>
								</tr>
								<tr>
									<td>기부일자</td>
									<td id="payDate">
										<fmt:parseDate var="parsedDate" value="<%=voList.get(i).getPayDate()%>" pattern="yyyy-MM-dd HH:mm:ss"/>
										<fmt:formatDate value="${parsedDate}" pattern="yyyy-MM-dd" />	
									</td>
								</tr>
								<tr>
									<td>기부증서</td>
									<td><input id="certificate" type="button" value="출력" data-bs-toggle="modal" data-bs-target="#certificatePrint"></td>
								</tr>
								<tr>
									<td>기부금영수증</td>
									<td><input id="receipt" type="submit" value="출력"></td>
								</tr>
							</tbody>
						</table>
					</form>
					
					<hr>
					<%} %>
					
				</div>
				
			</div>
			
		</div>
	
	<%@include file="/views/common/footer.jsp" %>

	<!-- Modal -->
	<%for(int i = 0; i < voList.size(); ++i) { %>
		<div class="modal" id="certificatePrint" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1">
			<div class="modal-dialog modal-dialog-centered" id="modal-outer">
				<div class="modal-content" id="modal-form">
					<div class="modal-header" id="modal-header">
						<h5 class="modal-title">기부 증서 출력하기</h5>
					</div>
					<div class="modal-body" id="modal-body">
						<form action="" method="">
							<div id="modal-form-title">기 부 증 서</div>
							
							<table id="modal-table">
								<tr>
									<td>기 부 번 호:</td>
									<td id="modalNo"></td>
								</tr>
								<tr>
									<td>기 부 자 명:</td>
									<td id="modalName"></td>
								</tr>
								<tr>
									<td>기 부 단 체:</td>
									<td id="modalCorp"></td>
								</tr>
								<tr>
									<td>기 부 분 야:</td>
									<td id="modalClass"></td>
								</tr>
								<tr>
									<td>총 기 부 금 액:</td>
									<td id="modalMoney"></td>
								</tr>
								<tr>
									<td>기 부 일 자:</td>
									<td id="modalDate"></td>
								</tr>
							</table>
						<div id="modal-text-outer">
							<div id="modal-text">위 사람은 사랑과 봉사, 섬김과 나눔의 정신을 가지고<br>
								어려운 이웃들의 복지 증진과 사회 통합을 위해 노력하며<br>
								기부 앤 테이크를 통해 기부하였음을 증명합니다.
							</div>
								<div id="modal-date">
									<c:set var="now" value="<%=new java.util.Date() %>"></c:set>
									<fmt:formatDate value="${now }" pattern="yyyy-MM-dd" var="today"/>
									<c:out value="${today }"/>
								</div>
							<div id="modal-sign">기부 앤 테이크 대표</div>
						</div>
						
						<div id="modal-form-buttons">
							<input type="button" class="modal-form-button" data-bs-dismiss="modal" value="취소" />
							<input type="submit" class="modal-form-button" value="출력" onclick="printPage()"/>
						</div>
					</form>
				</div>
			</div>
		</div>
	<%} %>

	<script>
				
				$(document).on("click","#certificate", function() {
					let payNo = $("#payNo").text();
					let payName = $("#payName").text();
					let corpName = $("#corpName").val();
					let corpClass = $("#corpClass").val();
				let payMoney = $("#payMoney").text();
				let payDate = $("#payDate").text();
				
				$("#modalNo").html(payNo);
				$("#modalName").html(payName);
				$("#modalCorp").html(corpName);
				$("#modalClass").html(corpClass);
				$("#modalMoney").html(payMoney);
				$("#modalDate").html(payDate);
			})

			function printPage(){
				var initBody = initBody = document.body.innerHTML;
				window.onbeforeprint = function(){
					document.body.innerHTML = document.getElementById('modal-body').innerHTML;
				};
				
				window.onafterprint = function(){
					document.body.innerHTML = initBody;
				};
				
				window.print();
				
				return false;
			}    
	</script>

</body>
</html>