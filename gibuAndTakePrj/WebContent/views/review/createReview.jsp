<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%
	String category = (String)request.getAttribute("category");    
	String regNo = (String)request.getAttribute("regNo");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>기부앤테이크</title>

<link href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" rel="stylesheet">
<script src="https://code.jquery.com/jquery-3.5.1.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>


<link href="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/summernote@0.8.18/dist/summernote.min.js"></script>


<style>
    *{
        box-sizing: border-box;
    }
    


    .review_create_header{
        width: 100%;
        background-image: url();
        background-color: rgba(0, 0, 0, 0.5);
        display: flex;
        justify-content: center;
        flex-direction: column;
        align-items: center;
        height: 376px;
    }

    .review_create_header *{
        color: white;
    }

    .review_create_header input{
        background-color: rgba(255, 255, 255, 0);;
        border: 1px solid white;
    }

    .review_header_title{
        font-size: 40px;
    }

    .review_header_title::placeholder{
        color: white;
    }

    .review_header_corp{
        opacity: 0.6;
    }

    #review_body_content{
        width: 1164px;
        margin: 0 auto;
        display: flex;
        justify-content: center;
        align-items: center;
        text-align: center;
    }



    #review_create_footer_btn{
        display: flex;
        align-items: flex-end;
        justify-content: flex-end;
    }

    .review_create_btn{
        height: 30px;
        background-color: #E4F4D2;
        border-color: #e6e6e6;
        border-radius: 15px;
        outline: none;
        box-shadow: none;
        
    }

    .note-editable{
        width: 1000px;
        height: 500px;
    }




</style>

</head>
<body>
<%@include file="/views/common/header.jsp" %>

    <section>
        <form id="review-form" action="${path}/review/create" method="post" enctype="multipart/form-data">
        <input name="category" type="hidden" value="${category}">
        <input name="regNo" type="hidden" value="${regNo}">
        <div id="review_create_wrap">
            <div class="review_create_header">
                <label for="review_header_img_btn">상단배경선택</label>
                <input type="file" id="review_header_img_btn" name="f">
                <input type="text" class="review_header_title" placeholder="후기제목" name="title"></input>
            </div>
            <div id="review_body_content">
                <textarea id="content" name="editordata" class="note-editable"></textarea>
            </div>
            <div id="review_create_footer_btn">
                <input type="submit" value="작성하기" class="review_create_btn">
                <input type="button" value="뒤로가기" class="review_create_btn" onclick="history.go(-1)"> 
            </div>
        </div>
        </form>
    </section>

<%@include file="/views/common/footer.jsp" %>

<script>
	
</script>


</body>
</html>