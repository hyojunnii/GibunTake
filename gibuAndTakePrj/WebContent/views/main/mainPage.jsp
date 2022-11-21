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
                <span>아동청소년</span>
                <h3><a href="<%=path%>/view/gibu_detail?type=0&num=1">진규의 꿈과 재능을 함께 응원해주세요</a></h3>
                <br />
                <h6>기부앤테이크</h6>
              </div>
              <div class="content-img">
                <a href="<%=path%>/view/gibu_detail?type=0&num=1"><img src="resources/img/main_img/청소년진규.png" class="right img-fluid" alt="청소년진규" /></a>
              </div>
            </div>
            <div class="carousel-item content-outer">
              <div class="content-header">
                <span>어르신</span>
                <h3><a href="<%=path%>/view/gibu_detail?type=0&num=5">추석을 맞아 어르신들에게 효를 배달해요</a></h3>
                <br />
                <h6>기부앤테이크</h6>
              </div>
              <div class="content-img">
                <a href="<%=path%>/view/gibu_detail?type=0&num=5"><img src="resources/img/main_img/추석어르신.png" class="right img-fluid" alt="추석어르신" /></a>
              </div>
            </div>
            <div class="carousel-item content-outer">
              <div class="content-header">
                <span>지구촌</span>
                <h3><a href="<%=path%>/view/gibu_detail?type=0&num=4">계속되는 전쟁, 우크라이나를 기억해주세요</a></h3>
                <br />
                <h6>기부앤테이크</h6>
              </div>
              <div class="content-img">
                <a href="<%=path%>/view/gibu_detail?type=0&num=4"><img src="resources/img/main_img/우크라이나.jpg" class="right img-fluid" alt="우크라이나" /></a>
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
          <h5>기부앤테이크의 추천 펀딩</h5>
          <a href="<%=path%>/view/funding">더보기 &gt;</a>
        </div>
        <div id="funding-content">
          <div class="card f-content" style="width: 20%">
            <a href="<%=path%>/view/funding_detail?type=0&num=8"><img src="resources/img/main_img/수제어묵.jpg" class="card-img-top card-img" /></a>
            <div class="card-body">
              <div class="card-title progress-title"><a href="<%=path%>/view/funding_detail?type=0&num=8">할머니의 맛있는 수제어묵</a></div>
              <div class="progress-money">1,000,000원</div>
              <div class="progress" style="height: 5px; width: 58%">
                <div class="progress-bar bg-success" role="progressbar" style="width: 0%; height: 5px"></div>
              </div>
            </div>
          </div>
          <div class="card f-content" style="width: 20%">
            <a href="<%=path%>/view/funding_detail?type=0&num=10"><img src="resources/img/main_img/탄소저감커피.jpg" class="card-img-top card-img" /></a>
            <div class="card-body">
              <div class="card-title progress-title"><a href="<%=path%>/view/funding_detail?type=0&num=10">지구를 위한 탄소 저감 커피</a></div>
              <div class="progress-money">1,000,000원</div>
              <div class="progress" style="height: 5px; width: 58%">
                <div class="progress-bar bg-success" role="progressbar" style="width: 0%; height: 5px"></div>
              </div>
            </div>
          </div>
          <div class="card f-content" style="width: 20%">
            <a href="<%=path%>/view/funding_detail?type=0&num=11"><img src="resources/img/main_img/댕냥이장난감.jpeg" class="card-img-top card-img"/></a>
            <div class="card-body">
              <div class="card-title progress-title"><a href="<%=path%>/view/funding_detail?type=0&num=11">유기동물을 돕는 댕냥이 장난감</a></div>
              <div class="progress-money">500,000원</div>
              <div class="progress" style="height: 5px; width: 58%">
                <div class="progress-bar bg-success" role="progressbar" style="width: 0%; height: 5px"></div>
              </div>
            </div>
          </div>
          <div class="card f-content" style="width: 20%">
            <a href="<%=path%>/view/funding_detail?type=0&num=12"><img src="resources/img/main_img/천연귤과자.jpg" class="card-img-top card-img" /></a>
            <div class="card-body">
              <div class="card-title progress-title"><a href="<%=path%>/view/funding_detail?type=0&num=12">색다른 천연 귤 과자</a></div>
              <div class="progress-money">1,000,000원</div>
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
          <h3><a href="<%=path%>/story">오늘의 참여현황</a></h3>
          <p>오늘의 마음이 이만큼 모였어요</p>
          <span>${todayStory.getToday()}</span>
        </div>
        <div id="info-content2">
          <table>
            <tr>
              <td class="t-title">기부참여</td>
              <td>${todayStory.getdPeople()}명</td>
              <td class="t-title">기부총액</td>
              <td>${todayStory.getdMoney()}원</td>
            </tr>
            <tr id="info-content2-tr2">
              <td class="t-title">펀딩참여</td>
              <td>${todayStory.getfPeople()}명</td>
              <td class="t-title">펀딩총액</td>
              <td>${todayStory.getfMoney()}원</td>
            </tr>
          </table>
        </div>
      </div>
      <div id="campaign">
        <h5 align="center"><a href="<%=path %>/view/campaign">기부앤테이크와 함께 행동해요!</a></h5>
        <div id="campaign-content">
          <figure class="figure">
            <a href="<%=path%>/view/campaign_detail?type=0&num=14"><img src="resources/img/main_img/작은가게.jpeg" class="figure-img img-fluid rounded cam-img" alt="작은가게" /></a>
            <div id="campaign-content-info">
              <figcaption class="figure-caption" style="color: #000000"><a href="<%=path%>/view/campaign_detail?type=0&num=14">우리동네 작은가게 함께 응원해요!</a></figcaption>
              <figcaption class="figure-caption">기부앤테이크</figcaption>
            </div>
          </figure>
          <figure class="figure">
            <a href="<%=path%>/view/campaign_detail?type=0&num=13"><img src="resources/img/main_img/지구온도.jpeg" class="figure-img img-fluid rounded cam-img" alt="지구온도" /></a>
            <div id="campaign-content-info">
              <figcaption class="figure-caption" style="color: #000000"><a href="<%=path%>/view/campaign_detail?type=0&num=13">지구온도를 내리고 실내온도는 높여요!</a></figcaption>
              <figcaption class="figure-caption">기부앤테이크</figcaption>
            </div>
          </figure>
        </div>
      </div>
    </div>
    <%@ include file="/views/common/footer.jsp" %>
  </body>
</html>
