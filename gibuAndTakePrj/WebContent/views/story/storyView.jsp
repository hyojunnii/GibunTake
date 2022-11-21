<%@page import="com.gnt.story.vo.StoryVo"%>
<%@page import="com.gnt.review.vo.ReviewVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <%
    List<ReviewVo> voList = (List<ReviewVo>)request.getAttribute("boardVoList");
	StoryVo storyVo = (StoryVo)request.getAttribute("storyVo");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<style>
    
    .green_bg{
        width: 100%;
        background-color: #14AE5C;
        color: white;
        margin-bottom: 30px;
        display: flex;
        justify-content: center;
        height: 200px;
        
    }

    .total_div{
        width: 1200px;
        display: flex;
        justify-content: center;
    }

    #graph_img{
        height: 200px;
    }

    .green_bg>div>table{
        color: white;
        font-size: 30px;
    }

    .total_div>table{
        display: flex;
        align-items: center;
    }

    .total_div>table tr{
        display: flex;
        justify-content: space-between;
        align-content: space-around;
        width: 600px;
        height: 65px;
        align-items: center;        
    }

    .total_div>table>tr td{
        margin-left: 50px;
        margin-right: 50px;

    }

    #recommend_review_wrap{
        width: 100%;
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    #recommend_review{
        display: flex;
        flex-direction: column;
        margin-top: 30px;
        width: 1200px;
        align-items: center;
        margin-bottom: 50px;
    }

    #recommend_review_title{
        font-size: 30px;
    }

    #recommend_review_body{
        width: 1164px;
        display : flex;
        justify-content: space-evenly;
        margin-top: 20px;
    }

    .review_card{
        width: 364px;
        height: 300px;
        text-align: center;
        border: 1px solid #e6e6e6;
        display: flex;
        flex-direction: column;
    }



    .review_card_corp{
        display: inline-block;
        margin: 29px auto 0;
        padding: 1px 10px 0;
        background-color: #fff;
        font-size: 15px;
        line-height: 27px;
        color: #9CCC65;
    }

    .review_card_title{
        height: 60px;
        line-height: 30px;
        margin: 19px 21px 0;
        font-size: 20px;
    }

    .review_card_img{
        width: 320px;
        height: 240px;
    }

    .review_card_text{
        height: 69px;
        line-height: 23px;
        margin: 19px 21px 0;
        font-size: 15px;
        text-align: left;
        color: #828282;
    }

    .review_view_more{
        width: 100%;
        margin: 0 0 24px 24px;
        height: 35px;
    }
    
</style>

</head>
<body>
<%@include file="/views/common/header.jsp" %>

<section>
    <div id="site_total" class="green_bg">
        <div class="total_div">
        <img src="/gibuAndTakePrj/resources/img/graph.png" alt="그래프" id="graph_img">
        <table>
            <tr>
                <td>누적 참여자</td>
                <td>${storyVo.totalCnt}명</td>
            </tr>
            <tr>
                <td>누적 참여금액</td>
                <td>${storyVo.totalMoney}원</td>
            </tr>
        </table>
        </div>
    </div>
    <div id="donate_day_total" class="green_bg">
        <div class="total_div">
        <table>
            <tr>
                <td>누적 기부 참여자</td>
                <td>${storyVo.totalDonateCnt}명</td>
            </tr>
            <tr>
                <td>누적 기부 참여금액</td>
                <td>${storyVo.totalDonateMoney}원</td>
            </tr>
        </table>
        </div>
    </div>
    <div id="funding_day_total" class="green_bg">
        <div class="total_div">
        <table>
            <tr>
                <td>누적 펀딩 참여자</td>
                <td>${storyVo.totalFundingCnt}명</td>
            </tr>
            <tr>
                <td>누적 펀딩 참여금액</td>
                <td>${storyVo.totalFundingMoney}원</td>
            </tr>
        </table>
        </div>
    </div>
    <div id="campaign_day_total" class="green_bg">
        <div class="total_div">
        <table>
            <tr>
                <td>누적 캠페인 참여자</td>
                <td>${storyVo.totalCampaignCnt}명</td>
            </tr>
        </table>
        </div>
    </div>
    <div id="recommend_review_wrap">
        <div id="recommend_review">
            <span id="recommend_review_title">함께한 기부들</span>
            <div id="recommend_review_body">

                <c:forEach items="${boardVoList}" var="b">
				<a href="${path}/campaign/review/view?id=${b.revNo}" class="review_card">
	                <span class="review_card_corp">${b.revName}</span>
	                <strong class="review_card_title">${b.revName}</strong>
	                <img src="${b.revImg}" alt="후기 썸네일" class="review_card_img">
	                <p class="review_card_text">${b.revContent}</p>
	            </a>
				</c:forEach>

                <a href="" class="review_card">
                    <span class="review_card_corp">기업이름</span>
                    <strong class="review_card_title">후기 제목</strong>
                    <img src="" alt="후기 썸네일" class="review_card_img">
                    <p class="review_card_text">후기 내용 ...</p>
                </a>

            </div>
        </div>
    </div>
</section>




<%@include file="/views/common/footer.jsp" %>
</body>
</html>