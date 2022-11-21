<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>소개:기부앤테이크?</title>
<style>

    #body {
        width: 1200px;
        margin: 0 auto;
    }

    #category {
        margin: 50px;
    }

    #account {
        margin: 30px auto;
        width: 700px;
        height: 250px;
        border: 2px solid #8bdcb1;
        border-radius: 15px;
        display: flex;
    }

    #account a {
        text-align: right;
    }

    #text {
        width: 300px;
        float: right;
        text-align: center;
        margin: auto;
        margin-top: 50px;
    }

    #text a {
        color: #2E6C4A;
        font-weight: bolder;
        font-size: 25px;
    }

    .big, .small{
        margin: auto;
        width: 700px;
    }

    .big {
        color: #2e6c4a;
        background-color: #EBF5E0;
        font-size: 20px;
        font-weight: bold;
        margin-top: 20px;
    }

    .small {
        font-size: 15px;
        padding: 10px;
        text-indent: 1em;
    }

    #img1{
        padding: 10px;
        width: 350px;
        border-radius: 20px;
        object-fit: cover;
    }

    #img2 {
        width: 800px;
        height: auto;
        display: block;
        margin: auto;
    }

    #what {
        background-color: #EBF5E0;
        color: #2e6c4a;
        font-weight: bold;
        border-radius: 15px;
    }

</style>
</head>
<body>

    <%@include file="/views/introduce/introduceHead.jsp" %>

    <div id="body">

        <div id="category">
            <a>'기부 앤 테이크'는 어떤 곳인가요?</a>
        </div>
    
        <div id="account">
           <div id="img-area">
                <img src="/gibuAndTakePrj/resources/img/do-not-use-this-image-g43f0f0b51_640.jpg" alt="" id="img1">
           </div>
            <div id="text">
                <a>기부 참여 실천</a>
                <p>다양한 사람들의 기부를 격려하고<br>
                기부에 대한 진입 장벽을 낮춰<br>
                기부에 관한 인식을 바꾸기 위한<br>
                선한 영향력을 추구하는 사이트<br>
                </p>
            </div>
        </div>
        
        <div class="big">
            '코로나19' 앞에서 휘청한 기부 단체
        </div>
        <div class="small">
            코로나19 팬데믹은 소규모 단체들에게 직격탄이 됐다. <br>
        </div>
        <div class="small">
            공익경영센터 비영리거버넌스연구소가 지난 해 5월 비영리단체를 대상으로 진행한
            '코로나19 사태가 미친 영향과 대책' 설문조사에 따르면 조사 대상의 90.6%가 
            연간 계획 대비 사업 활동이 위축됐다고 응답했다. 재정수입이 감소했다는 단체는 61.5%였다.
        </div>
        <div class="small">
            대형 단체들은 코로나19 팬데믹 상황에서도 이미 갖춰놓고 있는 비대면 플랫폼을 통해 기부캠페인을 진행한 반면, 오프라인 기부 캠페인에 주력하던 소규모 단체들은 캠페인을 벌일 기회조차 얻지 못했다는게 기부단체들의 설명이다.
        </div>
        <div class="big">
            기부에 대한 접근성
        </div>
        <div class="small">
            다양한 기부단체의 활동들을 한눈에 모아보며 일반인들을 대상으로 모금 활동을 진행하고, 
            자금이 부족하거나 없는 사람들이 프로젝트를 인터넷에 공개하고 목표 금액과 모금 기간을 정하여 익명의 다수(crowd)로부터 투자를 받는 행위 들을 보다 쉽게 접근하고자 한다.
        </div>
        <div class="big">
            기부에 대한 인식 변화
        </div>
        <div class="small">
            캠페인에 참여하는것도 자신의 행동을 기부하는것이라고 생각하여 캠페인도 개설 및 참가를 할 수 있도록 제작하였습니다.
        </div>
    
        <img src="/gibuAndTakePrj/resources/img/history.png" alt="" id="img2">

    </div>

    <%@include file="/views/common/footer.jsp" %>
</body>
</html>