package com.gnt.funding.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.funding.service.FundingService;
import com.gnt.funding.vo.FundingVo;
import com.gnt.gibu.service.GibuService;
import com.gnt.gibu.vo.GibuVo;

@WebServlet(urlPatterns = "/view/funding/insert")
public class FundingInsertController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String path = req.getContextPath();
		//데이터 꺼내기
		//꺼낸데이터 뭉치기
		//3개 (작성자번호, 내용)
		String no = req.getParameter("writerNo");
		String regno = req.getParameter("regNo");
		String content = req.getParameter("comment_area");
		FundingVo vo = new FundingVo();
		vo.setMno(no);
		vo.setRegcontent(content);
		vo.setRegno(regno);
		
		//결과 = 서비스 호출
		int result = new FundingService().insertReply(vo);
		
		//결과에 따라, 화면 선택
		if(result ==1 ) {
			//성공 -> 공지사항 목록(alertMsg)
			req.getSession().setAttribute("alertMsg", "댓글 작성 완료!");
			resp.sendRedirect(path+"/view/funding_detail?type=0&num="+regno);
		}else {
			//실패 -> 에러페이지(errorMsg)
//			req.setAttribute("errorMsg", "댓글 작성 실패");
			RequestDispatcher view = req.getRequestDispatcher("/views/error/errorPage.jsp");
			view.forward(req, resp);
		}
	}
}
