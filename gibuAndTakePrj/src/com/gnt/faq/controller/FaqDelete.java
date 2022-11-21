package com.gnt.faq.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.faq.service.FaqService;

@WebServlet(urlPatterns = "/faq/delete")
public class FaqDelete extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String num = req.getParameter("num");
		
		int result = new FaqService().delete(num);
		
		if(result == 1) {
			resp.sendRedirect("/gibuAndTakePrj/faq/list");
		}
	}
}
