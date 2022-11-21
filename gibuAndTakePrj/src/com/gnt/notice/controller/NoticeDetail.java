package com.gnt.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.notice.service.NoticeService;
import com.gnt.notice.vo.NoticeVo;

@WebServlet(urlPatterns = "/notice/detail")
public class NoticeDetail extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String num = req.getParameter("num");
		
		int result = new NoticeService().increaseNotice(num);
		
		if(result == 1) {
			NoticeVo vo = new NoticeService().selectNum(num);
			
			if(vo != null) {
				req.setAttribute("vo", vo);
				req.getRequestDispatcher("/views/notice/noticeDetail.jsp").forward(req, resp);
			}
		
		}
		
	}
}
