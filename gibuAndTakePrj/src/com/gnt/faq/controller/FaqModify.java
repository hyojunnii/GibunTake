package com.gnt.faq.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.faq.service.FaqService;
import com.gnt.faq.vo.CategoryVo;
import com.gnt.faq.vo.FaqVo;

@WebServlet(urlPatterns = "/faq/modify")
public class FaqModify extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String num = req.getParameter("num");
		
		FaqVo vo = new FaqService().selectNum(num);
		
		
		
		if(vo != null) {
			req.setAttribute("vo", vo);
			
			req.getRequestDispatcher("/views/FAQ/faqModify.jsp").forward(req, resp);
		}
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String cate = req.getParameter("cate");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String num = req.getParameter("num");
		
		FaqVo vo = new FaqVo();
		vo.setCate(cate);
		vo.setTitle(title);
		vo.setContent(content);
		vo.setNo(num);
		
		int result = new FaqService().modify(vo);
		
		if(result == 1) {
			resp.sendRedirect("/gibuAndTakePrj/faq/list?num=" + num);
		}
	}
}
