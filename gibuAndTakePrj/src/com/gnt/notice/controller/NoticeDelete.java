package com.gnt.notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.notice.service.NoticeService;

@WebServlet(urlPatterns = "/notice/delete")
public class NoticeDelete extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num = req.getParameter("num");
		
		int result = new NoticeService().delete(num);
		
		if(result == 1) {
			resp.sendRedirect("/gibuAndTakePrj/notice/list");
		}
		
	}
}
