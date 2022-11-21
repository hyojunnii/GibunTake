package com.gnt.corp.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.corp.service.corpService;
import com.gnt.corp.vo.corpVo;
import com.gnt.member.service.MemberService;
import com.gnt.member.vo.MemberVo;

@WebServlet(urlPatterns = "/corp/quit")
public class CorpQuit extends HttpServlet{
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		int no = ((corpVo)req.getSession().getAttribute("loginCorp")).getNo();
		
		int result = new corpService().quit(no);
		
		if(result == 1) {
			req.getSession().invalidate();
			req.getSession().setAttribute("alertMsg", "탈퇴 성공!");
			resp.sendRedirect("/gibuAndTakePrj");
		} else {
			req.getSession().setAttribute("alertMsg", "탈퇴 실패");
			resp.sendRedirect("/views/error/errorPage.jsp");
		}
		
	}
}

