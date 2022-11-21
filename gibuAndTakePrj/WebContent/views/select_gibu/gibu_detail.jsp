<%@page import="javax.naming.Context"%>
<%@page import="com.gnt.common.ReplyVo"%>
<%@page import="java.util.List"%>
<%@page import="com.gnt.gibu.vo.GibuVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%
	GibuVo vo = (GibuVo)request.getSession().getAttribute("gibuvo");
	List<ReplyVo> list = (List<ReplyVo>)request.getAttribute("replyvo");
	request.setAttribute("vo", vo);

%>    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
    .gibu_btn_container:hover{
        color: black ;
    }

    #gibu_detail_container{
        margin: 0 10%;
        text-align: center;
    }
    
    #gibu_detail_container img{
        width: 60%;
        /* 이미지 높이 */
        height: 400px;
        border-radius: 10px;
    }

    #gibu_detail_container_div{
        width: 100%;
        margin: 0 auto;
    }

    .gibu_btn_container{ 
        font-size: 50px;
        text-decoration: none;
        color: black;
    }
    .gibu_btn_cover{
        width: 40%;
        margin: 30px auto;
        background-color: #b3e0c9;
        border-radius: 10px;
    }
   
    #total_money{
        font-weight: 600;
        font-size: 30px;
        margin-bottom: 0;
    }

    #plan_money{
        font-weight: 500;
        font-size: 20px;
        margin-top: 0;
    }
    #table_cover{
        width: 60%;
        margin: 0 20%;
    }
    .gibu_table {
    border-collapse: collapse;
    text-align: left;
    line-height: 1.5;

    }
    .gibu_table thead th {
        padding: 10px;
        font-weight: bold;
        vertical-align: top;
        color: #369;
        border-bottom: 3px solid #036;
    }
    .gibu_table tbody th {
        width: 150px;
        padding: 10px;
        font-weight: bold;
        vertical-align: top;
        border-bottom: 1px solid #72d09e;
        background: #f3f6f7;
        text-align: center;
    }
    .gibu_table td {
        width: 350px;
        padding: 10px;
        vertical-align: top;
        border-bottom: 1px solid #72d09e;
    }
    #title_table{
    width: 100%;
}

#outer{
	width: 1200px;
	margin: 0 auto;
	
}
    /* tab css*/
    /* .tabs{float:left; width:100%; height:290px; box-sizing: border-box;} */
/* .tabnav{font-size:40px; width:60%; box-sizing: border-box; margin: 0 auto;} */
.tabnav li{display: inline-block;  height:46px; text-align:center; border-right:1px solid #72d09e;}
/* .tabnav li a:before{content:""; position:absolute; left:0; top:0px; width:100%; height:3px; }
.tabnav li a.active:before{background:red;}
.tabnav li a.active{border-bottom:1px solid #72d09e;}
.tabnav li a{ position:relative; display:block; background: #f8f8f8; color: #000; padding:0 30px; line-height:46px; text-decoration:none; font-size:16px;}
.tabnav li a:hover,
.tabnav li a.active{background:#fff; color:#7ea21e; }
.tabcontent{padding: 20px; border:1px solid #72d09e; border-top:none; width: 100%;} */ 

#comments{
    width: 60%;
    margin: 0 auto;
}

#comments_table{
    width: 100%;
    margin: 0 auto;
}
#comments_img{
    width: 100%;
    height: 200px;
    border-radius: 10px;
}
.ingCnt{
    font-weight: 700;
    margin-top: 30px;
    font-size: 30px;
}
#title_table{
    width: 100%;
}
#outer{
	width: 1200px;
	margin: 0 auto;
	
}

#comment_input_table {
    width: 100%;
}

#comment_area{
    width: 110%;
    height: 100px;
    resize: none;
    margin-top: 0;
}
#comment_area_btn{
    height: 100px;
    width: 45%;
    margin-top: 0;
    background-color: #8bdcb1;
    border: none;
    border-radius: 15px;
}
.gibu_btn_container{
	width: 100%;
	height: 100%;
	background-color: #8bdcb1;
    border: none;
    border-radius: 15px;
}
.reviw_container{
	height: 30px;
	 width: 40%;
	background-color: #8bdcb1;
    border: none;
    border-radius: 10px;
}
</style>
    <!-- Latest compiled and minified CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" />
    <!-- Latest compiled JavaScript -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    
	
</head>
<body>
    <%@ include file="../common/header.jsp" %>

	<div id="outer">
    <div id="gibu_detail_container">
        <table id="title_table">
            <tr>	
            		<td width="20%"></td>
	                <td colspan="3" width="60%" style="padding-top: 20px"><h1><%=vo.getRegname() %></h1></td>
	                <td width="20%">
           		<c:if test="${empty loginMember && empty loginCorp}">
	                </td>
              	</c:if>
	            <c:if test="${loginCorp.no eq gibuvo.mno}">
	             <a href="<%=path%>/pm/edit/donation" class="btn">수정하기</a>
	             </td>
	          </c:if>
            </tr>
        </table>
            <p class="comName">By <%=vo.getMnick() %></p>
            <img src="../resources/upload/<%= vo.getImgsrc() %>">
        <div id="gibu_detail_container_div">
            <p style="padding-top: 10px">
                <%= vo.getRegcontent() %>
            </p>
                <h2 style="padding-top: 10px">사업대상</h2>
            <div id="table_cover" style="padding-top: 10px">
                <table class="gibu_table">
                    <tbody>
                    <tr>
                        <th>기업이름</th>
                        <td><%=vo.getMnick() %></td>
                    </tr>
                    <tr>
                        <th>종료기간</th>
                        <td>~ <%= vo.getRegfdate() %></td>
                    </tr>
                    <tr>
                        <th>사업대상</th>
                        <td><%= vo.getDperson() %></td>
                    </tr>
                    </tbody>
                </table>
            </div>

            	<form action="<%=path %>/donate/pay" method="get">
            		<div class="gibu_btn_cover">
            			<input type="hidden" name="num" value="<%= vo.getRegno()%>">
                		<button type="submit"  class="gibu_btn_container">
	                    	<div>
	                       		기부하기
	                    	</div>
                		</button>
            		</div>
                </form>
                
            <p id="total_money">
                <%= vo.getDpmoney() %> 원
            </p>
            <p id="plan_money">
               목표금액 : <%= vo.getDgmoney() %> 원
            </p>
            
           <c:if test="${loginCorp.no eq gibuvo.mno}">
            <form action="<%=path %>/review/create" method="get">
            	<input type="hidden" name="regNo" value="<%=vo.getRegno()%>">
            	<input type="hidden" name="category" value="<%=vo.getRegclass()%>">
            	<button type="submit" class="reviw_container">후기 등록</button>
            </form>
            </c:if>
        </div>
    </div>
    </div>
    <br>
    <br>
    <div id="tabs"> <!-- A -->
        <h1 align="center">댓글</h1>
        <div class="tabcontent">
         
          <div id="comments">
          	
          	
          	
          	
          	<c:forEach var="rp" items="${replyvo}">
          	<form action="/gibuAndTakePrj/view/gibuDetail/edit" method="get">
          	<input type="hidden" name=num value="${rp.repno }">
	            <table id="comments_table">
	                <tr>
	                	<td hidden id="comments_num"> ${rp.repno} </td>
	                    <td id="comments_name" width="30%"> ${rp.mnick}</td>
	                    <td id="comments_date" align="right" width="50%">${rp.repmod}</td>
	                    <td align="right" width="20%">
	                    <c:if test="${loginMember.no == rp.mno}">
	                        <button type="submit" value="수정" class="btn" formaction='/gibuAndTakePrj/view/gibuDetail/edit?'>수정</button>
	                        <button type="submit" value="삭제" class="btn" formaction='/gibuAndTakePrj/view/gibuDetail/del?'>삭제</button>
	                 	</c:if>
	                        <button type="submit" value="신고" class="btn" formaction='/gibuAndTakePrj/view/gibuDetail/ban?'>신고</button>
	                    </td>
	                </tr>
	                <tr>
	                    <td colspan="5" id="comments_content">${rp.repcontent}</td>
	                </tr>
	            </table>
	            <hr>
	            </form>
			</c:forEach>
            

			<c:if test="${!empty loginMember }">
	            <!-- 댓글 -->
	            <form action="/gibuAndTakePrj/view/gibu/insert" method="get">
	            		<input type="hidden" name="writerNo" value="<%= memberVo.getNo()%>">
	            		<input type="hidden" name="regNo" value="<%= vo.getRegno() %>">
	                <table id="comment_input_table">
	                    <br>
	                   <tr>
	                    <td align="left">
	                        <textarea name="comment_area" id="comment_area" rows="5" placeholder="내용을 적어주세요"></textarea>
	                    </td>
	                    <td align="right">
	                        <input id="comment_area_btn" type="submit" value="등록하기">
	                    </td>
	                   </tr> 
	                </table>
			   	</form>
			</c:if>

          </div>

          
          
        </div>
      </div>
    <%@ include file="../common/footer.jsp" %>
   
   
</body>
</html>