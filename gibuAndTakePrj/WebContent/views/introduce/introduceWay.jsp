<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    
    #body {
        width: 1200px;
        margin: 0 auto;
    }

    #way {
        background-color: #EBF5E0;
        color: #2e6c4a;
        font-weight: bold;
        border-radius: 15px;
    }

    .btn-area{
        width: 1200px;
        text-align: center;
        margin-top: 30px;
        margin-bottom: 50px;
    }

    .btn-area a {
        text-decoration: none;
        border: none;
        color: #2e6c4a;
        font-size: 20px;
        font-weight: bolder;
        border-radius: 50px;
        background-color: #d8eee2;
        padding: 15px;
    }

    .btn-area a:hover {
        background-color: #2e6c4a;
        color: #d8eee2;
    }

    .img{
        display: flex;
        justify-content: space-evenly;
    }

    img{
        border-radius: 20px;
        border: 3px solid #8bdcb1;
        width: 500px;
        padding: 5px;
    }

    .text {
        font-size: 20px;
        text-align: left;
        line-height: 120px;
        color: #2e6c4a;
    }

    h2 {
        background-color: #d8eee2;
        color: #2e6c4a;
        text-align: center;
    }
</style>
</head>
<body>
	<%@include file="/views/introduce/introduceHead.jsp" %>

    <div id="body">

        <div id="category">
            <a>기부앤테이크에 함께하는 방법</a>
        </div>
        <!--
            이미지 다 3번 형식으로 바꿀 예정
        -->
        <h2>1 기부하기</h2>
        <div id="img-area">
            <div class="img">
                <img src="/gibuAndTakePrj/resources/img/intro_gibu.png" alt="기부 방법 이미지">
                <div class="text">
                1. 기부 목록에서 참여하고 싶은 기부를 선택한다. <br>
                2. 기부하기를 누른다. <br>
                3. 기부금 결제를 진행한다. <br>
                4. 마이페이지에서 나의 기부 내역을 볼 수 있다.
                </div>
            </div>

            <div class="btn-area">
                <a href="<%=path %>/view/gibu">기부하러 가기</a>
            </div>

            <h2>2 펀딩하기</h2>
            <div class="img">
                <img src="/gibuAndTakePrj/resources/img/intro_funding.png" alt="펀딩 방법 이미지">
                <div class="text">
                1. 펀딩 목록에서 참여하고 싶은 펀딩을 선택한다. <br>
                2. 원하는 리워드를 고르고 참여하기를 누른다. <br>
                3. 결제를 진행한다.<br>
                4. 마이페이지에서 내가 참여한 펀딩을 볼 수 있다. <br>
                </div>
            </div>

            <div class="btn-area">
                <a href="<%=path %>/view/funding">펀딩하러 가기</a>
            </div>

            <h2> 3 캠페인 참여하기</h2>
            <div class="img">
                <img src="/gibuAndTakePrj/resources/img/intro_campaign.png" alt="캠페인 참여 방법 이미지">
                <div class="text">
                1. 캠페인 목록에서 참여하고 싶은 캠페인을 선택한다. <br>
                2. 캠페인 소개를 읽는다. <br>
                3. 행동하기를 눌러 캠페인에 참여한다. <br>
                4. 마이페이지에서 내가 참여한 캠페인을 볼 수 있다.
                </div>
            </div>

            <div class="btn-area">
                <a href="<%=path %>/view/campaign">캠페인 참여하러 가기</a>
            </div> 
        </div>

    </div>

	<%@include file="/views/common/footer.jsp" %>
</body>
</html>