package com.gnt.notice.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.managercategory.vo.CategoryVo;
import com.gnt.notice.service.NoticeService;
import com.gnt.notice.vo.NoticeVo;

@WebServlet(urlPatterns = "/notice/write")
public class NoticeWrite extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<CategoryVo> list = new NoticeService().selectCategoryList();
		req.setAttribute("list", list);
		
		req.getRequestDispatcher("/views/notice/noticeWrite.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.setCharacterEncoding("UTF-8");
		
		String no = req.getParameter("no");
		String cate = req.getParameter("cate");
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		NoticeVo vo = new NoticeVo();
		vo.setWriter(no);
		vo.setCate(cate);
		vo.setTitle(title);
		vo.setContent(content);
		
		int result = new NoticeService().writeNotice(vo);
		
		if(result == 1) {
			resp.sendRedirect("/gibuAndTakePrj/notice/list");
		}
		
	}
}

