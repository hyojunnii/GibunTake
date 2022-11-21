package com.gnt.manager.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.manager.service.ManagerService;
import com.gnt.manager.vo.ManagerVo;

@WebServlet(urlPatterns = "/manager/login")
public class ManagerLogin extends HttpServlet{
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/views/manager/login.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = req.getParameter("memberId");
		String pwd = req.getParameter("memberPwd");
		
		ManagerVo vo = new ManagerVo();
		vo.setId(id);
		vo.setPwd(pwd);
		
		ManagerVo loginMember = new ManagerService().login(vo);
		
		if(loginMember != null) {
			req.getSession().setAttribute("loginMember", loginMember);
			resp.sendRedirect("/gibuAndTakePrj/manager/list");
		}else {
			req.getRequestDispatcher("/views/manager/login.jsp").forward(req, resp);
		}
		
	}
	
}
