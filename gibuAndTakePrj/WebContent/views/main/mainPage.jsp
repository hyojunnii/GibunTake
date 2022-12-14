<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Gibu n Take</title>
    <link rel="shortcut icon" type="image/x-icon" href="resources/img/free-icon-giving-5017478.png" />
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>

    <style>
      #body {
        width: 1200px;
        margin: 0 auto;
      }
      
      a {
      	text-decoration:none;
      	color: #000000;
      }
      
      a:hover {
      	color: #123c25;
      }

      .right {
        float: right;
      }

      .content-header {
        position: relative;
        width: 50%;
        top: 90px;
        right: -150px;
      }

      .donation-header {
        height: 300px;
      }

      .content-outer {
        height: 100%;
        background-color: #b3e0c9;
      }

      .content-img {
        height: 72%;
        width: 32%;
        position: relative;
        top: -80px;
        right: -670px;
        border-radius: 25px;
      }

      .content-img img {
        width: 100%;
        height: 100%;
        border-radius: 25px;
      }

      #funding {
        margin: 50px 10%;
      }

      #funding-header {
        margin-bottom: 20px;
        display: flex;
        justify-content: space-between;
      }

      #funding-header h5 {
        font-weight: 600;
        color: #15462b;
      }

      #funding-header a {
        text-decoration: none;
        background-color: #dee2e6;
        padding: 7px 10px 4px;
        border-radius: 15px;
        font-size: 13px;
        font-weight: 600;
        color: #2e6c4a;
      }

      #funding-header a:hover {
        background-color: #cfe6da;
      }

      #funding-content {
        display: flex;
        justify-content: space-evenly;
      }

      .f-content {
        border: none;
      }
      
      .f-content img {
        border-radius: 10px;
      }

      .f-content-info {
        display: flex;
      }

      .progress-title {
        font-size: 12px;
        font-weight: 600;
        padding-bottom: 2px;
      }

      .progress-money {
        font-size: 11px;
        float: right;
        position: relative;
        top: -7px;
      }

      #info-outer {
        background-color: #b3e0c9;
        padding: 20px 10%;
        height: 170px;
        display: flex;
        align-items: center;
      }

      #info-img {
        width: 20%;
        margin-right: -20px;
      }

      #info-img img {
        width: 70%;
        height: 100%;
      }
      
      #info-content {
      	width: 40%;
      }

      #info-content h3 {
        font-weight: 700;
        color: #123c25;
      }

      #info-content span {
        font-size: 15px;
      }

      #info-content2 {
        font-size: 18px;
      }
      #info-content2 table {
        border-collapse: separate;
        border-spacing: 20px 15px;
      }
      
      #info-content2 tr > td:nth-child(3) {
      	padding-left: 10px;
      }

      .t-title {
        font-weight: 600;
        color: #123c25;
      }

      #campaign h5 {
        margin-top: 40px;
        color: #123c25;
        font-size: 20px;
      }

      #campaign-content {
        margin: 25px 15% 40px;
        display: flex;
        justify-content: space-around;
      }

      #campaign-content-info {
        display: flex;
        justify-content: space-between;
        margin: 0 15px 0 10px;
      }
      
      .card-img {
      	height: 128px;
      }
      
      .cam-img {
      	height: 270px;
      	width: 400px;
      }
    </style>
  </head>
  <body>
    <%@ include file="/views/common/header.jsp" %>

    <div id="body">
      <div id="donation">
        <div id="carouselExampleCaptions" class="carousel carousel-dark slide" data-bs-ride="carousel">
          <div class="carousel-indicators">
            <button
              type="button"
              data-bs-target="#carouselExampleCaptions"
              data-bs-slide-to="0"
              class="active"
              aria-current="true"
              aria-label="Slide 1"
            ></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="1" aria-label="Slide 2"></button>
            <button type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide-to="2" aria-label="Slide 3"></button>
          </div>
          <div class="carousel-inner donation-header">
            <div class="carousel-item active content-outer">
              <div class="content-header">
                <span>???????????????</span>
                <h3><a href="<%=path%>/view/gibu_detail?type=0&num=1">????????? ?????? ????????? ?????? ??????????????????</a></h3>
                <br />
                <h6>??????????????????</h6>
              </div>
              <div class="content-img">
                <a href="<%=path%>/view/gibu_detail?type=0&num=1"><img src="resources/img/main_img/???????????????.png" class="right img-fluid" alt="???????????????" /></a>
              </div>
            </div>
            <div class="carousel-item content-outer">
              <div class="content-header">
                <span>?????????</span>
                <h3><a href="<%=path%>/view/gibu_detail?type=0&num=5">????????? ?????? ?????????????????? ?????? ????????????</a></h3>
                <br />
                <h6>??????????????????</h6>
              </div>
              <div class="content-img">
                <a href="<%=path%>/view/gibu_detail?type=0&num=5"><img src="resources/img/main_img/???????????????.png" class="right img-fluid" alt="???????????????" /></a>
              </div>
            </div>
            <div class="carousel-item content-outer">
              <div class="content-header">
                <span>?????????</span>
                <h3><a href="<%=path%>/view/gibu_detail?type=0&num=4">???????????? ??????, ?????????????????? ??????????????????</a></h3>
                <br />
                <h6>??????????????????</h6>
              </div>
              <div class="content-img">
                <a href="<%=path%>/view/gibu_detail?type=0&num=4"><img src="resources/img/main_img/???????????????.jpg" class="right img-fluid" alt="???????????????" /></a>
              </div>
            </div>
          </div>
          <button class="carousel-control-prev" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="prev">
            <span class="carousel-control-prev-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Previous</span>
          </button>
          <button class="carousel-control-next" type="button" data-bs-target="#carouselExampleCaptions" data-bs-slide="next">
            <span class="carousel-control-next-icon" aria-hidden="true"></span>
            <span class="visually-hidden">Next</span>
          </button>
        </div>
      </div>
      <div id="funding">
        <div id="funding-header">
          <h5>????????????????????? ?????? ??????</h5>
          <a href="<%=path%>/view/funding">????????? &gt;</a>
        </div>
        <div id="funding-content">
          <div class="card f-content" style="width: 20%">
            <a href="<%=path%>/view/funding_detail?type=0&num=8"><img src="resources/img/main_img/????????????.jpg" class="card-img-top card-img" /></a>
            <div class="card-body">
              <div class="card-title progress-title"><a href="<%=path%>/view/funding_detail?type=0&num=8">???????????? ????????? ????????????</a></div>
              <div class="progress-money">1,000,000???</div>
              <div class="progress" style="height: 5px; width: 58%">
                <div class="progress-bar bg-success" role="progressbar" style="width: 0%; height: 5px"></div>
              </div>
            </div>
          </div>
          <div class="card f-content" style="width: 20%">
            <a href="<%=path%>/view/funding_detail?type=0&num=10"><img src="resources/img/main_img/??????????????????.jpg" class="card-img-top card-img" /></a>
            <div class="card-body">
              <div class="card-title progress-title"><a href="<%=path%>/view/funding_detail?type=0&num=10">????????? ?????? ?????? ?????? ??????</a></div>
              <div class="progress-money">1,000,000???</div>
              <div class="progress" style="height: 5px; width: 58%">
                <div class="progress-bar bg-success" role="progressbar" style="width: 0%; height: 5px"></div>
              </div>
            </div>
          </div>
          <div class="card f-content" style="width: 20%">
            <a href="<%=path%>/view/funding_detail?type=0&num=11"><img src="resources/img/main_img/??????????????????.jpeg" class="card-img-top card-img"/></a>
            <div class="card-body">
              <div class="card-title progress-title"><a href="<%=path%>/view/funding_detail?type=0&num=11">??????????????? ?????? ????????? ?????????</a></div>
              <div class="progress-money">500,000???</div>
              <div class="progress" style="height: 5px; width: 58%">
                <div class="progress-bar bg-success" role="progressbar" style="width: 0%; height: 5px"></div>
              </div>
            </div>
          </div>
          <div class="card f-content" style="width: 20%">
            <a href="<%=path%>/view/funding_detail?type=0&num=12"><img src="resources/img/main_img/???????????????.jpg" class="card-img-top card-img" /></a>
            <div class="card-body">
              <div class="card-title progress-title"><a href="<%=path%>/view/funding_detail?type=0&num=12">????????? ?????? ??? ??????</a></div>
              <div class="progress-money">1,000,000???</div>
              <div class="progress" style="height: 5px; width: 58%">
                <div class="progress-bar bg-success" role="progressbar" style="width: 0%; height: 5px"></div>
              </div>
            </div>
          </div>
        </div>
      </div>
      <div id="info-outer">
        <div id="info-img">
          <img src="resources/img/free-icon-giving-5017478.png" class="img-fluid" />
        </div>
        <div id="info-content">
          <h3><a href="<%=path%>/story">????????? ????????????</a></h3>
          <p>????????? ????????? ????????? ????????????</p>
          <span>${todayStory.getToday()}</span>
        </div>
        <div id="info-content2">
          <table>
            <tr>
              <td class="t-title">????????????</td>
              <td>${todayStory.getdPeople()}???</td>
              <td class="t-title">????????????</td>
              <td>${todayStory.getdMoney()}???</td>
            </tr>
            <tr id="info-content2-tr2">
              <td class="t-title">????????????</td>
              <td>${todayStory.getfPeople()}???</td>
              <td class="t-title">????????????</td>
              <td>${todayStory.getfMoney()}???</td>
            </tr>
          </table>
        </div>
      </div>
      <div id="campaign">
        <h5 align="center"><a href="<%=path %>/view/campaign">????????????????????? ?????? ????????????!</a></h5>
        <div id="campaign-content">
          <figure class="figure">
            <a href="<%=path%>/view/campaign_detail?type=0&num=14"><img src="resources/img/main_img/????????????.jpeg" class="figure-img img-fluid rounded cam-img" alt="????????????" /></a>
            <div id="campaign-content-info">
              <figcaption class="figure-caption" style="color: #000000"><a href="<%=path%>/view/campaign_detail?type=0&num=14">???????????? ???????????? ?????? ????????????!</a></figcaption>
              <figcaption class="figure-caption">??????????????????</figcaption>
            </div>
          </figure>
          <figure class="figure">
            <a href="<%=path%>/view/campaign_detail?type=0&num=13"><img src="resources/img/main_img/????????????.jpeg" class="figure-img img-fluid rounded cam-img" alt="????????????" /></a>
            <div id="campaign-content-info">
              <figcaption class="figure-caption" style="color: #000000"><a href="<%=path%>/view/campaign_detail?type=0&num=13">??????????????? ????????? ??????????????? ?????????!</a></figcaption>
              <figcaption class="figure-caption">??????????????????</figcaption>
            </div>
          </figure>
        </div>
      </div>
    </div>
    <%@ include file="/views/common/footer.jsp" %>
  </body>
</html>
