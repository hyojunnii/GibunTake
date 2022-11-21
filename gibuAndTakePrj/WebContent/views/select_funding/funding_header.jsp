<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    *{
    margin: 0;
    padding: 0;
}
a{
    text-decoration: none;
    font-size: 25px;
    color: black;
}
.nav_tab:hover{
    background-color: #EBF5E0;
        color : #086C37;
        font-weight: 900;
}
li{
    list-style: none;
}

#funding_wrap{
    width: 500px;
    height: 50px;
    margin: 0 auto;
}


#funding_wrap ul li{
    float: left;
    width: 33.3%;
    height: 50px;
    line-height: 50px;
    text-align: center;
    background-color: white;
    
}

#gibu_wrap ul li a{
    display: block;
}
</style>
</head>
<body>

    
    <div id="funding_wrap">
        <ul>
            <li>
                <a class="nav_tab" href="/gibuAndTakePrj/view/funding">진행중인 펀딩</a>
            </li>
        </ul>
        <ul>
            <li>
                <a class="nav_tab" href="/gibuAndTakePrj/view/funding_done">만료된 펀딩</a>
            </li>
        </ul>
        <ul>
            <li>
                <a class="nav_tab" href="/gibuAndTakePrj/funding/review/list?p=1
                ">후기</a>
            </li>
        </ul>
    </div>

</body>
</html>