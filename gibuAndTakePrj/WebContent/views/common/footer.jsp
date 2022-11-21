<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Gibu n Take</title>
<link rel="shortcut icon" type="image/x-icon" href="../resources/img/free-icon-giving-5017478.png" />
<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=IBM+Plex+Sans+KR&display=swap" rel="stylesheet">

<style>
    *{
        font-family: 'IBM Plex Sans KR', sans-serif;
        
    }

    #site_footer{
        width: 100%;
        display: flex;
        flex-direction: column;
        align-items: center;
    }

    #site_footer a{
    	text-decoration: none;
    	color: black;
    }

    #site_footer>div{
        padding-left: 30px;
    }

    #notice{
        border-bottom: 1px solid #0C8243;
        font-size: 27px;
        padding-bottom: 10px;
        padding-top: 10px;
        width: 100%;
        display: flex;
        flex-direction: column;
        align-items: center;
        
    }
    
    #notice>span{
    	width : 1200px;        
    }
    
    #go_notice {
    	font-size: 24px;
    }

    #go_notice_title{
        font-size: 20px;
        color: rgba(0, 0, 0, 0.74);
    }

    #margin_colored{
        width: 100%;
        height: 10px;
        background-color: #83DDAD;
        margin: 0;
    }

    #footer_mini_text{
        font-size: smaller;
        color: rgb(92, 92, 92);
    }

    #footer_site_name{
        font-size: 27px;
        color: #086C37;
        margin-right: 5px;
    }

    #footer_else_menu{
        
    }
    
    #footer_else_menu>a{
        margin-left: 15px;
        margin-right: 15px;
        font-size: 18px;
    }
    
    #footer_else{
    	width: 1200px;
    }

    #footer_else>span{
    	display: flex;
        align-items: center;
        justify-content: space-between;
    }



</style>

</head>
<body>

	<footer id="site_footer">
        <div id="margin_colored">

        </div>
        <div id="notice">
            <span>
                <a href="/gibuAndTakePrj/notice/list" id="go_notice">공지사항</a>
                <a href="/gibuAndTakePrj/notice/list" id="go_notice_title">공지사항 내용</a>
            </span>
        </div>
        <div>
            <div id="footer_else">
                <span>
                    <span id="footer_else_site_name">
                        <span id="footer_site_name">기부 앤 테이크</span>
                        <span id="footer_mini_text">Bul4Zo0826@gmail.com</span>
                    </span>
                    <span id="footer_else_menu">
                        <a href="/gibuAndTakePrj/qa/list">문의하기</a>
                        <a href="/gibuAndTakePrj/faq/list">FAQ</a>
                        <a href="">개인정보 처리방침</a>
                        <a href="">이용약관</a>
                        <a href="https://www.mois.go.kr/frt/a01/frtMain.do">공익제보(행정안전부)</a>
                    </span>
                </span>
            </div>
            <div id = "footer_mini_text">
                <div class="text_mini">(주)기부 앤 테이크와 (팀)불사조는 기부, 펀딩, 캠페인 프로젝트의 당사자가 아닙니다. 프로젝트 진행 및 거래 등에 대한 책임은 해당 프로젝트의 개설자에게 있습니다.</div>
                <divclass="text_mini">Copyright © Bul4Zo Team. All Rights Reserved.</div>
            </div>
        </div>

    </footer>
</body>
</html>