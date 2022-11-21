<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
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
        <h1><a>기부 프로젝트 신청</a></h1>
      </div>
      <div id="pm-form-outer">
        <form action="<%=path%>/pm/apply/donation" method="post" enctype="multipart/form-data">
          <table id="pm-table">
            <tr>
              <td class="form-subtitle">카테고리*</td>
              <td colspan="4">
                <select name="category" class="form-select form-content" id="inputGroupSelect01" required>
                  <option value="" selected>카테고리를 선택하세요.</option>
                  <option value="아동청소년">아동/청소년</option>
                  <option value="어르신">어르신</option>
                  <option value="장애인">장애인</option>
                  <option value="다문화">다문화</option>
                  <option value="지구촌">지구촌</option>
                  <option value="가족여성">가족/여성</option>
                  <option value="시민사회">시민사회</option>
                  <option value="동물">동물</option>
                </select>
              </td>
            </tr>
            <tr>
              <td class="form-subtitle">단체명*</td>
              <td colspan="4"><input name="corp" type="text" class="form-control form-content" placeholder="단체명을 입력하세요." value="${loginCorp.nick}" disabled /></td>
            </tr>
            <tr>
              <td class="form-subtitle">프로젝트 제목*</td>
              <td colspan="4">
                <input name="title" type="text" class="form-control form-content" placeholder="프로젝트의 제목을 입력하세요." required />
              </td>
            </tr>
            <tr>
              <td class="form-subtitle">모금 기간*</td>
              <td class="form-content-sub">모금 종료일</td>
              <td class="form-content-date" colspan="3"><input name="fDate" type="date" class="form-control form-content" required /></td>
            </tr>
            <tr id="file">
              <td class="form-subtitle">대표 이미지 첨부*</td>
              <td colspan="4">
                <input type="file" name="file" class="form-control form-content" accept="image/*" />
              </td>
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
                ></textarea>
              </td>
            </tr>
            <tr>
              <td class="form-subtitle">목표 금액*</td>
              <td colspan="4"><input name="goalMoney" type="text" class="form-control form-content" placeholder="목표 금액을 입력하세요." required /></td>
            </tr>
            <tr>
              <td colspan="5" class="sub-title">기부금 사용계획</td>
            </tr>
            <tr>
              <td class="form-subtitle">사업 대상*</td>
              <td colspan="4"><input name="exePerson" type="text" class="form-control form-content" placeholder="사업 대상을 입력하세요." required /></td>
            </tr>
            <tr>
              <td class="form-subtitle">사업 기간*</td>
              <td class="form-content-sub">사업 시작일</td>
              <td class="form-content-date">
                <input name="exeStartDate" type="date" class="form-control form-content" required />
              </td>
              <td class="form-content-sub">사업 종료일</td>
              <td class="form-content-date"><input name="exeFinishDate" type="date" class="form-control form-content" required /></td>
            </tr>
            </table>
            <table id="pm-table2">
              <tr>
                <td class="form-subtitle form-subtitle2">사업 세부 사항*</td>
                <td>
                  <select name="exeCategory" class="form-select form-content" id="inputGroupSelect01" required>
                    <option value="사업비" selected>사업비</option>
                    <option value="인건비">인건비</option>
                    <option value="운영비">운영비</option>
                    <option value="행사홍보비">행사홍보비</option>
                  </select>
                </td>
                <td><input name="exeContent" type="text" class="form-control form-content" placeholder="사용 내용" required /></td>
                <td>
                  <input name="exeMoney" type="text" class="form-control form-content" placeholder="사용 금액" required />
                </td>
              </tr>
          </table>
          <input type="button" onclick="addRow()" class="button add-button" value="추가" />
          <input type="button" onclick="deleteRow()" class="button" value="삭제" />

          <div id="form-notice">
            <span class="form-notice-title">유의사항</span>
            <p class="form-notice-content">
              - 참여자들이 프로젝트에 대한 자세한 정보를 확인할 수 있도록 작성해주세요. <br />
              - 신청한 프로젝트는 관리자의 승인 후 게시가 이루어집니다. <br />
              - 카테고리, 단체명, 제목, 목표금액은 등록 후 수정이 불가능합니다. <br />
              - 모금이 시작되면 프로젝트 삭제가 불가능합니다. <br />
              - (주)기부 앤 테이크는 프로젝트에 대한 책임을 지지 않습니다. <br />
            </p>
          </div>

          <div class="form-checkbox">
            <label class="form-check-label" for="flexCheckDefault">유의사항을 모두 확인하였습니다.</label>
            <input class="form-check-input" type="checkbox" value="" id="flexCheckDefault" required />
          </div>

          <input type="submit" id="submit-btn" value="신청하기" />
        </form>
      </div>
    </div>
    <%@ include file="/views/common/footer.jsp" %>

    <script>
	    $(document).ready(function() {
	    	$('#summernote').summernote({
				  height: 400,                 // 에디터 높이
				  minHeight: 400,             // 최소 높이
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
				  /* callbacks: {	//여기 부분이 이미지를 첨부하는 부분
					onImageUpload : function(files) {
						uploadSummernoteImageFile(files[0],this);
					},
					onPaste: function (e) {
						var clipboardData = e.originalEvent.clipboardData;
						if (clipboardData && clipboardData.items && clipboardData.items.length) {
							var item = clipboardData.items[0];
							if (item.kind === 'file' && item.type.indexOf('image/') !== -1) {
								e.preventDefault();
							}
						}
					}
				} */
	    	});
	    	/* $("div.note-editable").on('drop',function(e){
	            for(i=0; i< e.originalEvent.dataTransfer.files.length; i++){
	            	uploadSummernoteImageFile(e.originalEvent.dataTransfer.files[i],$("#summernote")[0]);
	            }
	           e.preventDefault();
	     	}) */
	    });
	    
	    /* function uploadSummernoteImageFile(file, editor) {
			data = new FormData();
			data.append("file", file);
			$.ajax({
				data : data,
				type : "POST",
				url : "/uploadContentImgFile",
				contentType : false,
				processData : false,
				success : function(data) {
					$(editor).summernote('insertImage', data.url);
				}
			});
		} */
	    
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
