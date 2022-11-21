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

    <style>
      body {
        width: 1200px;
        margin: 0 auto;
      }

      #modal-outer {
        width: 400px;
      }

      #modal-form {
        height: 580px;
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
        font-weight: 500;
      }

      #modal-form-textarea {
        height: 200px;
        width: 90%;
        border-radius: 15px;
        margin: 6% auto;
        border: 1px solid #acdac2;
      }

      #modal-form-file {
        width: 90%;
        margin: 0 auto;
        border-radius: 15px;
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
        justify-content: center;
      }

      .count {
        position: absolute;
        right: 13%;
        bottom: 50%;
        color: #666;
        font-size: 15px;
      }
    </style>
  </head>
  <body>
    <button type="button" class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">참여하기</button>

    <div class="modal" id="exampleModal" data-bs-backdrop="static" data-bs-keyboard="false" tabindex="-1">
      <div class="modal-dialog modal-dialog-centered" id="modal-outer">
        <div class="modal-content" id="modal-form">
          <div class="modal-header" id="modal-header">
            <h5 class="modal-title">참여하기</h5>
          </div>
          <div class="modal-body" id="modal-body">
            <form action="" method="">
              <div id="modal-form-title">캠페인 제목</div>
              <textarea id="modal-form-textarea" class="form-control" aria-label="With textarea" placeholder="인증 사진을 첨부해주세요."></textarea>
              <div class="count"><span>0</span>/100</div>
              <input type="file" class="form-control" id="modal-form-file" />
              <p id="modal-form-info">
                -사진은 ?mb이하 최대 1장까지 등록 가능합니다. <br />
                -미션 내용에 맞지 않거나 게시글 정책에 맞지 않는 경우 삭제됩니다.
              </p>
              <div id="modal-form-buttons">
                <input type="button" class="modal-form-button" data-bs-dismiss="modal" value="취소" />
                <input type="submit" class="modal-form-button" value="인증" />
              </div>
            </form>
          </div>
        </div>
      </div>
    </div>

    <script>
      $("#modal-form-textarea").keyup(function () {
        var content = $(this).val();
        $("#modal-body .count span").html(content.length);
        if (content.length > 100) {
          $(this).val(content.substring(0, 100));
          $("#modal-body .count span").html(100);
        }
      });
    </script>
  </body>
</html>
