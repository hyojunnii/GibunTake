<%@page import="com.gnt.review.vo.ReviewPageVo"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.gnt.review.vo.ReviewVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	String category = (String)request.getAttribute("category");    

	List<ReviewVo> voList = (ArrayList<ReviewVo>)request.getAttribute("boardVoList");
	ReviewPageVo pageVo = (ReviewPageVo)request.getAttribute("PageVo");
	
	int currentPage = pageVo.getCurrentPage();
	int startPage = pageVo.getStartPage();
	int endPage = pageVo.getEndPage();
	int maxPage = pageVo.getMaxPage();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기부앤테이크</title>

<style>

    section{
        display: flex;
        justify-content: center;
	    flex-direction: column;
	    align-items: center;
    }
    
    a{
		text-decoration: none;	
	}


    *{
        box-sizing: border-box;
    }

    #review_card_wrap{
        width: 1164px;
        clear: both;
    }
    
    #review_card_wrap::after{
        content:'';
		display:block;
		clear:both;
    }

    .review_card{
        float: left;
        position: relative;
        width: 364px;
        height: 522px;
        margin: 0 0 24px 24px;
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
        margin-left: 21px;
        margin-right: 21px; 
    }

    .review_card_text{
        height: 69px;
        line-height: 23px;
        margin: 19px 21px 0;
        font-size: 15px;
        text-align: left;
        color: #828282;
    }

    #review_view_more{
        width: 100%;
        margin: 24px auto;
        height: 35px;
        display: flex;
    	justify-content: center;
    }

    #create_review{
        width: 100%;
        height: 30px;
        margin: 7px 0 7px 0;
        display: flex;
        flex-direction: column;
        align-items: center;
        
    }

    .review_btn{
        height: 30px;
        background-color: #E4F4D2;
        border-color: #e6e6e6;
        border-radius: 10px;
        outline: none;
        box-shadow: none;
        text-decoration: none;
        color: black;
    }

    #create_review>div{
        width: 1164px;
        display: flex;
        justify-content: flex-end;
    }

</style>

</head>
<body>
<%@include file="/views/common/header.jsp" %>

    <div id="create_review">
    </div> 

	<section>
        <div id="review_card_wrap">
        
        	<c:forEach items="${boardVoList}" var="b">
				<a href="${path}/donate/review/view?id=${b.revNo}" class="review_card">
	                <span class="review_card_corp">${b.revName}</span>
	                <strong class="review_card_title">${b.revName}</strong>
	                <img src="${b.revImg}" alt="후기 썸네일" class="review_card_img">
	                <p class="review_card_text">${b.revContent}</p>
	            </a>
			</c:forEach>
			

        </div>
        
        <div id="review_view_more">
            <%if(startPage!=1){%>
				<a href="<%=path%>/donate/review/list?p=<%=startPage-1%>" class="review_btn">&lt;&lt;</a>
				<%} %>
				<%for(int i = startPage; i<=endPage; i++){ %>
					<% if(i==currentPage){ %>
						<Strong class="review_btn"><%=i %></Strong>
					<%}else{%>
					<a href="<%=path%>/donate/review/list?p=<%=i%>" class="review_btn"><%=i %></a>
					<%} %>
				<%} %>
				<%if(endPage!=maxPage){%>
				<a href="<%=path%>/donate/review/list?p=<%=endPage+1%>" class="review_btn">&gt;&gt;</a>
			<%} %>
		</div>

    </section>


<%@include file="/views/common/footer.jsp" %>
</body>
</html>