<%@page import="com.gnt.project.vo.DonationVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<% 
	DonationVo dvo = (DonationVo)session.getAttribute("editVo");
%>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Insert title here</title>

    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>

    <!-- cssForm -->
    <link rel="stylesheet" href="../../resources/css/pmForm.css" type="text/css" />
    
    <!-- summerNote -->
    <script src="../../resources/js/summernote/summernote-lite.js"></script>
	<script src="../../resources/js/summernote/lang/summernote-ko-KR.js"></script>
	<link rel="stylesheet" href="../../resources/css/summernote/summernote-lite.css">
	
    <style>
      #body {
        width: 1200px;
        margin: 0 auto;
      }

      #pm-form-outer {
        margin-bottom: 10%;
      }
      
      #pm-table2 {
	  	padding: 0px;
	  	border-spacing: 2px 5px;
	  }
	  
	  .form-subtitle2{
	  	width: 21%;
	  }
    </style>
  </head>
  <body>
    <%@ include file="/views/common/header.jsp" %>
    <div id="body">
      <div id="pm-header">
        <h1><a>기부 프로젝트 수정</a></h1>
      </div>
      <div id="pm-form-outer">
        <form action="<%=path%>/pm/edit/donation" method="post">
          <table id="pm-table">
            <tr>
              <td class="form-subtitle">카테고리</td>
              <td colspan="4">
                <select name="category" class="form-select form-content" id="inputGroupSelect01">
                  <option disabled="disabled" selected>${editVo.donaCategory}</option>
                </select>
              </td>
            </tr>
            <tr>
              <td class="form-subtitle">단체명</td>
              <td colspan="4">
                <input name="corp" type="text" class="form-control form-content" value="${loginCorp.nick}" readonly />
              </td>
            </tr>
            <tr>
              <td class="form-subtitle">프로젝트 제목</td>
              <td colspan="4">
                <input value="${editVo.title}" name="title" type="text" class="form-control form-content" placeholder="프로젝트의 제목을 입력하세요." readonly />
              </td>
            </tr>
            <tr>
              <td class="form-subtitle">모금 기간</td>
              <td class="form-content-sub">모금 종료일</td>
              <td class="form-content-date" colspan="3"><input value="${editVo.fDate}" name="fDate" type="date" class="form-control form-content" required /></td>
            </tr>
            <tr>
              <td class="form-subtitle">프로젝트 소개*</td>
              <td colspan="4">
                <textarea
                  id="summernote"
                  name="content"
                  class="form-control form-content form-content-textarea"
                  aria-label="With textarea"
                  required
                  >${editVo.content}</textarea>
              </td>
            </tr>
            <tr>
              <td class="form-subtitle">목표 금액</td>
              <td colspan="4">
                <input value="${editVo.gMoney}" name="goalMoney" type="text" class="form-control form-content" placeholder="목표 금액을 입력하세요." readonly />
              </td>
            </tr>
            <tr>
              <td colspan="5" class="sub-title">기부금 사용계획</td>
            </tr>
            <tr>
              <td class="form-subtitle">사업 대상*</td>
              <td colspan="4"><input value="${editVo.person}" name="exePerson" type="text" class="form-control form-content" placeholder="사업 대상을 입력하세요." required /></td>
            </tr>
            <tr>
              <td class="form-subtitle">사업 기간*</td>
              <td class="form-content-sub">사업 시작일</td>
              <td class="form-content-date">
                <input value="${editVo.exeSDate}" name="exeStartDate" type="date" class="form-control form-content" required />
              </td>
              <td class="form-content-sub">사업 종료일</td>
              <td class="form-content-date">
              	<input value="${editVo.exeEDate}" name="exeFinishDate" type="date" class="form-control form-content" required />
              </td>
            </tr>
         </table>
         <table id="pm-table2">
            <tr>
              <td class="form-subtitle form-subtitle2">사업 세부 사항*</td>
              <td>
                <select name="exeCategory" class="form-select form-content" id="inputGroupSelect01" required>
                  <option value="${editVo.donaExecategory[0]}">${editVo.donaExecategory[0]}</option>
                  <option value="사업비">사업비</option>
                  <option value="인건비">인건비</option>
                  <option value="운영비">운영비</option>
                  <option value="행사홍보비">행사홍보비</option>
                </select>
              </td>
              <td><input value="${editVo.donaExecontent[0]}" name="exeContent" type="text" class="form-control form-content" placeholder="사용 내용" required /></td>
              <td>
                <input value="${editVo.money[0]}" name="exeMoney" type="text" class="form-control form-content" placeholder="사용 금액" required />
              </td>
            </tr>
            <%for(int i = 1; i < (dvo.getDonaExecategory().length); i++) {%>
              <tr>
            	<td class="form-subtitle form-subtitle2"></td>
            	<td>
                <select name="exeCategory" class="form-select form-content" id="inputGroupSelect01" required>
                  <option value="<%=dvo.getDonaExecategory()[i]%>"><%=dvo.getDonaExecategory()[i]%></option>
                  <option value="사업비">사업비</option>
                  <option value="인건비">인건비</option>
                  <option value="운영비">운영비</option>
                  <option value="행사홍보비">행사홍보비</option>
                </select>
	            </td>
	            <td><input value="<%=dvo.getDonaExecontent()[i]%>" name="exeContent" type="text" class="form-control form-content" placeholder="사용 내용" required /></td>
	            <td>
	              <input value="<%=dvo.getMoney()[i]%>" name="exeMoney" type="text" class="form-control form-content" placeholder="사용 금액" required />
	            </td>
		      </tr>
		     <%}%>
          </table>
          <input type="button" onclick="addRow()" class="button add-button" value="추가" />
          <input type="button" onclick="deleteRow()" class="button" value="삭제" />

          <div id="form-notice">
            <span class="form-notice-title">유의사항</span>
            <p class="form-notice-content">
              - 참여자들이 프로젝트에 대한 자세한 정보를 확인할 수 있도록 작성해주세요. <br />
              - 카테고리, 단체명, 제목, 모금기간, 목표금액은 수정이 불가능합니다. <br />
              - 모금이 시작된 경우 프로젝트 삭제가 불가능합니다. <br />
              - (주)기부 앤 테이크는 프로젝트에 대한 책임을 지지 않습니다. <br />
            </p>
          </div>

          <div class="form-checkbox">
            <label class="form-check-label" for="flexCheckDefault">유의사항을 모두 확인하였습니다.</label>
            <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault" required />
          </div>

          <input type="submit" id="submit-btn" value="수정하기" />
        </form>
      </div>
    </div>
    <%@ include file="/views/common/footer.jsp" %>

    <script>
    	$('#summernote').summernote({
			  height: 500,                 // 에디터 높이
			  minHeight: 500,             // 최소 높이
			  focus: true,                  // 에디터 로딩후 포커스를 맞출지 여부
			  lang: "ko-KR",					// 한글 설정
			  placeholder: '프로젝트의 정보를 입력해주세요.',	//placeholder 설정
			  toolbar: [
			    ['fontsize', ['fontsize']],
			    ['style', ['bold', 'italic', 'underline']],
			    ['color', ['forecolor','color']],
			  	['para', ['paragraph']],
			  	['height', ['height']],
			  ],
		  	  fontSizes: ['8','9','10','11','12','14','16','18','20','22','24','28','30','36','50','72'],
    	});
	    	
		function addRow() {
		  const table = document.getElementById("pm-table2");
		
		  const newRow = table.insertRow();
		
		  const newCell1 = newRow.insertCell(0);
		  const newCell2 = newRow.insertCell(1);
		  const newCell3 = newRow.insertCell(2);
		  const newCell4 = newRow.insertCell(3);
		
		  newCell1.innerHTML = '<td class="form-subtitle form-subtitle2"></td>';
		  newCell2.innerHTML =
		    '<td><select name="exeCategory" class="form-select form-content" id="inputGroupSelect01" required><option value="사업비" selected>사업비</option><option value="인건비">인건비</option><option value="운영비">운영비</option><option value="행사홍보비">행사홍보비</option></select></td>';
		  newCell3.innerHTML = '<td colspan="2"><input name="exeContent" type="text" class="form-control form-content" placeholder="사용 내용" /></td>';
		  newCell4.innerHTML = '<td><input name="exeMoney" type="text" class="form-control form-content" placeholder="사용 금액" /></td>';
		}

		function deleteRow() {
		  const table = document.getElementById("pm-table2");
		  if (table.rows.length <= 1) return;
		  table.deleteRow(table.rows.length - 1);
		}
    </script>
  </body>
</html>
