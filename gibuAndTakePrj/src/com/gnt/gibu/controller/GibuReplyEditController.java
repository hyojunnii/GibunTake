package com.gnt.gibu.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.common.ReplyVo;
import com.gnt.gibu.service.GibuService;

@WebServlet(urlPatterns = "/view/gibuDetail/edit")
public class GibuReplyEditController extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num = req.getParameter("num");
		
		
		ReplyVo vo = new GibuService().GibuEdit(num);
		
		if(vo != null) {
			req.setAttribute("vo", vo);
			req.getRequestDispatcher("/views/reply/gibuReplyEdit.jsp").forward(req, resp);
		}else {
			RequestDispatcher view = req.getRequestDispatcher("/views/error/errorPage.jsp");
			view.forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String mno = req.getParameter("mno");
		String regno = req.getParameter("regno");
		String repno = req.getParameter("repno");
		String commentArea = req.getParameter("comment_area");


		
		
		ReplyVo vo = new ReplyVo();
		vo.setMno(mno);
		vo.setRegno(regno);
		vo.setRepno(repno);
		vo.setRepcontent(commentArea);
		//호출
		System.out.println(vo.getMno());
		System.out.println(vo.getRegno());
		System.out.println(vo.getRepno());
		System.out.println(vo.getRepcontent());
		int result = new GibuService().Edit(vo);
		System.out.println(result);
		//결과에 따라 화면 선택
		if(result == 1) {
			//성공
			req.getSession().setAttribute("alertMsg", "댓글 수정 완료!");
			resp.sendRedirect(req.getContextPath()+ "/view/gibu_detail?type=0&num="+vo.getRegno());
		}else {
			//실패
//			req.setAttribute("errorMsg", "공지사항 수정 실패...");
			req.getRequestDispatcher("/views/error/errorPage.jsp").forward(req, resp);
		}
	}
}
