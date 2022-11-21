package com.gnt.member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gnt.member.service.MemberService;
import com.gnt.member.vo.MemberVo;

@WebServlet(urlPatterns="/member/pwdSearch")
public class PwdSearch extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.getRequestDispatcher("/views/member/PwdSearch.jsp").forward(req, resp);
		
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setCharacterEncoding("UTF-8");
		
		String id = req.getParameter("id");
		String email = req.getParameter("email");
		
		MemberVo vo = new MemberVo();
		
		vo.setId(id);
		vo.setEmail(email);

		//서비스 호출(객체)
		MemberVo searchPwd = new MemberService().pwdSearch(id, email);

		//실행결과에 따라 화면 선택
		if(searchPwd != null) {
			//성공 화면
			req.getSession().setAttribute("alertMsg", searchPwd.getPwd() + " 입니다.");
			resp.sendRedirect("/gibuAndTakePrj/views/member/login.jsp");
		}else {
			//로그인 실패
			req.setAttribute("errorMsg", "로그인 실패!");
			req.getRequestDispatcher("/gibuAndTakePrj/views/error/errorPage.jsp").forward(req, resp);
		}
	
	}
}
