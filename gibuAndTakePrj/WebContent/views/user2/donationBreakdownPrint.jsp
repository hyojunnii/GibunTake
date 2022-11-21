<%@page import="com.gnt.breakdown.vo.BreakdownVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	BreakdownVo vo = (BreakdownVo)request.getAttribute("vo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기부금 영수증 출력</title>
<style>

	td {
		text-align: center;
	}

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

    #res {
        width: 1000px;
    }

    #top-outer{
        margin: auto;
        margin-top: 50px;
        width: 800px;

        display: flex;
        justify-content: space-between;
        align-items: center;
    }

    #no {
        width: 160px;
        text-align: center;
        display: flex;
        height: 25px;
    }

    .no {
        width: 80px;
        box-sizing: border-box;
        border: 1px solid gray;
    }

    #btn-outer {
        width: 200px;
        display: flex;
    }

    #print, #back {
		background-color: #8bdcb1;
		border: none;
		border-radius: 25px;
		color: #2e6c4a;
		width: 100px;
        height: 40px;
        margin: 5px;
        
        justify-content: center;
        align-items: center;
		font-weight: bolder;
		font-size: 20px;
        
        display: flex;
    }

    #title {
        text-align: center;
        font-size: 40px;
    }

    table {
        width: 900px;
        border-top: 1px solid black;
        border-collapse: collapse;
        margin: 5px auto;
    }

    table td:first-child {
        font-size: 20px;
    }

    th, td {
        border-bottom: 1px solid black;
        border-left: 1px solid black;
        padding: 10px;
    }

    th{
        text-align: left;
        width: 150px;
    }


    #fourth th {
        text-align: center;
    }

    th:first-child, td:first-child {
        border-left: none;
    }

    #fourth th:nth-child(3) {
        text-align: center;
        border-right: 1px solid black;
    }

    tr:nth-child(2), tr:first-child{
        border-top: 3px solid #8bdcb1;
    }

    tr:last-child{
        border-bottom: 3px solid #8bdcb1;
    }

    .text {
        width: 800px;
        margin: auto;
        padding: 10px;
        text-indent: 2em;
    }

    hr{
        width: 900px;
        border: 2px solid #8bdcb1;
        margin-bottom: 10px;
    }

    .date {
        width: 800px;
        margin: auto;
        text-align: right;
    }

    .name {
    	width:400px;
    	text-align: right;
    }
    
    #memName, #gntName {
    	display: flex;
    	justify-content: center;
    }

    .sign {
        width: 800px;
        margin: auto;
        text-align: right;
        color: lightgray;
    }
    
    a {
        cursor: pointer;
    }

    #print:hover, #back:hover {
        background-color: #2e6c4a;
        color: #8bdcb1;
    }

    @media print {
        .noprint { 
	        display:none;
	    }
    }

    .mTitle{
        text-align: left;
    }
</style>
</head>
<body>

    <%@include file="/views/common/header.jsp" %>

    <div id="body">
        <div id="nav">
            <div id="naviIn"><%@ include file="/views/mypageNav/mypageNavi.jsp" %></div>
            <div id="res">
                <div id="top-outer">
                    <div id="no">
                        <div class="no">일련번호</div>
                        <div class="no">11-111</div>
                    </div>
                
                    <div id="title">기 부 금  영 수 증</div>
                    <div id="btn-outer">
                        <a id="print" class="noprint" onclick="printPage()">출력하기</a>
                        <a id="back" class="noprint" onclick="history.back()">돌아가기</a>
                    </div>
                </div>
        
        
                <table>
                    <tr id="first">
                        <td colspan="7" class="mTitle">1 기부자</td>
                    </tr>
                    <tr>
                        <th>성명</th>
                        <td colspan="2"><%=vo.getMemberName() %></td>
                        <th colspan="2">주민등록번호</th>
                        <td colspan="2">
                            <c:set var="memRegNum" value="<%=vo.getMemberRegNum() %>" />
                            <c:out value="${fn:substring(memRegNum, 0, 6)}"/>
                            -
                            <c:out value="${fn:substring(memRegNum, 6, 13)}"/>
                        </td>
                    </tr>
                    <tr>
                        <th>주소(소재지)</th>
                        <td colspan="6"><%=vo.getMemberAdd() %></td>
                    </tr>
                </table>
                <table id="second">
                    <tr>
                        <td colspan="7" class="mTitle">2 기부금 단체</td>
                    </tr>
                    <tr>
                        <th>단체명</th>
                        <td colspan="2"><%=vo.getCorpName() %></td>
                        <th colspan="2">사업자등록번호</th>
                        <td colspan="2">
                            <c:set var="corpRegNum" value="<%=vo.getCorpRegNum() %>" />
                            <c:out value="${fn:substring(corpRegNum, 0, 3)}"/>
                            -
                            <c:out value="${fn:substring(corpRegNum, 3, 5)}"/>
                            -
                            <c:out value="${fn:substring(corpRegNum, 5, 9)}"/>
                        
                        </td>
                    </tr>
                    <tr>
                        <th>소재지</th>
                        <td colspan="2"><%=vo.getCorpAdd() %></td>
                        <th colspan="2">기부금공공제대상<br>
                        공익법인등 근거법령</th>
                        <td colspan="2"></td>
                    </tr>
                </table>
            
                <table id="third">
                    <tr>
                        <td colspan="7" class="mTitle">3 기부금 모집처</td>
                    </tr>
                    <tr>
                        <th>단체명</th>
                        <td colspan="2">기부 앤 테이크</td>
                        <th colspan="2">사업자등록번호</th>
                        <td colspan="2">444 - 55 - 666666</td>
                    </tr>
                    <tr>
                        <th>주소(소재지)</th>
                        <td colspan="6">기부시 앤구 테이크동</td>
                    </tr>
                </table>
            
                <table id="fourth">
                    <tr>
                        <td colspan="7" class="mTitle">4 기부 내용</td>
                    </tr>
                    <tr>
                        <th rowspan="2">코드</th>
                        <th rowspan="2">구분<br>
                        (금전 또는 현물)</th>
                        <th rowspan="2">연월일</th>
                        <th colspan="3">내용</th>
                        <th rowspan="2">금액</th>
                    </tr>
                    <tr>
                        <th>품명</th>
                        <th>수량</th>
                        <th>단가</th>
                    </tr>
                    <tr>
                        <td>40</td>
                        <td>금전</td>
                        <td>
                        	<fmt:parseDate var="parsedDate" value="${vo.payDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        	<fmt:formatDate value="${parsedDate}" pattern="yyyy-MM-dd" />​
                        </td>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td><fmt:formatNumber value="${vo.payMoney}" pattern="#,###"/></td>
                    </tr>
                </table>
            
                <hr>
            
                <div class="text">
                    「소득세법」제34조,「조세특례제한법」제76조·제88조의4 및 「법인세법」제24조에 따른 기부금을 위와 같이 기부하였음을 증명하여 주시기 바랍니다.
                </div>
                <div class="date">
                    <c:set var="now" value="<%=new java.util.Date() %>"></c:set>
                    <fmt:formatDate value="${now }" pattern="yyyy-MM-dd" var="today"/>
                    <c:out value="${today }"/>
                </div>
                <div id="memName">
	                <div class="name">
	                    신청인 
	                </div>
	                <div class="name"><%=vo.getMemberName() %></div>
                </div>
                <div class="sign">
                    (서명 또는 인)
                </div>
                
                <hr>
            
                <div class="text">
                    위와 같이 기부금을 기부받았음을 증명합니다.
                </div>
                <div class="date">
                    <c:out value="${today }"/>
                </div>
                <div id="gntName">
	                <div class="name">
	                    기부금 수령인
	                </div>
	                <div class="name">(주) 기부 앤 테이크 (팀) 불사조</div>
                </div>
                <div class="sign">
                    (서명 또는 인)
                </div>
            
                <hr>
            </div>
        </div>

    </div>
    
    <%@include file="/views/common/footer.jsp" %>
    
    <script>
        function printPage(){
            var initBody = initBody = document.body.innerHTML;
            window.onbeforeprint = function(){
                document.body.innerHTML = document.getElementById('res').innerHTML;
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