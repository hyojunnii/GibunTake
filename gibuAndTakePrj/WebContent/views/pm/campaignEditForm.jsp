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

      .form-subtitle {
        width: 10%;
      }
      .sub-title {
        padding-left: 5%;
      }
      .form-content-sub {
        width: 8%;
      }

      #pm-form-outer {
        margin-bottom: 10%;
      }
    </style>
  </head>
  <body>
    <%@ include file="/views/common/header.jsp" %>
    <div id="body">
      <div id="pm-header">
        <h1><a>캠페인 프로젝트 수정</a></h1>
      </div>
      <div id="pm-form-outer">
        <form action="<%=path%>/pm/edit/campaign" method="post">
          <!-- name 안채움 -->
          <table id="pm-table">
            <tr>
              <td class="form-subtitle">진행자명</td>
              <td colspan="4">
                <input name="corp" type="text" class="form-control form-content" value="${loginCorp.nick}" readonly />
              </td>
            </tr>
            <tr>
              <td class="form-subtitle">프로젝트 제목</td>
              <td colspan="4">
                <input value="${editVo.title}" name="title" type="text" class="form-control form-content" placeholder="프로젝트의 제목을 입력하세요." required readonly />
              </td>
            </tr>
            <tr>
              <td class="form-subtitle">캠페인 기간</td>
              <td class="form-content-sub">캠페인 종료일</td>
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
              <td class="form-subtitle">목표 인원*</td>
              <td colspan="4">
                <input value="${editVo.gPeople}" name="gPeople" type="text" class="form-control form-content" placeholder="목표 인원을 입력하세요." required />
              </td>
            </tr>
          </table>

          <div id="form-notice">
            <span class="form-notice-title">유의사항</span>
            <p class="form-notice-content">
              - 참여자들이 프로젝트에 대한 자세한 정보를 확인할 수 있도록 작성해주세요. <br />
              - 진행자명, 제목은 수정이 불가능합니다. <br />
              - 캠페인이 시작된 경우 프로젝트 삭제가 불가능합니다. <br />
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
	    	});
	    });
	</script>    
  </body>
</html>
