package com.gnt.faq.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.faq.service.FaqService;
import com.gnt.faq.vo.CategoryVo;
import com.gnt.faq.vo.FaqVo;

@WebServlet(urlPatterns = "/faq/write1")
public class faqWrite extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryVo> list = new FaqService().selectCategoryList();
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/views/FAQ/faqWrite.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String no = req.getParameter("no");
		String cate = req.getParameter("cate");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		FaqVo vo = new FaqVo();
		vo.setWriter(no);
		vo.setCate(cate);
		vo.setTitle(title);
		vo.setContent(content);
		
		int result = new FaqService().writeFaq(vo);
		
		if(result == 1) {
			resp.sendRedirect("/gibuAndTakePrj/faq/list");
		}
	}
}
