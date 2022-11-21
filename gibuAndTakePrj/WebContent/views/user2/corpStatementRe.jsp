<%@page import="com.gnt.stmt.vo.ExeVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.gnt.stmt.vo.StmtVo"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	StmtVo donaVo = (StmtVo)request.getAttribute("donaVo");
	ArrayList<ExeVo> exeVo = (ArrayList<ExeVo>)request.getAttribute("exeVo");
%>
<!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<script src="https://code.jquery.com/jquery-3.6.0.js"></script>
<title>기업 명세서 수정</title>
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
        margin-top: 20px;
	}
	
	#category a {
		margin: 0 0 0 20px;
	}

	form {
		width: 1200px;
	}

    table {
		width: 700px;
		color: #15462b;
		border-top: 3px solid #8bdcb1;
		border-bottom: 3px solid #8bdcb1;
		border-collapse: collapse;
		margin: auto;
		margin-bottom: 5px;
	}

	th {
		text-align: left;
		width: 20%;
	}

	th, td {
		border-bottom: 1px solid black;
		padding: 5px;
		padding-left: 20px;
	}

	#first th, #second th {
		border-right: 1px solid black;
		width: 20%;
	}

	#second tbody td:last-child {
		text-align: right;
		padding-right: 10px;
	}

    #outer {
		width: 700px;
		display: flex;
		margin: 0 auto;
		margin-top: 10px;
		flex-wrap: wrap;
		box-sizing: border-box;
		justify-content: space-between;
	}

	#title {
		font-size: 30px;
		display: inline;
		width: 550px;
		font-weight: bold;
		padding: 5px;
	}

	#do_t {
		margin-left: 10px;
		font-size: 20px;
	}

    #re-outer {
        width: 700px;
        margin: 0 auto;
		margin-top: 20px;
		margin-bottom: 20px;
        display: flex;
    }

	#re-outer input {
		background-color: #8bdcb1;
		border: #8bdcb1;
		border-radius: 30px;
		color: #2e6c4a;
		font-weight: bolder;
		font-size: 20px;
		width: 130px;
		height: 40px;
		box-sizing: border-box;
        margin: 0 auto;
	}

    #col-outer {
        display: flex;
        margin: auto;
		margin-top: 20px;
		padding-right: 20px;
        width: 700px;
        justify-content: right;
    }

    #col-p, #col-m {
        background-color: #8bdcb1;
        color: #2e6c4a;
        font-size: 20px;
        font-weight: bold;
        border-radius: 100%;
        width: 25px;
        height: 25px;
        margin: 5px;
        text-align: center;
        line-height: 25px;
		cursor: pointer;
    }

    #second tbody td {
        color: lightgray;
    }

	.total {
		color: #2e6c4a;
		font-weight: bold;
	}
	
	#total {
		border-bottom: none;
	}

	.input-col {
		display: flex;
		justify-content: space-between;
		border: none;
		border-top: none;
	}

	a {
        cursor: pointer;
    }

	input[type=submit], input[type=button]{
		cursor: pointer;
	}

	#re-outer > input:hover, #col-p:hover, #col-m:hover{
		background-color: #15462b;
	}

	#exeBody > tr {
		border-top: 1px solid black;
	}

	#exeDataTr, #exeDataTr > td > input {
		background-color: #e4f9ee;
	}

	#exeDataTr > td > input {
		border: none;
		pointer-events: none;
		color: #15462b;
	}
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>

	<div id="body">
		<div id="category">
			<a>기업 명세서 내역 추가</a>
		</div>
		<div id="nav">
			<div id="naviIn"><%@ include file="/views/mypageNav/corpNavi.jsp" %></div>

			<form action="/gibuAndTakePrj/corp/stmtRe" method="post">
				<input type="hidden" value="<%=donaVo.getDonaNo() %>" name="donaNo">
				<table id="first">
					<div id="outer">
						<div id="title"><%=donaVo.getRegName() %></div>
						<div id="do_t">기부금 집행 내역 추가하기</div>
					</div>
					<tr>
						<th>집행기간</th>
						<td colspan="2">
							<fmt:parseDate var="parsedSdate" value="<%=donaVo.getDonaSdate() %>" pattern="yyyy-MM-dd HH:mm:ss"/>
                        	<fmt:formatDate value="${parsedSdate}" pattern="yyyy-MM-dd" />
                        	~
                        	<fmt:parseDate var="parsedEdate" value="<%=donaVo.getDonaEdate() %>" pattern="yyyy-MM-dd HH:mm:ss"/>
                        	<fmt:formatDate value="${parsedEdate}" pattern="yyyy-MM-dd" />
						</td>
					</tr>
					<tr>
						<th>총 모금 금액</th>
						<td colspan="2"><span class="total"><fmt:formatNumber value="<%=donaVo.getDonaPmoney() %>" pattern="#,###"/></span>원 (목표금액 <fmt:formatNumber value="<%=donaVo.getDonaGmoney() %>" pattern="#,###"/>원)</td>
					</tr>
					<tr>
						<th>사업 대상</th>
						<td colspan="2"><%=donaVo.getDonaPerson() %></td>
					</tr>
				</table>
				<table id="second">
					<div id="col-outer">
						<div id="col-p">+</div>
						<div id="col-m">-</div>
					</div>
					<thead>
						<tr>
							<th>총 집행 금액</th>
							<td colspan="2"><span class="total"><fmt:formatNumber value="<%=donaVo.getDonaPmoney() %>" pattern="#,###"/></span>원 (목표금액 <fmt:formatNumber value="<%=donaVo.getDonaGmoney() %>" pattern="#,###"/>원)</td>
						</tr>
					</thead>
					<tbody id="exeBody">
						<% for (int i = 0; i < exeVo.size(); ++i) {%>
							<tr id="exeDataTr">
								<th>
									<%=exeVo.get(i).getExeCtg() %>
								</th>
								<td colspan="2" class="input-col" id="input-cnt">
									<input type="text" value="<%=exeVo.get(i).getExeCnt() %>" size="40" readonly="readonly">
									<input type="number" value="<%=exeVo.get(i).getExeMoney() %>" readonly="readonly">
								</td>
							</tr>
						<%} %>
					</tbody>
				</table>
				<div id="re-outer">
					<input type="submit" value="완료">
					<input type="button" value="뒤로 가기" onclick="history.go(-1)">
				</div>
			</form>

		</div>
	</div>

	<%@include file="/views/common/footer.jsp" %>
	
	<script type="text/javascript">

		$('#col-p').click(function () {
			let exeRow;
			exeRow = document.all["exeBody"].insertRow();

			let exeTitle = exeRow.insertCell();
			exeTitle.outerHTML = '<th><select name="exeCategory" id="inputGroupSelect01" required> <option value="사업비" selected>사업비</option> <option value="인건비" >인건비</option> <option value="운영비" >운영비</option> <option value="행사홍보비" >행사홍보비</option> </select></th>';

			let exeCnt = exeRow.insertCell();
			exeCnt.innerHTML = '<input type="text" name="exeCnt" size="40" placeholder="사용 내역을 입력해주세요."> <input type="number" name="exeMoney" placeholder="사용 금액을 입력해주세요.">';
			exeCnt.setAttribute("class", "input-col");
		});

		$('#col-m').click(function () {
			let table = document.getElementById('exeBody');
			if (table.rows.length<1) return;
			table.deleteRow(table.rows.length-1);		
		})

	</script>

</body>
</html>