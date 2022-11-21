<%@page import="com.gnt.campaign.vo.CampaignVo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	List<CampaignVo> list = (List<CampaignVo>)request.getAttribute("campaignvo"); 
	int campaigncnt = (Integer)request.getAttribute("campaigncnt");
	List<CampaignVo> banner = (List<CampaignVo>)request.getAttribute("campaignbannervo"); 
	
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
/*GLOBALS*/
* {
    margin: 0;
    padding: 0;
    list-style: none;
    box-sizing: border-box;
}


#slider-wrap {
    width: 80%;
    height: 400px;
    position: relative;
    overflow: hidden;
    margin: 0 auto;
    border-radius: 10px;
}

#slider-wrap ul#slider {
    height: 100%;
    position: absolute;
    top: 0;
    left: 0;
}

#slider-wrap ul#slider li {
    float: left;
    position: relative;
    width: 600px;
    height: 400px;
    
}

#slider-wrap ul#slider li>div {
    position: absolute;
    top: 20px;
    left: 35px;
}

#slider-wrap ul#slider li>div h3 {
    font-size: 36px;
    text-transform: uppercase;
}

#slider-wrap ul#slider li>div span {
    font-size: 21px;
}

#slider-wrap ul#slider li img {
    display: block;
    width: 100%;
    height: 100%;
}

/*btns*/
.slider-btns {
    position: absolute;
    width: 50px;
    height: 60px;
    top: 50%;
    margin-top: -25px;
    line-height: 57px;
    text-align: center;
    cursor: pointer;
    background: rgba(0, 0, 0, 0.1);
    z-index: 100;
    -webkit-transition: all 0.1s ease;
    -o-transition: all 0.1s ease;
    transition: all 0.1s ease;
}

.slider-btns:hover {
    background: rgba(0, 0, 0, 0.3);
}

#next {
    right: -50px;
    border-radius: 7px 0px 0px 7px;
    color: #eee;
}

#previous {
    left: -50px;
    border-radius: 0px 7px 7px 7px;
    color: #eee;
}

#slider-wrap.active #next {
    right: 0px;
}

#slider-wrap.active #previous {
    left: 0px;
}

/*bar*/
#slider-pagination-wrap {
    min-width: 20px;
    margin-top: 350px;
    margin-left: auto;
    margin-right: auto;
    height: 15px;
    position: relative;
    text-align: center;
}

#slider-pagination-wrap ul {
    width: 100%;
}

#slider-pagination-wrap ul li {
    margin: 0 4px;
    display: inline-block;
    width: 5px;
    height: 5px;
    border-radius: 50%;
    background: #fff;
    opacity: 0.5;
    position: relative;
    top: 0;
}

#slider-pagination-wrap ul li.active {
    width: 12px;
    height: 12px;
    top: 3px;
    opacity: 1;
    -webkit-box-shadow: rgba(0, 0, 0, 0.1) 1px 1px 0px;
    box-shadow: rgba(0, 0, 0, 0.1) 1px 1px 0px;
}

/*ANIMATION*/
#slider-wrap ul,
#slider-pagination-wrap ul li {
    -webkit-transition: all 0.3s cubic-bezier(1, .01, .32, 1);
    -o-transition: all 0.3s cubic-bezier(1, .01, .32, 1);
    transition: all 0.3s cubic-bezier(1, .01, .32, 1);
}

.container{
        margin: 0 10%;
        margin-top: 30px;
        height: auto;
    }
    .container>p {
        font-weight: 800;
        font-size: 30px;
    }
    
    .card:hover{
        text-decoration: none;
    }
    
    .card{
        float: left;
        width: 267px;
        height: 363px;
        border: 1px solid #83DDAD;
        margin: 30px 0 30px 30px;
        border-radius: 10px;
    }
    
    .card div{
        height: 50%;
    }
    .card div p{
        margin-top: 10px;
        font-size: 20px;
        font-weight: 700;
    }
    .card div pre{
        margin-top: 5px;
        font-size: 15px;
        font-weight: 700;
        text-align: center;
    }
    
    progress{
        width: 90%;
        margin-left: 5%;
        margin-right: 5%;
        height: 10px;
        -webkit-appearance: none;
    }
    progress::-webkit-progress-bar{
        background-color: #8bdcb1;
        border: 1px solid black;
    }
    progress::-webkit-progress-value{
        background-color: red;
    }
    .i_prog_percent{
        color: red;
        margin-left: 5%;
        font-weight: 500;
        font-size: 30px;
        margin-top: 5px;
        line-height: 100px;
    }
    .i_total_do{
        margin-right: 5%;
        float: right;
        margin-top: 5%;
        font-size: 20px;
        font-weight: 600;
        line-height: 100px;
    }
    .card img{
        width: 100%;
        height: 100%;
        border-radius: 10px;
    }
    #outer{
	width: 1200px;
	margin: 0 auto;
	
}

#titleNo{
	color: #83DDAD;
}
</style>
</head>
<body>
    <%@ include file="../common/header.jsp" %>
    <%@ include file="campaign_header.jsp" %>
	<div id="outer">
    <div id="slider-wrap">
        <ul id="slider">
        
        	<%for(CampaignVo c : banner){ %>
        
            <li>
                <div>
                	<a href="/gibuAndTakePrj/view/campaign_detail?num=<%= c.getRegno()%>">
                    <h3 style="color:white"><%= c.getRegname() %></h3>
                    <span style="color:white"><%= c.getMnick() %></span>
                </div>
                <img src="../resources/upload/<%= c.getImgsrc()%>">
                </a>
            </li>
    		<%} %>
            
        </ul>
    
        <div class="slider-btns" id="next"><span>▶</span></div>
        <div class="slider-btns" id="previous"><span>◀</span></div>
    
        <div id="slider-pagination-wrap">
            <ul>
            </ul>
        </div>
    </div>

    <div class="container">
      
        <p>진행중인 캠페인 <span id="titleNo"><%= campaigncnt %></span>개</p>
         
        <%for(CampaignVo c : list){ %>
         <a href="/gibuAndTakePrj/view/campaign_detail?num=<%=c.getRegno() %>" class="card">
             <div>
                 <img src="../resources/upload/<%= c.getImgsrc() %>">
             </div>
             <div>
                 <p align="center"><%= c.getRegname() %></p>
                 <pre><%= c.getMnick() %></pre>

                 <span class="i_prog_percent"><%= c.getMoneypercent() %>%</span>
                 <span class="i_total_do"><%= c.getCamppeople() %> 명 행동중</span>
             </div>
         </a>

       	<%} %>           
        

        
    </div>
    <br clear="both">
<script>
    //slide-wrap
var slideWrapper = document.getElementById('slider-wrap');
//current slideIndexition
var slideIndex = 0;
//items
var slides = document.querySelectorAll('#slider-wrap ul li');
//number of slides
var totalSlides = slides.length;
//get the slide width
var sliderWidth = slideWrapper.clientWidth;
//set width of items
slides.forEach(function (element) {
    element.style.width = sliderWidth + 'px';
})
//set width to be 'x' times the number of slides
var slider = document.querySelector('#slider-wrap ul#slider');
slider.style.width = sliderWidth * totalSlides + 'px';

// next, prev
var nextBtn = document.getElementById('next');
var prevBtn = document.getElementById('previous');
nextBtn.addEventListener('click', function () {
    plusSlides(1);
});
prevBtn.addEventListener('click', function () {
    plusSlides(-1);
});

// hover
slideWrapper.addEventListener('mouseover', function () {
    this.classList.add('active');
    clearInterval(autoSlider);
});
slideWrapper.addEventListener('mouseleave', function () {
    this.classList.remove('active');
    autoSlider = setInterval(function () {
        plusSlides(1);
    }, 3000);
});


function plusSlides(n) {
    showSlides(slideIndex += n);
}

function currentSlides(n) {
    showSlides(slideIndex = n);
}

function showSlides(n) {
    slideIndex = n;
    if (slideIndex == -1) {
        slideIndex = totalSlides - 1;
    } else if (slideIndex === totalSlides) {
        slideIndex = 0;
    }

    slider.style.left = -(sliderWidth * slideIndex) + 'px';
    pagination();
}

//pagination
slides.forEach(function () {
    var li = document.createElement('li');
    document.querySelector('#slider-pagination-wrap ul').appendChild(li);
})

function pagination() {
    var dots = document.querySelectorAll('#slider-pagination-wrap ul li');
    dots.forEach(function (element) {
        element.classList.remove('active');
    });
    dots[slideIndex].classList.add('active');
}

pagination();
var autoSlider = setInterval(function () {
    plusSlides(1);
}, 3000);
</script>

</div>
    <%@ include file="../common/footer.jsp" %>
</body>
</html>