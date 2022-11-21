package com.gnt.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.member.service.MemberService;
import com.gnt.member.vo.MemberVo;

@WebServlet(urlPatterns="/member/idSearch")
public class IdSearch extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/views/member/IdSearch.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		String email = req.getParameter("email");
		
		MemberVo vo = new MemberVo();
		
		vo.setName(name);
		vo.setEmail(email);

		//서비스 호출(객체)
		MemberVo searchId = new MemberService().idSearch(name, email);

		//실행결과에 따라 화면 선택
		if(searchId != null) {
			//성공 화면
			req.getSession().setAttribute("alertMsg", searchId.getId() + " 입니다.");
			resp.sendRedirect("/gibuAndTakePrj/views/member/login.jsp");
		}else {
			//로그인 실패
			req.setAttribute("errorMsg", "로그인 실패!");
			req.getRequestDispatcher("/gibuAndTakePrj/views/error/errorPage.jsp").forward(req, resp);
		}
	
	}
}
