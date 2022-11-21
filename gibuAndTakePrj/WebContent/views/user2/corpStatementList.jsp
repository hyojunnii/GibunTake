<%@page import="java.io.Console"%>
<%@page import="com.gnt.stmt.vo.ExeVo"%>
<%@page import="com.gnt.stmt.vo.StmtVo"%>
<%@page import="java.util.ArrayList"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<StmtVo> donaList = (ArrayList<StmtVo>)request.getAttribute("donaResult");
	ArrayList<ExeVo> exeList = (ArrayList<ExeVo>)request.getAttribute("exeResult");
%>
<!DOCTYPE html>
<html>
<head>
	<!-- Latest compiled and minified CSS -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

<!-- Latest compiled JavaScript -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

<meta charset="UTF-8">
<title>기업 명세서 목록</title>
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

	form{
		width: 1000px;
	}

	table {
		width: 700px;
		color: #15462b;
		border-top: 3px solid #8bdcb1;
		border-bottom: 3px solid #8bdcb1;
		border-collapse: collapse;
		margin: auto;
		margin-bottom: 10px;
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

	.total {
		color: #2e6c4a;
		font-weight: bold;
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

	input {
		background-color: #8bdcb1;
		border: #8bdcb1;
		border-radius: 30px;
		color: #2e6c4a;
		font-weight: bolder;
		font-size: 20px;
		width: 130px;
		height: 40px;
		box-sizing: border-box;
	}

	#do_t {
		margin-left: 10px;
		font-size: 20px;
	}

	#do_ex, #do_tt, #do_tt2 {
		line-height: 35px;
		color: #2e6c4a;
	}

	hr {
		margin: 50px;
		border: 1px dashed #8bdcb1;
	}

	a, input[type=submit] {
        cursor: pointer;
    }
	
</style>
</head>
<body>
	<%@ include file="/views/common/header.jsp" %>
	<div id="body">
		
		<div id="category">
			<a>기업 명세서 목록</a>
		</div>
		
		<div id="nav">
			<div id="naviIn"><%@ include file="/views/mypageNav/corpNavi.jsp" %></div>

			<div id="content">
	
				<%for(int i = 0; i < donaList.size(); ++i) {%>
					<form action="/gibuAndTakePrj/corp/stmtRe" method="get">
						<table id="first">
						<input type="hidden" value="<%=donaList.get(i).getDonaNo() %>" name="donaNo">
							<div id="outer">
								<div id="title"><%=donaList.get(i).getRegName() %></div>
								<input type="submit" value="추가하기">
								
								<div id="do_t">기부금 집행 내역 |</div>
								<div id="do_ex">기부금이 어떻게 사용되었는지 등록해주세요.</div>
							</div>
							<tr>
								<th>집행기간</th>
								<td colspan="2">
									<fmt:parseDate var="parsedSdate" value="<%=donaList.get(i).getDonaSdate() %>" pattern="yyyy-MM-dd HH:mm:ss"/>
									<fmt:formatDate value="${parsedSdate}" pattern="yyyy-MM-dd" />
									~
									<fmt:parseDate var="parsedEdate" value="<%=donaList.get(i).getDonaEdate() %>" pattern="yyyy-MM-dd HH:mm:ss"/>
									<fmt:formatDate value="${parsedEdate}" pattern="yyyy-MM-dd" />
								</td>
							</tr>
							<tr>
								<th>총 모금 금액</th>
								<td colspan="2"><span class="total"><fmt:formatNumber value="<%=donaList.get(i).getDonaPmoney() %>" pattern="#,###"/></span>원(목표 금액 <fmt:formatNumber value="<%=donaList.get(i).getDonaGmoney() %>" pattern="#,###"/>원)</td>
							</tr>
							<tr>
								<th>사업 대상</th>
								<td colspan="2"><%=donaList.get(i).getDonaPerson() %></td>
							</tr>
						</table>
						<table id="second">
							<thead>
								<tr>
									<th>총 집행 금액</th>
									<td colspan="2"><fmt:formatNumber value="<%=donaList.get(i).getDonaPmoney() %>" pattern="#,###"/>원(목표 금액 <fmt:formatNumber value="<%=donaList.get(i).getDonaGmoney() %>" pattern="#,###"/>원)</td>
								</tr>
							</thead>
							<tbody>
								<%for(int j = 0; j < exeList.size(); ++j) {%>
									<%if(exeList.get(j).getDonaNo().equals(donaList.get(i).getDonaNo())){%>
									<tr>
										<th><%=exeList.get(j).getExeCtg() %></th>
										<td><%=exeList.get(j).getExeCnt() %></td>
										<td><fmt:formatNumber value="<%=exeList.get(j).getExeMoney() %>" pattern="#,###"/>원</td>
									</tr>
									<%} %>
								<%} %>
								</tbody>
						</table>
						<hr>
					</form>
				<%} %>
	
			</div>
		</div>
	</div>
	<%@ include file="/views/common/footer.jsp" %>
	

</body>
</html>